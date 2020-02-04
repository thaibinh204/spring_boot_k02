package com.k02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.k02.entity.Monhoc;

@Repository
public interface MonhocRepository extends JpaRepository<Monhoc, Long> {
	Monhoc findByMaMonHoc(String mamonhoc);
}
