package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_leave_request")
public class Leave_Request {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer lr_id;
	
	@Column(name="lr_leave_type", nullable=false,length=20)
	private String lr_leave_type;
	
	
	@Column(name="lr_description", length=150)
	private String lr_description;
	
	@Column(name="lr_duration")
	private Integer lr_duration;
	
	@Column(name="lr_status")
	private Integer lr_status;
	
	public Integer getLr_status() {
		return lr_status;
	}

	public void setLr_status(Integer lr_status) {
		this.lr_status = lr_status;
	}

	@Column(name="lr_active",nullable=false,length=2)
	private Integer lr_active;
	
	@Column(name="lr_from_date")
	@Temporal(TemporalType.DATE)
	private Date lr_from_date;
	
	@Column(name="lr_to_date")
	@Temporal(TemporalType.DATE)
	private Date lr_to_date;

	@Column(name="lr_create_date")
	@Temporal(TemporalType.DATE)
	private Date lr_create_date;

	@Column(name="lr_update_date")
	@Temporal(TemporalType.DATE)
	private Date lr_update_date;

	public Integer getLr_id() {
		return lr_id;
	}

	public void setLr_id(Integer lr_id) {
		this.lr_id = lr_id;
	}
	public Date getLr_from_date() {
		return lr_from_date;
	}

	public void setLr_from_date(Date lr_from_date) {
		this.lr_from_date = lr_from_date;
	}

	public Date getLr_to_date() {
		return lr_to_date;
	}

	public void setLr_to_date(Date lr_to_date) {
		this.lr_to_date = lr_to_date;
	}

	public Integer getLr_active() {
		return lr_active;
	}

	public void setLr_active(Integer lr_active) {
		this.lr_active = lr_active;
	}
	public String getLr_leave_type() {
		return lr_leave_type;
	}

	public void setLr_leave_type(String lr_leave_type) {
		this.lr_leave_type = lr_leave_type;
	}
	
	

	public String getLr_description() {
		return lr_description;
	}

	public void setLr_description(String lr_description) {
		this.lr_description = lr_description;
	}

	public Date getLr_create_date() {
		return lr_create_date;
	}

	public void setLr_create_date(Date lr_create_date) {
		this.lr_create_date = lr_create_date;
	}

	public Date getLr_update_date() {
		return lr_update_date;
	}

	public void setLr_update_date(Date lr_update_date) {
		this.lr_update_date = lr_update_date;
	}
	public Integer getLr_duration() {
		return lr_duration;
	}

	public void setLr_duration(Integer lr_duration) {
		this.lr_duration = lr_duration;
	}

	

	

}

