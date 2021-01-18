package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Customer;
import com.spcl.erp.model.RequestQuotation;
import com.spcl.erp.model.RfqProductList;


public interface PurchaseDao {
	
	public boolean saveRFQ(RequestQuotation rfq);
	public List<RequestQuotation> getRFQList();
	public RequestQuotation getRFQById(String rfq_id);
	public boolean updateRFQ(RequestQuotation rfq);
	public boolean deleteRFQ(String rfq_id);
	public boolean deleteRFQproducts(String del_pro_ids);
	public boolean sendRFQMail(String rfq_id);
	public List<RequestQuotation> getPOList();
	public RfqProductList getProductById(String prod_id);
}
