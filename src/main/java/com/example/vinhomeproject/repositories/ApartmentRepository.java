package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Long> {
}
