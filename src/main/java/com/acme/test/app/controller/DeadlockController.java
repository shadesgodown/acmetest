package com.acme.test.app.controller;

import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import com.acme.test.app.service.IDeadlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeadlockController {
    private static final Logger LOG = LoggerFactory.getLogger(DeadlockController.class);

    @Autowired
    IDeadlockService deadlockService;

    @RequestMapping(value = "/deadlock", method = RequestMethod.GET)
    public Response deadlock() throws Exception {
        LOG.info("Called deadlock endpoint");
        if (deadlockService.createDeadlock()) {
            return new Response(ResponseType.DEADLOCK, "Deadlock between Pedestrian and Driver was encountered at the Crosswalk.");
        } else {
            String error = "Deadlock did not occur between Pedestrian and Driver at the Crosswalk.";
            LOG.error(error);
            throw new Exception(error);
        }
    }

}
