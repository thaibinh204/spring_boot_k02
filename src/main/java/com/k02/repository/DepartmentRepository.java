package com.k02.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.k02.entity.Customer;
import com.k02.service.DepartmentService;

@Repository
public interface DepartmentRepository extends JpaRepository<Customer, Long> {
	

	
}
