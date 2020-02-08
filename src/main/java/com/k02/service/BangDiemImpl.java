package com.k02.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.k02.entity.BangDiem;
import com.k02.repository.BangDiemRepository;

public class BangDiemImpl implements BangDiemService {
	@Autowired
	private BangDiemRepository bangdiemRepository;
	
	@Override
	public void save(BangDiem bangdiem) {
		bangdiemRepository.save(bangdiem);
		
	}

	@Override
	public BangDiem indById(Long id) {		
		return bangdiemRepository.getOne(id);
	}

}
