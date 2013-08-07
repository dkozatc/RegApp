package com.springapp.dao;

import com.springapp.models.Appointment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/29/13
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AppointmentDao {
    public int insertAppointment(Appointment appointment);
    public String updateAppointment(Appointment appointment);
    public List<Appointment> getAppointments(String query);
    public String removeAppointments(String query);



}
