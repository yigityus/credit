package com.ing.credit.controller;

import com.ing.credit.service.LoanService;
import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.dto.InstallmentDto;
import com.ing.credit.service.dto.validator.CreditLimit;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loan")
    public List<InstallmentDto> create(@RequestBody @Validated @CreditLimit LoanDto loanDto) {
        return loanService.create(loanDto);
    }
}
