/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberDAO;
import com.itos.model.Member;
import com.itos.model.json.JsonMember;
import com.itos.model.ext.PaymentDetail;
import com.itos.service.model.IMemberService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
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
    public JqGridResponse<Member> getListMember(JqGridRequest req) {
        JqGridResponse<Member> response = new JqGridResponse<>();
        response = iMemberDAO.getList(req);
        return response;
    }

    public JqGridResponse<Member> getListMemberForRegister(JqGridRequest req) {
        JqGridResponse<Member> response = new JqGridResponse<>();
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
    public Member getLoadMember(Member member) {
        Member response = new Member();
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
}
