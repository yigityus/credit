package com.ing.credit.service;

import com.ing.credit.service.dto.InstallmentDto;

import java.util.List;

public interface InstallmentService {
    InstallmentDto save(InstallmentDto loanDto);
    List<InstallmentDto> findByLoanId(Long id);
}
