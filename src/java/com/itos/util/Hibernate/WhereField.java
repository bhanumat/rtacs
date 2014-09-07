/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util.Hibernate;

/**
 *
 * @author ITOS
 */
public class WhereField {

    private String searchField;
    private Object searchValue;
    private String searchOper;
    private String searchLogic;
    private int searchValueInt;
    private String searchDataType;
    

    /**
     * @return the searchField
     */
    public String getSearchField() {
        return searchField;
    }

    /**
     * @param searchField the searchField to set
     */
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    /**
     * @return the searchValue
     */
    public Object getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(Object searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * @return the searchOper
     */
    public String getSearchOper() {
        return searchOper;
    }

    /**
     * @param searchOper the searchOper to set
     */
    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    /**
     * @return the searchLogic
     */
    public String getSearchLogic() {
        return searchLogic;
    }

    /**
     * @param searchLogic the searchLogic to set
     */
    public void setSearchLogic(String searchLogic) {
        this.searchLogic = searchLogic;
    }

    /**
     * @return the searchValueInt
     */
    public int getSearchValueInt() {
        return searchValueInt;
    }

    /**
     * @param searchValueInt the searchValueInt to set
     */
    public void setSearchValueInt(int searchValueInt) {
        this.searchValueInt = searchValueInt;
    }

    /**
     * @return the searchDataType
     */
    public String getSearchDataType() {
        return searchDataType;
    }

    /**
     * @param searchDataType the searchDataType to set
     */
    public void setSearchDataType(String searchDataType) {
        this.searchDataType = searchDataType;
    }
}
