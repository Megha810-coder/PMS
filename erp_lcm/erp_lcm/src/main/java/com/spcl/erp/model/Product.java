package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_new_product")
public class Product {

	public Product() {}
	public Product(int material_id, String company_name,String manufacturing_date, String row_material,String expiry_date,String name_of_process ,String quality,String crude_product,String purification,String Equipment_used) {
	super();
	this.material_id = material_id;
	this.company_name = company_name;
    this.manufacturing_date = manufacturing_date;
    this.row_material = row_material;
    this.expiry_date =expiry_date;
    this.name_of_process = name_of_process;
    this.quality = quality;
    this.crude_product =crude_product;
    this.purification =purification;
    this.Equipment_used =Equipment_used;
    this.quality = quality;
	
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="material_id", nullable=false)
	private Integer material_id;
	
	@Column(name="row_material",length=200)
	private String row_material ;
	

	
	public Integer getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(Integer material_id) {
		this.material_id = material_id;
	}
	public String getRow_material() {
		return row_material;
	}
	public void setRow_material(String row_material) {
		this.row_material = row_material;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getManufacturing_date() {
		return manufacturing_date;
	}
	public void setManufacturing_date(String manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getName_of_process() {
		return name_of_process;
	}
	public void setName_of_process(String name_of_process) {
		this.name_of_process = name_of_process;
	}
	public String getCrude_product() {
		return crude_product;
	}
	public void setCrude_product(String crude_product) {
		this.crude_product = crude_product;
	}
	public String getPurification() {
		return purification;
	}
	public void setPurification(String purification) {
		this.purification = purification;
	}
	public Date getProduct_create_date() {
		return product_create_date;
	}
	public void setProduct_create_date(Date product_create_date) {
		this.product_create_date = product_create_date;
	}
	public String getProduct_create_by() {
		return product_create_by;
	}
	public void setProduct_create_by(String product_create_by) {
		this.product_create_by = product_create_by;
	}
	public Integer getProduct_active() {
		return product_active;
	}
	public void setProduct_active(Integer product_active) {
		this.product_active = product_active;
	}

	@Column(name="company_name",length=200)
	private String company_name ;
	
	@Column(name="manufacturing_date",length=200)
	private String manufacturing_date ;
	
	@Column(name="expiry_date",length=200)
	private String expiry_date ;
	
	@Column(name="name_of_process",length=200)
	private String name_of_process ;
	
	@Column(name="crude_product",length=200)
	private String crude_product ;
	
	@Column(name="purification",length=200)
	private String purification ;
	
	@Column(name="Equipment_used",length=200)
	private String Equipment_used ;
	
	@Column(name="quality",length=200)
	private String quality ;
	
	public String getEquipment_used() {
		return Equipment_used;
	}
	public void setEquipment_used(String equipment_used) {
		Equipment_used = equipment_used;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}

	@Column(name="product_create_date")
	@Temporal(TemporalType.DATE)
	private Date product_create_date;
	
	@Column(name="product_create_by")
	private String product_create_by;
	
	@Column(name="product_active")
	private Integer product_active;
	
	
	/*@Column(name="manufacturing_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date manufacturing_date;*/
	
	
	
	

	
	
	
	



}
