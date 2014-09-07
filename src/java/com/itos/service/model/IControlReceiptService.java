/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.model;

import com.itos.model.ControlReceipt;

/**
 *
 * @author ITOS
 */
public interface IControlReceiptService {

    public ControlReceipt updateMemberStatus(int id);
    public String getDocumentCode();

}
