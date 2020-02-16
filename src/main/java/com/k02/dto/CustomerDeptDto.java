package com.k02.dto;

public class CustomerDeptDto {

	private String customerName;

	private String address;

	private String country;

	private String deptName;

	private String sex;

	public CustomerDeptDto() {

	}

	public CustomerDeptDto(String customerName, String address, String country, String deptName, String sex) {
		this.customerName = customerName;
		this.address = address;
		this.country = country;
		this.deptName = deptName;
		this.sex = sex;
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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
