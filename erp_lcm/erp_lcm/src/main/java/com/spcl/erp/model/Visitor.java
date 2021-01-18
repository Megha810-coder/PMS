package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_visitor")
public class Visitor {
	

	public Visitor() {}
	public Visitor(int visitor_id, String appointment_no,String arrival_time) {
	super();
	this.visitor_id = visitor_id;
    this.appointment_no = appointment_no;
	this.arrival_time = arrival_time;

	}
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer visitor_id;
	
	@Column(name="appointment_no",length=15)
	private String appointment_no;
	
/*	@Column(name="visit_date")
	@Temporal(TemporalType.DATE)
	private Date visit_date;
*/
	@Column(name="arrival_time",length=15)
	private String arrival_time;
	
	@Column(name="visiting_hour_per_day",length=15)
	private String visiting_hour_per_day;
	
	@Column(name="visitor_name",length=15)
	private String visitor_name;
	
	@Column(name="organization_name",length=15)
	private String organization_name;
	
	@Column(name="mobile_no",length=10)
	private String mobile_no;
	
	@Column(name="email",length=10)
	private String email;
	
	@Column(name="visitor_type",length=10)
	private String visitor_type;
	
	@Column(name="carryng_device",length=10)
	private String carryng_device;
	
	@Column(name="host_name",length=10)
	private String host_name;
	
	@Column(name="dept_name",length=10)
	private String dept_name;
	
	@Column(name="purpose",length=10)
	private String purpose;
	
	@Column(name="visitor_active")
	private Integer visitor_active;
	
	

	public Integer getVisitor_active() {
		return visitor_active;
	}
	public void setVisitor_active(Integer visitor_active) {
		this.visitor_active = visitor_active;
	}
	public Integer getVisitor_id() {
		return visitor_id;
	}

	public void setVisitor_id(Integer visitor_id) {
		this.visitor_id = visitor_id;
	}

	public String getAppointment_no() {
		return appointment_no;
	}

	public void setAppointment_no(String appointment_no) {
		this.appointment_no = appointment_no;
	}


	/*public Date getVisit_date() {
		return visit_date;
	}
	
	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}*/
	
	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public String getVisiting_hour_per_day() {
		return visiting_hour_per_day;
	}

	public void setVisiting_hour_per_day(String visiting_hour_per_day) {
		this.visiting_hour_per_day = visiting_hour_per_day;
	}

	public String getVisitor_name() {
		return visitor_name;
	}

	public void setVisitor_name(String visitor_name) {
		this.visitor_name = visitor_name;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVisitor_type() {
		return visitor_type;
	}

	public void setVisitor_type(String visitor_type) {
		this.visitor_type = visitor_type;
	}

	public String getCarryng_device() {
		return carryng_device;
	}

	public void setCarryng_device(String carryng_device) {
		this.carryng_device = carryng_device;
	}

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	
}
