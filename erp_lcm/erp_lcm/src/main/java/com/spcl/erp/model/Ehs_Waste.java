package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_waste")
public class Ehs_Waste {
	
	
	public Ehs_Waste() {}
	public Ehs_Waste(int waste_id,String chem_name, String quantity, Date disposal_date,String waste_department,String techniques) {
	super();
	this.waste_id = waste_id;
	this.chem_name =chem_name;
	this.quantity = quantity;
	this.disposal_date=disposal_date;
	this.waste_department=waste_department;
	this.techniques=techniques;
	
	
	}
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="waste_id", nullable=false)
	private Integer waste_id;
	
	public Ehs_Waste_Transport getEhs_Waste_Transport() {
		return ehs_Waste_Transport;
	}

	public void setEhs_Waste_Transport(Ehs_Waste_Transport ehs_Waste_Transport) {
		this.ehs_Waste_Transport = ehs_Waste_Transport;
	}

	@Column(name="waste_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date waste_create_date;
	
	public Date getWaste_create_date() {
		return waste_create_date;
	}

	public void setWaste_create_date(Date waste_create_date) {
		this.waste_create_date = waste_create_date;
	}

	@Column(name="waste_create_by", nullable=true)
	private String waste_create_by;
	
	@Column(name="waste_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date waste_update_date;
	
	@Column(name="waste_update_by", nullable=true)
	private String waste_update_by;
		
	@Column(name="waste_active")
	private Integer waste_active;
	
	@Column(name="shipment_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date shipment_date;
	
	public Date getShipment_date() {
		return shipment_date;
	}
	public void setShipment_date(Date shipment_date) {
		this.shipment_date = shipment_date;
	}


	@Column(name="chem_name",length=100)
	private String chem_name ;
	
	@Column(name="quantity",length=100)
	private String quantity ;
	
	@Column(name="waste_desc",length=100)
	private String waste_desc ;
	
	@Column(name="waste_department",length=100)
	private String waste_department ;
	
	@Column(name="disposal_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date disposal_date;
	
	@Column(name="techniques",length=100)
	private String techniques ;
	
	@Column(name="doc_waste",length=100)
	private String doc_waste ;
	
	@Column(name="generation",length=100)
	private String generation ;
	
	
	@Column(name="collection",length=100)
	private String collection ;
	
	
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


	@Column(name="storage",length=100)
	private String storage ;
	
	
	@Column(name="transportation",length=100)
	private String transportation ;
	

	public void setDoc_waste(String doc_waste) {
		this.doc_waste = doc_waste;
	}

	@OneToOne(mappedBy="ehs_waste",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Ehs_Shipping ehs_Shipping;
	
	@OneToOne(mappedBy="ehs_waste",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Ehs_Waste_Transport ehs_Waste_Transport;


	public Ehs_Shipping getEhs_Shipping() {
		return ehs_Shipping;
	}

	public void setEhs_Shipping(Ehs_Shipping ehs_Shipping) {
		this.ehs_Shipping = ehs_Shipping;
	}

	public Integer getWaste_id() {
		return waste_id;
	}

	public void setWaste_id(Integer waste_id) {
		this.waste_id = waste_id;
	}

	public String getWaste_create_by() {
		return waste_create_by;
	}

	public void setWaste_create_by(String waste_create_by) {
		this.waste_create_by = waste_create_by;
	}

	public Date getWaste_update_date() {
		return waste_update_date;
	}

	public void setWaste_update_date(Date waste_update_date) {
		this.waste_update_date = waste_update_date;
	}

	public String getWaste_update_by() {
		return waste_update_by;
	}

	public void setWaste_update_by(String waste_update_by) {
		this.waste_update_by = waste_update_by;
	}

	public Integer getWaste_active() {
		return waste_active;
	}

	public void setWaste_active(Integer waste_active) {
		this.waste_active = waste_active;
	}

	public String getChem_name() {
		return chem_name;
	}

	public void setChem_name(String chem_name) {
		this.chem_name = chem_name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getWaste_desc() {
		return waste_desc;
	}

	public void setWaste_desc(String waste_desc) {
		this.waste_desc = waste_desc;
	}

	public String getWaste_department() {
		return waste_department;
	}

	public void setWaste_department(String waste_department) {
		this.waste_department = waste_department;
	}

	public Date getDisposal_date() {
		return disposal_date;
	}

	public void setDisposal_date(Date disposal_date) {
		this.disposal_date = disposal_date;
	}

	public String getTechniques() {
		return techniques;
	}

	public void setTechniques(String techniques) {
		this.techniques = techniques;
	}
	
	
}
