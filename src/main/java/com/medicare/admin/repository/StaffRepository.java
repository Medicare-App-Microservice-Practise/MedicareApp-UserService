package com.medicare.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medicare.admin.entity.Staff;



@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

	@Query("SELECT a FROM Staff a where a.staff_email = :email AND a.staff_password = :password")
	Optional<Staff> findStaffByEmailandPassword(@Param("email") String email, @Param("password") String password);
	
}
