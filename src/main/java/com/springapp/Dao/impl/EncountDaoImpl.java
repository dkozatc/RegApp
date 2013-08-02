package com.springapp.dao.impl;

import com.springapp.dao.EncountDao;
import com.springapp.models.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

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


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private ResourceBundle myResources = ResourceBundle.getBundle("com.springapp.properties.EncounterDao");

    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new  NamedParameterJdbcTemplate(this.dataSource);
        System.out.print("set");
    }
    public int insertEncounter(Encounter encounter){

        String query = myResources.getString("insertEncounter");
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(encounter);
        this.namedParameterJdbcTemplate.update(query, namedParameters);
        String sqlQuery = myResources.getString("getEncounterId");
        int id = this.namedParameterJdbcTemplate.queryForInt(sqlQuery, namedParameters);
        return id;
    }
    public String updateEncouter(Encounter encounter){

        String query = myResources.getString("updateEncounter");
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(encounter);
        this.namedParameterJdbcTemplate.update(query, namedParameters);

        return null;
    }
    @Override
    public List<Encounter> getEncounters(String query) {
        String slqQuery = myResources.getString("getEncounterList");
        MapSqlParameterSource paramSource = new MapSqlParameterSource("PatientID", query);
          List<Encounter> encounters = this.namedParameterJdbcTemplate.query(slqQuery, paramSource, new RowMapper() {
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
