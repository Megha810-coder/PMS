package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_contact")
public class Contact {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cntc_id", nullable=false,length=3)
	private Integer cntc_id;
	
	@NotEmpty
	@Column(name="cntc_name", nullable=false,length=100)
	private String cntc_name;
	
	@Column(name="cntc_address",nullable=true,length=200)
	private String cntc_address;
	
	@Column(name="cntc_email", nullable=true,length=100)
	private String cntc_email;
	
	@Column(name="cntc_mobile",nullable=true,length=10)
	private String cntc_mobile;
	
	@Column(name="cntc_postion",length=100)
	private String cntc_postion;

	public Integer getCntc_id() {
		return cntc_id;
	}

	public void setCntc_id(Integer cntc_id) {
		this.cntc_id = cntc_id;
	}

	public String getCntc_name() {
		return cntc_name;
	}

	public void setCntc_name(String cntc_name) {
		this.cntc_name = cntc_name;
	}

	public String getCntc_address() {
		return cntc_address;
	}

	public void setCntc_address(String cntc_address) {
		this.cntc_address = cntc_address;
	}

	public String getCntc_email() {
		return cntc_email;
	}

	public void setCntc_email(String cntc_email) {
		this.cntc_email = cntc_email;
	}

	public String getCntc_mobile() {
		return cntc_mobile;
	}

	public void setCntc_mobile(String cntc_mobile) {
		this.cntc_mobile = cntc_mobile;
	}

	public String getCntc_postion() {
		return cntc_postion;
	}

	public void setCntc_postion(String cntc_postion) {
		this.cntc_postion = cntc_postion;
	}
	
	
	
	
}
