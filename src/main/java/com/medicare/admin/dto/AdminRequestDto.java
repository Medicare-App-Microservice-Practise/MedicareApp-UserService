package com.medicare.admin.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequestDto {

	@NotBlank(message="Name cannot be blank")
	@NotNull(message="Name cannot be null")
	private String admin_name;
	
	@NotBlank(message="Email cannot be blank")
	@NotNull(message="Email cannot be null")
	@Email(message="Email not valid")
	private String admin_email;
	
	@NotBlank(message="Password cannot be blank")
	@NotNull(message="Password cannot be null")
	private String admin_password;
	
	@NotBlank(message="Mobile cannot be blank")
	@NotNull(message="Mobile cannot be null")
	private String admin_mobile;
	
}
