package com.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	boolean existsByEmailId(String emailId);

	

	
	
	
	
}
