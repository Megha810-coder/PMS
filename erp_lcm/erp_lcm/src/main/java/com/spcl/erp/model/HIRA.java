package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="erp_hira")
public class HIRA {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hira_id", nullable=false)
	private Integer hira_id;
	
	@Column(name="sr_no")
	private Integer sr_no ;
	
	@Column(name="activity")
	private String activity ;
	
	@Column(name="total_rating")
	private Integer total_rating ;
	
	@Column(name="legal")
	private Integer legal ;
	
	@Column(name="land")
	private String land ;
	
	@Column(name="air")
	private String air ;

	@Column(name="water")
	private String water ;

	@Column(name="human")
	private String human  ;

	@Column(name="resource")
	private String  resource;
	
	@Column(name="land1")
	private Integer land1 ;
	
	@Column(name="air1")
	private Integer air1 ;

	@Column(name="water1")
	private Integer water1 ;

	@Column(name="human1")
	private Integer human1  ;

	@Column(name="resource1")
	private Integer  resource1;

	@Column(name="impact_rating")
	private Integer impact_rating ;

	@Column(name="frequency")
	private Integer frequency ;
	
	@Column(name="hira_active")
	private Integer hira_active;

	public Integer getHira_id() {
		return hira_id;
	}

	public void setHira_id(Integer hira_id) {
		this.hira_id = hira_id;
	}

	public Integer getSr_no() {
		return sr_no;
	}

	public void setSr_no(Integer sr_no) {
		this.sr_no = sr_no;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Integer getTotal_rating() {
		return total_rating;
	}

	public void setTotal_rating(Integer total_rating) {
		this.total_rating = total_rating;
	}

	public Integer getLegal() {
		return legal;
	}

	public void setLegal(Integer legal) {
		this.legal = legal;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getAir() {
		return air;
	}

	public void setAir(String air) {
		this.air = air;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getHuman() {
		return human;
	}

	public void setHuman(String human) {
		this.human = human;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public Integer getLand1() {
		return land1;
	}

	public void setLand1(Integer land1) {
		this.land1 = land1;
	}

	public Integer getAir1() {
		return air1;
	}

	public void setAir1(Integer air1) {
		this.air1 = air1;
	}

	public Integer getWater1() {
		return water1;
	}

	public void setWater1(Integer water1) {
		this.water1 = water1;
	}

	public Integer getHuman1() {
		return human1;
	}

	public void setHuman1(Integer human1) {
		this.human1 = human1;
	}

	public Integer getResource1() {
		return resource1;
	}

	public void setResource1(Integer resource1) {
		this.resource1 = resource1;
	}

	public Integer getImpact_rating() {
		return impact_rating;
	}

	public void setImpact_rating(Integer impact_rating) {
		this.impact_rating = impact_rating;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getHira_active() {
		return hira_active;
	}

	public void setHira_active(Integer hira_active) {
		this.hira_active = hira_active;
	}
	
	

}