package com.medicare.admin.mapper;

import org.mapstruct.Mapper;

import com.medicare.admin.dto.StaffRequestDto;
import com.medicare.admin.dto.StaffResponseDto;
import com.medicare.admin.entity.Staff;



@Mapper(componentModel="spring")
public interface StaffMapper {

	public com.medicare.admin.entity.Staff staffRequestDtoToStaff (StaffRequestDto staffRequestDto);
	
	public StaffResponseDto staffToStaffResponseDto (Staff staff);
}
