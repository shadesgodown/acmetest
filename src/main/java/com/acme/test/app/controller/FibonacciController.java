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

/**
 * <code>RestController</code> used to calculate and return the first <code>n</code> values in the Fibonacci sequence.
 * Three endpoints are implemented (one that calculates with exponential complexity, one that
 * calculates with complexity of O(n), and one that is tail recursive (will not cause a <code>StackOverflowError</code>).
 */
@RestController
public class FibonacciController {
    private static final Logger LOG = LoggerFactory.getLogger(FibonacciController.class);

    @Autowired
    private IFibonacciService fibonacciService;

    /**
     * Calculates the first <code>num</code> values in the Fibonacci sequence using an
     * implementation with O(2^n) exponential complexity. It takes too long to
     * calculate the sequence after 40 values. An <code>IllegalArgumentException</code> is
     * thrown if <code>n</code> is less than 1 or greater than 40.
     *
     * @param num the number of values in the sequence to calculate (between 1 and 40)
     * @return <code>List</code> containing the calculated values
     * wrapped in a <code>Response</code> object with <code>ResponseType.FIBONACCI</code>
     */
    @RequestMapping(value = "/fib-exp/{num}", method = RequestMethod.GET)
    public Response fibExp(@PathVariable("num") final int num) {
        LOG.info("Called fib-exp endpoint");
        return new Response(ResponseType.FIBONACCI, fibonacciService.fibRecO2Expn(num));
    }

    /**
     * Calculates the first <code>num</code> values in the Fibonacci sequence using an
     * implementation with O(n) complexity. Values after the 93rd exceed Long.MAX_VALUE.
     * An <code>IllegalArgumentException</code> is thrown if <code>n</code> is less than
     * 1 or greater than 93.
     *
     * @param num the number of values in the sequence to calculate (between 1 and 93)
     * @return <code>List</code> containing the calculated values
     * wrapped in a <code>Response</code> object with <code>ResponseType.FIBONACCI</code>
     */
    @RequestMapping(value = "/fib-On/{num}", method = RequestMethod.GET)
    public Response fibOn(@PathVariable("num") final int num) {
        LOG.info("Called fib-On endpoint");
        return new Response(ResponseType.FIBONACCI, fibonacciService.fibRecOn(num));
    }

    /**
     * Calculates the first <code>num</code> values in the Fibonacci sequence using an
     * implementation with complexity of calculating the previous value plus <code>n - 1</code>
     * but with a tail recursive algorithm (will not cause a <code>StackOverflowError</code>).
     * Values after the 93rd exceed Long.MAX_VALUE. An <code>IllegalArgumentException</code>
     * is thrown if <code>n</code> is less than 1 or greater than 93.
     *
     * @param num the number of values in the sequence to calculate (between 1 and 93)
     * @return <code>List</code> containing the calculated values
     * wrapped in a <code>Response</code> object with <code>ResponseType.FIBONACCI</code>
     */
    @RequestMapping(value = "/fib-tail-rec/{num}", method = RequestMethod.GET)
    public Response fibTailRec(@PathVariable("num") final int num) {
        LOG.info("Called fib-tail-rec endpoint");
        return new Response(ResponseType.FIBONACCI, fibonacciService.fibRecTail(num));
    }

}

