package com.itos.service.model;

import com.itos.model.MemberPayment;
import com.itos.model.ext.MemberPaymentDto;
import com.itos.model.ext.MemberPaymentHeadDto;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MemberPaymentRequest;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;

/**
 *
 * @author bhanumat.w
 */
public interface IMemberPaymentService {

    MessageResponse createMemberPayment(MemberPayment memberPayment) throws Exception;

    MessageResponse updateMemberPayment(MemberPayment memberPayment) throws Exception;

    MessageResponse removeMemberPayment(MessageRequest req) throws Exception;

    MemberPayment getMemberPayment(int paymentId);

    JqGridResponse<MemberPaymentDto> searchMemberPayment(JqGridRequest req);

    JqGridResponse<MemberPaymentHeadDto> getMemberPaymentByCode(JqGridRequest req);

    public MessageResponse updateMemberPayment(MemberPaymentRequest req) throws Exception;

}
