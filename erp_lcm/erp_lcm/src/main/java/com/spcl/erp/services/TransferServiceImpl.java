package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.TransferDao;
import com.spcl.erp.model.RequestQuotation;
import com.spcl.erp.model.RfqProductList;
import com.spcl.erp.model.Transfer;
import com.spcl.erp.model.Transfer_Product;

public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferDao transferDao;

	public void setTransferDao(TransferDao transferDao) {
		this.transferDao = transferDao;
	}

	@Override
	public boolean saveTransfer(Transfer transfer) {
		return transferDao.saveTransfer(transfer);
	}

	@Override
	public List<Transfer> getTransferList() {
		List<Transfer> transferList = new ArrayList<Transfer>();
		transferList = transferDao.getTransferList();
		return transferList;
	}
	
	@Override
	public Transfer_Product getProductById(String trp_id) {
		Transfer_Product tral=new Transfer_Product();
		tral=transferDao.getProductById(trp_id);
		return tral;
	}	

	@Override
	public Transfer getTransferById(String tra_id) {
		Transfer transfer = new Transfer();
		transfer = transferDao.getTransferById(tra_id);
		return transfer;
	}
	
	@Override
	public Transfer getReceiptById(String rfq_id ) {
		Transfer transfer = transferDao.getReceiptById(rfq_id );
		return transfer;
	}
	
	@Override
	public Transfer getLabelById(String tra_id) {
		Transfer transfer = new Transfer();
		transfer = transferDao.getLabelById(tra_id);
		return transfer;
	}

	@Override
	public boolean updateTransfer(Transfer transfer) {
		return transferDao.updateTransfer(transfer);
	}

	@Override
	public boolean deleteTransfer(String tra_id) {
		return transferDao.deleteTransfer(tra_id);
	}

	@Override
	public List<Transfer> searchTransferList(String ware_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTransferproducts(String del_pro_ids) {
		return transferDao.deleteTransferproducts(del_pro_ids);
	}

	@Override
	public String getTra_lable(Integer tra_lable) {
		if (tra_lable == null) {
			return "Not Set";
		}

		String tra_lable_value;
		switch (tra_lable.intValue()) {
		case 1:
			tra_lable_value = "Draft";
			break;
		case 2:
			tra_lable_value = "wating";
			break;
		case 3:
			tra_lable_value = "Ready";
			break;
		case 4:
			tra_lable_value = "Done";
			break;
		default:
			tra_lable_value = "Not Set";
			break;
		}
		return tra_lable_value;
	}

	@Override
	public boolean markReadyTransfer(String id) {
		return transferDao.markReadyTransfer(id);
	}

	@Override
	public StringBuilder getAllButton(Transfer transfer, String contextPath) {
		StringBuilder btnstring = new StringBuilder();
		Integer lbl_status = transfer.getTra_lable();
		btnstring.append(
				"<button href=\"javscript:void(0);\" rel='"+contextPath+"/transfer/view_transfer?tra_id="+transfer.getTra_id()+"' class=\"btn btn-info btn-mini b-none view_item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"View\" ><i class=\"icofont icofont-eye-alt\"></i></button>\r\n");
		
		if (lbl_status.intValue()!=4) {
			btnstring.append("<button href='javscript:void(0); ' rel='"+contextPath+"/transfer/edit_transfer?tra_id="+transfer.getTra_id()+"' class='btn btn-warning btn-mini b-none edit_item' data-toggle='tooltip' data-placement='top' title='Edit'><i class='icofont icofont-edit'></i></button>\r\n");
		}
		
		btnstring.append("<button href=\"javscript:void(0);\" rel='"+contextPath+"/transfer/delete_transfer?tra_id="+transfer.getTra_id()+"' class=\"btn btn-danger btn-mini b-none alert-confirm remove_item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Delete/Remove\"><i class=\"icofont icofont-archive\"></i></button>\r\n");
		
		if (lbl_status.intValue()==1) {
			btnstring.append("<button href='javscript:void(0);'  rel='"+contextPath+"/transfer/mark_ready?tra_id="+transfer.getTra_id()+"' class=\"btn btn-info btn-mini b-none alert-confirm change_ready\" data-toggle='tooltip' data-placement='top' title=\"Mark_Ready\"><i class='icofont icofont-cart'></i></button>");
			
		}
		if (lbl_status.intValue()==3) {
			btnstring.append("<button href='javscript:void(0);'  rel='"+contextPath+"/transfer/edit_validation?tra_id="+transfer.getTra_id()+"' class=\"btn btn-info btn-mini b-none edit_validate\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Validation\"><i class='icofont icofont-cart'></i></button>");
			
		}
		
		
		return btnstring;
	}

	@Override
	public boolean saveReceipt(RequestQuotation rfq) {
		return transferDao.saveReceipt(rfq);
	}

}
