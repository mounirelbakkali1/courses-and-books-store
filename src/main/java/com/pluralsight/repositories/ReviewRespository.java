package com.pluralsight.repositories;

import com.pluralsight.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRespository extends JpaRepository<Review,Integer> {
}
