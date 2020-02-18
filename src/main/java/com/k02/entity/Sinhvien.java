package com.k02.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sinhvien")
public class Sinhvien {
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

	@ManyToOne(cascade = CascadeType.ALL)
	private Lophoc lophoc;
	
	@OneToMany(mappedBy="sinhvien",cascade = CascadeType.ALL)
	private Set<Bangdiem> dssv=new HashSet<Bangdiem>();
	
	
	
	public Set<Bangdiem> getDsdiem() {
		return dssv;
	}

	public void setDsdiem(Set<Bangdiem> dsdiem) {
		this.dssv = dsdiem;
	}

	public Lophoc getLophoc() {
		return lophoc;
	}

	public void setLophoc(Lophoc lophoc) {
		this.lophoc = lophoc;
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

}
