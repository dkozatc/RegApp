package com.springapp.mvc;

import com.springapp.models.Appointment;
import com.springapp.models.Encounter;
import com.springapp.models.PatientModel;
import com.springapp.service.AppointmentService;
import com.springapp.service.EncounterService;
import com.springapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/12/13
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private EncounterService encounterService;
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value="/Patient/showPatient", method = RequestMethod.GET)
    public @ResponseBody PatientModel showPatient(HttpServletRequest request) {
        Principal user = request.getUserPrincipal();
        System.out.print(user.getName());
        PatientModel result = patientService.getPatientBySSN(user.getName());
        return  result;
    }
    @RequestMapping(value="/Patient/patientEncounts", method = RequestMethod.GET)
    public @ResponseBody List<Encounter> getPatientEncounts(@RequestParam("id") String id ,ModelMap model) {
        System.out.println(id + " string");
        List<Encounter> result = encounterService.searchEncounters(id);
        return result;
    }
    @RequestMapping(value="/Patient/getAppointmentList", method = RequestMethod.GET)
    public @ResponseBody List<Appointment> getAppointmentList(@RequestParam("id") String id){
        System.out.print(id);
        List<Appointment> appointments = appointmentService.searchAppointment(id);
        return  appointments;
    }




}
