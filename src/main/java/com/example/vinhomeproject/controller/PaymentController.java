package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.Payment;

import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    private PaymentService sv;
    @Autowired
    public void PaymentSerivce(PaymentService sv){this.sv=sv;}
    @GetMapping
    public ResponseEntity<ResponseObject> getPayment(){return sv.getAllPayment();}
    @PutMapping
    public ResponseEntity<ResponseObject> findPayment(Long id){return sv.getPaymentById(id);}
    @PutMapping("/delete")
    public ResponseEntity<String> deletePayment(Long id){return sv.deletePayment(id);}
    @PutMapping("/update")
    public ResponseEntity<String>  updatePayment(Payment id){return sv.updatePayment(id);}
    @PostMapping("/create")
    public ResponseEntity<String>  createPayment(Payment id){return sv.createPayment(id);}
}
