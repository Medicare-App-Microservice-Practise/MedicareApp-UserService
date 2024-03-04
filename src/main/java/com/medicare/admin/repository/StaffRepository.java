package com.medicare.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.admin.entity.Staff;



@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

}
