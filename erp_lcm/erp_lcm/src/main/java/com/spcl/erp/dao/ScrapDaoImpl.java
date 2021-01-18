package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Scrap;



public class ScrapDaoImpl implements ScrapDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_scrap="erp_scrap";
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveScrap(Scrap scrap) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(scrap !=null)
		{
		 try{
			session.save(scrap);
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
	public List<Scrap> getScrapList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_scrap+" where scrap_active=1 ORDER BY scrap_id desc ";
		List<Scrap> scrapList=null;
		try{
			Query query=session.createQuery(hql);
			scrapList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return scrapList;
	}

	@Override
	public Scrap getScrapById(String scrap_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_scrap+" where scrap_id=?";
		Scrap scrap=null;
		int intValue = Integer.parseInt(scrap_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			scrap=(Scrap)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return scrap;
	}
	@Override
	public boolean updateScrap(Scrap scrap) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(scrap !=null)
		{
		 try{
			session.update(scrap);
			tx.commit();
			session.close();
			System.out.println("Successfully updated");
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
	public boolean deleteScrap(String scrap_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_scrap+" set scrap_active=0 where scrap_id=?";
		int intValue = Integer.parseInt(scrap_id);
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
	public List<Scrap> searchScrapList(String scrap_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
