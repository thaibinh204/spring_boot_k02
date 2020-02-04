package com.k02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.k02.entity.User;
import com.k02.service.UserService;

@Controller
public class Example {
	@Autowired
	private UserService userSrv;
	
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
	public String monhoc() {
		return "Them mon hoc thanh cong";
	}
}
