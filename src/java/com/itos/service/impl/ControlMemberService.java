/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IControlMemberDAO;
import com.itos.service.model.IControlMemberService;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Service("iControlMemberService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class ControlMemberService implements IControlMemberService {

    protected final Log logger = LogFactory.getLog(getClass());
    
    public ControlMemberService() {

    }

    @Autowired
    IControlMemberDAO iControlMemberDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public BigDecimal getLastApplyFee() {
        logger.info("ControlMemberService : getLastApplyFee");
        BigDecimal response = new BigDecimal(BigInteger.ZERO);
        response = iControlMemberDAO.getLastApplyFee();
        return response;
    }
}
