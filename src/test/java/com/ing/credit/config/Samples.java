package com.ing.credit.config;


import com.ing.credit.model.InstallmentCount;
import com.ing.credit.service.dto.CustomerDto;
import com.ing.credit.service.dto.LoanDto;

import java.time.LocalDate;

public class Samples {

    public static CustomerDto customer() {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Jane");
        customerDto.setSurname("Claim");
        customerDto.setUsedCreditLimit(1000.99);
        customerDto.setCreditLimit(1000000.99);

        return customerDto;
    }

    public static LoanDto loan() {
        LoanDto loan = new LoanDto();
        loan.setLoanAmount(1000.00);
        loan.setCreatedDate(LocalDate.now());
        loan.setInterestRate(1.2);
        loan.setNumberOfInstallment(InstallmentCount.NINE);
        return loan;
    }
}
