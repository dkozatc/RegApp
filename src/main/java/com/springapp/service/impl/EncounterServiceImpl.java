package com.springapp.service.impl;

import com.springapp.dao.EncountDao;
import com.springapp.models.Encounter;
import com.springapp.service.EncounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dkozar
 * Date: 7/24/13
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class EncounterServiceImpl implements EncounterService {
    @Autowired
    private EncountDao encountDao;

    @Override
    public String editEncounter(Encounter encounter) {

        encountDao.updateEncouter(encounter);

        return null;
    }


    public int createEncounter(Encounter encounter) {
       int id = encountDao.insertEncounter(encounter);
        return id;
    }

    @Override
    public List<Encounter> searchEncounters(String query) {

       List<Encounter> encounters = encountDao.getEncounters(query);

       return encounters;
    }
}
