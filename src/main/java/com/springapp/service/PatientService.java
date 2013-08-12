package com.springapp.service;

import com.springapp.models.PatientModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/11/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PatientService {
    public String editPatient(PatientModel patient);
    public int createPatient(PatientModel patient);
    public List<PatientModel> searchPatient(String query);
    public PatientModel getPatient(String id);
    public PatientModel getPatientBySSN(String SSN);
}
