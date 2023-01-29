package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "full_name")
    private String fullname;

    private String bio;
    @Column(name = "date_of_birth")
    @Temporal(DATE)
    private Date dateOfBirth;


    @OneToMany(mappedBy = "author",fetch = LAZY)
    @JsonIgnore
    private Set<Book> books = new HashSet<>();


}