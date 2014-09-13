/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberPaymentDAO;
import com.itos.dao.model.IMemberPaymentHeadDAO;
import com.itos.service.model.IMemberPaymentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bhanumat.w
 */
@Service("iMemberPaymentService")
public class MemberPaymentService implements IMemberPaymentService {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private IMemberPaymentDAO iMemberPaymentDAO;

    @Autowired
    private IMemberPaymentHeadDAO iMemberPaymentHeadDAO;

    public MemberPaymentService() {

    }
    
    //TODO: Add any other

}
