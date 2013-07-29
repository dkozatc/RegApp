package com.springapp.dao;

import com.springapp.models.Encounter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/24/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public interface EncountDao {
    public int insertEncounter(Encounter encounter);
    public String updateEncouter(Encounter encounter);
    public List<Encounter> getEncounters(String query);
    public int getEncounterID(Encounter encounter);
}
