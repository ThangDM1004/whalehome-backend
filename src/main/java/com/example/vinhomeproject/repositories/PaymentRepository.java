package com.example.vinhomeproject.repositories;

import com.example.vinhomeproject.models.Payment;
import com.example.vinhomeproject.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
