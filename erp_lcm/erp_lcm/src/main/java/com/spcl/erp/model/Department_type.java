package com.spcl.erp.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
@Entity(name="erp_department")
public class Department_type {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer dept_id;
	

	@Column(name="dt_department_name")
	private String dt_department_name;
	
	@Column(name="dt_manager")
	private String dt_manager;
	
	@Column(name="dt_parent_department")
	private String dt_parent_department;
	
	@Column(name="dt_create_date" ,nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dt_create_date;
	
	@Column(name="dt_update_date",nullable=true)
	@Temporal(TemporalType.DATE)
	private Date dt_update_date;
	
	@Column(name="dt_update_by")
	private String dt_update_by;
	
	@Column(name="dt_created_by")
	private String dt_created_by;
	
	@Column(name="dept_active")
	private Integer dept_active;

	
	@ManyToOne
	@JoinColumn(name="hr_req_id")
	private HrRequirement hrrequirement;
	
	public HrRequirement getHrrequirement() {
		return hrrequirement;
	}

	public void setHrrequirement(HrRequirement hrrequirement) {
		this.hrrequirement = hrrequirement;
	}
	
	public String getDt_update_by() {
		return dt_update_by;
	}
	public void setDt_update_by(String dt_update_by) {
		this.dt_update_by = dt_update_by;
	}
	
	public Integer getDept_active() {
		return dept_active;
	}
	public void setDept_active(Integer dept_active) {
		this.dept_active = dept_active;
	}
	public Date getDt_create_date() {
		return dt_create_date;
	}
	public void setDt_create_date(Date dt_create_date) {
		this.dt_create_date = dt_create_date;
	}
	public Date getDt_update_date() {
		return dt_update_date;
	}
	public void setDt_update_date(Date dt_update_date) {
		this.dt_update_date = dt_update_date;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public String getDt_department_name() {
		return dt_department_name;
	}
	public void setDt_department_name(String dt_department_name) {
		this.dt_department_name = dt_department_name;
	}
	public String getDt_manager() {
		return dt_manager;
	}
	public void setDt_manager(String dt_manager) {
		this.dt_manager = dt_manager;
	}
	public String getDt_parent_department() {
		return dt_parent_department;
	}
	public void setDt_parent_department(String dt_parent_department) {
		this.dt_parent_department = dt_parent_department;
	}
	public String getDt_created_by() {
		return dt_created_by;
	}
	public void setDt_created_by(String dt_created_by) {
		this.dt_created_by = dt_created_by;
	}

	

}
