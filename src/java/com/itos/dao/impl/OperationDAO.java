/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IOperationDAO;
import com.itos.model.Member;
import com.itos.model.Operation;
import com.itos.model.OperationMember;
import com.itos.util.ConstantsMessage;
import com.itos.util.DateUtil;
import com.itos.util.Hibernate.CommandConstant;
import com.itos.util.Hibernate.CommandQuery;
import com.itos.util.Hibernate.WhereField;
import com.itos.util.jqGrid.Condition;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.JqGridResponse;
import com.itos.util.jqGrid.Paging;
import com.itos.util.jqGrid.Search;
import com.itos.util.jsonObject.MessageRequest;
import com.itos.util.jsonObject.MessageResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITOS
 */
@Repository("iOperationDAO")
public class OperationDAO implements IOperationDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy", ENG_LOCALE);
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", ENG_LOCALE);

    @Autowired
    private SessionFactory sessionFactory;
    private final String objectTable = "Operation";

    @Override
    public JqGridResponse<Operation> getList(JqGridRequest req) {
        List<Operation> listResponse = new ArrayList<>();
        JqGridResponse<Operation> jqGrid = new JqGridResponse<>();
        Operation operationObject;
        List<Operation> list;

        Paging paging = CommandQuery.CountRows(sessionFactory, req, objectTable);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, objectTable, paging);

        if (!query.list().isEmpty()) {
            list = query.list();

            for (Operation operationObjectList : list) {
                operationObject = new Operation();
                operationObject.setAmount(operationObjectList.getAmount());
                operationObject.setApprovalDate(operationObjectList.getApprovalDate());
                operationObject.setCancelDate(operationObjectList.getCancelDate());
                operationObject.setCancelBy(operationObjectList.getCancelBy());
                operationObject.setCreateDate(operationObjectList.getCreateDate());
                operationObject.setDocCode(operationObjectList.getDocCode());
                operationObject.setDocDate(operationObjectList.getDocDate());
                operationObject.setCreateBy(operationObjectList.getCreateBy());
                operationObject.setOperationId(operationObjectList.getOperationId());
                operationObject.setOperationTypeCode(operationObjectList.getOperationTypeCode());
                operationObject.setPrintedStatus(operationObjectList.getPrintedStatus());
                operationObject.setRemark(operationObjectList.getRemark());
                operationObject.setOperationMembers(null);
                operationObject.setMemberNo(operationObjectList.getMemberNo());
                listResponse.add(operationObject);
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
    public MessageResponse setDeleteOperation(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        Operation operationOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            operationOriginal = new Operation();
            operationOriginal = (Operation) CommandQuery.LoadDetail(sessionFactory, Operation.class, Integer.parseInt(id));
            if (CommandQuery.Delete(sessionFactory, operationOriginal)) {
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
    public Operation saveNewOperation(Operation operation) {
        CommandQuery.Insert(sessionFactory, operation);

        return operation;
    }

    @Override
    public MessageResponse setSaveNewOperation(Operation operation) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        chekSuccess = CommandQuery.Insert(sessionFactory, operation);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(operation.getOperationId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditOperation(Operation operation) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        Operation operationOriginal = (Operation) CommandQuery.LoadDetail(sessionFactory, Operation.class, operation.getOperationId());
        operationOriginal.setAmount(operation.getAmount());
        operationOriginal.setApprovalDate(operation.getApprovalDate());
        operationOriginal.setCancelDate(operation.getCancelDate());
        operationOriginal.setCancelBy(operationOriginal.getCancelBy());
        operationOriginal.setCreateDate(operation.getCreateDate());
        operationOriginal.setDocCode(operation.getDocCode());
        operationOriginal.setDocDate(operation.getDocDate());
        operationOriginal.setCreateBy(operationOriginal.getCreateBy());
        operationOriginal.setOperationId(operation.getOperationId());
        operationOriginal.setOperationTypeCode(operation.getOperationTypeCode());
        operationOriginal.setPrintedStatus(operation.getPrintedStatus());
        operationOriginal.setRemark(operation.getRemark());
        //operationOriginal.setMemberNo(operation.getMemberNo());
        chekSuccess = CommandQuery.Update(sessionFactory, operationOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(operation.getOperationId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public Operation getLoadOperation(Operation operation) {
        Operation operationResponse = getLoadDetailByObject(operation);
        return operationResponse;
    }

    private Operation getLoadDetailByObject(Operation operation) {
        Operation operationResponse = new Operation();
        List<WhereField> listWhereField = new ArrayList<>();
        List<Operation> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("operationId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(operation.getOperationId());
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
                for (Operation operationObjectList : list) {
                    operationResponse.setAmount(operationObjectList.getAmount());
                    operationResponse.setApprovalDate(operationObjectList.getApprovalDate());
                    operationResponse.setCancelDate(operationObjectList.getCancelDate());
                    operationResponse.setCancelBy(operationResponse.getCancelBy());
                    operationResponse.setCreateDate(operationObjectList.getCreateDate());
                    operationResponse.setDocCode(operationObjectList.getDocCode());
                    operationResponse.setDocDate(operationObjectList.getDocDate());
                    operationResponse.setCreateBy(operationResponse.getCreateBy());
                    operationResponse.setOperationId(operationObjectList.getOperationId());
                    operationResponse.setOperationTypeCode(operationObjectList.getOperationTypeCode());
                    operationResponse.setPrintedStatus(operationObjectList.getPrintedStatus());
                    operationResponse.setRemark(operationObjectList.getRemark());
                    //operationResponse.setMemberNo(operation.getMemberNo());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return operationResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Operation getLoadDetailById(Operation operation) {
        Operation operationResponse = null;
        List<WhereField> listWhereField = new ArrayList<>();
        List<Operation> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("operationId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(operation.getOperationId());
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
                for (Operation operationObjectList : list) {
                    operationResponse.setAmount(operationObjectList.getAmount());
                    operationResponse.setApprovalDate(operationObjectList.getApprovalDate());
                    operationResponse.setCancelDate(operationObjectList.getCancelDate());
                    operationResponse.setCancelBy(operationResponse.getCancelBy());
                    operationResponse.setCreateDate(operationObjectList.getCreateDate());
                    operationResponse.setDocCode(operationObjectList.getDocCode());
                    operationResponse.setDocDate(operationObjectList.getDocDate());
                    operationResponse.setCreateBy(operationResponse.getCreateBy());
                    operationResponse.setOperationId(operationObjectList.getOperationId());
                    operationResponse.setOperationTypeCode(operationObjectList.getOperationTypeCode());
                    operationResponse.setPrintedStatus(operationObjectList.getPrintedStatus());
                    operationResponse.setRemark(operationObjectList.getRemark());
                    //operationResponse.setMemberNo(operation.getMemberNo());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return operationResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Operation> getListInJSONOperation(char status) {
        List<Operation> listResponse = new ArrayList<>();
        List<Operation> list;
        Operation operationObject;
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");
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

        Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);
        /*
         * Check array data if true set create object to array new.
         */
        if (!query.list().isEmpty()) {
            list = query.list();

            /*
             * Start developer create object to array new.
             */
            for (Operation operationObjectList : list) {
                operationObject = new Operation();
                operationObject.setAmount(operationObjectList.getAmount());
                operationObject.setApprovalDate(operationObjectList.getApprovalDate());
                operationObject.setCancelDate(operationObjectList.getCancelDate());
                operationObject.setCancelBy(operationObject.getCancelBy());
                operationObject.setCreateDate(operationObjectList.getCreateDate());
                operationObject.setDocCode(operationObjectList.getDocCode());
                operationObject.setDocDate(operationObjectList.getDocDate());
                operationObject.setCreateBy(operationObject.getCreateBy());
                operationObject.setOperationId(operationObjectList.getOperationId());
                operationObject.setOperationTypeCode(operationObjectList.getOperationTypeCode());
                operationObject.setPrintedStatus(operationObjectList.getPrintedStatus());
                operationObject.setRemark(operationObjectList.getRemark());
                //operationObject.setMemberNo(operationObjectList.getMemberNo());
                listResponse.add(operationObject);
            }
            /*
             * End developer create object to array new.
             */

        }
        return listResponse;
    }

    @Override
    public MessageResponse setSaveNewOperationList(Operation operationPost) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        Member member = null;
        OperationMember operationMember = null;
        Operation operation = new Operation();
        boolean chekSuccess = false;
        operation.setDocCode(operationPost.getDocCode());
        operation.setDocDate(operationPost.getDocDate());
        if (CommandQuery.Insert(sessionFactory, operation)) {
            for (Integer id : operationPost.getItemSelect()) {

                operationMember = new OperationMember();
                operationMember.setOperation(operation);
                member = new Member();
                member.setMemberId(id);
                operationMember.setMember(member);
                if (CommandQuery.Insert(sessionFactory, operationMember)) {
                    iCountSuccessful++;
                }
                /*
                 operationOriginal = new Operation();
                 operationOriginal = (Operation) CommandQuery.LoadDetail(sessionFactory, Operation.class, Integer.parseInt(id));
                 if (CommandQuery.Delete(sessionFactory, operationOriginal)) {
                 iCountSuccessful++;
                 }*/
            }
        }
        if (iCountSuccessful == (operationPost.getItemSelect().size())) {
            response.setCheckSuccess(true);
        } else {
            response.setCheckSuccess(false);
        }
        chekSuccess = response.getCheckSuccess();
        if (chekSuccess) {
            response.setId("");
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public JqGridResponse<Operation> getListAPP041(JqGridRequest req) {
        List<Operation> listResponse = new ArrayList<>();
        JqGridResponse<Operation> jqGrid = new JqGridResponse<>();
        Operation operationObject;
        List<Operation> list;
        StringBuilder hqlSearch = new StringBuilder();
        StringBuilder hql = new StringBuilder();

        hqlSearch.append(CommandConstant.CountRows);
        hqlSearch.append(" ");

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);
        hql.append(" ");
        hql.append(CommandConstant.QueryWhere);
        hql.append(" operation_type_code = 25 ");

        if (req.isSearch()) {
            Search search = Search.JSONDeserializer(req.getSearchCommand());
            for (Condition condition : search.getConditions()) {
                if (condition.getField().equalsIgnoreCase("docCode")
                        || condition.getField().equalsIgnoreCase("docDate")) {

                    if (CommandConstant.DataTypeDate.equalsIgnoreCase(condition.getDataType())) {
                        String[] tempDate = condition.getData().split(",");
                        String beginDate = "";
                        String endDate = "";
                        if (tempDate.length < 2 && CommandConstant.QueryBetween.equalsIgnoreCase(condition.getOp())) {
                            beginDate = formatDate(tempDate[0]);
                            endDate = formatDate("");
                        } else {
                            beginDate = formatDate(tempDate[0]);
                            endDate = formatDate(tempDate[1]);
                        }
                        hql.append(" and doc_date");
                        hql.append(" between ");
                        hql.append(" \'").append(beginDate).append("\' ");
                        hql.append(" and \'").append(endDate).append("\' ");
                    }
                    if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                        hql.append(" and doc_code");
                        hql.append(" = \'").append(condition.getData()).append("\' ");
                    }

                }//search operation
            }
        }
        hqlSearch.append(hql);
        Paging paging = CommandQuery.queryCountRows(sessionFactory, req, hqlSearch);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, paging, hql);

        if (!query.list().isEmpty()) {
            list = query.list();

            for (Operation operationObjectList : list) {
                operationObject = new Operation();
                operationObject.setAmount(operationObjectList.getAmount());
                operationObject.setApprovalDate(operationObjectList.getApprovalDate());
                operationObject.setCancelDate(operationObjectList.getCancelDate());
                operationObject.setCancelBy(operationObjectList.getCancelBy());
                operationObject.setCreateDate(operationObjectList.getCreateDate());
                operationObject.setDocCode(operationObjectList.getDocCode());
                operationObject.setDocDate(operationObjectList.getDocDate());
                operationObject.setCreateBy(operationObjectList.getCreateBy());
                operationObject.setOperationId(operationObjectList.getOperationId());
                operationObject.setOperationTypeCode(operationObjectList.getOperationTypeCode());
                operationObject.setPrintedStatus(operationObjectList.getPrintedStatus());
                operationObject.setRemark(operationObjectList.getRemark());
                operationObject.setOperationMembers(null);
                operationObject.setMemberNo(operationObjectList.getMemberNo());
                listResponse.add(operationObject);
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

    public JqGridResponse<Operation> getListAPP031(JqGridRequest req) {
        List<Operation> listResponse = new ArrayList<>();
        JqGridResponse<Operation> jqGrid = new JqGridResponse<>();
        Operation operationObject;
        List<Operation> list;
        StringBuilder hqlSearch = new StringBuilder();
        StringBuilder hql = new StringBuilder();

        hqlSearch.append(CommandConstant.CountRows);
        hqlSearch.append(" ");

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);
        hql.append(" ");
        hql.append(CommandConstant.QueryWhere);
        hql.append(" operation_type_code = 13 ");

        if (req.isSearch()) {
            Search search = Search.JSONDeserializer(req.getSearchCommand());
            for (Condition condition : search.getConditions()) {
                if (condition.getField().equalsIgnoreCase("docCode")
                        || condition.getField().equalsIgnoreCase("docDate")) {

                    if (CommandConstant.DataTypeDate.equalsIgnoreCase(condition.getDataType())) {
                        String[] tempDate = condition.getData().split(",");
                        String beginDate = "";
                        String endDate = "";
                        if (tempDate.length < 2 && CommandConstant.QueryBetween.equalsIgnoreCase(condition.getOp())) {
                            beginDate = formatDate(tempDate[0]);
                            endDate = formatDate("");
                        } else {
                            beginDate = formatDate(tempDate[0]);
                            endDate = formatDate(tempDate[1]);
                        }
                        hql.append(" and doc_date");
                        hql.append(" between ");
                        hql.append(" \'").append(beginDate).append("\' ");
                        hql.append(" and \'").append(endDate).append("\' ");
                    }
                    if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                        hql.append(" and doc_code");
                        hql.append(" = \'").append(condition.getData()).append("\' ");
                    }

                }//search operation
            }
        }
        hqlSearch.append(hql);
        Paging paging = CommandQuery.queryCountRows(sessionFactory, req, hqlSearch);
        Query query = CommandQuery.CreateQuery(sessionFactory, req, paging, hql);

        if (!query.list().isEmpty()) {
            list = query.list();

            for (Operation operationObjectList : list) {
                operationObject = new Operation();
                operationObject.setAmount(operationObjectList.getAmount());
                operationObject.setApprovalDate(operationObjectList.getApprovalDate());
                operationObject.setCancelDate(operationObjectList.getCancelDate());
                operationObject.setCancelBy(operationObjectList.getCancelBy());
                operationObject.setCreateDate(operationObjectList.getCreateDate());
                operationObject.setDocCode(operationObjectList.getDocCode());
                operationObject.setDocDate(operationObjectList.getDocDate());
                operationObject.setCreateBy(operationObjectList.getCreateBy());
                operationObject.setOperationId(operationObjectList.getOperationId());
                operationObject.setOperationTypeCode(operationObjectList.getOperationTypeCode());
                operationObject.setPrintedStatus(operationObjectList.getPrintedStatus());
                operationObject.setRemark(operationObjectList.getRemark());
                operationObject.setOperationMembers(null);
                operationObject.setMemberNo(operationObjectList.getMemberNo());
                listResponse.add(operationObject);
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
    public JqGridResponse<Operation> getList(JqGridRequest req, int operationTypeCode) {
        List<Operation> listResponse = new ArrayList<>();
        JqGridResponse<Operation> jqGrid = new JqGridResponse<>();
        Operation operationObject;
        List<Operation> list;
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;

        whereField = new WhereField();
        whereField.setSearchField("operationTypeCode");
        whereField.setSearchLogic("");
        whereField.setSearchOper(CommandConstant.QueryEqual);
        whereField.setSearchValue(operationTypeCode);
        whereField.setSearchDataType(CommandConstant.DataTypeInteger);
        listWhereField.add(whereField);

        Paging paging = CommandQuery.CountRows(sessionFactory, listWhereField, CommandConstant.QueryAND, req, objectTable);
        Query query = CommandQuery.CreateQuery(sessionFactory, listWhereField, CommandConstant.QueryAND, req, objectTable, paging);

        if (!query.list().isEmpty()) {
            list = query.list();

            for (Operation operationObjectList : list) {
                operationObject = new Operation();
                operationObject.setAmount(operationObjectList.getAmount());
                operationObject.setApprovalDate(operationObjectList.getApprovalDate());
                operationObject.setCancelDate(operationObjectList.getCancelDate());
                operationObject.setCancelBy(operationObjectList.getCancelBy());
                operationObject.setCreateDate(operationObjectList.getCreateDate());
                operationObject.setDocCode(operationObjectList.getDocCode());
                operationObject.setDocDate(operationObjectList.getDocDate());
                operationObject.setCreateBy(operationObjectList.getCreateBy());
                operationObject.setOperationId(operationObjectList.getOperationId());
                operationObject.setOperationTypeCode(operationObjectList.getOperationTypeCode());
                operationObject.setPrintedStatus(operationObjectList.getPrintedStatus());
                operationObject.setRemark(operationObjectList.getRemark());
                operationObject.setOperationMembers(null);
                operationObject.setMemberNo(operationObjectList.getMemberNo());
                listResponse.add(operationObject);
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

    private String formatDate(String date) {

        if (date.isEmpty()) {
            Date currentDate = DateUtil.getCurrentDate();
            String result = format.format(currentDate);
            return result;
        }
        try {
            Date tempDate = sf.parse(date);
            String result = format.format(tempDate);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    private Member getLoadMember(Member member) {
        logger.info("OperationDAO : getLoadMember");
        Member memberObject = getLoadDetailByObject(member);
        Member memberResponse = new Member();
        memberResponse.setAccTypeId(memberObject.getAccTypeId());
        memberResponse.setAccTypeName(memberObject.getAccTypeName());
        memberResponse.setAddress(memberObject.getAddress());
        memberResponse.setAddressPrimary(memberObject.getAddressPrimary());
        memberResponse.setApplyDate(memberObject.getApplyDate());
        memberResponse.setBankAccName(memberObject.getBankAccName());
        memberResponse.setBankAccNo(memberObject.getBankAccNo());
        memberResponse.setBankBranchId(memberObject.getBankBranchId());
        memberResponse.setBankCode(memberObject.getBankCode());
        memberResponse.setBirthDate(memberObject.getBirthDate());
        memberResponse.setCitizenId(memberObject.getCitizenId());
        memberResponse.setCreateBy(memberObject.getCreateBy());
        memberResponse.setCreateDate(memberObject.getCreateDate());
        memberResponse.setDistrict(memberObject.getDistrict());
        memberResponse.setFax(memberObject.getFax());
        memberResponse.setGender(memberObject.getGender());
        memberResponse.setMarryStatusCode(memberObject.getMarryStatusCode());
        memberResponse.setMemberCode(memberObject.getMemberCode());
        memberResponse.setMemberGroupCode(memberObject.getMemberGroupCode());
        memberResponse.setMemberId(memberObject.getMemberId());
        memberResponse.setMemberStatusCode(memberObject.getMemberStatusCode());
        memberResponse.setMemberTypeCode(memberObject.getMemberTypeCode());
        memberResponse.setMilitaryId(memberObject.getMilitaryId());
        memberResponse.setMilitaryName(memberObject.getMilitaryName());
        memberResponse.setMobile(memberObject.getMobile());
        memberResponse.setMoo(memberObject.getMoo());
        memberResponse.setName(memberObject.getName());
        memberResponse.setPaymentRemark(memberObject.getPaymentRemark());
        memberResponse.setPaymentType(memberObject.getPaymentType());
        memberResponse.setPaymentTypeCode(memberObject.getPaymentTypeCode());
        memberResponse.setPermanentAddress(memberObject.getPermanentAddress());
        memberResponse.setPermanentDistrict(memberObject.getPermanentDistrict());
        memberResponse.setPermanentFax(memberObject.getPermanentFax());
        memberResponse.setPermanentMobile(memberObject.getPermanentMobile());
        memberResponse.setPermanentProvinceCode(memberObject.getPermanentProvinceCode());
        memberResponse.setPermanentProvinceName(memberObject.getPermanentProvinceName());
        memberResponse.setPermanentRoad(memberObject.getPermanentRoad());
        memberResponse.setPermanentSoi(memberObject.getPermanentSoi());
        memberResponse.setPermanentSubdistrict(memberObject.getPermanentSubdistrict());
        memberResponse.setPermanentTel(memberObject.getPermanentTel());
        memberResponse.setPermanentZipcode(memberObject.getPermanentZipcode());
        memberResponse.setProvinceCode(memberObject.getProvinceCode());
        memberResponse.setProvinceName(memberObject.getProvinceName());
        memberResponse.setTitleId(memberObject.getTitleId());
        memberResponse.setRankId(memberObject.getRankId());
        memberResponse.setRankOrTitleName(null != memberObject.getRankId() ? memberObject.getRankName() : memberObject.getTitleName());
        memberResponse.setReferrerId(memberObject.getReferrerId());
        memberResponse.setReferrerRelationshipCode(memberObject.getReferrerRelationshipCode());
        memberResponse.setRemark(memberObject.getRemark());
        memberResponse.setRoad(memberObject.getRoad());
        memberResponse.setSoi(memberObject.getSoi());
        memberResponse.setSubdistrict(memberObject.getSubdistrict());
        memberResponse.setSurname(memberObject.getSurname());
        memberResponse.setTel(memberObject.getTel());
        memberResponse.setUpdateBy(memberObject.getUpdateBy());
        memberResponse.setUpdateDate(memberObject.getUpdateDate());
        memberResponse.setWifehusbandFullname(memberObject.getWifehusbandFullname());
        memberResponse.setZipcode(memberObject.getZipcode());
        memberResponse.setPermanentMoo(memberObject.getPermanentMoo());
        return memberResponse;
    }

    private Member getLoadDetailByObject(Member member) {
        logger.info("MemberDAO : getLoadDetailByObject");
        Member memberResponse = new Member();
        List<WhereField> listWhereField = new ArrayList();
        List<Member> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("memberId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(member.getMemberId());
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
                for (Member memberObjectList : list) {
                    memberResponse = new Member();
                    memberResponse.setAccTypeId(memberObjectList.getAccTypeId());
                    memberResponse.setAccTypeName(memberObjectList.getAccTypeName());
                    memberResponse.setAddress(memberObjectList.getAddress());
                    memberResponse.setAddressPrimary(memberObjectList.getAddressPrimary());
                    memberResponse.setApplyDate(memberObjectList.getApplyDate());
                    memberResponse.setBankAccName(memberObjectList.getBankAccName());
                    memberResponse.setBankAccNo(memberObjectList.getBankAccNo());
                    memberResponse.setBankBranchId(memberObjectList.getBankBranchId());
                    memberResponse.setBankCode(memberObjectList.getBankCode());
                    memberResponse.setBirthDate(memberObjectList.getBirthDate());
                    memberResponse.setCitizenId(memberObjectList.getCitizenId());
                    memberResponse.setCreateBy(memberObjectList.getCreateBy());
                    memberResponse.setCreateDate(memberObjectList.getCreateDate());
                    memberResponse.setDistrict(memberObjectList.getDistrict());
                    memberResponse.setFax(memberObjectList.getFax());
                    memberResponse.setGender(memberObjectList.getGender());
                    memberResponse.setMarryStatusCode(memberObjectList.getMarryStatusCode());
                    memberResponse.setMemberCode(memberObjectList.getMemberCode());
                    memberResponse.setMemberGroupCode(memberObjectList.getMemberGroupCode());
                    memberResponse.setMemberId(memberObjectList.getMemberId());
                    memberResponse.setMemberStatusCode(memberObjectList.getMemberStatusCode());
                    memberResponse.setMemberTypeCode(memberObjectList.getMemberTypeCode());
                    memberResponse.setMilitaryId(memberObjectList.getMilitaryId());
                    memberResponse.setMilitaryName(memberObjectList.getMilitaryName());
                    memberResponse.setMobile(memberObjectList.getMobile());
                    memberResponse.setMoo(memberObjectList.getMoo());
                    memberResponse.setName(memberObjectList.getName());
                    memberResponse.setPaymentRemark(memberObjectList.getPaymentRemark());
                    memberResponse.setPaymentType(memberObjectList.getPaymentType());
                    memberResponse.setPaymentTypeCode(memberObjectList.getPaymentTypeCode());
                    memberResponse.setPermanentAddress(memberObjectList.getPermanentAddress());
                    memberResponse.setPermanentDistrict(memberObjectList.getPermanentDistrict());
                    memberResponse.setPermanentFax(memberObjectList.getPermanentFax());
                    memberResponse.setPermanentMobile(memberObjectList.getPermanentMobile());
                    memberResponse.setPermanentProvinceCode(memberObjectList.getPermanentProvinceCode());
                    memberResponse.setPermanentProvinceName(memberObjectList.getPermanentProvinceName());
                    memberResponse.setPermanentRoad(memberObjectList.getPermanentRoad());
                    memberResponse.setPermanentSoi(memberObjectList.getPermanentSoi());
                    memberResponse.setPermanentSubdistrict(memberObjectList.getPermanentSubdistrict());
                    memberResponse.setPermanentTel(memberObjectList.getPermanentTel());
                    memberResponse.setPermanentZipcode(memberObjectList.getPermanentZipcode());
                    memberResponse.setProvinceCode(memberObjectList.getProvinceCode());
                    memberResponse.setProvinceName(memberObjectList.getProvinceName());
                    memberResponse.setTitleId(memberObjectList.getTitleId());
                    memberResponse.setRankId(memberObjectList.getRankId());
                    memberResponse.setRankOrTitleName(null != memberObjectList.getRankId() ? memberObjectList.getRankName() : memberObjectList.getTitleName());
                    memberResponse.setReferrerId(memberObjectList.getReferrerId());
                    memberResponse.setReferrerRelationshipCode(memberObjectList.getReferrerRelationshipCode());
                    memberResponse.setRemark(memberObjectList.getRemark());
                    memberResponse.setRoad(memberObjectList.getRoad());
                    memberResponse.setSoi(memberObjectList.getSoi());
                    memberResponse.setSubdistrict(memberObjectList.getSubdistrict());
                    memberResponse.setSurname(memberObjectList.getSurname());
                    memberResponse.setTel(memberObjectList.getTel());
                    memberResponse.setUpdateBy(memberObjectList.getUpdateBy());
                    memberResponse.setUpdateDate(memberObjectList.getUpdateDate());
                    memberResponse.setWifehusbandFullname(memberObjectList.getWifehusbandFullname());
                    memberResponse.setZipcode(memberObjectList.getZipcode());
                    memberResponse.setPermanentMoo(memberObjectList.getPermanentMoo());
                    memberResponse.setMemberBeneficiaries(memberObjectList.getMemberBeneficiaries());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return memberResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }
}
