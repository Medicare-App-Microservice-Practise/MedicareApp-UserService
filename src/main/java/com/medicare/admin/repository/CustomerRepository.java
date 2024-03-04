package com.medicare.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.admin.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
