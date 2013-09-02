package com.springapp.mvc;

import com.springapp.dao.EncountDao;
import com.springapp.dao.PatientDao;
import com.springapp.models.Appointment;
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

import java.util.Date;
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
    public void testAddNewPatient() {
        PatientModel patient = new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        ServiceResponse<Integer> response = mainController.addNewPatient(patient);
        assertTrue("Error added new Patient", response.getData() >= 0);
        String delete = patientDao.deletePatient(response.getData());
        assertEquals("delete dane", delete);
    }
    @Test
    public void testUpdatePatient(){
        PatientModel patient = new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int id = patientService.createPatient(patient);
        assertTrue("Add new PAtient Error", id >= 0);
        patient.setPatientID(id);
        ServiceResponse<String> response = mainController.updatePatient(patient);
        assertEquals("All dane", response.getData());
        String delete = patientDao.deletePatient(id);
        assertEquals("delete dane", delete);
    }

    @Test
    public void testAddNewEncounter(){
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        ServiceResponse<Integer> response = mainController.addNewEncounter(encounter);
        assertTrue("Add new Encounter fails", response.getData()>=0);
    }
    @Test
    public void testUpdateEncounter(){
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        ServiceResponse<Integer> response = mainController.addNewEncounter(encounter);
        assertTrue("Add new Encounter fails", response.getData()>=0);
        encounter.setId(response.getData());
        ServiceResponse<String> responseUpdate = mainController.updateEncounter(encounter);
        assertEquals("Update Dane",responseUpdate.getData());
    }
    @Test
    public void testGetAppointmentList(){
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        ServiceResponse <Integer> response = mainController.addNewAppointment(appointment);
        assertTrue("Insert appointment fail",response.getData()>=0);
        List<Appointment> appointments = mainController.getAppointmentList(appointment.getEncounterId());
        assertFalse("Error geting appointments list", appointments.isEmpty());

    }
    @Test
    public void testUpdateAppointment(){
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        ServiceResponse <Integer> response = mainController.addNewAppointment(appointment);
        assertTrue("Insert appointment fail",response.getData()>=0);
        appointment.setId(response.getData());
        ServiceResponse <String> responseUpdate = mainController.updateAppointment(appointment);
        assertEquals("Update dane", responseUpdate.getData());
    }
    @Test
    public void testAddNewAppointment(){
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        ServiceResponse <Integer> response = mainController.addNewAppointment(appointment);
        assertTrue("Insert appointment fail",response.getData()>=0);

    }
    @Test
    public void testDeleteAppointment(){
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        ServiceResponse <Integer> response = mainController.addNewAppointment(appointment);
        assertTrue("Insert appointment fail",response.getData()>=0);
        ServiceResponse <String> responseDelete = mainController.deleteAppointment(response.getData());
        assertEquals("delete dane", responseDelete.getData());

    }










}
