package com.springapp.service;

import com.springapp.dao.PatientDao;
import com.springapp.models.PatientModel;
import com.springapp.service.impl.SpringAppUserDetailsService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/16/13
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml", "classpath:spring-security.xml"})
public class SpringAppUserDetailServiceTests extends TestCase {

    @Autowired
    private SpringAppUserDetailsService springAppUserDetailsService;
    @Autowired
    private PatientDao patientDao;


    @Test
    public void testLoadUserByUsernameRegistrator(){
        UserDetails user = springAppUserDetailsService.loadUserByUsername("Dima");
        assertTrue("Error Logining", user!=null);


    }
    @Test
    public void testLoadUserByUsernamePatient(){
        PatientModel patient =  new PatientModel();
        patient.setFirstName("TestFirstName");
        patient.setLastName("TestLestName");
        patient.setSSN("123-12-1324");
        patient.setDateOfbirth("12/12/1999");
        patient.setMaritalStatus("Single");
        int patientId = patientDao.insertPatient(patient);
        assertTrue("expected to be greater than", patientId>=0);
        UserDetails user = springAppUserDetailsService.loadUserByUsername("123-12-1324");
        assertTrue("Error Logining", user!=null);
        String deleteResult = patientDao.deletePatient(patientId);
        assertEquals("delete dane", deleteResult);
    }
    @Test
    public void testLoadUserByUsername(){

        UserDetails user = springAppUserDetailsService.loadUserByUsername("");
        assertTrue("Error! Seccess Logining with empty user name", user==null);

    }
}
