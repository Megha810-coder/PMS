package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.SalePerson;


public class SalepersonDaoImpl implements SalepersonDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_saleperson="erp_saleperson";
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveSaleperson(SalePerson saleperson) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(saleperson !=null){
			try{
				session.save(saleperson);
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
	public List<SalePerson> getSalepersonList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_saleperson+" where salep_active=1  ORDER BY salep_id desc ";
		List<SalePerson> salep_List=null;
		try{
			Query query=session.createQuery(hql);
			salep_List=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return salep_List;
	}

	@Override
	public SalePerson getSalepersonById(String salep_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_saleperson+" where salep_active=1 and salep_id=?";
		SalePerson saleperson=null;
		int intValue = Integer.parseInt(salep_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			saleperson=(SalePerson)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return saleperson;
	}

	@Override
	public boolean updateSaleperson(SalePerson saleperson) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(saleperson !=null){
			try{
				session.update(saleperson);
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
	public boolean deleteSaleperson(String salep_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_saleperson+" set salep_active=0 where salep_id=?";
		int intValue = Integer.parseInt(salep_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
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
	public List<SalePerson> searchSalepersonList(String salep_name) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_saleperson+" where salep_active=1 ";
		
		if (!salep_name.equals(""))
			 hql = hql + " and salep_name LIKE :name";

		/*if(!str_dt.equals(""))
        	 hql = hql + " and ev_str_dt LIKE :str_dt";

     	if(!loc.equals(""))
        	 hql = hql + " and ev_location LIKE :loc";*/
                 

		hql = hql + " ORDER BY cust_id desc ";
		
		List<SalePerson> salepList=null;
		try{
			Query query=session.createQuery(hql);
			if (!salep_name.equals(""))
				query.setString("name","%"+salep_name+"%");
		
			/*if(!str_dt.equals(""))
			query.setString("str_dt","%"+str_dt+"%");
		
			if(!loc.equals(""))
			query.setString("loc","%"+loc+"%");*/
				
		
			salepList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e){
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		}
		return salepList;
	}

}
