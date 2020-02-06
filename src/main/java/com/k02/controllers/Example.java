package com.k02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.k02.entity.Lophoc;
import com.k02.entity.User;
import com.k02.service.LophocService;

import com.k02.entity.Monhoc;
import com.k02.entity.User;
import com.k02.service.MonhocService;

import com.k02.service.UserService;

@Controller
public class Example {
	@Autowired
	private UserService userSrv;
	@Autowired
	private LophocService lophocSrv;
	
	@Autowired
	private MonhocService monhocSrv;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		User user = new User();
		user.setUsername("thaibinh");
		user.setPassword("123456");
		userSrv.save(user);
		return "Hello Spring Boot";
	}

	@RequestMapping("/lophoc")
	@ResponseBody
	public String lophoc() {
		Lophoc lophoc = new Lophoc();
		lophoc.setMaLopHoc("m01");
		lophoc.setTenLopHoc("lop1");
		lophoc.setTongSoSinhVien(30);
		lophocSrv.save(lophoc);
		return  " nhap thong tin thanh cong";	
	}

	@RequestMapping("/monhoc")
	@ResponseBody
	public String monHoc() {
		Monhoc mh = new Monhoc();
		mh.setMamonhoc("005");
		mh.setTenmonhoc("Toan");
		monhocSrv.save(mh);
		return "Them bang mon hoc thanh cong";
	}

}
