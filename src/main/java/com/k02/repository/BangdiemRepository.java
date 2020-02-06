package com.k02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.k02.entity.Bangdiem;
import com.k02.entity.Monhoc;

@Repository
public interface BangdiemRepository extends JpaRepository<Bangdiem,Long> {
	Bangdiem findAllById(Long id);
}
