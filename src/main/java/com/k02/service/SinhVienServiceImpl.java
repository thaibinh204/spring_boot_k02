package com.k02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k02.entity.SinhVien;
import com.k02.repository.SinhVienRepository;

@Service
public class SinhVienServiceImpl implements SinhVienService{
	
	@Autowired 
	private SinhVienRepository sinhVienRepository;

	@Override
	public void save(SinhVien sinhvien) {
		sinhVienRepository.save(sinhvien);
	}

	@Override
	public List<SinhVien> findAll() {
		
		return sinhVienRepository.findAll();
	}

	@Override
	public SinhVien findById(Long id) {

		return sinhVienRepository.getOne(id);
	}

}
