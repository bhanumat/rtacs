/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import com.itos.model.Bank;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.List;

/**
 *
 * @author ITOS
 */
public interface IBankDAO {

    public JqGridResponse<Bank> getList(JqGridRequest req);
    
    public MessageResponse setDeleteBank(MessageRequest req);
    
    public MessageResponse setSaveNewBank(Bank bank);

    public MessageResponse setSaveEditBank(Bank bank);
    
    public Bank getLoadBank(Bank bank);

    public List<Bank> getListInJSONBank(char status);
}
