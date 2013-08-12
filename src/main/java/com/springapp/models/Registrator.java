package com.springapp.models;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 8/9/13
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Registrator {
    private int id;
    private String login;
    private String password;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
