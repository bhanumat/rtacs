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
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonOperationMember {
    public static OperationMember JSONDeserializer(String json, String stringDateFormat) {

        OperationMember operationmember = new OperationMember();
        List<Integer> itemSelectInteger = new ArrayList<>();
        List<Integer> itemSelectInteger2 = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            operationmember.setOperationTypeCode(jsonObject.getInt("operationTypeCode"));
            operationmember.setDocDate(MiscUtil.getDate(jsonObject.getString("docDate"), stringDateFormat));
            String itemSelectString = jsonObject.getString("operationId");
            String[] itemSelectArrary = itemSelectString.split(",");
            for (String objectInteger : itemSelectArrary) {
                if (!objectInteger.isEmpty()) {
                    itemSelectInteger.add(Integer.parseInt(objectInteger));
                }
            }
            
            String itemSelectString2 = jsonObject.getString("memberId");
            String[] itemSelectArrary2 = itemSelectString2.split(",");
            for (String objectInteger : itemSelectArrary2) {
                if (!objectInteger.isEmpty()) {
                    itemSelectInteger2.add(Integer.parseInt(objectInteger));
                }
            }
            
            operationmember.setItemSelect(itemSelectInteger);
            operationmember.setItemSelect2(itemSelectInteger2);
            //operationModify.setName(MiscUtil.getNull(jsonObject.getString("name")));
        } catch (Exception ex) {
            throw ex;
        }
        return operationmember;
    }
    
    public static OperationMember JSONDeserializerPayment(String json, String stringDateFormat) {
        OperationMember operationMember = new OperationMember();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            
            operationMember.setCitizenId(MiscUtil.getNull(jsonObject.getString("citizenId")));
            operationMember.setDocCode(MiscUtil.getNull(jsonObject.getString("docCode")));
            operationMember.setDocDate(MiscUtil.getDate(jsonObject.getString("docDate"), stringDateFormat));
            operationMember.setAmount(new BigDecimal((MiscUtil.getNull(jsonObject.getString("amount")).equals(""))?"0":MiscUtil.getNull(jsonObject.getString("amount"))));
            
        } catch (Exception ex) {
            //return null;
        }
        return operationMember;
    }
}
