package com.k02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.k02.entity.Department;
import com.k02.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;	
	
//	@Override
//	public List<Department> departmentList() {
//		return departmentRepository.departmentList();
//	}
}