package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_industrial")
public class Ehs_Industrial {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="industrial_id", nullable=false)
	private Integer industrial_id;

	
	@Column(name="industrial_name")
	private String industrial_name ;
	
	@Column(name="industrial_aspect")
	private String industrial_aspect ;
	
	@Column(name="industrial_des")
	private String industrial_des ;
	
	@Column(name="industrial_date")
	@Temporal(TemporalType.DATE)
	private Date industrial_date ;
	
	@Column(name="industrial_updated_date")
	@Temporal(TemporalType.DATE)
	private Date industrial_updated_date;
	
	@Column(name="industrial_created_date")
	@Temporal(TemporalType.DATE)
	private Date industrial_created_date;
	
	@Column(name="industrial_active")
	private int industrial_active ;
	
	
	public Integer getIndustrial_id() {
		return industrial_id;
		
	}

	public String getIndustrial_name() {
		return industrial_name;
	}

	public void setIndustrial_name(String industrial_name) {
		this.industrial_name = industrial_name;
	}

	public String getIndustrial_aspect() {
		return industrial_aspect;
	}

	public void setIndustrial_aspect(String industrial_aspect) {
		this.industrial_aspect = industrial_aspect;
	}

	public String getIndustrial_des() {
		return industrial_des;
	}

	public void setIndustrial_des(String industrial_des) {
		this.industrial_des = industrial_des;
	}

	public Date getIndustrial_date() {
		return industrial_date;
	}

	public void setIndustrial_date(Date industrial_date) {
		this.industrial_date = industrial_date;
	}

	public Date getIndustrial_updated_date() {
		return industrial_updated_date;
	}

	public void setIndustrial_updated_date(Date industrial_updated_date) {
		this.industrial_updated_date = industrial_updated_date;
	}

	public Date getIndustrial_created_date() {
		return industrial_created_date;
	}

	public void setIndustrial_created_date(Date industrial_created_date) {
		this.industrial_created_date = industrial_created_date;
	}

	public int getIndustrial_active() {
		return industrial_active;
	}

	public void setIndustrial_active(int industrial_active) {
		this.industrial_active = industrial_active;
	}

	public void setIndustrial_id(Integer industrial_id) {
		this.industrial_id = industrial_id;
	}
	
}



