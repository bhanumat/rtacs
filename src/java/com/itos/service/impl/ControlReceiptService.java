/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IControlReceiptDAO;
import com.itos.model.ControlReceipt;
import com.itos.service.model.IControlReceiptService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ITOS
 */
@Service("iControlReceiptService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class ControlReceiptService implements IControlReceiptService {

    protected final Log logger = LogFactory.getLog(getClass());
    
    public ControlReceiptService() {

    }

    @Autowired
    IControlReceiptDAO iControlReceiptDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public ControlReceipt updateMemberStatus(int id) {
        ControlReceipt response = new ControlReceipt();
        response = iControlReceiptDAO.updatedRunningNo(id);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public String getDocumentCode() {
        logger.info("ControlReceiptService : getDocumentCode");
        return iControlReceiptDAO.getDocumentCode();
    }
}
