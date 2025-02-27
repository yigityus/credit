package com.ing.credit.service.mapper;

import com.ing.credit.model.Customer;
import com.ing.credit.service.dto.CustomerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerDto dto);
    CustomerDto toDto(Customer entity);
    List<CustomerDto> toDto(List<Customer> all);
}
