/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util.jsonObject;

/**
 *
 * @author ITOS
 */
public class MessageResponse {

    private Boolean checkSuccess = false;
    private String message;
    private String id;
    private Object obj;

    public MessageResponse() {
    }

    public MessageResponse(Boolean checkSuccess, String message) {
        this.checkSuccess = checkSuccess;
        this.message = message;
    }

    public MessageResponse(Boolean checkSuccess, String message, String id, Object obj) {
        this.checkSuccess = checkSuccess;
        this.message = message;
        this.id = id;
        this.obj = obj;
    }

    /**
     * @return the checkSuccess
     */
    public Boolean getCheckSuccess() {
        return checkSuccess;
    }

    /**
     * @param checkSuccess the checkSuccess to set
     */
    public void setCheckSuccess(Boolean checkSuccess) {
        this.checkSuccess = checkSuccess;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the obj
     */
    public Object getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

}
