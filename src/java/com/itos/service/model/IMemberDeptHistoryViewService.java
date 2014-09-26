/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.model;

import com.itos.model.ext.MemberDeptHistoryView;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;

/**
 *
 * @author ITOS
 */
public interface IMemberDeptHistoryViewService {

    public JqGridResponse<MemberDeptHistoryView> getList(JqGridRequest req, int memberId);
}
