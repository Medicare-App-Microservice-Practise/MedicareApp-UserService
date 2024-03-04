package com.medicare.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.medicare.admin.dto.CustRequestDto;
import com.medicare.admin.dto.CustResponseDto;
import com.medicare.admin.entity.Customer;



@Mapper(componentModel="spring")
public interface CustomerMapper {

	public Customer customerRequestDtoToCustomer (CustRequestDto custRequestDto);
	
	public CustResponseDto customerToCustomerResponseDto (Customer customer);
	
	public List<CustResponseDto> listCustToCustomerResponseDto (List<Customer> customer);
	
}
