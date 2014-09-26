/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.model.ext;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Formula;

/**
 *
 * @author ITOS
 */
@Entity
@Table(name = "OperationMember", schema = "dbo", catalog = "rtacs"
)
public class MemberStatusView {

    private int rowId;
    private Date createDate;
    private Integer operationTypeCode;
    private String name;

    public MemberStatusView() {

    }

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
     * @return the operationTypeCode
     */
    @Column(name = "operation_type_code")
    public Integer getOperationTypeCode() {
        return operationTypeCode;
    }

    /**
     * @param operationTypeCode the operationTypeCode to set
     */
    public void setOperationTypeCode(Integer operationTypeCode) {
        this.operationTypeCode = operationTypeCode;
    }

    /**
     * @return the createDate
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", length = 23)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the userProfileNameTh
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
