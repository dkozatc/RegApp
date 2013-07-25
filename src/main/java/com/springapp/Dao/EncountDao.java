package com.springapp.dao;

import com.springapp.models.Encount;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/24/13
 * Time: 10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public interface EncountDao {
    public int insertEncounter(Encount encount);
    public String updateEncouter(Encount encount);
    public List<Encount> searchEncounters(String query);
    public int getEncounterID(Encount encount);
}
