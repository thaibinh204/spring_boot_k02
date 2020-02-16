package com.k02.service;

import java.util.List;

import com.k02.entity.SinhVien;

public interface SinhVienService {
	void save(SinhVien sinhvien);
	List<SinhVien> findAll();
	SinhVien findById(Long id);

}
