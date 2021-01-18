package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="erp_product_inventory")
public class Product_Inventory {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inventory_id", nullable=false)
	private Integer inventory_id;


	@Column(name="weight", nullable=false,length=200)
	private String weight ;
	
	
	@Column(name="volume", nullable=false,length=200)
	private String volume ;
	

	@Column(name="manufaturing_time", nullable=false,length=200)
	private String manufaturing_time ;
	
	@NotBlank
	@Column(name="customer_time", nullable=false,length=200)
	private String customer_time ;
	
	@NotBlank
	@Column(name="description_order", nullable=false,length=200)
	private String description_order ;
	
	@NotBlank
	@Column(name="description_receipt", nullable=false,length=200)
	private String description_receipt ;

	public Integer getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(Integer inventory_id) {
		this.inventory_id = inventory_id;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getManufaturing_time() {
		return manufaturing_time;
	}

	public void setManufaturing_time(String manufaturing_time) {
		this.manufaturing_time = manufaturing_time;
	}

	public String getCustomer_time() {
		return customer_time;
	}

	public void setCustomer_time(String customer_time) {
		this.customer_time = customer_time;
	}

	public String getDescription_order() {
		return description_order;
	}

	public void setDescription_order(String description_order) {
		this.description_order = description_order;
	}

	public String getDescription_receipt() {
		return description_receipt;
	}

	public void setDescription_receipt(String description_receipt) {
		this.description_receipt = description_receipt;
	}
	

}
