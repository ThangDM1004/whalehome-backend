package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Payment;
import com.example.vinhomeproject.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    @Override
    List<Payment> findAll();
    Payment findPaymentById(Long id);

    Payment save(Payment payment);
    @Query("SELECT p FROM Payment p WHERE p.payment_time BETWEEN :startDate AND :endDate")
    List<Payment> findByPaymentTimeBetween(LocalDate startDate, LocalDate endDate);
}
