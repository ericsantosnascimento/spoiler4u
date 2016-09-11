package com.spoiler.service;

import com.spoiler.Spoiler;
import com.spoiler.dao.SpoilerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by User on 17/03/2016.
 */
@Service
public class SpoilerService {

    @Autowired
    private SpoilerDAO spoilerDAO;

    public Spoiler saveOrUpdate(Spoiler spoiler){
        return  spoilerDAO.save(spoiler);
    }

    public void delete(Spoiler spoiler) {
        spoilerDAO.delete(spoiler);
    }

    public List<Spoiler> findAll(){
        return (List<Spoiler>) spoilerDAO.findAll();
    }

    public Spoiler findById(Long id) {
        return spoilerDAO.findOne(id);
    }

    /**
     * Randomize Spoilers
     *
     * @return Spoiler
     */
    public Spoiler random(){
        return spoilerDAO.findByRandomSpoiler().get(0);
    }
}
