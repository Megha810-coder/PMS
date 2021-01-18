package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_state")
public class State {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="state_id", nullable=false,length=3)
	private Integer state_id;
	
	@NotEmpty
	@Column(name="state_name", nullable=false,length=100)
	private String state_name;
	
	@OneToOne
	private Country erp_cuntry;
	
	public Country getErp_cuntry() {
		return erp_cuntry;
	}

	public void setErp_cuntry(Country erp_cuntry) {
		this.erp_cuntry = erp_cuntry;
	}

	public Integer getState_id() {
		return state_id;
	}

	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
		
}
