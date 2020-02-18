package com.k02.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.k02.entity.Bangdiem;



public interface BangdiemRepository extends JpaRepository<Bangdiem,Long> {
	
}
