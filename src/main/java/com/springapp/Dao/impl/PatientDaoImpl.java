package com.springapp.dao.impl;

import com.springapp.dao.PatientDao;
import com.springapp.models.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


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
    public String insertPatient(String query){
        this.jdbcTemplate.update(query);
          return "";
    }
    public String updatePatient(PatientModel patient){
        String query = "UPDATE patients SET FirstName=? , LastName=?, SSN=?, Dateofbirth=?, Gender=?, Mtlstatus=?, Race=?,"
                + "Religion=?, Language=?, Address=?, City=?, State=?, Zip=?, PhoneNumber=?, EmployerName=?, EmpAddress=?,"
                +" EmpCity=?, EmpState=?, EmpZip=?, EmpPhoneNumber=? Where PersonID="+patient.getPatientID()+";";

        this.jdbcTemplate.update(query, new Object[]{
                patient.getFirstName(),
                patient.getLastName(),
                patient.getSSN(),
                patient.getDateOfbirth(),
                patient.getGender(),
                patient.getMaritalStatus(),
                patient.getRace(),
                patient.getReligion(),
                patient.getLanguage(),
                patient.getPatientAddress(),
                patient.getPatientCity(),
                patient.getPatientState(),
                patient.getPatientZip(),
                patient.getPatientPhone(),
                patient.getEmployerName(),
                patient.getEmployerAddress(),
                patient.getEmployerCity(),
                patient.getEmployerState(),
                patient.getEmployerZip(),
                patient.getEmployerPhone()});
        return "";
    }
    public @ResponseBody List<PatientModel> searchPatients(String inputString){
          List patients;
        patients = this.jdbcTemplate.query(inputString, new RowMapper() {
            @Override
            public PatientModel mapRow(ResultSet resultSet, int i) throws SQLException {
                PatientModel patient = new PatientModel();
                patient.setPatientID(resultSet.getInt("PersonID"));
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
    public int getCountPatient(){
        int rowCount;
        rowCount = this.jdbcTemplate.queryForInt("select count(*) from patients");

        return rowCount;
    }



}
