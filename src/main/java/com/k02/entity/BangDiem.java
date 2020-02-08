package com.k02.entity;

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
@Table(name = "bang_diem")
public class BangDiem {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "diem")
	private double diem;

	@Column(name = "sinhvien_id")
	private Integer sinhvienId;

	@Column(name = "monhoc_id")
	private Integer monhocId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private SinhVien sinhvien ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public Integer getSinhvienId() {
		return sinhvienId;
	}

	public void setSinhvienId(Integer sinhvienId) {
		this.sinhvienId = sinhvienId;
	}

	public Integer getMonhocId() {
		return monhocId;
	}

	public void setMonhocId(Integer monhocId) {
		this.monhocId = monhocId;
	}

}
