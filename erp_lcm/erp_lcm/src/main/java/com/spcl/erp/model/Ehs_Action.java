package com.spcl.erp.model;

import java.util.Date;
import java.util.List;
import java.sql.Time;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name="erp_action")
public class Ehs_Action {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="action_id", nullable=false)
	private Integer action_id;
	

	
	@Column(name="plant_name")
	private String plant_name ;
	
	@Column(name="department")
	private String department ;
	
	@Column(name="incident_location")
	private String incident_location ;
	
	@Column(name="personal_mobile")
	private String personal_mobile ;
	
	@Column(name="emergency_mobile")
	private String emergency_mobile ;
	


	public String getPlant_name() {
		return plant_name;
	}

	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getIncident_location() {
		return incident_location;
	}

	public void setIncident_location(String incident_location) {
		this.incident_location = incident_location;
	}

	public String getPersonal_mobile() {
		return personal_mobile;
	}

	public void setPersonal_mobile(String personal_mobile) {
		this.personal_mobile = personal_mobile;
	}

	public String getEmergency_mobile() {
		return emergency_mobile;
	}

	public void setEmergency_mobile(String emergency_mobile) {
		this.emergency_mobile = emergency_mobile;
	}

	public List<Ehs_witnesed> getWitnesed_list() {
		return witnesed_list;
	}

	public void setWitnesed_list(List<Ehs_witnesed> witnesed_list) {
		this.witnesed_list = witnesed_list;
	}
	
	@OneToOne(mappedBy="ehs_action",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Ehs_Incident incident;
	
	@OneToOne(mappedBy="ehs_action",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Ehs_Treatment treatment;
	
	

	public Ehs_Incident getIncident() {
		return incident;
	}

	public void setIncident(Ehs_Incident incident) {
		this.incident = incident;
	}

	public Ehs_Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Ehs_Treatment treatment) {
		this.treatment = treatment;
	}

	@OneToMany(mappedBy="ehs_action",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Ehs_witnesed> witnesed_list;
	
	@OneToOne(mappedBy="ehs_action",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Ehs_Injured ehs_Injured;
	
	
	public Ehs_Injured getEhs_Injured() {
		return ehs_Injured;
	}

	public void setEhs_Injured(Ehs_Injured ehs_Injured) {
		this.ehs_Injured = ehs_Injured;
	}

	

	@Column(name="title",length=100)
	private String title ;
	
	@Column(name="file_name",length=100)
	private String file_name ;
	
	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	@Column(name="description",length=100)
	private String description ;
	
	@Column(name="action",length=100)
	private String action ;
	
	public Integer getAction_id() {
		return action_id;
	}

	public void setAction_id(Integer action_id) {
		this.action_id = action_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public Date getAction_create_date() {
		return action_create_date;
	}

	public void setAction_create_date(Date action_create_date) {
		this.action_create_date = action_create_date;
	}

	public String getAction_create_by() {
		return action_create_by;
	}

	public void setAction_create_by(String action_create_by) {
		this.action_create_by = action_create_by;
	}

	public Date getAction_update_date() {
		return action_update_date;
	}

	public void setAction_update_date(Date action_update_date) {
		this.action_update_date = action_update_date;
	}

	public String getAction_update_by() {
		return action_update_by;
	}

	public void setAction_update_by(String action_update_by) {
		this.action_update_by = action_update_by;
	}

	public Integer getAction_active() {
		return action_active;
	}

	public void setAction_active(Integer action_active) {
		this.action_active = action_active;
	}

	@Column(name="action_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date action_create_date;
	
	
	@Column(name="action_create_by", nullable=true)
	private String action_create_by;
	
	
	@Column(name="action_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date action_update_date;
	
	@Column(name="action_update_by", nullable=true)
	private String action_update_by;
		
	@Column(name="action_active")
	private Integer action_active;
	
	@Column(name="action_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date action_date;
	

	
	@Column(name="time",length=100)
	private String time ;

	public Date getAction_date() {
		return action_date;
	}

	public void setAction_date(Date action_date) {
		this.action_date = action_date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
