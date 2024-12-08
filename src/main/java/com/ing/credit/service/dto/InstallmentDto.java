package com.ing.credit.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InstallmentDto {
    private Long id;
    private Long loanId;
    @JsonIgnore
    private LoanDto loan;
    private Double amount;
    private Double paidAmount;
    private LocalDate dueDate;
    private LocalDateTime paymentDate;
    private boolean paid;

    public InstallmentDto() {
    }

    private InstallmentDto(LoanInstallmentDtoBuilder builder) {
        this.loanId = builder.loanId;
        this.amount = builder.amount;
        this.dueDate = builder.dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoanDto getLoan() {
        return loan;
    }

    public void setLoan(LoanDto loan) {
        this.loan = loan;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean getPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public static class LoanInstallmentDtoBuilder {
        private Double amount;
        private LocalDate dueDate;
        private Long loanId;

        public LoanInstallmentDtoBuilder amount(Double amount) {
            this.amount = amount;
            return this;
        }
        public LoanInstallmentDtoBuilder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }
        public LoanInstallmentDtoBuilder loanId(Long loanId) {
            this.loanId = loanId;
            return this;
        }

        public InstallmentDto build(){
            return new InstallmentDto(this);
        }
    }
}
