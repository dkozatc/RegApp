package com.springapp.mvc;

import com.springapp.dao.EncountDao;
import com.springapp.dao.PatientDao;
import com.springapp.models.Encounter;
import com.springapp.models.PatientModel;
import com.springapp.service.AppointmentService;
import com.springapp.service.EncounterService;
import com.springapp.service.PatientService;
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
 * Date: 8/16/13
 * Time: 12:04 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class MainControllerTests extends TestCase {
    @Autowired
    private MainController mainController;

    @Autowired
    private PatientService patientService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private EncountDao encountDao;


    @Test
    public void testSearchPatient() {
        PatientModel patient = new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int id = patientService.createPatient(patient);
        assertTrue("Add new PAtient Error", id >= 0);
        List<PatientModel> patients = mainController.searchPatient("T");
        assertFalse("List of Patient is empty", patients.isEmpty());
        String delete = patientDao.deletePatient(id);
        assertEquals("delete dane", delete);
    }

    @Test
    public void testGetPatient() {
        PatientModel patient = new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int id = patientService.createPatient(patient);
        assertTrue("Add new PAtient Error", id >= 0);
        PatientModel result = mainController.getPatient(id);
        assertTrue("Error geting Patient", result != null);
        String delete = patientDao.deletePatient(id);
        assertEquals("delete dane", delete);
    }

    @Test
    public void testGetPatientEncounts() {
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        int result = encountDao.insertEncounter(encounter);
        assertTrue("Encounert not inserted", result >= 0);
        List<Encounter> encounters = mainController.getPatientEncounts(encounter.getPatientID());
        assertFalse("Encounerts empty", encounters.isEmpty());
        String deleteResult = encountDao.deleteEncounter(result);
        assertEquals("delete dane", deleteResult);
    }

    @Test
    public void testaddNewPatient() {
        PatientModel patient = new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");

        ServiceResponse<Integer> response = mainController.addNewPatient(patient);
        assertTrue("Error addeding new Patient", response.getDate() >= 0);

        String delete = patientDao.deletePatient(response.getDate());
        assertEquals("delete dane", delete);
    }

}
