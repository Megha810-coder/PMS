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

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="erp_account")
public class Account {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="acc_id", nullable=false)
	private Integer acc_id;
	
	@NotBlank
	@Column(name="acc_number",length=100)
	private String acc_number ;
	
	@NotBlank
	@Column(name="acc_type",length=200)
	private String acc_type ;
	
	@Column(name="acc_holder",length=200)
	private String acc_holder ;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	private Bank bank;	
	
	@OneToOne
	@JoinColumn(name="emp_id", nullable=false)
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@NotBlank
	@Column(name="acc_holder1", nullable=false,length=200)
	private String acc_holder1 ;
	
	@Column(name="acc_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date acc_create_date;
	
	
	@Column(name="acc_create_by", nullable=true)
	private String acc_create_by;
	
	
	@Column(name="acc_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date acc_update_date;
	
	@Column(name="acc_update_by", nullable=true)
	private String acc_update_by;
		
	@Column(name="acc_active")
	private Integer acc_active;

	public Date getAcc_create_date() {
		return acc_create_date;
	}

	public void setAcc_create_date(Date acc_create_date) {
		this.acc_create_date = acc_create_date;
	}

	public String getAcc_create_by() {
		return acc_create_by;
	}

	public void setAcc_create_by(String acc_create_by) {
		this.acc_create_by = acc_create_by;
	}

	public Date getAcc_update_date() {
		return acc_update_date;
	}

	public void setAcc_update_date(Date acc_update_date) {
		this.acc_update_date = acc_update_date;
	}

	public String getAcc_update_by() {
		return acc_update_by;
	}

	public void setAcc_update_by(String acc_update_by) {
		this.acc_update_by = acc_update_by;
	}

	public Integer getAcc_active() {
		return acc_active;
	}

	public void setAcc_active(Integer acc_active) {
		this.acc_active = acc_active;
	}

	public Integer getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_number() {
		return acc_number;
	}

	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public String getAcc_holder() {
		return acc_holder;
	}

	public void setAcc_holder(String acc_holder) {
		this.acc_holder = acc_holder;
	}

	public String getAcc_holder1() {
		return acc_holder1;
	}

	public void setAcc_holder1(String acc_holder1) {
		this.acc_holder1 = acc_holder1;
	}
		

	

}
