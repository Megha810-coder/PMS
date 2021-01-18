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

@Entity(name="erp_shipping")
public class Ehs_Shipping {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shipping_id", nullable=false)
	private Integer shipping_id;
	
	@Column(name="shipping_name", nullable=true)
	private String shipping_name;
	
	
	@Column(name="waste_unit",length=100)
	private String waste_unit ;
	
	
	@Column(name="dis_address",length=100)
	private String dis_address ;
	
	@Column(name="containers",length=100)
	private String containers ;
	
	@Column(name="shipment_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date shipment_date;
	
	@Column(name="generation",length=100)
	private String generation ;
	
	
	@Column(name="collection",length=100)
	private String collection ;
	
	
	@Column(name="storage",length=100)
	private String storage ;
	
	
	@Column(name="transportation",length=100)
	private String transportation ;
	
	
	@Column(name="treatment",length=100)
	private String treatment ;

	@Column(name="disposal",length=100)
	private String disposal ;
	
	
	
	@OneToOne
	@JoinColumn(name="waste_id")
	private Ehs_Waste ehs_waste;
	

	public Ehs_Waste getEhs_waste() {
		return ehs_waste;
	}

	public void setEhs_waste(Ehs_Waste ehs_waste) {
		this.ehs_waste = ehs_waste;
	}

	public Integer getShipping_id() {
		return shipping_id;
	}

	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}

	public String getShipping_name() {
		return shipping_name;
	}

	public void setShipping_name(String shipping_name) {
		this.shipping_name = shipping_name;
	}

	public String getWaste_unit() {
		return waste_unit;
	}

	public void setWaste_unit(String waste_unit) {
		this.waste_unit = waste_unit;
	}

	public String getDis_address() {
		return dis_address;
	}

	public void setDis_address(String dis_address) {
		this.dis_address = dis_address;
	}

	public String getContainers() {
		return containers;
	}

	public void setContainers(String containers) {
		this.containers = containers;
	}

	public Date getShipment_date() {
		return shipment_date;
	}

	public void setShipment_date(Date shipment_date) {
		this.shipment_date = shipment_date;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getDisposal() {
		return disposal;
	}

	public void setDisposal(String disposal) {
		this.disposal = disposal;
	}
	
	

}
