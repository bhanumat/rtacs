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

public class DeptPaymentDto implements java.io.Serializable {
    private int deptpaymentId;
    private Date paymentDate;
    private Date budgetMonth;
    private String mildeptName;
    private Integer numMember;
    private BigDecimal totalAmount;
    private Integer numMemberIn;
    private Integer numMemberOut;
    private Date createdDate;
    private String username;
    private String remark;

    public DeptPaymentDto() {
    }

    public DeptPaymentDto(int deptpaymentId, Date paymentDate, Date budgetMonth, String mildeptName, Integer numMember, BigDecimal totalAmount, Integer numMemberIn, Integer numMemberOut, Date createdDate, String username, String remark) {
        this.deptpaymentId = deptpaymentId;
        this.paymentDate = paymentDate;
        this.budgetMonth = budgetMonth;
        this.mildeptName = mildeptName;
        this.numMember = numMember;
        this.totalAmount = totalAmount;
        this.numMemberIn = numMemberIn;
        this.numMemberOut = numMemberOut;
        this.createdDate = createdDate;
        this.username = username;
        this.remark = remark;
    }

    /**
     * @return the deptpaymentId
     */
    public int getDeptpaymentId() {
        return deptpaymentId;
    }

    /**
     * @param deptpaymentId the deptpaymentId to set
     */
    public void setDeptpaymentId(int deptpaymentId) {
        this.deptpaymentId = deptpaymentId;
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
     * @return the budgetMonth
     */
    public Date getBudgetMonth() {
        return budgetMonth;
    }

    /**
     * @param budgetMonth the budgetMonth to set
     */
    public void setBudgetMonth(Date budgetMonth) {
        this.budgetMonth = budgetMonth;
    }

    /**
     * @return the mildeptName
     */
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
     * @return the numMember
     */
    public Integer getNumMember() {
        return numMember;
    }

    /**
     * @param numMember the numMember to set
     */
    public void setNumMember(Integer numMember) {
        this.numMember = numMember;
    }

    /**
     * @return the totalAmount
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the numMemberIn
     */
    public Integer getNumMemberIn() {
        return numMemberIn;
    }

    /**
     * @param numMemberIn the numMemberIn to set
     */
    public void setNumMemberIn(Integer numMemberIn) {
        this.numMemberIn = numMemberIn;
    }

    /**
     * @return the numMemberOut
     */
    public Integer getNumMemberOut() {
        return numMemberOut;
    }

    /**
     * @param numMemberOut the numMemberOut to set
     */
    public void setNumMemberOut(Integer numMemberOut) {
        this.numMemberOut = numMemberOut;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
        return "DeptPaymentDto{" + "deptpaymentId=" + getDeptpaymentId() + ", paymentDate=" + getPaymentDate() + ", budgetMonth=" + getBudgetMonth() + ", mildeptName=" + getMildeptName() + ", numMember=" + getNumMember() + ", totalAmount=" + getTotalAmount() + ", numMemberIn=" + getNumMemberIn() + ", numMemberOut=" + getNumMemberOut() + ", createdDate=" + getCreatedDate() + ", username=" + getUsername() + ", remark=" + getRemark() + '}';
    }
}
