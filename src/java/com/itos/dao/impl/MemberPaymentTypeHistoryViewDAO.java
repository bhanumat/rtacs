/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IMemberPaymentTypeHistoryViewDAO;
import com.itos.model.ext.MemberPaymentTypeHistoryView;
import com.itos.util.Hibernate.CommandConstant;
import com.itos.util.Hibernate.CommandQuery;
import com.itos.util.Hibernate.WhereField;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jqGrid.Paging;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITOS
 */
@Repository("iMemberPaymentTypeHistoryViewDAO")
public class MemberPaymentTypeHistoryViewDAO implements IMemberPaymentTypeHistoryViewDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final String SQLString = "Select "
            + " ROW_NUMBER() OVER (ORDER BY m.created_date Desc) AS rowId, m.created_date,"
            + " m.payment_type_code, m.approved, m.change_code, o.name";
    private static final String SQLStringTable = " from MemberPaymentTypeHistory m ";
    private static final String SQLStringJoin = " left outer join Officer o on m.created_by = o.username ";

    @Autowired
    private SessionFactory sessionFactory;

    public JqGridResponse<MemberPaymentTypeHistoryView> getList(JqGridRequest req, int memberId) {
        StringBuilder hql = new StringBuilder();
        List<MemberPaymentTypeHistoryView> listResponse = new ArrayList<>();
        JqGridResponse<MemberPaymentTypeHistoryView> jqGrid = new JqGridResponse<>();
        MemberPaymentTypeHistoryView memberPaymentTypeHistoryViewObject;
        List<MemberPaymentTypeHistoryView> list;
        String where = "";
        boolean control = true;
        /*
         * Command HQL query Data.
         */
//    StringBuilder hql = new StringBuilder();
//    hql.append("From Bank");
        //+ " where "
        //+ " m.member_id = :memberId";
        if (memberId != 0) {
            List<WhereField> listWhereField = new ArrayList<>();
            WhereField whereField = null;
            whereField = new WhereField();
            whereField.setSearchField("memberId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(memberId);
            whereField.setSearchDataType(CommandConstant.DataTypeInteger);
            listWhereField.add(whereField);
            hql.append(SQLStringTable);
            hql.append(SQLStringJoin);
            if (0 != memberId || 0 != memberId) {
                hql.append(" where ");
                hql.append("m.member_id = :memberId ");
                control = false;
            }
            where = CommandQuery.WhereQuery(req, false, "");
            if (!where.isEmpty()) {
                if (!control) {
                    hql.append(" and ");
                }
                hql.append(where);
            }

            StringBuilder hqlCount = new StringBuilder();
            StringBuilder hqlQuery = new StringBuilder();
            hqlCount.append(CommandConstant.CountRows);
            hqlCount.append(hql.toString());
            hqlQuery.append(SQLString);
            hql.append(" ");
            hql.append(CommandConstant.OrderBy);
            hql.append(" ");
            hql.append(req.getSidx());
            hql.append(" ");
            hql.append(req.getSord());
            hqlQuery.append(hql.toString());

            Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, hqlCount);
            SQLQuery query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, paging, hqlQuery);
            query.addEntity(MemberPaymentTypeHistoryView.class);
            /*
             * Check array data if true set create object to array new.
             */
            list = query.list();

            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (MemberPaymentTypeHistoryView memberPaymentTypeHistoryViewObjectList : list) {
                    memberPaymentTypeHistoryViewObject = new MemberPaymentTypeHistoryView();
                    memberPaymentTypeHistoryViewObject.setRowId(memberPaymentTypeHistoryViewObjectList.getRowId());
                    memberPaymentTypeHistoryViewObject.setCreatedDate(memberPaymentTypeHistoryViewObjectList.getCreatedDate());
                    memberPaymentTypeHistoryViewObject.setPaymentTypeCode(memberPaymentTypeHistoryViewObjectList.getPaymentTypeCode());
                    memberPaymentTypeHistoryViewObject.setApproved(memberPaymentTypeHistoryViewObjectList.getApproved());                    
                    memberPaymentTypeHistoryViewObject.setChangeCode(memberPaymentTypeHistoryViewObjectList.getChangeCode());
                    memberPaymentTypeHistoryViewObject.setName(memberPaymentTypeHistoryViewObjectList.getName());
                    listResponse.add(memberPaymentTypeHistoryViewObject);
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
        } else {
            jqGrid.setPage(req.getPage());
            jqGrid.setRecords(0);
            jqGrid.setTotalPages(0);
            jqGrid.setRows(listResponse);
        }
        return jqGrid;
    }
}
