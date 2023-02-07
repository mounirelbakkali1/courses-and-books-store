package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.util.*;

import jakarta.persistence.*;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name = "questions")
@Setter
@Getter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    private String question;


    @ManyToMany(cascade = ALL,fetch = EAGER)
    @JoinTable(
            name="question_option",
            joinColumns=@JoinColumn(name="question_id"),
            inverseJoinColumns=@JoinColumn(name="option_id")
    )
    @Fetch(FetchMode.SUBSELECT)
    private List<Option> options = new ArrayList<>();



}