package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Payment;
import com.example.vinhomeproject.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    @Query("SELECT p FROM Payment p WHERE p.contract.id = ?1 ORDER BY p.createDate asc")
    List<Payment> findAllByContractId(Long id);
    @Query("SELECT p FROM Payment p WHERE p.contract.id = :id AND EXTRACT(MONTH FROM p.payment_time) = :month AND EXTRACT(YEAR FROM p.payment_time) = :year")
    List<Payment> findAllByContractId(@Param("id") Long id, @Param("month") int month, @Param("year") int year);

}
