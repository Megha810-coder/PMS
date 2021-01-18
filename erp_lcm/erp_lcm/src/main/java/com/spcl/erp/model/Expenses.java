package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_expenses")
public class Expenses {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exp_id", nullable=false,length=3)
	private Integer exp_id;
	
	
	
	@Column(name="exp_product", nullable=false,length=11)
	private String exp_product ;
	
	@Column(name="exp_unitPrice", length=30)
	private Float exp_unitPrice ;
	
	@Column(name="exp_quantity", length=30)
	private Integer exp_quantity;
   
	@Column(name="exp_total", length=30)
	private Integer exp_total;
	
	@Column(name="exp_paidBy", length=30)
	private String exp_paidBy;
	
	
	@Column(name="exp_account",length=50)
	private String exp_account ;
	
	@Column(name="exp_taxes",length=50)
	private String exp_taxes ;
	
	@Column(name="exp_sales_order",length=50)
	private String exp_sales_order;
	
	public String getExp_account() {
		return exp_account;
	}
	public void setExp_account(String exp_account) {
		this.exp_account = exp_account;
	}
	public String getExp_taxes() {
		return exp_taxes;
	}
	public void setExp_taxes(String exp_taxes) {
		this.exp_taxes = exp_taxes;
	}
	public String getExp_sales_order() {
		return exp_sales_order;
	}
	public void setExp_sales_order(String exp_sales_order) {
		this.exp_sales_order = exp_sales_order;
	}


	@Column(name="exp_billRefernce", length=30)
	private String exp_billRefernce;
	
	@Column(name="exp_employee", length=30)
	private String exp_employee;
	
	
	
	@Column(name="exp_description", length=30)
	private String exp_description;
	
	@Column(name="exp_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date exp_date;
	
	
	public Date getExp_date() {
		return exp_date;
	}
	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}


	@Column(name="exp_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date exp_create_date;
	
	
	@Column(name="exp_create_by", nullable=true)
	private String exp_create_by;
	
	
	@Column(name="exp_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date exp_update_date;
	
	@Column(name="exp_update_by", nullable=true)
	private String exp_update_by;
	
	
	@Column(name="exp_active")
	private Integer exp_active;
	
	
	public String getExp_product() {
		return exp_product;
	}
	public void setExp_product(String exp_product) {
		this.exp_product = exp_product;
	}
	
	public Float getExp_unitPrice() {
		return exp_unitPrice;
	}
	public void setExp_unitPrice(Float exp_unitPrice) {
		this.exp_unitPrice = exp_unitPrice;
	}
	
	public Integer getExp_quantity() {
		return exp_quantity;
	}
	public void setExp_quantity(Integer exp_quantity) {
		this.exp_quantity = exp_quantity;
	}
	
	public Integer getExp_total() {
		return exp_total;
	}
	public void setExp_total(Integer exp_total) {
		this.exp_total = exp_total;
	}
	
	public String getExp_paidBy() {
		return exp_paidBy;
	}
	public void setExp_paidBy(String exp_paidBy) {
		this.exp_paidBy = exp_paidBy;
	}
	
	public String getExp_billRefernce() {
		return exp_billRefernce;
	}
	public void setExp_billRefernce(String exp_billRefernce) {
		this.exp_billRefernce = exp_billRefernce;
	}
	
	public String getExp_employee() {
		return exp_employee;
	}
	public void setExp_employee(String exp_employee) {
		this.exp_employee = exp_employee;
	}
	
	public String getExp_description() {
		return exp_description;
	}
	public void setExp_description(String exp_description) {
		this.exp_description = exp_description;
	}
	
	
	public Date getExp_create_date() {
		return exp_create_date;
	}

	public void setExp_create_date(Date exp_create_date) {
		this.exp_create_date = exp_create_date;
	}
	
	
	public Date getExp_update_date() {
		return exp_update_date;
	}

	public void setExp_update_date(Date exp_update_date) {
		this.exp_update_date = exp_update_date;
	}

	
	public Integer getExp_active() {
		return exp_active;
	}
	public void setExp_active(Integer exp_active) {
		this.exp_active = exp_active;
	}
	public void setExp_id(Integer exp_id) {
		this.exp_id = exp_id;
	}
	
	
	public Integer getExp_id() {
		return exp_id;
     }
}
