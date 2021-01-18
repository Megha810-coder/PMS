package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_vehicle")
public class Product_Vehicle {
	
	
	public Product_Vehicle() {}
	 public Product_Vehicle(int vehicle_id, String vehicle_name,String vehicle_no, String supplier_name, String supplier_no, String supplier_address ,String driver_name,String Delivery_Date,String driver_no){
	  super();
	  this.vehicle_id = vehicle_id;
	  this.vehicle_name = vehicle_name;
	  this.vehicle_no = vehicle_no;
	  this.supplier_name = supplier_name;
	  this.supplier_no = supplier_no;
	  this.supplier_address = supplier_address;
	  this.driver_name = driver_name;
	  this.Delivery_Date = Delivery_Date;
	  this.driver_no = driver_no;
	  
	  }
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vehicle_id;

	@Column(name="vehicle_name", length=30)
	private String vehicle_name;
	
	@Column(name="vehicle_no" , length=30)
	private String vehicle_no;
	
	@Column(name="Delivery_Date")
	
	private String Delivery_Date;
	
	@Column(name="supplier_name", length=30)
	private String supplier_name;
	
	@Column(name="supplier_no" , length=30)
	private String supplier_no;
	
	@Column(name="supplier_address", length=30)
	private String supplier_address;
	
	@Column(name="driver_name", length=30)
	private String driver_name;
	
	@Column(name="driver_no", length=30)
	private String driver_no;
	
	@Column(name="vehicle_create_date")
	@Temporal(TemporalType.DATE)
	private Date vehicle_create_date;
	
	
	@Column(name="vehicle_create_by")
	private String vehicle_create_by;
	
	@Column(name="vehicle_active")
	private Integer vehicle_active;

	public Integer getVehicle_active() {
		return vehicle_active;
	}

	public void setVehicle_active(Integer vehicle_active) {
		this.vehicle_active = vehicle_active;
	}

	public String getDriver_no() {
		return driver_no;
	}

	public void setDriver_no(String driver_no) {
		this.driver_no = driver_no;
	}

	public Date getVehicle_create_date() {
		return vehicle_create_date;
	}

	public void setVehicle_create_date(Date vehicle_create_date) {
		this.vehicle_create_date = vehicle_create_date;
	}

	public String getVehicle_create_by() {
		return vehicle_create_by;
	}

	public void setVehicle_create_by(String vehicle_create_by) {
		this.vehicle_create_by = vehicle_create_by;
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

	

	public String getDelivery_Date() {
		return Delivery_Date;
	}
	public void setDelivery_Date(String delivery_Date) {
		Delivery_Date = delivery_Date;
	}
	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_no() {
		return supplier_no;
	}

	public void setSupplier_no(String supplier_no) {
		this.supplier_no = supplier_no;
	}

	public String getSupplier_address() {
		return supplier_address;
	}

	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	
}
