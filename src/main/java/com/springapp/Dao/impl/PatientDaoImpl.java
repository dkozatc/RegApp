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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private ResourceBundle myResources = ResourceBundle.getBundle("com.springapp.properties.PatientDao");
    private final String INSERT_PATIENT = myResources.getString("insertPatient");
    private final String UPDATE_PATIENT = myResources.getString("updatePatient");
    private final String GET_PATIENT_LIST = myResources.getString("getPatientList");
    private final String GET_PATIENT_BY_SSN = myResources.getString("getPatientBySSN");
    private final String GET_PATIENT_BY_ID = myResources.getString("getPatientById");
    private final String DELETE_PATIENT = myResources.getString("deletePatient");

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        System.out.print("set");
    }

    public int insertPatient(PatientModel patient) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(patient);
        this.namedParameterJdbcTemplate.update(this.INSERT_PATIENT, namedParameters, keyHolder);
        Number returnId = keyHolder.getKey();
        int id = returnId.intValue();
        return id;
    }

    public String updatePatient(PatientModel patient) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(patient);
        this.namedParameterJdbcTemplate.update(this.UPDATE_PATIENT, namedParameters);
        return "Dane";
    }

    public
    @ResponseBody
    List<PatientModel> searchPatients(String inputString) {
        String param = "%" + inputString + "%";
        MapSqlParameterSource paramSource = new MapSqlParameterSource("searchInput", param);
        List<PatientModel> patients = this.namedParameterJdbcTemplate.query(this.GET_PATIENT_LIST, paramSource, new PatientRowMapper());
        System.out.print(patients);
        return patients;
    }

    public int getPatientID(PatientModel patient) {
        String query = myResources.getString("getPatientId");
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(patient);
        int rowCount;
        rowCount = this.namedParameterJdbcTemplate.queryForInt(query, namedParameters);
        return rowCount;
    }

    public PatientModel getPatientById(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource("PatientID", id);
        PatientModel patient = (PatientModel) this.namedParameterJdbcTemplate.queryForObject(GET_PATIENT_BY_ID, paramSource, new PatientRowMapper());
        return patient;
    }

    @Override
    public PatientModel getPatientBySSN(String SSN) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource("SSN", SSN);
        PatientModel patient = (PatientModel) this.namedParameterJdbcTemplate.queryForObject(GET_PATIENT_BY_SSN, paramSource, new PatientRowMapper());
        return patient;
    }

    @Override
    public String deletePatient(int PatientID) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource("PatientID", PatientID);
        this.namedParameterJdbcTemplate.update(DELETE_PATIENT, paramSource);
        return "delete dane";
    }


}
