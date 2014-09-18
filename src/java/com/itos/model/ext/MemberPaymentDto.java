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

    public MemberPaymentDto() {
    }

    public MemberPaymentDto(int memberPaymentId, Date paymentDate, String referenceId, String memberCode, String militaryName, String citizenId, String title, String name, String surname, BigDecimal amount, int paymentTypeCode, String paymentStatus) {
        this.memberPaymentId = memberPaymentId;
        this.paymentDate = paymentDate;
        this.referenceId = referenceId;
        this.memberCode = memberCode;
        this.militaryName = militaryName;
        this.citizenId = citizenId;
        this.title = title;
        this.name = name;
        this.surname = surname;
        this.amount = amount;
        this.paymentTypeCode = paymentTypeCode;
        this.paymentStatus = paymentStatus;
    }
    
    /**
     * @return the memberPaymentId
     */
    public int getMemberPaymentId() {
        return memberPaymentId;
    }

    /**
     * @param memberPaymentId the memberPaymentId to set
     */
    public void setMemberPaymentId(int memberPaymentId) {
        this.memberPaymentId = memberPaymentId;
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
     * @return the referenceId
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * @param referenceId the referenceId to set
     */
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
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
     * @return the paymentStatus
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * @param paymentStatus the paymentStatus to set
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
}
