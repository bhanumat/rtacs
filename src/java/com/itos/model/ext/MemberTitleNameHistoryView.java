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

/**
 *
 * @author ITOS
 */
@Entity
@Table(name = "MemberTitleNameHistory", schema = "dbo", catalog = "rtacs"
)
public class MemberTitleNameHistoryView {

    private int rowId;
    private Date createdDate;
    private String titleRank;
    private String name;
    private String surname;
    private int approved;
    private int fileTypeCode;
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
     * @return the createdDate
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", length = 23)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the titleRank
     */
    @Column(name = "title_rank")
    public String getTitleRank() {
        return titleRank;
    }

    /**
     * @param titleRank the titleRank to set
     */
    public void setTitleRank(String titleRank) {
        this.titleRank = titleRank;
    }

    /**
     * @return the name
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

    /**
     * @return the surname
     */
    @Column(name = "surname")
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
     * @return the approved
     */
    @Column(name = "approved")
    public int getApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(int approved) {
        this.approved = approved;
    }

    /**
     * @return the fileTypeCode
     */
    @Column(name = "file_type_code")
    public int getFileTypeCode() {
        return fileTypeCode;
    }

    /**
     * @param fileTypeCode the fileTypeCode to set
     */
    public void setFileTypeCode(int fileTypeCode) {
        this.fileTypeCode = fileTypeCode;
    }

    /**
     * @return the username
     */
    @Column(name = "username")
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
