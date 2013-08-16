package com.springapp.service.impl;

import com.springapp.dao.AppointmentDao;
import com.springapp.models.Appointment;
import com.springapp.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/29/13
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentDao appointmentDao;


    @Override
    public String editAppointment(Appointment appointment) {
       String result = appointmentDao.updateAppointment(appointment);
        return result;
    }
    @Override
    public int createAppointmen(Appointment appointment) {
        int id = appointmentDao.insertAppointment(appointment);
        return id;
    }

    @Override
    public List<Appointment> searchAppointment(int query) {
        List<Appointment> appointments = appointmentDao.getAppointments(query);
        return appointments;
    }

    @Override
    public String deleteAppointment(int id) {
        appointmentDao.removeAppointments(id);
        return null;
    }
}
