package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.Payment;

import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseObject> getPayment(){return sv.getAllPayment();}
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getPaymentById(@PathVariable Long id){
        return sv.getPaymentById(id);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deletePayment(Long id){return sv.deletePayment(id);}
    @PutMapping("/update/{id}")
    public ResponseEntity<String>  updatePayment(Payment id){return sv.updatePayment(id);}
    @PostMapping
    public ResponseEntity<String>  createPayment(Payment id){return sv.createPayment(id);}
}
