package com.k02.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k02.entity.Monhoc;
import com.k02.repository.MonhocRepository;
import com.k02.repository.RoleRepository;

@Service
public class MonhocServiceImpl implements MonhocService {
	@Autowired
	private MonhocRepository monhocRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	 @Override
    public void save(Monhoc mh) {
		
		 monhocRepository.save(mh);
    } 

   
	

}
