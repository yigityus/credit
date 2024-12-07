package com.ing.credit.service.impl;

import com.ing.credit.model.LoanInstallment;
import com.ing.credit.repository.LoanInstallmentRepository;
import com.ing.credit.service.LoanInstallmentService;
import com.ing.credit.service.dto.LoanInstallmentDto;
import com.ing.credit.service.mapper.LoanInstallmentMapper;
import org.springframework.stereotype.Service;

@Service
public class LoanInstallmentServiceImpl implements LoanInstallmentService {

    private final LoanInstallmentRepository loanInstallmentRepository;
    private final LoanInstallmentMapper loanInstallmentMapper;

    public LoanInstallmentServiceImpl(LoanInstallmentRepository loanInstallmentRepository,
                                      LoanInstallmentMapper loanInstallmentMapper) {
        this.loanInstallmentRepository = loanInstallmentRepository;
        this.loanInstallmentMapper = loanInstallmentMapper;
    }

    @Override
    public LoanInstallmentDto save(LoanInstallmentDto loanDto) {
        LoanInstallment loan = loanInstallmentRepository.save(loanInstallmentMapper.toEntity(loanDto));
        return loanInstallmentMapper.toDto(loan);
    }
}
