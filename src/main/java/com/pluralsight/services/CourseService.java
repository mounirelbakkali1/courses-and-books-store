package com.pluralsight.services;

import com.pluralsight.dto.CourseDTO;
import com.pluralsight.dto.CourseDTOMapper;
import com.pluralsight.models.Course;
import com.pluralsight.repositories.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    CourseRepository repository;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PersistenceContext
    EntityManager em;


    @Autowired
    CourseDTOMapper mapper ;


    @Transactional
    public void persist(Course course){
        repository.save(em.merge(course));
        eventPublisher.publishEvent(course);
    }

    public Course getByID(int id){
        Course course =repository.findById(id).get();
        eventPublisher.publishEvent(course);
        return course;
    }
    public List<Course> findAllCourses(){
        return repository.findAll();
    }


    public List<CourseDTO> findAllCoursesDTO(){
        return repository.findAll()
                .stream()
                .map(course -> mapper.apply(course))
                .collect(Collectors.toList());
    }
}
