package com.k02.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.k02.entity.Lophoc;
import com.k02.repository.LophocRepository;

@Service
public class LophocServiceImpl implements LophocService {
	@Autowired
	private LophocRepository lophocRepository;
	

	@Override
	public void save(Lophoc lophoc) {
		lophocRepository.save(lophoc);

	}

}
