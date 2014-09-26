/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itos.model.Bank;
import com.itos.util.MiscUtil;
import java.io.IOException;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonBank {

    public static Bank JSONDeserializer(String json, String stringDateFormat) throws IOException {
        Bank bank = new Bank();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("bankCode")) {
                bank.setBankCode(MiscUtil.getNull(jsonObject.getString("bankCode")));
            }            
            if (jsonObject.containsKey("bankName")) {
                bank.setBankName(MiscUtil.getNull(jsonObject.getString("bankName")));
            }
        } catch (Exception ex) {
            //return null;
        }
        
        return bank;
    }
    
    public static Bank JSONDeserializerKey(String json, String stringDateFormat) throws IOException {
        Bank bank = new Bank();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("bankCode")) {
                bank.setBankCode(MiscUtil.getNull(jsonObject.getString("bankCode")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return bank;
    }
}
