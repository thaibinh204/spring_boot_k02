package com.k02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.k02.entity.Customer;
import com.k02.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private static List<Customer> customers;
	@Autowired
	private static  CustomerService customerService;

	 @RequestMapping(value = { "/customerList" }, method = RequestMethod.GET)
	 public String customerList(Model model){
//	    	customers = customerService.findAll();
//			model.addAttribute("customers", customers);
			return "customerList";

		}

		@RequestMapping(value = { "/detail" }, method = RequestMethod.GET)
		public String detail(Model model, @RequestParam(name = "id") long id) {
			Customer customer = customerService.findCustomerByIdQuery(id);
			String name = customer.getCustomerName();
			model.addAttribute("customer", customer);
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
