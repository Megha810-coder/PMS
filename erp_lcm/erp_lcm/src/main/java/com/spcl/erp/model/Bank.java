package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_bank")
public class Bank {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bnk_id", nullable=false)
	private Integer bnk_id;
	
	@NotBlank
	@Column(name="bnk_name", nullable=false,length=200)
	private String bnk_name ;
	
	@Size (min =5, max = 15,message="Bank identification code must be between 5 and 15 digit")
	@Column(name="bnk_id_code", nullable=false,length=15)
	private String bnk_id_code ;	
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address bnk_address;
	
	public Address getBnk_address() {
		return bnk_address;
	}

	public void setBnk_address(Address bnk_address) {
		this.bnk_address = bnk_address;
	}

	@Size(min=10,max=10,message="Phone number must be 10 digit")
	@Pattern(regexp="[0-9]+")
	@Column(name="bnk_phone",length=10)
	private String bnk_phone ;

	
	@NotNull
    @NotEmpty
    @Pattern(regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",message="Please enter valid email address")
	@Column(name="bnk_email", nullable=false,length=110)
	private String bnk_email ;
	
	@Column(name="bnk_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date bnk_create_date;
	
	
	@Column(name="bnk_create_by", nullable=true)
	private String bnk_create_by;
	
	
	@Column(name="bnk_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date bnk_update_date;
	
	@Column(name="bnk_update_by", nullable=true)
	private String bnk_update_by;
		
	@Column(name="bnk_active")
	private Integer bnk_active;


	public Integer getBnk_id() {
		return bnk_id;
	}


	public void setBnk_id(Integer bnk_id) {
		this.bnk_id = bnk_id;
	}


	public String getBnk_name() {
		return bnk_name;
	}


	public void setBnk_name(String bnk_name) {
		this.bnk_name = bnk_name;
	}


	public String getBnk_id_code() {
		return bnk_id_code;
	}


	public void setBnk_id_code(String bnk_id_code) {
		this.bnk_id_code = bnk_id_code;
	}
	
	
	public String getBnk_email() {
		return bnk_email;
	}


	public void setBnk_email(String bnk_email) {
		this.bnk_email = bnk_email;
	}


	public Date getBnk_create_date() {
		return bnk_create_date;
	}


	public void setBnk_create_date(Date bnk_create_date) {
		this.bnk_create_date = bnk_create_date;
	}


	public String getBnk_create_by() {
		return bnk_create_by;
	}


	public void setBnk_create_by(String bnk_create_by) {
		this.bnk_create_by = bnk_create_by;
	}


	public Date getBnk_update_date() {
		return bnk_update_date;
	}


	public void setBnk_update_date(Date bnk_update_date) {
		this.bnk_update_date = bnk_update_date;
	}


	public String getBnk_update_by() {
		return bnk_update_by;
	}


	public void setBnk_update_by(String bnk_update_by) {
		this.bnk_update_by = bnk_update_by;
	}


	public Integer getBnk_active() {
		return bnk_active;
	}


	public void setBnk_active(Integer bnk_active) {
		this.bnk_active = bnk_active;
	}

	public String getBnk_phone() {
		return bnk_phone;
	}

	public void setBnk_phone(String bnk_phone) {
		this.bnk_phone = bnk_phone;
	}

	
}
