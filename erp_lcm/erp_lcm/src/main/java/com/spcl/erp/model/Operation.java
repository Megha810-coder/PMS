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

@Entity(name="erp_operation")
public class Operation {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer opt_id;
	
	
	@NotEmpty
	@Column(name="operation", nullable=false)
	private String operation;
	
	@Column(name="opt_type")
	private Integer opt_type;
	
	@Column(name="opt_refer_sequ")
	private Integer opt_refer_sequ;
	
	@Column(name="opt_active")
	private Integer opt_active;
	
	@Column(name="opt_create_date")
	@Temporal(TemporalType.DATE)
	private Date opt_create_date;
	
	@Column(name="opt_create_by")
	private String  opt_create_by;
	
	@Column(name="opt_update_date")
	@Temporal(TemporalType.DATE)
	private Date opt_update_date;
	
	@Column(name="opt_update_by")
	private String opt_update_by;
	
	

	public Integer getOpt_id() {
		return opt_id;
	}

	public void setOpt_id(Integer opt_id) {
		this.opt_id = opt_id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Integer getOpt_type() {
		return opt_type;
	}

	public void setOpt_type(Integer opt_type) {
		this.opt_type = opt_type;
	}

	public Integer getOpt_refer_sequ() {
		return opt_refer_sequ;
	}

	public void setOpt_refer_sequ(Integer opt_refer_sequ) {
		this.opt_refer_sequ = opt_refer_sequ;
	}

	public Integer getOpt_active() {
		return opt_active;
	}

	public void setOpt_active(Integer opt_active) {
		this.opt_active = opt_active;
	}

	public Date getOpt_create_date() {
		return opt_create_date;
	}

	public void setOpt_create_date(Date opt_create_date) {
		this.opt_create_date = opt_create_date;
	}

	public String getOpt_create_by() {
		return opt_create_by;
	}

	public void setOpt_create_by(String opt_create_by) {
		this.opt_create_by = opt_create_by;
	}

	public Date getOpt_update_date() {
		return opt_update_date;
	}

	public void setOpt_update_date(Date opt_update_date) {
		this.opt_update_date = opt_update_date;
	}

	public String getOpt_update_by() {
		return opt_update_by;
	}

	public void setOpt_update_by(String opt_update_by) {
		this.opt_update_by = opt_update_by;
	}
	
}
