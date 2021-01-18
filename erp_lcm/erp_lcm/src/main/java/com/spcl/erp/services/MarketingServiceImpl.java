package com.spcl.erp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.MarketingDao;
import com.spcl.erp.model.Contact;


public class MarketingServiceImpl implements MarketingService {
	@Autowired
	private MarketingDao marketingDao;
	
	public void setMarketingDao(MarketingDao marketingDao){
		this.marketingDao=marketingDao;
	}
	

	@Override
	public boolean updateContact(Contact contact) {
		return marketingDao.updateContact(contact);
	}

	@Override
	public boolean saveContact(Contact contact) {
		return marketingDao.saveContact(contact);
	}


	@Override
	public List<Contact> getContactList() {
		return marketingDao.getContactList();
	}


	@Override
	public Contact getContactById(String id) {
		return marketingDao.getContactById(id);
	}


	@Override
	public boolean deleteContact(String id) {
		return marketingDao.deleteContact(id);
	}
	
	
}
