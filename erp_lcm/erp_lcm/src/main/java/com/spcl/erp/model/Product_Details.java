package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="erp_productDetails")
public class Product_Details {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", nullable=false)
	private Integer product_id;

	@NotBlank
	@Column(name="product_name", nullable=false,length=200)
	private String product_name ;
	
	@NotBlank
	@Column(name="product_quantity", nullable=false,length=200)
	private String product_quantity ;
	
	@NotBlank
	@Column(name="bill_material", nullable=false,length=200)
	private String bill_material ;
	
	@NotBlank
	@Column(name="manufa_order", nullable=false,length=200)
	private String manufa_order ;
	
	@Column(name="manufacturing_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date manufacturing_date;
	
	@Column(name="prod_type",length=100)
	private String prod_type ;
	
	@NotBlank
	@Column(name="sales_price", nullable=false,length=200)
	private String sales_price ;
	
	@NotBlank
	@Column(name="reference", nullable=false,length=200)
	private String reference ;
	
	@NotBlank
	@Column(name="cost", nullable=false,length=200)
	private String cost ;
	
	@NotBlank
	@Column(name="barcode", nullable=false,length=200)
	private String barcode ;
	
	@Column(name="prod_category",length=100)
	private String prod_category ;
	
	@NotBlank
	@Column(name="notes", nullable=false,length=200)
	private String notes ;
	
	@Column(name="product_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date product_create_date;
	
	@Column(name="product_create_by", nullable=true)
	private String product_create_by;
	
	@Column(name="product_active")
	private Integer product_active;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getBill_material() {
		return bill_material;
	}

	public void setBill_material(String bill_material) {
		this.bill_material = bill_material;
	}

	public String getManufa_order() {
		return manufa_order;
	}

	public void setManufa_order(String manufa_order) {
		this.manufa_order = manufa_order;
	}

	public Date getManufacturing_date() {
		return manufacturing_date;
	}

	public void setManufacturing_date(Date manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}

	public String getProd_type() {
		return prod_type;
	}

	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
	}

	public String getSales_price() {
		return sales_price;
	}

	public void setSales_price(String sales_price) {
		this.sales_price = sales_price;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getProd_category() {
		return prod_category;
	}

	public void setProd_category(String prod_category) {
		this.prod_category = prod_category;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
	

	
}
