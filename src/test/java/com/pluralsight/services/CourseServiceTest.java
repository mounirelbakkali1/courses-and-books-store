package com.pluralsight.services;

import com.pluralsight.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class CourseServiceTest {

    @Autowired
    CourseService service;

    @Test
    void getByID() throws Exception {
        Course course =service.getByID(2);
        int numOfOptionsInAquiz = course.getChapitres().get(0).getQuiz().getQuestions().get(0).getOptions().size();
        assertEquals(numOfOptionsInAquiz,2);
    }
}