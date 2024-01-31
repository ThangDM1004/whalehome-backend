package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.PaymentType;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/paymenttype")
public class PaymentTypeController {
    private PaymentTypeService sv;

    @Autowired
    public void PaymentTypeSerivce(PaymentTypeService sv){this.sv=sv;}

    @GetMapping
    public ResponseEntity<ResponseObject> getPaymentType(){return sv.getAllPaymentType();}
    @PutMapping()
    public ResponseEntity<ResponseObject> findPaymentType(Long id){return sv.getPaymentTypeById(id);}
    @PutMapping("/delete")
    public ResponseEntity<String> deletePaymentType(Long id){return sv.deletePaymentType(id);}
    @PutMapping("/update")
    public ResponseEntity<String> updatePaymentType(PaymentType id){return sv.updatePaymentType(id);}

    @PostMapping("/create")
    public ResponseEntity<String> createPaymentType(PaymentType id){return sv.createPaymentType(id);}
}
