/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IOperationMemberDAO;
import com.itos.model.OperationMember;
import com.itos.model.ext.PaymentDetail;
import com.itos.model.ext.PaymentMember;
import com.itos.service.model.IOperationMemberService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.ArrayList;
import java.util.List;
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
@Service("iOperationMemberService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class OperationMemberService implements IOperationMemberService {

    protected final Log logger = LogFactory.getLog(getClass());
    
    public OperationMemberService() {

    }

    @Autowired
    IOperationMemberDAO iOperationMemberDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<OperationMember> getListOperationMember(JqGridRequest req) {
        logger.info("OperationMemberService : getListOperationMember");
         JqGridResponse<OperationMember> response = iOperationMemberDAO.getList(req);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<PaymentMember> getListPaymentMember(JqGridRequest req) {
        logger.info("OperationMemberService : getListPaymentMember");
         JqGridResponse<PaymentMember> response = iOperationMemberDAO.getPaymentMemberList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteOperationMember(MessageRequest req) {
        logger.info("OperationMemberService : setDeleteOperationMember");
        MessageResponse response = new MessageResponse();
        response = iOperationMemberDAO.setDeleteOperationMember(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewOperationMember(OperationMember operationMember) {
        MessageResponse response = new MessageResponse();

        //operationMember.setCreateDate(DateUtil.getCurrentDate());
        
        response = iOperationMemberDAO.setSaveApproveOperationMember(operationMember);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse savePaymentNewOperationMember(OperationMember operationMember) {
        MessageResponse response = new MessageResponse();

        //operationMember.setCreateDate(DateUtil.getCurrentDate());
        
        response = iOperationMemberDAO.setSaveNewOperationMember(operationMember);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveApproveOperationMember(OperationMember operationMember) {
        MessageResponse response = new MessageResponse();
        logger.info("OperationMemberService : setSaveApproveOperationMember");
//        operationMember.setCreateDate(DateUtil.getCurrentDate());
        
        response = iOperationMemberDAO.setSaveApproveOperationMember(operationMember);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse cancelBill(MessageRequest req) {
        logger.info("OperationMemberService : cancelBill");
        MessageResponse response = new MessageResponse();
        response = iOperationMemberDAO.cancelBill(req);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public OperationMember getLoadOperationMember(OperationMember operationMember) {
        OperationMember response = new OperationMember();
        response = iOperationMemberDAO.getLoadOperationMember(operationMember);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<OperationMember> getListInJSONOperationMember(char status) {
        List<OperationMember> response = new ArrayList<>();
        response = iOperationMemberDAO.getListInJSONOperationMember(status);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public PaymentDetail searchPaymentDetail(String operationMemberId) {
        PaymentDetail response = new PaymentDetail();
        response = iOperationMemberDAO.searchPaymentDetail(operationMemberId);
        return response;
    }

}
