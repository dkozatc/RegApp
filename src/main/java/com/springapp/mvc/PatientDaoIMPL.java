package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/11/13
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class PatientDaoIMPL {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public DataSource getDataSource() {
        return dataSource;
    }
       @Autowired
    public void setDataSource(DataSource dataSource) {

        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
        System.out.print("set");
    }

    public int getCountPatient(){
        int rowCount;
        rowCount = this.jdbcTemplate.queryForInt("select count(*) from patients");

        return rowCount;
    }



}
