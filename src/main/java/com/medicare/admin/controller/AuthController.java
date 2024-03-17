package com.medicare.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.admin.dto.AdminResponseDto;
import com.medicare.admin.dto.LoginDto;
import com.medicare.admin.dto.StaffResponseDto;
import com.medicare.admin.exception.customException.NotFoundException;
import com.medicare.admin.response.UserResponse;
import com.medicare.admin.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	UserResponse response;
	
	@Autowired
	AuthService authService;
	
	@PostMapping("")
	public ResponseEntity<Object> authLogin(@RequestBody LoginDto loginDto) throws NotFoundException
	{
		System.out.println(loginDto.getRole());
		if(loginDto.getRole().equals("admin"))
		{
			System.out.println("admin");
			AdminResponseDto adminResponseDto = authService.authLoginAdmin(loginDto);
			return response.responseWithData("success", adminResponseDto, HttpStatus.OK);
		}
		else
		{
			System.out.println("staff");
			StaffResponseDto staffResponseDto = authService.authLoginStaff(loginDto);
			return response.responseWithData("success", staffResponseDto, HttpStatus.OK);
		}
	}
	
}
