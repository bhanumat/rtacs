/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itos.model.ext;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author TeTe
 */
public class PaymentMilitary {
    
    private int militaryId;
    private Date docDate;
    private String militaryCode;
    private String militaryName;
    private int sumMember;
    private BigDecimal sumAmount;
    private String memberIdList;

    public int getMilitaryId() {
        return militaryId;
    }

    public void setMilitaryId(int militaryId) {
        this.militaryId = militaryId;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getMilitaryCode() {
        return militaryCode;
    }

    public void setMilitaryCode(String militaryCode) {
        this.militaryCode = militaryCode;
    }

    public String getMilitaryName() {
        return militaryName;
    }

    public void setMilitaryName(String militaryName) {
        this.militaryName = militaryName;
    }

    public int getSumMember() {
        return sumMember;
    }

    public void setSumMember(int sumMember) {
        this.sumMember = sumMember;
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }
    
    public String getMemberIdList() {
        return memberIdList;
    }

    public void setMemberIdList(String memberIdList) {
        this.memberIdList = memberIdList;
    }
}
