package com.k02.service;

import java.util.List;

import com.k02.entity.Lophoc;


public interface LophocService {
	 void save(Lophoc lophoc );
	 List<Lophoc> findAll();
	 Lophoc findById(Long id);
	   
}
