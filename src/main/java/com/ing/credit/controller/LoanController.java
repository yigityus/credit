package com.ing.credit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class LoanController {

    @GetMapping("/hello")
    public String hello() {
        return Instant.now().toString();
    }
}
