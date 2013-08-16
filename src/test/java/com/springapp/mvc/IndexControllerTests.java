package com.springapp.mvc;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/15/13
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class IndexControllerTests extends TestCase {
    @Autowired
    private IndexController indexController;

   @Test
    public void testRedirectIndex(){
       String response = indexController.redirectIndex();
       assertEquals("redirect:/Registrator/",response);

   }
    @Test
    public void testPrintWelcome(){
        String response = indexController.printWelcome(new ModelMap());
        assertEquals("index",response);
    }
    @Test
    public void testPatientShow(){
        String response = indexController.patientShow();
        assertEquals("patientIndex",response);
    }
    @Test
    public void testlogin(){
        String response = indexController.login();
        assertEquals("login",response);
    }
    @Test
    public void testLoginloginError(){
        String response = indexController.loginError(new ModelMap());
        assertEquals("login",response);
    }
    @Test
    public void testLogout(){
        String response = indexController.logout();
        assertEquals("login",response);

    }





}
