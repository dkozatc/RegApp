package com.springapp.service;

import com.springapp.dao.EncountDao;
import com.springapp.models.Encounter;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/15/13
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class EncountersServicesTests extends TestCase {
    @Autowired
    private EncounterService encounterService;

    @Autowired
    private EncountDao encountDao;



    @Test
    public void testEditEncounter(){
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        int result = encounterService.createEncounter(encounter);
        assertTrue("Encounert not inserted", result>=0);
        Encounter encounterUpdated = new Encounter();
        encounterUpdated.setId(result);
        encounterUpdated.setDiagnose("Diagnosis1Test");
        encounterUpdated.setStatus("aga");
        encounterUpdated.setPatientID(999);
        encounterUpdated.setTimeIn("13/12/1232");
        encounterUpdated.setTimeOut("15/02/1234");
        String resultReturn =  encounterService.editEncounter(encounterUpdated);
        assertEquals("All dane", resultReturn);
        String deleteResult = encountDao.deleteEncounter(result);
        assertEquals("delete dane", deleteResult);
    }

    @Test
    public void testCreateEncounter(){
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        int result = encounterService.createEncounter(encounter);
        assertTrue("Encounert not inserted", result>=0);
        String deleteResult = encountDao.deleteEncounter(result);
        assertEquals("delete dane", deleteResult);


    }
    @Test
    public void testSearchEncounters(){
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        int result = encounterService.createEncounter(encounter);
        assertTrue("Encounert not inserted", result>=0);
        List<Encounter> encounters = encounterService.searchEncounters(encounter.getPatientID());
        assertFalse("Encounerts empty", encounters.isEmpty());
        String deleteResult = encountDao.deleteEncounter(result);
        assertEquals("delete dane", deleteResult);


    }




}
