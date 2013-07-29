package com.springapp.mvc;


import com.google.gson.Gson;
import com.springapp.models.Encounter;
import com.springapp.models.PatientModel;
import com.springapp.service.EncounterService;
import com.springapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value="/test", method = RequestMethod.GET)
    public @ResponseBody List<PatientModel> printWelcome(@RequestParam("requestString") String requestString ,ModelMap model) {
        System.out.println(requestString + " string");
        List<PatientModel> result = patientService.searchPatient(requestString);
        return  result;
    }

    @RequestMapping(value="/showPatient", method = RequestMethod.GET)
    public @ResponseBody PatientModel getPatient(@RequestParam("id") String id ,ModelMap model) {

        System.out.println(id + " string");
        PatientModel result = patientService.getPatient(id);
        return result;
    }
    @RequestMapping(value="/patientEncounts", method = RequestMethod.GET)
    public @ResponseBody List<Encounter> getPatientEncounts(@RequestParam("id") String id ,ModelMap model) {
        System.out.println(id + " string");
        List<Encounter> result = encounterService.searchEncounters(id);
        return result;
    }
    @RequestMapping(value="/addPatient", method = RequestMethod.POST)
    public @ResponseBody String addNewPatient(PatientModel patientModel){
        int a = patientService.createPatient(patientModel);
        return "{\"PatientID\":"+a+"}";
    }
    @RequestMapping(value="/updatePatient", method = RequestMethod.POST)
    public @ResponseBody String updatePatient(PatientModel patientModel){
        String result = patientService.editPatient(patientModel);
        return "Dane!";
    }
    @RequestMapping(value="/addEncounter", method = RequestMethod.POST)
    public @ResponseBody String addNewEncounter(Encounter encounter){
       encounterService.createEncounter(encounter);
       return "Dane!!!";
    }
    @RequestMapping(value="/updateEncouter", method = RequestMethod.POST)
    public @ResponseBody String updateEncounter(Encounter encounter){
        encounterService.editEncounter(encounter);
        return "Update Dane";
    }

}
