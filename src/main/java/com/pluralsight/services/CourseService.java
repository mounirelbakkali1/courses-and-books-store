package com.pluralsight.services;

import com.pluralsight.models.Course;
import com.pluralsight.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository repository;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PersistenceContext
    EntityManager em;


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
}
