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

import static javax.persistence.CascadeType.ALL;
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
    @OneToMany(fetch = FetchType.EAGER,cascade = ALL)
    @JoinColumn(name = "book_id")
    private List<Review> reviews = new ArrayList<>();

    private String description ;

    @Column(columnDefinition = "BLOB")
    @Lob
    private byte[] image;

    private float price;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "author_id")
    private Author author;





    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", reviews=" + reviews +
                ", author=" + author +
                '}';
    }

    public void addReview(Review review){
        reviews.add(review);
    }
}
