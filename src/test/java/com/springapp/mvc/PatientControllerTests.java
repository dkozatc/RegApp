package com.springapp.mvc;

import com.springapp.dao.AppointmentDao;
import com.springapp.dao.EncountDao;
import com.springapp.dao.PatientDao;
import com.springapp.models.Appointment;
import com.springapp.models.Encounter;
import com.springapp.models.PatientModel;
import com.sun.security.auth.UserPrincipal;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/15/13
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class PatientControllerTests extends TestCase {


    @Autowired
    private PatientController patientController;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private EncountDao encountDao;
    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testShowPatient(){
        PatientModel patient =  new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int id = patientDao.insertPatient(patient);
        assertTrue("expected to be greater than", id>=0);
        Principal principal = new UserPrincipal("123-12-1324");
        PatientModel result = patientController.showPatient(principal);
        assertTrue("Error show Patient Controller", result!=null);
        String deleteResult = patientDao.deletePatient(id);
        assertEquals("delete dane", deleteResult);
    }

    @Test
    public void testGetPatientEncounts(){
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        int result = encountDao.insertEncounter(encounter);
        assertTrue("Encounert not inserted", result>=0);
        List< Encounter > encounters = patientController.getPatientEncounts(encounter.getPatientID());
        assertFalse("Empty encounter List", encounters.isEmpty());
        String deleteResult = encountDao.deleteEncounter(result);
        assertEquals("delete dane", deleteResult);
    }

    @Test
    public void testGetAppointmentList(){
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        int appointmnetId= appointmentDao.insertAppointment(appointment);
        assertTrue("Insert appointment fail", appointmnetId>=0);
        List<Appointment> appointments = patientController.getAppointmentList( appointment.getEncounterId());
        assertFalse("Appointments list empty", appointments.isEmpty());
        String result = appointmentDao.removeAppointments(appointmnetId);
        assertEquals("delete dane", result);
    }


}
