/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.json;

import com.itos.model.ext.RegisterNo;
import com.itos.util.MiscUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonRegisterNo {

    public static List<RegisterNo> JSONDeserializer(String json, String stringDateFormat) throws IOException {
        List<RegisterNo> listRegisterNo = new ArrayList<>();
        RegisterNo registerNo;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            if (jsonObject.containsKey("RegisterNo")) {
                JSONArray jsonArray = jsonObject.getJSONArray("RegisterNo");
                for (Object objRegisterNo : jsonArray) {
                    JSONObject jsonObjectRegisterNo = (JSONObject) objRegisterNo;
                    registerNo = new RegisterNo();
                    if (jsonObjectRegisterNo.containsKey("memberId")) {
                        registerNo.setMemberId(MiscUtil.getInt(jsonObjectRegisterNo.getString("memberId")));
                    }
                    if (jsonObjectRegisterNo.containsKey("memberCode")) {
                        registerNo.setMemberCode(MiscUtil.getNull(jsonObjectRegisterNo.getString("memberCode")));
                    }
                    listRegisterNo.add(registerNo);
                }
            }
        } catch (Exception ex) {
            //return null;
        }
        return listRegisterNo;
    }

}
