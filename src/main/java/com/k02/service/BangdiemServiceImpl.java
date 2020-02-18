package com.k02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k02.entity.Bangdiem;
import com.k02.repository.BangdiemRepository;

@Service
public class BangdiemServiceImpl implements BangdiemService {
	@Autowired
	private BangdiemRepository bangdiemResposity;
	
	@Override
	public Bangdiem findByMonhoc(Long id) {
		return bangdiemResposity.getOne(id);
	}
	
	@Override
	public Bangdiem findByBangdiem(Long id) {
		return bangdiemResposity.getOne(id);
	}
}
