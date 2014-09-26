/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.model;

import com.itos.model.Member;
import com.itos.model.ext.ChangeMemberData;
import com.itos.model.ext.MemberData;
import com.itos.model.ext.MemberTotalDetail;
import com.itos.model.ext.PaymentDetail;
import com.itos.model.ext.PaymentMilitary;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.CHT010Request;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;

/**
 *
 * @author ITOS
 */
public interface IMemberService {

    public JqGridResponse<MemberData> getListMember(JqGridRequest req);

    public JqGridResponse<MemberData> getListMemberForRegister(JqGridRequest req);

    public MessageResponse setDeleteMember(MessageRequest req);

    public MessageResponse setSaveNewMember(Member member);

    public MessageResponse setSaveEditMember(Member member);

    public MemberData getLoadMember(Member member);

    public MessageResponse setSaveUpdateMemberOperation(Member member);

    public PaymentDetail searchMemberFromCitisenId(String citizenId);

    public Member updateMemberStatus(String citizenId);

    public JqGridResponse<MemberData> getListMember(JqGridRequest req, int operationTypeCode);
    
    public JqGridResponse<MemberData> getListMemberStatus(JqGridRequest req, int memberStatusCode);

    public JqGridResponse<MemberData> getListMember(JqGridRequest req, int operationTypeCode, int operationId);

    public Member updateMemberStatusAPP041(Integer memberId);

    public Member updateMemberStatusAPP031(Integer memberId);
    
    public JqGridResponse<PaymentMilitary> getPaymentMilitaryList(JqGridRequest req);
    
    public Member updatedMemberPAY021_1(String memberId);
    
    public JqGridResponse<ChangeMemberData> getChangeMemberList(JqGridRequest req);
    
    public MessageResponse updatedCHT010(CHT010Request request);
    public MemberTotalDetail searchCHT030(MessageRequest req);
}
