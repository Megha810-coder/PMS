package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="erp_exp_report")
public class Exp_report {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exp_report_id", nullable=false)
	private Integer exp_report_id;
	
	@NotBlank
	@Column(name="exp_report_summary",length=50)
	private String exp_report_summary;
	
	@NotBlank
	@Column(name="exp_report_employee",length=50)
	private String exp_report_employee; 
	
	@NotBlank
	@Column(name="exp_report_manager",length=50)
	private String exp_report_manager;
	
	@Column(name="exp_rprt_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date exp_rprt_create_date;
	
	@Column(name="exp_rprt_create_by", nullable=true)
	private String exp_rprt_create_by;
	
	@Column(name="exp_rprt_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date exp_rprt_update_date;
	
	@Column(name="exp_rprt_update_by", nullable=true)
	private String exp_rprt_update_by;
	
	@Column(name="exp_rprt_active", length=1)
	private Integer exp_rprt_active;

	
	public Integer getExp_report_id() {
		return exp_report_id;
	}

	public void setExp_report_id(Integer exp_report_id) {
		this.exp_report_id = exp_report_id;
	}

	public String getExp_report_summary() {
		return exp_report_summary;
	}

	public void setExp_report_summary(String exp_report_summary) {
		this.exp_report_summary = exp_report_summary;
	}

	public String getExp_report_employee() {
		return exp_report_employee;
	}

	public void setExp_report_employee(String exp_report_employee) {
		this.exp_report_employee = exp_report_employee;
	}

	public String getExp_report_manager() {
		return exp_report_manager;
	}

	public void setExp_report_manager(String exp_report_manager) {
		this.exp_report_manager = exp_report_manager;
	}

	public Date getExp_rprt_create_date() {
		return exp_rprt_create_date;
	}

	public void setExp_rprt_create_date(Date exp_rprt_create_date) {
		this.exp_rprt_create_date = exp_rprt_create_date;
	}

	public String getExp_rprt_create_by() {
		return exp_rprt_create_by;
	}

	public void setExp_rprt_create_by(String exp_rprt_create_by) {
		this.exp_rprt_create_by = exp_rprt_create_by;
	}

	public Date getExp_rprt_update_date() {
		return exp_rprt_update_date;
	}

	public void setExp_rprt_update_date(Date exp_rprt_update_date) {
		this.exp_rprt_update_date = exp_rprt_update_date;
	}

	public String getExp_rprt_update_by() {
		return exp_rprt_update_by;
	}

	public void setExp_rprt_update_by(String exp_rprt_update_by) {
		this.exp_rprt_update_by = exp_rprt_update_by;
	}

	public Integer getExp_rprt_active() {
		return exp_rprt_active;
	}

	public void setExp_rprt_active(Integer exp_rprt_active) {
		this.exp_rprt_active = exp_rprt_active;
	}

	
	
}
