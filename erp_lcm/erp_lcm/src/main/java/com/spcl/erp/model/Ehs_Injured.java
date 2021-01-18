package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="erp_injured")
public class Ehs_Injured {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="injured_id", nullable=false)
	private Integer injured_id;
	
	
	@Column(name="injured_name",length=100)
	private String injured_name ;
	
	
	@Column(name="injured_org_unit",length=100)
	private String injured_org_unit ;
	
	
	@Column(name="injured_address",length=100)
	private String injured_address ;
	
	@Column(name="injured_email",length=100)
	private String injured_email ;
	
	@Column(name="injured_phone",length=100)
	private String injured_phone ;
	
	@Column(name="injury",length=100)
	private String injury ;
		
	@Column(name="injured_create_date")
	@Temporal(TemporalType.DATE)
	private Date injured_create_date;
	
	
	@Column(name="injured_create_by")
	private String injured_create_by;
	
	
	@Column(name="injured_update_date")
	@Temporal(TemporalType.DATE)
	private Date injured_update_date;
	
	@Column(name="injured_update_by")
	private String injured_update_by;
		
	@Column(name="injured_active")
	private Integer injured_active;

	
	@OneToOne
	@JoinColumn(name="action_id")
	private Ehs_Action ehs_action;
	
	
	public Ehs_Action getEhs_action() {
		return ehs_action;
	}

	public void setEhs_action(Ehs_Action ehs_action) {
		this.ehs_action = ehs_action;
	}

	public Integer getInjured_id() {
		return injured_id;
	}

	public void setInjured_id(Integer injured_id) {
		this.injured_id = injured_id;
	}

	public String getInjured_name() {
		return injured_name;
	}

	public void setInjured_name(String injured_name) {
		this.injured_name = injured_name;
	}

	public String getInjured_org_unit() {
		return injured_org_unit;
	}

	public void setInjured_org_unit(String injured_org_unit) {
		this.injured_org_unit = injured_org_unit;
	}

	public String getInjured_address() {
		return injured_address;
	}

	public void setInjured_address(String injured_address) {
		this.injured_address = injured_address;
	}

	public String getInjured_email() {
		return injured_email;
	}

	public void setInjured_email(String injured_email) {
		this.injured_email = injured_email;
	}

	public String getInjured_phone() {
		return injured_phone;
	}

	public void setInjured_phone(String injured_phone) {
		this.injured_phone = injured_phone;
	}

	public String getInjury() {
		return injury;
	}

	public void setInjury(String injury) {
		this.injury = injury;
	}

	

	public Date getInjured_create_date() {
		return injured_create_date;
	}

	public void setInjured_create_date(Date injured_create_date) {
		this.injured_create_date = injured_create_date;
	}

	public String getInjured_create_by() {
		return injured_create_by;
	}

	public void setInjured_create_by(String injured_create_by) {
		this.injured_create_by = injured_create_by;
	}

	public Date getInjured_update_date() {
		return injured_update_date;
	}

	public void setInjured_update_date(Date injured_update_date) {
		this.injured_update_date = injured_update_date;
	}

	public String getInjured_update_by() {
		return injured_update_by;
	}

	public void setInjured_update_by(String injured_update_by) {
		this.injured_update_by = injured_update_by;
	}

	public Integer getInjured_active() {
		return injured_active;
	}

	public void setInjured_active(Integer injured_active) {
		this.injured_active = injured_active;
	}

}
