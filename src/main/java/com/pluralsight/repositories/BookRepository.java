package com.pluralsight.repositories;

import com.pluralsight.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT AVG (b.rate) FROM Review b WHERE b.book=:id")
    float getBookRating(@Param("id") Book book);
}
