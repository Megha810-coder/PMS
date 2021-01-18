package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_new_scrap")
public class Product_Scrap {

	public Product_Scrap() {}
	 public Product_Scrap(int scrap_id, String unused_material,String quatity, String stock,String reused_date,
			 String material_name,String description,String department,String date_of_deposal,
			 String vehicle_name,String vehicle_no,String material_quantity,String disposal_name,String date_of_dispatched,String deposal_method){
	  super();
	  this.scrap_id = scrap_id;
	  this.unused_material =unused_material;
	  this.quatity = quatity;
	  this.stock = stock;
	  this.reused_date = reused_date;
	  this.material_name = material_name;
	  this.description = description;
	  this.department =department;
	 this.date_of_deposal =date_of_deposal;
	 this.vehicle_name =vehicle_name;
	 this.vehicle_no =vehicle_no;
	 this.material_quantity =material_quantity;
	 this.date_of_dispatched =date_of_dispatched;
	 this.deposal_method =deposal_method;
			  
	
}
	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer scrap_id;

		@Column(name="unused_material", length=30)
		private String unused_material;
		
		@Column(name="quatity", length=30)
		private String quatity;
		
		@Column(name="stock", length=30)
		private String stock;
		
		@Column(name="reused_date" , length=30)
		private String reused_date;
		
		@Column(name="material_name" , length=30)
		private String material_name;

		@Column(name="description" , length=30)
		private String description;

		@Column(name="department" , length=30)
		private String department;

		@Column(name="date_of_deposal" , length=30)
		private String date_of_deposal;
		
		@Column(name="deposal_method" , length=30)
		private String deposal_method;
		
		@Column(name="vehicle_name" , length=30)
		private String vehicle_name;
		
		
		@Column(name="vehicle_no" , length=30)
		private String vehicle_no;
		
		@Column(name="material_quantity" , length=30)
		private String material_quantity;
		
		@Column(name="disposal_name" , length=30)
		private String disposal_name;
		
		@Column(name="date_of_dispatched" , length=30)
		private String date_of_dispatched;
		
	

		public String getMaterial_name() {
			return material_name;
		}
		public void setMaterial_name(String material_name) {
			this.material_name = material_name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getDate_of_deposal() {
			return date_of_deposal;
		}
		public void setDate_of_deposal(String date_of_deposal) {
			this.date_of_deposal = date_of_deposal;
		}
		public String getDeposal_method() {
			return deposal_method;
		}
		public void setDeposal_method(String deposal_method) {
			this.deposal_method = deposal_method;
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
		public String getMaterial_quantity() {
			return material_quantity;
		}
		public void setMaterial_quantity(String material_quantity) {
			this.material_quantity = material_quantity;
		}
		public String getDisposal_name() {
			return disposal_name;
		}
		public void setDisposal_name(String disposal_name) {
			this.disposal_name = disposal_name;
		}
		public String getDate_of_dispatched() {
			return date_of_dispatched;
		}
		public void setDate_of_dispatched(String date_of_dispatched) {
			this.date_of_dispatched = date_of_dispatched;
		}
		public Integer getGeneration() {
			return generation;
		}
		public void setGeneration(Integer generation) {
			this.generation = generation;
		}
		public Integer getCollection_1() {
			return collection_1;
		}
		public void setCollection_1(Integer collection_1) {
			this.collection_1 = collection_1;
		}
		public Integer getStorage_1() {
			return storage_1;
		}
		public void setStorage_1(Integer storage_1) {
			this.storage_1 = storage_1;
		}
		public Integer getTransportation_1() {
			return transportation_1;
		}
		public void setTransportation_1(Integer transportation_1) {
			this.transportation_1 = transportation_1;
		}
		private Integer generation;

		private Integer collection_1;

		private Integer storage_1;

		private Integer transportation_1;
		
		@Column(name="scrap_create_date")
		@Temporal(TemporalType.DATE)
		private Date scrap_create_date;
		
		
		@Column(name="scrap_create_by")
		private String scrap_create_by;
		
		@Column(name="scrap_active")
		private Integer scrap_active;
		
		public Date getScrap_create_date() {
			return scrap_create_date;
		}
		public void setScrap_create_date(Date scrap_create_date) {
			this.scrap_create_date = scrap_create_date;
		}
		public String getScrap_create_by() {
			return scrap_create_by;
		}
		public void setScrap_create_by(String scrap_create_by) {
			this.scrap_create_by = scrap_create_by;
		}
		public Integer getScrap_active() {
			return scrap_active;
		}
		public void setScrap_active(Integer scrap_active) {
			this.scrap_active = scrap_active;
		}
		public Integer getScrap_id() {
			return scrap_id;
		}
		public void setScrap_id(Integer scrap_id) {
			this.scrap_id = scrap_id;
		}
		public String getUnused_material() {
			return unused_material;
		}
		public void setUnused_material(String unused_material) {
			this.unused_material = unused_material;
		}
		public String getQuatity() {
			return quatity;
		}
		public void setQuatity(String quatity) {
			this.quatity = quatity;
		}
		public String getStock() {
			return stock;
		}
		public void setStock(String stock) {
			this.stock = stock;
		}
		public String getReused_date() {
			return reused_date;
		}
		public void setReused_date(String reused_date) {
			this.reused_date = reused_date;
		}
}