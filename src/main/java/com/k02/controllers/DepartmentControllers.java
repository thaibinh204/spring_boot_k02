package com.k02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.k02.service.DepartmentService;

@Controller
public class DepartmentControllers {
	
	@Autowired
	private DepartmentService departmentService;

	
	@RequestMapping(value = { "/departmentlist" }, method = RequestMethod.GET)
	public String departmentList(Model model) {
		
		return "";
		
	}
}
