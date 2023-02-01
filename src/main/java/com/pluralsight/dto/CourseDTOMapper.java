package com.pluralsight.dto;

import com.pluralsight.models.Course;
import com.pluralsight.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class CourseDTOMapper implements Function<Course,CourseDTO> {


    @Autowired ChapitresDTOMapper chapitresDTOMapper;
    @Autowired
    private CourseRepository courseRepository;

  /*  String title,
    Duration duration,
    Instructor instructor,
    byte[] image,
    List<Chapitre> chapitres,
    Audiance audiance,
    Date relaseDate,
    float price*/




    @Override
    public CourseDTO apply(Course course) {
        return new CourseDTO(
                course.getTitle(),
                course.getDuration(),
                course.getInstructor(),
                course.getImage(),
                getChapitreDTO(course),
                course.getAudiance(),
                course.getRelaseDate(),
                course.getPrice()
        );
    }


    public List<ChapiterDTO> getChapitreDTO(Course course){
        return course.getChapitres()
                .stream()
                .map(chapitre -> chapitresDTOMapper.apply(chapitre))
                .collect(Collectors.toList());
    }
}
