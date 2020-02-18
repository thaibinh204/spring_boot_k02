package com.k02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.k02.dto.CustomerDto;
import com.k02.entity.Customer;
import com.k02.form.Search;
import com.k02.service.CustomerService;
import com.k02.service.CustomerdeptService;
import com.k02.service.DepartmentService;

@Controller
public class CustomerController {
	
	
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value = { "/customerList" }, method = RequestMethod.GET)
	public String customerList(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "customerList";

	}

	@RequestMapping(value = { "/detail" }, method = RequestMethod.GET)
	public String detail(Model model, @RequestParam(name = "id") long id) {
		Customer customer = new Customer();
		customer = customerService.findCustomerByIdQuery(id);
//			customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		return "detail";
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
	public String edit(Model model,@RequestParam(name="id") long id) {
		Customer customer = new Customer();
		customer = customerService.findCustomerByIdQuery(id);
		model.addAttribute("customer", customer);
		return "edit";
	}
	
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public String editCustomer(Model model,@ModelAttribute Customer customers) {
		
		Customer customer = new Customer();
		customer.setCustomerName(customers.getCustomerName());
		customer.setContactName(customers.getContactName());
		customer.setAddress(customers.getAddress());
		customer.setCity(customers.getCity());
		customer.setPostalCode(customers.getPostalCode());
		customer.setCountry(customers.getCountry());
		customer.setId(customers.getId());
		
		//use query
		int updatedId = customerService.updateCustomer(customers.getCustomerName(),customers.getContactName(),customers.getAddress(),customers.getCity(),customers.getPostalCode(),customers.getCountry(),customers.getId());
		
		//use jpa function
		//customerService.save(customer);
		
		return "redirect:/customerList";
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String delete(Model model,@RequestParam(name="id") long id) {
		if(customerService.checkExistCustomerByIdQuery(id)==true) {
			customerService.deleteCustomerByIdQuery(id);
			System.out.println("delete success");
			List<Customer> customers = customerService.findAll();
			model.addAttribute("customers", customers);			
			return "customerList";
		}else {
			return "dont delete";
		}
	}
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addCustomer(Model model) {
		return "add";
	}
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public String addCustomer(Model model,@ModelAttribute Customer customers) {
		
		Customer customer = new Customer();
		customer.setCustomerName(customers.getCustomerName());
		customer.setContactName(customers.getContactName());
		customer.setAddress(customers.getAddress());
		customer.setCity(customers.getCity());
		customer.setPostalCode(customers.getPostalCode());
		customer.setCountry(customers.getCountry());
		customerService.save(customer);
		return "redirect:/customerList";
	}
	
	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String seach(Model model,@ModelAttribute Search search) {
		List<Customer> customers =customerService.searchCustomer(search.getTxtSearch());
		model.addAttribute("customers", customers);
		return "customerList";
	}
	
	@RequestMapping(value = { "/departmentList" }, method = RequestMethod.GET)
	public String departmentList(Model model) {
		List<CustomerDto> departments = customerService.ListCustomerDepartment();
//		model.addAttribute("departments", departments);
		return "departmentList";

	}
	
}
