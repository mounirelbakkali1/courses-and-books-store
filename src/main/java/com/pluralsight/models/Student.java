package com.pluralsight.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = {PERSIST,MERGE})
            @JoinTable(
                    name = "student_course",
                    joinColumns = @JoinColumn(name = "student_id"),
                    inverseJoinColumns = @JoinColumn(name = "course_id")
            )
    private List<Course> ListOfCoursesEnrolledIn =new ArrayList<Course>();

    @OneToMany(cascade = ALL,mappedBy = "studentPreference")
    private List<Tages> preferenceTopics=new ArrayList<>();




}
