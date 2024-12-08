package com.ing.credit.service.dto;

import java.util.List;

public class PaymentDto {
    private Long loanId;
    private Double amount;
    private double remainingAmount;
    private List<InstallmentDto> paidInstallment;

    public List<InstallmentDto> getPaidInstallment() {
        return paidInstallment;
    }

    public void setPaidInstallment(List<InstallmentDto> paidInstallment) {
        this.paidInstallment = paidInstallment;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
