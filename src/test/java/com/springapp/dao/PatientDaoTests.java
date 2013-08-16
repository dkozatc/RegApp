package com.springapp.dao;

import com.springapp.models.PatientModel;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
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
 * Date: 8/13/13
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class PatientDaoTests extends TestCase {
          @Autowired
          private PatientDao patientDao;

          private int patientId;

         @Test
         public void testInsertPatient(){
            PatientModel patient =  new PatientModel();
            patient.setFirstName("TestFirstName");
            patient.setLastName("TestLestName");
            patient.setSSN("123-12-1324");
            patient.setDateOfbirth("12/12/1999");
            patient.setMaritalStatus("Single");
            int patientId = patientDao.insertPatient(patient);
            assertTrue("expected to be greater than", patientId>=0);
            String deleteResult = patientDao.deletePatient(patientId);
            assertEquals("delete dane", deleteResult);

         }

        @Test
        public void testUpdatePatient(){
            PatientModel patient =  new PatientModel();
            patient.setFirstName("TestFirstName");
            patient.setLastName("TestLestName");
            patient.setSSN("123-12-1324");
            patient.setDateOfbirth("12/12/1999");
            patient.setMaritalStatus("Single");
            int patientId = patientDao.insertPatient(patient);
            assertTrue("expected to be greater than", patientId>=0);
            PatientModel patientUpdate =  new PatientModel();
            patientUpdate.setFirstName("TestFirstName1");
            patientUpdate.setLastName("TestLestName2");
            patientUpdate.setSSN("123-12-1325");
            patientUpdate.setDateOfbirth("12/12/1998");
            patientUpdate.setMaritalStatus("single");
            patientUpdate.setPatientID(patientId);
            String result = patientDao.updatePatient(patient);
            assertEquals("Dane", result);
            String deleteResult = patientDao.deletePatient(patientId);
            assertEquals("delete dane", deleteResult);
        }

        @Test
        public void testSearchPatients(){
           PatientModel patient =  new PatientModel();
           patient.setFirstName("TestFirstName");
           patient.setLastName("TestLestName");
           patient.setSSN("123-12-1324");
           patient.setDateOfbirth("12/12/1999");
           patient.setMaritalStatus("Single");
           int patientId = patientDao.insertPatient(patient);
           assertTrue("expected to be greater than", patientId>=0);
           List<PatientModel> result = patientDao.searchPatients("T");
           assertFalse("Search Patient List is empty", result.isEmpty());
           String deleteResult = patientDao.deletePatient(patientId);
           assertEquals("delete dane", deleteResult);


        }

        @Test
        public void testGetPatientID(){
           PatientModel patient =  new PatientModel();
           patient.setFirstName("TestFirstName");
           patient.setLastName("TestLestName");
           patient.setSSN("123-12-1324");
           patient.setDateOfbirth("12/12/1999");
           patient.setMaritalStatus("Single");
           int patientId = patientDao.insertPatient(patient);
           assertTrue("expected to be greater than", patientId>=0);
           PatientModel patient1 = patientDao.getPatientById(patientId);
           assertTrue("Patient id wrong", patient1!=null);
           int result = patientDao.getPatientID(patient);
           assertTrue("Patient id is bad",result>0);
           String deleteResult = patientDao.deletePatient(patientId);
           assertEquals("delete dane", deleteResult);
        }

        @Test
        public void testGetPatientBySSN(){
            PatientModel patient =  new PatientModel();
            patient.setFirstName("TestFirstName");
            patient.setLastName("TestLestName");
            patient.setSSN("123-12-1324");
            patient.setDateOfbirth("12/12/1999");
            patient.setMaritalStatus("Single");
            int patientId = patientDao.insertPatient(patient);
            assertTrue("expected to be greater than", patientId>=0);
            PatientModel patientReturn = patientDao.getPatientById(patientId);
            assertTrue("Patient id wrong", patientReturn!=null);
            PatientModel result = patientDao.getPatientBySSN(patientReturn.getSSN());
            assertTrue("Patient wrong", result!=null);
            String deleteResult = patientDao.deletePatient(patientId);
            assertEquals("delete dane", deleteResult);
        }
        @After
        public void deletePartientROW(){

        }

}