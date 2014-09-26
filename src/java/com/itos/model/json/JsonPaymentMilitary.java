/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.itos.model.ext.PaymentMilitary;
import com.itos.util.MiscUtil;
import java.math.BigDecimal;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonPaymentMilitary {

    public static PaymentMilitary JSONDeserializer(String json, String stringDateFormat) {
        PaymentMilitary paymentMilitary = new PaymentMilitary();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("militaryId")) {
                paymentMilitary.setMilitaryId(MiscUtil.getInt(jsonObject.getString("militaryId")));
            }
            if (jsonObject.containsKey("docDate")) {
                paymentMilitary.setDocDate(MiscUtil.getDate(jsonObject.getString("docDate"),stringDateFormat));
            }
            if (jsonObject.containsKey("memberIdList")) {
                paymentMilitary.setMemberIdList(MiscUtil.getNull(jsonObject.getString("memberIdList")));
            }
            if (jsonObject.containsKey("sumAmount")) {
                paymentMilitary.setSumAmount(new BigDecimal((MiscUtil.getNull(jsonObject.getString("sumAmount")).equals("")) ? "0" : MiscUtil.getNull(jsonObject.getString("sumAmount"))));
            }            
        } catch (Exception ex) {
            throw ex;
        }
        return paymentMilitary;
    }

}
