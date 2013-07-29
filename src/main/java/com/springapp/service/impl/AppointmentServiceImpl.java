package com.springapp.service.impl;

import com.springapp.dao.AppointmentDao;
import com.springapp.models.Appointment;
import com.springapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/29/13
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;

    public AppointmentDao getAppointmentDao() {

        return appointmentDao;
    }

    public void setAppointmentDao(AppointmentDao appointmentDao) {

        this.appointmentDao = appointmentDao;
    }

    @Override
    public String editAppointment(Appointment appointment) {
         appointmentDao.updateAppointment(appointment);

        return null;
    }

    @Override
    public int createAppointmen(Appointment appointment) {
        int id = appointmentDao.insertAppointment(appointment);

        return 0;
    }

    @Override
    public List<Appointment> searchAppointment(String query) {
        List<Appointment> appointments = appointmentDao.getAppointments(query);

        return appointments;
    }
}
