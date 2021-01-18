package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.MultipartFile;

@Entity(name="erp_first_aid")
public class First_aid {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="first_id", nullable=false)
	private Integer first_id;
	
	@Column(name="skin_contacts")
	private String skin_contacts ;
	
	/*@Column(name="file")
	private MultipartFile file ;
	

	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}*/


	@Column(name="eye_contacts")
	private String eye_contacts ;
	
	
	@Column(name="inhalations")
	private String inhalations ;
	
	
	@Column(name="ingestions")
	private String ingestions ;
	


	@Column(name="other")
	private String other ;
	
	@OneToOne
	@JoinColumn(name="hazard_id")
	private Hazardous_Chemicals hazardous_Chemicals;


	public Hazardous_Chemicals getHazardous_Chemicals() {
		return hazardous_Chemicals;
	}


	public void setHazardous_Chemicals(Hazardous_Chemicals hazardous_Chemicals) {
		this.hazardous_Chemicals = hazardous_Chemicals;
	}


	public Integer getFirst_id() {
		return first_id;
	}


	public void setFirst_id(Integer first_id) {
		this.first_id = first_id;
	}


	public String getSkin_contacts() {
		return skin_contacts;
	}


	public void setSkin_contacts(String skin_contacts) {
		this.skin_contacts = skin_contacts;
	}


	public String getEye_contacts() {
		return eye_contacts;
	}


	public void setEye_contacts(String eye_contacts) {
		this.eye_contacts = eye_contacts;
	}


	public String getInhalations() {
		return inhalations;
	}


	public void setInhalations(String inhalations) {
		this.inhalations = inhalations;
	}


	public String getIngestions() {
		return ingestions;
	}


	public void setIngestions(String ingestions) {
		this.ingestions = ingestions;
	}


	public String getOther() {
		return other;
	}


	public void setOther(String other) {
		this.other = other;
	}


	
}
