/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IMemberDeptHistoryViewDAO;
import com.itos.model.ext.MemberDeptHistoryView;
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
@Repository("iMemberDeptHistoryViewDAO")
public class MemberDeptHistoryViewDAO implements IMemberDeptHistoryViewDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final String SQLString = "Select "
            + " ROW_NUMBER() OVER (ORDER BY d.created_date Desc) AS rowId,"
            + " d.created_date, d.fr_mildept_id, d.mildept_id,"
            + " mf.name as fr_mildept_name, mt.name as mildept_name,"
            + " d.approved, isnull(oa.name, o.name) as username, d.cancel ";
    private static final String SQLStringTable = " from MemberDeptHistory d ";
    private static final String SQLStringJoin = " left outer join MilitaryDepartment mf on mf.mildept_id = d.fr_mildept_id"
            + " left outer join MilitaryDepartment mt on mt.mildept_id = d.mildept_id"
            + " left outer join Officer o on d.created_by = o.username"
            + " left outer join Officer oa on d.approved_by = oa.username ";

    @Autowired
    private SessionFactory sessionFactory;

    public JqGridResponse<MemberDeptHistoryView> getList(JqGridRequest req, int memberId) {
        StringBuilder hql = new StringBuilder();
        List<MemberDeptHistoryView> listResponse = new ArrayList<>();
        JqGridResponse<MemberDeptHistoryView> jqGrid = new JqGridResponse<>();
        MemberDeptHistoryView memberDeptHistoryViewObject;
        List<MemberDeptHistoryView> list;
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
                hql.append("d.member_id = :memberId ");
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
            query.addEntity(MemberDeptHistoryView.class);
            /*
             * Check array data if true set create object to array new.
             */
            list = query.list();

            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (MemberDeptHistoryView memberDeptHistoryViewObjectList : list) {
                    memberDeptHistoryViewObject = new MemberDeptHistoryView();
                    memberDeptHistoryViewObject.setRowId(memberDeptHistoryViewObjectList.getRowId());
                    memberDeptHistoryViewObject.setCreatedDate(memberDeptHistoryViewObjectList.getCreatedDate());
                    memberDeptHistoryViewObject.setFrMildeptId(memberDeptHistoryViewObjectList.getFrMildeptId());
                    memberDeptHistoryViewObject.setMildeptId(memberDeptHistoryViewObjectList.getMildeptId());
                    memberDeptHistoryViewObject.setApproved(memberDeptHistoryViewObjectList.getApproved());
                    memberDeptHistoryViewObject.setCancel(memberDeptHistoryViewObjectList.getCancel());
                    memberDeptHistoryViewObject.setUsername(memberDeptHistoryViewObjectList.getUsername());
                    memberDeptHistoryViewObject.setFrMildeptName(memberDeptHistoryViewObjectList.getFrMildeptName());
                    memberDeptHistoryViewObject.setMildeptName(memberDeptHistoryViewObjectList.getMildeptName());

                    listResponse.add(memberDeptHistoryViewObject);
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
