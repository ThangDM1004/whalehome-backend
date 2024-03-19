package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.VNPayService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/vnpay")
public class VNPayController {
    @Autowired
    public VNPayService service;

    @PostMapping("/payment-callback")
    public ModelAndView paymentCallback(@RequestParam Map<String, String> queryParams){
        return new ModelAndView(service.paymentCallback(queryParams)) ;
    }
    @GetMapping("/payment")
    public ResponseEntity<ResponseObject> payment(@PathParam("price") long price, @PathParam("paymentId") Long paymentId, @RequestParam("bankCode") String bankCode) throws UnsupportedEncodingException {
        return service.payment(price,paymentId,bankCode);
    }
}
