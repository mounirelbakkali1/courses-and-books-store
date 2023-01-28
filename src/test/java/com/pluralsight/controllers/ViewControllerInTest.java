package com.pluralsight.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ViewControllerInTest {


    @Autowired
    MockMvc mockMvc;

    @Test
    void findBook() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books/1");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertNotNull(result);
    }

    @Test
    void findBooks() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/books");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(MediaType.APPLICATION_JSON_VALUE,result.getResponse().getContentType());
    }

}