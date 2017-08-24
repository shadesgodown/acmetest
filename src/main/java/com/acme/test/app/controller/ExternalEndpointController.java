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

@RestController
public class ExternalEndpointController {
    private static final Logger LOG = LoggerFactory.getLogger(ExternalEndpointController.class);

    @RequestMapping(value = "/externalEndpoint", method = RequestMethod.GET)
    public Response externalEndpoint() throws IOException {
        LOG.info("Called externalEndpoint endpoint");
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
