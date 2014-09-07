/*
 * Copyright (C) 2011 Toshiaki Maki <makingx@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.itos.util.jqGrid;

/**
 *
 * @author ITOS
 */
public class JqGridRequest {

    private String nd;
    private int rows;
    private int page;
    private String sidx;
    private String sord;
    private String searchField;
    private String searchString;
    private String searchOper;
    //private boolean _search;
    private String filters;
    private boolean search;
    private String searchCommand;

    /**
     * @return the nd
     */
    public String getNd() {
        return nd;
    }

    /**
     * @param nd the nd to set
     */
    public void setNd(String nd) {
        this.nd = nd;
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return the sidx
     */
    public String getSidx() {
        return sidx;
    }

    /**
     * @param sidx the sidx to set
     */
    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    /**
     * @return the sord
     */
    public String getSord() {
        return sord;
    }

    /**
     * @param sord the sord to set
     */
    public void setSord(String sord) {
        this.sord = sord;
    }

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
     * @return the searchString
     */
    public String getSearchString() {
        return searchString;
    }

    /**
     * @param searchString the searchString to set
     */
    public void setSearchString(String searchString) {
        this.searchString = searchString;
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
//
//    /**
//     * @return the _search
//     */
//    public boolean isSearch() {
//        return _search;
//    }
//
//    /**
//     * @param _search the _search to set
//     */
//    public void setSearch(boolean _search) {
//        this._search = _search;
//    }

    /**
     * @return the filters
     */
    public String getFilters() {
        return filters;
    }

    /**
     * @param filters the filters to set
     */
    public void setFilters(String filters) {
        this.filters = filters;
    }

    /**
     * @return the search
     */
    public boolean isSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(boolean search) {
        this.search = search;
    }

    /**
     * @return the searchCommand
     */
    public String getSearchCommand() {
        return searchCommand;
    }

    /**
     * @param searchCommand the searchCommand to set
     */
    public void setSearchCommand(String searchCommand) {
        this.searchCommand = searchCommand;
    }
}
