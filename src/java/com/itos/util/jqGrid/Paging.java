/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.itos.util.jqGrid;

/**
 *
 * @author ITOS
 */
public class Paging {
    private int startIndex;
    private int endIndex;
    private int iRecords;
    
    /**
     * @return the startIndex
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * @param startIndex the startIndex to set
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * @return the endIndex
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * @param endIndex the endIndex to set
     */
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    /**
     * @return the iRecords
     */
    public int getiRecords() {
        return iRecords;
    }

    /**
     * @param iRecords the iRecords to set
     */
    public void setiRecords(int iRecords) {
        this.iRecords = iRecords;
    }
}
