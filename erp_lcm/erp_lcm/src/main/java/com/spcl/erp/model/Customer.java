package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_customer")
public class Customer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cust_id;
	
	@Column(name="cust_type", nullable=false,length=2)
	private Integer cust_type;
	
	@Column(name="cust_title", nullable=true,length=10)
	private String cust_title;
	
	@NotEmpty
	@Column(name="cust_fname", nullable=false,length=50)
	private String cust_fname;

	@Column(name="cust_mname", nullable=true,length=50)
	private String cust_mname;
	
	@NotEmpty
	@Column(name="cust_lname", nullable=false,length=50)
	private String cust_lname;
	
	@Column(name="cust_comp_name", nullable=true,length=100)
	private String cust_comp_name;
	
	@NotEmpty
	@Column(name="cust_phone", nullable=false,length=20)
	private String cust_phone;
	
	@NotEmpty
	@Column(name="cust_email", nullable=false,length=100)
	private String cust_email;
	
	@Column(name="cust_website", nullable=true,length=100)
	private String cust_website;
	
	@NotEmpty
	@Column(name="cust_gst_no", nullable=false,length=30)
	private String cust_gst_no;
	
	@Column(name="cust_job_position_id",length=5)
	private Integer cust_job_position_id;
	
	@Column(name="cust_cust",length=2)
	private Integer cust_cust;
	
	@Column(name="cust_vendor",length=2)
	private Integer cust_vendor;
	
	@Column(name="cust_description", nullable=true)
	private String cust_description;
	
	@Column(name="cust_adds_line1", nullable=true)
	private String cust_adds_line1;
	
	@Column(name="cust_adds_line2", nullable=true)
	private String cust_adds_line2;
	
	@Column(name="cust_addr_id")
	private Integer cust_addr_id;
	
	@Column(name="cust_city_id",length=5)
	private Integer cust_city_id;
	
	@Column(name="cust_saleperson_id",length=3)
	private Integer cust_saleperson_id;
	
	@Column(name="cust_bank_id",length=3)
	private Integer cust_bank_id;
	
	@Column(name="cust_active",nullable=false,length=2)
	private Integer cust_active;
	
	@Column(name="cust_payment_term_id ",length=5)
	private Integer cust_payment_term_id ;
	
	@Column(name="cust_vend_payment_term",length=5)
	private Integer cust_vend_payment_term;
	
	@Column(name="cust_acc_pay_id",length=5)
	private Integer cust_acc_pay_id;
	
	@Column(name="cust_acc_due_id",length=5)
	private Integer cust_acc_due_id;
		
	@Column(name="cust_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date cust_create_date;
	
	@Column(name="cust_create_by", nullable=true)
	private String cust_create_by;
	
	@Column(name="cust_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date cust_update_date;
	
	@Column(name="cust_update_by", nullable=true)
	private String cust_update_by;
	
	@Column(name="cust_img_code", length=20)
	private String cust_img_code;
	
	@OneToOne
	private City enq_city;

	public City getEnq_city() {
		return enq_city;
	}

	public void setEnq_city(City enq_city) {
		this.enq_city = enq_city;
	}

	public String getCust_img_code() {
		return cust_img_code;
	}

	public void setCust_img_code(String cust_img_code) {
		this.cust_img_code = cust_img_code;
	}

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	
	public Integer getCust_type() {
		return cust_type;
	}

	public void setCust_type(Integer cust_type) {
		this.cust_type = cust_type;
	}
	
	public String getCust_title() {
		return cust_title;
	}

	public void setCust_title(String cust_title) {
		this.cust_title = cust_title;
	}

	public String getCust_fname() {
		return cust_fname;
	}

	public void setCust_fname(String cust_fname) {
		this.cust_fname = cust_fname;
	}

	public String getCust_mname() {
		return cust_mname;
	}

	public void setCust_mname(String cust_mname) {
		this.cust_mname = cust_mname;
	}

	public String getCust_lname() {
		return cust_lname;
	}

	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}
	
	public String getCust_comp_name() {
		return cust_comp_name;
	}

	public void setCust_comp_name(String cust_comp_name) {
		this.cust_comp_name = cust_comp_name;
	}
	
	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_gst_no() {
		return cust_gst_no;
	}

	public void setCust_gst_no(String cust_gst_no) {
		this.cust_gst_no = cust_gst_no;
	}

	public String getCust_description() {
		return cust_description;
	}

	public void setCust_description(String cust_description) {
		this.cust_description = cust_description;
	}

	public Integer getCust_cust() {
		return cust_cust;
	}

	public void setCust_cust(Integer cust_cust) {
		this.cust_cust = cust_cust;
	}

	public Integer getCust_vendor() {
		return cust_vendor;
	}

	public void setCust_vendor(Integer cust_vendor) {
		this.cust_vendor = cust_vendor;
	}

	public Integer getCust_saleperson_id() {
		return cust_saleperson_id;
	}

	public void setCust_saleperson_id(Integer cust_saleperson_id) {
		this.cust_saleperson_id = cust_saleperson_id;
	}

	public Integer getCust_bank_id() {
		return cust_bank_id;
	}

	public void setCust_bank_id(Integer cust_bank_id) {
		this.cust_bank_id = cust_bank_id;
	}

	public Date getCust_create_date() {
		return cust_create_date;
	}

	public void setCust_create_date(Date cust_create_date) {
		this.cust_create_date = cust_create_date;
	}

	public String getCust_create_by() {
		return cust_create_by;
	}

	public void setCust_create_by(String cust_create_by) {
		this.cust_create_by = cust_create_by;
	}

	public Date getCust_update_date() {
		return cust_update_date;
	}

	public void setCust_update_date(Date cust_update_date) {
		this.cust_update_date = cust_update_date;
	}

	public String getCust_update_by() {
		return cust_update_by;
	}

	public void setCust_update_by(String cust_update_by) {
		this.cust_update_by = cust_update_by;
	}

	public Integer getCust_active() {
		return cust_active;
	}

	public void setCust_active(Integer cust_active) {
		this.cust_active = cust_active;
	}

	public String getCust_website() {
		return cust_website;
	}

	public void setCust_website(String cust_website) {
		this.cust_website = cust_website;
	}

	public Integer getCust_job_position_id() {
		return cust_job_position_id;
	}

	public void setCust_job_position_id(Integer cust_job_position_id) {
		this.cust_job_position_id = cust_job_position_id;
	}

	public String getCust_adds_line1() {
		return cust_adds_line1;
	}

	public void setCust_adds_line1(String cust_adds_line1) {
		this.cust_adds_line1 = cust_adds_line1;
	}

	public String getCust_adds_line2() {
		return cust_adds_line2;
	}

	public void setCust_adds_line2(String cust_adds_line2) {
		this.cust_adds_line2 = cust_adds_line2;
	}

	public Integer getCust_city_id() {
		return cust_city_id;
	}

	public void setCust_city_id(Integer cust_city_id) {
		this.cust_city_id = cust_city_id;
	}

	public Integer getCust_payment_term_id() {
		return cust_payment_term_id;
	}

	public void setCust_payment_term_id(Integer cust_payment_term_id) {
		this.cust_payment_term_id = cust_payment_term_id;
	}

	public Integer getCust_vend_payment_term() {
		return cust_vend_payment_term;
	}

	public void setCust_vend_payment_term(Integer cust_vend_payment_term) {
		this.cust_vend_payment_term = cust_vend_payment_term;
	}

	public Integer getCust_acc_pay_id() {
		return cust_acc_pay_id;
	}

	public void setCust_acc_pay_id(Integer cust_acc_pay_id) {
		this.cust_acc_pay_id = cust_acc_pay_id;
	}

	public Integer getCust_acc_due_id() {
		return cust_acc_due_id;
	}

	public void setCust_acc_due_id(Integer cust_acc_due_id) {
		this.cust_acc_due_id = cust_acc_due_id;
	}

	public Integer getCust_addr_id() {
		return cust_addr_id;
	}

	public void setCust_addr_id(Integer cust_addr_id) {
		this.cust_addr_id = cust_addr_id;
	}
}
