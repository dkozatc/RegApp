package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String printWelcome() {
          return "redirect:/Registrator/";
    }
	@RequestMapping(value="Registrator/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
   		model.addAttribute("message", "Hello world!");
		return "index";
	}
    @RequestMapping(value="Patient/", method = RequestMethod.GET)
    public String patientShow(ModelMap model) {

        return "patientIndex";
    }
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }
    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "login";
    }




}