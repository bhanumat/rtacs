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
public class MemberPaymentHeadDto {
    private int paymentId;
    private Integer memberId;
    private Date paymentDate;
    private String receiptNo;
    private Integer paymentTypeCode;
    private BigDecimal amount;
    private String paymentDetail;
    private Integer sopAmount;
    private boolean paymentFlag;
    private String remark;

    public MemberPaymentHeadDto() {
    }

    public MemberPaymentHeadDto(Date paymentDate, BigDecimal amount, String paymentDetail, Integer sopAmount) {
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentDetail = paymentDetail;
        this.sopAmount = sopAmount;
    }
    

    public MemberPaymentHeadDto(int paymentId, Integer memberId, Date paymentDate, String receiptNo, Integer paymentTypeCode, BigDecimal amount, String paymentDetail, Integer sopAmount, boolean paymentFlag, String remark) {
        this.paymentId = paymentId;
        this.memberId = memberId;
        this.paymentDate = paymentDate;
        this.receiptNo = receiptNo;
        this.paymentTypeCode = paymentTypeCode;
        this.amount = amount;
        this.paymentDetail = paymentDetail;
        this.sopAmount = sopAmount;
        this.paymentFlag = paymentFlag;
        this.remark = remark;
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
     * @return the memberId
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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
     * @return the paymentTypeCode
     */
    public Integer getPaymentTypeCode() {
        return paymentTypeCode;
    }

    /**
     * @param paymentTypeCode the paymentTypeCode to set
     */
    public void setPaymentTypeCode(Integer paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
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
     * @return the paymentDetail
     */
    public String getPaymentDetail() {
        return paymentDetail;
    }

    /**
     * @param paymentDetail the paymentDetail to set
     */
    public void setPaymentDetail(String paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    /**
     * @return the sopAmount
     */
    public Integer getSopAmount() {
        return sopAmount;
    }

    /**
     * @param sopAmount the sopAmount to set
     */
    public void setSopAmount(Integer sopAmount) {
        this.sopAmount = sopAmount;
    }

    /**
     * @return the paymentFlag
     */
    public boolean isPaymentFlag() {
        return paymentFlag;
    }

    /**
     * @param paymentFlag the paymentFlag to set
     */
    public void setPaymentFlag(boolean paymentFlag) {
        this.paymentFlag = paymentFlag;
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

    @Override
    public String toString() {
        return "MemberPaymentHeadDto{" + "paymentId=" + paymentId + ", memberId=" + memberId + ", paymentDate=" + paymentDate + ", receiptNo=" + receiptNo + ", paymentTypeCode=" + paymentTypeCode + ", amount=" + amount + ", paymentDetail=" + paymentDetail + ", sopAmount=" + sopAmount + ", paymentFlag=" + paymentFlag + ", remark=" + remark + '}';
    }
    
    
}
