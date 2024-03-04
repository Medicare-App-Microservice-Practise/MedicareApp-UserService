package com.medicare.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.admin.dto.CustRequestDto;
import com.medicare.admin.dto.CustResponseDto;
import com.medicare.admin.entity.Customer;
import com.medicare.admin.exception.customException.CustomErrorException;
import com.medicare.admin.exception.customException.NotFoundException;
import com.medicare.admin.exception.customException.NotSaveException;
import com.medicare.admin.mapper.CustomerMapper;
import com.medicare.admin.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repo;
	
	@Autowired
	CustomerMapper mapper;
	
	public void addCustomer(CustRequestDto custRequestDto) throws CustomErrorException
	{
		try {
			Customer customer = mapper.customerRequestDtoToCustomer(custRequestDto);
			
			if(	repo.save(customer) == null)
			{
				throw new NotSaveException("Unable to save new customer");
			}
		}catch(NotSaveException ex) {
			 throw new CustomErrorException(ex.getMessage());
		}
		
	}
	
	public CustResponseDto updateCustomer(int id, CustRequestDto custRequestDto) throws NotFoundException, CustomErrorException {
		
		try {
			Customer customer = repo.findById(id).orElseThrow(()-> new NotFoundException("Customer with ID "+id+" Not Found"));
			
			if(custRequestDto.getCust_name() != null)
			{
				customer.setCust_name(custRequestDto.getCust_name());
			}
			if(custRequestDto.getCust_mobile() != null)
			{
				customer.setCust_mobile(custRequestDto.getCust_mobile());
			}
			if(custRequestDto.getCust_email() != null)
			{
				customer.setCust_email(custRequestDto.getCust_email());
			}
			if(custRequestDto.getCust_companyname() != null)
			{
				customer.setCust_companyname(custRequestDto.getCust_companyname());
			}
			if(custRequestDto.getCust_address() != null)
			{
				customer.setCust_address(custRequestDto.getCust_address());
			}
			if(custRequestDto.getCust_state() != null)
			{
				customer.setCust_state(custRequestDto.getCust_state());
			}
			if(custRequestDto.getCust_city() != null)
			{
				customer.setCust_city(custRequestDto.getCust_city());
			}
			if(custRequestDto.getCust_postcode() != null)
			{
				customer.setCust_postcode(custRequestDto.getCust_postcode());
			}
			
			Customer updatedCustomer = repo.save(customer);
			
			if(updatedCustomer == null)
			{
				throw new NotSaveException("Customer not able to update");
			}
			
			CustResponseDto custResponseDto = mapper.customerToCustomerResponseDto(updatedCustomer);
			
			return custResponseDto;
		}catch(NotSaveException ex)
		{
			throw new CustomErrorException(ex.getMessage());
		}
		
	}
	
	public CustResponseDto getCustomerById(int id) throws NotFoundException
	{
		
		Customer customer = repo.findById(id).orElseThrow(()-> new NotFoundException("Customer with ID "+id+" Not Found"));
		
		CustResponseDto custResponseDto = mapper.customerToCustomerResponseDto(customer);
		
		return custResponseDto;
		
	}
	
	public List<CustResponseDto> getAllCustomer(){
		
		List<Customer> customer = repo.findAll();
		
		List<CustResponseDto> custResponseDto = mapper.listCustToCustomerResponseDto(customer);
		
		return custResponseDto;
		
	}
	
	public void deleteCustomer(int id)
	{
		repo.deleteById(id);
	}
}
