package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_emp_employee_position")

public class Employee_position {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer emp_position_id;
	
	@Column(name="emp_position_department", nullable=false,length=30)
	private String emp_position_department;
	
	@Column(name="emp_job_position", nullable=false,length=30)
	private String emp_job_position;

	@Column(name="emp_name", nullable=false,length=30)
	private String emp_name;
	
	@Column(name="emp_job_description", nullable=false,length=30)
	private String emp_job_description;
	
	@Column(name="emp_position_manager", nullable=false,length=30)
	private String emp_position_manager;
	
	@Column(name="emp_job_type", nullable=false,length=30)
	private String emp_job_type;
	
	@Column(name="emp_working_hour", nullable=false,length=30)
	private String emp_working_hour;
	
	@Column(name="emp_joining_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date emp_joining_date;
   
	@Column(name="emp_shift", nullable=false,length=30)
	private String emp_shift;

	public Integer getEmp_position_id() {
		return emp_position_id;
	}

	public void setEmp_position_id(Integer emp_position_id) {
		this.emp_position_id = emp_position_id;
	}

	public String getEmp_position_department() {
		return emp_position_department;
	}

	public void setEmp_position_department(String emp_position_department) {
		this.emp_position_department = emp_position_department;
	}

	public String getEmp_job_position() {
		return emp_job_position;
	}

	public void setEmp_job_position(String emp_job_position) {
		this.emp_job_position = emp_job_position;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_job_description() {
		return emp_job_description;
	}

	public void setEmp_job_description(String emp_job_description) {
		this.emp_job_description = emp_job_description;
	}

	public String getEmp_position_manager() {
		return emp_position_manager;
	}

	public void setEmp_position_manager(String emp_position_manager) {
		this.emp_position_manager = emp_position_manager;
	}

	public String getEmp_job_type() {
		return emp_job_type;
	}

	public void setEmp_job_type(String emp_job_type) {
		this.emp_job_type = emp_job_type;
	}

	public String getEmp_working_hour() {
		return emp_working_hour;
	}

	public void setEmp_working_hour(String emp_working_hour) {
		this.emp_working_hour = emp_working_hour;
	}

	public Date getEmp_joining_date() {
		return emp_joining_date;
	}

	public void setEmp_joining_date(Date emp_joining_date) {
		this.emp_joining_date = emp_joining_date;
	}

	public String getEmp_shift() {
		return emp_shift;
	}

	public void setEmp_shift(String emp_shift) {
		this.emp_shift = emp_shift;
	}
	
}
