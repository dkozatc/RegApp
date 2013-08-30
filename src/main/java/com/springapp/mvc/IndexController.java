package com.springapp.mvc;

import com.springapp.service.ValidationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class IndexController {
    @Autowired
    private ValidationServices validationServices;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String redirectIndex() {
          return "redirect:/Registrator/";
    }
	@RequestMapping(value="Registrator/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {



       return "index";
	}
    @RequestMapping(value="Patient/", method = RequestMethod.GET)
    public String patientShow() {
          return "patientIndex";
    }
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout() {
        return "login";
    }




}