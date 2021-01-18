package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_osha_law")
public class Osha_Law {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="osha_id", nullable=false)
	private Integer osha_id;

	
	@Column(name="osha_name")
	private String osha_name ;
	
	@Column(name="osha_fact")
	private String osha_fact ;
	
	public int getOsha_active() {
		return osha_active;
	}

	public void setOsha_active(int osha_active) {
		this.osha_active = osha_active;
	}

	@Column(name="osha_des")
	private String osha_des ;
	

	@Column(name="osha_active")
	private int osha_active ;
	
	
	
	public Integer getOsha_id() {
		return osha_id;
	}

	public void setOsha_id(Integer osha_id) {
		this.osha_id = osha_id;
	}

	public String getOsha_name() {
		return osha_name;
	}

	public void setOsha_name(String osha_name) {
		this.osha_name = osha_name;
	}

	public String getOsha_fact() {
		return osha_fact;
	}

	public void setOsha_fact(String osha_fact) {
		this.osha_fact = osha_fact;
	}

	public String getOsha_des() {
		return osha_des;
	}

	public void setOsha_des(String osha_des) {
		this.osha_des = osha_des;
	}

	public Date getOsha_date() {
		return osha_date;
	}

	public void setOsha_date(Date osha_date) {
		this.osha_date = osha_date;
	}

	public Date getOsha_updated_date() {
		return osha_updated_date;
	}

	public void setOsha_updated_date(Date osha_updated_date) {
		this.osha_updated_date = osha_updated_date;
	}

	public Date getOsha_created_date() {
		return osha_created_date;
	}

	public void setOsha_created_date(Date osha_created_date) {
		this.osha_created_date = osha_created_date;
	}

	@Column(name="osha_date")
	@Temporal(TemporalType.DATE)
	private Date osha_date ;
	
	@Column(name="osha_updated_date")
	@Temporal(TemporalType.DATE)
	private Date osha_updated_date;
	
	@Column(name="osha_created_date")
	@Temporal(TemporalType.DATE)
	private Date osha_created_date;
	

	

	
	

}
