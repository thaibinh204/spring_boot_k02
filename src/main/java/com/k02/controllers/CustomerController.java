package com.k02.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.k02.dto.CustomerDeptDto;
import com.k02.entity.Customer;
import com.k02.entity.Department;
import com.k02.entity.Lophoc;
import com.k02.entity.SinhVien;
import com.k02.form.SearchForm;
import com.k02.service.CustomerService;
import com.k02.service.DepartmentService;
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
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = { "/customerList" }, method = RequestMethod.GET)
	public String customerList(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		SearchForm searchForm = new SearchForm();
		model.addAttribute("searchForm", searchForm);
		return "customerList";

	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String searchCustomer(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
		List<Customer> customers = customerService.search(searchForm.getCustomerName());
		model.addAttribute("customers", customers);

		model.addAttribute("searchForm", searchForm);
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
		model.addAttribute("sinhviens", sinhVien);
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

	@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.GET)
	public String addCustomer(Model model) {
		Customer addCustomer = new Customer();
		model.addAttribute("addCustomer", addCustomer);
		return "addCustomer";
	}

	@RequestMapping(value = { "/addCustomer" }, method = RequestMethod.POST)
	public String saveAddCustomer(Model model, @ModelAttribute("addCustomer") Customer addCustomer) {
		Customer customer = new Customer();
		customer.setCustomerName(addCustomer.getCustomerName());
		customer.setContactName(addCustomer.getContactName());
		customer.setAddress(addCustomer.getAddress());
		customer.setCity(addCustomer.getCity());
		customer.setCountry(addCustomer.getCountry());
		customer.setPostalCode(addCustomer.getPostalCode());
		// insert xuong database bang sql
		customerService.saveSql(customer.getCustomerName(), customer.getContactName(), customer.getAddress(),
				customer.getCity(), customer.getPostalCode(), customer.getCountry());

		// insert xuong database bang ham co san cua JPA
		// customerService.save(customer);
		return "redirect:/customerList";
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public String saveedit(Model model, @ModelAttribute("editCustomer") Customer editCustomer) {
		Customer customer = new Customer();
		customer.setId(editCustomer.getId());
		customer.setCustomerName(editCustomer.getCustomerName());
		customer.setContactName(editCustomer.getContactName());
		customer.setAddress(editCustomer.getAddress());
		customer.setCity(editCustomer.getCity());
		customer.setCountry(editCustomer.getCountry());
		customer.setPostalCode(editCustomer.getPostalCode());
		// update xuong database bang sql

		customerService.updateSql(customer.getCustomerName(), customer.getContactName(), customer.getAddress(),
				customer.getCity(), customer.getPostalCode(), customer.getCountry(), customer.getId());
		// update xuong database bang ham cua JPA co san
//		customerService.save(customer);
//		model.addAttribute("editCustomer", customer);
		// save xong di sang customerList xem xong co sua dc hay chua
		return "redirect:/customerList";
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String delete(Model model, @RequestParam(name = "id") long id) {
//		customerService.deleteById(id);
		customerService.deleteSql(id);
		return "redirect:/customerList";
	}

	@RequestMapping(value = { "/customerDeptList" }, method = RequestMethod.GET)
	public String deptList(Model model) {
		List<CustomerDeptDto> customers = new ArrayList<>();
		customers = customerService.getListCustomerDept();
		model.addAttribute("customers", customers);
		return "customerDeptList";
	}

	@RequestMapping(value = { "/addCustomerList" }, method = RequestMethod.GET)
	public String showCustomerDept(Model model) {
		
		List<Department> departments = departmentService.findAll();
		// mang 1 chieu co key kieu Long, value kieu String
		Map<Long, String> mapDept = new HashMap<>();
		for (Department department : departments) {
			// muon put gia tri nao thi get gia tri do ra
			mapDept.put(department.getId(), department.getName());
		}
// truyen danh sach department qua cho select trong vew
		model.addAttribute("mapDept", mapDept);
		// tao 1 form rong de truyen qua cho vew
		Customer addCustomer = new Customer();
		model.addAttribute("addCustomer", addCustomer);		
		return "addCustomerDept";

	}
	@RequestMapping(value= {"/saveCustomerDept"}, method = RequestMethod.POST)
	public String saveCustomerDept(Model model, @ModelAttribute("addCustomer") Customer addCustomer) {
		customerService.save(addCustomer);
		return "redirect:/customerDeptList";
	}
}
