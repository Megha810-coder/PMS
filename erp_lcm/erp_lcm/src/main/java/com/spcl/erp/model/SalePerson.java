package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_saleperson")
public class SalePerson {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer salep_id;
		
	@Column(name="salep_title", nullable=true,length=10)
	private String salep_title;
	
	@NotEmpty
	@Column(name="salep_fname", nullable=false,length=50)
	private String salep_fname;

	@Column(name="salep_mname", nullable=true,length=50)
	private String salep_mname;
	

	@Column(name="salep_lname", nullable=false,length=50)
	private String salep_lname;
	
	@Column(name="salep_contact", nullable=false,length=20)
	private String salep_contact;
	
	@Column(name="salep_email", nullable=false,length=100)
	private String salep_email;
	
	@Column(name="salep_website", nullable=true,length=100)
	private String salep_website;
			
	@Column(name="salep_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date salep_create_date;
	
	@Column(name="salep_create_by", nullable=true)
	private String salep_create_by;
	
	@Column(name="salep_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date salep_update_date;
	
	@Column(name="salep_update_by", nullable=true)
	private String salep_update_by;
	
	
	@Column(name="salep_active", nullable=false,length=2)
	private Integer salep_active;
	
	@Column(name="salep_img_code", length=20)
	private String salep_img_code;
	
	public Integer getSalep_id() {
		return salep_id;
	}

	public void setSalep_id(Integer salep_id) {
		this.salep_id = salep_id;
	}

	public String getSalep_title() {
		return salep_title;
	}

	public void setSalep_title(String salep_title) {
		this.salep_title = salep_title;
	}

	public String getSalep_fname() {
		return salep_fname;
	}

	public void setSalep_fname(String salep_fname) {
		this.salep_fname = salep_fname;
	}

	public String getSalep_mname() {
		return salep_mname;
	}

	public void setSalep_mname(String salep_mname) {
		this.salep_mname = salep_mname;
	}

	public String getSalep_lname() {
		return salep_lname;
	}

	public void setSalep_lname(String salep_lname) {
		this.salep_lname = salep_lname;
	}

	public String getSalep_contact() {
		return salep_contact;
	}

	public void setSalep_contact(String salep_contact) {
		this.salep_contact = salep_contact;
	}

	public String getSalep_email() {
		return salep_email;
	}

	public void setSalep_email(String salep_email) {
		this.salep_email = salep_email;
	}

	public String getSalep_website() {
		return salep_website;
	}

	public void setSalep_website(String salep_website) {
		this.salep_website = salep_website;
	}

	public Date getSalep_create_date() {
		return salep_create_date;
	}

	public void setSalep_create_date(Date salep_create_date) {
		this.salep_create_date = salep_create_date;
	}

	public String getSalep_create_by() {
		return salep_create_by;
	}

	public void setSalep_create_by(String salep_create_by) {
		this.salep_create_by = salep_create_by;
	}

	public Date getSalep_update_date() {
		return salep_update_date;
	}

	public void setSalep_update_date(Date salep_update_date) {
		this.salep_update_date = salep_update_date;
	}

	public String getSalep_update_by() {
		return salep_update_by;
	}

	public void setSalep_update_by(String salep_update_by) {
		this.salep_update_by = salep_update_by;
	}

	public String getSalep_img_code() {
		return salep_img_code;
	}

	public void setSalep_img_code(String salep_img_code) {
		this.salep_img_code = salep_img_code;
	}
	public Integer getSalep_active() {
		return salep_active;
	}

	public void setSalep_active(Integer salep_active) {
		this.salep_active = salep_active;
	}

	
}
