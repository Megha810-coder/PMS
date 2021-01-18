package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spcl.erp.helper.Helper;

@Entity(name="erp_education")

public class Employee_Education {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer edu_id;
	
	@Column(name="edu_certificate")
	private Integer edu_certificate;
	
	@Column(name="edu_university", length=50)
	private String edu_university;
	
	@Column(name="edu_passing_year",length=10)
	private String edu_passing_year;
	
	@Column(name="edu_degree",length=50)
	private Integer edu_degree;
	
	@ManyToOne
	@JoinColumn(name="emp_id", nullable=false)
	private Employee employee;
	
	
	public Employee_Education() {
		this.edu_certificate=new Integer(0);
		this.edu_university="";
		this.edu_passing_year="";
		this.edu_degree=new Integer(0);
	}
		
	public String getCrtificateText(Helper helper) {
		if (edu_certificate==null) {
			return "Not Set";
		}
		String text=helper.get_Certificate_list().get(edu_certificate.toString());
		
		return text;
	}
	
	public String getDegreeText(Helper helper) {
		if (edu_certificate==null) {
			return "Not Set";
		}
		String text=helper.get_Degree_list().get(edu_degree.toString());
		
		return text;
	}



	public Integer getEdu_id() {
		return edu_id;
	}



	public void setEdu_id(Integer edu_id) {
		this.edu_id = edu_id;
	}



	public Integer getEdu_certificate() {
		return edu_certificate;
	}



	public void setEdu_certificate(Integer edu_certificate) {
		this.edu_certificate = edu_certificate;
	}



	public String getEdu_university() {
		return edu_university;
	}



	public void setEdu_university(String edu_university) {
		this.edu_university = edu_university;
	}


	public String getEdu_passing_year() {
		return edu_passing_year;
	}

	public void setEdu_passing_year(String edu_passing_year) {
		this.edu_passing_year = edu_passing_year;
	}

	public Integer getEdu_degree() {
		return edu_degree;
	}


	public void setEdu_degree(Integer edu_degree) {
		this.edu_degree = edu_degree;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	
}
