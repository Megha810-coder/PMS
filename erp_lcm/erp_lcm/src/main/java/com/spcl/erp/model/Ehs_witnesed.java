package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;
@Entity(name="erp_witnesed")
public class Ehs_witnesed
{
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="witnesed_id")
	private Integer witnesed_id;

	@Column(name="witness_name",length=100)
	private String witness_name ;
	
	
	@Column(name="witness_org_unit",length=100)
	private String witness_org_unit ;
	
	@ManyToOne
	@JoinColumn(name="action_id")
	private Ehs_Action ehs_action;	
	
	public Ehs_Action getEhs_action() {
		return ehs_action;
	}

	public void setEhs_action(Ehs_Action ehs_action) {
		this.ehs_action = ehs_action;
	}

	public Integer getWitnesed_id() {
		return witnesed_id;
	}

	public void setWitnesed_id(Integer witnesed_id) {
		this.witnesed_id = witnesed_id;
	}

	public String getWitness_name() {
		return witness_name;
	}

	public void setWitness_name(String witness_name) {
		this.witness_name = witness_name;
	}

	public String getWitness_org_unit() {
		return witness_org_unit;
	}

	public void setWitness_org_unit(String witness_org_unit) {
		this.witness_org_unit = witness_org_unit;
	}

	public String getWitness_email() {
		return witness_email;
	}

	public void setWitness_email(String witness_email) {
		this.witness_email = witness_email;
	}

	public String getWitness_phone() {
		return witness_phone;
	}

	public void setWitness_phone(String witness_phone) {
		this.witness_phone = witness_phone;
	}


	@Column(name="witness_email",length=100)
	private String witness_email ;
	
	
	@Column(name="witness_phone",length=100)
	private String witness_phone ;
}
