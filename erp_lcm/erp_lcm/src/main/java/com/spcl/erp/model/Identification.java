package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="erp_identification")
public class Identification {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="identification_id", nullable=false)
	private Integer identification_id;
	
	

	@OneToOne
	@JoinColumn(name="hazard_id")
	private Hazardous_Chemicals hazardous_Chemicals;

	
	public Hazardous_Chemicals getHazardous_Chemicals() {
		
		return hazardous_Chemicals;
	}


	public void setHazardous_Chemicals(Hazardous_Chemicals hazardous_Chemicals) {
		this.hazardous_Chemicals = hazardous_Chemicals;
	}


	@Column(name="skin_contact")
	private String skin_contact ;
	
	
	@Column(name="eye_contact")
	private String eye_contact ;
	
	
	@Column(name="inhalation")
	private String inhalation ;
	
	
	@Column(name="ingestion")
	private String ingestion ;

	public String getRA1() {
		return RA1;
	}


	public void setRA1(String rA1) {
		RA1 = rA1;
	}


	public String getRA2() {
		return RA2;
	}


	public void setRA2(String rA2) {
		RA2 = rA2;
	}


	public String getRA3() {
		return RA3;
	}


	public void setRA3(String rA3) {
		RA3 = rA3;
	}


	public String getRA4() {
		return RA4;
	}


	public void setRA4(String rA4) {
		RA4 = rA4;
	}


	public String getRA5() {
		return RA5;
	}


	public void setRA5(String rA5) {
		RA5 = rA5;
	}


	@Column(name="RA1")
	private String RA1 ;
	
	@Column(name="RA2")
	private String RA2 ;
	
	@Column(name="RA3")
	private String RA3 ;
	
	@Column(name="RA4")
	private String RA4 ;
	
	@Column(name="RA5")
	private String RA5 ;
	
	@Column(name="toxic_effect")
	private String toxic_effect ;
	
	

	public Integer getIdentification_id() {
		return identification_id;
	}


	public void setIdentification_id(Integer identification_id) {
		this.identification_id = identification_id;
	}


	public String getSkin_contact() {
		return skin_contact;
	}


	public void setSkin_contact(String skin_contact) {
		this.skin_contact = skin_contact;
	}


	public String getEye_contact() {
		return eye_contact;
	}


	public void setEye_contact(String eye_contact) {
		this.eye_contact = eye_contact;
	}


	public String getInhalation() {
		return inhalation;
	}


	public void setInhalation(String inhalation) {
		this.inhalation = inhalation;
	}


	public String getIngestion() {
		return ingestion;
	}


	public void setIngestion(String ingestion) {
		this.ingestion = ingestion;
	}


	public String getToxic_effect() {
		return toxic_effect;
	}


	public void setToxic_effect(String toxic_effect) {
		this.toxic_effect = toxic_effect;
	}
	
}
