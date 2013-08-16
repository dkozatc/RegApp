package com.springapp.service;

import com.springapp.dao.PatientDao;
import com.springapp.models.Appointment;
import com.springapp.models.PatientModel;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/15/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class PatientServicesTests extends TestCase {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientDao patientDao;

    @Test
    public void testEditPatient(){
        PatientModel patient =  new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int id = patientService.createPatient(patient);
        assertTrue("creating fails", id>=0);
        patient.setPatientID(id);
        String  resultUpdate = patientService.editPatient(patient);
        assertEquals("All dane", resultUpdate);
        String delete = patientDao.deletePatient(id);
        assertEquals("delete dane", delete);
    }
    @Test
    public void testCreatePatient(){
        PatientModel patient =  new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int id = patientService.createPatient(patient);
        assertTrue("creating fails", id>=0);
        String delete = patientDao.deletePatient(id);
        assertEquals("delete dane", delete);
    }
    @Test
    public void testSearchAppointment(){
        PatientModel patient =  new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int id = patientService.createPatient(patient);
        assertTrue("creating fails", id>=0);
        List<PatientModel> patients =  patientService.searchPatient("T");
        assertFalse("Empty patient List", patients.isEmpty());
        String delete = patientDao.deletePatient(id);
        assertEquals("delete dane", delete);
    }
    @Test
    public void testGetPatient(){
        PatientModel patient =  new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int id = patientService.createPatient(patient);
        assertTrue("creating fails", id>=0);
        PatientModel patientReturn = patientService.getPatient(id);
        assertTrue("Patinet not found", patientReturn!=null);
        String delete = patientDao.deletePatient(id);
        assertEquals("delete dane", delete);
    }
    @Test
    public void testGetPatientBySSN(){
        PatientModel patient =  new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int id = patientService.createPatient(patient);
        assertTrue("creating fails", id>=0);
        PatientModel patientReturn = patientService.getPatientBySSN(patient.getSSN());
        assertTrue("Patinet not found", patientReturn!=null);
        String delete = patientDao.deletePatient(id);
        assertEquals("delete dane", delete);
    }
}
