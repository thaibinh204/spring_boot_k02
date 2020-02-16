package com.k02.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k02.entity.Customer;
import com.k02.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> findAll() {		
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Long id) {		
		return customerRepository.getOne(id);
	}

	@Override
	public Customer findCustomerByIdQuery(Long id) {
		
		return customerRepository.findCustomerByIdQuery(id);
	}

	@Override
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
		
	}

	@Override
	public void deleteSql(Long id) {
		customerRepository.deleteSql(id);
		
	}

	@Override
	public void saveSql(String customerName, String contactName, String address, String city, String postalcode,
			String country) {
		customerRepository.saveSql(customerName, contactName, address, city, postalcode, country);
		
	}

	@Override
	public void updateSql(String customerName, String contactName, String address, String city, String postalcode,
			String country, Long id) {
		customerRepository.updateSql(customerName, contactName, address, city, postalcode, country, id);
		
	}

	@Override
	public List<Customer> search(String customerName) {
		
		return customerRepository.search(customerName);
	}

	

}
