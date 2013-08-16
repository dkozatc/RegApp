package com.springapp.dao;

import com.springapp.models.Appointment;
import junit.framework.TestCase;
import org.junit.Ignore;
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
 * Date: 8/14/13
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class AppointmentsDaoTests extends TestCase {
    @Autowired
    private AppointmentDao appointmentDao;

    private int appointmnetId;

    @Test
    public void testInsertAppointment(){
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        int appointmnetId= appointmentDao.insertAppointment(appointment);
        assertTrue("Insert appointment fail", appointmnetId>=0);
        String result = appointmentDao.removeAppointments(appointmnetId);
        assertEquals("delete dane", result);

    }

    @Test
    public void testUpdateAppointment(){
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        int appointmnetId= appointmentDao.insertAppointment(appointment);
        assertTrue("Insert appointment fail", appointmnetId>=0);
        String result  = appointmentDao.updateAppointment(appointment);
        assertEquals("Update dane", result);
        String resultRemove = appointmentDao.removeAppointments(appointmnetId);
        assertEquals("delete dane", resultRemove);
    }

    @Test
    public void testGetAppointments(){
        Appointment appointment = new Appointment();
        appointment.setEncounterId(1);
        appointment.setResourcesId(1);
        appointment.setCommentsText("test");
        appointment.setStartDateTime(new Date());
        appointment.setEndDateTime(new Date());
        int appointmnetId= appointmentDao.insertAppointment(appointment);
        assertTrue("Insert appointment fail", appointmnetId>=0);
        List<Appointment> appointments =  appointmentDao.getAppointments(appointment.getEncounterId());
        assertFalse("Appointmnets list is empty", appointments.isEmpty());
        String resultRemove = appointmentDao.removeAppointments(appointmnetId);
        assertEquals("delete dane", resultRemove);
    }







}
