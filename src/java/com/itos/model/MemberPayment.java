package com.itos.model;
// Generated Sep 13, 2014 5:40:42 PM by Hibernate Tools 3.6.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MemberPayment generated by hbm2java
 */
@Entity
@Table(name = "MemberPayment", schema = "dbo", catalog = "rtacs"
)
public class MemberPayment implements java.io.Serializable {

    private int paymentId;
    private int memberId;
    private Date paymentDate;
    private String monthCode;
    private Integer paymentTypeCode;
    private Integer referenceId;
    private String bankCode;
    private String bankAccNo;
    private Integer bankOperationId;
    private BigDecimal bankPayAmount;
    private BigDecimal payAmount;
    private BigDecimal amount;
    private BigDecimal overAmount;
    private Integer cancelFlag;
    private String remark;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;

    public MemberPayment() {
    }

    public MemberPayment(int paymentId, int memberId) {
        this.paymentId = paymentId;
        this.memberId = memberId;
    }

    public MemberPayment(int paymentId, int memberId, Date paymentDate, String monthCode, Integer paymentTypeCode, Integer referenceId, String bankCode, String bankAccNo, Integer bankOperationId, BigDecimal bankPayAmount, BigDecimal payAmount, BigDecimal amount, BigDecimal overAmount, Integer cancelFlag, String remark, Date createdDate, String createdBy, Date updatedDate, String updatedBy) {
        this.paymentId = paymentId;
        this.memberId = memberId;
        this.paymentDate = paymentDate;
        this.monthCode = monthCode;
        this.paymentTypeCode = paymentTypeCode;
        this.referenceId = referenceId;
        this.bankCode = bankCode;
        this.bankAccNo = bankAccNo;
        this.bankOperationId = bankOperationId;
        this.bankPayAmount = bankPayAmount;
        this.payAmount = payAmount;
        this.amount = amount;
        this.overAmount = overAmount;
        this.cancelFlag = cancelFlag;
        this.remark = remark;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_id", unique = true, nullable = false)
    public int getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Column(name = "member_id", nullable = false)
    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "payment_date", length = 23)
    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(name = "month_code", length = 5)
    public String getMonthCode() {
        return this.monthCode;
    }

    public void setMonthCode(String monthCode) {
        this.monthCode = monthCode;
    }

    @Column(name = "payment_type_code")
    public Integer getPaymentTypeCode() {
        return this.paymentTypeCode;
    }

    public void setPaymentTypeCode(Integer paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    @Column(name = "reference_id")
    public Integer getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    @Column(name = "bank_code", length = 5)
    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Column(name = "bank_acc_no", length = 15)
    public String getBankAccNo() {
        return this.bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    @Column(name = "bank_operation_id")
    public Integer getBankOperationId() {
        return this.bankOperationId;
    }

    public void setBankOperationId(Integer bankOperationId) {
        this.bankOperationId = bankOperationId;
    }

    @Column(name = "bank_pay_amount", precision = 14, scale = 4)
    public BigDecimal getBankPayAmount() {
        return this.bankPayAmount;
    }

    public void setBankPayAmount(BigDecimal bankPayAmount) {
        this.bankPayAmount = bankPayAmount;
    }

    @Column(name = "pay_amount", precision = 14, scale = 4)
    public BigDecimal getPayAmount() {
        return this.payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    @Column(name = "amount", precision = 14, scale = 4)
    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "over_amount", precision = 14, scale = 4)
    public BigDecimal getOverAmount() {
        return this.overAmount;
    }

    public void setOverAmount(BigDecimal overAmount) {
        this.overAmount = overAmount;
    }

    @Column(name = "cancel_flag")
    public Integer getCancelFlag() {
        return this.cancelFlag;
    }

    public void setCancelFlag(Integer cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    @Column(name = "remark")
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", length = 23)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "created_by")
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", length = 23)
    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Column(name = "updated_by")
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
