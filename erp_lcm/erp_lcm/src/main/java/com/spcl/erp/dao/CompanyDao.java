package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Com_Enquiry;


public interface CompanyDao {
	
	public void saveEnquiry(Com_Enquiry com_Enquiry);

	public List<Com_Enquiry> getEnquiryList();

	public Com_Enquiry getEnquiryById(String id);
}
