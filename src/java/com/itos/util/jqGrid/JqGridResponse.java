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

import java.util.Collection;

public class JqGridResponse<T> {

    private int page = 1;
    private int totalPages = 1;
    private int records = 10;
    private Collection<T> rows;

    public JqGridResponse() {
    }

    public JqGridResponse(int page, int totalPages, int records, Collection<T> rows) {
        this.page = page;
        this.totalPages = totalPages;
        this.records = records;
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public Collection<T> getRows() {
        return rows;
    }

    public void setRows(Collection<T> rows) {
        this.rows = rows;
    }
    /*
     @Override
     public String toString() {
     StringBuilder builder = new StringBuilder();
     builder.append("JqGridResponse [page=");
     builder.append(page);
     builder.append(", total=");
     builder.append(total);
     builder.append(", records=");
     builder.append(records);
     builder.append(", ");
     if (rows != null) {
     builder.append("rows=");
     builder.append(rows);
     }
     builder.append("]");
     return builder.toString();
     }
     */
}
