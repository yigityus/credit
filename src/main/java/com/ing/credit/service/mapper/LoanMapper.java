package com.ing.credit.service.mapper;

import com.ing.credit.model.Loan;
import com.ing.credit.service.dto.LoanDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { CustomerMapper.class })
public interface LoanMapper {
    Loan toEntity(LoanDto dto);
    LoanDto toDto(Loan entity);
}
