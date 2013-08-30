package com.springapp.service;

import com.springapp.dao.AppointmentDao;
import com.springapp.models.Appointment;
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
 * Date: 8/15/13
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class AppointmentsServicesTests extends TestCase {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testEditAppointment() {
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        int appointmnetId = appointmentService.createAppointmen(appointment);
        assertTrue("Insert appointment fail", appointmnetId >= 0);
        appointment.setId(appointmnetId);
        String result = appointmentService.editAppointment(appointment);
        assertEquals("Update dane", result);
        String resultRemove = appointmentDao.removeAppointments(appointmnetId);
        assertEquals("delete dane", resultRemove);


    }

    @Test
    public void testCreateAppointmen() {
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        int appointmnetId = appointmentService.createAppointmen(appointment);
        assertTrue("Insert appointment fail", appointmnetId >= 0);
        String resultRemove = appointmentDao.removeAppointments(appointmnetId);
        assertEquals("delete dane", resultRemove);
    }

    @Test
    public void testSearchAppointment() {
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        int appointmnetId = appointmentService.createAppointmen(appointment);
        List<Appointment> appointments = appointmentService.searchAppointment(appointment.getEncounterId());
        assertFalse("Appointmnets list is empty", appointments.isEmpty());
        String resultRemove = appointmentDao.removeAppointments(appointmnetId);
        assertEquals("delete dane", resultRemove);

    }


}
