package com.ing.credit.service;

import com.ing.credit.model.LoanInstallment;
import com.ing.credit.service.dto.LoanDto;

import java.util.List;

public interface LoanService {
    LoanDto save(LoanDto loanDto);
    List<LoanInstallment> create(LoanDto loanDto);
}
