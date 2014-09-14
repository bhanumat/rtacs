package com.itos.service.model;

import com.itos.model.MemberPaymentHead;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;

/**
 *
 * @author bhanumat.w
 */
public interface IMemberPaymentHeadService {

    MessageResponse createMemberPaymentHead(MemberPaymentHead memberPaymentHead);

    MessageResponse updateMemberPaymentHead(MemberPaymentHead memberPaymentHead);

    MessageResponse removeMemberPaymentHead(MessageRequest req);

    MemberPaymentHead getMemberPaymentHead(int paymentId);
}
