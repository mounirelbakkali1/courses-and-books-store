package com.pluralsight.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "paths")
@Getter
@Setter
public class Path {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String title ;
    private String description ;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "path_id")
    private Set<Course> courses = new HashSet<>();
}
