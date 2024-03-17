package com.medicare.admin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.admin.dto.AdminResponseDto;
import com.medicare.admin.dto.LoginDto;
import com.medicare.admin.dto.StaffResponseDto;
import com.medicare.admin.entity.Admin;
import com.medicare.admin.entity.Staff;
import com.medicare.admin.exception.customException.NotFoundException;
import com.medicare.admin.mapper.AdminMapper;
import com.medicare.admin.mapper.StaffMapper;
import com.medicare.admin.repository.AdminRepository;
import com.medicare.admin.repository.StaffRepository;

@Service
public class AuthService {

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	StaffRepository staffRepo;
	
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	StaffMapper staffMapper;
	
	public AdminResponseDto authLoginAdmin(LoginDto loginDto) throws NotFoundException
	{
	
		Optional<Admin> adminOptional = adminRepo.findByEmailandPassword(loginDto.getEmail(), loginDto.getPassword());
		
		if(adminOptional.isPresent())
		{
			Admin admin = adminOptional.get();
            AdminResponseDto adminResponseDto = adminMapper.adminToAdminResponsDto(admin);
            return adminResponseDto;
		}
		else
		{
			throw new NotFoundException("Unable to login as Admin");
		}

	}
	
	public StaffResponseDto authLoginStaff(LoginDto loginDto) throws NotFoundException
	{
		Optional<Staff> staffOptional = staffRepo.findStaffByEmailandPassword(loginDto.getEmail(), loginDto.getPassword());
		
		if(staffOptional.isPresent())
		{
			Staff staff = staffOptional.get();
			StaffResponseDto staffResponseDto = staffMapper.staffToStaffResponseDto(staff);
			return staffResponseDto;
		}
		else
		{
			throw new NotFoundException("Unable to login as Staff");
		}
	}
	
}
