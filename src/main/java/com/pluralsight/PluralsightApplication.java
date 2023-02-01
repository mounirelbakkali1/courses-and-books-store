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
import java.util.*;

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
            // new book
            Book book = new Book();
            book.setIsbn("E-8989");

            // new author
            Author author = new Author();
            author.setFullname("Alex feiro");
            author.setBio("american author");
            // DATE
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DATE,05);
            calendar.set(Calendar.YEAR,1999);
            calendar.set(Calendar.MONTH,01);
            author.setDateOfBirth(calendar.getTime());
            book.setAuthor(author);


            //saving book
            bookRepository.save(book);


            // getting book
            Book book1 = bookRepository.findById(1).orElse(null);

            // new reviews
            Review review1 = new Review(3.1f);
            Review review2 = new Review(3.4f);
            Review review3 = new Review(5f);

            // adding reviews to book
            book1.getReviews().add(review1);
            book1.getReviews().add(review2);
            book1.getReviews().add(review3);

            bookRepository.save(book1);


            System.out.println(book1);
            bookRepository.findAll().stream()
                    .forEach(book2 -> System.out.println(book2));

            System.out.println("Books rating");
            bookRepository.findAll().stream()
                    .forEach(b->{
                        System.out.println(b.getReviews());
                    });


            // new course
            Course course1 = new Course();
            course1.setTitle("Master JEE");

            // new Instructor
            Instructor instructor = new Instructor();
            instructor.setName("Mounir EL bakkali");
            course1.setInstructor(instructor);

            // saving course
            courseService.persist(course1);




            // new course
            Course course = new Course();


            // new chapitres
            Chapitre chapitre1 = new Chapitre("ch 1", "con bsqb qsbsq");
            Chapitre chapitre2 = new Chapitre("ch 2", "con bsqb qsbsq");
            Chapitre chapitre3 = new Chapitre("ch 3", "con bsqb qsbsq");


            course.getChapitres().add(chapitre1);
            course.getChapitres().add(chapitre2);
            course.getChapitres().add(chapitre3);



            // new Student
            Student student = new Student();
            student.setEmail("mounir@gmail.com");
            student.setPassword("Io2&mam-87");
            student.setName("Mounir EL bakkali");
            student.setUsername("mounirelbakkali1");

            // student enrolle to course
            student.getListOfCoursesEnrolledIn().add(course);
            course.getStudentEnrolled().add(student);


            // new skills couvred by the course
            Tages tag1 = new Tages("java");
            Tages tag2 = new Tages("jee");
            Tages tag3 = new Tages("spring boot");


            course.getSkillsConvered().add(tag1);
            course.getSkillsConvered().add(tag2);
            course.getSkillsConvered().add(tag3);

            // setting audiance
            course.getAudiance().add(Audiance.INTERMIDIATE);

            student.getPreferenceTopics().add(tag3);




            // new Path
            Path path = new Path();
            path.setTitle("JEE");
            path.setDescription("master jee for intermediate");

            // last course now is part of a path
            path.getCourses().add(course);



            // new  instructor
            Instructor instructor1 = new Instructor("Ahmed Abderrafie", "prof Youcode Maroc");
            course.setInstructor(instructor1);
            Duration duration = Duration.of(2,HOURS);
            course.setDuration(duration);
            course.setTitle("Deep into software engineering with JEE");
            courseService.persist(course);

            courseService.findAllCourses().stream()
                    .forEach(System.out::println);
        };
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Course course = courseService.getByID(2);
            List<Chapitre> chapitres = course.getChapitres();
            chapitres.stream()
                    .forEach(chapitre -> {
                        // new quiz for each chapitre
                        Quiz quiz = new Quiz();
                        quiz.setDescription("bla bla bla bla bla bla ");
                        quiz.setSuccessRate(0.6f);


                        // new options for quuiz question
                        Option  option = new Option();
                        option.setContent("opt 1");

                        Option option1 = new Option();
                        option1.setContent("opt 2");

                       // new Question
                        Question question = new Question();

                        question.setOptions(List.of(option1,option));

                        // this is the right answer
                        quiz.getRightAnswers().add(option);

                        quiz.setQuestions(List.of(
                                question
                        ));
                        chapitre.setQuiz(quiz);
                    });
            courseService.persist(course);
        };
    }



}
