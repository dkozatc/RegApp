package com.springapp.mvc.service;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/10/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */

import com.springapp.mvc.PatientDaoIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientAcoutns {

    @Autowired
    private PatientDaoIMPL patientDaoIMPL;

    public String insertPatient() {
        return "some";
    }

    public String updatePersone() {
        return "update";
    }

    public String deletePersone() {
        return "delete";
    }

    public String searchPatient() {
        int a = patientDaoIMPL.getCountPatient();
        System.out.print(a);
        return "result";
    }
}
