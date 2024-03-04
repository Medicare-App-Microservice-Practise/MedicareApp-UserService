package com.medicare.admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.admin.dto.StaffRequestDto;
import com.medicare.admin.dto.StaffResponseDto;
import com.medicare.admin.exception.customException.CustomErrorException;
import com.medicare.admin.response.UserResponse;
import com.medicare.admin.service.StaffService;



@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {
	
	@Autowired
	StaffService service;
	
	@Autowired
	UserResponse response;

	@PostMapping("")
	public ResponseEntity<Object> addStaff(@RequestBody @Valid StaffRequestDto staffRequestDto) throws CustomErrorException
	{
		service.addStaff(staffRequestDto);
		return response.responseWithoutData("success", HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getStaffById(@PathVariable int id) throws CustomErrorException
	{
		StaffResponseDto staffResponseDto = service.getStaffById(id);
		return response.responseWithData("success", staffResponseDto, HttpStatus.OK);
	}
	
}
