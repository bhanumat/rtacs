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
    
    private int paymentId;
    private Date paymentDate;
    private String receiptNo;
    private String memberCode;
    private String militaryName;
    private String citizenId;
    private String title;
    private String name;
    private String surname;
    private BigDecimal amount;
    private int paymentTypeCode;
    private Character printedStatus;

    public MemberPaymentDto() {
    }

    public MemberPaymentDto(int paymentId, Date paymentDate, String receiptNo, String memberCode, String militaryName, String citizenId, String title, String name, String surname, BigDecimal amount, int paymentTypeCode, Character printedStatus) {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.receiptNo = receiptNo;
        this.memberCode = memberCode;
        this.militaryName = militaryName;
        this.citizenId = citizenId;
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.amount = amount;
        this.paymentTypeCode = paymentTypeCode;
        this.printedStatus = printedStatus;
    }

    /**
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return the paymentDate
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the memberCode
     */
    public String getMemberCode() {
        return memberCode;
    }

    /**
     * @param memberCode the memberCode to set
     */
    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    /**
     * @return the militaryName
     */
    public String getMilitaryName() {
        return militaryName;
    }

    /**
     * @param militaryName the militaryName to set
     */
    public void setMilitaryName(String militaryName) {
        this.militaryName = militaryName;
    }

    /**
     * @return the citizenId
     */
    public String getCitizenId() {
        return citizenId;
    }

    /**
     * @param citizenId the citizenId to set
     */
    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the paymentTypeCode
     */
    public int getPaymentTypeCode() {
        return paymentTypeCode;
    }

    /**
     * @param paymentTypeCode the paymentTypeCode to set
     */
    public void setPaymentTypeCode(int paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    /**
     * @return the receiptNo
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * @param receiptNo the receiptNo to set
     */
    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }
    
    /**
     * @return the printedStatus
     */
    public Character getPrintedStatus() {
        return printedStatus;
    }

    /**
     * @param printedStatus the printedStatus to set
     */
    public void setPrintedStatus(Character printedStatus) {
        this.printedStatus = printedStatus;
    }

    @Override
    public String toString() {
        return "MemberPaymentDto{" + "paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", receiptNo=" + receiptNo + ", memberCode=" + memberCode + ", militaryName=" + militaryName + ", citizenId=" + citizenId + ", title=" + title + ", name=" + name + ", surname=" + surname + ", amount=" + amount + ", paymentTypeCode=" + paymentTypeCode + ", printedStatus=" + getPrintedStatus() + '}';
    }
    
}
