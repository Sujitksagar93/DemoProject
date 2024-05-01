package com.demoproject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.dto.CustomerDto;
import com.demoproject.entity.Customer;
import com.demoproject.repository.CustomerRepository;
import com.demoproject.repository.PincodeRepositoery;
import com.demoproject.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PincodeRepositoery pincodeRepositoery;

	@Override

	public List<Customer> getAllCustomerList() {

		return customerRepository.findAll();

	}

	@Override
	public Customer createCustomer(CustomerDto customerDto) {

		Customer customer = new Customer();
		boolean emailIdExist = customerRepository.existsByEmailId(customerDto.getEmailId());

		String regularExpression = "^[A-Z][a-zA-Z]*$";

		String name = customerDto.getFirstName();
		// name not empty and not greater than 10char validation
		if (name.matches(regularExpression))// && (name.isEmpty() || (name.length()>0 && name.length()>=15))
		{
			customer.setFirstName(customerDto.getFirstName());

		} else {
			throw new IllegalArgumentException("Check first letter is capital and name not null");
		}

		// mobile number validation
		Long moblieNo = customerDto.getMobileNumber();
		String no = Long.toString(moblieNo);

		if ((no.length() == 10)) {
			customer.setMobileNumber(customerDto.getMobileNumber());
		} else {
			throw new IllegalArgumentException("Enter 10 digit mobile number only");

		}

		// email id validation
		if (!emailIdExist) {
			customer.setEmailId(customerDto.getEmailId());

		} else {
			// throw new IllegalArgumentException("Email id already exist");
			throw new IllegalArgumentException("email id already exists");
		}

		boolean pin = pincodeRepositoery.existsByPincode(customerDto.getPincode());

		System.out.println(pin);

		if (pin) {

			customer.setPincode(customerDto.getPincode());
		} else {
			throw new IllegalArgumentException("pincode is not exists");
		}

		customer.setLastName(customerDto.getLastName());
		customer.setAddress(customerDto.getAddress());
		customer.setState(customerDto.getState());
		customer.setCity(customerDto.getCity());

		return customerRepository.save(customer);
	}

	@Override
	public Customer getCutomerById(Integer userId) {

		Customer id = customerRepository.findById(userId).orElse(null);

		if (id != null) {
			return id;
		} else {
			throw new IllegalArgumentException("id not found ");
		}
	}

	@Override
	public void deleteCustomerById(Integer userId) {

		boolean idExist = customerRepository.existsById(userId);

		if (!idExist) {
			System.out.println(idExist);
			throw new IllegalArgumentException("id does not exist");
		} else {
			System.out.println(idExist);
			customerRepository.deleteById(userId);
			
		}

	}

	@Override
	public Customer updateCustomerDetails(CustomerDto customerDto, Integer userId) {

		Customer updateDetails = customerRepository.findById(userId).orElse(null);

		if (updateDetails != null) {
			updateDetails.setFirstName(customerDto.getFirstName());
			updateDetails.setLastName(customerDto.getLastName());
			updateDetails.setEmailId(customerDto.getEmailId());
			updateDetails.setAddress(customerDto.getAddress());
			updateDetails.setCity(customerDto.getCity());
			updateDetails.setMobileNumber(customerDto.getMobileNumber());
			updateDetails.setPincode(customerDto.getPincode());
			updateDetails.setState(customerDto.getState());

			return customerRepository.save(updateDetails);
		}else {
			throw new IllegalArgumentException("to update data is not available");
		}

		
	}

}
