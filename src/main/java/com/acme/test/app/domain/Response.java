package com.acme.test.app.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Response {
    private static final Logger LOG = LoggerFactory.getLogger(Response.class);

    private ResponseType type;
    private Object response;

    public Response(ResponseType type, Object response) {
        this.type = type;
        this.response = response;
    }

    public ResponseType getType() {
        return type;
    }

    public Object getResponse() {
        return response;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Response response1 = (Response) o;

        if (type != null ? !type.equals(response1.type) : response1.type != null) return false;
        return response != null ? response.equals(response1.response) : response1.response == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (response != null ? response.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
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
