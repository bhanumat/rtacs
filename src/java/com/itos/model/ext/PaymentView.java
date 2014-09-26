/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.ext;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ITOS
 */
@Entity
@Table(name = "MemberPayment", schema = "dbo", catalog = "rtacs"
)
public class PaymentView implements java.io.Serializable {

    private int rowId;
    private int paymentId;
    private String monthCode;
    private Date budgetMonth;
    private Integer startSopNo;
    private Integer endSopNo;
    private Date paymentDate;
    private Integer paymentTypeCode;
    private BigDecimal amount;
    private BigDecimal payAmount;
    private BigDecimal overAmount;
    private String remark;
    private Integer referenceId;
    private String receiptNo;
    private String mildeptName;
    private String username;

    /**
     * @return the rowId
     */
    @Id
    @Column(name = "rowId", unique = true, nullable = false)
    public int getRowId() {
        return this.rowId;
    }

    /**
     * @param rowId the rowId to set
     */
    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    /**
     * @return the paymentId
     */
    @Column(name = "payment_id")
    public int getPaymentId() {
        return this.paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return the monthCode
     */
    @Column(name = "month_code", length = 5)
    public String getMonthCode() {
        return this.monthCode;
    }

    /**
     * @param monthCode the monthCode to set
     */
    public void setMonthCode(String monthCode) {
        this.monthCode = monthCode;
    }

    /**
     * @return the budgetMonth
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "budget_month", length = 23)
    public Date getBudgetMonth() {
        return this.budgetMonth;
    }

    /**
     * @param budgetMonth the budgetMonth to set
     */
    public void setBudgetMonth(Date budgetMonth) {
        this.budgetMonth = budgetMonth;
    }

    /**
     * @return the startSopNo
     */
    @Column(name = "start_sop_no")
    public Integer getStartSopNo() {
        return this.startSopNo;
    }

    /**
     * @param startSopNo the startSopNo to set
     */
    public void setStartSopNo(Integer startSopNo) {
        this.startSopNo = startSopNo;
    }

    /**
     * @return the endSopNo
     */
    @Column(name = "end_sop_no")
    public Integer getEndSopNo() {
        return this.endSopNo;
    }

    /**
     * @param endSopNo the endSopNo to set
     */
    public void setEndSopNo(Integer endSopNo) {
        this.endSopNo = endSopNo;
    }

    /**
     * @return the paymentDate
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date", length = 23)
    public Date getPaymentDate() {
        return this.paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the paymentTypeCode
     */
    @Column(name = "payment_type_code")
    public Integer getPaymentTypeCode() {
        return this.paymentTypeCode;
    }

    /**
     * @param paymentTypeCode the paymentTypeCode to set
     */
    public void setPaymentTypeCode(Integer paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    /**
     * @return the referenceId
     */
    @Column(name = "reference_id")
    public Integer getReferenceId() {
        return this.referenceId;
    }

    /**
     * @param referenceId the referenceId to set
     */
    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    /**
     * @return the payAmount
     */
    @Column(name = "pay_amount", precision = 14, scale = 4)
    public BigDecimal getPayAmount() {
        return this.payAmount;
    }

    /**
     * @param payAmount the payAmount to set
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * @return the amount
     */
    @Column(name = "amount", precision = 14, scale = 4)
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the overAmount
     */
    @Column(name = "over_amount", precision = 14, scale = 4)
    public BigDecimal getOverAmount() {
        return this.overAmount;
    }

    /**
     * @param overAmount the overAmount to set
     */
    public void setOverAmount(BigDecimal overAmount) {
        this.overAmount = overAmount;
    }

    /**
     * @return the remark
     */
    @Column(name = "remark")
    public String getRemark() {
        return this.remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the receiptNo
     */
    @Column(name = "receipt_no", length = 10)
    public String getReceiptNo() {
        return this.receiptNo;
    }

    /**
     * @param receiptNo the receiptNo to set
     */
    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    /**
     * @return the receiptNo
     */
    @Column(name = "mildept_name", length = 50)
    public String getMildeptName() {
        return mildeptName;
    }

    /**
     * @param mildeptName the mildeptName to set
     */
    public void setMildeptName(String mildeptName) {
        this.mildeptName = mildeptName;
    }

    /**
     * @return the username
     */
    @Column(name = "username", length = 256)
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
