/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.impl;

import com.itos.dao.model.IJdbcRTACSDBDAO;
import javax.sql.DataSource;

/**
 *
 * @author ITOS
 */
public class JdbcRTACSDBDAO implements IJdbcRTACSDBDAO {

    private DataSource dataSource;

    @Override
    public DataSource getDataSource() {
        return this.dataSource;
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
