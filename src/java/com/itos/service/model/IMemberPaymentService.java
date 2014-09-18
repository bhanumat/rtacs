package com.itos.service.model;

import com.itos.model.MemberPayment;
import com.itos.model.ext.MemberPaymentDto;
import com.itos.model.ext.MemberPaymentHeadDto;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author bhanumat.w
 */
public interface IMemberPaymentService {

    MessageResponse createMemberPayment(MemberPayment memberPayment);

    MessageResponse updateMemberPayment(MemberPayment memberPayment);

    MessageResponse removeMemberPayment(MessageRequest req);

    MemberPayment getMemberPayment(int paymentId);
    
    JqGridResponse<MemberPaymentDto> searchMemberPayment(JqGridRequest req);
    
    JqGridResponse<MemberPaymentHeadDto> searchMemberPaymentByCode(String citizenId, String memberCode);

}
