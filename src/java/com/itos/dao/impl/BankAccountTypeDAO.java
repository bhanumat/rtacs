/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IBankAccountTypeDAO;
import com.itos.dao.model.IBankDAO;
import com.itos.model.Bank;
import com.itos.model.BankAccountType;
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
@Repository("iBankAccountTypeDAO")
public class BankAccountTypeDAO implements IBankAccountTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    IBankDAO iBankDAO;

    private final String objectTable = "BankAccountType";
    private final String objectTableBank = "Bank";

    @Override
    public JqGridResponse<BankAccountType> getList(JqGridRequest req) {
        List<BankAccountType> listResponse = new ArrayList<>();
        JqGridResponse<BankAccountType> jqGrid = new JqGridResponse<>();
        BankAccountType bankAccountTypeObject;
        List<BankAccountType> list;
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
            for (BankAccountType bankAccountTypeObjectList : list) {
                bankAccountTypeObject = new BankAccountType();
                bankAccountTypeObject.setAccTypeId(bankAccountTypeObjectList.getAccTypeId());
                bankAccountTypeObject.setBankCode(bankAccountTypeObjectList.getBankCode());
                bankAccountTypeObject.setBankName(bankAccountTypeObjectList.getBankName());
                bankAccountTypeObject.setAccTypeName(bankAccountTypeObjectList.getAccTypeName());
                bankAccountTypeObject.setCreateBy(bankAccountTypeObjectList.getCreateBy());
                bankAccountTypeObject.setCreateDate(bankAccountTypeObjectList.getCreateDate());
                bankAccountTypeObject.setStatus(bankAccountTypeObjectList.getStatus());
                bankAccountTypeObject.setUpdateBy(bankAccountTypeObjectList.getUpdateBy());
                bankAccountTypeObject.setUpdateDate(bankAccountTypeObjectList.getUpdateDate());
                listResponse.add(bankAccountTypeObject);
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
    public MessageResponse setDeleteBankAccountType(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        BankAccountType bankAccountTypeOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            bankAccountTypeOriginal = new BankAccountType();
            bankAccountTypeOriginal = (BankAccountType) CommandQuery.LoadDetail(sessionFactory, BankAccountType.class, Integer.parseInt(id));
            if (CommandQuery.Delete(sessionFactory, bankAccountTypeOriginal)) {
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
    public MessageResponse setSaveNewBankAccountType(BankAccountType bankAccountType) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;        
        chekSuccess = CommandQuery.Insert(sessionFactory, bankAccountType);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(bankAccountType.getAccTypeId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditBankAccountType(BankAccountType bankAccountType) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        BankAccountType bankAccountTypeOriginal = (BankAccountType) CommandQuery.LoadDetail(sessionFactory, BankAccountType.class, bankAccountType.getAccTypeId());
        bankAccountTypeOriginal.setBank(bankAccountType.getBank());
        bankAccountTypeOriginal.setAccTypeName(bankAccountType.getAccTypeName());
        bankAccountTypeOriginal.setStatus(bankAccountType.getStatus());
        bankAccountTypeOriginal.setUpdateBy(bankAccountType.getUpdateBy());
        bankAccountTypeOriginal.setUpdateDate(bankAccountType.getUpdateDate());
        chekSuccess = CommandQuery.Update(sessionFactory, bankAccountTypeOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(bankAccountType.getAccTypeId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public BankAccountType getLoadBankAccountType(BankAccountType bankAccountType) {
        BankAccountType bankAccountTypeResponse = getLoadDetailByObject(bankAccountType);
        BankAccountType bankAccountTypeObject = new BankAccountType();
        bankAccountTypeObject.setAccTypeId(bankAccountTypeResponse.getAccTypeId());
        bankAccountTypeObject.setBankCode(bankAccountTypeResponse.getBankCode());
        bankAccountTypeObject.setBankName(bankAccountTypeResponse.getBankName());
        bankAccountTypeObject.setAccTypeName(bankAccountTypeResponse.getAccTypeName());
        bankAccountTypeObject.setCreateBy(bankAccountTypeResponse.getCreateBy());
        bankAccountTypeObject.setCreateDate(bankAccountTypeResponse.getCreateDate());
        bankAccountTypeObject.setStatus(bankAccountTypeResponse.getStatus());
        bankAccountTypeObject.setUpdateBy(bankAccountTypeResponse.getUpdateBy());
        bankAccountTypeObject.setUpdateDate(bankAccountTypeResponse.getUpdateDate());
        return bankAccountTypeObject;
    }

    private BankAccountType getLoadDetailByObject(BankAccountType bankAccountType) {
        BankAccountType bankAccountTypeResponse = new BankAccountType();
        List<WhereField> listWhereField = new ArrayList<>();
        List<BankAccountType> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("accTypeId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(bankAccountType.getAccTypeId());
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
                for (BankAccountType bankAccountTypeObjectList : list) {
                    bankAccountTypeResponse = new BankAccountType();
                    bankAccountTypeResponse.setAccTypeId(bankAccountTypeObjectList.getAccTypeId());
                    bankAccountTypeResponse.setBank(bankAccountTypeObjectList.getBank());
                    bankAccountTypeResponse.setAccTypeName(bankAccountTypeObjectList.getAccTypeName());
                    bankAccountTypeResponse.setCreateBy(bankAccountTypeObjectList.getCreateBy());
                    bankAccountTypeResponse.setCreateDate(bankAccountTypeObjectList.getCreateDate());
                    bankAccountTypeResponse.setStatus(bankAccountTypeObjectList.getStatus());
                    bankAccountTypeResponse.setUpdateBy(bankAccountTypeObjectList.getUpdateBy());
                    bankAccountTypeResponse.setUpdateDate(bankAccountTypeObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return bankAccountTypeResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private BankAccountType getLoadDetailById(BankAccountType bankAccountType) {
        BankAccountType bankAccountTypeResponse = null;
        List<WhereField> listWhereField = new ArrayList<>();
        List<BankAccountType> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("accTypeId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(bankAccountType.getAccTypeId());
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
                for (BankAccountType bankAccountTypeObjectList : list) {
                    bankAccountTypeResponse = new BankAccountType();
                    bankAccountTypeResponse.setAccTypeId(bankAccountTypeObjectList.getAccTypeId());
                    bankAccountTypeResponse.setBank(bankAccountTypeObjectList.getBank());
                    bankAccountTypeResponse.setAccTypeName(bankAccountTypeObjectList.getAccTypeName());
                    bankAccountTypeResponse.setCreateBy(bankAccountTypeObjectList.getCreateBy());
                    bankAccountTypeResponse.setCreateDate(bankAccountTypeObjectList.getCreateDate());
                    bankAccountTypeResponse.setStatus(bankAccountTypeObjectList.getStatus());
                    bankAccountTypeResponse.setUpdateBy(bankAccountTypeObjectList.getUpdateBy());
                    bankAccountTypeResponse.setUpdateDate(bankAccountTypeObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return bankAccountTypeResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<BankAccountType> getListInJSONBankAccountType(char status) {
        List<BankAccountType> listResponse = new ArrayList<>();
        List<BankAccountType> list;
        BankAccountType bankAccountTypeObject;
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
            for (BankAccountType bankAccountTypeObjectList : list) {
                bankAccountTypeObject = new BankAccountType();
                bankAccountTypeObject.setAccTypeId(bankAccountTypeObjectList.getAccTypeId());
                bankAccountTypeObject.setBankCode(bankAccountTypeObjectList.getBankCode());
                bankAccountTypeObject.setBankName(bankAccountTypeObjectList.getBankName());
                bankAccountTypeObject.setAccTypeName(bankAccountTypeObjectList.getAccTypeName());
                bankAccountTypeObject.setCreateBy(bankAccountTypeObjectList.getCreateBy());
                bankAccountTypeObject.setCreateDate(bankAccountTypeObjectList.getCreateDate());
                bankAccountTypeObject.setStatus(bankAccountTypeObjectList.getStatus());
                bankAccountTypeObject.setUpdateBy(bankAccountTypeObjectList.getUpdateBy());
                bankAccountTypeObject.setUpdateDate(bankAccountTypeObjectList.getUpdateDate());
                listResponse.add(bankAccountTypeObject);
            }
            /*
             * End developer create object to array new.
             */

        }
        return listResponse;
    }
}
