package com.ing.credit.repository;

import com.ing.credit.model.Loan;
import com.ing.credit.model.LoanInstallment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanInstallmentRepository extends JpaRepository<LoanInstallment, Long> {
}
