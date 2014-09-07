/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IProvinceDAO;
import com.itos.model.Province;
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
@Repository("iProvinceDAO")
public class ProvinceDAO implements IProvinceDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private final String objectTable = "Province";

    @Override
    public JqGridResponse<Province> getList(JqGridRequest req) {
        List<Province> listResponse = new ArrayList<>();
        JqGridResponse<Province> jqGrid = new JqGridResponse<>();
        Province provinceObject;
        List<Province> list;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Province");

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
            for (Province provinceObjectList : list) {
                provinceObject = new Province();
                provinceObject.setProvinceCode(provinceObjectList.getProvinceCode());
                provinceObject.setProvinceName(provinceObjectList.getProvinceName());
                provinceObject.setCreateBy(provinceObjectList.getCreateBy());
                provinceObject.setCreateDate(provinceObjectList.getCreateDate());
                provinceObject.setStatus(provinceObjectList.getStatus());
                provinceObject.setUpdateBy(provinceObjectList.getUpdateBy());
                provinceObject.setUpdateDate(provinceObjectList.getUpdateDate());
                listResponse.add(provinceObject);
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
    public MessageResponse setDeleteProvince(MessageRequest req) {
        int iCountSuccessful = 0;
        MessageResponse response = new MessageResponse();
        Province provinceOriginal = null;
        boolean chekSuccess = false;
        for (String id : req.getItemSelect()) {
            provinceOriginal = new Province();
            provinceOriginal = (Province) CommandQuery.LoadDetail(sessionFactory, Province.class, id);
            if (CommandQuery.Delete(sessionFactory, provinceOriginal)) {
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
    public MessageResponse setSaveNewProvince(Province province) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        chekSuccess = CommandQuery.Insert(sessionFactory, province);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(province.getProvinceCode());
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public MessageResponse setSaveEditProvince(Province province) {
        MessageResponse response = new MessageResponse();
        boolean chekSuccess = false;
        Province provinceOriginal = (Province) CommandQuery.LoadDetail(sessionFactory, Province.class, province.getProvinceCode());
        provinceOriginal.setProvinceName(province.getProvinceName());
        provinceOriginal.setStatus(province.getStatus());
        provinceOriginal.setUpdateBy(province.getUpdateBy());
        provinceOriginal.setUpdateDate(province.getUpdateDate());
        chekSuccess = CommandQuery.Update(sessionFactory, provinceOriginal);
        response.setCheckSuccess(chekSuccess);
        if (chekSuccess) {
            response.setId(province.getProvinceCode());
            response.setMessage(ConstantsMessage.SaveSuccessful);
        } else {
            throw new RuntimeException(ConstantsMessage.SaveUnsuccessful);
        }
        return response;
    }

    @Override
    public Province getLoadProvince(Province province) {
        Province groupResponse = getLoadDetailByObject(province);
        return groupResponse;
    }

    private Province getLoadDetailByObject(Province province) {
        Province provinceResponse = new Province();
        List<WhereField> listWhereField = new ArrayList();
        List<Province> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("provinceCode");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(province.getProvinceCode());
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
                for (Province provinceObjectList : list) {
                    provinceResponse = new Province();
                    provinceResponse.setProvinceCode(provinceObjectList.getProvinceCode());
                    provinceResponse.setProvinceName(provinceObjectList.getProvinceName());
                    provinceResponse.setCreateBy(provinceObjectList.getCreateBy());
                    provinceResponse.setCreateDate(provinceObjectList.getCreateDate());
                    provinceResponse.setStatus(provinceObjectList.getStatus());
                    provinceResponse.setUpdateBy(provinceObjectList.getUpdateBy());
                    provinceResponse.setUpdateDate(provinceObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return provinceResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Province getLoadDetailById(Province groups) {
        Province provinceResponse = null;
        List<WhereField> listWhereField = new ArrayList();
        List<Province> list;
        WhereField whereField = null;
        try {
            /*
             * Command HQL query Data.
             */
            whereField = new WhereField();
            whereField.setSearchField("provinceCode");
            whereField.setSearchLogic("");
            whereField.setSearchOper(CommandConstant.QueryEqual);
            whereField.setSearchValue(groups.getProvinceCode());
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
                for (Province provinceObjectList : list) {
                    provinceResponse = new Province();
                    provinceResponse.setProvinceCode(provinceObjectList.getProvinceCode());
                    provinceResponse.setProvinceName(provinceObjectList.getProvinceName());
                    provinceResponse.setCreateBy(provinceObjectList.getCreateBy());
                    provinceResponse.setCreateDate(provinceObjectList.getCreateDate());
                    provinceResponse.setStatus(provinceObjectList.getStatus());
                    provinceResponse.setUpdateBy(provinceObjectList.getUpdateBy());
                    provinceResponse.setUpdateDate(provinceObjectList.getUpdateDate());
                    break;
                }
                /*
                 * End developer create object to array new.
                 */
            }
            return provinceResponse;
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Province> getListInJSONProvince(char status) {
        List<Province> listResponse = new ArrayList<>();
        List<Province> list;
        Province provinceObject;
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;
        /*
         * Command HQL query Data.
         */
//        StringBuilder hql = new StringBuilder();
//        hql.append("From Province");
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
            for (Province provinceObjectList : list) {
                provinceObject = new Province();
                provinceObject.setProvinceCode(provinceObjectList.getProvinceCode());
                provinceObject.setProvinceName(provinceObjectList.getProvinceName());
                provinceObject.setCreateBy(provinceObjectList.getCreateBy());
                provinceObject.setCreateDate(provinceObjectList.getCreateDate());
                provinceObject.setStatus(provinceObjectList.getStatus());
                provinceObject.setUpdateBy(provinceObjectList.getUpdateBy());
                provinceObject.setUpdateDate(provinceObjectList.getUpdateDate());
                listResponse.add(provinceObject);
            }
            /*
             * End developer create object to array new.
             */

        }
        return listResponse;
    }
}
