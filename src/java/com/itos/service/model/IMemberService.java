/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.model;

import com.itos.model.Member;
import com.itos.model.ext.PaymentDetail;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;

/**
 *
 * @author ITOS
 */
public interface IMemberService {

    public JqGridResponse<Member> getListMember(JqGridRequest req);

    public JqGridResponse<Member> getListMemberForRegister(JqGridRequest req);

    public MessageResponse setDeleteMember(MessageRequest req);

    public MessageResponse setSaveNewMember(Member member);

    public MessageResponse setSaveEditMember(Member member);

    public Member getLoadMember(Member member);

    public MessageResponse setSaveUpdateMemberOperation(Member member);

    public PaymentDetail searchMemberFromCitisenId(String citizenId);

    public Member updateMemberStatus(String citizenId);

    public JqGridResponse<Member> getListMemberAPP041_2(JqGridRequest req);

    public JqGridResponse<Member> getAddListMemberAPP041_2(JqGridRequest req);

    public JqGridResponse<Member> getListMemberAPP031_2(JqGridRequest req);

    public JqGridResponse<Member> getAddListMemberAPP031_2(JqGridRequest req);

    public JqGridResponse<Member> getListMember(JqGridRequest req, int memberStatusCode);

    public JqGridResponse<Member> getListMember(JqGridRequest req, int memberStatusCode, int operationId);

    public Member updateMemberStatusAPP041(Integer memberId);

    public Member updateMemberStatusAPP031(Integer memberId);

}
