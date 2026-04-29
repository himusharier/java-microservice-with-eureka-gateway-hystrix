package com.himusharier.payment_service.controller;

import com.himusharier.payment_service.entity.Payment;
import com.himusharier.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @PostMapping("/do-payment")
    public Payment doPayment(@RequestBody Payment payment) {
        return service.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable Integer orderId) {
        return service.findPaymentHistoryByOrderId(orderId);
    }
}
