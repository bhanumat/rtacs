/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util.jqGrid;

import java.util.List;

/**
 * A POJO that represents a jQgrid JSON requests {@link String}<br/>
 * A sample filter follows the following format:
 * <pre>
 * {"groupOp":"AND","rules":[{"field":"firstName","op":"eq","data":"John"}]}
 * </pre>
 */
public class Filter {

    private String source;
    private String groupOp;
    private List<Rule> rules;

    public Filter() {
        super();
    }

    public Filter(String source) {
        super();
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGroupOp() {
        return groupOp;
    }

    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
