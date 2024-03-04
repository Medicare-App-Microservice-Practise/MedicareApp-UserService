package com.medicare.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponseDto {

	private Integer admin_id;
	
	private String admin_name;
	
	private String admin_email;
	
	private String admin_password;
	
	private String admin_mobile;
	
}
