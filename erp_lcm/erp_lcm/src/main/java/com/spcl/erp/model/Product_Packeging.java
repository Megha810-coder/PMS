package com.spcl.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_packeging")
public class Product_Packeging {
	
		 public Product_Packeging() {}
		 public Product_Packeging(int packeging_id,String packeging_material,String weight_of_product,String sealing ,String packeging_date,String delivery_date){
		  super();
		  this.packeging_id = packeging_id;
		  this.packeging_material = packeging_material;
		  this.weight_of_product = weight_of_product;
		  this.sealing = sealing;
		  this.packeging_date = packeging_date;
		  this.delivery_date = delivery_date;
		  }
	


	public String getPackeging_material() {
			return packeging_material;
		}
		public void setPackeging_material(String packeging_material) {
			this.packeging_material = packeging_material;
		}
		public String getWeight_of_product() {
			return weight_of_product;
		}
		public void setWeight_of_product(String weight_of_product) {
			this.weight_of_product = weight_of_product;
		}
		public String getSealing() {
			return sealing;
		}
		public void setSealing(String sealing) {
			this.sealing = sealing;
		}
		



	public String getPackeging_date() {
			return packeging_date;
		}
		public void setPackeging_date(String packeging_date) {
			this.packeging_date = packeging_date;
		}
		public String getDelivery_date() {
			return delivery_date;
		}
		public void setDelivery_date(String delivery_date) {
			this.delivery_date = delivery_date;
		}




	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer packeging_id;

	public Integer getPackeging_id() {
		return packeging_id;
	}

	public void setPackeging_id(Integer packeging_id) {
		this.packeging_id = packeging_id;
	}

	

	public Integer getPackeging_active() {
		return packeging_active;
	}

	public void setPackeging_active(Integer packeging_active) {
		this.packeging_active = packeging_active;
	}

	

	

	@Column(name="packeging_material", length=30)
	private String packeging_material;
	
	@Column(name="weight_of_product" , length=30)
	private String weight_of_product;
	
	@Column(name="sealing" , length=30)
	private String sealing;
	
	@Column(name="packeging_date" , length=30)
	private String packeging_date;
	
	@Column(name="delivery_date" , length=30)
	private String delivery_date;
	
//	@Column(name="packeging_date", nullable=true)
//	@Temporal(TemporalType.DATE)
//	private Date packeging_date;
	
/*	@Column(name="delivery_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date delivery_date;*/
	
	@Column(name="packeging_create_date")
	@Temporal(TemporalType.DATE)
	private Date packeging_create_date;
	
	@Column(name="packeging_create_by")
	private String packeging_create_by;
	
	@Column(name="packeging_active")
	private Integer packeging_active;

	public Date getPackeging_create_date() {
		return packeging_create_date;
	}

	public void setPackeging_create_date(Date packeging_create_date) {
		this.packeging_create_date = packeging_create_date;
	}

	public String getPackeging_create_by() {
		return packeging_create_by;
	}

	public void setPackeging_create_by(String packeging_create_by) {
		this.packeging_create_by = packeging_create_by;
	}

}
