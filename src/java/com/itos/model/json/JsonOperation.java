/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.itos.model.Operation;
import com.itos.util.MiscUtil;
import java.io.IOException;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonOperation {

    public static Operation JSONDeserializer(String json, String stringDateFormat) {
        Operation operation = new Operation();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("operationId")) {
                operation.setOperationId(MiscUtil.getInt(jsonObject.getString("operationId")));
            }
            if (jsonObject.containsKey("operationTypeCode")) {
                operation.setOperationTypeCode(MiscUtil.getInt(jsonObject.getString("operationTypeCode")));
            }
            if (jsonObject.containsKey("docCode")) {
                operation.setDocCode(MiscUtil.getNull(jsonObject.getString("docCode")));
            }
            if (jsonObject.containsKey("docDate")) {
                operation.setDocDate(MiscUtil.getDate(jsonObject.getString("docDate"), stringDateFormat));
            }
            if (jsonObject.containsKey("remark")) {
                operation.setRemark(MiscUtil.getNull(jsonObject.getString("remark")));
            }
            if (jsonObject.containsKey("memberNo")) {
                operation.setMemberNo(MiscUtil.getInt(jsonObject.getString("memberNo")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return operation;
    }

    public static Operation JSONDeserializerKey(String json, String stringDateFormat) throws IOException {
        Operation operation = new Operation();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("operationId")) {
                operation.setOperationId(MiscUtil.getInt(jsonObject.getString("operationId")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return operation;
    }
    
    public static Operation JSONDeserializerAPP041(String json, String stringDateFormat) {
        System.out.println("JSONDeserializerAPP041");
        System.out.println("json : >>" + json + "<<");
        Operation operation = new Operation();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("operationId")) {
                System.out.println("operationId");
                operation.setOperationId(MiscUtil.getInt(jsonObject.getString("operationId")));
            }
            if (jsonObject.containsKey("operationTypeCode")) {
                System.out.println("operationTypeCode");
                operation.setOperationTypeCode(MiscUtil.getInt(jsonObject.getString("operationTypeCode")));
            }
            if (jsonObject.containsKey("docCode")) {
                System.out.println("docCode");
                operation.setDocCode(MiscUtil.getNull(jsonObject.getString("docCode")));
            }
            if (jsonObject.containsKey("docDate")) {
                System.out.println("docDate");
                operation.setDocDate(MiscUtil.getDate(jsonObject.getString("docDate"), stringDateFormat));
            }
            if (jsonObject.containsKey("remark")) {
                System.out.println("remark");
                operation.setRemark(MiscUtil.getNull(jsonObject.getString("remark")));
            }
            if (jsonObject.containsKey("memberNo")) {
                System.out.println("memberNo");
                operation.setMemberNo(MiscUtil.getInt(jsonObject.getString("memberNo")));
            }
        } catch (Exception ex) {
            System.out.println("error : " + ex.getMessage());
            //return null;
        }
        System.out.println("exit JSONDeserializerAPP041");
        return operation;
    }
     public static Operation JSONDeserializerAPP031(String json, String stringDateFormat) {
        System.out.println("JSONDeserializerAPP031");
        System.out.println("json : >>" + json + "<<");
        Operation operation = new Operation();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("operationId")) {
                System.out.println("operationId");
                operation.setOperationId(MiscUtil.getInt(jsonObject.getString("operationId")));
            }
            if (jsonObject.containsKey("operationTypeCode")) {
                System.out.println("operationTypeCode");
                operation.setOperationTypeCode(MiscUtil.getInt(jsonObject.getString("operationTypeCode")));
            }
            if (jsonObject.containsKey("docCode")) {
                System.out.println("docCode");
                operation.setDocCode(MiscUtil.getNull(jsonObject.getString("docCode")));
            }
            if (jsonObject.containsKey("docDate")) {
                System.out.println("docDate");
                operation.setDocDate(MiscUtil.getDate(jsonObject.getString("docDate"), stringDateFormat));
            }
            if (jsonObject.containsKey("remark")) {
                System.out.println("remark");
                operation.setRemark(MiscUtil.getNull(jsonObject.getString("remark")));
            }
            if (jsonObject.containsKey("memberNo")) {
                System.out.println("memberNo");
                operation.setMemberNo(MiscUtil.getInt(jsonObject.getString("memberNo")));
            }
        } catch (Exception ex) {
            System.out.println("error : " + ex.getMessage());
            //return null;
        }
        System.out.println("exit JSONDeserializerAPP031");
        return operation;
    }   
}
