package com.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.entity.Pincode;


@Repository
public interface PincodeRepositoery extends JpaRepository<Pincode, Integer> {

	

	boolean existsByPincode(Integer pincode);


	
	
}
