package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.CustomerDao;
import com.spcl.erp.dao.PurchaseDao;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.RequestQuotation;
import com.spcl.erp.model.RfqProductList;

public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseDao purchaseDao;
		
	public PurchaseDao getPurchaseDao() {
		return purchaseDao;
	}

	public void setPurchaseDao(PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}
	
	@Override
	public boolean saveRFQ(RequestQuotation rfq) {
		return purchaseDao.saveRFQ(rfq);
	}

	@Override
	public List<RequestQuotation> getRFQList() {
		List<RequestQuotation> rfq_List=new ArrayList<RequestQuotation>();
		rfq_List=purchaseDao.getRFQList();
		return rfq_List;
	}

	@Override
	public RequestQuotation getRFQById(String rfq_id) {
		RequestQuotation rfq=new RequestQuotation();
		rfq=purchaseDao.getRFQById(rfq_id);
		return rfq;
	}

	@Override
	public boolean updateRFQ(RequestQuotation rfq) {
		return purchaseDao.updateRFQ(rfq);
	}

	@Override
	public boolean deleteRFQ(String rfq_id) {
		return purchaseDao.deleteRFQ(rfq_id);
	}

	@Override
	public boolean deleteRFQproducts(String del_pro_ids) {
		return purchaseDao.deleteRFQproducts(del_pro_ids);
	}

	@Override
	public boolean sendRFQMail(String rfq_id) {
		
		return purchaseDao.sendRFQMail(rfq_id);
	}
	@Override
	public boolean getRFQMailStatus(Integer rfq_id) {
		
		return true;
	}

	@Override
	public StringBuilder getAllButton(RequestQuotation rfq, String contextPath) {
		StringBuilder btnstring=new StringBuilder();
		btnstring.append("<button href='javscript:void(0);' rel='"+contextPath+"/purchase/view_rfq?rfq_id="+rfq.getRfq_id()+"' class='btn-sm btn-info btn-icon view_item' data-toggle='tooltip' data-placement='top' title='View' ><i class='icofont icofont-eye-alt'></i></button>"+
     	"<button href='jacvscript:void(0);' rel="+contextPath+"/purchase/edit_rfq?rfq_id="+rfq.getRfq_id()+" class='btn-sm btn-warning btn-icon edit_item' data-toggle='tooltip' data-placement='top' title='Edit'><i class='icofont icofont-edit'></i></button>"+
     	"<button href='javscript:void(0);' rel='"+contextPath+"/purchase/delete_rfq?rfq_id="+rfq.getRfq_id()+"' class='btn-sm btn-danger btn-icon alert-confirm remove_item' data-toggle='tooltip' data-placement='top' title='Delete/Remove'><i class='icofont icofont-archive'></i></button>"
      	);
		
		Integer lbl_status=rfq.getRfq_label_status();
		switch (lbl_status.intValue()) {
		/*case 1:
			btnstring.append("<button href='javscript:void(0);' rel='"+contextPath+"/purchase/rfq_mail?rfq_id="+rfq.getRfq_id()+"' class='btn-sm btn-info btn-icon' data-toggle='tooltip' data-placement='top' title='SEND RFQ by Email' ><i class='icofont icofont-email'></i></button>");
			break;
		
		case 2:
			btnstring.append("<button href='javscript:void(0);' rel='"+contextPath+"/purchase/create_po?rfq_id="+rfq.getRfq_id()+"' class='btn-sm btn-success btn-icon' data-toggle='tooltip' data-placement='top' title='Purchase Order' ><i class='icofont icofont-cart'></i></button>");
			break;
		
		default:
			btnstring.append("<button href='javscript:void(0);' rel='"+contextPath+"/purchase/create_po?rfq_id="+rfq.getRfq_id()+"' class='btn-sm btn-info btn-icon' data-toggle='tooltip' data-placement='top' title='SEND RFQ by Email' ><i class='icofont icofont-email'></i></button>");
			break;
		}*/
		
		case 1:
			btnstring.append("<a href='"+contextPath+"/purchase/rfq_mail?rfq_id="+rfq.getRfq_id()+"' class='btn-sm btn-info btn-icon' data-toggle='tooltip' data-placement='top' title='SEND RFQ by Email' ><i class='icofont icofont-email'></i></a>");
			break;
		
		case 2:
			btnstring.append("<a href='"+contextPath+"/purchase/create_po?rfq_id="+rfq.getRfq_id()+"' class='btn-sm btn-success btn-icon' data-toggle='tooltip' data-placement='top' title='Create_PO' ><i class='icofont icofont-cart'></i></a>");
			break;
		case 3:
			btnstring.append("<a href='"+contextPath+"/purchase/view_receipt?rfq_id="+rfq.getRfq_id()+"' class='btn-sm btn-success btn-icon' data-toggle='tooltip' data-placement='top' title='Receipt' ><i class='icofont icofont-cart'></i></a>");
			break;
		
		}
		return btnstring;
	}

	@Override
	public List<RequestQuotation> getPOList() {
		List<RequestQuotation> po_list=new ArrayList<RequestQuotation>();
		po_list=purchaseDao.getPOList();
		return po_list;
	}
	
	@Override
	public RfqProductList getProductById(String  rfq_id) {
		RfqProductList rfpl=new RfqProductList();
		rfpl=purchaseDao.getProductById(rfq_id);
		return rfpl;
	}	

}
