package com.medicare.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.admin.dto.AdminRequestDto;
import com.medicare.admin.dto.AdminResponseDto;
import com.medicare.admin.entity.Admin;
import com.medicare.admin.exception.customException.NotFoundException;
import com.medicare.admin.mapper.AdminMapper;
import com.medicare.admin.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository repo;
	
	@Autowired
	AdminMapper mapper;
	
	public void addAdmin (AdminRequestDto adminRequestDto)
	{
		Admin admin = mapper.adminRequestDtotoAdmin(adminRequestDto);
		repo.save(admin);
	}
	
	public AdminResponseDto getAdminById (int id) throws NotFoundException
	{
		
		Admin admin = repo.findById(id).orElseThrow(()-> new NotFoundException("Admin with ID "+id+" Not Found"));
		AdminResponseDto adminResponseDto = mapper.adminToAdminResponsDto(admin);
		return adminResponseDto;
	}
}
