package com.acme.test.app.controller;

import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * <code>RestController</code> used to request an external endpoint (https://jsonplaceholder.typicode.com/posts)
 * and return it's content in response.
 */
@RestController
public class ExternalEndpointController {
    private static final Logger LOG = LoggerFactory.getLogger(ExternalEndpointController.class);

    /**
     * Uses Spring's <code>RestTemplate</code> to request the external endpoint (https://jsonplaceholder.typicode.com/posts)
     * and return it's content in response.
     *
     * @return the external endpoint's content wrapped in a <code>Response</code> object with
     * <code>ResponseType.EXTERNAL_ENDPOINT</code>
     * @throws IOException if the external endpoint does not return a response successfully
     */
    @RequestMapping(value = "/external-endpoint", method = RequestMethod.GET)
    public Response externalEndpoint() throws IOException {
        LOG.info("Called external-endpoint endpoint");
        RestTemplate restTemplate = new RestTemplate();
        String externalEndpointUrl = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<String> response = restTemplate.getForEntity(externalEndpointUrl, String.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new IOException("Did not receive response from https://jsonplaceholder.typicode.com/posts successfully.");
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode body = mapper.readTree(response.getBody());
        return new Response(ResponseType.EXTERNAL_ENDPOINT, body);
    }

}
