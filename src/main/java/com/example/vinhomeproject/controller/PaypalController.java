package com.example.vinhomeproject.controller;

import com.example.vinhomeproject.models.Contract;
import com.example.vinhomeproject.response.ResponseObject;
import com.example.vinhomeproject.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/paypal")
public class PaypalController {

    @Autowired
    private PaypalService paypalService;

    @PostMapping("/pay")
    public ResponseEntity<ResponseObject> createPayment(
            @RequestParam("amount") String amount,
            @RequestParam("paymentId") Long paymentId
    ) {
        try {
            String cancelUrl = "https://whalehome.up.railway.app/api/v1/paypal/cancel";
            String successUrl = "https://whalehome.up.railway.app/api/v1/paypal/success/" + paymentId;
            Payment payment = paypalService.createPayment(
                    Double.valueOf(amount),
                    "USD",
                    "paypal",
                    "sale",
                    cancelUrl,
                    successUrl,
                    paymentId
            );

            for (Links links: payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                            "Create payment successfully",
                            links.getHref()
                    ));
                }
            }
        } catch (PayPalRESTException e) {

        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "",
               ""
        ));
    }

    @GetMapping("/success/{id}")
    public ResponseEntity<ResponseObject> paymentSuccess(
            @PathVariable("id") Long id,
            @RequestParam("paymentId") String paymentId,
            @RequestParam("PayerID") String payerId
    ) {
      return paypalService.paymentSuccessfully(id,paymentId,payerId);
    }
    @GetMapping("/cancel")
    public ResponseEntity<ResponseObject> paymentCancel() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(
                "Payment cancel",
                ""
        ));
    }

}
