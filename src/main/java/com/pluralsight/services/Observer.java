package com.pluralsight.services;


import com.pluralsight.models.Course;
import com.pluralsight.models.Instructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Observer  {

        @EventListener
        public void CourseCreated(@com.pluralsight.configuration.Course Course course){
                Optional<Instructor> instructor = Optional.ofNullable(course.getInstructor());
                System.out.printf("------- AUTHOR: %s has created %s course", instructor.map(instructor1 -> instructor1.getName()).orElse("default"),course.getTitle());
        }
        @EventListener
        public void InstructorCreated(@com.pluralsight.configuration.Instructor Instructor instructor){
                System.out.printf("------- AUTHOR: %s has been created a book %n ", instructor.getName());
        }


}
