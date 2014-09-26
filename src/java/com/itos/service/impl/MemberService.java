/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberDAO;
import com.itos.model.Member;
import com.itos.model.ext.ChangeMemberData;
import com.itos.model.ext.MemberData;
import com.itos.model.ext.MemberTotalDetail;
import com.itos.model.ext.PaymentDetail;
import com.itos.model.ext.PaymentMilitary;
import com.itos.service.model.IMemberService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.CHT010Request;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
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
@Service("iMemberService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class MemberService implements IMemberService {

    protected final Log logger = LogFactory.getLog(getClass());

    public MemberService() {

    }

    @Autowired
    IMemberDAO iMemberDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberData> getListMember(JqGridRequest req) {
        JqGridResponse<MemberData> response = new JqGridResponse<>();
        response = iMemberDAO.getList(req);
        return response;
    }

    public JqGridResponse<MemberData> getListMemberForRegister(JqGridRequest req) {
        JqGridResponse<MemberData> response = new JqGridResponse<>();
        response = iMemberDAO.getListForRegister(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteMember(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iMemberDAO.setDeleteMember(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewMember(Member member) {
        MessageResponse response = new MessageResponse();

        member.setCreateDate(DateUtil.getCurrentDate());
        member.setUpdateDate(DateUtil.getCurrentDate());

        response = iMemberDAO.setSaveNewMember(member);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditMember(Member member) {
        MessageResponse response = new MessageResponse();

        member.setUpdateDate(DateUtil.getCurrentDate());

        response = iMemberDAO.setSaveEditMember(member);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public MemberData getLoadMember(Member member) {
        MemberData response = new MemberData();
        response = iMemberDAO.getLoadMember(member);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveUpdateMemberOperation(Member member) {
        MessageResponse response = new MessageResponse();

        member.setUpdateDate(DateUtil.getCurrentDate());

        response = iMemberDAO.setSaveUpdateMemberOperation(member);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public PaymentDetail searchMemberFromCitisenId(String citizenId) {
        logger.info("MemberService : searchMemberFromCitisenId");
        PaymentDetail response = new PaymentDetail();
        response = iMemberDAO.searchMember(citizenId);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public Member updateMemberStatus(String citizenId) {
        Member response = new Member();
        response = iMemberDAO.updatedStatus(citizenId);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public Member updatedMemberPAY021_1(String memberId) {
        Member response = new Member();
        response = iMemberDAO.updatedStatusPAY021_1(memberId);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public Member updateMemberStatusAPP041(Integer memberId) {
        Member response = new Member();
        response = iMemberDAO.updatedStatusAPP041(memberId);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public Member updateMemberStatusAPP031(Integer memberId) {
        Member response = new Member();
        response = iMemberDAO.updatedStatusAPP031(memberId);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberData> getListMember(JqGridRequest req, int operationTypeCode) {
        JqGridResponse<MemberData> response = new JqGridResponse<>();
        response = iMemberDAO.getList(req, operationTypeCode);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberData> getListMemberStatus(JqGridRequest req, int memberStatusCode) {
        JqGridResponse<MemberData> response = new JqGridResponse<>();
        response = iMemberDAO.getListMemberStatus(req, memberStatusCode);
        return response;
    }

    /*
     JqGridRequest req,
     int memberStatusCode, // 0=ALL
     int operationId
     */
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberData> getListMember(JqGridRequest req, int operationTypeCode, int operationId) {
        JqGridResponse<MemberData> response = new JqGridResponse<>();
        response = iMemberDAO.getList(req, operationTypeCode, operationId);
        return response;
    }
    
    /*
     JqGridRequest req,
     int memberStatusCode, // 0=ALL
     int operationId
     */
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<PaymentMilitary> getPaymentMilitaryList(JqGridRequest req) {
        JqGridResponse<PaymentMilitary> response = iMemberDAO.getPaymentMilitaryList(req);
        return response;
    }    
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<ChangeMemberData> getChangeMemberList(JqGridRequest req) {
        JqGridResponse<ChangeMemberData> response = iMemberDAO.getChangeMemberList(req);
        return response;
    }  
    
    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse updatedCHT010(CHT010Request request) {
        MessageResponse response = new MessageResponse();
        response = iMemberDAO.updatedCHT010(request);
        return response;
    }
    
    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public MemberTotalDetail searchCHT030(MessageRequest req) {
        MemberTotalDetail response = iMemberDAO.searchCHT030(req);
        return response;
    }  
}
