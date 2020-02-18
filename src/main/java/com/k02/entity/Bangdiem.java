package com.k02.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="bangdiem")

public class Bangdiem {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="diem")
	private Long diem;
	@Column(name="sinhvien_id")
	private Long sinhvienid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Monhoc monhoc;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(insertable = false, updatable = false)
	private Sinhvien sinhvien;
	

	public Sinhvien getSinhvien() {
		return sinhvien;
	}

	public void setSinhvien(Sinhvien sinhvien) {
		this.sinhvien = sinhvien;
	}

//	public Monhoc getMonhoc() {
//		return monhoc;
//	}
//
//	public void setMonhoc(Monhoc monhoc) {
//		this.monhoc = monhoc;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDiem() {
		return diem;
	}

	public void setDiem(Long diem) {
		this.diem = diem;
	}

	public Long getSinhvienid() {
		return sinhvienid;
	}

	public void setSinhvienid(Long sinhvienid) {
		this.sinhvienid = sinhvienid;
	}
	
	
	
}
