package com.springapp.mvc.service;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/10/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
import com.springapp.mvc.models.PatientModel;
import com.mysql.jdbc.Connection;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientAcoutns {

            private PatientModel patient;

            public PatientAcoutns(PatientModel patient){
                this.patient = patient;


            }


            public String insertPatient() throws SQLException {


              return "some";
            }

            public String updatePersone(){



               return "update";
            }

            public String deletePersone(){



                return "delete";
            }
            public String  searchPatient(){


                return "result";


            }
}
