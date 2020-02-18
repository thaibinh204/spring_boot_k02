package com.k02.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.k02.dto.CustomerDto;

@Service
public interface CustomerdeptService{

	List<CustomerDto> ListCustomerDepartment();
}
