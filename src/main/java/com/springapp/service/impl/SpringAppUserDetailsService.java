package com.springapp.service.impl;

import com.springapp.dao.Users;
import com.springapp.models.Registrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.net.Authenticator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/8/13
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */

public class SpringAppUserDetailsService implements UserDetailsService{
    @Autowired
    private Users usersDao;

public UserDetails loadUserByUsername(String s)  {
        UserDetails  User= usersDao.getUserByUsername(s);
        return User;
    }
}
