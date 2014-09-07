/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IProvinceDAO;
import com.itos.model.Province;
import com.itos.service.model.IProvinceService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ITOS
 */
@Service("iProvinceService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class ProvinceService implements IProvinceService {

    public ProvinceService() {

    }

    @Autowired
    IProvinceDAO iProvinceDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<Province> getListProvince(JqGridRequest req) {
        JqGridResponse<Province> response = new JqGridResponse<>();
        response = iProvinceDAO.getList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteProvince(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iProvinceDAO.setDeleteProvince(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewProvince(Province province) {
        MessageResponse response = new MessageResponse();

        province.setCreateDate(DateUtil.getCurrentDate());
        province.setUpdateDate(DateUtil.getCurrentDate());

        response = iProvinceDAO.setSaveNewProvince(province);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditProvince(Province province) {
        MessageResponse response = new MessageResponse();

        province.setUpdateDate(DateUtil.getCurrentDate());

        response = iProvinceDAO.setSaveEditProvince(province);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public Province getLoadProvince(Province province) {
        Province response = new Province();
        response = iProvinceDAO.getLoadProvince(province);
        return response;
    }

    
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<Province> getListInJSONProvince(char status) {
        List<Province> response = new ArrayList<>();
        response = iProvinceDAO.getListInJSONProvince(status);
        return response;
    }

}
