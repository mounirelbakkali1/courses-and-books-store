package com.pluralsight.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private float rate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;


    public Review(float rate,Book book) {
        this.rate = rate;
        this.book= book;
    }

}