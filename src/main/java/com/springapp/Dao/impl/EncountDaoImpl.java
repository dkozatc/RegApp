package com.springapp.dao.impl;

import com.springapp.dao.EncountDao;
import com.springapp.models.Encount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/24/13
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class  EncountDaoImpl implements EncountDao {
    @Autowired
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

    public int insertEncounter(Encount encount){

        String query = "INSERT INTO encounts (id, Diagnosis, Status, PatientID, TimeIn, TemeOut) VALUES (null, ?, ?, ?, ?, ?);";

        this.jdbcTemplate.update(query, new Object[]{
                encount.getDiagnose(),
                encount.getStatus(),
                encount.getPatientID(),
                encount.getTimeIn(),
                encount.getTimeOut()
        });

        return 0;
    }

    public String updateEncouter(Encount encount){


        return null;
    }

    @Override
    public List<Encount> searchEncounters(String query) {

        return null;
    }

    public int getEncounterID(Encount encount){


          return 0;
    }


}
