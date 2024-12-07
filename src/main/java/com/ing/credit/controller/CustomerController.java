package com.ing.credit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class CustomerController {

    @GetMapping("/c1")
    public String c1() {
        return Instant.now().toString();
    }
}
