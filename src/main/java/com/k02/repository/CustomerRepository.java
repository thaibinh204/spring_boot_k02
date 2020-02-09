package com.k02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.k02.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query("SELECT c FROM Customer c WHERE customer_id = :id")
	 Customer findCustomerByIdQuery(@Param("id") Long id);
}
