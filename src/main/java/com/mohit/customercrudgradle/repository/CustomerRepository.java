package com.mohit.customercrudgradle.repository;

import org.springframework.data.repository.CrudRepository;

import com.mohit.customercrudgradle.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	@Override
    Customer findOne(String id);

    @Override
    void delete(Customer deleted);
}
