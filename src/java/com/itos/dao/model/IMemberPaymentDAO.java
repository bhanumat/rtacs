package com.itos.dao.model;

import com.itos.model.MemberPayment;
import com.itos.model.ext.DeptMemberPaymentDto;
import com.itos.model.ext.DeptPaymentDto;
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
public interface IMemberPaymentDAO {

    MessageResponse add(MemberPayment memberPayment);

    MemberPayment getMemberPaymentById(int paymentId);

    MessageResponse remove(MessageRequest req);

    MessageResponse update(MemberPayment memberPayment);
    
    JqGridResponse<MemberPaymentDto> searchMemberPayment(JqGridRequest req);
    
    JqGridResponse<MemberPaymentHeadDto> getMemberPaymentByCode(JqGridRequest req);
    
    JqGridResponse<DeptPaymentDto> searchDeptPayment(JqGridRequest req);
    
    JqGridResponse<DeptMemberPaymentDto> getListDeptMemberPayment (JqGridRequest req);
}
