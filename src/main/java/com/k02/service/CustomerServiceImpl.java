package com.k02.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k02.dto.CustomerDto;
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
	public void deleteCustomerByIdQuery(Long id) {
		customerRepository.deleteById(id);
	}
	
	@Override
	public boolean checkExistCustomerByIdQuery(Long id) {
		return customerRepository.existsById(id);
	}

	@Override
	public int updateCustomer(String customerName, String contactName,String address, String city, String postalcode, String country,Long id) {
		int result=customerRepository.updateCustomer(customerName,contactName,address, city,postalcode,country,id);
		return result;
	}
	
	@Override
	public List<Customer> searchCustomer(String txtSearch) {
		return customerRepository.searchCustomer(txtSearch);
	}
	
	@Override
	public List<CustomerDto> ListCustomerDepartment() {
		return customerRepository.ListCustomerDepartment();
	}

}
