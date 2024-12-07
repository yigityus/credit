package com.ing.credit.service;

import com.ing.credit.model.Loan;
import com.ing.credit.repository.LoanRepository;
import com.ing.credit.service.dto.CustomerDto;
import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.impl.CustomerServiceImpl;
import com.ing.credit.service.impl.LoanServiceImpl;
import com.ing.credit.service.mapper.LoanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest // Load the Spring context
public class LoanServiceIntegrationTest {

    @Autowired
    private LoanServiceImpl loanService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanMapper loanMapper;

    @Test
    void save_ShouldSaveLoanAndReturnDto() {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("John Doe");

        // Act: Call the save method
        CustomerDto savedCustomerDto = customerService.save(customerDto);

        LoanDto loanDto = new LoanDto();
        loanDto.setCustomer(savedCustomerDto);

        loanDto.setLoanAmount(1000L);

        LoanDto savedLoanDto = loanService.save(loanDto);
        // Assert: Validate the saved data
        assertNotNull(savedLoanDto);
        assertNotNull(savedLoanDto.getId()); // ID should be auto-generated
        assertEquals(1000L, savedLoanDto.getLoanAmount());

        // Verify that the data is in the database
        Loan savedEntity = loanRepository.findById(savedLoanDto.getId()).orElse(null);
        assertNotNull(savedEntity);
        assertEquals(1000L, savedEntity.getLoanAmount());
    }

    @Test
    void save_ShouldSaveLoanAndReturnDtoWithMultipleLoan() {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("John Doe");

        // Act: Call the save method
        CustomerDto savedCustomerDto = customerService.save(customerDto);

        LoanDto loanDto = new LoanDto();
        loanDto.setCustomer(savedCustomerDto);

        loanDto.setLoanAmount(1000L);

        LoanDto savedLoanDto = loanService.save(loanDto);
        // Assert: Validate the saved data
        assertNotNull(savedLoanDto);
        assertNotNull(savedLoanDto.getId()); // ID should be auto-generated
        assertEquals(1000L, savedLoanDto.getLoanAmount());

        // Verify that the data is in the database
        Loan savedEntity = loanRepository.findById(savedLoanDto.getId()).orElse(null);
        assertNotNull(savedEntity);
        assertEquals(1000L, savedEntity.getLoanAmount());


        LoanDto loanDto2 = new LoanDto();
        loanDto2.setCustomer(savedCustomerDto);

        loanDto2.setLoanAmount(1000L);
        LoanDto savedLoanDto2 = loanService.save(loanDto2);

        List<Loan> all = loanRepository.findAll();
        assertEquals(2, all.size());

    }

}
