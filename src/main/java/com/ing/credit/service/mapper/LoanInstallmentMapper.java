package com.ing.credit.service.mapper;

import com.ing.credit.model.LoanInstallment;
import com.ing.credit.service.dto.LoanInstallmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { LoanMapper.class })
public interface LoanInstallmentMapper {
    LoanInstallment toEntity(LoanInstallmentDto dto);
    LoanInstallmentDto toDto(LoanInstallment entity);
}
