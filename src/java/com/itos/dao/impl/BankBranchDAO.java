/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IBankBranchDAO;
import com.itos.dao.model.IBankDAO;
import com.itos.model.BankBranch;
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
@Repository("iBankBranchDAO")
public class BankBranchDAO implements IBankBranchDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    IBankDAO iBankDAO;

    @Autowired
    IBankDAO iProvinceDAO;

    private final String objectTable = "BankBranch";
    private final String objectTableBank = "Bank";
    private final String objectTableProvince = "Province";

    @Override
    public JqGridResponse<BankBranch> getList(JqGridRequest req) {
        List<BankBranch> listResponse = new ArrayList<>();
        JqGridResponse<BankBranch> jqGrid = new JqGridResponse<>();
        BankBranch bankBranchObject;
        List<BankBranch> list;
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
            for (BankBranch bankBranchObjectList : list) {
                bankBranchObject = new BankBranch();
                bankBranchObject.setAddress(bankBranchObjectList.getAddress());
                bankBranchObject.setBankCode(bankBranchObjectList.getBankCode());
                bankBranchObject.setBankName(bankBranchObjectList.getBankName());
                bankBranchObject.setBranchCode(bankBranchObjectList.getBranchCode());
                bankBranchObject.setBranchId(bankBranchObjectList.getBranchId());
                bankBranchObject.setBranchName(bankBranchObjectList.getBranchName());
                bankBranchObject.setBranchShort(bankBranchObjectList.getBranchShort());
                bankBranchObject.setCreateBy(bankBranchObjectList.getCreateBy());
                bankBranchObject.setCreateDate(bankBranchObjectList.getCreateDate());
                bankBranchObject.setDistrict(bankBranchObjectList.getDistrict());
                bankBranchObject.setFax(bankBranchObjectList.getFax());
                bankBranchObject.setProvinceCode(bankBranchObjectList.getProvinceCode());
                bankBranchObject.setProvinceName(bankBranchObjectList.getProvinceName());
                bankBranchObject.setZipcode(bankBranchObjectList.getZipcode());
                bankBranchObject.setStatus(bankBranchObjectList.getStatus());
                bankBranchObject.setSubdistrict(bankBranchObjectList.getSubdistrict());
                bankBranchObject.setTel(bankBranchObjectList.getTel());
                bankBranchObject.setUpdateBy(bankBranchObjectList.getUpdateBy());
                bankBranchObject.setUpdateDate(bankBranchObjectList.getUpdateDate());
                listResponse.add(bankBranchObject);
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
    public MessageResponse setDeleteBankBranch(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        BankBranch bankBranchOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            bankBranchOriginal = new BankBranch();
            bankBranchOriginal = (BankBranch) CommandQuery.LoadDetail(sessionFactory, BankBranch.class, Integer.parseInt(id));
            if (CommandQuery.Delete(sessionFactory, bankBranchOriginal)) {
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
    public MessageResponse setSaveNewBankBranch(BankBranch bankBranch) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        chekSuccess = CommandQuery.Insert(sessionFactory, bankBranch);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(bankBranch.getBranchId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditBankBranch(BankBranch bankBranch) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        BankBranch bankBranchOriginal = (BankBranch) CommandQuery.LoadDetail(sessionFactory, BankBranch.class, bankBranch.getBranchId());
        bankBranchOriginal.setAddress(bankBranch.getAddress());
        bankBranchOriginal.setBank(bankBranch.getBank());
        bankBranchOriginal.setBranchId(bankBranch.getBranchId());
        bankBranchOriginal.setBranchCode(bankBranch.getBranchCode());
        bankBranchOriginal.setBranchName(bankBranch.getBranchName());
        bankBranchOriginal.setBranchShort(bankBranch.getBranchShort());
        bankBranchOriginal.setCreateBy(bankBranch.getCreateBy());
        bankBranchOriginal.setCreateDate(bankBranch.getCreateDate());
        bankBranchOriginal.setDistrict(bankBranch.getDistrict());
        bankBranchOriginal.setFax(bankBranch.getFax());
        bankBranchOriginal.setProvince(bankBranch.getProvince());
        bankBranchOriginal.setZipcode(bankBranch.getZipcode());
        bankBranchOriginal.setStatus(bankBranch.getStatus());
        bankBranchOriginal.setSubdistrict(bankBranch.getSubdistrict());
        bankBranchOriginal.setTel(bankBranch.getTel());
        bankBranchOriginal.setUpdateBy(bankBranch.getUpdateBy());
        bankBranchOriginal.setUpdateDate(bankBranch.getUpdateDate());
        chekSuccess = CommandQuery.Update(sessionFactory, bankBranchOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(bankBranch.getBranchId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public BankBranch getLoadBankBranch(BankBranch bankBranch) {
        BankBranch bankBranchResponse = getLoadDetailByObject(bankBranch);
        BankBranch bankBranchObject = new BankBranch();
        bankBranchObject.setAddress(bankBranchResponse.getAddress());
        bankBranchObject.setBankCode(bankBranchResponse.getBankCode());
        bankBranchObject.setBankName(bankBranchResponse.getBankName());
        bankBranchObject.setBranchCode(bankBranchResponse.getBranchCode());
        bankBranchObject.setBranchId(bankBranchResponse.getBranchId());
        bankBranchObject.setBranchName(bankBranchResponse.getBranchName());
        bankBranchObject.setBranchShort(bankBranchResponse.getBranchShort());
        bankBranchObject.setCreateBy(bankBranchResponse.getCreateBy());
        bankBranchObject.setCreateDate(bankBranchResponse.getCreateDate());
        bankBranchObject.setDistrict(bankBranchResponse.getDistrict());
        bankBranchObject.setFax(bankBranchResponse.getFax());
        bankBranchObject.setProvinceCode(bankBranchResponse.getProvinceCode());
        bankBranchObject.setProvinceName(bankBranchResponse.getProvinceName());
        bankBranchObject.setZipcode(bankBranchResponse.getZipcode());
        bankBranchObject.setStatus(bankBranchResponse.getStatus());
        bankBranchObject.setSubdistrict(bankBranchResponse.getSubdistrict());
        bankBranchObject.setTel(bankBranchResponse.getTel());
        bankBranchObject.setUpdateBy(bankBranchResponse.getUpdateBy());
        bankBranchObject.setUpdateDate(bankBranchResponse.getUpdateDate());
        return bankBranchObject;
    }

    private BankBranch getLoadDetailByObject(BankBranch bankBranch) {
        BankBranch bankBranchResponse = new BankBranch();
        List<WhereField> listWhereField = new ArrayList<>();
        List<BankBranch> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("branchId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(bankBranch.getBranchId());
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
                for (BankBranch bankBranchObjectList : list) {
                    bankBranchResponse = new BankBranch();
                    bankBranchResponse.setAddress(bankBranchObjectList.getAddress());
                    bankBranchResponse.setBranchId(bankBranchObjectList.getBranchId());
                    bankBranchResponse.setBank(bankBranchObjectList.getBank());
                    bankBranchResponse.setBranchCode(bankBranchObjectList.getBranchCode());
                    bankBranchResponse.setBranchName(bankBranchObjectList.getBranchName());
                    bankBranchResponse.setBranchShort(bankBranchObjectList.getBranchShort());
                    bankBranchResponse.setCreateBy(bankBranchObjectList.getCreateBy());
                    bankBranchResponse.setCreateDate(bankBranchObjectList.getCreateDate());
                    bankBranchResponse.setDistrict(bankBranchObjectList.getDistrict());
                    bankBranchResponse.setFax(bankBranchObjectList.getFax());
                    bankBranchResponse.setProvince(bankBranchObjectList.getProvince());
                    bankBranchResponse.setZipcode(bankBranchObjectList.getZipcode());
                    bankBranchResponse.setStatus(bankBranchObjectList.getStatus());
                    bankBranchResponse.setSubdistrict(bankBranchObjectList.getSubdistrict());
                    bankBranchResponse.setTel(bankBranchObjectList.getTel());
                    bankBranchResponse.setUpdateBy(bankBranchObjectList.getUpdateBy());
                    bankBranchResponse.setUpdateDate(bankBranchObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return bankBranchResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private BankBranch getLoadDetailById(BankBranch bankBranch) {
        BankBranch bankBranchResponse = null;
        List<WhereField> listWhereField = new ArrayList<>();
        List<BankBranch> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("branchId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(bankBranch.getBranchId());
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
                for (BankBranch bankBranchObjectList : list) {
                    bankBranchResponse = new BankBranch();
                    bankBranchResponse.setAddress(bankBranchObjectList.getAddress());
                    bankBranchResponse.setBranchId(bankBranchObjectList.getBranchId());
                    bankBranchResponse.setBank(bankBranchObjectList.getBank());
                    bankBranchResponse.setBranchCode(bankBranchObjectList.getBranchCode());
                    bankBranchResponse.setBranchName(bankBranchObjectList.getBranchName());
                    bankBranchResponse.setBranchShort(bankBranchObjectList.getBranchShort());
                    bankBranchResponse.setCreateBy(bankBranchObjectList.getCreateBy());
                    bankBranchResponse.setCreateDate(bankBranchObjectList.getCreateDate());
                    bankBranchResponse.setDistrict(bankBranchObjectList.getDistrict());
                    bankBranchResponse.setFax(bankBranchObjectList.getFax());
                    bankBranchResponse.setProvince(bankBranchObjectList.getProvince());
                    bankBranchResponse.setZipcode(bankBranchObjectList.getZipcode());
                    bankBranchResponse.setStatus(bankBranchObjectList.getStatus());
                    bankBranchResponse.setSubdistrict(bankBranchObjectList.getSubdistrict());
                    bankBranchResponse.setTel(bankBranchObjectList.getTel());
                    bankBranchResponse.setUpdateBy(bankBranchObjectList.getUpdateBy());
                    bankBranchResponse.setUpdateDate(bankBranchObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return bankBranchResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<BankBranch> getListInJSONBankBranch(char status) {
        List<BankBranch> listResponse = new ArrayList<>();
        List<BankBranch> list;
        BankBranch bankBranchObject;
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
            for (BankBranch bankBranchObjectList : list) {
                bankBranchObject = new BankBranch();
                bankBranchObject.setAddress(bankBranchObjectList.getAddress());
                bankBranchObject.setBankCode(bankBranchObjectList.getBankCode());
                bankBranchObject.setBankName(bankBranchObjectList.getBankName());
                bankBranchObject.setBranchCode(bankBranchObjectList.getBranchCode());
                bankBranchObject.setBranchId(bankBranchObjectList.getBranchId());
                bankBranchObject.setBranchName(bankBranchObjectList.getBranchName());
                bankBranchObject.setBranchShort(bankBranchObjectList.getBranchShort());
                bankBranchObject.setCreateBy(bankBranchObjectList.getCreateBy());
                bankBranchObject.setCreateDate(bankBranchObjectList.getCreateDate());
                bankBranchObject.setDistrict(bankBranchObjectList.getDistrict());
                bankBranchObject.setFax(bankBranchObjectList.getFax());
                bankBranchObject.setProvinceCode(bankBranchObjectList.getProvinceCode());
                bankBranchObject.setProvinceName(bankBranchObjectList.getProvinceName());
                bankBranchObject.setZipcode(bankBranchObjectList.getZipcode());
                bankBranchObject.setStatus(bankBranchObjectList.getStatus());
                bankBranchObject.setSubdistrict(bankBranchObjectList.getSubdistrict());
                bankBranchObject.setTel(bankBranchObjectList.getTel());
                bankBranchObject.setUpdateBy(bankBranchObjectList.getUpdateBy());
                bankBranchObject.setUpdateDate(bankBranchObjectList.getUpdateDate());
                listResponse.add(bankBranchObject);
            }
            /*
             * End developer create object to array new.
             */

        }
        return listResponse;
    }
}
