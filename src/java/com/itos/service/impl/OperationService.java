/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IOperationDAO;
import com.itos.model.Operation;
import com.itos.service.model.IOperationService;
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
@Service("iOperationService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class OperationService implements IOperationService {

    public OperationService() {

    }

    @Autowired
    IOperationDAO iOperationDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<Operation> getListOperation(JqGridRequest req) {
        JqGridResponse<Operation> response = new JqGridResponse<>();
        response = iOperationDAO.getList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteOperation(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iOperationDAO.setDeleteOperation(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public Operation saveNewOperation(Operation operation) {
        Operation response = new Operation();

        operation.setCreateDate(DateUtil.getCurrentDate());
        
        response = iOperationDAO.saveNewOperation(operation);
        return response;
    }
    
        @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewOperation(Operation operation) {
        MessageResponse response = new MessageResponse();
        response = iOperationDAO.setSaveNewOperation(operation);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditOperation(Operation operation) {
        MessageResponse response = new MessageResponse();

        response = iOperationDAO.setSaveEditOperation(operation);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public Operation getLoadOperation(Operation operation) {
        Operation response = new Operation();
        response = iOperationDAO.getLoadOperation(operation);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<Operation> getListInJSONOperation(char status) {
        List<Operation> response = new ArrayList<>();
        response = iOperationDAO.getListInJSONOperation(status);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewOperationList(Operation operation) {
        MessageResponse response = new MessageResponse();
        response = iOperationDAO.setSaveNewOperationList(operation);
        return response;
    }

}
