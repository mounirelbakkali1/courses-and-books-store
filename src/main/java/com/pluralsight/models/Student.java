package com.pluralsight.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @ManyToMany(cascade = ALL,fetch = FetchType.LAZY)
            @JoinTable(
                    name = "student_course",
                    joinColumns = @JoinColumn(name = "student_id"),
                    inverseJoinColumns = @JoinColumn(name = "course_id")
            )
    @JsonIgnore
    private List<Course> ListOfCoursesEnrolledIn =new ArrayList<Course>();

    @OneToMany(cascade = ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private List<Tages> preferenceTopics=new ArrayList<>();




}
