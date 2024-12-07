package com.ing.credit.service;

import com.ing.credit.model.Customer;
import com.ing.credit.repository.CustomerRepository;
import com.ing.credit.service.dto.CustomerDto;
import com.ing.credit.service.impl.CustomerServiceImpl;
import com.ing.credit.service.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest // Load the Spring context
public class CustomerServiceIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void save_ShouldSaveCustomerAndReturnDto() {

        // Arrange: Create a CustomerDto
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("John Doe");
        customerDto.setSurname("Good Luck");

        // Act: Call the save method
        CustomerDto savedCustomerDto = customerService.save(customerDto);

        // Assert: Validate the saved data
        assertNotNull(savedCustomerDto);
        assertNotNull(savedCustomerDto.getId()); // ID should be auto-generated
        assertEquals("John Doe", savedCustomerDto.getName());

        // Verify that the data is in the database
        Customer savedEntity = customerRepository.findById(savedCustomerDto.getId()).orElse(null);
        assertNotNull(savedEntity);
        assertEquals("John Doe", savedEntity.getName());
    }
}
