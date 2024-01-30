package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.PaymentType;
import com.example.vinhomeproject.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://whale-home-apartment-rent-front-end-web-admin-2.vercel.app"})
@RequestMapping("/api/v1/paymenttype")
public class PaymentTypeController {
    private PaymentTypeService sv;

    @Autowired
    public void PaymentTypeSerivce(PaymentTypeService sv){this.sv=sv;}

    @GetMapping
    public List<PaymentType> getPaymentType(){return sv.getAllPaymentType();}
    @PutMapping()
    public PaymentType findPaymentType(Long id){return sv.getPaymentTypeById(id);}
    @PutMapping("/delete")
    public PaymentType deletePaymentType(Long id){return sv.deletePaymentType(id);}
    @PutMapping("/update")
    public PaymentType updatePaymentType(PaymentType id){return sv.updatePaymentType(id);}

    @PostMapping("/create")
    public PaymentType createPaymentType(PaymentType id){return sv.createPaymentType(id);}
}
