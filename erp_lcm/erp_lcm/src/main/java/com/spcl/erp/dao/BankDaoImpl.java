package com.spcl.erp.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Account;
import com.spcl.erp.model.Bank;

public class BankDaoImpl  implements BankDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_account="erp_account";
	private String tbl_bank="erp_bank";
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Override
	public List<Bank> getBankList(Map<String, String> search_field) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		StringBuilder hql=new StringBuilder("from "+tbl_bank+" where bnk_active=1 ");
		
		if (search_field!=null&&!search_field.isEmpty()) {
			//hql=new StringBuilder("from "+tbl_bank+" where bnk_active=1 ");
			for(Map.Entry<String, String> entry : search_field.entrySet()) {
				String value = entry.getValue();
				if (value!=null&&!value.isEmpty()) {
					String key = entry.getKey();
					hql.append(" and "+key+"='"+value+"' " );
				}
			}
		}
		hql.append("ORDER BY bnk_id desc");
		List<Bank> bankList=null;
		try{
			Query query=session.createQuery(hql.toString());
			bankList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return bankList;
	}
	
	
		
	@Override
	public boolean saveBank(Bank bank) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(bank !=null){
			try{		
				session.save(bank);
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
	public boolean updateBank(Bank bank) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(bank !=null)
		{
		 try{
			session.update(bank);
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
	public Bank getBankById(String id) {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_bank+" where bnk_id=?";
		Bank bank=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			bank=(Bank)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return bank;
	}


	@Override
	public boolean deleteBank(String del_id) {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="delete from "+tbl_bank+" WHERE bnk_id="+del_id;
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
	
	@Override
	public List<Account> getAccountList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_account+" where acc_active=1 ORDER BY acc_id desc ";
		List<Account> accountList=null;
		try{
			Query query=session.createQuery(hql);
			accountList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return accountList;
	}

	@Override
	public boolean saveAccount(Account account) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(account !=null){
			try{
		
				session.save(account);
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
	public boolean updateAccount(Account account) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(account !=null)
		{
		 try{
			session.update(account);
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
	public Account getAccountById(String id) {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_account+" where acc_id=?";
		Account account=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			account=(Account)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return account;
	}
	
	@Override
	public boolean deleteAccount(String del_id) {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="delete from "+tbl_account+" WHERE acc_id="+del_id;
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
