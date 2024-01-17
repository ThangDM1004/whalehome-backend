package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Long> {
}
