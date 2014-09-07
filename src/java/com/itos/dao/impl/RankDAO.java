/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IRankDAO;
import com.itos.model.Rank;
import com.itos.util.ConstantsMessage;
import com.itos.util.Hibernate.CommandConstant;
import com.itos.util.Hibernate.CommandQuery;
import com.itos.util.Hibernate.WhereField;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jqGrid.Paging;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITOS
 */
@Repository("iRankDAO")
public class RankDAO implements IRankDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private final String objectTable = "Rank";

    @Override
    public JqGridResponse<Rank> getList(JqGridRequest req) {
        List<Rank> listResponse = new ArrayList<>();
        JqGridResponse<Rank> jqGrid = new JqGridResponse<>();
        Rank rankObject;
        List<Rank> list;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");

        Paging paging = CommandQuery.CountRows(sessionFactory, req, objectTable);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, objectTable, paging);
        /*
         * Check array data if true set create object to array new.
         */
        if (!query.list().isEmpty()) {
            list = query.list();

            /*
             * Start developer create object to array new.
             */
            for (Rank rankObjectList : list) {
                rankObject = new Rank();
                rankObject.setRankId(rankObjectList.getRankId());
                rankObject.setRankClassCode(rankObjectList.getRankClassCode());
                rankObject.setRankFullname(rankObjectList.getRankFullname());
                rankObject.setRankName(rankObjectList.getRankName());
                rankObject.setRankOrder(rankObjectList.getRankOrder());
                rankObject.setStatus(rankObjectList.getStatus());
                rankObject.setCreateBy(rankObjectList.getCreateBy());
                rankObject.setCreateDate(rankObjectList.getCreateDate());
                rankObject.setUpdateBy(rankObjectList.getUpdateBy());
                rankObject.setUpdateDate(rankObjectList.getUpdateDate());
                listResponse.add(rankObject);
            }
            /*
             * End developer create object to array new.
             */

            /*
             * Set Paging to jqgrid.
             */
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(paging.getiRecords());
            jqGrid.setTotalPages((paging.getiRecords() + req.getRows() - 1) / req.getRows());
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }

    @Override
    public MessageResponse setDeleteRank(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        Rank rankOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            rankOriginal = new Rank();
            rankOriginal = (Rank) CommandQuery.LoadDetail(sessionFactory, Rank.class, Integer.parseInt(id));
            if (CommandQuery.Delete(sessionFactory, rankOriginal)) {
                iCountSuccessful++;
            }
        }
        if (iCountSuccessful == req.getItemSelect().size()) {
            response.setCheckSuccess(true);
        } else {
            response.setCheckSuccess(false);
        }
        chekSuccess = response.getCheckSuccess();
        if (chekSuccess) {
            response.setId("");
            response.setMessage(ConstantsMessage.DeleteSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.DeleteUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveNewRank(Rank rank) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        chekSuccess = CommandQuery.Insert(sessionFactory, rank);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(rank.getRankId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditRank(Rank rank) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        Rank rankOriginal = (Rank) CommandQuery.LoadDetail(sessionFactory, Rank.class, rank.getRankId());

        rankOriginal.setRankClassCode(rank.getRankClassCode());
        rankOriginal.setRankFullname(rank.getRankFullname());
        rankOriginal.setRankName(rank.getRankName());
        rankOriginal.setRankOrder(rank.getRankOrder());
        rankOriginal.setStatus(rank.getStatus());
        rankOriginal.setUpdateBy(rank.getUpdateBy());
        rankOriginal.setUpdateDate(rank.getUpdateDate());
        chekSuccess = CommandQuery.Update(sessionFactory, rankOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(rank.getRankId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public Rank getLoadRank(Rank rank) {
        Rank groupResponse = getLoadDetailByObject(rank);
        return groupResponse;
    }

    private Rank getLoadDetailByObject(Rank rankObject) {
        Rank rankResponse = new Rank();
        List<WhereField> listWhereField = new ArrayList();
        List<Rank> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("rankId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(rankObject.getRankId());
            listWhereField.add(whereField);

//            whereField = new WhereField();
//            whereField.setSearchField("flag");
//            whereField.setSearchLogic(CommandConstant.QueryAND);
//            whereField.setSearchOper(CommandConstant.QueryEqual);
//            whereField.setSearchValue("Y");
//            listWhereField.add(whereField);
            Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField, 0, 1);
            /*
             * Check array data if true set create object to array new.
             */
            if (!query.list().isEmpty()) {
                list = query.list();

                /*
                 * Start developer create object to array new.
                 */
                for (Rank rankObjectList : list) {
                    rankResponse = new Rank();
                    rankResponse.setRankId(rankObjectList.getRankId());
                    rankResponse.setRankClassCode(rankObjectList.getRankClassCode());
                    rankResponse.setRankFullname(rankObjectList.getRankFullname());
                    rankResponse.setRankName(rankObjectList.getRankName());
                    rankResponse.setRankOrder(rankObjectList.getRankOrder());
                    rankResponse.setStatus(rankObjectList.getStatus());
                    rankResponse.setCreateBy(rankObjectList.getCreateBy());
                    rankResponse.setCreateDate(rankObjectList.getCreateDate());
                    rankResponse.setUpdateBy(rankObjectList.getUpdateBy());
                    rankResponse.setUpdateDate(rankObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return rankResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Rank getLoadDetailById(Rank rank) {
        Rank rankResponse = null;
        List<WhereField> listWhereField = new ArrayList();
        List<Rank> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("rankId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(rank.getRankId());
            listWhereField.add(whereField);

            Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField, 0, 1);
            /*
             * Check array data if true set create object to array new.
             */
            if (!query.list().isEmpty()) {
                list = query.list();

                /*
                 * Start developer create object to array new.
                 */
                for (Rank rankObjectList : list) {
                    rankResponse = new Rank();
                    rankResponse.setRankId(rankObjectList.getRankId());
                    rankResponse.setRankClassCode(rankObjectList.getRankClassCode());
                    rankResponse.setRankFullname(rankObjectList.getRankFullname());
                    rankResponse.setRankName(rankObjectList.getRankName());
                    rankResponse.setRankOrder(rankObjectList.getRankOrder());
                    rankResponse.setStatus(rankObjectList.getStatus());                    
                    rankResponse.setCreateBy(rankObjectList.getCreateBy());
                    rankResponse.setCreateDate(rankObjectList.getCreateDate());
                    rankResponse.setUpdateBy(rankObjectList.getUpdateBy());
                    rankResponse.setUpdateDate(rankObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return rankResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    @Override
    public List<Rank> getListInJSONRank(char status) {
        List<Rank> listResponse = new ArrayList<>();
        List<Rank> list;
        Rank rankObject;
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Title");
        Query query;
        whereField = new WhereField();
        whereField.setSearchField("status");
        whereField.setSearchLogic("");
        if ('%' != status) {
            whereField.setSearchOper(CommandConstant.QueryEqual);
        } else {
            whereField.setSearchOper(CommandConstant.QueryContains);
        }
        whereField.setSearchValue(status);
        whereField.setSearchDataType(CommandConstant.DataTypeChar);
        listWhereField.add(whereField);
        query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);
        /*
         if ('%' == status) {
         query = CommandQuery.CreateQuery(sessionFactory, objectTable);
         } else {
         whereField = new WhereField();
         whereField.setSearchField("status");
         whereField.setSearchLogic("");
         whereField.setSearchOper(CommandConstant.QueryEqual);
         whereField.setSearchValue(status);
         listWhereField.add(whereField);
         query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);
         }
         */
        /*
         * Check array data if true set create object to array new.
         */
        if (!query.list().isEmpty()) {
            list = query.list();

            /*
             * Start developer create object to array new.
             */
            for (Rank rankObjectList : list) {
                rankObject = new Rank();
                rankObject.setRankId(rankObjectList.getRankId());
                rankObject.setRankClassCode(rankObjectList.getRankClassCode());
                rankObject.setRankFullname(rankObjectList.getRankFullname());
                rankObject.setRankName(rankObjectList.getRankName());
                rankObject.setRankOrder(rankObjectList.getRankOrder());
                rankObject.setStatus(rankObjectList.getStatus());
                rankObject.setCreateBy(rankObjectList.getCreateBy());
                rankObject.setCreateDate(rankObjectList.getCreateDate());
                rankObject.setUpdateBy(rankObjectList.getUpdateBy());
                rankObject.setUpdateDate(rankObjectList.getUpdateDate());
                listResponse.add(rankObject);
            }
            /*
             * End developer create object to array new.
             */

        }
        return listResponse;
    }
}
