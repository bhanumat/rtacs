/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itos.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itos.model.Province;
import com.itos.util.MiscUtil;
import java.io.IOException;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonProvince {
    public static Province JSONDeserializer(String json, String stringDateFormat) throws IOException {
        Province province = new Province();
        ObjectMapper mapper = new ObjectMapper();
        try {
            province = mapper.readValue(json, Province.class);
        } catch (IOException ex) {
            throw ex;
        }
        return province;
    }
    
    public static Province JSONDeserializerKey(String json, String stringDateFormat) throws IOException {
        Province province = new Province();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("provinceCode")) {
                province.setProvinceCode(MiscUtil.getNull(jsonObject.getString("provinceCode")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return province;
    }
}
