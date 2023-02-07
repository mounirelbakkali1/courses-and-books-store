package com.pluralsight.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pluralsight.dto.CourseDTO;
import com.pluralsight.services.CourseService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {


    @Autowired
    CourseService service;

    @Autowired
    ObjectMapper mapper;


    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAll(){
        List<CourseDTO> courses = service.findAllCoursesDTO();
        // duration data type is throwing json parsing exeption
        // TODO : I ADDED com.fasterxml.jackson.datatype module
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/view")
    public ModelAndView viewCourses(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courses");
        modelAndView.addObject("courses", service.findAllCoursesDTO());
        return modelAndView;
    }


    @PostConstruct
    private void setUp() {
        mapper.registerModule(new JavaTimeModule());
    }
}
