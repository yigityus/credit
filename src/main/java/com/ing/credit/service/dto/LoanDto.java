package com.ing.credit.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.ing.credit.model.Installment;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.time.Instant;

public class LoanDto {
    private Long id;
    private Long customerId;
    private CustomerDto customer;
    private Double loanAmount;
    @DecimalMin("0.1")
    @DecimalMax("0.5")
    private Double interestRate;
    private Installment numberOfInstallment;
    private Instant createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Installment getNumberOfInstallment() {
        return numberOfInstallment;
    }

    public void setNumberOfInstallment(Installment numberOfInstallment) {
        this.numberOfInstallment = numberOfInstallment;
    }
}
