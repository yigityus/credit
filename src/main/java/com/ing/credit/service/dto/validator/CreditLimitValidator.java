package com.ing.credit.service.dto.validator;

import com.ing.credit.model.Customer;
import com.ing.credit.repository.CustomerRepository;
import com.ing.credit.service.dto.LoanDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreditLimitValidator implements ConstraintValidator<CreditLimit, LoanDto> {

    private final CustomerRepository customerRepository;

    public CreditLimitValidator(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void initialize(CreditLimit constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LoanDto loanDto, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Customer> optionalCustomer = customerRepository.findById(loanDto.getCustomerId());

        if (optionalCustomer.isEmpty()) {
            throw new IllegalArgumentException("Customer is not found!");
        }

        Customer customer = optionalCustomer.get();
        if ( customer.getCreditLimit().doubleValue() - customer.getUsedCreditLimit().doubleValue() < loanDto.getLoanAmount().doubleValue() ) {
            return false;
        }

        return true;
    }
}
