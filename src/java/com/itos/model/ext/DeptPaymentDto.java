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
    private String budgetMonth;
    private String mildeptName;
    private Integer numMember;
    private BigDecimal totalAmount;
    private Integer numMemberIn;
    private Integer numMemberOut;
    private Date createdDate;
    private String username;

    public DeptPaymentDto() {
    }

    public DeptPaymentDto(int deptpaymentId, Date paymentDate, String budgetMonth, Integer numMember, BigDecimal totalAmount, Integer numMemberIn, Integer numMemberOut, Date createdDate, String username) {
        this.deptpaymentId = deptpaymentId;
        this.paymentDate = paymentDate;
        this.budgetMonth = budgetMonth;
        this.numMember = numMember;
        this.totalAmount = totalAmount;
        this.numMemberIn = numMemberIn;
        this.numMemberOut = numMemberOut;
        this.createdDate = createdDate;
        this.username = username;
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
    public String getBudgetMonth() {
        return budgetMonth;
    }

    /**
     * @param budgetMonth the budgetMonth to set
     */
    public void setBudgetMonth(String budgetMonth) {
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

    @Override
    public String toString() {
        return "DeptPaymentDto{" + "deptpaymentId=" + deptpaymentId + ", paymentDate=" + paymentDate + ", budgetMonth=" + budgetMonth + ", mildeptName=" + mildeptName + ", numMember=" + numMember + ", totalAmount=" + totalAmount + ", numMemberIn=" + numMemberIn + ", numMemberOut=" + numMemberOut + ", createdDate=" + createdDate + ", username=" + username + '}';
    }
}
