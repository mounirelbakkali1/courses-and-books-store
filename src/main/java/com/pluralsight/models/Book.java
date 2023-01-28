package com.pluralsight.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id ;
    private String isbn;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book",cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Review> reviews = new ArrayList<>();

    public void addReview(Review review){
        reviews.add(review);
        review.setBook(this);
    }
}
