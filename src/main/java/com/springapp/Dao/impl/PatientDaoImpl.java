package com.springapp.dao.impl;

import com.springapp.dao.PatientDao;
import com.springapp.models.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/11/13
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class PatientDaoImpl implements PatientDao {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private ResourceBundle myResources = ResourceBundle.getBundle("com.springapp.properties.PatientDao");
    private final String INSERT_PATIENT = myResources.getString("insertPatient");
    private final String UPDATE_PATIENT = myResources.getString("updatePatient");
    private final String GET_PATIENT_LIST = myResources.getString("getPatientList");

    public DataSource getDataSource() {
        return dataSource;
    }
       @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
           this.namedParameterJdbcTemplate = new  NamedParameterJdbcTemplate(this.dataSource);
        System.out.print("set");
    }
    public int insertPatient(PatientModel patient){
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(patient);
        this.namedParameterJdbcTemplate.update(this.INSERT_PATIENT, namedParameters);
        return  0;
    }
    public String updatePatient(PatientModel patient){
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(patient);
        this.namedParameterJdbcTemplate.update(this.UPDATE_PATIENT, namedParameters);

        return "";
    }
    public @ResponseBody List<PatientModel> searchPatients(String inputString){

        String param = "%"+inputString+ "%";
        MapSqlParameterSource paramSource = new MapSqlParameterSource("searchInput", param);

        List<PatientModel> patients = this.namedParameterJdbcTemplate.query(this.GET_PATIENT_LIST, paramSource, new PatientRowMapper());
        System.out.print(patients);
        return patients;
    }
    public int getPatientID(PatientModel patient){
        String query = myResources.getString("getPatientId");
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(patient);
        int rowCount;
        rowCount = this.namedParameterJdbcTemplate.queryForInt(query, namedParameters);
        return rowCount;
    }
     public PatientModel getPatientById(String id){

         String query = myResources.getString("getPatientById");
         MapSqlParameterSource paramSource = new MapSqlParameterSource("PatientID", id);
         PatientModel patient = (PatientModel) this.namedParameterJdbcTemplate.queryForObject(query,paramSource ,new PatientRowMapper());
         return patient;
     }



}
