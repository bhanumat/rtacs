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
public class DeptMemberPaymentDto extends MemberPaymentDto{
    private int memberId;
    private BigDecimal paymentAmount;
    private Integer typeCode;
    private String description;
    private String remark;
    private String mildeptNameIn;
    private String mildeptNameOut;

    public DeptMemberPaymentDto() {
    }

    public DeptMemberPaymentDto(int memberId, BigDecimal paymentAmount, Integer typeCode, String remark, String mildeptNameIn, String mildeptNameOut) {
        this.memberId = memberId;
        this.paymentAmount = paymentAmount;
        this.typeCode = typeCode;
        this.remark = remark;
        this.mildeptNameIn = mildeptNameIn;
        this.mildeptNameOut = mildeptNameOut;
    }

    public DeptMemberPaymentDto(int memberId, BigDecimal paymentAmount, Integer typeCode, String description, String remark, String mildeptNameIn, String mildeptNameOut, int paymentId, Date paymentDate, String receiptNo, String memberCode, String militaryName, String citizenId, String title, String name, String surname, BigDecimal amount, int paymentTypeCode, Character printedStatus) {
        super(paymentId, paymentDate, receiptNo, memberCode, militaryName, citizenId, title, name, surname, amount, paymentTypeCode, printedStatus);
        this.memberId = memberId;
        this.paymentAmount = paymentAmount;
        this.typeCode = typeCode;
        this.description = description;
        this.remark = remark;
        this.mildeptNameIn = mildeptNameIn;
        this.mildeptNameOut = mildeptNameOut;
    }

    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the paymentAmount
     */
    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount the paymentAmount to set
     */
    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * @return the typeCode
     */
    public Integer getTypeCode() {
        return typeCode;
    }

    /**
     * @param typeCode the typeCode to set
     */
    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the mildeptNameIn
     */
    public String getMildeptNameIn() {
        return mildeptNameIn;
    }

    /**
     * @param mildeptNameIn the mildeptNameIn to set
     */
    public void setMildeptNameIn(String mildeptNameIn) {
        this.mildeptNameIn = mildeptNameIn;
    }

    /**
     * @return the mildeptNameOut
     */
    public String getMildeptNameOut() {
        return mildeptNameOut;
    }

    /**
     * @param mildeptNameOut the mildeptNameOut to set
     */
    public void setMildeptNameOut(String mildeptNameOut) {
        this.mildeptNameOut = mildeptNameOut;
    }

    @Override
    public String toString() {
        return "DeptMemberPaymentDto{" + "memberId=" + memberId + ", paymentAmount=" + paymentAmount + ", typeCode=" + typeCode + ", description=" + description + ", remark=" + remark + ", mildeptNameIn=" + mildeptNameIn + ", mildeptNameOut=" + mildeptNameOut + '}';
    }
    
}
