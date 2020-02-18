package com.k02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k02.entity.Sinhvien;
import com.k02.repository.SinhvienRepository;

@Service
public class SinhvienServiceImpl implements SinhvienService {
	@Autowired
	private SinhvienRepository sinhvienRespository;
	
	@Override
	public Sinhvien findBySinhvien(Long id) {
		return sinhvienRespository.getOne(id);
	}
	
}
