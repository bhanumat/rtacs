/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.Member;
import com.itos.model.ext.ChangeMemberData;
import com.itos.model.ext.MemberData;
import com.itos.model.ext.MemberTotalDetail;
import com.itos.model.ext.PaymentDetail;
import com.itos.model.ext.PaymentMilitary;
import com.itos.model.json.JsonMember;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.CHT010Request;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IMemberDAO {

    public JqGridResponse<MemberData> getList(JqGridRequest req);

    public JqGridResponse<MemberData> getListForRegister(JqGridRequest req);

    public MessageResponse setDeleteMember(MessageRequest req);

    public MessageResponse setSaveNewMember(Member member);

    public MessageResponse setSaveEditMember(Member member);

    public MemberData getLoadMember(Member member);

    public MessageResponse setSaveUpdateMemberOperation(Member member);

    public PaymentDetail searchMember(String citisenId);

    public Member updatedStatus(String citizenId);

    public JqGridResponse<MemberData> getList(JqGridRequest req, int operationTypeCode);
    
    public JqGridResponse<MemberData> getListMemberStatus(JqGridRequest req, int memberStatusCode);

    public JqGridResponse<MemberData> getList(JqGridRequest req, int operationTypeCode, int operationId);

    public Member updatedStatusAPP041(Integer memberId);

    public Member updatedStatusAPP031(Integer memberId);
    
    public JqGridResponse<PaymentMilitary> getPaymentMilitaryList(JqGridRequest req);
    
    public Member updatedStatusPAY021_1(String memberId);
    
    public JqGridResponse<ChangeMemberData> getChangeMemberList(JqGridRequest req);
    
    public MessageResponse updatedCHT010(CHT010Request request);
    public MemberTotalDetail searchCHT030(MessageRequest req);
}
