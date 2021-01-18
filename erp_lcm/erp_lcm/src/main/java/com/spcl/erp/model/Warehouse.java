package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_warehouse")
public class Warehouse {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ware_id;
	
	@NotEmpty
	@Column(name="ware_name", nullable=false)
	private String ware_name;
	
	@Column(name="ware_short_name", nullable=true)
	private String ware_short_name;
	
	@Column(name="ware_addr_id")
	private Integer ware_addr_id;
	
	@Column(name="ware_active")
	private Integer ware_active;
	
	@Column(name="ware_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date ware_create_date;
	
	@Column(name="ware_created_by", nullable=true)
	private String ware_created_by;
	
	@Column(name="ware_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date ware_update_date;
	
	@Column(name="ware_updated_by", nullable=true)
	private String ware_updated_by;

	public Integer getWare_id() {
		return ware_id;
	}

	public void setWare_id(Integer ware_id) {
		this.ware_id = ware_id;
	}

	public String getWare_name() {
		return ware_name;
	}

	public void setWare_name(String ware_name) {
		this.ware_name = ware_name;
	}

	public String getWare_short_name() {
		return ware_short_name;
	}

	public void setWare_short_name(String ware_short_name) {
		this.ware_short_name = ware_short_name;
	}

	public Integer getWare_addr_id() {
		return ware_addr_id;
	}

	public void setWare_addr_id(Integer ware_addr_id) {
		this.ware_addr_id = ware_addr_id;
	}

	public Integer getWare_active() {
		return ware_active;
	}

	public void setWare_active(Integer ware_active) {
		this.ware_active = ware_active;
	}

	public Date getWare_create_date() {
		return ware_create_date;
	}

	public void setWare_create_date(Date ware_create_date) {
		this.ware_create_date = ware_create_date;
	}

	public String getWare_created_by() {
		return ware_created_by;
	}

	public void setWare_created_by(String ware_created_by) {
		this.ware_created_by = ware_created_by;
	}

	public Date getWare_update_date() {
		return ware_update_date;
	}

	public void setWare_update_date(Date ware_update_date) {
		this.ware_update_date = ware_update_date;
	}

	public String getWare_updated_by() {
		return ware_updated_by;
	}

	public void setWare_updated_by(String ware_updated_by) {
		this.ware_updated_by = ware_updated_by;
	}

	
	
		
	
}
