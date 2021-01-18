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

@Entity(name="erp_ehs_vehicle")
public class Ehs_Vehicle {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_id", nullable=false)
	private Integer vehicle_id;
	
	@Column(name="vehicle_name")
	private String vehicle_name ;
	
	@Column(name="vehicle_no")
	private String vehicle_no ;

	@Column(name="del_date")
	@Temporal(TemporalType.DATE)
	private Date del_date;
	
	@Column(name="suplier_name")
	private String suplier_name ;
	
	@Column(name="suplier_no")
	private String suplier_no ;
	
	@Column(name="suplier_address")
	private String suplier_address ;
	
	@Column(name="driver_name")
	private String driver_name ;
	
	@Column(name="driver_no")
	private String driver_no ;

	@OneToOne
	@JoinColumn(name="product_id")
	private Ehs_Product ehs_Product;
	
	public Ehs_Product getEhs_Product() {
		return ehs_Product;
	}

	public void setEhs_Product(Ehs_Product ehs_Product) {
		this.ehs_Product = ehs_Product;
	}

	public Integer getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public Date getDel_date() {
		return del_date;
	}

	public void setDel_date(Date del_date) {
		this.del_date = del_date;
	}

	public String getSuplier_name() {
		return suplier_name;
	}

	public void setSuplier_name(String suplier_name) {
		this.suplier_name = suplier_name;
	}

	public String getSuplier_no() {
		return suplier_no;
	}

	public void setSuplier_no(String suplier_no) {
		this.suplier_no = suplier_no;
	}

	public String getSuplier_address() {
		return suplier_address;
	}

	public void setSuplier_address(String suplier_address) {
		this.suplier_address = suplier_address;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getDriver_no() {
		return driver_no;
	}

	public void setDriver_no(String driver_no) {
		this.driver_no = driver_no;
	}
}
