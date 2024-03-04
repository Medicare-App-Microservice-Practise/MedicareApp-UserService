package com.medicare.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.medicare.admin.dto.AdminRequestDto;
import com.medicare.admin.dto.AdminResponseDto;
import com.medicare.admin.entity.Admin;

@Mapper(componentModel="spring")
public interface AdminMapper {

	public Admin adminRequestDtotoAdmin (AdminRequestDto adminRequestDto);
	
	public AdminRequestDto adminToAdminRequestDto (Admin admin);
	
	public List<AdminRequestDto> listAdminToAdminRequestDto (List<Admin> admin);
	
	public AdminResponseDto adminToAdminResponsDto(Admin admin);
	
}
