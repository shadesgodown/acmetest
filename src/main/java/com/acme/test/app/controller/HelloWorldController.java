package com.acme.test.app.controller;

import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public Response helloWorld() {
        LOG.info("Called helloworld endpoint");
        return new Response(ResponseType.HELLO_WORLD, "Hello World!");
    }

}
