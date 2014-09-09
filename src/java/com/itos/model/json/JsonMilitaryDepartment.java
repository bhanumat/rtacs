/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itos.model.MilitaryDepartment;
import com.itos.util.MiscUtil;
import java.io.IOException;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonMilitaryDepartment {

    //MilitaryDepartment
    public static MilitaryDepartment JSONDeserializer(String json, String stringDateFormat) throws IOException {
        MilitaryDepartment militaryDepartment = new MilitaryDepartment();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("militaryId")) {
                militaryDepartment.setMilitaryId(MiscUtil.getInt(jsonObject.getString("militaryId")));
            }
            if (jsonObject.containsKey("mildeptId")) {
                militaryDepartment.setMildeptId(MiscUtil.getInt(jsonObject.getString("mildeptId")));
            }
            if (jsonObject.containsKey("name")) {
                militaryDepartment.setName(MiscUtil.getNull(jsonObject.getString("name")));
            }
            if (jsonObject.containsKey("fullname")) {
                militaryDepartment.setFullname(MiscUtil.getNull(jsonObject.getString("fullname")));
            }
            if (jsonObject.containsKey("address1")) {
                militaryDepartment.setAddress1(MiscUtil.getNull(jsonObject.getString("address1")));
            }
            if (jsonObject.containsKey("address2")) {
                militaryDepartment.setAddress2(MiscUtil.getNull(jsonObject.getString("address2")));
            }
            if (jsonObject.containsKey("subdistrict")) {
                militaryDepartment.setSubdistrict(MiscUtil.getNull(jsonObject.getString("subdistrict")));
            }
            if (jsonObject.containsKey("district")) {
                militaryDepartment.setDistrict(MiscUtil.getNull(jsonObject.getString("district")));
            }
            if (jsonObject.containsKey("provinceCode")) {
                militaryDepartment.setProvinceCode(MiscUtil.getNull(jsonObject.getString("provinceCode")));
            }
            if (jsonObject.containsKey("zipcode")) {
                militaryDepartment.setZipcode(MiscUtil.getNull(jsonObject.getString("zipcode")));
            }
            if (jsonObject.containsKey("tel")) {
                militaryDepartment.setTel(MiscUtil.getNull(jsonObject.getString("tel")));
            }
            if (jsonObject.containsKey("fax")) {
                militaryDepartment.setFax(MiscUtil.getNull(jsonObject.getString("fax")));
            }
            if (jsonObject.containsKey("bankAccName")) {
                militaryDepartment.setBankAccName(MiscUtil.getNull(jsonObject.getString("bankAccName")));
            }
            if (jsonObject.containsKey("bankAccNo")) {
                militaryDepartment.setBankAccNo(MiscUtil.getNull(jsonObject.getString("bankAccNo")));
            }
            if (jsonObject.containsKey("mildeptIdForSend")) {
                militaryDepartment.setMildeptIdForSend(MiscUtil.getInt(jsonObject.getString("mildeptIdForSend")));
            }
            if (jsonObject.containsKey("bankCode")) {
                militaryDepartment.setBankCode(MiscUtil.getNull(jsonObject.getString("bankCode")));
            }
            if (jsonObject.containsKey("branchId")) {
                militaryDepartment.setBranchId(MiscUtil.getInt(jsonObject.getString("branchId")));
            }
            if (jsonObject.containsKey("bankAccTypeId")) {
                militaryDepartment.setBankAccTypeId(MiscUtil.getInt(jsonObject.getString("bankAccTypeId")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return militaryDepartment;
    }

    public static MilitaryDepartment JSONDeserializerKey(String json, String stringDateFormat) throws IOException {
        MilitaryDepartment militaryDepartment = new MilitaryDepartment();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("militaryId")) {
                militaryDepartment.setMilitaryId(MiscUtil.getInt(jsonObject.getString("militaryId")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return militaryDepartment;
    }
}
