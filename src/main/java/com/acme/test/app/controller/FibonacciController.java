package com.acme.test.app.controller;

import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import com.acme.test.app.service.IFibonacciService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    private static final Logger LOG = LoggerFactory.getLogger(FibonacciController.class);

    @Autowired
    IFibonacciService fibonacciService;

    @RequestMapping(value = "/fibExp/{num}", method = RequestMethod.GET)
    public Response fibExp(@PathVariable("num") final int num) {
        LOG.info("Called fibExp endpoint");
        return new Response(ResponseType.FIBONACCI, fibonacciService.fibRecO2Expn(num));
    }

    @RequestMapping(value = "/fibConstant/{num}", method = RequestMethod.GET)
    public Response fibConstant(@PathVariable("num") final int num) {
        LOG.info("Called fibConstant endpoint");
        return new Response(ResponseType.FIBONACCI, fibonacciService.fibRecOn(num));
    }

    @RequestMapping(value = "/fibTailRec/{num}", method = RequestMethod.GET)
    public Response fibTailRec(@PathVariable("num") final int num) {
        LOG.info("Called fibTailRec endpoint");
        return new Response(ResponseType.FIBONACCI, fibonacciService.fibRecTail(num));
    }

}

