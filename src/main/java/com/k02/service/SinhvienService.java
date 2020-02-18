package com.k02.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.k02.entity.Bangdiem;
import com.k02.entity.Sinhvien;

public interface SinhvienService {
	Sinhvien findBySinhvien(Long id);
}	
