package com.springapp.models;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/23/13
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Encount {
    int id=0;
    String Diagnose;
    String Status;
    int PatientID =0;
    String TimeIn;
    String TimeOut;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnose() {
        return Diagnose;
    }

    public void setDiagnose(String diagnose) {
        Diagnose = diagnose;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public String getTimeIn() {
        return TimeIn;
    }

    public void setTimeIn(String timeIn) {
        TimeIn = timeIn;
    }

    public String getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(String timeOut) {
        TimeOut = timeOut;
    }
}
