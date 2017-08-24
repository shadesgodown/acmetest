package com.acme.test.app.controller;

import com.acme.test.app.domain.Album;
import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import com.acme.test.app.service.ICrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudController {
    private static final Logger LOG = LoggerFactory.getLogger(CrudController.class);

    @Autowired
    private ICrudService crudService;

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public Response getAlbum(@PathVariable final Long id) {
        LOG.info("Called album GET endpoint");
        return new Response(ResponseType.CRUD, crudService.findById(id));
    }

    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public Response getAlbums() {
        LOG.info("Called albums GET endpoint");
        return new Response(ResponseType.CRUD, crudService.findAll());
    }

    @RequestMapping(value = "/album", method = RequestMethod.POST)
    public Response createAlbum(@RequestBody final Album album) {
        LOG.info("Called albums POST endpoint");
        return new Response(ResponseType.CRUD, crudService.create(album));
    }

    @RequestMapping(value = "/album", method = RequestMethod.DELETE)
    public void deleteAlbum(@RequestBody final Album album) {
        LOG.info("Called album DELETE endpoint");
        crudService.delete(album);
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.DELETE)
    public void deleteAlbumById(@PathVariable final Long id) {
        LOG.info("Called album DELETE by id endpoint");
        crudService.deleteById(id);
    }
}
