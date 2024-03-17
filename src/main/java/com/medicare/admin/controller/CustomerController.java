package com.medicare.admin.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.admin.dto.CustRequestDto;
import com.medicare.admin.dto.CustResponseDto;
import com.medicare.admin.exception.customException.CustomErrorException;
import com.medicare.admin.exception.customException.NotFoundException;
import com.medicare.admin.response.UserResponse;
import com.medicare.admin.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	UserResponse response;
	
	private static final Logger logger = Logger.getLogger(CustomerController.class.getName());

	@PostMapping("")
	public ResponseEntity<Object> addCustomer (@RequestBody @Valid CustRequestDto custRequestDto) throws CustomErrorException
	{
		service.addCustomer(custRequestDto);
		return response.responseWithoutData("success", HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable int id, @Valid @RequestBody CustRequestDto custRequestDto) throws NotFoundException, CustomErrorException
	{
		logger.info("value is "+id);
		logger.info(custRequestDto.toString());
		service.updateCustomer(id, custRequestDto);
		return response.responseWithoutData("success", HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable int id) throws NotFoundException
	{
		CustResponseDto custResponseDto = service.getCustomerById(id);
		return response.responseWithData("success", custResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<Object> getCustomers()
	{
		List<CustResponseDto> custResponseDto = service.getAllCustomer();
		return response.responseWithData("success", custResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable int id)
	{
		service.deleteCustomer(id);
		return response.responseWithoutData("success", HttpStatus.OK);
	}
	
}
