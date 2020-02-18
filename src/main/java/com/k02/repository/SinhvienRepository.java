package com.k02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.k02.entity.Sinhvien;

public interface SinhvienRepository extends JpaRepository<Sinhvien,Long> {
	
}
