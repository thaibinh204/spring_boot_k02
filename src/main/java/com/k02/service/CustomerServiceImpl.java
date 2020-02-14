package com.k02.service;
import java.math.BigInteger;
import java.util.ArrayList;
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
	public void delete(Long id) {
		customerRepository.deleteById(id);

	}

	@Override
	public List<Customer> search(String customerName) {
		if (customerName == null) {
			customerName = "";
		}

		List<Customer> resultSearch = new ArrayList<>();
		resultSearch = (List<Customer>) customerRepository.search(customerName);
		return resultSearch;


	}

	@Override
	public List<Customer> searchByCustomerNameAndCountry(String customerName, String country) {
		// TODO 自動生成されたメソッド・スタブ
		if (customerName == null) {
			customerName = "";
		}
		if (country == null) {
			country = "";
		}
		return customerRepository.findByCustomerNameAndCountry(customerName, country);
	}



}
