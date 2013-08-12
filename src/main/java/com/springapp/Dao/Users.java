package com.springapp.dao;

import org.springframework.security.core.userdetails.User;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/9/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Users {
    public User getUserByUsername(String username);
}
