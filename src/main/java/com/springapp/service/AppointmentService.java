package com.springapp.service;

import com.springapp.models.Appointment;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/29/13
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AppointmentService {
    public String editAppointment(Appointment appointment);
    public int createAppointmen(Appointment appointment);
    public List<Appointment> searchAppointment(int query);
    public String deleteAppointment(int id);

}
