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
 * @author Aui
 */
public class MemberPaymentDto {
    
    private int memberPaymentId;
    private Date paymentDate;
    private String referenceId;
    private String memberCode;
    private String militaryName;
    private String citizenId;
    private String title;
    private String name;
    private String surname;
    private BigDecimal amount;
    private int paymentTypeCode;
    private String paymentStatus;
    
     public int getMemberPaymentId() {
        return memberPaymentId;
    }

    public void setMemberPaymentId(int memberPaymentId) {
        this.memberPaymentId = memberPaymentId;
    }
    
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getMilitaryName() {
        return militaryName;
    }

    public void setMilitaryName(String militaryName) {
        this.militaryName = militaryName;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }
    
    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(int paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
}
