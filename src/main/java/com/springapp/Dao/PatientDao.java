package com.springapp.dao;

import com.springapp.models.PatientModel;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/11/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PatientDao {
    public String insertPatient(String query);
    public String updatePatient(int id, String query);
    public List<PatientModel> searchPatients(String query);
    public int getCountPatient();
}
