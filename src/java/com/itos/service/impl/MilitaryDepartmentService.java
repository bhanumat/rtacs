/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMilitaryDepartmentDAO;
import com.itos.model.MilitaryDepartment;
import com.itos.service.model.IMilitaryDepartmentService;
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
@Service("iMilitaryDepartmentService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class MilitaryDepartmentService implements IMilitaryDepartmentService {

    public MilitaryDepartmentService() {

    }

    @Autowired
    IMilitaryDepartmentDAO iMilitaryDepartmentDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MilitaryDepartment> getListMilitaryDepartment(JqGridRequest req) {
        JqGridResponse<MilitaryDepartment> response = new JqGridResponse<>();
        response = iMilitaryDepartmentDAO.getList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteMilitaryDepartment(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iMilitaryDepartmentDAO.setDeleteMilitaryDepartment(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewMilitaryDepartment(MilitaryDepartment militaryDepartment) {
        MessageResponse response = new MessageResponse();

        //MilitaryDepartment.setCreateDate(DateUtil.getCurrentDate());
        //MilitaryDepartment.setUpdateDate(DateUtil.getCurrentDate());
        response = iMilitaryDepartmentDAO.setSaveNewMilitaryDepartment(militaryDepartment);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditMilitaryDepartment(MilitaryDepartment militaryDepartment) {
        MessageResponse response = new MessageResponse();

        //MilitaryDepartment.setUpdateDate(DateUtil.getCurrentDate());
        response = iMilitaryDepartmentDAO.setSaveEditMilitaryDepartment(militaryDepartment);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public MilitaryDepartment getLoadMilitaryDepartment(MilitaryDepartment militaryDepartment) {
        MilitaryDepartment response = new MilitaryDepartment();
        response = iMilitaryDepartmentDAO.getLoadMilitaryDepartment(militaryDepartment);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<MilitaryDepartment> getListInJSONMilitaryDepartment(char status) {
        List<MilitaryDepartment> response = new ArrayList<>();
        response = iMilitaryDepartmentDAO.getListInJSONMilitaryDepartment(status);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<MilitaryDepartment> getMilitaryDepartments(char status) {
        return iMilitaryDepartmentDAO.getMilitaryDepartments(status);
    }

}
