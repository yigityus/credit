package com.ing.credit.service.impl;

import com.ing.credit.model.Installment;
import com.ing.credit.repository.InstallmentRepository;
import com.ing.credit.service.InstallmentService;
import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.dto.InstallmentDto;
import com.ing.credit.service.mapper.InstallmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class InstallmentServiceImpl implements InstallmentService {

    private final InstallmentRepository installmentRepository;
    private final InstallmentMapper installmentMapper;

    public InstallmentServiceImpl(InstallmentRepository installmentRepository,
                                  InstallmentMapper installmentMapper) {
        this.installmentRepository = installmentRepository;
        this.installmentMapper = installmentMapper;
    }

    @Override
    public InstallmentDto save(InstallmentDto installmentDto) {

        if (Objects.isNull(installmentDto.getLoan())) {
            LoanDto loanDto = new LoanDto();
            loanDto.setId(installmentDto.getLoanId());
            installmentDto.setLoan(loanDto);
        }

        Installment loan = installmentRepository
                .save(installmentMapper.toEntity(installmentDto));
        return installmentMapper.toDto(loan);
    }

    @Override
    public List<InstallmentDto> findByLoanId(Long id) {
        List<Installment> installments = installmentRepository.findByLoanId(id);
        return installmentMapper.toDto(installments);
    }
}
