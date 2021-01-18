package com.spcl.erp.model;

import java.util.Date;

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

@Entity(name="erp_incident")
public class Ehs_Incident {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="incident_id", nullable=false)
	private Integer incident_id;
	
	@Column(name="location",length=100)
	private String location ;
	
	
	@Column(name="location_des",length=100)
	private String location_des ;
	
	
	@Column(name="location_class",length=100)
	private String location_class ;
	
	
	@Column(name="location_org_unit",length=100)
	private String location_org_unit ;
	
	
	@Column(name="files",length=100)
	private String files ;
	
	@Column(name="inc_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date inc_create_date;
	
	
	@Column(name="inc_create_by", nullable=true)
	private String inc_create_by;
	
	
	@Column(name="inc_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date inc_update_date;
	
	@Column(name="inc_update_by", nullable=true)
	private String inc_update_by;
		
	@Column(name="inc_active")
	private Integer inc_active;
	
	@OneToOne
	@JoinColumn(name="action_id")
	private Ehs_Action ehs_action;
	
	public Ehs_Action getEhs_action() {
		return ehs_action;
	}

	public void setEhs_action(Ehs_Action ehs_action) {
		this.ehs_action = ehs_action;
	}

	public Integer getIncident_id() {
		return incident_id;
	}

	public void setIncident_id(Integer incident_id) {
		this.incident_id = incident_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation_des() {
		return location_des;
	}

	public void setLocation_des(String location_des) {
		this.location_des = location_des;
	}

	public String getLocation_class() {
		return location_class;
	}

	public void setLocation_class(String location_class) {
		this.location_class = location_class;
	}

	public String getLocation_org_unit() {
		return location_org_unit;
	}

	public void setLocation_org_unit(String location_org_unit) {
		this.location_org_unit = location_org_unit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public Date getInc_create_date() {
		return inc_create_date;
	}

	public void setInc_create_date(Date inc_create_date) {
		this.inc_create_date = inc_create_date;
	}

	public String getInc_create_by() {
		return inc_create_by;
	}

	public void setInc_create_by(String inc_create_by) {
		this.inc_create_by = inc_create_by;
	}

	public Date getInc_update_date() {
		return inc_update_date;
	}

	public void setInc_update_date(Date inc_update_date) {
		this.inc_update_date = inc_update_date;
	}

	public String getInc_update_by() {
		return inc_update_by;
	}

	public void setInc_update_by(String inc_update_by) {
		this.inc_update_by = inc_update_by;
	}

	public Integer getInc_active() {
		return inc_active;
	}

	public void setInc_active(Integer inc_active) {
		this.inc_active = inc_active;
	}
	
	
}
