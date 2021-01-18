package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="erp_document")
public class Employee_Document {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_doc_id", nullable=false)
	private Integer emp_doc_id;
	
	@Column(name="emp_doc1", length=30)
	private String emp_doc1;
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name="emp_doc2", length=30)
	private String emp_doc2;
	
	@Column(name="emp_doc3", length=30)
	private String emp_doc3;

	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	public Integer getEmp_doc_id() {
		return emp_doc_id;
	}

	public void setEmp_doc_id(Integer emp_doc_id) {
		this.emp_doc_id = emp_doc_id;
	}

	public String getEmp_doc1() {
		return emp_doc1;
	}

	public String getEmp_doc2() {
		return emp_doc2;
	}

	public void setEmp_doc2(String emp_doc2) {
		this.emp_doc2 = emp_doc2;
	}

	public String getEmp_doc3() {
		return emp_doc3;
	}

	public void setEmp_doc3(String emp_doc3) {
		this.emp_doc3 = emp_doc3;
	}

	public void setEmp_doc1(String emp_doc1) {
		this.emp_doc1 = emp_doc1;
	}

	
	
	
	
}

