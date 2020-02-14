package com.k02.service;

import java.util.List;

import com.k02.entity.Customer;

public interface CustomerService {
	void save (Customer customer);
	 List<Customer> findAll();
	 Customer findById(Long id);
	 Customer findCustomerByIdQuery(Long id);
	 void delete (Long id);
	 List<Customer> search(String customerName);
	 List<Customer> searchByCustomerNameAndCountry(String customerName, String country);
}
