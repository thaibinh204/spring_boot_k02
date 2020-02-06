package com.k02.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lophoc")
public class Lophoc {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ma_lop_hoc")
	private String maLopHoc;

	@Column(name = "ten_lop_hoc")
	private String tenLopHoc;

	@Column(name = "tong_so_sinh_vien")
	private Integer tongSoSinhVien;

	@OneToMany(mappedBy = "lopHoc", cascade = CascadeType.ALL)
	private Set<SinhVien> dsSV = new HashSet<SinhVien>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaLopHoc() {
		return maLopHoc;
	}

	public void setMaLopHoc(String maLopHoc) {
		this.maLopHoc = maLopHoc;
	}

	public String getTenLopHoc() {
		return tenLopHoc;
	}

	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
	}

	public Integer getTongSoSinhVien() {
		return tongSoSinhVien;
	}

	public void setTongSoSinhVien(Integer tongSoSinhVien) {
		this.tongSoSinhVien = tongSoSinhVien;
	}

	public Set<SinhVien> getDsSV() {
		return dsSV;
	}

	public void setDsSV(Set<SinhVien> dsSV) {
		this.dsSV = dsSV;
	}

}
