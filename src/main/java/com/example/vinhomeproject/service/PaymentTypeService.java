package com.example.vinhomeproject.service;

import com.example.vinhomeproject.models.PaymentType;
import com.example.vinhomeproject.repositories.PaymentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeService {
    private final PaymentTypeRepository rs;




    public PaymentTypeService(PaymentTypeRepository rs) {
        this.rs = rs;
    }

    public List<PaymentType> getAllPaymentType(){
        return rs.findAll();
    }
    public PaymentType getPaymentTypeById(Long id){
        return rs.findPaymentTypeById(id);
    }
    public PaymentType deletePaymentType(Long id) {
        PaymentType existingUser = rs.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setStatus(false);


            return rs.save(existingUser);
        }

        return null;
    }
    public PaymentType updatePaymentType(PaymentType id) {
        PaymentType existingUser =rs.findById(id.getId()).orElse(null);

        if (existingUser != null) {
            existingUser.setStatus(id.isStatus());
            existingUser.setPayments(id.getPayments());
            existingUser.setName(id.getName());
            existingUser.setCreateBy(id.getCreateBy());
            existingUser.setCreateDate(id.getCreateDate());
            existingUser.setModifiedBy(id.getModifiedBy());
            existingUser.setModifiedDate(id.getModifiedDate());
            return rs.save(existingUser);
        }

        return null;
    }

    public PaymentType createPaymentType(PaymentType id) {
        PaymentType existingUser = new PaymentType();


        existingUser.setStatus(id.isStatus());
        existingUser.setPayments(id.getPayments());
        existingUser.setName(id.getName());
        existingUser.setCreateBy(id.getCreateBy());
        existingUser.setCreateDate(id.getCreateDate());
        existingUser.setModifiedBy(id.getModifiedBy());
        existingUser.setModifiedDate(id.getModifiedDate());
        return rs.save(existingUser);

    }
}
