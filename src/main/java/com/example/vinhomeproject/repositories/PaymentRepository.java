package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Payment;
import com.example.vinhomeproject.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    @Override
    List<Payment> findAll();
    Payment findPaymentById(Long id);

    Payment save(Payment payment);
}
