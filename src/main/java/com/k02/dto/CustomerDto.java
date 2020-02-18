package com.k02.dto;

import javax.persistence.Entity;

import org.springframework.stereotype.Controller;

@Controller
public class CustomerDto {
	private String customerName;
	private String address;
	private String country;
	private String departmentName;
	private String sex;
	
	public CustomerDto() {
		
	}
	public CustomerDto(String customerName,String address,String country,String departmentName,String sex) {
		this.customerName=customerName;
		this.address=address;
		this.country=country;
		this.departmentName=departmentName;
		this.sex=sex;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
}
