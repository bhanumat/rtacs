/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IMemberStatusViewDAO;
import com.itos.model.ext.MemberStatusView;
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
@Repository("iMemberStatusViewDAO")
public class MemberStatusViewDAO implements IMemberStatusViewDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final String SQLString = "Select "
            + " ROW_NUMBER() OVER (ORDER BY o.create_date Desc) AS rowId, o.create_date, o.operation_type_code, u.name ";
    private static final String SQLStringTable = " from OperationMember om ";
    private static final String SQLStringJoin = " inner join Operation o on o.operation_id=om.operation_id "
            + " left outer join Officer u on u.username = o.create_by ";

    @Autowired
    private SessionFactory sessionFactory;

    public JqGridResponse<MemberStatusView> getList(JqGridRequest req, int memberId) {
        StringBuilder hql = new StringBuilder();
        List<MemberStatusView> listResponse = new ArrayList<>();
        JqGridResponse<MemberStatusView> jqGrid = new JqGridResponse<>();
        MemberStatusView memberStatusViewObject;
        List<MemberStatusView> list;
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
                hql.append("om.member_id = :memberId ");
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
            query.addEntity(MemberStatusView.class);
            /*
             * Check array data if true set create object to array new.
             */
            list = query.list();

            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (MemberStatusView memberStatusViewObjectList : list) {
                    memberStatusViewObject = new MemberStatusView();
                    memberStatusViewObject.setRowId(memberStatusViewObjectList.getRowId());
                    memberStatusViewObject.setCreateDate(memberStatusViewObjectList.getCreateDate());
                    memberStatusViewObject.setOperationTypeCode(memberStatusViewObjectList.getOperationTypeCode());
                    memberStatusViewObject.setName(memberStatusViewObjectList.getName());

                    listResponse.add(memberStatusViewObject);
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
