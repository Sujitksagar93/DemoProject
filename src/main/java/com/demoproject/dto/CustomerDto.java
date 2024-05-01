package com.demoproject.dto;

//import jakarta.validation.constraints.Pattern;

public class CustomerDto {

	//@NotEmpty
	//@Pattern(regexp = "^[A-Za-z]\\\\w{5, 29}$", message = "First letter must be capital.")
	private String firstName;
	
	//@NotEmpty
	private String lastName;
	
	//@Email
	//@NotEmpty
	private String emailId;
	
	//@DecimalMin(value = "1000000000")
   // @DecimalMax(value = "9999999999")
	private Long mobileNumber;
	
	private String address;
	private String city;
	private String state;
	private Integer pincode;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	
	
}
