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

@Entity(name="erp_ehs_product")
public class Ehs_Product {
	
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", nullable=false)
	private Integer product_id;
	
	@Column(name="product_name")
	private String product_name ;
	
	public Ehs_Safety getEhs_Safety() {
		return ehs_Safety;
	}

	public void setEhs_Safety(Ehs_Safety ehs_Safety) {
		this.ehs_Safety = ehs_Safety;
	}

	@Column(name="type_of_product")
	private String type_of_product ;
	
	public String getType_of_product() {
		return type_of_product;
	}

	public void setType_of_product(String type_of_product) {
		this.type_of_product = type_of_product;
	}

	@Column(name="prod_code")
	private String prod_code ;
	
	@Column(name="formula")
	private String formula ;
	
	@Column(name="manufacturing_date")
	@Temporal(TemporalType.DATE)
	private Date manufacturing_date;
    
	@Column(name="expiry_date")
	@Temporal(TemporalType.DATE)
	private Date expiry_date;

	@Column(name="product_updated_date")
	@Temporal(TemporalType.DATE)
	private Date product_updated_date;
	
	@Column(name="product_created_date")
	@Temporal(TemporalType.DATE)
	private Date product_created_date;

	@Column(name="product_active",nullable=false,length=2)
	private Integer product_active ;
	
	@OneToOne(mappedBy="ehs_Product",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Ehs_Safety ehs_Safety;
	
	@OneToOne(mappedBy="ehs_Product",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Ehs_Pack ehs_Pack;
	
	@OneToOne(mappedBy="ehs_Product",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Ehs_Vehicle ehs_Vehicle;
	
	public Ehs_Vehicle getEhs_Vehicle() {
		return ehs_Vehicle;
	}

	public void setEhs_Vehicle(Ehs_Vehicle ehs_Vehicle) {
		this.ehs_Vehicle = ehs_Vehicle;
	}

	public Ehs_Pack getEhs_Pack() {
		return ehs_Pack;
	}

	public void setEhs_Pack(Ehs_Pack ehs_Pack) {
		this.ehs_Pack = ehs_Pack;
	}

	public Integer getProduct_active() {
		return product_active;
	}

	public void setProduct_active(Integer product_active) {
		this.product_active = product_active;
	}

	public Date getProduct_created_date() {
		return product_created_date;
	}

	public void setProduct_created_date(Date product_created_date) {
		this.product_created_date = product_created_date;
	}

	@Column(name="product_create_by")
	private String product_create_by;

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

	public String getProd_code() {
		return prod_code;
	}

	public void setProd_code(String prod_code) {
		this.prod_code = prod_code;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public Date getManufacturing_date() {
		return manufacturing_date;
	}

	public void setManufacturing_date(Date manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public Date getProduct_updated_date() {
		return product_updated_date;
	}

	public void setProduct_updated_date(Date product_updated_date) {
		this.product_updated_date = product_updated_date;
	}

	public String getProduct_create_by() {
		return product_create_by;
	}

	public void setProduct_create_by(String product_create_by) {
		this.product_create_by = product_create_by;
	}

	public void setProduct_active(java.sql.Date dat) {
		// TODO Auto-generated method stub
		
	}
}
