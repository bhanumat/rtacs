/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberPaymentDAO;
import com.itos.model.MemberPayment;
import com.itos.service.model.IMemberPaymentService;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
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

    public MemberPaymentService() {

    }

    @Override
    public MessageResponse createMemberPayment(MemberPayment memberPayment) {
        if (memberPayment != null) {
            return iMemberPaymentDAO.add(memberPayment);
        } else {
            logger.error("Passing memberPayment=null");
            throw new NullPointerException("MemberPayment memberPayment is null");
        }
    }

    @Override
    public MessageResponse updateMemberPayment(MemberPayment memberPayment) {
        if (memberPayment != null) {
            return iMemberPaymentDAO.update(memberPayment);
        } else {
            logger.error("Passing memberPayment=null");
            throw new NullPointerException("MemberPayment memberPayment is null");
        }
    }

    @Override
    public MessageResponse removeMemberPayment(MessageRequest req) {
        if (req != null) {
            return iMemberPaymentDAO.remove(req);
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }

    @Override
    public MemberPayment getMemberPayment(int paymentId) {
        return iMemberPaymentDAO.getMemberPaymentById(paymentId);
    }

}
