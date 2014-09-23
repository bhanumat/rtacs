/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberPaymentDAO;
import com.itos.dao.model.IMemberPaymentHeadDAO;
import com.itos.model.MemberPayment;
import com.itos.model.ext.MemberPaymentDto;
import com.itos.model.ext.MemberPaymentHeadDto;
import com.itos.model.ext.PaymentMember;
import com.itos.service.model.IMemberPaymentService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jqGrid.Search;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse createMemberPayment(MemberPayment memberPayment) {
        if (memberPayment != null) {
            return iMemberPaymentDAO.add(memberPayment);
        } else {
            logger.error("Passing memberPayment=null");
            throw new NullPointerException("MemberPayment memberPayment is null");
        }
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse updateMemberPayment(MemberPayment memberPayment) {
        if (memberPayment != null) {
            return iMemberPaymentDAO.update(memberPayment);
        } else {
            logger.error("Passing memberPayment=null");
            throw new NullPointerException("MemberPayment memberPayment is null");
        }
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse removeMemberPayment(MessageRequest req) {
        if (req != null) {
            MessageResponse resp = iMemberPaymentDAO.remove(req);
            if (resp.getCheckSuccess()) {
                //Manual remove cascade table related.
                return iMemberPaymentHeadDAO.remove(req);
            } else {
                return resp;
            }
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public MemberPayment getMemberPayment(int paymentId) {
        return iMemberPaymentDAO.getMemberPaymentById(paymentId);
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberPaymentDto> searchMemberPayment(JqGridRequest req) {
        if (req != null) {
            return iMemberPaymentDAO.searchMemberPayment(req);
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberPaymentHeadDto> getMemberPaymentByCode(JqGridRequest req) {
        if (req != null) {
            return iMemberPaymentDAO.getMemberPaymentByCode(req);
        } else {
            logger.error("Passing req=null");
            throw new NullPointerException("MessageReqquest req is null");
        }
    }

}
