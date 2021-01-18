package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="erp_address")
public class Address {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="adds_id", nullable=false,length=11)
	private Integer adds_id ;
	
	@Column(name="add_line1",length=150)
	private  String add_line1;
	
	@Column(name="add_line2",length=150)
	private  String add_line2;
	
	
	public String getAdd_line1() {
		return add_line1;
	}

	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}

	public String getAdd_line2() {
		return add_line2;
	}

	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}

	@OneToOne
	private City enq_city;
	
	public City getEnq_city() {
		return enq_city;
	}

	public void setEnq_city(City enq_city) {
		this.enq_city = enq_city;
	}

	public Integer getAdds_id() {
		return adds_id;
	}

	public void setAdds_id(Integer adds_id) {
		this.adds_id = adds_id;
	}
		

	@OneToOne
	@JoinColumn(name="emp_cont_id", nullable=false)
	private Employee_Contacts emp_contact;

	public Employee_Contacts getEmp_contact() {
		return emp_contact;
	}

	public void setEmp_contact(Employee_Contacts emp_contact) {
		this.emp_contact = emp_contact;
	}
}

