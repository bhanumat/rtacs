/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itos.util.jqGrid;

/**
 *
 * @author ITOS
 */
public class Condition {
    private String groupOp;
    private String field;
    private String op;
    private String data;
    private String dataType;
    private String joinType;

    /**
     * @return the groupOp
     */
    public String getGroupOp() {
        return groupOp;
    }

    /**
     * @param groupOp the groupOp to set
     */
    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * @return the op
     */
    public String getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the joinType
     */
    public String getJoinType() {
        return joinType;
    }

    /**
     * @param joinType the joinType to set
     */
    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }
}
