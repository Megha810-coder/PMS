package com.spcl.erp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
@Entity(name="erp_employee")

public class Employee {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer emp_id;
	
	@NotEmpty
	@Column(name="emp_code", nullable=false,length=15)
	private String emp_code;
	
	@NotEmpty
	@Column(name="emp_title", nullable=false,length=20)
	private String emp_title;
	
	@NotEmpty
	@Column(name="emp_fname", nullable=false,length=30)
	private String emp_fname;
	
	@NotEmpty
	@Column(name="emp_mname", nullable=true,length=30)
	private String emp_mname;
	
	@NotEmpty
	@Column(name="emp_lname", nullable=false,length=30)
	private String emp_lname;
	
	@NotNull
	@Column(name="emp_gender",length=2)
	private Integer emp_gender;
	
	@Column(name="emp_dob", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date emp_dob;
	
	@Column(name="emp_place", nullable=false,length=30)
	private String emp_place;
	
	@Column(name="emp_marital_status", nullable=true,length=2)
	private Integer emp_marital_status;
	
	@Column(name="emp_active",nullable=false)
	private Integer emp_active;
	
	@Column(name="emp_img_code", length=20)
	private String emp_img_code;
	
	@Column(name="emp_created_date",nullable=true)
	@Temporal(TemporalType.DATE)
	private Date emp_created_date;
	
	@Column(name="emp_updated_date",nullable=true)
	@Temporal(TemporalType.DATE)
	private Date emp_updated_date;
	
	@Column(name="emp_create_by", nullable=true,length=100)
	private String cust_create_by;
	
	@Column(name="emp_update_by", nullable=true,length=100)
	private String cust_update_by;
	
	@OneToMany(mappedBy="employee",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Employee_Education> education_list;
	
	@OneToOne(mappedBy="employee_contact",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Employee_Contacts contacts;
	
	@OneToOne(mappedBy="employee",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Account account;
	
	@OneToOne(mappedBy="employee_company",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Employee_Company company;
	
	@OneToMany(mappedBy="employee",fetch=FetchType.EAGER,cascade =CascadeType.ALL)
	@Fetch(value =FetchMode.SUBSELECT)
	private List<Employee_Work> work_list;
	
	public Employee_Company getCompany() {
		return company;
	}


	public void setCompany(Employee_Company company) {
		this.company = company;
	}


	public List<Employee_Work> getWork_list() {
		return work_list;
	}


	public void setWork_list(List<Employee_Work> work_list) {
		this.work_list = work_list;
	}


	public List<Employee_Document> getDocument_list() {
		return document_list;
	}


	public void setDocument_list(List<Employee_Document> document_list) {
		this.document_list = document_list;
	}

	@OneToMany(mappedBy="employee",fetch=FetchType.EAGER,cascade =CascadeType.ALL)
	@Fetch(value =FetchMode.SUBSELECT)
	private List<Employee_Document> document_list;
	
	public Employee_Contacts getContacts() {
		return contacts;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public void setContacts(Employee_Contacts contacts) {
		this.contacts = contacts;
	}


	public Employee() {
		this.emp_active=new Integer(1);
		this.emp_gender=new Integer(0);
		this.emp_marital_status=new Integer(0);
	}
	

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmp_title() {
		return emp_title;
	}

	public void setEmp_title(String emp_title) {
		this.emp_title = emp_title;
	}

	public String getEmp_fname() {
		return emp_fname;
	}

	public void setEmp_fname(String emp_fname) {
		this.emp_fname = emp_fname;
	}

	public String getEmp_mname() {
		return emp_mname;
	}

	public void setEmp_mname(String emp_mname) {
		this.emp_mname = emp_mname;
	}

	public String getEmp_lname() {
		return emp_lname;
	}

	public void setEmp_lname(String emp_lname) {
		this.emp_lname = emp_lname;
	}

	public Integer getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(Integer emp_gender) {
		this.emp_gender = emp_gender;
	}

	public Date getEmp_dob() {
		return emp_dob;
	}

	public void setEmp_dob(Date emp_dob) {
		this.emp_dob = emp_dob;
	}

	public String getEmp_place() {
		return emp_place;
	}

	public void setEmp_place(String emp_place) {
		this.emp_place = emp_place;
	}

	public Integer getEmp_marital_status() {
		return emp_marital_status;
	}

	public void setEmp_marital_status(Integer emp_marital_status) {
		this.emp_marital_status = emp_marital_status;
	}

	public Integer getEmp_active() {
		return emp_active;
	}

	public void setEmp_active(Integer emp_active) {
		this.emp_active = emp_active;
	}

	public Date getEmp_created_date() {
		return emp_created_date;
	}

	public void setEmp_created_date(Date emp_created_date) {
		this.emp_created_date = emp_created_date;
	}

	public Date getEmp_updated_date() {
		return emp_updated_date;
	}

	public void setEmp_updated_date(Date emp_updated_date) {
		this.emp_updated_date = emp_updated_date;
	}

	public String getCust_create_by() {
		return cust_create_by;
	}

	public void setCust_create_by(String cust_create_by) {
		this.cust_create_by = cust_create_by;
	}

	public String getCust_update_by() {
		return cust_update_by;
	}

	public void setCust_update_by(String cust_update_by) {
		this.cust_update_by = cust_update_by;
	}
	
	public String getEmp_img_code() {
		return emp_img_code;
	}

	public void setEmp_img_code(String emp_img_code) {
		this.emp_img_code = emp_img_code;
	}

	public List<Employee_Education> getEducation_list() {
		return education_list;
	}

	public void setEducation_list(List<Employee_Education> education_list) {
		this.education_list = education_list;
	}
		
	
}

	

