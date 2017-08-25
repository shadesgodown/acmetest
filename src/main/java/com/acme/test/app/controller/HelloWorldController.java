package com.acme.test.app.controller;

import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple <code>RestController</code> that returns the response
 * <code>Hello World!</code>.
 */
@RestController
public class HelloWorldController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    /**
     * Returns the response <code>Hello World!</code>.
     *
     * @return <code>String</code> <code>Hello World!</code> wrapped
     * in a <code>Response</code> object with <code>ResponseType.HELLO_WORLD</code>
     */
    @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    public Response helloWorld() {
        LOG.info("Called hello-world endpoint");
        return new Response(ResponseType.HELLO_WORLD, "Hello World!");
    }

}
