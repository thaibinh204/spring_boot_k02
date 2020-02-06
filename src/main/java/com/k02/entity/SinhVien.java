package com.k02.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sinhvien")
public class SinhVien {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ma_sinh_vien")
	private String maSinhVien;

	@Column(name = "ten_sinh_vien")
	private String tenSinhVien;

	@Column(name = "ngay_sinh")
	private Date ngaySinh;

	@Column(name = "ma_lop_hoc")
	private String maLopHoc;

	@ManyToOne(cascade = CascadeType.ALL)
	private Lophoc lopHoc;

	public Lophoc getLophoc() {
		return lopHoc;
	}

	public void setLophoc(Lophoc lopHoc) {
		this.lopHoc = lopHoc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getMaLopHoc() {
		return maLopHoc;
	}

	public void setMaLopHoc(String maLopHoc) {
		this.maLopHoc = maLopHoc;
	}

}
