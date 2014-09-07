/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util.jqGrid;

/**
 * Inner class containing field rules
 */
public class Rule {

    private String junction;
    private String field;
    private String op;
    private String data;

    public Rule() {
    }

    public Rule(String junction, String field, String op, String data) {
        super();
        this.junction = junction;
        this.field = field;
        this.op = op;
        this.data = data;
    }

    public String getJunction() {
        return junction;
    }

    public void setJunction(String junction) {
        this.junction = junction;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
