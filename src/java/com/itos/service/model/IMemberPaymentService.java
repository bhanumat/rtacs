package com.itos.service.model;

import com.itos.model.MemberPayment;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;

/**
 *
 * @author bhanumat.w
 */
public interface IMemberPaymentService {

    MessageResponse createMemberPayment(MemberPayment memberPayment);

    MessageResponse updateMemberPayment(MemberPayment memberPayment);

    MessageResponse removeMemberPayment(MessageRequest req);

    MemberPayment getMemberPayment(int paymentId);

}
