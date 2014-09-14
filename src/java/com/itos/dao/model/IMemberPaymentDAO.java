package com.itos.dao.model;

import com.itos.model.MemberPayment;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;

/**
 *
 * @author bhanumat.w
 */
public interface IMemberPaymentDAO {

    MessageResponse add(MemberPayment memberPayment);

    JqGridResponse<MemberPayment> getList(JqGridRequest req);

    MemberPayment getMemberPaymentById(int paymentId);

    MessageResponse remove(MessageRequest req);

    MessageResponse update(MemberPayment memberPayment);
}
