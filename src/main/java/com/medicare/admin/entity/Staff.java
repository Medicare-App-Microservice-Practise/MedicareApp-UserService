package com.medicare.admin.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Integer staff_id;
	
	@Column(nullable=false)
	private String staff_name;
	
	@Column(nullable=false)
	private String staff_email;
	
	@Column(nullable=false)
	private String staff_password;
	
	@Column(nullable=false)
	private String staff_mobile;
	
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
