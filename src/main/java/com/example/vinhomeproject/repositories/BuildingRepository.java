package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Long> {
}
