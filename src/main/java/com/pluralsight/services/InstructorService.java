package com.pluralsight.services;

import com.pluralsight.models.Instructor;
import com.pluralsight.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {


    @Autowired
    InstructorRepository repository;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    public void save(Instructor instructor){
        repository.save(instructor);
        eventPublisher.publishEvent(instructor);
    }
}
