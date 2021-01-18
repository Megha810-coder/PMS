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

@Entity(name="erp_treatment")
public class Ehs_Treatment {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="treatment_id", nullable=false)
	private Integer treatment_id;
	
	
	@Column(name="physician",length=100)
	private String physician ;
	
	
	@Column(name="first_aid",length=100)
	private String first_aid ;
	
	
	@Column(name="treatment_provider",length=100)
	private String treatment_provider ;
	
	
	@Column(name="further_treatement",length=100)
	private String further_treatement ;
	
	
	@Column(name="beyond_first_aid",length=100)
	private String beyond_first_aid ;
	
	
	@Column(name="emergency_room",length=100)
	private String emergency_room ;
	
	
	@Column(name="impatient_overnight",length=100)
	private String impatient_overnight ;
	
	
	@Column(name="unconsciousness",length=100)
	private String unconsciousness ;
	
	
	@Column(name="unconsciousness1",length=100)
	private String unconsciousness1 ;
	

	@Column(name="comment",length=100)
	private String comment ;
	


	@Column(name="after_accident",length=100)
	private String after_accident ;
	
	@Column(name="treatment_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date treatment_date;
	
	@OneToOne
	@JoinColumn(name="action_id")
	private Ehs_Action ehs_action;
	
	
	public Ehs_Action getEhs_action() {
		return ehs_action;
	}

	public void setEhs_action(Ehs_Action ehs_action) {
		this.ehs_action = ehs_action;
	}

	public Integer getTreatment_id() {
		return treatment_id;
	}

	public void setTreatment_id(Integer treatment_id) {
		this.treatment_id = treatment_id;
	}

	public String getPhysician() {
		return physician;
	}

	public void setPhysician(String physician) {
		this.physician = physician;
	}

	public String getFirst_aid() {
		return first_aid;
	}

	public void setFirst_aid(String first_aid) {
		this.first_aid = first_aid;
	}

	public String getTreatment_provider() {
		return treatment_provider;
	}

	public void setTreatment_provider(String treatment_provider) {
		this.treatment_provider = treatment_provider;
	}

	public String getFurther_treatement() {
		return further_treatement;
	}

	public void setFurther_treatement(String further_treatement) {
		this.further_treatement = further_treatement;
	}

	public String getBeyond_first_aid() {
		return beyond_first_aid;
	}

	public void setBeyond_first_aid(String beyond_first_aid) {
		this.beyond_first_aid = beyond_first_aid;
	}

	public String getEmergency_room() {
		return emergency_room;
	}

	public void setEmergency_room(String emergency_room) {
		this.emergency_room = emergency_room;
	}

	public String getImpatient_overnight() {
		return impatient_overnight;
	}

	public void setImpatient_overnight(String impatient_overnight) {
		this.impatient_overnight = impatient_overnight;
	}

	public String getUnconsciousness() {
		return unconsciousness;
	}

	public void setUnconsciousness(String unconsciousness) {
		this.unconsciousness = unconsciousness;
	}

	public String getUnconsciousness1() {
		return unconsciousness1;
	}

	public void setUnconsciousness1(String unconsciousness1) {
		this.unconsciousness1 = unconsciousness1;
	}

	public String getComment() {
		return comment;
	}

	public String getAfter_accident() {
		return after_accident;
	}

	public void setAfter_accident(String after_accident) {
		this.after_accident = after_accident;
	}

	public Date getTreatment_date() {
		return treatment_date;
	}

	public void setTreatment_date(Date treatment_date) {
		this.treatment_date = treatment_date;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getTreat_create_date() {
		return treat_create_date;
	}

	public void setTreat_create_date(Date treat_create_date) {
		this.treat_create_date = treat_create_date;
	}

	public String getTreat_create_by() {
		return treat_create_by;
	}

	public void setTreat_create_by(String treat_create_by) {
		this.treat_create_by = treat_create_by;
	}

	public Date getTreat_update_date() {
		return treat_update_date;
	}

	public void setTreat_update_date(Date treat_update_date) {
		this.treat_update_date = treat_update_date;
	}

	public String getTreat_update_by() {
		return treat_update_by;
	}

	public void setTreat_update_by(String treat_update_by) {
		this.treat_update_by = treat_update_by;
	}

	public Integer getTreat_active() {
		return treat_active;
	}

	public void setTreat_active(Integer treat_active) {
		this.treat_active = treat_active;
	}

	@Column(name="treat_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date treat_create_date;
	
	
	@Column(name="treat_create_by", nullable=true)
	private String treat_create_by;
	
	
	@Column(name="treat_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date treat_update_date;
	
	@Column(name="treat_update_by", nullable=true)
	private String treat_update_by;
		
	@Column(name="treat_active")
	private Integer treat_active;

}
