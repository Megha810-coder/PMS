package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.model.RequestQuotation;
import com.spcl.erp.model.RfqProductList;
import com.spcl.erp.model.Transfer;
import com.spcl.erp.model.Transfer_Product;

public interface TransferService {
	
	public boolean saveTransfer(Transfer transfer);
	public List<Transfer> getTransferList();
	public Transfer getTransferById(String tra_id);
	public boolean updateTransfer(Transfer transfer);
	public boolean deleteTransfer(String tra_id);
	public List<Transfer> searchTransferList(String ware_name);
	public boolean deleteTransferproducts(String del_pro_ids);
	public String getTra_lable(Integer tra_lable);
	public boolean markReadyTransfer(String id);
	public StringBuilder getAllButton(Transfer transfer,String contextPath);
	public Transfer getLabelById(String tra_id);
	public boolean saveReceipt(RequestQuotation rfq);
	public Transfer getReceiptById(String tra_source );
	public Transfer_Product getProductById(String trp_id);

}
