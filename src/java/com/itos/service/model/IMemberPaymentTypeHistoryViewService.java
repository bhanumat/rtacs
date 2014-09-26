/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.model;

import com.itos.model.ext.MemberPaymentTypeHistoryView;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;

/**
 *
 * @author ITOS
 */
public interface IMemberPaymentTypeHistoryViewService {

    public JqGridResponse<MemberPaymentTypeHistoryView> getList(JqGridRequest req, int memberId);
}
