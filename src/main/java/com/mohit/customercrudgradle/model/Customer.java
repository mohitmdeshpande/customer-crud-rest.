package com.mohit.customercrudgradle.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {
	
	@Id
	String id; //primary key auto generated
	
	@NotNull(message = "Customer name is a mandatory field")
	@Size(min=2, max=30, message = "Name must be between 2(two) to 30(thirty) characters")
	String custName;
	@NotNull(message = "Customer address is a mandatory field")
	@Size(min=5,max=100,message = "Address must be between 5(five) to 100(hundred) characters")
	String custAddress;
	
	@NotNull(message = "Customer email is a mandatory field")
	@Email(message="Entered email address is invalid")
	String custEEmail;
	
	@NotNull(message = "Customer mobile number is a mandatory field")
	@Pattern(regexp = "^(\\+\\d{2}[- ]?)?\\d{10}$", message="Please enter 10 digit mobile number only or append with +91")
	//@Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$")
	String custMobile;
	
	public Customer() {
		
	}

	public Customer(String custName, String custAddress, String custEEmail, String custMobile) {
		
		this.custName = custName;
		this.custAddress = custAddress;
		this.custEEmail = custEEmail;
		this.custMobile = custMobile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustEEmail() {
		return custEEmail;
	}

	public void setCustEEmail(String custEEmail) {
		this.custEEmail = custEEmail;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	

}
