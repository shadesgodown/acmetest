package com.acme.test.app.controller;

import com.acme.test.app.domain.Album;
import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import com.acme.test.app.service.ICrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <code>RestController</code> used to perform CRUD (create, read, and
 * delete specifically) operations on <code>Album</code>s.
 */
@RestController
public class CrudController {
    private static final Logger LOG = LoggerFactory.getLogger(CrudController.class);

    @Autowired
    private ICrudService crudService;

    /**
     * Retrieves an <code>Album</code> by id.
     *
     * @param id the id of the <code>Album</code> to retrieve
     * @return the <code>Album</code> or <code>null</code> if not found
     * wrapped in a <code>Response</code> object with <code>ResponseType.CRUD</code>
     */
    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public Response getAlbum(@PathVariable final Long id) {
        LOG.info("Called album GET endpoint");
        return new Response(ResponseType.CRUD, crudService.findById(id));
    }

    /**
     * Retrieves all <code>Album</code>s from the repository.
     *
     * @return a <code>List</code> of all <code>Album</code>s in the repository
     * or an empty <code>List</code> wrapped in a <code>Response</code> object
     * with <code>ResponseType.CRUD</code>
     */
    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public Response getAlbums() {
        LOG.info("Called albums GET endpoint");
        return new Response(ResponseType.CRUD, crudService.findAll());
    }

    /**
     * Creates the <code>Album</code> sent in the body of the request
     * and saves in the repository.
     *
     * @param album the <code>Album</code> to be created and saved
     * @return the <code>Album</code> including its auto incremented id
     * wrapped in a <code>Response</code> object with <code>ResponseType.CRUD</code>
     */
    @RequestMapping(value = "/album", method = RequestMethod.POST)
    public Response createAlbum(@RequestBody final Album album) {
        LOG.info("Called albums POST endpoint");
        return new Response(ResponseType.CRUD, crudService.create(album));
    }

    /**
     * Deletes the <code>Album</code> sent in the body of the request
     * from the repository.
     *
     * @param album the <code>Album</code> to be deleted
     */
    @RequestMapping(value = "/album", method = RequestMethod.DELETE)
    public void deleteAlbum(@RequestBody final Album album) {
        LOG.info("Called album DELETE endpoint");
        crudService.delete(album);
    }

    /**
     * Deletes the <code>Album</code> with the id passed in from the
     * repository.
     *
     * @param id the id of the <code>Album</code> to be deleted
     */
    @RequestMapping(value = "/album/{id}", method = RequestMethod.DELETE)
    public void deleteAlbumById(@PathVariable final Long id) {
        LOG.info("Called album DELETE by id endpoint");
        crudService.deleteById(id);
    }
}
