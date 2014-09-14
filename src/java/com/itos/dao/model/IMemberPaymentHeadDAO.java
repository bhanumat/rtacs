/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.MemberPaymentHead;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;

/**
 *
 * @author bhanumat.w
 */
public interface IMemberPaymentHeadDAO {

    MessageResponse add(MemberPaymentHead memberPaymentHead);

    JqGridResponse<MemberPaymentHead> getList(JqGridRequest req);

    MemberPaymentHead getMemberPaymentHeadById(int paymentId);

    MessageResponse remove(MessageRequest req);

    MessageResponse update(MemberPaymentHead memberPaymentHead);

}
