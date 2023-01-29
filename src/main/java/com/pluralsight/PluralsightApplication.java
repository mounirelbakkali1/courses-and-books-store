package com.pluralsight;

import com.pluralsight.models.*;
import com.pluralsight.repositories.BookRepository;
import com.pluralsight.repositories.ReviewRespository;
import com.pluralsight.services.CourseService;
import com.pluralsight.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.HOURS;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.pluralsight.repositories")
public class PluralsightApplication {


    @Autowired CourseService courseService;

    @Autowired
    InstructorService instructorService;
    @Autowired
    ReviewRespository reviewRespository;
    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(PluralsightApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(){
        return args->{

            Book book = new Book();
            book.setIsbn("E-8989");


            Author author = new Author();
            author.setFullname("Alex feiro");
            author.setBio("american author");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DATE,05);
            calendar.set(Calendar.YEAR,1999);
            calendar.set(Calendar.MONTH,01);
            author.setDateOfBirth(calendar.getTime());
            book.setAuthor(author);

            author.getBooks().add(book);


            bookRepository.save(book);



            Book book1 = bookRepository.findById(1).orElse(null);
            Review review1 = new Review(3.1f,book1);
            Review review2 = new Review(3.4f,book1);
            Review review3 = new Review(5f,book1);

            book.getReviews().add(review1);
            book.getReviews().add(review2);
            book.getReviews().add(review3);
            reviewRespository.save(review1);
            reviewRespository.save(review2);
            reviewRespository.save(review3);

            System.out.println(book1);
            bookRepository.findAll().stream()
                    .forEach(book2 -> System.out.println(book2));

            System.out.println("Books rating");
            bookRepository.findAll().stream()
                    .forEach(b->{
                        System.out.println(b.getId()+" : "+bookRepository.getBookRating(b));
                    });


           Course course1 = new Course();
            course1.setTitle("Master JEE");
            Instructor instructor = new Instructor();
            instructor.setName("Mounir EL bakkali");
            instructor.getCourses().add(course1);
            instructorService.save(instructor);

            course1.setInstructor(instructor);
            courseService.persist(course1);





            Course course = new Course();

            Chapitre chapitre1 = new Chapitre("ch 1", "con bsqb qsbsq");
            Chapitre chapitre2 = new Chapitre("ch 2", "con bsqb qsbsq");
            Chapitre chapitre3 = new Chapitre("ch 3", "con bsqb qsbsq");
            chapitre1.setCourse(course);
            chapitre2.setCourse(course);
            chapitre3.setCourse(course);

            course.getChapitres().add(chapitre1);
            course.getChapitres().add(chapitre2);
            course.getChapitres().add(chapitre3);

            Student student = new Student();
            student.setEmail("mounir@gmail.com");
            student.setPassword("Io2&mam-87");
            student.setName("Mounir EL bakkali");
            student.setUsername("mounirelbakkali1");

            student.getListOfCoursesEnrolledIn().add(course);
            course.getStudentEnrolled().add(student);

            Tages tag1 = new Tages("java");
            Tages tag2 = new Tages("jee");
            Tages tag3 = new Tages("spring boot");

            tag1.setSkillsCovered(course);
            tag2.setSkillsCovered(course);
            tag3.setSkillsCovered(course);

            course.getSkillsConvered().add(tag1);
            course.getSkillsConvered().add(tag2);
            course.getSkillsConvered().add(tag3);
            course.getAudiance().add(Audiance.INTERMIDIATE);

            student.getPreferenceTopics().add(tag3);
            tag3.setStudentPreference(student);
            tag1.setStudentPreference(student);
            tag2.setStudentPreference(student);

            Path path = new Path();
            path.setTitle("JEE");
            path.setDescription("master jee for intermediate");
            path.getCourses().add(course);

            course.setPath(path);


            Instructor instructor1 = new Instructor("Ahmed Abderrafie", "prof Youcode Maroc");
            course.setInstructor(instructor1);
            instructor1.getCourses().add(course);
            Duration duration = Duration.of(2,HOURS);
            course.setDuration(duration);
            course.setTitle("Deep into software engineering with JEE");
            courseService.persist(course);
            courseService.findAllCourses().stream()
                    .forEach(System.out::println);


        };
    }



}
