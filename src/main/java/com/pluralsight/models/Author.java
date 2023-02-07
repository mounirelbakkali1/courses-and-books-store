package com.pluralsight.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import static jakarta.persistence.TemporalType.DATE;

@Entity
@Table(name = "authors")
@Getter
@Setter
@ToString
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




}