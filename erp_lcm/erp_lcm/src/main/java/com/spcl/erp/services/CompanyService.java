package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.model.Com_Enquiry;

public interface CompanyService {

	public void saveEnquiry(Com_Enquiry comp_enquiry);

	public List<Com_Enquiry> getEnquiryList();

	public Com_Enquiry getEnquiryById(String id);
}
