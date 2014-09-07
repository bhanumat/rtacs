/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.BankAccountType;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IBankAccountTypeDAO {

    public JqGridResponse<BankAccountType> getList(JqGridRequest req);
    
    public MessageResponse setDeleteBankAccountType(MessageRequest req);
    
    public MessageResponse setSaveNewBankAccountType(BankAccountType bankAccountType);

    public MessageResponse setSaveEditBankAccountType(BankAccountType bankAccountType);
    
    public BankAccountType getLoadBankAccountType(BankAccountType bankAccountType);
    
    public List<BankAccountType> getListInJSONBankAccountType(char status);
}
