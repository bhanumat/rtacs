/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IBankAccountTypeDAO;
import com.itos.model.BankAccountType;
import com.itos.service.model.IBankAccountTypeService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ITOS
 */
@Service("iBankAccountTypeService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class BankAccountTypeService implements IBankAccountTypeService {

    public BankAccountTypeService() {

    }

    @Autowired
    IBankAccountTypeDAO iBankAccountTypeDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<BankAccountType> getListBankAccountType(JqGridRequest req) {
        JqGridResponse<BankAccountType> response = new JqGridResponse<>();
        response = iBankAccountTypeDAO.getList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteBankAccountType(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iBankAccountTypeDAO.setDeleteBankAccountType(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewBankAccountType(BankAccountType bankAccountType) {
        MessageResponse response = new MessageResponse();

        bankAccountType.setCreateDate(DateUtil.getCurrentDate());
        bankAccountType.setUpdateDate(DateUtil.getCurrentDate());

        response = iBankAccountTypeDAO.setSaveNewBankAccountType(bankAccountType);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditBankAccountType(BankAccountType bankAccountType) {
        MessageResponse response = new MessageResponse();

        bankAccountType.setUpdateDate(DateUtil.getCurrentDate());

        response = iBankAccountTypeDAO.setSaveEditBankAccountType(bankAccountType);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public BankAccountType getLoadBankAccountType(BankAccountType bankAccountType) {
        BankAccountType response = new BankAccountType();
        response = iBankAccountTypeDAO.getLoadBankAccountType(bankAccountType);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<BankAccountType> getListInJSONBankAccountType(char status){
        List<BankAccountType> response = new ArrayList<>();
        response = iBankAccountTypeDAO.getListInJSONBankAccountType(status);
        return response;
    }

}
