package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;


@Entity(name="erp_city")
public class City {
		
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id", nullable=false,length=3)
	private Integer city_id ;
	
	@NotEmpty
	@Column(name="city_name", nullable=false,length=100)
	
	private String city_name;
	
	/*@Column(name="city_country_id")
	private Integer city_country_id;
	*/
	/*@OneToOne
	private State state;*/
	
	@OneToOne
	private Country erp_country;
	
	public Country getErp_country() {
		return erp_country;
	}

	public void setErp_country(Country erp_country) {
		this.erp_country = erp_country;
	}
	
	@OneToOne
	private State erp_state;
	
	public State getErp_state() {
		return erp_state;
	}

	public void setErp_state(State erp_state) {
		this.erp_state = erp_state;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	/*public Integer getCity_country_id() {
		return city_country_id;
	}

	public void setCity_country_id(Integer city_country_id) {
		this.city_country_id = city_country_id;
	}*/

	/*public Integer getCity_state_id() {
		return city_state_id;
	}

	public void setCity_state_id(Integer city_state_id) {
		this.city_state_id = city_state_id;
	}
	*/
		
}
