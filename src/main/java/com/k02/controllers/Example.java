package com.k02.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.k02.entity.Bangdiem;
import com.k02.entity.Lophoc;
import com.k02.entity.User;
import com.k02.service.BangdiemService;
import com.k02.service.LophocService;


import com.k02.entity.Monhoc;
import com.k02.entity.Sinhvien;
import com.k02.entity.User;
import com.k02.service.MonhocService;
import com.k02.service.SinhvienService;
import com.k02.service.UserService;

@Controller
public class Example {
	@Autowired
	private UserService userSrv;
	@Autowired
	private LophocService lophocSrv;
	@Autowired
	private MonhocService monhocSrv;
	@Autowired
	private SinhvienService sinhvienSrv;
	
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
	      //tao doi tuong uuser
              //them file hello
		User user = new User();
		user.setUsername("thaibinh");
		user.setPassword("123456");
		userSrv.save(user);
		return "Hello Spring Boot";
	}

	@RequestMapping("/lophoc")
	@ResponseBody
	public String lophoc() {
//		Lophoc lophoc = new Lophoc();
//		lophoc.setMaLopHoc("m02");
//		lophoc.setTenLopHoc("lop1");
//		lophoc.setTongSoSinhVien(30);
//		lophocSrv.save(lophoc);
		
		// Lay lop hoc
		Lophoc lopHoc = lophocSrv.findById(1l);
	
		String result ="";
		if(lopHoc != null) {
			// mac dinh là trong lop hoc co chua danh sach sv cua lop do
			// nen get danh sach sv
			Set<Sinhvien> sinhViens = lopHoc.getDsSV();
			// lay tat ca ten sv trong danh sach roi hien thi len man hinh
			for (Sinhvien sinhVien : sinhViens) {
				result += sinhVien.getTenSinhVien()+"</br>";
			}
		}
		return  result + "</br></br> nhap thong tin thanh cong";
		
	}

	@RequestMapping("/monhoc")
	@ResponseBody
	public String monHoc() {
		Monhoc mh = new Monhoc();
		mh.setMamonhoc("005");
		mh.setTenmonhoc("Toan");
		monhocSrv.save(mh);
		return "Them bang mon hoc thanh cong";
		
	}
	
	@RequestMapping("/bangdiem")
	@ResponseBody
	public String bangDiem() {
		Monhoc ds =monhocSrv.findByMonhoc(2l);
		String result ="";
		if(ds != null) {
			Set<Bangdiem> monHocs = ds.getDsmh();
			for (Bangdiem monH : monHocs) {
				result += ds.getTenmonhoc()+" - "+monH.getDiem()+"</br>";
			}
		}else {
			result="Danh sach trong";
		}
		return  result;
	}
	
	@RequestMapping("/sinhvien")
	@ResponseBody
	public String sinhVien() {
		Sinhvien ds=sinhvienSrv.findBySinhvien(2l);
		String result="";
		if(ds!=null){
			Set<Bangdiem> dssv=ds.getDsdiem();
			for(Bangdiem item : dssv) {
				result+=ds.getTenSinhVien()+ " " +item.getDiem()+"</br>";
			}
		}
		return result;
	}

}
