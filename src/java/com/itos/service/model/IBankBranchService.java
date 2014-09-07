/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.model;

import com.itos.model.BankBranch;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IBankBranchService {

    public JqGridResponse<BankBranch> getListBankBranch(JqGridRequest req);
    
    public MessageResponse setDeleteBankBranch(MessageRequest req);
    
    public MessageResponse setSaveNewBankBranch(BankBranch bankBranch);
    
    public MessageResponse setSaveEditBankBranch(BankBranch bankBranch);
    
    public BankBranch getLoadBankBranch(BankBranch bankBranch);

    public List<BankBranch> getListInJSONBankBranch(char status);

}
