/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.ITitleDAO;
import com.itos.model.Title;
import com.itos.service.model.ITitleService;
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
@Service("iTitleService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class TitleService implements ITitleService {

    public TitleService() {

    }

    @Autowired
    ITitleDAO iTitleDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<Title> getListTitle(JqGridRequest req) {
        JqGridResponse<Title> response = new JqGridResponse<>();
        response = iTitleDAO.getList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteTitle(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iTitleDAO.setDeleteTitle(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewTitle(Title title) {
        MessageResponse response = new MessageResponse();

        title.setCreateDate(DateUtil.getCurrentDate());
        title.setUpdateDate(DateUtil.getCurrentDate());

        response = iTitleDAO.setSaveNewTitle(title);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditTitle(Title title) {
        MessageResponse response = new MessageResponse();

        title.setUpdateDate(DateUtil.getCurrentDate());

        response = iTitleDAO.setSaveEditTitle(title);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public Title getLoadTitle(Title title) {
        Title response = new Title();
        response = iTitleDAO.getLoadTitle(title);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<Title> getListInJSONTitle(char status) {
        List<Title> response = new ArrayList<>();
        response = iTitleDAO.getListInJSONTitle(status);
        return response;
    }

}
