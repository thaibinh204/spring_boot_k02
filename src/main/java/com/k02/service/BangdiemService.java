package com.k02.service;

import com.k02.entity.Bangdiem;

public interface BangdiemService {
	Bangdiem findByMonhoc(Long id);
	Bangdiem findByBangdiem(Long id);
}
