/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.Member;
import com.itos.model.json.JsonMember;
import com.itos.model.ext.PaymentDetail;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IMemberDAO {

    public JqGridResponse<Member> getList(JqGridRequest req);

    public JqGridResponse<Member> getListForRegister(JqGridRequest req);

    public MessageResponse setDeleteMember(MessageRequest req);

    public MessageResponse setSaveNewMember(Member member);

    public MessageResponse setSaveEditMember(Member member);

    public Member getLoadMember(Member member);

    public MessageResponse setSaveUpdateMemberOperation(Member member);

    public PaymentDetail searchMember(String citisenId);

    public Member updatedStatus(String citizenId);
}
