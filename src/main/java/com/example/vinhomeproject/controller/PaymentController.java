package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.Payment;

import com.example.vinhomeproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/payment")
public class PaymentController {
    private PaymentService sv;
    @Autowired
    public void PaymentSerivce(PaymentService sv){this.sv=sv;}
    @GetMapping
    public List<Payment> getPayment(){return sv.getAllPayment();}
    @PutMapping
    public Payment findPayment(Long id){return sv.getPaymentById(id);}
    @PutMapping("/delete")
    public Payment deletePayment(Long id){return sv.deletePayment(id);}
    @PutMapping("/update")
    public Payment updatePayment(Payment id){return sv.updatePayment(id);}
    @PostMapping("/create")
    public Payment createPayment(Payment id){return sv.createPayment(id);}
}
