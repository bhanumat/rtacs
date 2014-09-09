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
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("rankId")) {
                rank.setRankId(MiscUtil.getInt(jsonObject.getString("rankId")));
            }
            if (jsonObject.containsKey("rankName")) {
                rank.setRankName(MiscUtil.getNull(jsonObject.getString("rankName")));
            }
            if (jsonObject.containsKey("rankClassCode")) {
                rank.setRankClassCode(MiscUtil.getInt(jsonObject.getString("rankClassCode")));
            }
            if (jsonObject.containsKey("rankFullname")) {
                rank.setRankFullname(MiscUtil.getNull(jsonObject.getString("rankFullname")));
            }
            if (jsonObject.containsKey("rankOrder")) {
                rank.setRankOrder(MiscUtil.getInt(jsonObject.getString("rankOrder")));
            }
            if (jsonObject.containsKey("status")) {
                rank.setStatus(MiscUtil.getChar(jsonObject.getString("status")));
            }
        } catch (Exception ex) {
            //return null;
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
