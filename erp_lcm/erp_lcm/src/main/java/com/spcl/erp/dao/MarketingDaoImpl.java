package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Contact;
import com.spcl.erp.model.Transfer;

public class MarketingDaoImpl implements MarketingDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_contact="erp_contact";
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(contact !=null)
		{
		 try{
			session.update(contact);
			tx.commit();
			session.close();
			return true;
		}
		 catch(Exception e)
			 {
				 tx.rollback();
				 session.close();
				 e.printStackTrace();
				 return false;
			 }
		}
		return false;
	}

	@Override
	public boolean saveContact(Contact contact) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(contact !=null){
			try{
		
				session.save(contact);
				tx.commit();
				session.close();
				return true;
			}
			catch(Exception e){
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Contact> getContactList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_contact+" ORDER BY cntc_id desc ";
		List<Contact> contactList=null;
		try{
			Query query=session.createQuery(hql);
			contactList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return contactList;
	}

	@Override
	public Contact getContactById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_contact+" where cntc_id=?";
		Contact contact=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			contact=(Contact)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return contact;
	}
	
	@Override
	public boolean deleteContact(String del_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="delete from "+tbl_contact+" WHERE cntc_id="+del_id;
		try{
			Query query=session.createQuery(hql);
			query.executeUpdate();
			tx.commit();
			session.close();
			return true;
		}
		catch(Exception e){
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		}
		return false;
	}

}
