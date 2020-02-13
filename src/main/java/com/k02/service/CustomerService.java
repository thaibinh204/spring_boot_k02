package com.k02.service;

import java.util.List;

import com.k02.entity.Customer;



public interface CustomerService {
	void save (Customer customer);
	 List<Customer> findAll();
	//tim theo ten id
	 Customer findById(Long id);
	 // c2
	 Customer findCustomerByIdQuery(Long id);

}
