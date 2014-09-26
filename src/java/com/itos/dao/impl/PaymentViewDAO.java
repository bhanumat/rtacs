/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IPaymentViewDAO;
import com.itos.model.ext.PaymentView;
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
@Repository("iPaymentViewDAO")
public class PaymentViewDAO implements IPaymentViewDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final String SQLString = "Select "
            + " ROW_NUMBER() OVER (ORDER BY m.month_code Desc) AS rowId, m.payment_id, "
            + " m.month_code, c.budget_month, c.start_sop_no, c.end_sop_no, "
            + " m.payment_date, m.payment_type_code, m.amount, m.pay_amount, m.over_amount "
            + "	, m.remark, m.reference_id, r.receipt_no, "
            + " m.payment_id, "
            + " isnull(mds.name, md.name) as mildept_name, "
            + " isnull(dso.User_Profile_Code, isnull(dpo.User_Profile_Code, isnull(ro.User_Profile_Code, ''))) as username ";
    private static final String SQLStringTable = " from MemberPayment m ";
    private static final String SQLStringJoin = " join ControlPayment c on c.month_code = m.month_code "
            + " left outer join Receipt r on (m.reference_id = r.receipt_id and "
            + " m.payment_type_code in (20,21)) "
            + " left outer join user_profile ro on ro.User_Profile_Code = r.created_by "
            + " left outer join DeptPayment dp on (m.reference_id = dp.deptpayment_id and "
            + " m.payment_type_code in (10,11)) "
            + " left outer join MilitaryDepartment md on dp.mildept_id = md.mildept_id "
            + " left outer join user_profile dpo on dpo.User_Profile_Code = dp.created_by "
            + " left outer join DeductSent ds on (ds.DeductSentCode = m.DeductSentCode and "
            + " m.payment_type_code = 10) "
            + " left outer join DeductHist dh on dh.BranchCode = ds.BranchCode and dh.ForDate = ds.ForDate "
            + " left outer join MilitaryDepartment mds on mds.mildept_id = dh.BranchCode "
            + " left outer join user_profile dso on dso.User_Profile_Code = dh.CheckedBy "
            + " left outer join user_profile mo on mo.User_Profile_Code = m.created_by ";

    @Autowired
    private SessionFactory sessionFactory;

    public JqGridResponse<PaymentView> getList(JqGridRequest req, int memberId) {
        StringBuilder hql = new StringBuilder();
        List<PaymentView> listResponse = new ArrayList<>();
        JqGridResponse<PaymentView> jqGrid = new JqGridResponse<>();
        PaymentView paymentViewObject;
        List<PaymentView> list;
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
            query.addEntity(PaymentView.class);
            /*
             * Check array data if true set create object to array new.
             */
            list = query.list();

            if (!list.isEmpty()) {

                /*
                 * Start developer create object to array new.
                 */
                for (PaymentView paymentViewObjectList : list) {
                    paymentViewObject = new PaymentView();
                    paymentViewObject.setRowId(paymentViewObjectList.getRowId());
                    paymentViewObject.setPaymentId(paymentViewObjectList.getPaymentId());
                    paymentViewObject.setMonthCode(paymentViewObjectList.getMonthCode());
                    paymentViewObject.setBudgetMonth(paymentViewObjectList.getBudgetMonth());
                    paymentViewObject.setStartSopNo(paymentViewObjectList.getStartSopNo());
                    paymentViewObject.setEndSopNo(paymentViewObjectList.getEndSopNo());
                    paymentViewObject.setPaymentDate(paymentViewObjectList.getPaymentDate());
                    paymentViewObject.setPaymentTypeCode(paymentViewObjectList.getPaymentTypeCode());
                    paymentViewObject.setReferenceId(paymentViewObjectList.getReferenceId());
                    paymentViewObject.setPayAmount(paymentViewObjectList.getPayAmount());
                    paymentViewObject.setAmount(paymentViewObjectList.getAmount());
                    paymentViewObject.setOverAmount(paymentViewObjectList.getOverAmount());
                    paymentViewObject.setRemark(paymentViewObjectList.getRemark());
                    paymentViewObject.setReceiptNo(paymentViewObjectList.getReceiptNo());
                    paymentViewObject.setMildeptName(paymentViewObjectList.getMildeptName());
                    paymentViewObject.setUsername(paymentViewObjectList.getUsername());

                    listResponse.add(paymentViewObject);
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
