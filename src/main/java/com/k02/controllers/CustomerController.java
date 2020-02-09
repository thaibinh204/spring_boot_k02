package com.k02.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CustomerController {
	
	@RequestMapping(value = { "/customerList" }, method = RequestMethod.GET) 
	public String customerList(Model model){
		
//		model.addAttribute("customer", customerList);
		
		return "customerList";
		
	}
	@RequestMapping(value = { "/detail" }, method = RequestMethod.GET)
	public String detail(Model model) {
		
		return "detail";
	}
	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
	public String edit(Model model) {
		
		return "edit";
	}
	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String delete(Model model) {
		
		return "delete";
	}
}
