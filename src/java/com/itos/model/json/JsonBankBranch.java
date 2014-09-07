/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itos.model.BankBranch;
import com.itos.util.MiscUtil;
import java.io.IOException;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonBankBranch {

    public static BankBranch JSONDeserializer(String json, String stringDateFormat) throws IOException {
        BankBranch bankBranch = new BankBranch();
        ObjectMapper mapper = new ObjectMapper();
        try {
            bankBranch = mapper.readValue(json, BankBranch.class);
        } catch (IOException ex) {
            throw ex;
        }
        return bankBranch;
    }
    
    public static BankBranch JSONDeserializerKey(String json, String stringDateFormat) throws IOException {
        BankBranch bankBranch = new BankBranch();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("branchId")) {
                bankBranch.setBranchId(MiscUtil.getInt(jsonObject.getString("branchId")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return bankBranch;
    }
}
