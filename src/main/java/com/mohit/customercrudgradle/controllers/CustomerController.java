package com.mohit.customercrudgradle.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.customercrudgradle.model.Customer;
import com.mohit.customercrudgradle.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/customers")
    public Iterable<Customer> customer() {
        return customerRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/customers")
    public String save(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
    	
    	 if (bindingResult.hasErrors()) {
             return "Error adding new customer";
         }
    	
    	customerRepository.save(customer);

        return customer.getId();
 
    }

    @RequestMapping(method=RequestMethod.GET, value="/customers/{id}")
    public Customer show(@PathVariable String id) {
        return customerRepository.findOne(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/customers/{id}")
    public Customer update(@PathVariable String id,@Valid @RequestBody Customer customer) {
        Customer cust = customerRepository.findOne(id);
        if(customer.getCustName() != null)
        	cust.setCustName(customer.getCustName());
        if(customer.getCustAddress() != null)
        	cust.setCustAddress(customer.getCustAddress());
        if(customer.getCustEEmail() != null)
        	cust.setCustEEmail(customer.getCustEEmail());
        if(customer.getCustEEmail() != null)
        	cust.setCustEEmail(customer.getCustEEmail());
        customerRepository.save(cust);
        return cust;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/customers/{id}")
    public String delete(@PathVariable String id) {
    	Customer customer = customerRepository.findOne(id);
        customerRepository.delete(customer);

        return "customer deleted successfully!!";
    }
}
