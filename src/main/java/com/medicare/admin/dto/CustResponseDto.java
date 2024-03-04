package com.medicare.admin.dto;

import java.sql.Timestamp;

import javax.persistence.Column;

import com.medicare.admin.entity.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustResponseDto {

	private Integer cust_id;

	private String cust_name;

	private String cust_email;

	private String cust_mobile;

	private String cust_address;

	private String cust_state;

	private String cust_city;
	
	private String cust_postcode;

	private String cust_companyname;
	
}
