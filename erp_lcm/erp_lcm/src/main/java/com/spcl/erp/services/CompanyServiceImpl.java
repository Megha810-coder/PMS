package com.spcl.erp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.CompanyDao;
import com.spcl.erp.model.Com_Enquiry;

public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	public void setCompanyDao(CompanyDao companyDao)
	{
		this.companyDao=companyDao;
	}
	
	@Override
	public void saveEnquiry(Com_Enquiry comp_enquiry) {
		companyDao.saveEnquiry(comp_enquiry);
		
	}

	@Override
	public List<Com_Enquiry> getEnquiryList() {
		
		return companyDao.getEnquiryList();
	}

	@Override
	public Com_Enquiry getEnquiryById(String id) {
		return companyDao.getEnquiryById(id);
	}


}
