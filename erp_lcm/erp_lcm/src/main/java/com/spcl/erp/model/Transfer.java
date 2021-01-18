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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="erp_invent_transfer")
public class Transfer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tra_id;
	
	public Transfer() {
		this.tra_lable=new Integer(0);
	}
	

	@ManyToOne
	@JoinColumn(name="rfq_id")
	private RequestQuotation rfq;
	
	
	public RequestQuotation getRfq() {
		return rfq;
	}

	public void setRfq(RequestQuotation rfq) {
		this.rfq = rfq;
	}

	@Column(name="tra_partner_id", nullable=false)
	private Integer tra_partner_id;
	
	@Column(name="tra_opt_type", nullable=true)
	private Integer tra_opt_type;
	
	@Column(name="tra_source" )
	private String tra_source;
		
	@Column(name="tra_shiping" )
	private Integer tra_shiping;
	
	@Column(name="tra_priority")
	private Integer tra_priority;
	
	@Column(name="tra_note" )
	private String tra_note;
	
	@Column(name="tra_lable",length=20 )
	private Integer tra_lable;
	
	@Column(name="tra_button",length=20 )
	private String tra_button;
	
	public String getTra_button() {
		return tra_button;
	}

	public void setTra_button(String tra_button) {
		this.tra_button = tra_button;
	}

	public Integer getTra_lable() {
		return tra_lable;
	}

	public void setTra_lable(Integer tra_lable) {
		this.tra_lable = tra_lable;
	}

	@OneToOne
	private Operation erp_operation;
	
	
	
	@OneToMany(mappedBy="transfer",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Transfer_Product> trp_list;
	
	@Column(name="tra_create_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date tra_create_date;
	
	@Column(name="tra_create_by", nullable=true)
	private String tra_create_by;
	
	@Column(name="tra_update_date", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date tra_update_date;
	
	@Column(name="tra_update_by", nullable=true)
	private String tra_update_by;
	
	@Column(name="tra_active", length=1)
	private Integer tra_active;

	public Integer getTra_active() {
		return tra_active;
	}

	public void setTra_active(Integer tra_active) {
		this.tra_active = tra_active;
	}

	public Integer getTra_id() {
		return tra_id;
	}

	public void setTra_id(Integer tra_id) {
		this.tra_id = tra_id;
	}

	public Integer getTra_partner_id() {
		return tra_partner_id;
	}

	public void setTra_partner_id(Integer tra_partner_id) {
		this.tra_partner_id = tra_partner_id;
	}

	public Integer getTra_opt_type() {
		return tra_opt_type;
	}

	public void setTra_opt_type(Integer tra_opt_type) {
		this.tra_opt_type = tra_opt_type;
	}

	public String getTra_source() {
		return tra_source;
	}

	public void setTra_source(String tra_source) {
		this.tra_source = tra_source;
	}

	public Integer getTra_shiping() {
		return tra_shiping;
	}

	public void setTra_shiping(Integer tra_shiping) {
		this.tra_shiping = tra_shiping;
	}

	public Integer getTra_priority() {
		return tra_priority;
	}

	public void setTra_priority(Integer tra_priority) {
		this.tra_priority = tra_priority;
	}

	public String getTra_note() {
		return tra_note;
	}

	public void setTra_note(String tra_note) {
		this.tra_note = tra_note;
	}

	public Date getTra_create_date() {
		return tra_create_date;
	}

	public void setTra_create_date(Date tra_create_date) {
		this.tra_create_date = tra_create_date;
	}

	public String getTra_create_by() {
		return tra_create_by;
	}

	public void setTra_create_by(String tra_create_by) {
		this.tra_create_by = tra_create_by;
	}

	public Date getTra_update_date() {
		return tra_update_date;
	}

	public void setTra_update_date(Date tra_update_date) {
		this.tra_update_date = tra_update_date;
	}

	public String getTra_update_by() {
		return tra_update_by;
	}

	public void setTra_update_by(String tra_update_by) {
		this.tra_update_by = tra_update_by;
	}

	public Operation getErp_operation() {
		return erp_operation;
	}

	public void setErp_operation(Operation erp_operation) {
		this.erp_operation = erp_operation;
	}

	public List<Transfer_Product> getTrp_list() {
		return trp_list;
	}

	public void setTrp_list(List<Transfer_Product> trp_list) {
		this.trp_list = trp_list;
	}

}
