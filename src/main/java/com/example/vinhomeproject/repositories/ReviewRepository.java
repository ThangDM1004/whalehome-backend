package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Review;
import com.example.vinhomeproject.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
