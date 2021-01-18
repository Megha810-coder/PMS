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

@Entity(name="erp_factory")
public class Ehs_Factory_Act {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="factory_id", nullable=false)
	private Integer factory_id;

	
	@Column(name="factory_name")
	private String factory_name ;
	
	@Column(name="factory_fact")
	private String factory_fact ;
	
	@Column(name="factory_des")
	private String factory_des ;
	
	@Column(name="factory_date")
	@Temporal(TemporalType.DATE)
	private Date factory_date ;
	
	@Column(name="factory_updated_date")
	@Temporal(TemporalType.DATE)
	private Date factory_updated_date;
	
	@Column(name="factory_created_date")
	@Temporal(TemporalType.DATE)
	private Date factory_created_date;
	
	
	public String getFactory_name() {
		return factory_name;
	}

	public void setFactory_name(String factory_name) {
		this.factory_name = factory_name;
	}

	public String getFactory_fact() {
		return factory_fact;
	}

	public void setFactory_fact(String factory_fact) {
		this.factory_fact = factory_fact;
	}

	public String getFactory_des() {
		return factory_des;
	}

	public void setFactory_des(String factory_des) {
		this.factory_des = factory_des;
	}

	public Date getFactory_date() {
		return factory_date;
	}

	public void setFactory_date(Date factory_date) {
		this.factory_date = factory_date;
	}

	public Date getFactory_updated_date() {
		return factory_updated_date;
	}

	public void setFactory_updated_date(Date factory_updated_date) {
		this.factory_updated_date = factory_updated_date;
	}

	public Date getFactory_created_date() {
		return factory_created_date;
	}

	public void setFactory_created_date(Date factory_created_date) {
		this.factory_created_date = factory_created_date;
	}

	public int getFactory_active() {
		return factory_active;
	}

	public void setFactory_active(int factory_active) {
		this.factory_active = factory_active;
	}

	public void setFactory_id(Integer factory_id) {
		this.factory_id = factory_id;
	}

	@Column(name="factory_active")
	private int factory_active ;

	public Integer getFactory_id() {
		return factory_id;
		

}
}
