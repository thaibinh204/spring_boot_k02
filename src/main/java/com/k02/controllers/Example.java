package com.k02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.k02.entity.Bangdiem;
import com.k02.entity.Monhoc;
import com.k02.entity.User;
import com.k02.service.BangdiemService;
import com.k02.service.MonhocService;
import com.k02.service.UserService;

@Controller
public class Example {
	@Autowired
	private UserService userSrv;
	
	@Autowired
	private MonhocService monhocSrv;
	
	@Autowired
	private BangdiemService bangdiemSrv;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		User user = new User();
		user.setUsername("thaibinh");
		user.setPassword("123456");
		userSrv.save(user);
		return "Hello Spring Boot";
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
	
	@RequestMapping("/bangdiem")
	@ResponseBody
	public String bangDiem() {
		Bangdiem bangdiem = new Bangdiem();
		System.out.println(bangdiemSrv.getOne(1l));  
		return "Danh sach bang diem";
	}
}
