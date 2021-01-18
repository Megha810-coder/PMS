package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="erp_ehs_safety")
public class Ehs_Safety {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="safety_id", nullable=false)
	private Integer safety_id;
	
	@Column(name="chemical_used")
	private String chemical_used ;
	
	@Column(name="technology_used")
	private String technology_used ;
	
	@Column(name="equipment_used")
	private String equipment_used ;

	@OneToOne
	@JoinColumn(name="product_id")
	private Ehs_Product ehs_Product;
	
	public Ehs_Product getEhs_Product() {
		return ehs_Product;
	}

	public void setEhs_Product(Ehs_Product ehs_Product) {
		this.ehs_Product = ehs_Product;
	}

	public Integer getSafety_id() {
		return safety_id;
	}

	public void setSafety_id(Integer safety_id) {
		this.safety_id = safety_id;
	}

	public String getChemical_used() {
		return chemical_used;
	}

	public void setChemical_used(String chemical_used) {
		this.chemical_used = chemical_used;
	}

	public String getTechnology_used() {
		return technology_used;
	}

	public void setTechnology_used(String technology_used) {
		this.technology_used = technology_used;
	}

	public String getEquipment_used() {
		return equipment_used;
	}

	public void setEquipment_used(String equipment_used) {
		this.equipment_used = equipment_used;
	}
}
