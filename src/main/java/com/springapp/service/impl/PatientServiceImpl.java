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
        patientDao.insertPatient(patient);
        int id = patientDao.getPatientID(patient);
        System.out.print(id);
        return id;
    }
    public List<PatientModel> searchPatient(String request) {
        List<PatientModel> patientList = patientDao.searchPatients(request);
        return patientList;
    }
    @Override
    public PatientModel getPatient(String id) {
        PatientModel patient = patientDao.getPatientById(id);
        return patient;
    }
}
