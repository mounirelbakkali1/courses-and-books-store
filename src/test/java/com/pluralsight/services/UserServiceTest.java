package com.pluralsight.services;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class UserServiceTest {

    @Autowired
    MockMvc mvc;

    @Test
    void findAllUsers() throws Exception {
        RequestBuilder requestBuilder = get("/users");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        String response = result.getResponse().getContentAsString();
        Integer id = JsonPath.parse(response).read("$[0].id");
        String username = JsonPath.parse(response).read("$[0].username");
        assertEquals(id,1);
        assertEquals("mounirelbakkali1",username);

    }


    @Test void shouldRetreiveANullPassword() throws Exception {
        MvcResult result = mvc.perform(get("/users/mapper")).andReturn();
        String password = JsonPath.parse(result.getResponse().getContentAsString()).read("$[0].password");
        assertNull(password);
    }
}