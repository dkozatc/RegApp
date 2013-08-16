package com.springapp.mvc;


import com.google.gson.Gson;
import com.springapp.models.Appointment;
import com.springapp.models.Encounter;
import com.springapp.models.PatientModel;
import com.springapp.service.AppointmentService;
import com.springapp.service.EncounterService;
import com.springapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/2/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */




@Controller
public class MainController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private EncounterService encounterService;
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value="Registrator/test", method = RequestMethod.GET)
    public @ResponseBody List<PatientModel> searchPatient(@RequestParam("requestString") String requestString ) {
        System.out.println(requestString + " string");
        List<PatientModel> result = patientService.searchPatient(requestString);
        return  result;
    }
    @RequestMapping(value="Registrator/showPatient", method = RequestMethod.GET)
    public @ResponseBody PatientModel getPatient(@RequestParam("id") int id) {

        System.out.println(id + " string");
        PatientModel result = patientService.getPatient(id);
        return result;
    }
    @RequestMapping(value="Registrator/patientEncounts", method = RequestMethod.GET)
    public @ResponseBody List<Encounter> getPatientEncounts(@RequestParam("id") int id) {
        System.out.println(id + " string");
        List<Encounter> result = encounterService.searchEncounters(id);
        return result;
    }
    @RequestMapping(value="Registrator/addPatient", method = RequestMethod.POST)
    public @ResponseBody ServiceResponse<Integer> addNewPatient(PatientModel patientModel){
        int id = patientService.createPatient(patientModel);
        return new ServiceResponse<Integer>(id);
    }
    @RequestMapping(value="Registrator/updatePatient", method = RequestMethod.POST)
    public @ResponseBody String updatePatient(PatientModel patientModel){
        String result = patientService.editPatient(patientModel);
        return "Dane!";
    }
    @RequestMapping(value="Registrator/addEncounter", method = RequestMethod.POST)
    public @ResponseBody ServiceResponse<Integer> addNewEncounter(Encounter encounter){
      int id = encounterService.createEncounter(encounter);
       return new ServiceResponse<Integer>(id);
    }
    @RequestMapping(value="Registrator/updateEncouter", method = RequestMethod.POST)
    public @ResponseBody String updateEncounter(Encounter encounter){
        encounterService.editEncounter(encounter);
        return "Update Dane";
    }
    @RequestMapping(value="Registrator/getAppointmentList", method = RequestMethod.GET)
    public @ResponseBody List<Appointment> getAppointmentList(@RequestParam("id")int id){
        System.out.print(id);
        List<Appointment> appointments = appointmentService.searchAppointment(id);
        return  appointments;
    }
    @RequestMapping(value="Registrator/updateAppointment", method = RequestMethod.PUT)
    public @ResponseBody String updateAppointment(@RequestBody Appointment appointment){
        System.out.print(appointment);
        appointmentService.editAppointment(appointment);
        return "{\"id\":0}";
    }
    @RequestMapping(value="Registrator/addAppointment", method = RequestMethod.POST)
    public @ResponseBody String addNewAppointment(@RequestBody  Appointment appointment){
       System.out.print(appointment);
             appointmentService.createAppointmen(appointment);
       return "{\"id\":0}";
    }
    @RequestMapping(value="Registrator/deleteAppointment", method = RequestMethod.DELETE)
    public @ResponseBody String deleteAppointment(@RequestParam("id") int id){
        System.out.print(id);
        appointmentService.deleteAppointment(id);
        return "{\"id\":0}";
    }



}
