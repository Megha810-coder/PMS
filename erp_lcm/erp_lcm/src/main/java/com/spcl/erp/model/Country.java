package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_country")
public class Country {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cntry_id", nullable=false,length=8)
	private Integer cntry_id;
	
	@NotEmpty
	@Column(name="cntry_name", nullable=false,length=100)
	private String cntry_name;
	
	@Column(name="cntry_iso3", length=3)
	private String cntry_iso3;
	
	@Column(name="cntry_iso2", length=2)
	private String cntry_iso2;
	
	@Column(name="cntry_code", length=3)
	private Integer cntry_code;
	
	@Column(name="cntry_phonecode", length=10)
	private Integer cntry_phonecode;
	
	@Column(name="cntry_capital", length=100)
	private String cntry_capital;
	
	@Column(name="cntry_currency", nullable=false, length=10)
	private String cntry_currency;
	
	@Column(name="cntry_flag", length=2)
	private Integer cntry_flag;
	
	
	public Integer getCntry_id() {
		return cntry_id;
	}

	public void setCntry_id(Integer cntry_id) {
		this.cntry_id = cntry_id;
	}

	public String getCntry_name() {
		return cntry_name;
	}

	public void setCntry_name(String cntry_name) {
		this.cntry_name = cntry_name;
	}

	public String getCntry_iso3() {
		return cntry_iso3;
	}

	public void setCntry_iso3(String cntry_iso3) {
		this.cntry_iso3 = cntry_iso3;
	}

	public String getCntry_iso2() {
		return cntry_iso2;
	}

	public void setCntry_iso2(String cntry_iso2) {
		this.cntry_iso2 = cntry_iso2;
	}

	public Integer getCntry_code() {
		return cntry_code;
	}

	public void setCntry_code(Integer cntry_code) {
		this.cntry_code = cntry_code;
	}

	public Integer getCntry_phonecode() {
		return cntry_phonecode;
	}

	public void setCntry_phonecode(Integer cntry_phonecode) {
		this.cntry_phonecode = cntry_phonecode;
	}

	public String getCntry_capital() {
		return cntry_capital;
	}

	public void setCntry_capital(String cntry_capital) {
		this.cntry_capital = cntry_capital;
	}

	public String getCntry_currency() {
		return cntry_currency;
	}

	public void setCntry_currency(String cntry_currency) {
		this.cntry_currency = cntry_currency;
	}
	public Integer getCntry_flag() {
		return cntry_flag;
	}

	public void setCntry_flag(Integer cntry_flag) {
		this.cntry_flag = cntry_flag;
	}
		
}
