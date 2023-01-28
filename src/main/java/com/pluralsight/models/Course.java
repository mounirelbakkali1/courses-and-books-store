package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

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
    @ManyToMany(mappedBy = "ListOfCoursesEnrolledIn",cascade = ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Student> studentEnrolled= new ArrayList<>();
    @Column(name = "duration")
    private Duration duration;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @Lob
    @Column(name = "image",columnDefinition = "BLOB")
    private byte[] image ;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "skillsCovered",cascade = ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @Column(name = "couse")
    private List<Tages> skillsConvered=new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapitre> chapitres = new ArrayList<>();

    public void addChapitre(Chapitre chapitre) {
        chapitres.add(chapitre);
        chapitre.setCourse(this);
    }

    public void removeChapitre(Chapitre chapitre) {
        chapitres.remove(chapitre);
        chapitre.setCourse(null);
    }
}
