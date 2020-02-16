package com.k02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.k02.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
