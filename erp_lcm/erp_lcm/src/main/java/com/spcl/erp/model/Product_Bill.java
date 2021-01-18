package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_bill")
public class Product_Bill {

	public Product_Bill() {}
	 public Product_Bill(int bill_id,String name_purchaser,String purchaser_no,String supplier_name,String supplier_no,String supplier_address,String date,String purchaser_address){
	  super();
      this.bill_id = bill_id;
	  this.name_purchaser =name_purchaser;
	  this.purchaser_no = purchaser_no;
	  this.supplier_name = supplier_name;
	  this.supplier_no = supplier_no;
	  this.supplier_address = supplier_address;
	  this.date =date;
	  this.purchaser_address =purchaser_address;
	
}

	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer bill_id;

	 @Column(name="name_purchaser", length=30)
		private String name_purchaser;
	 
	 @Column(name="purchaser_no", length=30)
		private String purchaser_no;
	 
	 @Column(name="purchaser_address", length=30)
		private String purchaser_address;
	 
	 @Column(name="date", length=30)
		private String date;
	 
	 @Column(name="supplier_name", length=30)
		private String supplier_name;
	 
	 @Column(name="supplier_no", length=30)
		private String supplier_no;
	 
	 @Column(name="supplier_address", length=30)
		private String supplier_address;
	 
	 @Column(name="bill_create_date")
		@Temporal(TemporalType.DATE)
		private Date bill_create_date;
		
		
		@Column(name="bill_create_by")
		private String bill_create_by;
		
		@Column(name="bill_active")
		private Integer bill_active;

		public Integer getBill_id() {
			return bill_id;
		}
		public void setBill_id(Integer bill_id) {
			this.bill_id = bill_id;
		}
		public String getName_purchaser() {
			return name_purchaser;
		}
		public void setName_purchaser(String name_purchaser) {
			this.name_purchaser = name_purchaser;
		}
		public String getPurchaser_no() {
			return purchaser_no;
		}
		public void setPurchaser_no(String purchaser_no) {
			this.purchaser_no = purchaser_no;
		}
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
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
		
		public String getPurchaser_address() {
			return purchaser_address;
		}
		public void setPurchaser_address(String purchaser_address) {
			this.purchaser_address = purchaser_address;
		}
		public String getSupplier_address() {
			return supplier_address;
		}
		public void setSupplier_address(String supplier_address) {
			this.supplier_address = supplier_address;
		}
		public Date getBill_create_date() {
			return bill_create_date;
		}
		public void setBill_create_date(Date bill_create_date) {
			this.bill_create_date = bill_create_date;
		}
		public String getBill_create_by() {
			return bill_create_by;
		}
		public void setBill_create_by(String bill_create_by) {
			this.bill_create_by = bill_create_by;
		}
		public Integer getBill_active() {
			return bill_active;
		}
		public void setBill_active(Integer bill_active) {
			this.bill_active = bill_active;
		}
}
