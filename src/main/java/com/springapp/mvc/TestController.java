package com.springapp.mvc;


import com.google.gson.Gson;
import com.springapp.models.PatientModel;
import com.springapp.service.PatientService;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/2/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */




@Controller
public class TestController {
    @Autowired
    private PatientService patientService;
    @RequestMapping(value="/test", method = RequestMethod.GET)
    public @ResponseBody String printWelcome(@RequestParam("requestString") String requestString ,ModelMap model) {
        //model.addAttribute("message", "{'FirstName':'Dima', 'LastName':'Kozaryok'}");
        System.out.println(requestString + " string");
        List<PatientModel> result = patientService.searchPatient(requestString);
        String json = new Gson().toJson(result);
        return json;
    }

    @RequestMapping(value="/addPatient", method = RequestMethod.POST)
    public @ResponseBody String addNewPatient(PatientModel patientModel){

        int a = patientService.createPatient(patientModel);

        return "{\"PatientID\":"+a+"}";
    }

    @RequestMapping(value="/updatePatient", method = RequestMethod.POST)
    public @ResponseBody String updatePatient(PatientModel patientModel){

        //String result = patientService.editPatient(patientModel);


        return "Dane!";
    }


}
