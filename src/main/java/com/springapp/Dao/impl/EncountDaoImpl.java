package com.springapp.dao.impl;

import com.springapp.dao.EncountDao;
import com.springapp.models.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public int insertEncounter(Encounter encounter){

        String query = "INSERT INTO encounts (id, Diagnosis, Status, PatientID, TimeIn, TimeOut) VALUES (null, ?, ?, ?, ?, ?);";
        this.jdbcTemplate.update(query, new Object[]{
                encounter.getDiagnose(),
                encounter.getStatus(),
                encounter.getPatientID(),
                encounter.getTimeIn(),
                encounter.getTimeOut()
        });
        return 0;
    }
    public String updateEncouter(Encounter encounter){
        String query = "UPDATE encounts SET Diagnosis=?, Status=?, PatientID=?, TimeIn=?, TimeOut=? where id="+
                encounter.getId();
        this.jdbcTemplate.update(query, new Object[]{
               encounter.getDiagnose(),
               encounter.getStatus(),
               encounter.getPatientID(),
               encounter.getTimeIn(),
               encounter.getTimeOut()
        });
        return null;
    }
    @Override
    public List<Encounter> getEncounters(String query) {
        String slqQuery = "SELECT * FROM encounts WHERE PatientID="+query;
          List<Encounter> encounters = this.jdbcTemplate.query(slqQuery, new RowMapper() {
              @Override
              public Encounter mapRow(ResultSet resultSet, int i) throws SQLException {
                  Encounter encounter = new Encounter();
                  encounter.setId(resultSet.getInt("id"));
                  encounter.setDiagnose(resultSet.getString("Diagnosis"));
                  encounter.setStatus(resultSet.getString("Status"));
                  encounter.setPatientID(resultSet.getInt("PatientID"));
                  encounter.setTimeIn(resultSet.getString("TimeIn"));
                  encounter.setTimeOut(resultSet.getString("TimeOut"));
                  return encounter;
              }
          });
        return encounters;
    }
    public int getEncounterID(Encounter encounter){

          return 0;
    }


}
