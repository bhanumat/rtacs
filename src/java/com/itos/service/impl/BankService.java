/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IBankDAO;
import com.itos.model.Bank;
import com.itos.service.model.IBankService;
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
@Service("iBankService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class BankService implements IBankService {

    public BankService() {

    }

    @Autowired
    IBankDAO iBankDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<Bank> getListBank(JqGridRequest req) {
        JqGridResponse<Bank> response = new JqGridResponse<>();
        response = iBankDAO.getList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteBank(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iBankDAO.setDeleteBank(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewBank(Bank bank) {
        MessageResponse response = new MessageResponse();

        bank.setCreateDate(DateUtil.getCurrentDate());
        bank.setUpdateDate(DateUtil.getCurrentDate());

        response = iBankDAO.setSaveNewBank(bank);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditBank(Bank bank) {
        MessageResponse response = new MessageResponse();

        bank.setUpdateDate(DateUtil.getCurrentDate());

        response = iBankDAO.setSaveEditBank(bank);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public Bank getLoadBank(Bank bank) {
        Bank response = new Bank();
        response = iBankDAO.getLoadBank(bank);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<Bank> getListInJSONBank(char status) {
        List<Bank> response = new ArrayList<>();
        response = iBankDAO.getListInJSONBank(status);
        return response;
    }

}
