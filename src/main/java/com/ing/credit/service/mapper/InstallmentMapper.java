package com.ing.credit.service.mapper;

import com.ing.credit.model.Installment;
import com.ing.credit.service.dto.InstallmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { LoanMapper.class })
public interface InstallmentMapper {
    Installment toEntity(InstallmentDto dto);
    @Mapping(source = "loan.id", target = "loanId")
    InstallmentDto toDto(Installment entity);
    List<InstallmentDto> toDto(List<Installment> loanInstallments);
}
