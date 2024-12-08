package com.ing.credit.service;

import com.ing.credit.service.dto.CustomerDto;
import com.ing.credit.service.dto.LoanDto;

import java.util.List;

public interface CustomerService {
    CustomerDto save(CustomerDto customerDto);
    List<CustomerDto> findAll();
    CustomerDto findById(Long customerId);
    void adjustCreditBalance(Long customerId, Double amount);
}
