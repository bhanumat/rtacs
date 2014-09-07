/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.Member;
import com.itos.model.MemberBeneficiary;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IMemberBeneficiaryDAO {

    public JqGridResponse<MemberBeneficiary> getList(JqGridRequest req);
    
    public MessageResponse setDeleteMemberBeneficiary(MessageRequest req);
    
    public MessageResponse setSaveNewMemberBeneficiary(MemberBeneficiary memberBeneficiary);

    public MessageResponse setSaveEditMemberBeneficiary(MemberBeneficiary memberBeneficiary);
    
    public MemberBeneficiary getLoadMemberBeneficiary(MemberBeneficiary memberBeneficiary);

    public List<MemberBeneficiary> getListByMember(Member member);
}
