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

@Entity(name="erp_ehs_pack")
public class Ehs_Pack {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pack_id", nullable=false)
	private Integer pack_id;
	
	@Column(name="packeging_type")
	private String packeging_type ;
	
	@Column(name="packeging_method")
	private String packeging_method ;
	
	@Column(name="way_to_handle")
	private String way_to_handle ;
	
	@Column(name="packeging_date")
	@Temporal(TemporalType.DATE)
	private Date packeging_date;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private Ehs_Product ehs_Product;
	
	public Ehs_Product getEhs_Product() {
		return ehs_Product;
	}

	public void setEhs_Product(Ehs_Product ehs_Product) {
		this.ehs_Product = ehs_Product;
	}

	public Integer getPack_id() {
		return pack_id;
	}

	public void setPack_id(Integer pack_id) {
		this.pack_id = pack_id;
	}

	public String getPackeging_type() {
		return packeging_type;
	}

	public void setPackeging_type(String packeging_type) {
		this.packeging_type = packeging_type;
	}

	public String getPackeging_method() {
		return packeging_method;
	}

	public void setPackeging_method(String packeging_method) {
		this.packeging_method = packeging_method;
	}

	public String getWay_to_handle() {
		return way_to_handle;
	}

	public void setWay_to_handle(String way_to_handle) {
		this.way_to_handle = way_to_handle;
	}

	public Date getPackeging_date() {
		return packeging_date;
	}

	public void setPackeging_date(Date packeging_date) {
		this.packeging_date = packeging_date;
	}

	public Date getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}

	@Column(name="delivery_date")
	@Temporal(TemporalType.DATE)
	private Date delivery_date;

}
