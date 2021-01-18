package com.spcl.erp.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.spcl.erp.model.Leave_Department;
import com.spcl.erp.model.Leave_Request;
import com.spcl.erp.model.Leave_type;


public class LeaveDaoImpl implements LeaveDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_leave_type="erp_leave_type";
	private String tb2_leave_department="erp_leave_department";
	private String tb3_leave_request="erp_leave_request";
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public void saveLeave_type(Leave_type leave_type) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(leave_type !=null)
		{
		 try{
			session.save(leave_type);
			tx.commit();
			session.close();
			}
		 catch(Exception e)
		 {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		 }
		}

	}

	@Override
	public List<Leave_type> getLeave_typeList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_leave_type+" where lt_active=1 ORDER BY lt_id desc ";
		List<Leave_type> leave_typeList=null;
		try{
			Query query=session.createQuery(hql);
			leave_typeList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return leave_typeList;
	}

	@Override
	public Leave_type getLeave_typeById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_leave_type+" where lt_active=1 and lt_id=?";
		Leave_type leave_type=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			leave_type=(Leave_type)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return leave_type;
	}

	@Override
	public void updateLeave_type(Leave_type leave_type) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(leave_type !=null)
		{
		 try{
			session.update(leave_type);
			tx.commit();
			session.close();
			System.out.println("Successfully updated");
		}
		 catch(Exception e)
		 {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		 }
		}
	}

	@Override
	public boolean deleteLeave_type(String id) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_leave_type+" set lt_active=0 where lt_id=?";
		int intValue = Integer.parseInt(id);
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
	public List<Leave_type> searchLeave_typeList(String lt_name) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_leave_type+" where lt_active=1 ";
		
		if (!lt_name.equals(""))
			 hql = hql + " and lt_name LIKE :name";

		/*if(!str_dt.equals(""))
        	 hql = hql + " and ev_str_dt LIKE :str_dt";

     	if(!loc.equals(""))
        	 hql = hql + " and ev_location LIKE :loc";*/
                 

		hql = hql + " ORDER BY lt_id desc ";
		
		List<Leave_type> leave_typeList=null;
		try{
			Query query=session.createQuery(hql);
			if (!lt_name.equals(""))
				query.setString("name","%"+lt_name+"%");
		
			/*if(!str_dt.equals(""))
			query.setString("str_dt","%"+str_dt+"%");
		
			if(!loc.equals(""))
			query.setString("loc","%"+loc+"%");*/
				
		
			leave_typeList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e){
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		}
		return leave_typeList;
	}
	
	@Override
	public void saveLeave_Department(Leave_Department leave_department) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(leave_department !=null)
		{
		 try{
			session.save(leave_department);
			tx.commit();
			session.close();
			}
		 catch(Exception e)
		 {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		 }
		}

	}

	@Override
	public List<Leave_Department> getLeave_department_List() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tb2_leave_department+" where ld_active=1 ORDER BY ld_id desc ";
		List<Leave_Department> leave_department_List=null;
		try{
			Query query=session.createQuery(hql);
			leave_department_List=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return leave_department_List;
	}

	@Override
	public List<Leave_Request> getLeave_request_List() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tb3_leave_request+" where lr_active=1 ORDER BY lr_id desc ";
		List<Leave_Request> leave_request_list=null;
		try{
			Query query=session.createQuery(hql);
			leave_request_list=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return leave_request_list;
	}

	@Override
	public boolean saveLeave_Request(Leave_Request leave_request) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(leave_request!=null){
			try{
				session.save(leave_request);
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
	public boolean updateLeave_Request(Leave_Request leave_request) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(leave_request !=null){
			try{
				session.update(leave_request);
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
	public Leave_Request getLeave_requestById(String lr_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tb3_leave_request+" where lr_id=?";
		Leave_Request leave_request=null;
		int intValue = Integer.parseInt(lr_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			leave_request=(Leave_Request)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
	return leave_request;
	 }

	@Override
	public boolean deleteLeave(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tb3_leave_request+" set lr_active=0 where lr_id=?";
		int intValue = Integer.parseInt(id);
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
	}
	
	
	
	


