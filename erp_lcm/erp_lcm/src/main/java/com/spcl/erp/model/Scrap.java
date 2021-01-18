package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_scrap")
public class Scrap {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer scrap_id;
	
	
	@Column(name="scrap_pro_id",nullable=false )
	private Integer scrap_pro_id;
	
	@Column(name="scrap_pro_qty")
	private Integer scrap_pro_qty;
	
	@Column(name="scrap_document")
	private String scrap_document;
	
	@Column(name="scrap_date")
	private Date scrap_date;
	
	public Date getScrap_date() {
		return scrap_date;
	}

	public void setScrap_date(Date scrap_date) {
		this.scrap_date = scrap_date;
	}


	@Column(name="scrap_active")
	private Integer scrap_active;
	
	
	public Integer getScrap_id() {
		return scrap_id;
	}

	public void setScrap_id(Integer scrap_id) {
		this.scrap_id = scrap_id;
	}

	public Integer getScrap_pro_id() {
		return scrap_pro_id;
	}

	public void setScrap_pro_id(Integer scrap_pro_id) {
		this.scrap_pro_id = scrap_pro_id;
	}

	public Integer getScrap_pro_qty() {
		return scrap_pro_qty;
	}

	public void setScrap_pro_qty(Integer scrap_pro_qty) {
		this.scrap_pro_qty = scrap_pro_qty;
	}

	public String getScrap_document() {
		return scrap_document;
	}

	public void setScrap_document(String scrap_document) {
		this.scrap_document = scrap_document;
	}
	
	public Integer getScrap_active() {
		return scrap_active;
	}

	public void setScrap_active(Integer scrap_active) {
		this.scrap_active = scrap_active;
	}

	public Date getScrap_create_date() {
		return scrap_create_date;
	}

	public void setScrap_create_date(Date scrap_create_date) {
		this.scrap_create_date = scrap_create_date;
	}

	public String getScrap_created_by() {
		return scrap_created_by;
	}

	public void setScrap_created_by(String scrap_created_by) {
		this.scrap_created_by = scrap_created_by;
	}

	public Date getScrap_update_date() {
		return scrap_update_date;
	}

	public void setScrap_update_date(Date scrap_update_date) {
		this.scrap_update_date = scrap_update_date;
	}

	public String getScrap_updated_by() {
		return scrap_updated_by;
	}

	public void setScrap_updated_by(String scrap_updated_by) {
		this.scrap_updated_by = scrap_updated_by;
	}

	@Column(name="scrap_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date scrap_create_date;
	
	@Column(name="scrap_created_by", nullable=true)
	private String scrap_created_by;
	
	@Column(name="scrap_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date scrap_update_date;
	
	@Column(name="scrap_updated_by", nullable=true)
	private String scrap_updated_by;
}
