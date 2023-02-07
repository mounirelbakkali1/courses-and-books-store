package com.pluralsight.models;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "quizes")
@Setter
@Getter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String description;
    @Column(name = "success_rate")
    private float successRate;



    @OneToMany(fetch = FetchType.EAGER,cascade = ALL)
    @JoinColumn(name = "quiz_id")
    private List<Question> questions = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY, cascade = ALL)
    @JoinColumn(name = "quiz_id")
    private List<Option> rightAnswers = new ArrayList<>();


}