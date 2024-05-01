package com.demoproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.dto.CustomerDto;
import com.demoproject.entity.Customer;
import com.demoproject.response.ResponseHandler;
import com.demoproject.serviceImpl.CustomerServiceImpl;

//import jakarta.validation.Valid;



@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/list")
	public ResponseHandler getAllCustomerList()
	{
		ResponseHandler response = new ResponseHandler();
		
		List<Customer> customer= customerServiceImpl.getAllCustomerList();
		response.setStatus(true);
		response.setData(customer);
		response.setMessage("sucess");
//		try {
//			
//		} catch (CustomeExceptionMessage e) {
//			
//			erro.setStatus(false);
//			erro.setData(new ArrayList<>());
//			erro.setMsg(e.getMessage());
//		}
		return response;
	}
	
	@GetMapping("/{userId}")
	public ResponseHandler getCutomerById(@PathVariable Integer userId)
	{
		ResponseHandler response = new ResponseHandler();		 
	      
		 try {
			 Customer customer = customerServiceImpl.getCutomerById(userId);
			    response.setStatus(true);
				response.setData(customer);
				response.setMessage("sucess");
			 
		} catch (IllegalArgumentException e) {
			
			response.setStatus(false);
			response.setData(new ArrayList<>());
			response.setMessage(e.getMessage());
		}
		return response;
	    }
//	public ResponseEntity<Customer> getCutomerById(@PathVariable Integer userId)
//	{
//		 Customer customer = customerServiceImpl.getCutomerById(userId);
//	        if (customer != null) {
//	        	
//	            return ResponseEntity.ok(customer);
//	        } else {
//	        	
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	            
//	        }
//	    }


	
	@PostMapping("/add_customer")
	public ResponseHandler saveCustomer(@RequestBody  CustomerDto customerDto)
	{
		ResponseHandler response = new ResponseHandler();		 
		try {
			Customer customer = customerServiceImpl.createCustomer(customerDto);
//			return new ResponseEntity<>(customer,HttpStatus.CREATED);
			response.setStatus(true);
			response.setData(customer);
			response.setMessage("sucess");
			
		} catch (IllegalArgumentException e) {
			 //System.out.println("Email Id already exists");
			response.setStatus(false);
			response.setData(new ArrayList<>());
			response.setMessage(e.getMessage());
			System.out.println(e.getMessage());
			
		}
		return response;
		
//		return null;
		
	}
//	public String saveCustomer(@RequestBody CustomerDto customerDto)
//	{
//		try {
//			Customer customer = customerServiceImpl.createCustomer(customerDto);
//			return "email exists";
//			
//		} catch (Exception e) {
//			 System.out.println("Email Id already exists");
//		}
//		
//		return null;
//		
//	}
	
	
	@DeleteMapping("/delete/{userId}")
	public ResponseHandler deleteCustomerById(@PathVariable Integer userId)
	{
		ResponseHandler response = new ResponseHandler();		 
		try {
			customerServiceImpl.deleteCustomerById(userId);
			
			response.setStatus(true);
			response.setData(userId);
			response.setMessage("Id deleted Sucessfully");
			 
			
		} catch (IllegalArgumentException e) {
			response.setStatus(false);
			response.setData(new ArrayList<>());
			response.setMessage(e.getMessage());
		}
		 
		 return response;
		
		
	}
	
	@PutMapping("/updateDetails/{userId}")
	public ResponseHandler updateCustomerDetails(@PathVariable Integer userId, @RequestBody CustomerDto customerDto)
	{
			
		ResponseHandler response = new ResponseHandler();		 
			try {
				customerServiceImpl.updateCustomerDetails(customerDto, userId);
				response.setStatus(true);
				response.setData(userId);
				response.setMessage("Data update Sucessfully");
			} catch (IllegalArgumentException e) {
				response.setStatus(false);
				response.setData(new ArrayList<>());
				response.setMessage(e.getMessage());
			}
		return response;
	
	}
	
	
	
}
