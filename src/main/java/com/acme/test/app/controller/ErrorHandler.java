package com.acme.test.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <code>ControllerAdvice</code> that sends a <code>ResponseStatus</code>
 * of <code>HttpStatus.BAD_REQUEST</code> if an <code>IllegalArgumentException</code>
 * is thrown from a REST endpoint.
 */
@ControllerAdvice
public class ErrorHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ErrorHandler.class);

    /**
     * Sends an <code>HttpStatus.BAD_REQUEST</code> error if an
     * <code>IllegalArgumentException</code> occurs.
     *
     * @param e the <code>IllegalArgumentException</code> that occurred
     * @param response the <code>HttpServeltResponse</code> that is used to return the
     *                 <code>HttpStatus.BAD_REQUEST</code> error
     * @throws IOException if the <code>sendError</code> method fails
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void processValidationError(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        LOG.info("Returning HTTP 400 Bad Request", e);
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
