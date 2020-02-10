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

		@RequestMapping(value = {"/addCustomer"}, method = RequestMethod.GET)
		public String addCustomer(Model model) {
			CustomerForm customerForm = new CustomerForm();
			model.addAttribute("customerForm", customerForm);
			return "addCustomer";
		}

		@RequestMapping(value = {"/saveCustomer"}, method = RequestMethod.POST)
		public String saveCustomer(Model model, @ModelAttribute("customerForm") CustomerForm customerForm) {
			Customer customer = new Customer();
			customer.setId(customerForm.getId());
			customer.setCustomerName(customerForm.getCustomerName());
			customer.setContactName(customerForm.getContactName());
			customer.setAddress(customerForm.getAddress());
			customer.setCity(customerForm.getCity());
			customer.setPostalCode(customerForm.getPostalCode());
			customer.setCountry(customerForm.getCountry());
			customerService.save(customer);
			return "redirect:/customerList";
		}

		@RequestMapping(value = { "/editCustomer" }, method = RequestMethod.GET)
		public String edit(Model model, @RequestParam(name = "id") long id) {
			Customer customer = customerService.findById(id);
		    CustomerForm customerForm = new CustomerForm();
		    customerForm.setId(id);
		    customerForm.setCustomerName(customer.getCustomerName());
		    customerForm.setContactName(customer.getContactName());
		    customerForm.setAddress(customer.getAddress());
		    customerForm.setCity(customer.getCity());
		    customerForm.setPostalCode(customer.getPostalCode());
		    customerForm.setCountry(customer.getCountry());
		    model.addAttribute("customerForm", customerForm);
			return "editCustomer";
		}

		@RequestMapping(value = { "/deleteCustomer" }, method = RequestMethod.GET)
		public String delete(Model model) {

			return "redirect:/customerList";
		}
}
