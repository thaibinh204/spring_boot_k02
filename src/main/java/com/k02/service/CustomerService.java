package com.k02.service;

import java.util.List;

import com.k02.entity.Customer;

public interface CustomerService {
	void save(Customer customer);

	void deleteById(Long id);

	List<Customer> findAll();

	// tim theo ten id
	Customer findById(Long id);

	// c2
	Customer findCustomerByIdQuery(Long id);

	void deleteSql(Long id);

	void saveSql(String customerName, String contactName, String address, String city, String postalcode,
			String country);

	void updateSql(String customerName, String contactName, String address, String city, String postalcode,
			String country, Long id);
	
	List<Customer> search(String customerName); 
}
