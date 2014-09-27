/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberPaymentDAO;
import com.itos.dao.model.IMemberPaymentHeadDAO;
import com.itos.model.MemberPayment;
import com.itos.model.MemberPaymentHead;
import com.itos.model.ext.MemberPaymentDto;
import com.itos.model.ext.MemberPaymentHeadDto;
import com.itos.service.model.IMemberPaymentService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MemberPaymentRequest;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    
    @Value("${application.DateFormat}")
    private String stringDateFormat;
    
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
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse updateMemberPayment(MemberPaymentRequest req) throws Exception {
        if (req != null && req.getMemberPaymentHeadDtos() != null && req.getMemberPaymentHeadDtos().length > 0) {
            Date paymentDate = DateUtil.String2Date(req.getPaymentDate(), stringDateFormat);
            int memberId = req.getMemberId();
            int paymentTypeCode = req.getPaymentTypeCode();
            String performedBy = req.getPerformedBy();
            String postNo = req.getPostNo();
            //TODO: where to save postNo
            MemberPayment memberPaymentToUpdate;
            MemberPayment memberPaymentUpdated;
            MemberPaymentHead memberPaymentHeadToAdd;
            MessageResponse resp = null;
            for (MemberPaymentHeadDto dto : req.getMemberPaymentHeadDtos()) {
                memberPaymentToUpdate = new MemberPayment(memberId, dto.getPaymentId());
                memberPaymentToUpdate.setPaymentDate(paymentDate);
                memberPaymentToUpdate.setPaymentTypeCode(paymentTypeCode);
                memberPaymentToUpdate.setUpdatedBy(performedBy);
                
                resp = iMemberPaymentDAO.update(memberPaymentToUpdate);
                memberPaymentUpdated = (MemberPayment) resp.getObj();
                
                memberPaymentHeadToAdd = new MemberPaymentHead(memberId);
                memberPaymentHeadToAdd.setAmount(memberPaymentUpdated.getAmount());
                memberPaymentHeadToAdd.setPaymentDate(paymentDate);
                memberPaymentHeadToAdd.setPaymentTypeCode(paymentTypeCode);
                memberPaymentHeadToAdd.setCreatedBy(performedBy);
                resp = iMemberPaymentHeadDAO.add(memberPaymentHeadToAdd);
            }
            return resp;
        } else {
            logger.error("Passing MemberPaymentRequest req with null");
            throw new NullPointerException("Passing MemberPaymentRequest req with null or  req.getMemberPaymentHeadDtos() is null or empty");
        }
    }
    
}
