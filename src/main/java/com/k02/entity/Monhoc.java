package com.k02.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="mon_hoc")
public class Monhoc {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ma_mon_hoc")
	String maMonHoc;
	
	@Column(name="ten_mon_hoc")
	String tenMonHoc;
	
	
	@ManyToMany
    private Set<Role> roles;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMamonhoc() {
		return maMonHoc;
	}


	public void setMamonhoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}


	public String getTenmonhoc() {
		return tenMonHoc;
	}


	public void setTenmonhoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
