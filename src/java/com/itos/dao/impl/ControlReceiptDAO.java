/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IControlReceiptDAO;
import com.itos.model.ControlReceipt;
import com.itos.util.Hibernate.CommandConstant;
import com.itos.util.Hibernate.CommandQuery;
import com.itos.util.Hibernate.WhereField;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITOS
 */
@Repository("iControlReceiptDAO")
public class ControlReceiptDAO implements IControlReceiptDAO {

    protected final Log logger = LogFactory.getLog(getClass());
    private static final int LENGTH_CODE = 8;
    @Autowired
    private SessionFactory sessionFactory;

    private final String objectTable = "ControlReceipt";

    @Override
    public ControlReceipt updatedRunningNo(int id) {
        logger.info("ControlReceiptDAO : updatedStatus");
        int iCountSuccessful = 0;
        List<ControlReceipt> list;
        ControlReceipt controlReceiptOriginal = null;
        
        logger.info("id : >>" + id + "<<");
       
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField whereField = null;

        Query query;
        whereField = new WhereField();
        whereField.setSearchField("controlReceiptId");
        whereField.setSearchLogic("");
        whereField.setSearchOper(CommandConstant.QueryEqual);
        whereField.setSearchValue(id);
        whereField.setSearchDataType(CommandConstant.DataTypeInteger);
        listWhereField.add(whereField);
        query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);

        if (!query.list().isEmpty()) {
            list = query.list();
            controlReceiptOriginal = list.get(0);
            System.out.println("running : >>" + controlReceiptOriginal.getRunningNo() + "<<");
            controlReceiptOriginal.setRunningNo(controlReceiptOriginal.getRunningNo()+1);
            System.out.println("new running : >>" + controlReceiptOriginal.getRunningNo() + "<<");
            if (CommandQuery.Update(sessionFactory, controlReceiptOriginal)) {
                iCountSuccessful++;
            }
        }
        if (iCountSuccessful > 0) {
            return controlReceiptOriginal;
        } 
        return null;
    }
    
    @Override
    public String getDocumentCode() {
        logger.info("ControlReceiptDAO : getDocumentCode");
        
        List<ControlReceipt> list;
        List<WhereField> listWhereField = new ArrayList<>();
        WhereField field = new WhereField();
        field.setSearchField("control_receipt_id");
        field.setSearchValue(1);
        field.setSearchLogic("");
        field.setSearchOper(CommandConstant.QueryEqual);
        field.setSearchDataType(CommandConstant.DataTypeInteger);
        listWhereField.add(field);
        Query query = CommandQuery.CreateQuery(sessionFactory, objectTable, listWhereField);
        String docCode = "";
        if (!query.list().isEmpty()) {
            list = query.list();
            ControlReceipt controlReceipt = list.get(0);
            docCode = "" + controlReceipt.getGroupCode() + (controlReceipt.getRunningNo()+1);
            logger.info("docCode : >>" + docCode + "<<");
            docCode = fullfillCode(docCode);
            logger.info("fullfillCode docCode : >>" + docCode + "<<");
            
            //ControlReceipt receipt = updatedRunningNo(controlReceipt.getControlReceiptId());
            //System.out.println("new ID : >>" + receipt.getControlReceiptId() + "<< running : >>" + receipt.getRunningNo() + "<<");
            return docCode;
        }
        return null;
    }
    
    private String fullfillCode(String code){
        if(code.isEmpty())
            return "";
        String result = code.substring(0, 1);
        int length = code.length();
        for(int i=0;i<LENGTH_CODE-length;i++){
            result = result + "0";
        }
        result = result + code.substring(1);
        return result;
    }
}
