package com.acme.test.app.controller;

import com.acme.test.app.domain.Album;
import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CrudControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetAlbum() throws Exception {
        Album check = new Album();
        check.setId(1l);
        check.setArtist("Pearl Jam");
        check.setTitle("Ten");
        check.setLabel("Epic");

        mvc.perform(MockMvcRequestBuilders.get("/album/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Response(ResponseType.CRUD, check).toString()));
    }

    @Test
    public void testGetAlbumNull() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/album/50").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Response(ResponseType.CRUD, null).toString()));
    }

    @Test
    public void testGetAlbums() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/albums").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(result.getResponse().getContentAsString());
        JsonNode response = jsonNode.get("response");
        assertThat(response.size(), equalTo(9));
    }

    @Test
    public void testCreateAlbum() throws Exception {
        Album testAlbumRequest = new Album();
        testAlbumRequest.setArtist("Pearl Jam");
        testAlbumRequest.setTitle("Vs.");
        testAlbumRequest.setLabel("Epic");

        Album testAlbumResponse = new Album();
        testAlbumResponse.setId(10l);
        testAlbumResponse.setArtist("Pearl Jam");
        testAlbumResponse.setTitle("Vs.");
        testAlbumResponse.setLabel("Epic");

        mvc.perform(MockMvcRequestBuilders.post("/album").accept(MediaType.APPLICATION_JSON)
                .content(testAlbumRequest.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Response(ResponseType.CRUD, testAlbumResponse).toString()));

        mvc.perform(MockMvcRequestBuilders.delete("/album/10").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/album/9").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/albums").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(result.getResponse().getContentAsString());
        JsonNode response = jsonNode.get("response");
        assertThat(response.size(), equalTo(8));
    }

    @Test
    public void testDelete() throws Exception {
        Album testAlbumRequest = new Album();
        testAlbumRequest.setArtist("Pearl Jam");
        testAlbumRequest.setTitle("Vs.");
        testAlbumRequest.setLabel("Epic");

        Album testAlbumResponse = new Album();
        testAlbumResponse.setId(10l);
        testAlbumResponse.setArtist("Pearl Jam");
        testAlbumResponse.setTitle("Vs.");
        testAlbumResponse.setLabel("Epic");

        mvc.perform(MockMvcRequestBuilders.post("/album").accept(MediaType.APPLICATION_JSON)
                .content(testAlbumRequest.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Response(ResponseType.CRUD, testAlbumResponse).toString()));

        mvc.perform(MockMvcRequestBuilders.delete("/album").accept(MediaType.APPLICATION_JSON)
                .content(testAlbumResponse.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/albums").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(result.getResponse().getContentAsString());
        JsonNode response = jsonNode.get("response");
        assertThat(response.size(), equalTo(9));
    }
}
