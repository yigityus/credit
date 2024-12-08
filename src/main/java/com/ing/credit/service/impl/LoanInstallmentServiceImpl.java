package com.ing.credit.service.impl;

import com.ing.credit.model.LoanInstallment;
import com.ing.credit.repository.LoanInstallmentRepository;
import com.ing.credit.service.LoanInstallmentService;
import com.ing.credit.service.dto.CustomerDto;
import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.dto.LoanInstallmentDto;
import com.ing.credit.service.mapper.LoanInstallmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public LoanInstallmentDto save(LoanInstallmentDto loanInstallmentDto) {

        if (Objects.isNull(loanInstallmentDto.getLoan())) {
            LoanDto loanDto = new LoanDto();
            loanDto.setId(loanInstallmentDto.getLoanId());
            loanInstallmentDto.setLoan(loanDto);
        }

        LoanInstallment loan = loanInstallmentRepository
                .save(loanInstallmentMapper.toEntity(loanInstallmentDto));
        return loanInstallmentMapper.toDto(loan);
    }

    @Override
    public List<LoanInstallmentDto> findByLoanId(Long id) {
        List<LoanInstallment> loanInstallments = loanInstallmentRepository.findByLoanId(id);
        return loanInstallmentMapper.toDto(loanInstallments);
    }
}
