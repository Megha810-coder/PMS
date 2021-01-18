package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_labour_check")
public class LabourCheck {
	
	
	public LabourCheck() {}
	public LabourCheck(int lab_check_id) {
	super();
	this.lab_check_id = lab_check_id;
//	this.department_dept_id = department_dept_id;
	/*this.check_in = check_in;
	this.check_out = check_out;
*/
    
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer lab_check_id;
		
	@Column(name="check_active",length=11)
	private Integer check_active;
	
	public Integer getCheck_active() {
		return check_active;
	}

	public void setCheck_active(Integer check_active) {
		this.check_active = check_active;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="check_in")
	private Date check_in;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="check_out")
	private Date check_out;
	
	@Column(name="status",length=11)
	private Integer status;
	
	@Column(name="salary",length=11)
	private Integer salary;
		
	@Column(name="Check_In_Status",length=30)
	private String Check_In_Status;
	
	@Column(name="Check_in_time")
	@Temporal(TemporalType.DATE)
	private Date Check_in_time;
	
	@ManyToOne
	@JoinColumn(name="shift_id")
	private ShiftTime shift_time;
	
	public ShiftTime getShift_time() {
		return shift_time;
	}

	public void setShift_time(ShiftTime shift_time) {
		this.shift_time = shift_time;
	}

	public Date getCheck_in_time() {
		return Check_in_time;
	}

	public void setCheck_in_time(Date check_in_time) {
		Check_in_time = check_in_time;
	}

	@OneToOne
	private Department_type department;
	
	@OneToOne
	private Labour labour;
	
	public Labour getLabour() {
		return labour;
	}

	public void setLabour(Labour labour) {
		this.labour = labour;
	}

	public Department_type getDepartment() {
		return department;
	}

	public void setDepartment(Department_type department) {
		this.department = department;
	}
		
	public String getCheck_In_Status() {
		return Check_In_Status;
	}

	public void setCheck_In_Status(String check_In_Status) {
		Check_In_Status = check_In_Status;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getLab_check_id() {
		return lab_check_id;
	}

	public void setLab_check_id(Integer lab_check_id) {
		this.lab_check_id = lab_check_id;
	}
	
	public Date getCheck_in() {
		return check_in;
	}

	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}

	public Date getCheck_out() {
		return check_out;
	}

	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
