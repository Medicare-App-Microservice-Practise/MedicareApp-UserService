package com.medicare.admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.admin.dto.AdminRequestDto;
import com.medicare.admin.dto.AdminResponseDto;
import com.medicare.admin.exception.customException.NotFoundException;
import com.medicare.admin.response.AdminResponse;
import com.medicare.admin.service.AdminService;



@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@Autowired
	AdminResponse response;

	@PostMapping("")
	public ResponseEntity<Object> addAdmin (@RequestBody @Valid AdminRequestDto adminRequestdto)
	{
		service.addAdmin(adminRequestdto);
		return response.responseWithoutData("success", HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getAdminById(@PathVariable int id) throws NotFoundException
	{
		AdminResponseDto adminResponseDto = service.getAdminById(id);
		return response.responseWithData("success", adminResponseDto, null);
	}
	
}
