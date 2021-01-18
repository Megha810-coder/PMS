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

@Entity(name="erp_enquiry_request")
public class Com_Enquiry {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enq_id", nullable=false,length=3)
	private Integer enq_id;
	
	@NotEmpty
	@Column(name="enq_name", nullable=false,length=100)
	private String enq_name;
	
	@Column(name="enq_company_name",length=100)
	private String enq_company_name;
	
	@Column(name="enq_email", nullable=true,length=100)
	private String enq_email;
	
	@Column(name="enq_contact_id",length=10)
	private Integer enq_contact_id;
	
	@Column(name="enq_post_id",length=10)
	private Integer enq_post_id;
	
	@Column(name="enq_description", nullable=true)
	private String enq_description;
	
	@Column(name="enq_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date enq_date;
	
	@OneToOne
	private Country enq_cuntry;

	public Integer getEnq_id() {
		return enq_id;
	}

	public void setEnq_id(Integer enq_id) {
		this.enq_id = enq_id;
	}

	public String getEnq_name() {
		return enq_name;
	}

	public void setEnq_name(String enq_name) {
		this.enq_name = enq_name;
	}

	public String getEnq_company_name() {
		return enq_company_name;
	}

	public void setEnq_company_name(String enq_company_name) {
		this.enq_company_name = enq_company_name;
	}

	public Integer getEnq_post_id() {
		return enq_post_id;
	}

	public void setEnq_post_id(Integer enq_post_id) {
		this.enq_post_id = enq_post_id;
	}

	public String getEnq_email() {
		return enq_email;
	}

	public void setEnq_email(String enq_email) {
		this.enq_email = enq_email;
	}

	public Country getEnq_cuntry() {
		return enq_cuntry;
	}

	public void setEnq_cuntry(Country enq_cuntry) {
		this.enq_cuntry = enq_cuntry;
	}

	public Integer getEnq_contact_id() {
		return enq_contact_id;
	}

	public void setEnq_contact_id(Integer enq_contact_id) {
		this.enq_contact_id = enq_contact_id;
	}

	public String getEnq_description() {
		return enq_description;
	}

	public void setEnq_description(String enq_description) {
		this.enq_description = enq_description;
	}

	public Date getEnq_date() {
		return enq_date;
	}

	public void setEnq_date(Date enq_date) {
		this.enq_date = enq_date;
	}

	
	
	
}
