package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    @Query("SELECT a FROM Appointment a WHERE a.users.id = :userId")
    List<Appointment> findByUserId(@Param("userId") Long userId);
}
