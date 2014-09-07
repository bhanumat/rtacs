/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.dao.model;

import javax.sql.DataSource;

/**
 *
 * @author ITOS
 */
public interface IJdbcRTACSDBDAO {

    public DataSource getDataSource();

    public void setDataSource(DataSource dataSource);
}
