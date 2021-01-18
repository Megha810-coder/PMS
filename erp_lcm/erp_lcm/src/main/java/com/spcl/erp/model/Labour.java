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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
@Entity(name="erp_labour")

public class Labour {

	public Labour() {}
	public Labour(int lab_id, String lab_code, String lab_fname, String lab_mname,String lab_lname,String lab_mobile_no,String lab_dob) {
	super();
	this.lab_id = lab_id;
	this.lab_code = lab_code;
	this.lab_fname = lab_fname;
	this.lab_mname = lab_mname;
	this.lab_lname = lab_lname;
    this.lab_mobile_no = lab_mobile_no;
    this.lab_dob = lab_dob;
    
	}

	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer lab_id;
	
	
	@Column(name="lab_code",length=15)
	private String lab_code;
	

	@Column(name="lab_title",length=20)
	private String lab_title;
	
	
	@Column(name="lab_fname",length=30)
	private String lab_fname;
	
	
	@Column(name="lab_mname",length=30)
	private String lab_mname;
	

	@Column(name="lab_lname",length=30)
	private String lab_lname;
	
	
	@Column(name="lab_gender",length=2)
	private String lab_gender;
	
	@Column(name="lab_dob")
	private String lab_dob;
	
	/*@Column(name="lab_place",length=30)
	private String lab_place;*/
	
	@Column(name="lab_marital_status",length=2)
	private String lab_marital_status;
	
	@Column(name="lab_active")
	private Integer lab_active;
	
	
	
	@Column(name="lab_img_code", length=20)
	private String lab_img_code;
	
	@Column(name="lab_created_date")
	@Temporal(TemporalType.DATE)
	private Date lab_created_date;
	
	@Column(name="lab_updated_date")
	@Temporal(TemporalType.DATE)
	private Date lab_updated_date;
	
	@Column(name="lab_create_by",length=100)
	private String lab_create_by;
	
	@Column(name="lab_update_by",length=100)
	private String lab_update_by;
	
	@Column(name="lab_mobile_no",length=100)
	private String lab_mobile_no;
	
	@Column(name="corr_line1",length=100)
	private String corr_line1;
	
	@Column(name="corr_line2",length=100)
	private String corr_line2;
	
	@Column(name="lab_city_id",length=100)
	private String lab_city_id;
	
	@Column(name="con_name",length=100)
	private String con_name;
	
	public String getCon_name() {
		return con_name;
	}
	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}

	@Column(name="lab_join_date")
	private String lab_join_date;

	public Integer getLab_salary() {
		return lab_salary;
	}

	public void setLab_salary(Integer lab_salary) {
		this.lab_salary = lab_salary;
	}

	@Column(name="lab_salary",length=100)
	private Integer lab_salary;
	
	
	@OneToOne
	private Department_type department;
	
	
	
	@OneToOne
	private City enq_city;
	
	@ManyToOne
	@JoinColumn(name="cd_id")
	private Contractor contractor;
	
	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public City getEnq_city() {
		return enq_city;
	}

	public void setEnq_city(City enq_city) {
		this.enq_city = enq_city;
	}

	public Department_type getDepartment() {
		return department;
	}

	public void setDepartment(Department_type department) {
		this.department = department;
	}

	public Integer getLab_id() {
		return lab_id;
	}

	public void setLab_id(Integer lab_id) {
		this.lab_id = lab_id;
	}

	public String getLab_code() {
		return lab_code;
	}

	public void setLab_code(String lab_code) {
		this.lab_code = lab_code;
	}

	public String getLab_title() {
		return lab_title;
	}

	public void setLab_title(String lab_title) {
		this.lab_title = lab_title;
	}

	public String getLab_fname() {
		return lab_fname;
	}

	public void setLab_fname(String lab_fname) {
		this.lab_fname = lab_fname;
	}

	public String getLab_mname() {
		return lab_mname;
	}

	public void setLab_mname(String lab_mname) {
		this.lab_mname = lab_mname;
	}

	public String getLab_lname() {
		return lab_lname;
	}

	public void setLab_lname(String lab_lname) {
		this.lab_lname = lab_lname;
	}

	public String getLab_gender() {
		return lab_gender;
	}

	public void setLab_gender(String lab_gender) {
		this.lab_gender = lab_gender;
	}

	public String getLab_dob() {
		return lab_dob;
	}

	public void setLab_dob(String lab_dob) {
		this.lab_dob = lab_dob;
	}

	/*public String getLab_place() {
		return lab_place;
	}

	public void setLab_place(String lab_place) {
		this.lab_place = lab_place;
	}

	*/

	public String getLab_marital_status() {
		return lab_marital_status;
	}

	public void setLab_marital_status(String lab_marital_status) {
		this.lab_marital_status = lab_marital_status;
	}

	public Integer getLab_active() {
		return lab_active;
	}

	public void setLab_active(Integer lab_active) {
		this.lab_active = lab_active;
	}

	public String getLab_img_code() {
		return lab_img_code;
	}

	public void setLab_img_code(String lab_img_code) {
		this.lab_img_code = lab_img_code;
	}

	public Date getLab_created_date() {
		return lab_created_date;
	}

	public void setLab_created_date(Date lab_created_date) {
		this.lab_created_date = lab_created_date;
	}

	public Date getLab_updated_date() {
		return lab_updated_date;
	}

	public void setLab_updated_date(Date lab_updated_date) {
		this.lab_updated_date = lab_updated_date;
	}

	public String getLab_create_by() {
		return lab_create_by;
	}

	public void setLab_create_by(String lab_create_by) {
		this.lab_create_by = lab_create_by;
	}

	public String getLab_update_by() {
		return lab_update_by;
	}

	public void setLab_update_by(String lab_update_by) {
		this.lab_update_by = lab_update_by;
	}

	public String getLab_mobile_no() {
		return lab_mobile_no;
	}

	public void setLab_mobile_no(String lab_mobile_no) {
		this.lab_mobile_no = lab_mobile_no;
	}

	public String getCorr_line1() {
		return corr_line1;
	}

	public void setCorr_line1(String corr_line1) {
		this.corr_line1 = corr_line1;
	}

	public String getCorr_line2() {
		return corr_line2;
	}

	public void setCorr_line2(String corr_line2) {
		this.corr_line2 = corr_line2;
	}
	
	public String getLab_city_id() {
		return lab_city_id;
	}

	public void setLab_city_id(String lab_city_id) {
		this.lab_city_id = lab_city_id;
	}

	public String getLab_join_date() {
		return lab_join_date;
	}

	public void setLab_join_date(String lab_join_date) {
		this.lab_join_date = lab_join_date;
	}

		
}

	

