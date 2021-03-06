/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.Member;
import com.itos.model.Operation;
import com.itos.model.OperationMember;
import com.itos.model.ext.PaymentDetail;
import com.itos.model.ext.PaymentMember;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IOperationMemberDAO {

    public JqGridResponse<OperationMember> getList(JqGridRequest req);
    
    public JqGridResponse<PaymentMember> getPaymentMemberList(JqGridRequest req);
    
    public MessageResponse setDeleteOperationMember(MessageRequest req);
    
    public MessageResponse cancelBill(MessageRequest req);
    
    public MessageResponse setSaveNewOperationMember(OperationMember operationMember);
    
    public MessageResponse setSaveApproveOperationMember(OperationMember operationMember);

    public MessageResponse setSaveEditOperationMember(OperationMember operationMember);
    
    public OperationMember getLoadOperationMember(OperationMember operationMember);
    
    public List<OperationMember> getListInJSONOperationMember(char status);
    
    public PaymentDetail searchPaymentDetail(String operationMemberId);

    public MessageResponse setSaveNewOperationMemberForRegisterNo(List<Member> listMember, Operation operation);
    
    public JqGridResponse<OperationMember> getList(JqGridRequest req, int memberStatusCode);
    
    public MessageResponse setSaveApproveOperationMemberList(List<Member> listMember, Operation operation);
}
