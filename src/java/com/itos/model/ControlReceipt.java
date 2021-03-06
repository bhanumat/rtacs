package com.itos.model;
// Generated Sep 21, 2014 6:09:06 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ControlReceipt generated by hbm2java
 */
@Entity
@Table(name = "ControlReceipt", schema = "dbo", catalog = "rtacs"
)
public class ControlReceipt implements java.io.Serializable {

    private int controlReceiptId;
    private Integer stationId;
    private Character groupCode;
    private Integer runningNo;

    public ControlReceipt() {
    }

    public ControlReceipt(int controlReceiptId) {
        this.controlReceiptId = controlReceiptId;
    }

    public ControlReceipt(int controlReceiptId, Integer stationId, Character groupCode, Integer runningNo) {
        this.controlReceiptId = controlReceiptId;
        this.stationId = stationId;
        this.groupCode = groupCode;
        this.runningNo = runningNo;
    }

    @Id

    @Column(name = "control_receipt_id", unique = true, nullable = false)
    public int getControlReceiptId() {
        return this.controlReceiptId;
    }

    public void setControlReceiptId(int controlReceiptId) {
        this.controlReceiptId = controlReceiptId;
    }

    @Column(name = "station_id")
    public Integer getStationId() {
        return this.stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Column(name = "group_code", length = 1)
    public Character getGroupCode() {
        return this.groupCode;
    }

    public void setGroupCode(Character groupCode) {
        this.groupCode = groupCode;
    }

    @Column(name = "running_no")
    public Integer getRunningNo() {
        return this.runningNo;
    }

    public void setRunningNo(Integer runningNo) {
        this.runningNo = runningNo;
    }

}
