package com.medicare.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medicare.admin.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

	@Query("SELECT a FROM Admin a where a.admin_email = :email and a.admin_password = :password")
	Optional<Admin> findByEmailandPassword(@Param("email") String email, @Param("password") String password);
	
}
