/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util.jqGrid;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author ITOS
 */
public class Search {

    private List<Condition> conditions;

    /**
     * @return the conditions
     */
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * @param conditions the conditions to set
     */
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public static Search JSONDeserializer(String json) {
        Condition condition = null;
        try {
            Search searchs = new Search();
            JSONObject jsonObject = new JSONObject();
            jsonObject = JSONObject.fromObject(json);
            //filters.setGroupOp(jsonObject.getString("groupOp"));
            JSONArray jsonArray = jsonObject.getJSONArray("conditions");
            List<Condition> listCondition = new ArrayList<Condition>();
            for (Object objCondition : jsonArray) {
                JSONObject jsonObjectCondition = (JSONObject) objCondition;
                condition = new Condition();
                try {
                    condition.setJoinType(null == jsonObjectCondition.getString("joinType") ? "" : jsonObjectCondition.getString("joinType"));
                } catch (Exception ex) {
                    condition.setJoinType("");
                }
                try {
                    condition.setGroupOp(null == jsonObjectCondition.getString("groupOp") ? "" : jsonObjectCondition.getString("groupOp"));
                } catch (Exception ex) {
                    condition.setGroupOp("");
                }
                try {
                    condition.setDataType(null == jsonObjectCondition.getString("dataType") ? "" : jsonObjectCondition.getString("dataType"));
                } catch (Exception ex) {
                    condition.setDataType("");
                }
                try {
                    condition.setData(null == jsonObjectCondition.getString("data") ? "" : jsonObjectCondition.getString("data"));
                } catch (Exception ex) {
                    condition.setData("");
                }
                try {
                    condition.setOp(null == jsonObjectCondition.getString("op") ? "" : jsonObjectCondition.getString("op"));
                } catch (Exception ex) {
                    condition.setOp("");
                }
                try {
                    condition.setField(null == jsonObjectCondition.getString("field") ? "" : jsonObjectCondition.getString("field"));
                } catch (Exception ex) {
                    condition.setField("");
                }
                listCondition.add(condition);
                condition = null;
            }
            searchs.setConditions(listCondition);
            return searchs;
        } catch (Exception ex) {
            return null;
        }
    }
}
