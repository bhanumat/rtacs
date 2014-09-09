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
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("branchId")) {
                bankBranch.setBranchId(MiscUtil.getInt(jsonObject.getString("branchId")));
            }
            if (jsonObject.containsKey("bankCode")) {
                bankBranch.setBankCode(MiscUtil.getNull(jsonObject.getString("bankCode")));
            }
            if (jsonObject.containsKey("branchCode")) {
                bankBranch.setBranchCode(MiscUtil.getNull(jsonObject.getString("branchCode")));
            }
            if (jsonObject.containsKey("branchName")) {
                bankBranch.setBranchName(MiscUtil.getNull(jsonObject.getString("branchName")));
            }
            if (jsonObject.containsKey("branchShort")) {
                bankBranch.setBranchShort(MiscUtil.getNull(jsonObject.getString("branchShort")));
            }
            if (jsonObject.containsKey("address")) {
                bankBranch.setAddress(MiscUtil.getNull(jsonObject.getString("address")));
            }
            if (jsonObject.containsKey("subdistrict")) {
                bankBranch.setSubdistrict(MiscUtil.getNull(jsonObject.getString("subdistrict")));
            }
            if (jsonObject.containsKey("district")) {
                bankBranch.setDistrict(MiscUtil.getNull(jsonObject.getString("district")));
            }
            if (jsonObject.containsKey("zipcode")) {
                bankBranch.setZipcode(MiscUtil.getNull(jsonObject.getString("zipcode")));
            }
            if (jsonObject.containsKey("tel")) {
                bankBranch.setTel(MiscUtil.getNull(jsonObject.getString("tel")));
            }
            if (jsonObject.containsKey("fax")) {
                bankBranch.setFax(MiscUtil.getNull(jsonObject.getString("fax")));
            }
            if (jsonObject.containsKey("bankName")) {
                bankBranch.setBankName(MiscUtil.getNull(jsonObject.getString("bankName")));
            }
            if (jsonObject.containsKey("provinceCode")) {
                bankBranch.setProvinceCode(MiscUtil.getNull(jsonObject.getString("provinceCode")));
            }
            if (jsonObject.containsKey("provinceName")) {
                bankBranch.setProvinceName(MiscUtil.getNull(jsonObject.getString("provinceName")));
            }
            if (jsonObject.containsKey("status")) {
                bankBranch.setStatus(MiscUtil.getChar(jsonObject.getString("status")));
            }
        } catch (Exception ex) {
            //return null;
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
