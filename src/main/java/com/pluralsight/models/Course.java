package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.Duration;
import java.util.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title ;
    private String description;
    @ManyToMany(mappedBy = "ListOfCoursesEnrolledIn",cascade = ALL,fetch = LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Student> studentEnrolled= new ArrayList<>();
    @Column(name = "duration")
    private Duration duration;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @Lob
    @Column(name = "image",columnDefinition = "BLOB")
    private byte[] image ;

    @OneToMany(fetch = EAGER,cascade = ALL)
    @JoinColumn(name = "course_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<Tages> skillsConvered=new ArrayList<>();

    @OneToMany(cascade = ALL, orphanRemoval = true,fetch = EAGER)
    @JoinColumn(name = "course_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<Chapitre> chapitres = new ArrayList<>();

    @ElementCollection(targetClass = Audiance.class)
    @CollectionTable(name = "course_audiance", joinColumns = @JoinColumn(name = "course_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "audiance_id")
    private Set<Audiance> audiance = new HashSet<>();


    @Column(name = "release_date")
    @Temporal(DATE)
    private Date relaseDate;

    private float price;





}
