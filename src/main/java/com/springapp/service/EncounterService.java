package com.springapp.service;

import com.springapp.models.Encount;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/24/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public interface EncounterService {

    public String editEncounter(Encount encount);
    public int createEncounter(Encount encount);
    public List<Encount> searchPatient(String query);



}
