package com.k02.service;

import java.util.List;

import com.k02.dto.CustomerDto;
import com.k02.entity.Customer;



public interface CustomerService {
	void save (Customer customer);
	 List<Customer> findAll();
	 Customer findById(Long id);
	 Customer findCustomerByIdQuery(Long id);
	 void deleteCustomerByIdQuery(Long id);
	 boolean checkExistCustomerByIdQuery(Long id);
	 int updateCustomer(String customername, String contactname,String address, String city, String postalcode, String country,Long id);
	 List<Customer> searchCustomer(String txtSearch);
	List<CustomerDto> ListCustomerDepartment();
}
