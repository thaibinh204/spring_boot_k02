package com.k02.form;

import javax.persistence.Column;

public class SearchForm {
	
	@Column(name ="customer_name")
	private String customerName;

	public SearchForm() {
		
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
