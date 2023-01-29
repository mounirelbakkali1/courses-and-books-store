package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "quizes")
@Setter
@Getter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(mappedBy = "quiz")
    private Chapitre chapitre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quiz")
    private Set<Question> questions = new HashSet<>();


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quiz")
    private List<RAnswer> rightAnswers = new ArrayList<>();


}