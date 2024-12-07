package com.ing.credit.service;

import com.ing.credit.service.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto save(CustomerDto customerDto);
    List<CustomerDto> findAll();
}
