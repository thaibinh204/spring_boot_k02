package com.k02.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bang_diem")
public class Bangdiem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long ma_sinh_vien;
	private long diem;
	private long ma_mon_hoc;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Bangdiem bangdiem;
	
	public Bangdiem() {}
	
	public Bangdiem(Long diem) {
		this.diem=diem;
	}
	
	public Bangdiem getBangdiem() {
		return bangdiem;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMa_sinh_vien() {
		return ma_sinh_vien;
	}

	public void setMa_sinh_vien(long ma_sinh_vien) {
		this.ma_sinh_vien = ma_sinh_vien;
	}

	public long getDiem() {
		return diem;
	}

	public void setDiem(long diem) {
		this.diem = diem;
	}

	public long getMa_mon_hoc() {
		return ma_mon_hoc;
	}

	public void setMa_mon_hoc(long ma_mon_hoc) {
		this.ma_mon_hoc = ma_mon_hoc;
	}

	public void setMonhoc(Bangdiem bangdiem) {
		this.bangdiem = bangdiem;
	}
	
	@Override
	public String toString() {
		return "Monhoc [id="+id+", name="+diem+"]";
	}

	
}
