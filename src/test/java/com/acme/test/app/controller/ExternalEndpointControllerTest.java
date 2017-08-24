package com.acme.test.app.controller;

import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;

@RunWith(JMockit.class)
public class ExternalEndpointControllerTest {

    @Tested
    ExternalEndpointController externalEndpointController;

    @Test
    public void testCreateDeadlock(@Mocked RestTemplate restTemplate) throws Exception {
        new Expectations() {{
            restTemplate.getForEntity(anyString, String.class);
            result = new ResponseEntity<>("{\"test\": \"blahblahblah\"}", HttpStatus.OK);
            result = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }};

        ObjectMapper mapper = new ObjectMapper();
        JsonNode body = mapper.readTree("{\"test\": \"blahblahblah\"}");

        assertThat(externalEndpointController.externalEndpoint(), equalTo(new Response(ResponseType.EXTERNAL_ENDPOINT, body)));

        try {
            externalEndpointController.externalEndpoint();
            fail();
        } catch (IOException ex) {
            assertThat(ex.getMessage(), equalTo("Did not receive response from https://jsonplaceholder.typicode.com/posts successfully."));
        }
    }

}
