package com.spcl.erp.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="erp_shift_time")
public class ShiftTime {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer shift_id;
	
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name="shift_time_in")
	    private Date shift_time_in;
	 	
	
		@Column(name="shift_time_out")
	    private Time shift_time_out;
		
		public List<LabourCheck> getLabourCheck() {
			return labourCheck;
		}

		public void setLabourCheck(List<LabourCheck> labourCheck) {
			this.labourCheck = labourCheck;
		}


		public String shift_status;
		
	 	public Date getShift_time_in() {
			return shift_time_in;
		}

		public void setShift_time_in(Date shift_time_in) {
			this.shift_time_in = shift_time_in;
		}

		public Time getShift_time_out() {
			return shift_time_out;
		}

		public void setShift_time_out(Time shift_time_out) {
			this.shift_time_out = shift_time_out;
		}

		public String getShift_status() {
			return shift_status;
		}

		public void setShift_status(String shift_status) {
			this.shift_status = shift_status;
		}
		
		
		@OneToMany(mappedBy="shift_time",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
		private List<LabourCheck> labourCheck;
		
		
		
		

		public Integer getShift_id() {
			return shift_id;
		}

		public void setShift_id(Integer shift_id) {
			this.shift_id = shift_id;
		}

		
		
}
