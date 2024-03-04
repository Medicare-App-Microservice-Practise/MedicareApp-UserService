package com.medicare.admin.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustRequestDto {

	@NotBlank(message="Name cannot be blank")
	@NotNull(message="Name cannot be null")
	private String cust_name;

	@NotBlank(message="Email cannot be blank")
	@NotNull(message="Email cannot be null")
	@Email(message="Email not valid")
	private String cust_email;

	@NotBlank(message="Mobile cannot be blank")
	@NotNull(message="Mobile cannot be null")
	private String cust_mobile;

	@NotBlank(message="Address cannot be blank")
	@NotNull(message="Address cannot be null")
	private String cust_address;

	@NotBlank(message="State cannot be blank")
	@NotNull(message="State cannot be null")
	private String cust_state;

	@NotBlank(message="City cannot be blank")
	@NotNull(message="City cannot be null")
	private String cust_city;
	
	@NotBlank(message="PostalCode cannot be blank")
	@NotNull(message="PostalCode cannot be null")
	private String cust_postcode;

	@NotBlank(message="Company Name cannot be blank")
	@NotNull(message="Company Name cannot be null")
	private String cust_companyname;
	
}
