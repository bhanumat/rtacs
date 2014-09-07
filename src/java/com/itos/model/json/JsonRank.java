/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itos.model.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itos.model.Rank;
import com.itos.util.MiscUtil;
import java.io.IOException;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonRank {
    public static Rank JSONDeserializer(String json, String stringDateFormat) throws IOException {
        Rank rank = new Rank();
        ObjectMapper mapper = new ObjectMapper();
        try {
            rank = mapper.readValue(json, Rank.class);
        } catch (IOException ex) {
            throw ex;
        }
        return rank;
    }
    
    public static Rank JSONDeserializerKey(String json, String stringDateFormat) throws IOException {
        Rank rank = new Rank();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("rankId")) {
                rank.setRankId(MiscUtil.getInt(jsonObject.getString("rankId")));
            }
        } catch (Exception ex) {
            //return null;
        }
        return rank;
    }
}
