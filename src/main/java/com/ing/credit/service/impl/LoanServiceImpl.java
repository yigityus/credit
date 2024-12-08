package com.ing.credit.service.impl;

import com.ing.credit.model.Loan;
import com.ing.credit.repository.LoanRepository;
import com.ing.credit.service.CustomerService;
import com.ing.credit.service.LoanInstallmentService;
import com.ing.credit.service.LoanService;
import com.ing.credit.service.dto.CustomerDto;
import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.dto.LoanInstallmentDto;
import com.ing.credit.service.mapper.LoanMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanInstallmentService loanInstallmentService;
    private final CustomerService customerService;
    private final LoanMapper loanMapper;

    public LoanServiceImpl(LoanRepository loanRepository,
                           LoanInstallmentService loanInstallmentService,
                           CustomerService customerService,
                           LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanInstallmentService = loanInstallmentService;
        this.customerService = customerService;
        this.loanMapper = loanMapper;
    }

    @Override
    public LoanDto save(LoanDto loanDto) {

        if (Objects.isNull(loanDto.getCustomer())) {
            CustomerDto customer = new CustomerDto();
            customer.setId(loanDto.getCustomerId());
            loanDto.setCustomer(customer);
        }

        Loan loan = loanRepository.save(loanMapper.toEntity(loanDto));
        return loanMapper.toDto(loan);
    }

    @Override
    public List<LoanInstallmentDto> create(final LoanDto loanDto) {
        LoanDto dto = save(loanDto);

        Double totalAmount = dto.getLoanAmount() * (1 + dto.getInterestRate());
        int installmentCount = dto.getNumberOfInstallment().getValue();
        double installment = totalAmount / installmentCount;

        LocalDate now = LocalDate.now();
        LocalDate next = now.with(TemporalAdjusters.firstDayOfNextMonth());

        for (int i = 0; i < installmentCount; i++) {
            LoanInstallmentDto loanInstallmentDto = new LoanInstallmentDto.LoanInstallmentDtoBuilder()
                    .loanId(dto.getId())
                    .amount(installment)
                    .dueDate(next).build();

            next = next.with(TemporalAdjusters.firstDayOfNextMonth());

            loanInstallmentService.save(loanInstallmentDto);
        }

        List<LoanInstallmentDto> installments = loanInstallmentService.findByLoanId(dto.getId());

        return installments;
    }
}
