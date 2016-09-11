package com.spoiler.controller;

import com.spoiler.Spoiler;
import com.spoiler.service.SpoilerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Company controller to access the api operations
 * <p/>
 * Created by Eric Nascimento on 16/12/2015.
 */
@RestController
@RequestMapping("/api/spoilers")
public class SpoilerController {

    private static final Logger logger = LoggerFactory.getLogger(SpoilerController.class);

    @Autowired
    private SpoilerService spoilerService;

    /**
     * retrieve list of spoilers
     *
     * @return list of spoilers
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Spoiler> list() {
        return spoilerService.findAll();
    }

    /**
     * retrive spoiler by id
     *
     * @param id
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Spoiler listOne(@PathVariable long id) {
        return spoilerService.findById(id);
    }

    /**
     * create spoiler
     *
     * @param spoiler
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Spoiler create(@RequestBody Spoiler spoiler) {
        logger.info("creating or updating company: {}", spoiler);
        return spoilerService.saveOrUpdate(spoiler);
    }

    /**
     * delete spoiler
     *
     * @param spoiler
     */
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Spoiler spoiler) {
        logger.info("deleting commpany: {}", spoiler);
        spoilerService.delete(spoiler);
    }

    /**
     * retrive random spoiler
     *
     */
    @CrossOrigin(origins = {"http://spoiler4u.com", "http://localhost:8080","http://ec2-52-90-187-212.compute-1.amazonaws.com:9000"})
    @RequestMapping(path = "/random", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Spoiler random() {
        return spoilerService.random();
    }
}
