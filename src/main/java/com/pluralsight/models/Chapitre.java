package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "chapitres")
@Getter
@Setter
@NoArgsConstructor
public class Chapitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String title;
    private String content;



    @OneToOne(cascade = ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Chapitre(String title, String content) {
        this.title = title;
        this.content = content;
    }
}