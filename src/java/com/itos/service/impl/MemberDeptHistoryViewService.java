/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberDeptHistoryViewDAO;
import com.itos.model.ext.MemberDeptHistoryView;
import com.itos.service.model.IMemberDeptHistoryViewService;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ITOS
 */
@Service("iMemberDeptHistoryViewService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class MemberDeptHistoryViewService implements IMemberDeptHistoryViewService{

    @Autowired
    IMemberDeptHistoryViewDAO iMemberDeptHistoryViewDAO;
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberDeptHistoryView> getList(JqGridRequest req, int memberId) {
        JqGridResponse<MemberDeptHistoryView> response = new JqGridResponse<>();
        response = iMemberDeptHistoryViewDAO.getList(req, memberId);
        return response;
    }
}
