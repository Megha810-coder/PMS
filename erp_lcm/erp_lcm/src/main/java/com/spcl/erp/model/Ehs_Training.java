package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_training")
public class Ehs_Training {
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="training_id", nullable=false)
	private Integer training_id;

	
	@Column(name="training_name")
	private String training_name ;
	
	@Column(name="training_aspect")
	private String training_aspect ;
	
	@Column(name="training_des")
	private String training_des ;
	
	@Column(name="training_rat")
	private String training_rat ;
	
	public String getTraining_rat() {
		return training_rat;
	}

	public void setTraining_rat(String training_rat) {
		this.training_rat = training_rat;
	}

	@Column(name="training_date")
	@Temporal(TemporalType.DATE)
	private Date training_date ;
	
	@Column(name="training_updated_date")
	@Temporal(TemporalType.DATE)
	private Date training_updated_date;
	
	@Column(name="training_created_date")
	@Temporal(TemporalType.DATE)
	private Date training_created_date;
	
	@Column(name="training_active")
	private int training_active ;

	public Integer getTraining_id() {
		return training_id;
	}

	public void setTraining_id(Integer training_id) {
		this.training_id = training_id;
	}

	public String getTraining_name() {
		return training_name;
	}

	public void setTraining_name(String training_name) {
		this.training_name = training_name;
	}

	public String getTraining_aspect() {
		return training_aspect;
	}

	public void setTraining_aspect(String training_aspect) {
		this.training_aspect = training_aspect;
	}

	public String getTraining_des() {
		return training_des;
	}

	public void setTraining_des(String training_des) {
		this.training_des = training_des;
	}

	public Date getTraining_date() {
		return training_date;
	}

	public void setTraining_date(Date training_date) {
		this.training_date = training_date;
	}

	public Date getTraining_updated_date() {
		return training_updated_date;
	}

	public void setTraining_updated_date(Date training_updated_date) {
		this.training_updated_date = training_updated_date;
	}

	public Date getTraining_created_date() {
		return training_created_date;
	}

	public void setTraining_created_date(Date training_created_date) {
		this.training_created_date = training_created_date;
	}

	public int getTraining_active() {
		return training_active;
	}

	public void setTraining_active(int training_active) {
		this.training_active = training_active;
	}
	

	
}
