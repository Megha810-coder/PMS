package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="erp_emp_employee_work")
public class Employee_Work {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_company_id", nullable=false)
	private Integer emp_company_id;
	
	@Column(name="emp_name", length=30)
	private String emp_name;
	
	@Column(name="emp_work_location", length=30)
	private String emp_work_location;
	
	@Column(name="emp_phone",length=30)
	private Integer emp_phone;
	
	@Column(name="emp_job", length=30)
	private String emp_job;
	
	@Column(name="emp_salary",length=30)
	private Double emp_salary;
	
	@Column(name="emp_experiance", nullable=false,length=30)
	private Integer emp_experiance;

	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getEmp_company_id() {
		return emp_company_id;
	}

	public void setEmp_company_id(Integer emp_company_id) {
		this.emp_company_id = emp_company_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_work_location() {
		return emp_work_location;
	}

	public void setEmp_work_location(String emp_work_location) {
		this.emp_work_location = emp_work_location;
	}

	public Integer getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(Integer emp_phone) {
		this.emp_phone = emp_phone;
	}

	public String getEmp_job() {
		return emp_job;
	}

	public void setEmp_job(String emp_job) {
		this.emp_job = emp_job;
	}

	public Double getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(Double emp_salary) {
		this.emp_salary = emp_salary;
	}

	public Integer getEmp_experiance() {
		return emp_experiance;
	}

	public void setEmp_experiance(Integer emp_experiance) {
		this.emp_experiance = emp_experiance;
	}
}
