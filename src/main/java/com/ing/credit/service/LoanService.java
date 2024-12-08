package com.ing.credit.service;

import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.dto.InstallmentDto;

import java.util.List;

public interface LoanService {
    LoanDto save(LoanDto loanDto);
    List<InstallmentDto> create(LoanDto loanDto);
}
