package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="erp_rfq_product_list")
public class RfqProductList {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rfq_list_id;
	
	@Column(name="rfpl_prod_id")
	private Integer rfpl_prod_id;
	
	@ManyToOne
	@JoinColumn(name="rfq_id")
	private RequestQuotation rfq;
	
	@Column(name="rfpl_tax_id")
	private Integer rfpl_tax_id;
	
	@Column(name="rfpl_qty")
	private Integer rfpl_qty;
	
	@Column(name="rfpl_unit_price")
	private Float rfpl_unit_price;
	
	@Column(name="rfpl_subtotal")
	private Float rfpl_subtotal;

	public RfqProductList() {} 
	
	public RfqProductList(Integer rfq_list_id, Integer rfpl_prod_id, RequestQuotation rfq, Integer rfpl_tax_id,
			Integer rfpl_qty, float rfpl_unit_price, float rfpl_subtotal) {
		
		this.rfq_list_id = rfq_list_id;
		this.rfpl_prod_id = rfpl_prod_id;
		this.rfq = rfq;
		this.rfpl_tax_id = rfpl_tax_id;
		this.rfpl_qty = rfpl_qty;
		this.rfpl_unit_price = rfpl_unit_price;
		this.rfpl_subtotal = rfpl_subtotal;
	}
	
	public Integer getRfq_list_id() {
		return rfq_list_id;
	}

	public void setRfq_list_id(Integer rfq_list_id) {
		this.rfq_list_id = rfq_list_id;
	}

	public Integer getRfpl_prod_id() {
		return rfpl_prod_id;
	}

	public void setRfpl_prod_id(Integer rfpl_prod_id) {
		this.rfpl_prod_id = rfpl_prod_id;
	}

	public RequestQuotation getRfq() {
		return rfq;
	}

	public void setRfq(RequestQuotation rfq) {
		this.rfq = rfq;
	}

	public Integer getRfpl_tax_id() {
		return rfpl_tax_id;
	}

	public void setRfpl_tax_id(Integer rfpl_tax_id) {
		this.rfpl_tax_id = rfpl_tax_id;
	}

	public Integer getRfpl_qty() {
		return rfpl_qty;
	}

	public void setRfpl_qty(Integer rfpl_qty) {
		this.rfpl_qty = rfpl_qty;
	}

	public Float getRfpl_unit_price() {
		return rfpl_unit_price;
	}

	public void setRfpl_unit_price(Float rfpl_unit_price) {
		this.rfpl_unit_price = rfpl_unit_price;
	}

	public Float getRfpl_subtotal() {
		return rfpl_subtotal;
	}

	public void setRfpl_subtotal(Float rfpl_subtotal) {
		this.rfpl_subtotal = rfpl_subtotal;
	}

	
	
}
