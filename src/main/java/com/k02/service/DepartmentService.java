package com.k02.service;

import java.util.List;

import com.k02.entity.Department;

public interface DepartmentService {
	void save(Department department);
	List<Department> findAll();
}
