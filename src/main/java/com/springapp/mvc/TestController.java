package com.springapp.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/2/13
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */




@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(method = RequestMethod.POST)
    public String printWelcome(@RequestParam("requestString") String requestString ,ModelMap model) {
        model.addAttribute("message", requestString);
        return "test";
    }
}
