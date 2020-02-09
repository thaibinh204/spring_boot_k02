package com.k02.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.k02.entity.Customer;
import com.k02.service.CustomerService;


@Controller
public class DefaultController {
	// bien toan cuc
	@Autowired
	private static List<Customer> customers;
	@Autowired
	private static  CustomerService customerService;

    @GetMapping("/")
    public String home1() {
    	String test = "";
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("username: " + auth.getName());
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
    
    @RequestMapping(value = { "/customerList" }, method = RequestMethod.GET) 
	public String customerList(Model model){
    	//customers = customerService.findAll();
		//model.addAttribute("customers", customers);
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

	@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.GET)
	public String addCustomer(Model model) {
		
		return "AddCustomer";
	}
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

}
