/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itos.util.jsonObject;

import java.util.List;

/**
 *
 * @author ITOS
 */
public class CHT010Request {
    
    private List<Integer> memberId;
    private List<Integer> titleameHistoryId;
    private List<Integer> titleId;
    private List<Integer> rankId;
    private List<String> name;
    private List<String> surname;
    private List<String> approvedDate;
    private List<String> approved;
    private List<String> approvedBy;

    public List<Integer> getMemberId() {
        return memberId;
    }

    public void setMemberId(List<Integer> memberId) {
        this.memberId = memberId;
    }

    public List<Integer> getTitleameHistoryId() {
        return titleameHistoryId;
    }

    public void setTitleameHistoryId(List<Integer> titleameHistoryId) {
        this.titleameHistoryId = titleameHistoryId;
    }

    public List<Integer> getTitleId() {
        return titleId;
    }

    public void setTitleId(List<Integer> titleId) {
        this.titleId = titleId;
    }

    public List<Integer> getRankId() {
        return rankId;
    }

    public void setRankId(List<Integer> rankId) {
        this.rankId = rankId;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getSurname() {
        return surname;
    }

    public void setSurname(List<String> surname) {
        this.surname = surname;
    }

    public List<String> getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(List<String> approvedDate) {
        this.approvedDate = approvedDate;
    }

    public List<String> getApproved() {
        return approved;
    }

    public void setApproved(List<String> approved) {
        this.approved = approved;
    }

    public List<String> getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(List<String> approvedBy) {
        this.approvedBy = approvedBy;
    }
    
    
}
