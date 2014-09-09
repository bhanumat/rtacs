/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itos.model.Title;
import com.itos.util.MiscUtil;
import java.io.IOException;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonTitle {

    public static Title JSONDeserializer(String json, String stringDateFormat) throws IOException {
        Title title = new Title();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("titleId")) {
                title.setTitleId(MiscUtil.getInt(jsonObject.getString("titleId")));
            }
            if (jsonObject.containsKey("titleDesc")) {
                title.setTitleDesc(MiscUtil.getNull(jsonObject.getString("titleDesc")));
            }
            if (jsonObject.containsKey("title")) {
                title.setTitle(MiscUtil.getNull(jsonObject.getString("title")));
            }
            if (jsonObject.containsKey("status")) {
                title.setStatus(MiscUtil.getChar(jsonObject.getString("status")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return title;
    }
    
    public static Title JSONDeserializerKey(String json, String stringDateFormat) throws IOException {
        Title title = new Title();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("titleId")) {
                title.setTitleId(MiscUtil.getInt(jsonObject.getString("titleId")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return title;
    }
}
