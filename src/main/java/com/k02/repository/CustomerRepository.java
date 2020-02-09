package com.k02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.k02.entity.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
