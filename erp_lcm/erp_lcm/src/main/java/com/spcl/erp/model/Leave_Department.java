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

@Entity(name="erp_leave_department")
public class Leave_Department {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ld_id;
	
	@NotEmpty
	@Column(name="ld_leave_type", nullable=false,length=30)
	private String ld_leave_type;
	@Column(name="ld_display_name", length=30)
	private String ld_display_name;
	
	@Column(name="ld_duration", length=30)
	private String ld_duration;
	@Column(name="ld_manager", length=30)
	private String ld_manager;
	@Column(name="ld_parent_department", length=30)
	private String ld_parent_department;
	@Column(name="ld_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date ld_create_date;
	@Column(name="ld_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date ld_update_date;
	@Column(name="ld_active")
	private Integer ld_active;
	public Integer getLd_id() {
		return ld_id;
	}
	public void setLd_id(Integer ld_id) {
		this.ld_id = ld_id;
	}
	public String getLd_leave_type() {
		return ld_leave_type;
	}
	public void setLd_leave_type(String ld_leave_type) {
		this.ld_leave_type = ld_leave_type;
	}
	public String getLd_display_name() {
		return ld_display_name;
	}
	public void setLd_display_name(String ld_display_name) {
		this.ld_display_name = ld_display_name;
	}
	public String getLd_duration() {
		return ld_duration;
	}
	public void setLd_duration(String ld_duration) {
		this.ld_duration = ld_duration;
	}
	public String getLd_manager() {
		return ld_manager;
	}
	public void setLd_manager(String ld_manager) {
		this.ld_manager = ld_manager;
	}
	public String getLd_parent_department() {
		return ld_parent_department;
	}
	public void setLd_parent_department(String ld_parent_department) {
		this.ld_parent_department = ld_parent_department;
	}
	public Date getLd_create_date() {
		return ld_create_date;
	}
	public void setLd_create_date(Date ld_create_date) {
		this.ld_create_date = ld_create_date;
	}
	public Date getLd_update_date() {
		return ld_update_date;
	}
	public void setLd_update_date(Date ld_update_date) {
		this.ld_update_date = ld_update_date;
	}
	public Integer getLd_active() {
		return ld_active;
	}
	public void setLd_active(Integer ld_active) {
		this.ld_active = ld_active;
	}

	

	
}
		


