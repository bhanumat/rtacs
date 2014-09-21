/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.service.model.IMemberPaymentHeadService;
import com.itos.dao.model.IMemberPaymentHeadDAO;
import com.itos.model.MemberPaymentHead;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bhanumat.w
 */
@Service("iMemberPaymentHeadService")
public class MemberPaymentHeadService implements IMemberPaymentHeadService {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private IMemberPaymentHeadDAO iMemberPaymentHeadDAO;

    public MemberPaymentHeadService() {

    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse createMemberPaymentHead(MemberPaymentHead memberPaymentHead) {
        if (memberPaymentHead != null) {
            return iMemberPaymentHeadDAO.add(memberPaymentHead);
        } else {
            logger.error("Passing memberPaymentHead=null");
            throw new NullPointerException("MemberPaymentHead memberPaymentHead is null");
        }
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse updateMemberPaymentHead(MemberPaymentHead memberPaymentHead) {
        if (memberPaymentHead != null) {
            return iMemberPaymentHeadDAO.update(memberPaymentHead);
        } else {
            logger.error("Passing memberPaymentHead=null");
            throw new NullPointerException("MemberPaymentHead memberPaymentHead is null");
        }
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse removeMemberPaymentHead(MessageRequest req) {
        if (req != null) {
            return iMemberPaymentHeadDAO.remove(req);
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }

    @Override
    public MemberPaymentHead getMemberPaymentHead(int paymentId) {
        return iMemberPaymentHeadDAO.getMemberPaymentHeadById(paymentId);
    }
}
