package com.pluralsight.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

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
