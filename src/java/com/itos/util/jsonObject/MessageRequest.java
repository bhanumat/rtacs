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
public class MessageRequest {
    private List<String> itemSelect;
    private String userProfileId;
    private String userProfileCode;
    private String dataSource;

    /**
     * @return the itemSelect
     */
    public List<String> getItemSelect() {
        return itemSelect;
    }

    /**
     * @param itemSelect the itemSelect to set
     */
    public void setItemSelect(List<String> itemSelect) {
        this.itemSelect = itemSelect;
    }

    /**
     * @return the userProfileId
     */
    public String getUserProfileId() {
        return userProfileId;
    }

    /**
     * @param userProfileId the userProfileId to set
     */
    public void setUserProfileId(String userProfileId) {
        this.userProfileId = userProfileId;
    }

    /**
     * @return the userProfileCode
     */
    public String getUserProfileCode() {
        return userProfileCode;
    }

    /**
     * @param userProfileCode the userProfileCode to set
     */
    public void setUserProfileCode(String userProfileCode) {
        this.userProfileCode = userProfileCode;
    }

    /**
     * @return the dataSource
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    
}
