package com.k02.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.k02.entity.SinhVien;
import com.k02.repository.SinhVienRepository;

public class SinhVienServicelmpl implements SinhVienService{
	@Autowired
	private SinhVienRepository sinhVienRepository;

	@Override
	public void save(SinhVien SinhVien) {
	sinhVienRepository.save(SinhVien);
		
	}

}
