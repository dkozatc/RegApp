package com.springapp.dao.impl;

import com.springapp.models.PatientModel;
import org.springframework.jdbc.core.RowMapper;



import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/6/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class PatientRowMapper implements RowMapper {


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
}
