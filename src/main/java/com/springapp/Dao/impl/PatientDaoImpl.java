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
        String query =  myResources.getString("insertPatient");
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(patient);
        this.namedParameterJdbcTemplate.update(query, namedParameters);
        return  0;
    }
    public String updatePatient(PatientModel patient){
        String query = myResources.getString("updatePatient");
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(patient);
        this.namedParameterJdbcTemplate.update(query, namedParameters);

        return "";
    }
    public @ResponseBody List<PatientModel> searchPatients(String inputString){
        System.out.print(inputString);
        String msqlQuery = myResources.getString("getPatientList");
        String param = "%"+inputString+ "%";
        MapSqlParameterSource paramSource = new MapSqlParameterSource("searchInput", param);
        System.out.print(msqlQuery);


       List<PatientModel> patients = this.namedParameterJdbcTemplate.query(msqlQuery, paramSource, new RowMapper() {
            @Override
            public PatientModel mapRow(ResultSet resultSet, int i) throws SQLException {
                PatientModel patient = new PatientModel();
                patient.setPatientID(resultSet.getInt("PatientID"));
                patient.setFirstName(resultSet.getString("FirstName"));
                patient.setLastName(resultSet.getString("LastName"));
                patient.setSSN(resultSet.getString("SSN"));
                patient.setDateOfbirth(resultSet.getString("Dateofbirth"));
                patient.setGender(resultSet.getString("Gender"));
                patient.setMaritalStatus(resultSet.getString("Mtlstatus"));
                patient.setRace(resultSet.getString("Race"));
                patient.setReligion(resultSet.getString("Religion"));
                patient.setLanguage(resultSet.getString("Language"));
                patient.setPatientAddress(resultSet.getString("Address"));
                patient.setPatientCity(resultSet.getString("City"));
                patient.setPatientState(resultSet.getString("State"));
                patient.setPatientZip(resultSet.getString("Zip"));
                patient.setPatientPhone(resultSet.getString("PhoneNumber"));
                patient.setEmployerName(resultSet.getString("EmployerName"));
                patient.setEmployerAddress(resultSet.getString("EmpAddress"));
                patient.setEmployerCity(resultSet.getString("EmpCity"));
                patient.setEmployerState(resultSet.getString("EmpState"));
                patient.setEmployerZip(resultSet.getString("EmpZip"));
                patient.setEmployerPhone(resultSet.getString("EmpPhoneNumber"));
                return patient;
            }
        });
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
        PatientModel patient = (PatientModel) this.namedParameterJdbcTemplate.queryForObject(query,paramSource ,new RowMapper() {
             @Override
             public PatientModel mapRow(ResultSet resultSet, int i) throws SQLException {
                 PatientModel patient = new PatientModel();
                 patient.setPatientID(resultSet.getInt("PatientID"));
                 patient.setFirstName(resultSet.getString("FirstName"));
                 patient.setLastName(resultSet.getString("LastName"));
                 patient.setSSN(resultSet.getString("SSN"));
                 patient.setDateOfbirth(resultSet.getString("Dateofbirth"));
                 patient.setGender(resultSet.getString("Gender"));
                 patient.setMaritalStatus(resultSet.getString("Mtlstatus"));
                 patient.setRace(resultSet.getString("Race"));
                 patient.setReligion(resultSet.getString("Religion"));
                 patient.setLanguage(resultSet.getString("Language"));
                 patient.setPatientAddress(resultSet.getString("Address"));
                 patient.setPatientCity(resultSet.getString("City"));
                 patient.setPatientState(resultSet.getString("State"));
                 patient.setPatientZip(resultSet.getString("Zip"));
                 patient.setPatientPhone(resultSet.getString("PhoneNumber"));
                 patient.setEmployerName(resultSet.getString("EmployerName"));
                 patient.setEmployerAddress(resultSet.getString("EmpAddress"));
                 patient.setEmployerCity(resultSet.getString("EmpCity"));
                 patient.setEmployerState(resultSet.getString("EmpState"));
                 patient.setEmployerZip(resultSet.getString("EmpZip"));
                 patient.setEmployerPhone(resultSet.getString("EmpPhoneNumber"));
                 return patient;
             }
         });
         return patient;
     }



}
