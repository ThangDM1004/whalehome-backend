package com.example.vinhomeproject.service;

import com.example.vinhomeproject.models.Payment;
import com.example.vinhomeproject.repositories.PaymentRepository;
import com.example.vinhomeproject.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository rs;

    public PaymentService(PaymentRepository rs) {
        this.rs = rs;
    }

    public ResponseEntity<ResponseObject> getAllPayment(){
        List<Payment> paymentList=rs.findAll();

        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                paymentList
        ));
    }
    public ResponseEntity<ResponseObject> getPaymentById(Long id){


        return ResponseEntity.ok(new ResponseObject(
                "successfully",
                rs.findPaymentById(id)
        ));

    }


    public  ResponseEntity<String> deletePayment(Long id) {
        Payment existingUser = rs.findPaymentById(id);

        if (existingUser != null) {
            existingUser.setStatus(false);
            rs.save(existingUser);
            return ResponseEntity.ok("delete successfully");
        }else {
            return ResponseEntity.ok("id not exist");
        }


    }

    public ResponseEntity<String> updatePayment(Payment id) {
        Payment existingUser = rs.findPaymentById(id.getId());

        if (existingUser != null) {
            if (id.getContent()!=null){ existingUser.setContent(id.getContent());}
            if (id.getPayment_time()!=null){existingUser.setPayment_time(id.getPayment_time());}
            if (id.getPaymentType()!=null){ existingUser.setPaymentType(id.getPaymentType());}
            if (id.getTotal_price()!=0){existingUser.setTotal_price(id.getTotal_price());}
            existingUser.setStatus(false);
             rs.save(existingUser);
             return ResponseEntity.ok("update successfully");
        }else {
            return ResponseEntity.ok("id not exist");
        }
    }
    public ResponseEntity<String> createPayment(Payment id) {
        Payment existingUser = new Payment();
        existingUser.setContent(id.getContent());
        existingUser.setPayment_time(id.getPayment_time());
        existingUser.setPaymentType(id.getPaymentType());
        existingUser.setTotal_price(id.getTotal_price());
        existingUser.setStatus(true);
        rs.save(existingUser);
        return ResponseEntity.ok("create successfully");



    }
}
