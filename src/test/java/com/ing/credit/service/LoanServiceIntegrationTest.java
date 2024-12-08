package com.ing.credit.service;

import com.ing.credit.config.Samples;
import com.ing.credit.model.Loan;
import com.ing.credit.repository.CustomerRepository;
import com.ing.credit.repository.LoanRepository;
import com.ing.credit.service.dto.CustomerDto;
import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.impl.CustomerServiceImpl;
import com.ing.credit.service.impl.LoanServiceImpl;
import com.ing.credit.service.mapper.LoanMapper;
import org.junit.jupiter.api.BeforeEach;
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
    private CustomerRepository customerRepository;

    @BeforeEach
    public void init() {
        loanRepository.deleteAll();
        customerRepository.deleteAll();
    }

    @Test
    void save_ShouldSaveLoanAndReturnDto() {
        // Act: Call the save method
        CustomerDto customer = customerService.save(Samples.customer());
        LoanDto loan = Samples.loan();
        loan.setCustomer(customer);
        LoanDto savedLoanDto = loanService.save(loan);
        // Assert: Validate the saved data
        assertNotNull(savedLoanDto);
        assertNotNull(savedLoanDto.getId()); // ID should be auto-generated
        assertEquals(1000.00, savedLoanDto.getLoanAmount());

        // Verify that the data is in the database
        Loan savedEntity = loanRepository.findById(savedLoanDto.getId()).orElse(null);
        assertNotNull(savedEntity);
        assertEquals(1000.00, savedEntity.getLoanAmount());
    }

}
