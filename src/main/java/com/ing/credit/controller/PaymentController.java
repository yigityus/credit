package com.ing.credit.controller;

import com.ing.credit.service.PaymentService;
import com.ing.credit.service.dto.PaymentDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public PaymentDto create(@RequestBody PaymentDto paymentDto) {
        return paymentService.pay(paymentDto);
    }
}
