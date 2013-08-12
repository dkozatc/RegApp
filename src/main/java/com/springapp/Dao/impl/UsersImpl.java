package com.springapp.dao.impl;

import com.springapp.dao.Users;
import com.springapp.models.PatientModel;
import com.springapp.models.Registrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/9/13
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UsersImpl implements Users {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private ResourceBundle myResources = ResourceBundle.getBundle("com.springapp.properties.RegistratorDao");
    private final String GET_REGISTRATOR_BY_USERNAME = this.myResources.getString("getRegistratorByUsername");
    private final String GET_PATIENT_BY_SSN = this.myResources.getString("getPatientBySSN");

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new  NamedParameterJdbcTemplate(this.dataSource);
        System.out.print("SEt Sourse");
        System.out.print(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public User getUserByUsername(String username) {
         MapSqlParameterSource paramSource = new MapSqlParameterSource("username", username);
         User user = null;
         List<Registrator> registrators = this.namedParameterJdbcTemplate.query(GET_REGISTRATOR_BY_USERNAME, paramSource, new RowMapper() {
             @Override
             public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Registrator registrator = new Registrator();
                registrator.setId(resultSet.getInt("id"));
                registrator.setLogin(resultSet.getString("Login"));
                registrator.setPassword(resultSet.getString("Password"));
                return registrator;
             }
         });
         List<PatientModel> patients = this.namedParameterJdbcTemplate.query(GET_PATIENT_BY_SSN, paramSource, new PatientRowMapper());
         if(!registrators.isEmpty()){
                GrantedAuthority newrole = new SimpleGrantedAuthority("ROLE_REGISTRATOR");
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(newrole);
                Collection<GrantedAuthority> Aut= authorities;
                user = new User(registrators.get(0).getLogin(), registrators.get(0).getPassword(), Aut);
        } else if(!patients.isEmpty() ){
                GrantedAuthority newrole = new SimpleGrantedAuthority("ROLE_PATIENT");
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(newrole);
                Collection<GrantedAuthority> Aut= authorities;
                user = new User(patients.get(0).getSSN(), patients.get(0).getPassword(), Aut);
        }
        return user;
    }



}
