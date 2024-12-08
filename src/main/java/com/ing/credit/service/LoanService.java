package com.ing.credit.service;

import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.dto.LoanInstallmentDto;

import java.util.List;

public interface LoanService {
    LoanDto save(LoanDto loanDto);
    List<LoanInstallmentDto> create(LoanDto loanDto);
}
