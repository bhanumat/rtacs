/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.ITitleDAO;
import com.itos.model.Title;
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
@Repository("iTitleDAO")
public class TitleDAO implements ITitleDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private final String objectTable = "Title";

    @Override
    public JqGridResponse<Title> getList(JqGridRequest req) {
        List<Title> listResponse = new ArrayList<>();
        JqGridResponse<Title> jqGrid = new JqGridResponse<>();
        Title titleObject;
        List<Title> list;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Title");

        Paging paging = CommandQuery.CountRows(sessionFactory, req, objectTable);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, objectTable, paging);
        /*
         * Check array data if true set create object to array new.
         */
        list = query.list();
        if (!list.isEmpty()) {

            /*
             * Start developer create object to array new.
             */
            for (Title titleObjectList : list) {
                titleObject = new Title();
                titleObject.setTitleId(titleObjectList.getTitleId());
                titleObject.setTitle(titleObjectList.getTitle());
                titleObject.setTitleDesc(titleObjectList.getTitleDesc());
                titleObject.setCreateBy(titleObjectList.getCreateBy());
                titleObject.setCreateDate(titleObjectList.getCreateDate());
                titleObject.setStatus(titleObjectList.getStatus());
                titleObject.setUpdateBy(titleObjectList.getUpdateBy());
                titleObject.setUpdateDate(titleObjectList.getUpdateDate());
                listResponse.add(titleObject);
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
    public MessageResponse setDeleteTitle(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        Title titleOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            titleOriginal = new Title();
            titleOriginal = (Title) CommandQuery.LoadDetail(sessionFactory, Title.class, Integer.parseInt(id));
            if (CommandQuery.Delete(sessionFactory, titleOriginal)) {
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
    public MessageResponse setSaveNewTitle(Title title) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        chekSuccess = CommandQuery.Insert(sessionFactory, title);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(title.getTitleId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditTitle(Title title) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        Title titleOriginal = (Title) CommandQuery.LoadDetail(sessionFactory, Title.class, title.getTitleId());
        titleOriginal.setTitleDesc(title.getTitleDesc());
        titleOriginal.setTitle(title.getTitle());
        titleOriginal.setStatus(title.getStatus());
        titleOriginal.setUpdateBy(title.getUpdateBy());
        titleOriginal.setUpdateDate(title.getUpdateDate());
        chekSuccess = CommandQuery.Update(sessionFactory, titleOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(title.getTitleId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public Title getLoadTitle(Title title) {
        Title groupResponse = getLoadDetailByObject(title);
        return groupResponse;
    }

    private Title getLoadDetailByObject(Title title) {
        Title titleResponse = new Title();
        List<WhereField> listWhereField = new ArrayList<>();
        List<Title> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("titleId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(title.getTitleId());
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
            list = query.list();
            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (Title titleObjectList : list) {
                    titleResponse = new Title();
                    titleResponse.setTitleId(titleObjectList.getTitleId());
                    titleResponse.setTitle(titleObjectList.getTitle());
                    titleResponse.setTitleDesc(titleObjectList.getTitleDesc());
                    titleResponse.setCreateBy(titleObjectList.getCreateBy());
                    titleResponse.setCreateDate(titleObjectList.getCreateDate());
                    titleResponse.setStatus(titleObjectList.getStatus());
                    titleResponse.setUpdateBy(titleObjectList.getUpdateBy());
                    titleResponse.setUpdateDate(titleObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return titleResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Title getLoadDetailById(Title groups) {
        Title titleResponse = null;
        List<WhereField> listWhereField = new ArrayList<>();
        List<Title> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("titleId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(groups.getTitleId());
            listWhereField.add(whereField);

            Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField, 0, 1);
            /*
             * Check array data if true set create object to array new.
             */
            list = query.list();
            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (Title titleObjectList : list) {
                    titleResponse = new Title();
                    titleResponse.setTitleId(titleObjectList.getTitleId());
                    titleResponse.setTitle(titleObjectList.getTitle());
                    titleResponse.setTitleDesc(titleObjectList.getTitleDesc());
                    titleResponse.setCreateBy(titleObjectList.getCreateBy());
                    titleResponse.setCreateDate(titleObjectList.getCreateDate());
                    titleResponse.setStatus(titleObjectList.getStatus());
                    titleResponse.setUpdateBy(titleObjectList.getUpdateBy());
                    titleResponse.setUpdateDate(titleObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return titleResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Title> getListInJSONTitle(char status) {
        List<Title> listResponse = new ArrayList<>();
        List<Title> list;
        Title titleObject;
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
        list = query.list();
        if (!list.isEmpty()) {

            /*
             * Start developer create object to array new.
             */
            for (Title titleObjectList : list) {
                titleObject = new Title();
                titleObject.setTitleId(titleObjectList.getTitleId());
                titleObject.setTitle(titleObjectList.getTitle());
                titleObject.setTitleDesc(titleObjectList.getTitleDesc());
                titleObject.setCreateBy(titleObjectList.getCreateBy());
                titleObject.setCreateDate(titleObjectList.getCreateDate());
                titleObject.setStatus(titleObjectList.getStatus());
                titleObject.setUpdateBy(titleObjectList.getUpdateBy());
                titleObject.setUpdateDate(titleObjectList.getUpdateDate());
                listResponse.add(titleObject);
            }
            /*
             * End developer create object to array new.
             */

        }
        return listResponse;
    }
}
