/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itos.model.ext;

import java.util.Date;

/**
 *
 * @author TeTe
 */
public class ChangeMemberData {
    
    private Date createdDate;
    private String militaryName;
    private String memberCode;
    private int memberId;
    private String oldName;
    private String newName;
    private String fileTypeCode;
    private String approved;
    private String remark;
    private String memberStatusCode;
    private int titleameHistoryId;
    private Integer titleId;
    private Integer rankId;
    private String nameHidden;
    private String surnameHidden;

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getNameHidden() {
        return nameHidden;
    }

    public void setNameHidden(String nameHidden) {
        this.nameHidden = nameHidden;
    }

    public String getSurnameHidden() {
        return surnameHidden;
    }

    public void setSurnameHidden(String surnameHidden) {
        this.surnameHidden = surnameHidden;
    }
    
    public int getTitleameHistoryId() {
        return titleameHistoryId;
    }

    public void setTitleameHistoryId(int titleameHistoryId) {
        this.titleameHistoryId = titleameHistoryId;
    }
    
    public String getMemberStatusCode() {
        return memberStatusCode;
    }

    public void setMemberStatusCode(String memberStatusCode) {
        this.memberStatusCode = memberStatusCode;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getMilitaryName() {
        return militaryName;
    }

    public void setMilitaryName(String militaryName) {
        this.militaryName = militaryName;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getFileTypeCode() {
        return fileTypeCode;
    }

    public void setFileTypeCode(String fileTypeCode) {
        this.fileTypeCode = fileTypeCode;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
