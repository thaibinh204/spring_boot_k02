package com.k02.repository;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.k02.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query("SELECT c FROM Customer c WHERE customer_id = :id")
	 Customer findCustomerByIdQuery(@Param("id") Long id);

	@Query("SELECT c FROM Customer c WHERE c.customerName LIKE %:customerName%")
	List<Customer> search(@Param("customerName") String customerName );

	public List<Customer> findByCustomerNameAndCountry(String customerName, String country);
}
