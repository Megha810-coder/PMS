package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="vms_feedback")
public class VMS_Feedback {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="feedback_id", nullable=false)
	private Integer feedback_id;
	
	@NotBlank
	@Column(name="emp_name", nullable=false,length=200)
	private String emp_name ;
	
	@NotBlank
	@Column(name="emp_email", nullable=false,length=200)
	private String emp_email ;
	
	@Column(name="emp_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date emp_date;
	
	@Column(name="duration",length=100)
	private String duration ;
	
	@NotBlank
	@Column(name="review", nullable=false,length=200)
	private String review ;
	
	@Column(name="overall_experience",length=100)
	private String overall_experience ;
	
	@Column(name="timely_response",length=100)
	private String timely_response ;
	
	@Column(name="support",length=100)
	private String support ;
	
	@Column(name="sastisfaction",length=100)
	private String sastisfaction ;
	
	@NotBlank
	@Column(name="text_field", nullable=false,length=200)
	private String text_field ;
	
	public Integer getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(Integer feedback_id) {
		this.feedback_id = feedback_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public Date getEmp_date() {
		return emp_date;
	}

	public void setEmp_date(Date emp_date) {
		this.emp_date = emp_date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getOverall_experience() {
		return overall_experience;
	}

	public void setOverall_experience(String overall_experience) {
		this.overall_experience = overall_experience;
	}

	public String getTimely_response() {
		return timely_response;
	}

	public void setTimely_response(String timely_response) {
		this.timely_response = timely_response;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public String getSastisfaction() {
		return sastisfaction;
	}

	public void setSastisfaction(String sastisfaction) {
		this.sastisfaction = sastisfaction;
	}

	public String getText_field() {
		return text_field;
	}

	public void setText_field(String text_field) {
		this.text_field = text_field;
	}

	public Date getFeedback_create_date() {
		return feedback_create_date;
	}

	public void setFeedback_create_date(Date feedback_create_date) {
		this.feedback_create_date = feedback_create_date;
	}

	public String getAcc_create_by() {
		return acc_create_by;
	}

	public void setAcc_create_by(String acc_create_by) {
		this.acc_create_by = acc_create_by;
	}

	public Integer getFeedback_active() {
		return feedback_active;
	}

	public void setFeedback_active(Integer feedback_active) {
		this.feedback_active = feedback_active;
	}

	@Column(name="feedback_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date feedback_create_date;
	
	@Column(name="feedback_create_by", nullable=true)
	private String acc_create_by;
	
	@Column(name="feedback_active")
	private Integer feedback_active;
}
