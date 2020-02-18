package com.k02.form;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Controller;

@Controller
public class Search {
	private String txtSearch;

	public String getTxtSearch() {
		return txtSearch;
	}

	public void setTxtSearch(String txtSearch) {
		this.txtSearch = txtSearch;
	}
	
}
