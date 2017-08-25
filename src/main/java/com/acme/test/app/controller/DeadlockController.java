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

/**
 * <code>RestController</code> used to create a deadlock scenario between two threads. The threads
 * simulate a deadlock between a <code>Pedestrian</code> and a <code>Driver</code>
 * at a <code>Crosswalk</code>, each one waiting for the other to cross.
 */
@RestController
public class DeadlockController {
    private static final Logger LOG = LoggerFactory.getLogger(DeadlockController.class);

    @Autowired
    IDeadlockService deadlockService;

    /**
     * Creates a deadlock scenario between two threads (each thread is waiting on the other).
     * Simulates a deadlock between a <code>Pedestrian</code> and a <code>Driver</code>
     * at a <code>Crosswalk</code>, each one waiting for the other to cross. The endpoint
     * times out after 3 seconds and returns reporting the deadlock state.
     *
     * @return a <code>String</code> stating that the deadlock did occur wrapped in
     * a <code>Response</code> object with a <code>ResponseType.DEADLOCK</code>
     * @throws Exception with a message stating that the deadlock did not occur if
     * the deadlock is not successful
     */
    @RequestMapping(value = "/deadlock", method = RequestMethod.GET)
    public Response deadlock() throws Exception {
        LOG.info("Called deadlock endpoint");
        if (deadlockService.createDeadlock()) {
            return new Response(ResponseType.DEADLOCK, "Deadlock occurred between Pedestrian and Driver at the Crosswalk.");
        } else {
            String error = "Deadlock did not occur between Pedestrian and Driver at the Crosswalk.";
            LOG.error(error);
            throw new Exception(error);
        }
    }

}
