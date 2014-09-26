/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IBankDAO;
import com.itos.model.Bank;
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
@Repository("iBankDAO")
public class BankDAO implements IBankDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private final String objectTable = "Bank";

    @Override
    public JqGridResponse<Bank> getList(JqGridRequest req) {
        List<Bank> listResponse = new ArrayList<>();
        JqGridResponse<Bank> jqGrid = new JqGridResponse<>();
        Bank bankObject;
        List<Bank> list;
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
        list = query.list();
        if (!list.isEmpty()) {

            /*
             * Start developer create object to array new.
             */
            for (Bank bankObjectList : list) {
                bankObject = new Bank();
                bankObject.setBankCode(bankObjectList.getBankCode());
                bankObject.setBankName(bankObjectList.getBankName());
                bankObject.setCreateBy(bankObjectList.getCreateBy());
                bankObject.setCreateDate(bankObjectList.getCreateDate());
                bankObject.setStatus(bankObjectList.getStatus());
                bankObject.setUpdateBy(bankObjectList.getUpdateBy());
                bankObject.setUpdateDate(bankObjectList.getUpdateDate());
                listResponse.add(bankObject);
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
    public MessageResponse setDeleteBank(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        Bank bankOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            bankOriginal = new Bank();
            bankOriginal = (Bank) CommandQuery.LoadDetail(sessionFactory, Bank.class, id);
            if (CommandQuery.Delete(sessionFactory, bankOriginal)) {
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
    public MessageResponse setSaveNewBank(Bank bank) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        chekSuccess = CommandQuery.Insert(sessionFactory, bank);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(bank.getBankCode());
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditBank(Bank bank) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        Bank bankOriginal = (Bank) CommandQuery.LoadDetail(sessionFactory, Bank.class, bank.getBankCode());
        bankOriginal.setBankName(bank.getBankName());
        bankOriginal.setStatus(bank.getStatus());
        bankOriginal.setUpdateBy(bank.getUpdateBy());
        bankOriginal.setUpdateDate(bank.getUpdateDate());
        chekSuccess = CommandQuery.Update(sessionFactory, bankOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(bank.getBankCode());
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public Bank getLoadBank(Bank bank) {
        Bank groupResponse = getLoadDetailByObject(bank);
        return groupResponse;
    }

    private Bank getLoadDetailByObject(Bank bank) {
        Bank bankResponse = new Bank();
        List<WhereField> listWhereField = new ArrayList<>();
        List<Bank> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("bankCode");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(bank.getBankCode());
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
                for (Bank bankObjectList : list) {
                    bankResponse = new Bank();
                    bankResponse.setBankCode(bankObjectList.getBankCode());
                    bankResponse.setBankName(bankObjectList.getBankName());
                    bankResponse.setCreateBy(bankObjectList.getCreateBy());
                    bankResponse.setCreateDate(bankObjectList.getCreateDate());
                    bankResponse.setStatus(bankObjectList.getStatus());
                    bankResponse.setUpdateBy(bankObjectList.getUpdateBy());
                    bankResponse.setUpdateDate(bankObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return bankResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Bank getLoadDetailById(Bank groups) {
        Bank bankResponse = null;
        List<WhereField> listWhereField = new ArrayList<>();
        List<Bank> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("bankCode");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(groups.getBankCode());
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
                for (Bank bankObjectList : list) {
                    bankResponse = new Bank();
                    bankResponse.setBankCode(bankObjectList.getBankCode());
                    bankResponse.setBankName(bankObjectList.getBankName());
                    bankResponse.setCreateBy(bankObjectList.getCreateBy());
                    bankResponse.setCreateDate(bankObjectList.getCreateDate());
                    bankResponse.setStatus(bankObjectList.getStatus());
                    bankResponse.setUpdateBy(bankObjectList.getUpdateBy());
                    bankResponse.setUpdateDate(bankObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return bankResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Bank> getListInJSONBank(char status) {
        List<Bank> listResponse = new ArrayList<>();
        List<Bank> list;
        Bank bankObject;
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Bank");
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
            for (Bank bankObjectList : list) {
                bankObject = new Bank();
                bankObject.setBankCode(bankObjectList.getBankCode());
                bankObject.setBankName(bankObjectList.getBankName());
                bankObject.setCreateBy(bankObjectList.getCreateBy());
                bankObject.setCreateDate(bankObjectList.getCreateDate());
                bankObject.setStatus(bankObjectList.getStatus());
                bankObject.setUpdateBy(bankObjectList.getUpdateBy());
                bankObject.setUpdateDate(bankObjectList.getUpdateDate());
                listResponse.add(bankObject);
            }
            /*
             * End developer create object to array new.
             */

        }
        return listResponse;
    }
}
