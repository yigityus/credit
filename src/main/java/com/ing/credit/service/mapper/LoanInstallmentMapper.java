package com.ing.credit.service.mapper;

import com.ing.credit.model.LoanInstallment;
import com.ing.credit.service.dto.LoanInstallmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { LoanMapper.class })
public interface LoanInstallmentMapper {
    LoanInstallment toEntity(LoanInstallmentDto dto);
    @Mapping(source = "loan.id", target = "loanId")
    LoanInstallmentDto toDto(LoanInstallment entity);
    List<LoanInstallmentDto> toDto(List<LoanInstallment> loanInstallments);
}
