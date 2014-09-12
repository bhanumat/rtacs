/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.itos.model.OperationMember;
import com.itos.util.MiscUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonOperationMember {

    public static OperationMember JSONDeserializer(String json, String stringDateFormat) {
        OperationMember operationMember = new OperationMember();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("operationMemberId")) {
                operationMember.setOperationMemberId(MiscUtil.getInt(jsonObject.getString("operationMemberId")));
            }
            if (jsonObject.containsKey("citizenId")) {
                operationMember.setCitizenId(MiscUtil.getNull(jsonObject.getString("citizenId")));
            }
            if (jsonObject.containsKey("docCode")) {
                operationMember.setDocCode(MiscUtil.getNull(jsonObject.getString("docCode")));
            }
//            if (jsonObject.containsKey("docDate")) {
//                operationMember.setDocDate(MiscUtil.getNull(jsonObject.getString("docDate")));
//            }
            if (jsonObject.containsKey("remark")) {
                operationMember.setRemark(MiscUtil.getNull(jsonObject.getString("remark")));
            }
            if (jsonObject.containsKey("amount")) {
                operationMember.setAmount(new BigDecimal((MiscUtil.getNull(jsonObject.getString("amount")).equals("")) ? "0" : MiscUtil.getNull(jsonObject.getString("amount"))));
            }            
        } catch (Exception ex) {
            throw ex;
        }
        return operationMember;
    }

    public static OperationMember JSONDeserializerPayment(String json, String stringDateFormat) {
//        OperationMember operationMember = new OperationMember();
//        try {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject = JSONObject.fromObject(json);
//            
//            operationMember.setCitizenId(MiscUtil.getNull(jsonObject.getString("citizenId")));
//            operationMember.setDocCode(MiscUtil.getNull(jsonObject.getString("docCode")));
//            operationMember.setDocDate(MiscUtil.getDate(jsonObject.getString("docDate"), stringDateFormat));
//            operationMember.setAmount(new BigDecimal((MiscUtil.getNull(jsonObject.getString("amount")).equals(""))?"0":MiscUtil.getNull(jsonObject.getString("amount"))));
//            
//        } 
        OperationMember operationMember = new OperationMember();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("operationMemberId")) {
                operationMember.setOperationMemberId(MiscUtil.getInt(jsonObject.getString("operationMemberId")));
            }
            if (jsonObject.containsKey("citizenId")) {
                operationMember.setCitizenId(MiscUtil.getNull(jsonObject.getString("citizenId")));
            }
            if (jsonObject.containsKey("docCode")) {
                operationMember.setDocCode(MiscUtil.getNull(jsonObject.getString("docCode")));
            }
            if (jsonObject.containsKey("docDate")) {
                operationMember.setDocDate(MiscUtil.getDate(jsonObject.getString("docDate"),stringDateFormat));
            }
            if (jsonObject.containsKey("amount")) {
                operationMember.setAmount(new BigDecimal((MiscUtil.getNull(jsonObject.getString("amount")).equals(""))?"0":MiscUtil.getNull(jsonObject.getString("amount"))));
            }
        } catch (Exception ex) {
            //return null;
        }
        return operationMember;
    }
    
    public static List<OperationMember> JSONDeserializerArray(String json, String stringDateFormat) {
        List<OperationMember> listOperationMember = new ArrayList<>();
        OperationMember operationMember;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("listOperationMember")) {
                JSONArray jsonArray = jsonObject.getJSONArray("listOperationMember");
                for (Object objData : jsonArray) {
                    JSONObject jsonObjectList = (JSONObject) objData;
                    operationMember = new OperationMember(); 
                    if (jsonObjectList.containsKey("memberId")) {
                        operationMember.setMemberId(MiscUtil.getInt(jsonObjectList.getString("memberId")));
                    }
                    
                    if (jsonObjectList.containsKey("operationId")) {
                        operationMember.setOperationId(MiscUtil.getInt(jsonObjectList.getString("operationId")));
                    }
                    listOperationMember.add(operationMember);                    
                }
            }
            
        } catch (Exception ex) {
            throw ex;
        }
        return listOperationMember;
    }
}
