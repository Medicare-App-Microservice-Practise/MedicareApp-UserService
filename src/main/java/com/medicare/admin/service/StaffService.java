package com.medicare.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.admin.dto.StaffRequestDto;
import com.medicare.admin.dto.StaffResponseDto;
import com.medicare.admin.entity.Staff;
import com.medicare.admin.exception.customException.CustomErrorException;
import com.medicare.admin.mapper.StaffMapper;
import com.medicare.admin.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	StaffRepository repo;
	
	@Autowired
	StaffMapper mapper;
	
	public void addStaff(StaffRequestDto staffRequestDto) throws CustomErrorException
	{
		try {
			Staff staff = mapper.staffRequestDtoToStaff(staffRequestDto);
			repo.save(staff);
		} catch (IllegalArgumentException ex) {
		    throw new CustomErrorException("Not able to save for staff", ex);
		}
		
	}
	
	public StaffResponseDto getStaffById (int id) throws CustomErrorException
	{
		Staff staff = repo.findById(id).orElseThrow(()-> new CustomErrorException("Staff with ID "+id+" Not Found"));
		StaffResponseDto staffResponseDto = mapper.staffToStaffResponseDto(staff);
		return staffResponseDto;
	}
}
