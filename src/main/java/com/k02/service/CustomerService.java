package com.k02.service;

import java.util.List;

import com.k02.entity.Customer;



public interface CustomerService {
	void save (Customer customer);
	 List<Customer> findAll();

}
