package com.demoproject.service;

import java.util.List;

import com.demoproject.dto.CustomerDto;
import com.demoproject.entity.Customer;



public interface CustomerService {
	
	public List<Customer> getAllCustomerList();
	
	public Customer createCustomer(CustomerDto customerDto);
	
	public Customer getCutomerById( Integer userId);
	
	public void deleteCustomerById(Integer userId);
	
	public Customer updateCustomerDetails(CustomerDto customerDto , Integer userId );

	List<Customer> getAllCustomerLists(Integer page, Integer size);
	
	
	
}
