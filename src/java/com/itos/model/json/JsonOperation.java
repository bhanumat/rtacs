/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itos.model.json;

import com.itos.model.Operation;
import com.itos.util.MiscUtil;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class JsonOperation {
    public static Operation JSONDeserializer(String json, String stringDateFormat) {

        Operation operation = new Operation();
        List<Integer> itemSelectInteger = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            operation.setDocCode(MiscUtil.getNull(jsonObject.getString("DocCode")));
            operation.setDocDate(MiscUtil.getDate(jsonObject.getString("DocDate"), stringDateFormat));
            String itemSelectString = jsonObject.getString("ItemSelect");
            String[] itemSelectArrary = itemSelectString.split(",");
            for (String objectInteger : itemSelectArrary) {
                if (!objectInteger.isEmpty()) {
                    itemSelectInteger.add(Integer.parseInt(objectInteger));
                }
            }
            operation.setItemSelect(itemSelectInteger);
            //operationModify.setName(MiscUtil.getNull(jsonObject.getString("name")));
        } catch (Exception ex) {
            throw ex;
        }
        return operation;
    }
}
