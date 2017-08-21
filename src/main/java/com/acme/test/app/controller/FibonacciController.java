package com.acme.test.app.controller;

import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciController.class);

    @RequestMapping("/fibrec")
    public Response fibRec() {
        LOG.info("Called fibrec endpoint");
        return new Response(ResponseType.HELLO_WORLD, "Hello World!");
    }

    @RequestMapping("/fibtailrec")
    public Response fibTailRec() {
        LOG.info("Called fibtailrec endpoint");
        return new Response(ResponseType.HELLO_WORLD, "Hello World!");
    }

}

