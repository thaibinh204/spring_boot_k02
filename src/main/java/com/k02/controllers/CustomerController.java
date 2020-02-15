package com.k02.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.k02.entity.Customer;
import com.k02.form.CustomerForm;
import com.k02.service.CustomerService;



@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	 @RequestMapping(value = { "/customerList" }, method = RequestMethod.GET)
	 public String customerList(Model model){
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
		@RequestMapping(value = { "/editCustomer" }, method = RequestMethod.GET)
		public String edit(Model model, @RequestParam(name = "id") long id) {
			Customer customer = new Customer();
			customer = customerService.findCustomerByIdQuery(id);
		model.addAttribute("customer",customer);
		
			return "editCustomer";
		}
		@RequestMapping(value = {"/saveCustomer"}, method = RequestMethod.POST)
		public String save(Model model,
				@ModelAttribute("customer") Customer customer) {
			
			customerService.save(customer);
			return "redirect:/customerList";
		}
		
		@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.GET)
		public String addCustomers(Model model) {
			Customer customer = new Customer();
			model.addAttribute("customer", customer);
		
		
			return "addCustomer";
		}
		
		
		@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
		public String delete(Model model,@RequestParam(name = "id") long id) {
			Customer customer = new Customer();
			customerService.deleteById(id);
			return "redirect:/customerList";
		}
		
}
