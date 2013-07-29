package com.springapp.models;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/9/13
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class PatientModel {
    int PatientID;
    String FirstName;
    String LastName;
    String SSN;
    String DateOfbirth;
    String Gender;
    String MaritalStatus;
    String Race;
    String Religion;
    String Language;
    String PatientAddress;
    String PatientCity;
    String PatientState;
    String PatientZip;
    String PatientPhone;
    String EmployerName;
    String EmployerAddress;
    String EmployerCity;
    String EmployerState;
    String EmployerZip;
    String EmployerPhone;

    @JsonProperty("PatientID")
    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
    @JsonProperty("FirstName")
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    @JsonProperty("SSN")
    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
    @JsonProperty("DateOfbirth")
    public String getDateOfbirth() {
        return DateOfbirth;
    }

    public void setDateOfbirth(String dateOfbirth) {
        DateOfbirth = dateOfbirth;
    }
    @JsonProperty("Gender")
    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
    @JsonProperty("MaritalStatus")
    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }
    @JsonProperty("Race")
    public String getRace() {
        return Race;
    }

    public void setRace(String race) {
        Race = race;
    }
    @JsonProperty("Religion")
    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }
    @JsonProperty("Language")
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }
    @JsonProperty("PatientAddress")
    public String getPatientAddress() {
        return PatientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        PatientAddress = patientAddress;
    }
    @JsonProperty("PatientCity")
    public String getPatientCity() {
        return PatientCity;
    }

    public void setPatientCity(String patientCity) {
        PatientCity = patientCity;
    }
    @JsonProperty("PatientState")
    public String getPatientState() {
        return PatientState;
    }

    public void setPatientState(String patientState) {
        PatientState = patientState;
    }
    @JsonProperty("PatientZip")
    public String getPatientZip() {
        return PatientZip;
    }

    public void setPatientZip(String patientZip) {
        PatientZip = patientZip;
    }
    @JsonProperty("PatientPhone")
    public String getPatientPhone() {
        return PatientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        PatientPhone = patientPhone;
    }
    @JsonProperty("EmployerName")
    public String getEmployerName() {
        return EmployerName;
    }

    public void setEmployerName(String employerName) {
        EmployerName = employerName;
    }
    @JsonProperty("EmployerAddress")
    public String getEmployerAddress() {
        return EmployerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        EmployerAddress = employerAddress;
    }
    @JsonProperty("EmployerCity")
    public String getEmployerCity() {
        return EmployerCity;
    }

    public void setEmployerCity(String employerCity) {
        EmployerCity = employerCity;
    }
    @JsonProperty("EmployerState")
    public String getEmployerState() {
        return EmployerState;
    }

    public void setEmployerState(String employerState) {
        EmployerState = employerState;
    }
    @JsonProperty("EmployerZip")
    public String getEmployerZip() {
        return EmployerZip;
    }

    public void setEmployerZip(String employerZip) {
        EmployerZip = employerZip;
    }
    @JsonProperty("EmployerPhone")
    public String getEmployerPhone() {
        return EmployerPhone;
    }

    public void setEmployerPhone(String employerPhone) {
        EmployerPhone = employerPhone;
    }
}
