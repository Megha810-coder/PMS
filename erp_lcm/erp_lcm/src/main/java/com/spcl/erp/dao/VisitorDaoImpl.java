  package com.spcl.erp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


import com.spcl.erp.model.Visitor;

public class VisitorDaoImpl implements VisitorDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;


	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	private String tbl_visitor="erp_visitor";
	private String tbl_freqVisitor="erp_frequent";
	
	@Override
	public boolean saveVisitor(Visitor visitor) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(visitor!=null){
			try{
				session.save(visitor);				tx.commit();
				session.close();
				return true;
			}catch(Exception e){
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;

	}
	

	/*@Override
	public List<Visitor> getVisitor_list() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_visitor+" where visitor_active=1  ORDER BY visitor_id desc ";
		List<Visitor> visitor_List=null;
		try{
			Query query=session.createQuery(hql);
			visitor_List=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return visitor_List;
	}*/
	
	
	@Override
	public List<Visitor> getVisitor_list() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_visitor +"  where visitor_active=1 ORDER BY visitor_id desc ";
		List<Visitor> vis_list = new ArrayList<>();
		List<Visitor> visitor_List=null;
		try{
			Query query = session.createQuery(hql);
			visitor_List = query.list();
			
			for (Visitor list : visitor_List) {
				
				int visitor_id  = list.getVisitor_id();
				String appointment_no=list.getAppointment_no();
				String arrival_time = list.getArrival_time();
				
				Visitor	vis = new Visitor(visitor_id,appointment_no,arrival_time);
				vis_list.add(vis);
			}

			tx.commit();
			session.close();
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return vis_list;
	}


	





}
