package com.springapp.service.impl;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/10/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */

import com.springapp.dao.PatientDao;
import com.springapp.models.PatientModel;
import com.springapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;
    @Override
    public String editPatient(PatientModel patient) {
        patientDao.updatePatient(patient);
        return null;
    }
    public int createPatient(PatientModel patient){
        String query = "insert into patients (PatientID, FirstName, LastName, SSN, Dateofbirth, Gender, Mtlstatus, Race," +
                " Religion, Language, Address, City, State, Zip, PhoneNumber, EmployerName, EmpAddress, EmpCity, EmpState, "+
                "EmpZip, EmpPhoneNumber) value (NULL, '"+patient.getFirstName()+"','"+patient.getLastName()+"', '"
                +patient.getSSN()+"', '"+patient.getDateOfbirth()+"', '"+patient.getGender()+"', '"
                +patient.getMaritalStatus()+"', '"+patient.getRace()+"', '"+patient.getReligion()+"', '"
                +patient.getLanguage()+"', '"+patient.getPatientAddress()+"', '"+patient.getPatientCity()+
                "', '"+patient.getPatientState()+"', '"+patient.getPatientZip()+"', '"+patient.getPatientPhone()
                +"','"+patient.getEmployerName()+"',' "+patient.getEmployerAddress()+ "', '"+patient.getEmployerCity()
                +"','"+patient.getEmployerState()+"','"+patient.getEmployerZip()+"', '"+patient.getEmployerPhone()+"');";
        System.out.print(query);
        patientDao.insertPatient(query);
        int id = patientDao.getPatientID(patient);
        System.out.print(id);
        return id;
    }
    public List<PatientModel> searchPatient(String request) {
        String  query = "Select * from patients where FirstName LIKE '%"+request+"%' OR "+
                " LastName LIKE '%"+request+"%' OR SSN LIKE '%"+request+"%' OR PhoneNumber LIKE '%"+request+"%';";
        System.out.println(query);
        List<PatientModel> patientList = patientDao.searchPatients(query);
        return patientList;

    }
}
