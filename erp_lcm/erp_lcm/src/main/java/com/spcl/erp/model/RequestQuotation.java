package com.spcl.erp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="erp_req_for_quotation")
public class RequestQuotation {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rfq_id;
		
	@ManyToOne
	private Customer customer;
	
	@Column(name="rfq_no", nullable=true,length=20)
	private String rfq_no;
	
	@Column(name="rfq_odr_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date rfq_odr_date;
	
	@Column(name="rfq_extra_note",length=200)
	private String rfq_extra_note;
		
	public List<Transfer> getTransferlist() {
		return transferlist;
	}

	public void setTransferlist(List<Transfer> transferlist) {
		this.transferlist = transferlist;
	}

	@OneToOne
	private SalePerson saleperson;
	
	@OneToMany(mappedBy="rfq",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<RfqProductList> rfqproductlist;
	//create transfer lidt not transfer product list....
	@OneToMany(mappedBy="rfq",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Transfer> transferlist;

	@Column(name="rfq_payment_term",length=2)
	private Integer rfq_payment_term;
	
	@Column(name="gross_amount", length=8)
	private Float gross_amount;
	
	@Column(name="tax_amount",length=8)
	private Float tax_amount;
	
	@Column(name="net_amount",length=8)
	private Float net_amount;

	@Column(name="rfq_active",length=2)
	private Integer rfq_active;
	
	@Column(name="rfq_label_status",length=2)
	private Integer rfq_label_status;
	
	@Column(name="rfq_rcv_qty",length=2)
	private Integer rfq_rcv_qty;
	
	@Column(name="rfq_bill_qty",length=2)
	private Integer rfq_bill_qty;
	
	@Column(name="rfq_isRfq")
	private Integer rfq_isRfq;
	
	@Column(name="rfq_isPO")
	private Integer rfq_isPO;
	
	
	public Integer getRfq_rcv_qty() {
		return rfq_rcv_qty;
	}

	public void setRfq_rcv_qty(Integer rfq_rcv_qty) {
		this.rfq_rcv_qty = rfq_rcv_qty;
	}

	public Integer getRfq_bill_qty() {
		return rfq_bill_qty;
	}

	public void setRfq_bill_qty(Integer rfq_bill_qty) {
		this.rfq_bill_qty = rfq_bill_qty;
	}

	public Integer getRfq_isRfq() {
		return rfq_isRfq;
	}

	public void setRfq_isRfq(Integer rfq_isRfq) {
		this.rfq_isRfq = rfq_isRfq;
	}

	public Integer getRfq_isPO() {
		return rfq_isPO;
	}

	public void setRfq_isPO(Integer rfq_isPO) {
		this.rfq_isPO = rfq_isPO;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SalePerson getSaleperson() {
		return saleperson;
	}

	public void setSaleperson(SalePerson saleperson) {
		this.saleperson = saleperson;
	}

	public Integer getRfq_id() {
		return rfq_id;
	}
	
	public Integer getRfq_payment_term() {
		return rfq_payment_term;
	}
	
	public void setRfq_id(Integer rfq_id) {
		this.rfq_id = rfq_id;
	}

	public Date getRfq_odr_date() {
		return rfq_odr_date;
	}

	public void setRfq_odr_date(Date rfq_odr_date) {
		this.rfq_odr_date = rfq_odr_date;
	}

	public String getRfq_extra_note() {
		return rfq_extra_note;
	}

	public void setRfq_extra_note(String rfq_extra_note) {
		this.rfq_extra_note = rfq_extra_note;
	}

	public Float getGross_amount() {
		return gross_amount;
	}

	public void setGross_amount(Float gross_amount) {
		this.gross_amount = gross_amount;
	}

	public Float getTax_amount() {
		return tax_amount;
	}

	public void setRfq_payment_term(Integer rfq_payment_term) {
		this.rfq_payment_term = rfq_payment_term;
	}

	public void setTax_amount(Float tax_amount) {
		this.tax_amount = tax_amount;
	}

	public Float getNet_amount() {
		return net_amount;
	}

	public void setNet_amount(Float net_amount) {
		this.net_amount = net_amount;
	}
	public Integer getRfq_active() {
		return rfq_active;
	}

	public void setRfq_active(Integer rfq_active) {
		this.rfq_active = rfq_active;
	}
	
	public String getRfq_no() {
		return rfq_no;
	}

	public void setRfq_no(String rfq_no) {
		this.rfq_no = rfq_no;
	}

	public List<RfqProductList> getRfqproductlist() {
		return rfqproductlist;
	}

	public void setRfqproductlist(List<RfqProductList> rfqproductlist) {
		this.rfqproductlist = rfqproductlist;
	}
	
	public Integer getRfq_label_status() {
		return rfq_label_status;
	}

	public void setRfq_label_status(Integer rfq_label_status) {
		this.rfq_label_status = rfq_label_status;
	}

	
}
