package com.ing.credit.service;

import com.ing.credit.config.Samples;
import com.ing.credit.repository.LoanRepository;
import com.ing.credit.service.dto.InstallmentDto;
import com.ing.credit.service.dto.LoanDto;
import com.ing.credit.service.impl.LoanServiceImpl;
import com.ing.credit.service.mapper.LoanMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CreateLoanTest {

    @InjectMocks
    private LoanServiceImpl loanService;

    @Mock
    private CustomerService customerService;

    @Mock
    private LoanMapper loanMapper;

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private InstallmentService installmentService;

    @Mock
    private LoanDto loanDto;  // Assuming this is the class containing the create method

    @Test
    public void testCreateLoan() throws Exception {
        // Prepare mock data
        LoanDto expectedLoanDto = Samples.loan();
        List<InstallmentDto> expectedInstallments = new ArrayList<>();
        for (int i = 0; i < expectedLoanDto.getNumberOfInstallment().getValue(); i++) {
            expectedInstallments.add(createMockInstallment(expectedLoanDto.getId(), i));
        }

        Mockito.when(loanService.save(expectedLoanDto)).thenReturn(expectedLoanDto);
        Mockito.when(installmentService.findByLoanId(expectedLoanDto.getId())).thenReturn(expectedInstallments);

        // Call the method under test
        List<InstallmentDto> actualInstallments = loanService.create(expectedLoanDto);

        assertEquals(expectedInstallments, actualInstallments);
    }

    private InstallmentDto createMockInstallment(Long loanId, int index) {
        LocalDate dueDate = LocalDate.now().withMonth(index + 1).withDayOfMonth(1);
        return new InstallmentDto.LoanInstallmentDtoBuilder()
                .loanId(loanId)
                .amount( 1000.0 )
                .dueDate(dueDate)
                .build();
    }
}
