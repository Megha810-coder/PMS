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

@Entity(name="erp_chemicals")
public class Hazardous_Chemicals {
	
	public Hazardous_Chemicals() {}
	public Hazardous_Chemicals(int hazard_id,String chemical_name, String prod_code,String formula,String supplier_name ) {
	super();
	this.hazard_id = hazard_id;
	this.chemical_name =chemical_name;
	this.prod_code = prod_code;
	this.formula=supplier_name ;
	this.supplier_name=supplier_name;
	/*this.disposal_date=disposal_date;
	this.waste_department=waste_department;
	this.techniques=techniques;
	*/
	
	}
	

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="hazard_id", nullable=false)
private Integer hazard_id;

public Integer getHazard_id() {
return hazard_id;
}

public void setHazard_id(Integer hazard_id) {
this.hazard_id = hazard_id;
}

public String getChemical_name() {
return chemical_name;
}

public void setChemical_name(String chemical_name) {
this.chemical_name = chemical_name;
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

public String getSynonyms() {
return synonyms;
}

public void setSynonyms(String synonyms) {
this.synonyms = synonyms;
}

public String getSupplier_name() {
return supplier_name;
}

public void setSupplier_name(String supplier_name) {
this.supplier_name = supplier_name;
}

public String getSupplier_address() {
return supplier_address;
}

public void setSupplier_address(String supplier_address) {
this.supplier_address = supplier_address;
}

public String getSupplier_phone() {
return supplier_phone;
}

public void setSupplier_phone(String supplier_phone) {
this.supplier_phone = supplier_phone;
}

public String getPhy_state() {
return phy_state;
}

public void setPhy_state(String phy_state) {
this.phy_state = phy_state;
}

public String getOdor_name() {
return odor_name;
}

public void setOdor_name(String odor_name) {
this.odor_name = odor_name;
}

public String getVapor_pressure() {
return vapor_pressure;
}

public void setVapor_pressure(String vapor_pressure) {
this.vapor_pressure = vapor_pressure;
}

public String getVapor_density() {
return vapor_density;
}

public void setVapor_density(String vapor_density) {
this.vapor_density = vapor_density;
}

public String getEvaporation_rate() {
return evaporation_rate;
}

public void setEvaporation_rate(String evaporation_rate) {
this.evaporation_rate = evaporation_rate;
}

public String getBoiling_point() {
return boiling_point;
}

public void setBoiling_point(String boiling_point) {
this.boiling_point = boiling_point;
}

public String getMelting_point() {
return melting_point;
}

public void setMelting_point(String melting_point) {
this.melting_point = melting_point;
}

@Column(name="chemical_name")
private String chemical_name ;

@Column(name="prod_code")
private String prod_code ;

@Column(name="formula")
private String formula ;

@Column(name="synonyms")
private String synonyms ;

@Column(name="supplier_name")
private String supplier_name ;

@Column(name="supplier_address")
private String supplier_address ;

@Column(name="supplier_phone")
private String supplier_phone ;


@Column(name="phy_state")
private String phy_state ;

@Column(name="odor_name")
private String odor_name ;

@Column(name="vapor_pressure")
private String vapor_pressure ;

@Column(name="vapor_density")
private String vapor_density ;

@Column(name="evaporation_rate")
private String evaporation_rate ;

@Column(name="boiling_point")
private String boiling_point ;

@Column(name="melting_point")
private String melting_point ;

@Column(name="hazard_active",nullable=false,length=2)
private Integer hazard_active ;

@Column(name="hazardous_created_date")
@Temporal(TemporalType.DATE)
private Date hazardous_created_date;

public Date getHazardous_updated_date() {
return hazardous_updated_date;
}

public void setHazardous_updated_date(Date hazardous_updated_date) {
this.hazardous_updated_date = hazardous_updated_date;
}

@Column(name="hazardous_updated_date")
@Temporal(TemporalType.DATE)
private Date hazardous_updated_date;

@Column(name="hazardous_create_by")
private String hazardous_create_by;

@OneToOne(mappedBy="hazardous_Chemicals",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private Identification identification;

@OneToOne(mappedBy="hazardous_Chemicals",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private First_aid first_aid;


public First_aid getFirst_aid() {
	return first_aid;
}

public void setFirst_aid(First_aid first_aid) {
	this.first_aid = first_aid;
}

public Identification getIdentification() {
	return identification;
}

public void setIdentification(Identification identification) {
	this.identification = identification;
}

public String getHazardous_create_by() {
return hazardous_create_by;
}

public Integer getHazard_active() {
	return hazard_active;
}

public void setHazard_active(Integer hazard_active) {
	this.hazard_active = hazard_active;
}

public void setHazardous_create_by(String hazardous_create_by) {
this.hazardous_create_by = hazardous_create_by;
}

public Date getHazardous_created_date() {
return hazardous_created_date;
}

public void setHazardous_created_date(Date hazardous_created_date) {
this.hazardous_created_date = hazardous_created_date;
}

@Column(name="file_name")
private String file_name ;

public String getFile_name() {
	return file_name;
}

public void setFile_name(String file_name) {
	this.file_name = file_name;
}

}
