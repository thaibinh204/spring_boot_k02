package com.k02.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hocjava.k02.thymeleaf.form.PersonForm;
import hocjava.k02.thymeleaf.model.Person;

@Controller
public class CustomerController {
	
@RequestMapping(value = {"/addCustomer"}, method = RequestMethod.GET)
public String showAddCustomerForm(model model) {
	
	CustomerForm customerForm = new CustomerForm();
	model.addAttribute("AddCustomerForm", customerForm);
	return "AddCustomer";
	
}
@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.POST)
public String saveCustomer(Model model, //
		@ModelAttribute("AddCustomerForm") CustomerForm customerForm) {

	String fistrName = customerForm.getFirstName();
	String lastName = customerForm.getLastName();

	if (firstName != null && firstName.length() > 0 //
			&& lastName != null && lastName.length() > 0) {
		Person newPerson = new Person(firstName, lastName);
		persons.add(newPerson);

		return "redirect:/CustomerList";
	}

	return "AddCustomer";
}
}
