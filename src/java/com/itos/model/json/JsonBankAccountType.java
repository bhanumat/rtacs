/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itos.model.BankAccountType;
import com.itos.model.Member;
import com.itos.util.MiscUtil;
import java.io.IOException;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonBankAccountType {

    public static BankAccountType JSONDeserializer(String json, String stringDateFormat) throws IOException {
        BankAccountType bankAccountType = new BankAccountType();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("bankCode")) {
                bankAccountType.setBankCode(MiscUtil.getNull(jsonObject.getString("bankCode")));
            } 
            if (jsonObject.containsKey("accTypeName")) {
                bankAccountType.setAccTypeName(MiscUtil.getNull(jsonObject.getString("accTypeName")));
            }
            if (jsonObject.containsKey("accTypeId")) {
                bankAccountType.setAccTypeId(MiscUtil.getInt(jsonObject.getString("accTypeId")));
            }
            if (jsonObject.containsKey("status")) {
                bankAccountType.setStatus(MiscUtil.getChar(jsonObject.getString("status")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return bankAccountType;
    }

    public static BankAccountType JSONDeserializerKey(String json, String stringDateFormat) throws IOException {
        BankAccountType bankAccountType = new BankAccountType();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("accTypeId")) {
                bankAccountType.setAccTypeId(MiscUtil.getInt(jsonObject.getString("accTypeId")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return bankAccountType;
    }
}
