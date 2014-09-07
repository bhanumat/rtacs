/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IBankBranchDAO;
import com.itos.model.BankBranch;
import com.itos.service.model.IBankBranchService;
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
@Service("iBankBranchService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class BankBranchService implements IBankBranchService {

    public BankBranchService() {

    }

    @Autowired
    IBankBranchDAO iBankBranchDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<BankBranch> getListBankBranch(JqGridRequest req) {
        JqGridResponse<BankBranch> response = new JqGridResponse<>();
        response = iBankBranchDAO.getList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteBankBranch(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iBankBranchDAO.setDeleteBankBranch(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewBankBranch(BankBranch bankBranch) {
        MessageResponse response = new MessageResponse();

        bankBranch.setCreateDate(DateUtil.getCurrentDate());
        bankBranch.setUpdateDate(DateUtil.getCurrentDate());
        
        response = iBankBranchDAO.setSaveNewBankBranch(bankBranch);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditBankBranch(BankBranch bankBranch) {
        MessageResponse response = new MessageResponse();

        bankBranch.setUpdateDate(DateUtil.getCurrentDate());

        response = iBankBranchDAO.setSaveEditBankBranch(bankBranch);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public BankBranch getLoadBankBranch(BankBranch bankBranch) {
        BankBranch response = new BankBranch();
        response = iBankBranchDAO.getLoadBankBranch(bankBranch);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<BankBranch> getListInJSONBankBranch(char status) {
        List<BankBranch> response = new ArrayList<>();
        response = iBankBranchDAO.getListInJSONBankBranch(status);
        return response;
    }

}
