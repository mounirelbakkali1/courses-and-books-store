package com.pluralsight.repositories;

import com.pluralsight.models.Book;
import com.pluralsight.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRespository extends JpaRepository<Review,Integer> {

}
