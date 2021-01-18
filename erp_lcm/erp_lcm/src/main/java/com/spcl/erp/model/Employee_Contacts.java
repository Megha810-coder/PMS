package com.spcl.erp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity(name="erp_emp_contact")
public class Employee_Contacts {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer emp_cont_id;
	
	@Column(name="emp_mobile_no",length=100)
	private String emp_mobile_no;
	
	@Column(name="emp_cntry_code_for_mob",length=10)
	private String emp_cntry_code_for_mob;
	
	@Column(name="emp_alt_mobile_no",length=100)
	private String emp_alt_mobile_no;
	
	@Column(name="emp_alt_cntry_code_for_mob",length=10)
	private String emp_alt_cntry_code_for_mob;
	
	@Column(name="emp_landline_no",length=100)
	private String emp_landline_no;
		
	@Column(name="emp_email",length=100)
	private String emp_email;

	@Column(name="emp_alt_email",length=100)
	private String emp_alt_email;
	
	@Column(name="emp_twitter_link",length=100)
	private String emp_twitter_link;
	
	@Column(name="emp_facebook_link",length=100)
	private String emp_facebook_link;
	
	@Column(name="emp_instagram_link",length=100)
	private String emp_instagram_link;
	
	@Column(name="emp_blog_link",length=100)
	private String emp_blog_link;
	
	@Column(name="emp_website",length=100)
	private String emp_website;
	
	@OneToOne
	@JoinColumn(name="emp_id", nullable=false)
	private Employee employee_contact;
	
	@OneToMany(mappedBy="emp_contact",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Address> address_list;

	public Integer getEmp_cont_id() {
		return emp_cont_id;
	}

	public void setEmp_cont_id(Integer emp_cont_id) {
		this.emp_cont_id = emp_cont_id;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_alt_email() {
		return emp_alt_email;
	}

	public void setEmp_alt_email(String emp_alt_email) {
		this.emp_alt_email = emp_alt_email;
	}

	public String getEmp_twitter_link() {
		return emp_twitter_link;
	}

	public void setEmp_twitter_link(String emp_twitter_link) {
		this.emp_twitter_link = emp_twitter_link;
	}

	public String getEmp_facebook_link() {
		return emp_facebook_link;
	}

	public void setEmp_facebook_link(String emp_facebook_link) {
		this.emp_facebook_link = emp_facebook_link;
	}

	public String getEmp_instagram_link() {
		return emp_instagram_link;
	}

	public void setEmp_instagram_link(String emp_instagram_link) {
		this.emp_instagram_link = emp_instagram_link;
	}

	public String getEmp_blog_link() {
		return emp_blog_link;
	}

	public void setEmp_blog_link(String emp_blog_link) {
		this.emp_blog_link = emp_blog_link;
	}

	public String getEmp_website() {
		return emp_website;
	}

	public void setEmp_website(String emp_website) {
		this.emp_website = emp_website;
	}

	public Employee getEmployee_contact() {
		return employee_contact;
	}

	public void setEmployee_contact(Employee employee_contact) {
		this.employee_contact = employee_contact;
	}

	public List<Address> getAddress_list() {
		return address_list;
	}

	public void setAddress_list(List<Address> address_list) {
		this.address_list = address_list;
	}

	public String getEmp_mobile_no() {
		return emp_mobile_no;
	}

	public void setEmp_mobile_no(String emp_mobile_no) {
		this.emp_mobile_no = emp_mobile_no;
	}

	public String getEmp_cntry_code_for_mob() {
		return emp_cntry_code_for_mob;
	}

	public void setEmp_cntry_code_for_mob(String emp_cntry_code_for_mob) {
		this.emp_cntry_code_for_mob = emp_cntry_code_for_mob;
	}

	public String getEmp_alt_mobile_no() {
		return emp_alt_mobile_no;
	}

	public void setEmp_alt_mobile_no(String emp_alt_mobile_no) {
		this.emp_alt_mobile_no = emp_alt_mobile_no;
	}

	public String getEmp_alt_cntry_code_for_mob() {
		return emp_alt_cntry_code_for_mob;
	}

	public void setEmp_alt_cntry_code_for_mob(String emp_alt_cntry_code_for_mob) {
		this.emp_alt_cntry_code_for_mob = emp_alt_cntry_code_for_mob;
	}

	public String getEmp_landline_no() {
		return emp_landline_no;
	}

	public void setEmp_landline_no(String emp_landline_no) {
		this.emp_landline_no = emp_landline_no;
	}
	
	

}
