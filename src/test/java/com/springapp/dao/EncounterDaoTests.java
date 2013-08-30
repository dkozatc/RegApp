package com.springapp.dao;

import com.springapp.models.Encounter;
import junit.framework.TestCase;
import org.junit.Ignore;
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
 * Date: 8/14/13
 * Time: 12:46 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class EncounterDaoTests extends TestCase {
    @Autowired
    private EncountDao encountDao;

    @Test
    public void testInsertEncounter(){
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        int result = encountDao.insertEncounter(encounter);
        assertTrue("Encounert not inserted", result>=0);
        String deleteResult = encountDao.deleteEncounter(result);
        assertEquals("delete dane", deleteResult);
    }
    @Test
    public void testUpdateEncouter(){
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        int result = encountDao.insertEncounter(encounter);
        assertTrue("Encounert not inserted", result>=0);
        Encounter encounterUpdated = new Encounter();
        encounterUpdated.setDiagnose("Diagnosis1Test");
        encounterUpdated.setStatus("aga");
        encounterUpdated.setPatientID(999);
        encounterUpdated.setTimeIn("13/12/1232");
        encounterUpdated.setTimeOut("15/02/1234");
        encounterUpdated.setId(result);
        String resultReturn =  encountDao.updateEncouter(encounterUpdated);
        assertEquals("All dane", resultReturn);
        String deleteResult = encountDao.deleteEncounter(result);
        assertEquals("delete dane", deleteResult);
    }
    @Test
    public void testGetEncounters(){
        Encounter encounter = new Encounter();
        encounter.setDiagnose("DiagnosisTest");
        encounter.setStatus("aga");
        encounter.setPatientID(999);
        encounter.setTimeIn("12/12/1232");
        encounter.setTimeOut("12/02/1234");
        int result = encountDao.insertEncounter(encounter);
        assertTrue("Encounert not inserted", result>=0);
        List<Encounter> encounters = encountDao.getEncounters(encounter.getPatientID());
        assertFalse("Encounerts empty", encounters.isEmpty());
        String deleteResult = encountDao.deleteEncounter(result);
        assertEquals("delete dane", deleteResult);
    }
    @Ignore
    @Test
    public void testGetEncounterID(){
        List<Encounter> encounter = encountDao.getEncounters(1);
        assertFalse("Encounerts empty", encounter.isEmpty());
        int encounterID =  encountDao.getEncounterID(encounter.get(0));
        assertTrue("Wrong encounter id", encounterID>0);
    }


}
