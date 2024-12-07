package com.ing.credit.service.impl;

import com.ing.credit.model.Loan;
import com.ing.credit.repository.LoanRepository;
import com.ing.credit.service.LoanService;
import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.mapper.LoanMapper;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    public LoanServiceImpl(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    @Override
    public LoanDto save(LoanDto loanDto) {
        Loan loan = loanRepository.save(loanMapper.toEntity(loanDto));
        return loanMapper.toDto(loan);
    }
}
