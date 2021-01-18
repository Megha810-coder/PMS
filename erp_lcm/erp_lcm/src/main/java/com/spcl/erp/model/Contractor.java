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
@Entity(name="erp_contractor")

public class Contractor {
	
	

	public Contractor() {}
	public Contractor(int cd_id  , String cd_code , String cd_fname , String cd_mname ,String cd_lname) {
	super();
	this.cd_id = cd_id;
	this.cd_code = cd_code;
	this.cd_fname = cd_fname;
	this.cd_mname = cd_mname;
	this.cd_lname = cd_lname;
   
    
	}
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cd_id;
	

	@Column(name="cd_code",length=15)
	private String cd_code;
	

	@Column(name="cd_title",length=20)
	private String cd_title;
	
	
	@Column(name="cd_fname",length=30)
	private String cd_fname;
	
	
	@Column(name="cd_mname",length=30)
	private String cd_mname;
	

	@Column(name="cd_lname",length=30)
	private String cd_lname;
	

	@Column(name="cd_gender",length=2)
	private Integer cd_gender;
	
	@Column(name="cd_dob")
	
	private String cd_dob;
	
	/*@Column(name="cd_place",length=30)
	private String cd_place;*/
	
	@Column(name="cd_marital_status",length=2)
	private Integer cd_marital_status;
	
	@Column(name="cd_active")
	private Integer cd_active;
	
	@Column(name="cd_img_code", length=20)
	private String cd_img_code;
	
	@Column(name="cd_created_date")
	@Temporal(TemporalType.DATE)
	private Date cd_created_date;
	
	@Column(name="cd_updated_date")
	@Temporal(TemporalType.DATE)
	private Date cd_updated_date;
	
	@Column(name="cd_create_by",length=100)
	private String cd_create_by;
	
	@Column(name="cd_update_by",length=100)
	private String cd_update_by;
	
	@Column(name="cd_mobile_no",length=100)
	private String cd_mobile_no;
	
	@Column(name="corr_line1",length=100)
	private String corr_line1;
	
	@Column(name="corr_line2",length=100)
	private String corr_line2;
	
	@Column(name="cd_city_id",length=100)
	private Integer cd_city_id;
	
	@Column(name="cd_join_date")
	@Temporal(TemporalType.DATE)
	private Date cd_join_date;
	
	@OneToMany(mappedBy="contractor",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	List<Labour> labour;
	
	public List<Labour> getLabour() {
		return labour;
	}

	public void setLabour(List<Labour> labour) {
		this.labour = labour;
	}

	@OneToOne
	private City enq_city;
	
	public City getEnq_city() {
		return enq_city;
	}

	public void setEnq_city(City enq_city) {
		this.enq_city = enq_city;
	}
	
	public Integer getCd_id() {
		return cd_id;
	}

	public void setCd_id(Integer cd_id) {
		this.cd_id = cd_id;
	}

	public String getCd_code() {
		return cd_code;
	}

	public void setCd_code(String cd_code) {
		this.cd_code = cd_code;
	}

	public String getCd_title() {
		return cd_title;
	}

	public void setCd_title(String cd_title) {
		this.cd_title = cd_title;
	}

	public String getCd_fname() {
		return cd_fname;
	}

	public void setCd_fname(String cd_fname) {
		this.cd_fname = cd_fname;
	}

	public String getCd_mname() {
		return cd_mname;
	}

	public void setCd_mname(String cd_mname) {
		this.cd_mname = cd_mname;
	}

	public String getCd_lname() {
		return cd_lname;
	}

	public void setCd_lname(String cd_lname) {
		this.cd_lname = cd_lname;
	}

	public Integer getCd_gender() {
		return cd_gender;
	}

	public void setCd_gender(Integer cd_gender) {
		this.cd_gender = cd_gender;
	}

	public String getCd_dob() {
		return cd_dob;
	}

	public void setCd_dob(String cd_dob) {
		this.cd_dob = cd_dob;
	}

	public Integer getCd_marital_status() {
		return cd_marital_status;
	}

	public void setCd_marital_status(Integer cd_marital_status) {
		this.cd_marital_status = cd_marital_status;
	}

	public Integer getCd_active() {
		return cd_active;
	}

	public void setCd_active(Integer cd_active) {
		this.cd_active = cd_active;
	}

	
	public String getCd_img_code() {
		return cd_img_code;
	}

	public void setCd_img_code(String cd_img_code) {
		this.cd_img_code = cd_img_code;
	}

	public Date getCd_created_date() {
		return cd_created_date;
	}

	public void setCd_created_date(Date cd_created_date) {
		this.cd_created_date = cd_created_date;
	}

	public Date getCd_updated_date() {
		return cd_updated_date;
	}

	public void setCd_updated_date(Date cd_updated_date) {
		this.cd_updated_date = cd_updated_date;
	}

	public String getCd_create_by() {
		return cd_create_by;
	}

	public void setCd_create_by(String cd_create_by) {
		this.cd_create_by = cd_create_by;
	}

	public String getCd_update_by() {
		return cd_update_by;
	}

	public void setCd_update_by(String cd_update_by) {
		this.cd_update_by = cd_update_by;
	}

	public String getCd_mobile_no() {
		return cd_mobile_no;
	}

	public void setCd_mobile_no(String cd_mobile_no) {
		this.cd_mobile_no = cd_mobile_no;
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

	public Integer getCd_city_id() {
		return cd_city_id;
	}

	public void setCd_city_id(Integer cd_city_id) {
		this.cd_city_id = cd_city_id;
	}

	public Date getCd_join_date() {
		return cd_join_date;
	}

	public void setCd_join_date(Date cd_join_date) {
		this.cd_join_date = cd_join_date;
	}

	

		
}

	

