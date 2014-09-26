/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IMemberStatusViewDAO;
import com.itos.model.ext.MemberStatusView;
import com.itos.service.model.IMemberStatusViewService;
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
@Service("iMemberStatusViewService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class MemberStatusViewService implements IMemberStatusViewService{

    @Autowired
    IMemberStatusViewDAO iMemberStatusViewDAO;
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<MemberStatusView> getList(JqGridRequest req, int memberId) {
        JqGridResponse<MemberStatusView> response = new JqGridResponse<>();
        response = iMemberStatusViewDAO.getList(req, memberId);
        return response;
    }
}
