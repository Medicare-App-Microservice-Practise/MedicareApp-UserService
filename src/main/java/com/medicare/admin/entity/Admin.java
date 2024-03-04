package com.medicare.admin.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Integer admin_id;
	
	@Column(nullable=false)
	private String admin_name;
	
	@Column(nullable=false)
	private String admin_email;
	
	@Column(nullable=false)
	private String admin_password;
	
	@Column(nullable=false)
	private String admin_mobile;
	
	@Column(nullable=false)
	private Timestamp created_timestamp;
	
	@Column(nullable=false)
	private Timestamp update_timestamp;
	
	@PrePersist
	protected void onCreate() {
		created_timestamp = new Timestamp(System.currentTimeMillis());
		update_timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	@PreUpdate
	protected void onUpdate() {
		created_timestamp = new Timestamp(System.currentTimeMillis());
	}
	
}
