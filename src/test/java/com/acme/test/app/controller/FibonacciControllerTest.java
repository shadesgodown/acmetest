package com.acme.test.app.controller;

import com.acme.test.app.domain.Response;
import com.acme.test.app.domain.ResponseType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FibonacciControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testFibExp() throws Exception {
        List<Long> check = new ArrayList<>(8);
        check.addAll(new ArrayList(Arrays.asList(0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l)));

        mvc.perform(MockMvcRequestBuilders.get("/fib-exp/8").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Response(ResponseType.FIBONACCI, check).toString()));
    }

    @Test
    public void testFibOn() throws Exception {
        List<Long> check = new ArrayList<>(8);
        check.addAll(new ArrayList(Arrays.asList(0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l)));

        mvc.perform(MockMvcRequestBuilders.get("/fib-On/8").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Response(ResponseType.FIBONACCI, check).toString()));
    }

    @Test
    public void testFibTailRec() throws Exception {
        List<Long> check = new ArrayList<>(8);
        check.addAll(new ArrayList(Arrays.asList(0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l)));

        mvc.perform(MockMvcRequestBuilders.get("/fib-tail-rec/8").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Response(ResponseType.FIBONACCI, check).toString()));
    }

}
