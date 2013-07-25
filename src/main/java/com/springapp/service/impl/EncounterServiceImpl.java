package com.springapp.service.impl;

import com.springapp.dao.EncountDao;
import com.springapp.models.Encount;
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
    public String editEncounter(Encount encount) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public int createEncounter(Encount encount) {
        encountDao.insertEncounter(encount);
        return 0;
    }

    @Override
    public List<Encount> searchPatient(String query) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
