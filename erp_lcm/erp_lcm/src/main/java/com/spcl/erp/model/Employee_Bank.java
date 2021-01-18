package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="erp_emp_bank_details")

public class Employee_Bank {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer emp_bank_id;
	
	@Column(name="emp_bank_name", nullable=false,length=30)
	private String emp_bank_name;
	
	@Column(name="emp_bank_acc_no", nullable=false,length=30)
	private String emp_bank_acc_no;
	
	@Column(name="emp_bank_branch_name", nullable=false,length=30)
	private String emp_bank_branch_name;
	
	@Column(name="emp_ifcs", nullable=false,length=30)
	private String emp_ifcs;
	
	@Column(name="emp_account_holder", nullable=false,length=30)
	private String emp_account_holder;

	public Integer getEmp_bank_id() {
		return emp_bank_id;
	}

	public void setEmp_bank_id(Integer emp_bank_id) {
		this.emp_bank_id = emp_bank_id;
	}

	public String getEmp_bank_name() {
		return emp_bank_name;
	}

	public void setEmp_bank_name(String emp_bank_name) {
		this.emp_bank_name = emp_bank_name;
	}

	public String getEmp_bank_acc_no() {
		return emp_bank_acc_no;
	}

	public void setEmp_bank_acc_no(String emp_bank_acc_no) {
		this.emp_bank_acc_no = emp_bank_acc_no;
	}

	public String getEmp_bank_branch_name() {
		return emp_bank_branch_name;
	}

	public void setEmp_bank_branch_name(String emp_bank_branch_name) {
		this.emp_bank_branch_name = emp_bank_branch_name;
	}

	public String getEmp_ifcs() {
		return emp_ifcs;
	}

	public void setEmp_ifcs(String emp_ifcs) {
		this.emp_ifcs = emp_ifcs;
	}

	public String getEmp_account_holder() {
		return emp_account_holder;
	}

	public void setEmp_account_holder(String emp_account_holder) {
		this.emp_account_holder = emp_account_holder;
	}

}
