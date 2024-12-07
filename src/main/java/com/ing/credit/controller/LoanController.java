package com.ing.credit.controller;

import com.ing.credit.service.dto.LoanDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @PostMapping("/loan")
    public ResponseEntity<LoanDto> create(@RequestBody @Validated LoanDto loanDto) {
        return ResponseEntity.ok(loanDto);
    }
}
