package org.jsp.AdminHospitalDemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false,unique=true)
	private String Founder;
	
	@Column(nullable=false)
	private String gst;
	
	@Column(nullable=false)
	private int year_of_esth;

	
	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFounder() {
		return Founder;
	}


	public void setFounder(String founder) {
		this.Founder = founder;
	}


	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst=gst;
	}


public int getYear_of_esth() {
		return year_of_esth;
	}


	public void setYear_of_esth(int year_of_esth) {
		this.year_of_esth = year_of_esth;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
