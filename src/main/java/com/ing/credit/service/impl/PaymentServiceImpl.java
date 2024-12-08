package com.ing.credit.service.impl;

import com.ing.credit.service.CustomerService;
import com.ing.credit.service.InstallmentService;
import com.ing.credit.service.PaymentService;
import com.ing.credit.service.dto.InstallmentDto;
import com.ing.credit.service.dto.PaymentDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final InstallmentService installmentService;
    private final CustomerService customerService;

    public PaymentServiceImpl(InstallmentService installmentService, CustomerService customerService) {
        this.installmentService = installmentService;
        this.customerService = customerService;
    }

    @Override
    public PaymentDto pay(PaymentDto paymentDto) {
        List<InstallmentDto> installments = installmentService.findByLoanId(paymentDto.getLoanId());
        double amount = paymentDto.getAmount().doubleValue();

        List<InstallmentDto> list = installments.stream()
                .filter(i -> i.getPaid() == false)
                .filter(i -> i.getDueDate().isBefore(LocalDate.now().plus(3, ChronoUnit.MONTHS)))
                .collect(Collectors.toList());

        Long customerId = list.stream().findFirst()
                .get().getLoan().getCustomerId();

        List<InstallmentDto> paidInstallments = new ArrayList<>();
        int min = Math.min(list.size(), 3);

        for (int i = 0; i < min; i++) {
            InstallmentDto installment = list.get(i);
            if (amount >= installment.getAmount()) {
                installment.setPaymentDate(LocalDateTime.now());
                installment.setPaidAmount(installment.getAmount());
                installment.setPaid(Boolean.TRUE);

                paidInstallments.add(installmentService.save(installment));
                amount = amount - installment.getAmount();
                customerService.adjustCreditBalance(customerId, installment.getAmount());
            }
        }

        paymentDto.setRemainingAmount(amount);
        paymentDto.setPaidInstallment(paidInstallments);

        return paymentDto;
    }
}
