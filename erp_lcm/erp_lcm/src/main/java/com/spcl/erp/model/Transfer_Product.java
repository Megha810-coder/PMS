package com.spcl.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name="erp_transfer_product_list")
public class Transfer_Product {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer trp_id;
	
	@NotNull
	@Column(name="trp_product_id", nullable=true)
	private Integer trp_product_id;
	
	@Column(name="trp_initial" )
	private Integer trp_initial;
	
	@Column(name="trp_reserve")
	private Integer trp_reserve;
	
	@Column(name="trp_done")
	private Integer trp_done;
	
	@ManyToOne
	@JoinColumn(name="rfq_id")
	private RequestQuotation rfq;
	
	
	@ManyToOne
	@JoinColumn(name="tra_id", nullable=false)
	private Transfer transfer;
	
	public Transfer_Product(){
		this.trp_reserve=0;
		this.trp_done=0;
		
	}
	
	public Transfer_Product(
			Integer trp_product_id, 
			Integer trp_initial, 
			Integer trp_reserve, 
			Integer trp_done){
		this.trp_product_id=trp_product_id;
		this.trp_initial=trp_initial;
		this.trp_reserve=trp_reserve;
		this.trp_done=trp_done;
	}

	public Integer getTrp_id() {
		return trp_id;
	}

	public void setTrp_id(Integer trp_id) {
		this.trp_id = trp_id;
	}

	public Integer getTrp_product_id() {
		return trp_product_id;
	}

	public void setTrp_product_id(Integer trp_product_id) {
		this.trp_product_id = trp_product_id;
	}

	public Integer getTrp_initial() {
		return trp_initial;
	}

	public void setTrp_initial(Integer trp_initial) {
		this.trp_initial = trp_initial;
	}

	public Integer getTrp_reserve() {
		return trp_reserve;
	}

	public void setTrp_reserve(Integer trp_reserve) {
		this.trp_reserve = trp_reserve;
	}

	public Integer getTrp_done() {
		return trp_done;
	}

	public void setTrp_done(Integer trp_done) {
		this.trp_done = trp_done;
	}

	public Transfer getTransfer() {
		return transfer;
	}

	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}
}
