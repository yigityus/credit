package com.ing.credit.service;

import com.ing.credit.service.dto.LoanInstallmentDto;

import java.util.List;

public interface LoanInstallmentService {
    LoanInstallmentDto save(LoanInstallmentDto loanDto);
    List<LoanInstallmentDto> findByLoanId(Long id);
}
