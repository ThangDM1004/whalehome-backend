package com.example.vinhomeproject.service;

import com.example.vinhomeproject.models.Payment;
import com.example.vinhomeproject.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository rs;

    public PaymentService(PaymentRepository rs) {
        this.rs = rs;
    }

    public List<Payment> getAllPayment(){
        return rs.findAll();
    }
    public Payment getPaymentById(Long id){return rs.findPaymentById(id);}
    public Payment deletePayment(Long id) {
        Payment existingUser = rs.findPaymentById(id);

        if (existingUser != null) {
            existingUser.setStatus(false);
            return rs.save(existingUser);
        }

        return null;
    }

    public Payment updatePayment(Payment id) {
        Payment existingUser = rs.findPaymentById(id.getId());

        if (existingUser != null) {
            existingUser.setContent(id.getContent());
            existingUser.setPayment_time(id.getPayment_time());
            existingUser.setPaymentType(id.getPaymentType());
            existingUser.setTotal_price(id.getTotal_price());
            existingUser.setStatus(false);
            return rs.save(existingUser);
        }

        return null;
    }
    public Payment createPayment(Payment id) {
        Payment existingUser = new Payment();


        existingUser.setContent(id.getContent());
        existingUser.setPayment_time(id.getPayment_time());
        existingUser.setPaymentType(id.getPaymentType());
        existingUser.setTotal_price(id.getTotal_price());
        existingUser.setStatus(false);
        return rs.save(existingUser);



    }
}
