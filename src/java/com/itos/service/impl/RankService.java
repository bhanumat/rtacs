/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.service.impl;

import com.itos.dao.model.IRankDAO;
import com.itos.model.Rank;
import com.itos.service.model.IRankService;
import com.itos.util.DateUtil;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ITOS
 */
@Service("iRankService")
@Transactional(value = "hibernateTransactionManager", propagation = Propagation.SUPPORTS)
public class RankService implements IRankService {

    public RankService() {

    }

    @Autowired
    IRankDAO iRankDAO;

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public JqGridResponse<Rank> getListRank(JqGridRequest req) {
        JqGridResponse<Rank> response = new JqGridResponse<>();
        response = iRankDAO.getList(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setDeleteRank(MessageRequest req) {
        MessageResponse response = new MessageResponse();
        response = iRankDAO.setDeleteRank(req);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveNewRank(Rank rank) {
        MessageResponse response = new MessageResponse();

        //Rank.setCreateDate(DateUtil.getCurrentDate());
        //Rank.setUpdateDate(DateUtil.getCurrentDate());
        response = iRankDAO.setSaveNewRank(rank);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", rollbackFor = Exception.class)
    public MessageResponse setSaveEditRank(Rank rank) {
        MessageResponse response = new MessageResponse();

        //Rank.setUpdateDate(DateUtil.getCurrentDate());
        response = iRankDAO.setSaveEditRank(rank);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public Rank getLoadRank(Rank rank) {
        Rank response = new Rank();
        response = iRankDAO.getLoadRank(rank);
        return response;
    }

    @Override
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<Rank> getListInJSONRank(char status) {
        List<Rank> response = new ArrayList<>();
        response = iRankDAO.getListInJSONRank(status);
        return response;
    }
}
