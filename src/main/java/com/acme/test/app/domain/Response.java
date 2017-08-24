package com.acme.test.app.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic response class used to convert a service response into JSON with the response type
 * and the response content.
 */
public class Response {
    private static final Logger LOG = LoggerFactory.getLogger(Response.class);

    // the response type
    private ResponseType type;

    // the response content
    private Object response;

    /**
     * Constructor to create a response made up of a <code>ResponseType</code>
     * and a response.
     *
     * @param type the response type (from the <code>ResponseType</code> <code>enum</code>)
     * @param response the response content
     */
    public Response(ResponseType type, Object response) {
        this.type = type;
        this.response = response;
    }

    /**
     * Gets the <code>ResponseType</code>.
     *
     * @return the <code>ResponseType</code>
     */
    public ResponseType getType() {
        return type;
    }

    /**
     * Gets the response content.
     *
     * @return the response content
     */
    public Object getResponse() {
        return response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Response response1 = (Response) o;

        if (type != null ? !type.equals(response1.type) : response1.type != null) return false;
        return response != null ? response.equals(response1.response) : response1.response == null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (response != null ? response.hashCode() : 0);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // uses Jackson ObjectMapper to convert object to JSON String
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOG.warn("Could not serialize object to JSON");
            return "Response{" +
                    "type='" + type + '\'' +
                    ", response=" + response +
                    '}';
        }
    }
}
