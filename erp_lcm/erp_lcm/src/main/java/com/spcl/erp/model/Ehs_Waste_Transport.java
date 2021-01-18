package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="erp_waste_transport")

public class Ehs_Waste_Transport {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trans_id", nullable=false)
	private Integer trans_id;
	
	public Integer getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(Integer trans_id) {
		this.trans_id = trans_id;
	}

	public String getForm_handling() {
		return form_handling;
	}

	public void setForm_handling(String form_handling) {
		this.form_handling = form_handling;
	}

	public String getTreet_address() {
		return treet_address;
	}

	public void setTreet_address(String treet_address) {
		this.treet_address = treet_address;
	}

	public String getDisposal_address() {
		return disposal_address;
	}

	public void setDisposal_address(String disposal_address) {
		this.disposal_address = disposal_address;
	}

	@Column(name="form_handling",length=100)
	private String form_handling ;
	
	@Column(name="treet_address",length=100)
	private String treet_address ;
	
	@Column(name="disposal_address",length=100)
	private String disposal_address ;
	
	@OneToOne
	@JoinColumn(name="waste_id")
	private Ehs_Waste ehs_waste;

	public Ehs_Waste getEhs_waste() {
		return ehs_waste;
	}

	public void setEhs_waste(Ehs_Waste ehs_waste) {
		this.ehs_waste = ehs_waste;
	}
	
	@Column(name="veh_name",length=100)
	private String veh_name ;

	@Column(name="veh_number",length=100)
	private String veh_number ;


	@Column(name="material_qty",length=100)
	private String material_qty ;

	@Column(name="dis_name",length=100)
	private String dis_name ;

	public String getVeh_name() {
		return veh_name;
	}

	public void setVeh_name(String veh_name) {
		this.veh_name = veh_name;
	}

	public String getVeh_number() {
		return veh_number;
	}

	public void setVeh_number(String veh_number) {
		this.veh_number = veh_number;
	}

	public String getMaterial_qty() {
		return material_qty;
	}

	public void setMaterial_qty(String material_qty) {
		this.material_qty = material_qty;
	}

	public String getDis_name() {
		return dis_name;
	}

	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}
}
