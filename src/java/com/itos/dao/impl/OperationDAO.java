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
@Repository("iOperationDAO")
public class OperationDAO implements IOperationDAO {

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
        List<WhereField> listWhereField = new ArrayList();
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
        List<WhereField> listWhereField = new ArrayList();
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
}
