/**
 * 
 */
package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.model.Contact;

/**
 * @author Gopal
 *
 */
public interface MarketingService {

	public boolean updateContact(Contact contact);

	public boolean saveContact(Contact contact);

	public List<Contact> getContactList();

	public Contact getContactById(String id);

	public boolean deleteContact(String id);
	
}
