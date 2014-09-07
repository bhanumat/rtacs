/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IMilitaryDepartmentDAO;
import com.itos.model.MilitaryDepartment;
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
@Repository("iMilitaryDepartmentDAO")
public class MilitaryDepartmentDAO implements IMilitaryDepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private final String objectTable = "MilitaryDepartment";

    @Override
    public JqGridResponse<MilitaryDepartment> getList(JqGridRequest req) {
        List<MilitaryDepartment> listResponse = new ArrayList<>();
        JqGridResponse<MilitaryDepartment> jqGrid = new JqGridResponse<>();
        MilitaryDepartment militaryDepartmentObject;
        List<MilitaryDepartment> list;
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
            for (MilitaryDepartment militaryDepartmentObjectList : list) {
                militaryDepartmentObject = new MilitaryDepartment();
                militaryDepartmentObject.setAddress1(militaryDepartmentObjectList.getAddress1());
                militaryDepartmentObject.setAddress2(militaryDepartmentObjectList.getAddress2());
                militaryDepartmentObject.setBankAccName(militaryDepartmentObjectList.getBankAccName());
                militaryDepartmentObject.setBankAccNo(militaryDepartmentObjectList.getBankAccNo());
                militaryDepartmentObject.setBankCode(militaryDepartmentObjectList.getBankCode());
                militaryDepartmentObject.setBankName(militaryDepartmentObjectList.getBankName());
                militaryDepartmentObject.setBranchId(militaryDepartmentObjectList.getBranchId());
                militaryDepartmentObject.setBranchName(militaryDepartmentObjectList.getBranchName());
                militaryDepartmentObject.setBankAccTypeId(militaryDepartmentObjectList.getBankAccTypeId());
                militaryDepartmentObject.setBankAccTypeName(militaryDepartmentObjectList.getBankAccTypeName());
                militaryDepartmentObject.setDistrict(militaryDepartmentObjectList.getDistrict());
                militaryDepartmentObject.setFax(militaryDepartmentObjectList.getFax());
                militaryDepartmentObject.setFullname(militaryDepartmentObjectList.getFullname());
                militaryDepartmentObject.setMildeptId(militaryDepartmentObjectList.getMildeptId());
                militaryDepartmentObject.setName(militaryDepartmentObjectList.getName());
                militaryDepartmentObject.setProvinceCode(militaryDepartmentObjectList.getProvinceCode());
                militaryDepartmentObject.setStatus(militaryDepartmentObjectList.getStatus());
                militaryDepartmentObject.setSubdistrict(militaryDepartmentObjectList.getSubdistrict());
                militaryDepartmentObject.setTel(militaryDepartmentObjectList.getTel());
                militaryDepartmentObject.setZipcode(militaryDepartmentObjectList.getZipcode());
                militaryDepartmentObject.setMilitaryId(militaryDepartmentObjectList.getMilitaryId());
                listResponse.add(militaryDepartmentObject);
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
    public MessageResponse setDeleteMilitaryDepartment(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        MilitaryDepartment militaryDepartmentOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            militaryDepartmentOriginal = new MilitaryDepartment();
            militaryDepartmentOriginal = (MilitaryDepartment) CommandQuery.LoadDetail(sessionFactory, MilitaryDepartment.class, Integer.parseInt(id));
            if (CommandQuery.Delete(sessionFactory, militaryDepartmentOriginal)) {
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
    public MessageResponse setSaveNewMilitaryDepartment(MilitaryDepartment militaryDepartment) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        chekSuccess = CommandQuery.Insert(sessionFactory, militaryDepartment);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(militaryDepartment.getMilitaryId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditMilitaryDepartment(MilitaryDepartment militaryDepartment) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        MilitaryDepartment militaryDepartmentOriginal = (MilitaryDepartment) CommandQuery.LoadDetail(sessionFactory, MilitaryDepartment.class, militaryDepartment.getMilitaryId());
        militaryDepartmentOriginal.setAddress1(militaryDepartment.getAddress1());
        militaryDepartmentOriginal.setAddress2(militaryDepartment.getAddress2());
        militaryDepartmentOriginal.setBankAccName(militaryDepartment.getBankAccName());
        militaryDepartmentOriginal.setBankAccNo(militaryDepartment.getBankAccNo());
        militaryDepartmentOriginal.setBankAccountType(militaryDepartment.getBankAccountType());
        militaryDepartmentOriginal.setBank(militaryDepartment.getBank());
        militaryDepartmentOriginal.setBankBranch(militaryDepartment.getBankBranch());
        militaryDepartmentOriginal.setDistrict(militaryDepartment.getDistrict());
        militaryDepartmentOriginal.setFax(militaryDepartment.getFax());
        militaryDepartmentOriginal.setFullname(militaryDepartment.getFullname());
        militaryDepartmentOriginal.setMildeptId(militaryDepartment.getMildeptId());
        militaryDepartmentOriginal.setName(militaryDepartment.getName());
        militaryDepartmentOriginal.setProvinceCode(militaryDepartment.getProvinceCode());
        militaryDepartmentOriginal.setStatus(militaryDepartment.getStatus());
        militaryDepartmentOriginal.setSubdistrict(militaryDepartment.getSubdistrict());
        militaryDepartmentOriginal.setTel(militaryDepartment.getTel());
        militaryDepartmentOriginal.setZipcode(militaryDepartment.getZipcode());
        chekSuccess = CommandQuery.Update(sessionFactory, militaryDepartmentOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(String.valueOf(militaryDepartment.getMilitaryId()));
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MilitaryDepartment getLoadMilitaryDepartment(MilitaryDepartment militaryDepartment) {
        MilitaryDepartment groupResponse = getLoadDetailById(militaryDepartment);
        return groupResponse;
    }

    private MilitaryDepartment getLoadDetailByObject(MilitaryDepartment militaryDepartmentObject) {
        MilitaryDepartment militaryDepartmentResponse = new MilitaryDepartment();
        List<WhereField> listWhereField = new ArrayList();
        List<MilitaryDepartment> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("militaryId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(militaryDepartmentObject.getMilitaryId());
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
                for (MilitaryDepartment militaryDepartmentObjectList : list) {
                    militaryDepartmentResponse = new MilitaryDepartment();
                    militaryDepartmentResponse.setAddress1(militaryDepartmentObjectList.getAddress1());
                    militaryDepartmentResponse.setAddress2(militaryDepartmentObjectList.getAddress2());
                    militaryDepartmentResponse.setBankAccName(militaryDepartmentObjectList.getBankAccName());
                    militaryDepartmentResponse.setBankAccNo(militaryDepartmentObjectList.getBankAccNo());
                    militaryDepartmentResponse.setBankAccountType(militaryDepartmentObjectList.getBankAccountType());
                    militaryDepartmentResponse.setBank(militaryDepartmentObjectList.getBank());
                    militaryDepartmentResponse.setBankBranch(militaryDepartmentObjectList.getBankBranch());
                    militaryDepartmentResponse.setDistrict(militaryDepartmentObjectList.getDistrict());
                    militaryDepartmentResponse.setFax(militaryDepartmentObjectList.getFax());
                    militaryDepartmentResponse.setFullname(militaryDepartmentObjectList.getFullname());
                    militaryDepartmentResponse.setMildeptId(militaryDepartmentObjectList.getMildeptId());
                    militaryDepartmentResponse.setName(militaryDepartmentObjectList.getName());
                    militaryDepartmentResponse.setProvinceCode(militaryDepartmentObjectList.getProvinceCode());
                    militaryDepartmentResponse.setStatus(militaryDepartmentObjectList.getStatus());
                    militaryDepartmentResponse.setSubdistrict(militaryDepartmentObjectList.getSubdistrict());
                    militaryDepartmentResponse.setTel(militaryDepartmentObjectList.getTel());
                    militaryDepartmentResponse.setZipcode(militaryDepartmentObjectList.getZipcode());
                    militaryDepartmentResponse.setMilitaryId(militaryDepartmentObjectList.getMilitaryId());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return militaryDepartmentResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private MilitaryDepartment getLoadDetailById(MilitaryDepartment militaryDepartment) {
        MilitaryDepartment militaryDepartmentResponse = null;
        List<WhereField> listWhereField = new ArrayList();
        List<MilitaryDepartment> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("militaryId");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(militaryDepartment.getMilitaryId());
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
                for (MilitaryDepartment militaryDepartmentObjectList : list) {
                    militaryDepartmentResponse = new MilitaryDepartment();
                    militaryDepartmentResponse.setAddress1(militaryDepartmentObjectList.getAddress1());
                    militaryDepartmentResponse.setAddress2(militaryDepartmentObjectList.getAddress2());
                    militaryDepartmentResponse.setBankAccName(militaryDepartmentObjectList.getBankAccName());
                    militaryDepartmentResponse.setBankAccNo(militaryDepartmentObjectList.getBankAccNo());
                    militaryDepartmentResponse.setBankCode(militaryDepartmentObjectList.getBankCode());
                    militaryDepartmentResponse.setBankName(militaryDepartmentObjectList.getBankName());
                    militaryDepartmentResponse.setBranchId(militaryDepartmentObjectList.getBranchId());
                    militaryDepartmentResponse.setBranchName(militaryDepartmentObjectList.getBranchName());
                    militaryDepartmentResponse.setBankAccTypeId(militaryDepartmentObjectList.getBankAccTypeId());
                    militaryDepartmentResponse.setBankAccTypeName(militaryDepartmentObjectList.getBankAccTypeName());
                    militaryDepartmentResponse.setDistrict(militaryDepartmentObjectList.getDistrict());
                    militaryDepartmentResponse.setFax(militaryDepartmentObjectList.getFax());
                    militaryDepartmentResponse.setFullname(militaryDepartmentObjectList.getFullname());
                    militaryDepartmentResponse.setMildeptId(militaryDepartmentObjectList.getMildeptId());
                    militaryDepartmentResponse.setName(militaryDepartmentObjectList.getName());
                    militaryDepartmentResponse.setProvinceCode(militaryDepartmentObjectList.getProvinceCode());
                    militaryDepartmentResponse.setStatus(militaryDepartmentObjectList.getStatus());
                    militaryDepartmentResponse.setSubdistrict(militaryDepartmentObjectList.getSubdistrict());
                    militaryDepartmentResponse.setTel(militaryDepartmentObjectList.getTel());
                    militaryDepartmentResponse.setZipcode(militaryDepartmentObjectList.getZipcode());
                    militaryDepartmentResponse.setMilitaryId(militaryDepartmentObjectList.getMilitaryId());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return militaryDepartmentResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<MilitaryDepartment> getListInJSONMilitaryDepartment(char status) {
        List<MilitaryDepartment> listResponse = new ArrayList<>();
        List<MilitaryDepartment> list;
        MilitaryDepartment militaryDepartmentObject;
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
        if (!query.list().isEmpty()) {
            list = query.list();

            /*
             * Start developer create object to array new.
             */
            for (MilitaryDepartment militaryDepartmentObjectList : list) {
                militaryDepartmentObject = new MilitaryDepartment();
                militaryDepartmentObject.setAddress1(militaryDepartmentObjectList.getAddress1());
                militaryDepartmentObject.setAddress2(militaryDepartmentObjectList.getAddress2());
                militaryDepartmentObject.setBankAccName(militaryDepartmentObjectList.getBankAccName());
                militaryDepartmentObject.setBankAccNo(militaryDepartmentObjectList.getBankAccNo());
                militaryDepartmentObject.setBankCode(militaryDepartmentObjectList.getBankCode());
                militaryDepartmentObject.setBankName(militaryDepartmentObjectList.getBankName());
                militaryDepartmentObject.setBranchId(militaryDepartmentObjectList.getBranchId());
                militaryDepartmentObject.setBranchName(militaryDepartmentObjectList.getBranchName());
                militaryDepartmentObject.setBankAccTypeId(militaryDepartmentObjectList.getBankAccTypeId());
                militaryDepartmentObject.setBankAccTypeName(militaryDepartmentObjectList.getBankAccTypeName());
                militaryDepartmentObject.setDistrict(militaryDepartmentObjectList.getDistrict());
                militaryDepartmentObject.setFax(militaryDepartmentObjectList.getFax());
                militaryDepartmentObject.setFullname(militaryDepartmentObjectList.getFullname());
                militaryDepartmentObject.setMildeptId(militaryDepartmentObjectList.getMildeptId());
                militaryDepartmentObject.setName(militaryDepartmentObjectList.getName());
                militaryDepartmentObject.setProvinceCode(militaryDepartmentObjectList.getProvinceCode());
                militaryDepartmentObject.setStatus(militaryDepartmentObjectList.getStatus());
                militaryDepartmentObject.setSubdistrict(militaryDepartmentObjectList.getSubdistrict());
                militaryDepartmentObject.setTel(militaryDepartmentObjectList.getTel());
                militaryDepartmentObject.setZipcode(militaryDepartmentObjectList.getZipcode());
                militaryDepartmentObject.setMilitaryId(militaryDepartmentObjectList.getMilitaryId());
                listResponse.add(militaryDepartmentObject);
            }
            /*
             * End developer create object to array new.
             */

        }
        return listResponse;
    }
}
