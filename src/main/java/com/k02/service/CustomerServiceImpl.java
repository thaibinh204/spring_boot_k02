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
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

	

}
