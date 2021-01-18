package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_leave_type")
public class Leave_type {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer lt_id;
	
	@NotEmpty
	@Column(name="lt_name", nullable=false)
	private String lt_name;
	
	@Column(name="lt_description", nullable=true)
	private String lt_description;
	
	@Column(name="lt_is_unpaid")
	private Integer lt_is_unpaid;
	
	@Column(name="lt_take_leave")
	private Integer lt_take_leave;
	
	@Column(name="lt_valid_by")
	private Integer lt_valid_by;
	
	@Column(name="lt_allc_mode")
	private Integer lt_allc_mode;
	
	@Column(name="lt_active")
	private Integer lt_active;
	
	@Column(name="lt_start_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date lt_start_date;
	
	@Column(name="lt_end_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date lt_end_date;
	
	@Column(name="lt_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date lt_create_date;
	
	@Column(name="lt_create_by", nullable=true)
	private String lt_create_by;
	
	@Column(name="lt_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date lt_update_date;
	
	@Column(name="lt_update_by", nullable=true)
	private String lt_update_by;

	public Integer getLt_id() {
		return lt_id;
	}

	public void setLt_id(Integer lt_id) {
		this.lt_id = lt_id;
	}

	public String getLt_name() {
		return lt_name;
	}

	public void setLt_name(String lt_name) {
		this.lt_name = lt_name;
	}

	public String getLt_description() {
		return lt_description;
	}

	public void setLt_description(String lt_description) {
		this.lt_description = lt_description;
	}

	public Integer getLt_is_unpaid() {
		return lt_is_unpaid;
	}

	public void setLt_is_unpaid(Integer lt_is_unpaid) {
		this.lt_is_unpaid = lt_is_unpaid;
		
	}
	
	public Integer getLt_take_leave() {
		return lt_take_leave;
	}

	public void setLt_take_leave(Integer lt_take_leave) {
		this.lt_take_leave = lt_take_leave;
	}
	
	
	public Integer getLt_valid_by() {
		return lt_valid_by;
	}

	public void setLt_valid_by(Integer lt_valid_by) {
		this.lt_valid_by = lt_valid_by;
		
	}

	public Integer getLt_allc_mode() {
		return lt_allc_mode;
	}
	
	public void setLt_allc_mode(Integer lt_allc_mode) {
		this.lt_allc_mode = lt_allc_mode;
	}

	public Date getLt_start_date() {
		return lt_start_date;
	}
	
	public void setLt_start_date(Date lt_start_date) {
		this.lt_start_date = lt_start_date;
	}

	public Date getLt_end_date() {
		return lt_end_date;
	}

	public void setLt_end_date(Date lt_end_date) {
		this.lt_end_date = lt_end_date;
	}

	public Integer getLt_active() {
		return lt_active;
	}

	public void setLt_active(Integer lt_active) {
		this.lt_active = lt_active;
	}

	public Date getLt_create_date() {
		return lt_create_date;
	}

	public void setLt_create_date(Date lt_create_date) {
		this.lt_create_date = lt_create_date;
	}

	public String getLt_create_by() {
		return lt_create_by;
	}

	public void setLt_create_by(String lt_create_by) {
		this.lt_create_by = lt_create_by;
	}

	public Date getLt_update_date() {
		return lt_update_date;
	}

	public void setLt_update_date(Date lt_update_date) {
		this.lt_update_date = lt_update_date;
	}

	public String getLt_update_by() {
		return lt_update_by;
	}

	public void setLt_update_by(String lt_update_by) {
		this.lt_update_by = lt_update_by;
	}
	
}
