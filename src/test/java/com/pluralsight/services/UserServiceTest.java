package com.pluralsight.services;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


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
        DocumentContext jsonContext = JsonPath.parse(result.getResponse().getContentAsString());
        Configuration conf = Configuration.defaultConfiguration().addOptions(Option.SUPPRESS_EXCEPTIONS);
        String rest = JsonPath.using(conf).parse(result.getResponse().getContentAsString()).read("$[0].password");
        assertNull(rest);
    }
}