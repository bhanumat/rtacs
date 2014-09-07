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
        ObjectMapper mapper = new ObjectMapper();
        try {
            militaryDepartment = mapper.readValue(json, MilitaryDepartment.class);
        } catch (IOException ex) {
            throw ex;
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
