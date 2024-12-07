package com.ing.credit.service.impl;

import com.ing.credit.model.Customer;
import com.ing.credit.repository.CustomerRepository;
import com.ing.credit.service.CustomerService;
import com.ing.credit.service.dto.CustomerDto;
import com.ing.credit.service.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = customerRepository.save(customerMapper.toEntity(customerDto));
        return customerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerMapper.toDto(customerRepository.findAll());
    }
}
