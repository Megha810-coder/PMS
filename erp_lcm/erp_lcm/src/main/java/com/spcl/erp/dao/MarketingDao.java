package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Contact;

public interface MarketingDao {

	public boolean updateContact(Contact contact);

	public boolean saveContact(Contact contact);

	public List<Contact> getContactList();

	public Contact getContactById(String id);

	public boolean deleteContact(String id);
	
	

}
