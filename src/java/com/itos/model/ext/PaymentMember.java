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
public class PaymentMember {
    
    private int operationMemberId;
    private Date docDate;
    private String docCode;
    private String MilitaryName;
    private String citizenID;
    private String title;
    private String name;
    private String surname;
    private BigDecimal amount;
    private int typeCode;
    private String printedStatus;
    
     public int getOperationMemberId() {
        return operationMemberId;
    }

    public void setOperationMemberId(int operationMemberId) {
        this.operationMemberId = operationMemberId;
    }
    
    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getMilitaryName() {
        return MilitaryName;
    }

    public void setMilitaryName(String MilitaryName) {
        this.MilitaryName = MilitaryName;
    }

    public String getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
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

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getPrintedStatus() {
        return printedStatus;
    }

    public void setPrintedStatus(String printedStatus) {
        this.printedStatus = printedStatus;
    }
    
    
}
