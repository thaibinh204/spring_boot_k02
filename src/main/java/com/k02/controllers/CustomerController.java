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
import com.k02.entity.Lophoc;
import com.k02.entity.SinhVien;
import com.k02.service.CustomerService;
import com.k02.service.LophocService;
import com.k02.service.SinhVienService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SinhVienService sinhVienService;
	@Autowired
	private LophocService lophocService;

	 @RequestMapping(value = { "/customerList" }, method = RequestMethod.GET)
	 public String customerList(Model model){
		    List<Customer> customers = customerService.findAll();
			model.addAttribute("customers", customers);
			return "customerList";

		}
	 @RequestMapping(value = { "/LopHocList" }, method = RequestMethod.GET)
	 public String lopHocList(Model model) {
		 List<Lophoc> lophoc = lophocService.findAll();
		 model.addAttribute("lophocs", lophoc);
		 return "lopHocList";
	 }
	 @RequestMapping(value = { "/SinhVienList" }, method = RequestMethod.GET)
	 public String sinhVienList(Model model) {
		 List<SinhVien> sinhVien = sinhVienService.findAll();
		 model.addAttribute("sinhviens", sinhVien );
		 return "SinhVienList"; 
		 
	 }
		@RequestMapping(value = { "/detail" }, method = RequestMethod.GET)
		public String detail(Model model, @RequestParam(name = "id") long id) {
			Customer customer = new Customer();
//			customer = customerService.findCustomerByIdQuery(id);
		customer = customerService.findById(id);
			model.addAttribute("customer", customer);
			return "detail";
		}
		@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
		public String edit(Model model, @RequestParam(name = "id") long id) {
			Customer editCustomer = new Customer();
			editCustomer = customerService.findById(id);
			model.addAttribute("editCustomer", editCustomer);
			return "edit";
		}
		@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
		public String saveedit(Model model, 
				@ModelAttribute ("editCustomer") Customer cutomer) {
		
			return "edit";
		}
		@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
		public String delete(Model model) {
			return "delete";
		}
}
