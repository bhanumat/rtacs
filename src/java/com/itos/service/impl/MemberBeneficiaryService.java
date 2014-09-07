/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberBeneficiaryDAO;
import com.itos.model.Member;
import com.itos.model.MemberBeneficiary;
import com.itos.service.model.IMemberBeneficiaryService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ITOS
 */
@Service("iMemberBeneficiaryService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class MemberBeneficiaryService implements IMemberBeneficiaryService {

    public MemberBeneficiaryService() {

    }

    @Autowired
    IMemberBeneficiaryDAO iMemberBeneficiaryDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberBeneficiary> getListMemberBeneficiary(JqGridRequest req) {
        JqGridResponse<MemberBeneficiary> response = new JqGridResponse<>();
        response = iMemberBeneficiaryDAO.getList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteMemberBeneficiary(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iMemberBeneficiaryDAO.setDeleteMemberBeneficiary(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewMemberBeneficiary(MemberBeneficiary memberBeneficiary) {
        MessageResponse response = new MessageResponse();

        //MemberBeneficiary.setCreateDate(DateUtil.getCurrentDate());
        //MemberBeneficiary.setUpdateDate(DateUtil.getCurrentDate());

        response = iMemberBeneficiaryDAO.setSaveNewMemberBeneficiary(memberBeneficiary);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditMemberBeneficiary(MemberBeneficiary memberBeneficiary) {
        MessageResponse response = new MessageResponse();

        //MemberBeneficiary.setUpdateDate(DateUtil.getCurrentDate());

        response = iMemberBeneficiaryDAO.setSaveEditMemberBeneficiary(memberBeneficiary);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public MemberBeneficiary getLoadMemberBeneficiary(MemberBeneficiary memberBeneficiary) {
        MemberBeneficiary response = new MemberBeneficiary();
        response = iMemberBeneficiaryDAO.getLoadMemberBeneficiary(memberBeneficiary);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<MemberBeneficiary> getListMemberBeneficiaryByMember(Member member) {
        List<MemberBeneficiary> response = new ArrayList<>();
        response = iMemberBeneficiaryDAO.getListByMember(member);
        return response;
    }
}
