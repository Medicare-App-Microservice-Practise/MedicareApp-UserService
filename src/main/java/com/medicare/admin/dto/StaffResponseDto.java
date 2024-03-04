package com.medicare.admin.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffResponseDto {

	private Integer staff_id;
	private String staff_name;
	private String staff_email;
	private String staff_password;
	private String staff_mobile;
	
}
