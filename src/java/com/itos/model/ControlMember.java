package com.itos.model;
// Generated Sep 21, 2014 6:09:06 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ControlMember generated by hbm2java
 */
@Entity
@Table(name = "ControlMember", schema = "dbo", catalog = "rtacs"
)
public class ControlMember implements java.io.Serializable {

    private int controlMemberId;
    private BigDecimal applyFee;
    private Integer applicantAgeAllow;
    private Integer sonAgeAllowAtLeast;
    private Integer sonAgeAllow;
    private Integer husbandwifeAgeAllow;
    private Integer parentAgeAllow;
    private BigDecimal paymentCalAmount;
    private Integer percentDeduct;
    private Integer outsYearToRemove;
    private Integer closingDate;
    private Integer monthToRegistered;
    private String director;
    private String assistDirector;
    private Date date;
    private Integer stationId;
    private Integer officerId;

    public ControlMember() {
    }

    public ControlMember(int controlMemberId) {
        this.controlMemberId = controlMemberId;
    }

    public ControlMember(int controlMemberId, BigDecimal applyFee, Integer applicantAgeAllow, Integer sonAgeAllowAtLeast, Integer sonAgeAllow, Integer husbandwifeAgeAllow, Integer parentAgeAllow, BigDecimal paymentCalAmount, Integer percentDeduct, Integer outsYearToRemove, Integer closingDate, Integer monthToRegistered, String director, String assistDirector, Date date, Integer stationId, Integer officerId) {
        this.controlMemberId = controlMemberId;
        this.applyFee = applyFee;
        this.applicantAgeAllow = applicantAgeAllow;
        this.sonAgeAllowAtLeast = sonAgeAllowAtLeast;
        this.sonAgeAllow = sonAgeAllow;
        this.husbandwifeAgeAllow = husbandwifeAgeAllow;
        this.parentAgeAllow = parentAgeAllow;
        this.paymentCalAmount = paymentCalAmount;
        this.percentDeduct = percentDeduct;
        this.outsYearToRemove = outsYearToRemove;
        this.closingDate = closingDate;
        this.monthToRegistered = monthToRegistered;
        this.director = director;
        this.assistDirector = assistDirector;
        this.date = date;
        this.stationId = stationId;
        this.officerId = officerId;
    }

    @Id

    @Column(name = "control_member_id", unique = true, nullable = false)
    public int getControlMemberId() {
        return this.controlMemberId;
    }

    public void setControlMemberId(int controlMemberId) {
        this.controlMemberId = controlMemberId;
    }

    @Column(name = "apply_fee", precision = 10)
    public BigDecimal getApplyFee() {
        return this.applyFee;
    }

    public void setApplyFee(BigDecimal applyFee) {
        this.applyFee = applyFee;
    }

    @Column(name = "applicant_age_allow")
    public Integer getApplicantAgeAllow() {
        return this.applicantAgeAllow;
    }

    public void setApplicantAgeAllow(Integer applicantAgeAllow) {
        this.applicantAgeAllow = applicantAgeAllow;
    }

    @Column(name = "son_age_allow_at_least")
    public Integer getSonAgeAllowAtLeast() {
        return this.sonAgeAllowAtLeast;
    }

    public void setSonAgeAllowAtLeast(Integer sonAgeAllowAtLeast) {
        this.sonAgeAllowAtLeast = sonAgeAllowAtLeast;
    }

    @Column(name = "son_age_allow")
    public Integer getSonAgeAllow() {
        return this.sonAgeAllow;
    }

    public void setSonAgeAllow(Integer sonAgeAllow) {
        this.sonAgeAllow = sonAgeAllow;
    }

    @Column(name = "husbandwife_age_allow")
    public Integer getHusbandwifeAgeAllow() {
        return this.husbandwifeAgeAllow;
    }

    public void setHusbandwifeAgeAllow(Integer husbandwifeAgeAllow) {
        this.husbandwifeAgeAllow = husbandwifeAgeAllow;
    }

    @Column(name = "parent_age_allow")
    public Integer getParentAgeAllow() {
        return this.parentAgeAllow;
    }

    public void setParentAgeAllow(Integer parentAgeAllow) {
        this.parentAgeAllow = parentAgeAllow;
    }

    @Column(name = "payment_cal_amount", precision = 10, scale = 4)
    public BigDecimal getPaymentCalAmount() {
        return this.paymentCalAmount;
    }

    public void setPaymentCalAmount(BigDecimal paymentCalAmount) {
        this.paymentCalAmount = paymentCalAmount;
    }

    @Column(name = "percent_deduct")
    public Integer getPercentDeduct() {
        return this.percentDeduct;
    }

    public void setPercentDeduct(Integer percentDeduct) {
        this.percentDeduct = percentDeduct;
    }

    @Column(name = "outs_year_to_remove")
    public Integer getOutsYearToRemove() {
        return this.outsYearToRemove;
    }

    public void setOutsYearToRemove(Integer outsYearToRemove) {
        this.outsYearToRemove = outsYearToRemove;
    }

    @Column(name = "closing_date")
    public Integer getClosingDate() {
        return this.closingDate;
    }

    public void setClosingDate(Integer closingDate) {
        this.closingDate = closingDate;
    }

    @Column(name = "month_to_registered")
    public Integer getMonthToRegistered() {
        return this.monthToRegistered;
    }

    public void setMonthToRegistered(Integer monthToRegistered) {
        this.monthToRegistered = monthToRegistered;
    }

    @Column(name = "director", length = 200)
    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(name = "assist_director", length = 200)
    public String getAssistDirector() {
        return this.assistDirector;
    }

    public void setAssistDirector(String assistDirector) {
        this.assistDirector = assistDirector;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", length = 23)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "station_id")
    public Integer getStationId() {
        return this.stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Column(name = "officer_id")
    public Integer getOfficerId() {
        return this.officerId;
    }

    public void setOfficerId(Integer officerId) {
        this.officerId = officerId;
    }

}
