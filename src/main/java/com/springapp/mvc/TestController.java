package com.springapp.mvc;


import com.springapp.mvc.models.PatientModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/2/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */




@Controller
@RequestMapping(method = RequestMethod.POST)
public class TestController {

    @RequestMapping("/test")
    public String printWelcome(@RequestParam("requestString") String requestString ,ModelMap model) {
        model.addAttribute("message", "{'FirstName':'Dima', 'LastName':'Kozaryok'}");
        return "test";
    }

    @RequestMapping("/addPatient")
    public String addNewPatient(PatientModel patientModel){

        return "addNew";
    }


}
