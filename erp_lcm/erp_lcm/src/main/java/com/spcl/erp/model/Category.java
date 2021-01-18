package com.spcl.erp.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="erp_category")
public class Category {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cat_id;
	


	@Column(name="Scategory", length=11)
	private String Scategory;
	
	@Column(name="Category_Name" , length=11)
	private Integer Category_Name;
	
	@Column(name="costing" , length=11)
	private Integer costing;
	
	@Column(name="Int_valuation", length=11)
	private Integer Int_valuation;
	
	@Column(name="price_diff", length=11)
	private Integer price_diff;
	
	@Column(name="Income_acc", length=11)
	private Integer Income_acc;
	
	public Integer getCat_id() {
		return cat_id;
	}

	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}

	public String getScategory() {
		return Scategory;
	}

	public void setScategory(String scategory) {
		Scategory = scategory;
	}

	public Integer getCategory_Name() {
		return Category_Name;
	}

	public void setCategory_Name(Integer category_Name) {
		Category_Name = category_Name;
	}

	public Integer getCosting() {
		return costing;
	}

	public void setCosting(Integer costing) {
		this.costing = costing;
	}

	public Integer getInt_valuation() {
		return Int_valuation;
	}

	public void setInt_valuation(Integer int_valuation) {
		Int_valuation = int_valuation;
	}

	public Integer getPrice_diff() {
		return price_diff;
	}

	public void setPrice_diff(Integer price_diff) {
		this.price_diff = price_diff;
	}

	public Integer getIncome_acc() {
		return Income_acc;
	}

	public void setIncome_acc(Integer income_acc) {
		Income_acc = income_acc;
	}

	public Integer getExpense() {
		return Expense;
	}

	public void setExpense(Integer expense) {
		Expense = expense;
	}

	public Integer getStock_input() {
		return stock_input;
	}

	public void setStock_input(Integer stock_input) {
		this.stock_input = stock_input;
	}

	public Integer getStock_out() {
		return stock_out;
	}

	public void setStock_out(Integer stock_out) {
		this.stock_out = stock_out;
	}

	public Integer getStock_valuation() {
		return stock_valuation;
	}

	public void setStock_valuation(Integer stock_valuation) {
		this.stock_valuation = stock_valuation;
	}

	public Integer getCat_active() {
		return cat_active;
	}

	public void setCat_active(Integer cat_active) {
		this.cat_active = cat_active;
	}

	public Integer getStock_journal() {
		return stock_journal;
	}

	public void setStock_journal(Integer stock_journal) {
		this.stock_journal = stock_journal;
	}

	@Column(name="Expense", length=11)
	private Integer Expense;
	
	@Column(name="stock_input", length=11)
	private Integer stock_input;
	
	@Column(name="stock_out", length=11)
	private Integer stock_out;
	
	@Column(name="stock_valuation", length=11)
	private Integer stock_valuation;
	
	@Column(name="cat_active", length=11)
	private Integer cat_active;
	
	@Column(name="stock_journal", length=11)
	private Integer stock_journal;

	
}
