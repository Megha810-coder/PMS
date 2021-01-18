package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="erp_emp_employee_company")
public class Employee_Company {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_company_id", nullable=false)
	private Integer emp_company_id;
	
	@Column(name="emp_work_location", nullable=false,length=30)
	private String emp_work_location;
	
	@Column(name="emp_company_email",length=30)
	private String emp_company_email;
	
	@Column(name="emp_company_ph_no", nullable=false,length=30)
	private String emp_company_ph_no;
  
	@OneToOne
	@JoinColumn(name="emp_id")
	private Employee employee_company;  
	
	
	public Employee getEmployee_company() {
		return employee_company;
	}

	public void setEmployee_company(Employee employee_company) {
		this.employee_company = employee_company;
	}

	public Integer getEmp_company_id() {
		return emp_company_id;
	}

	public void setEmp_company_id(Integer emp_company_id) {
		this.emp_company_id = emp_company_id;
	}

	public String getEmp_work_location() {
		return emp_work_location;
	}

	public void setEmp_work_location(String emp_work_location) {
		this.emp_work_location = emp_work_location;
	}

	

	public String getEmp_company_email() {
		return emp_company_email;
	}

	public void setEmp_company_email(String emp_company_email) {
		this.emp_company_email = emp_company_email;
	}

	public String getEmp_company_ph_no() {
		return emp_company_ph_no;
	}

	public void setEmp_company_ph_no(String emp_company_ph_no) {
		this.emp_company_ph_no = emp_company_ph_no;
	}
	
	

}
