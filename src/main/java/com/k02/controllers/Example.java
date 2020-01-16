package com.k02.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring Boot";
	}
}
