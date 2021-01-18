package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Department_type;


public class DepartmentDaoImpl implements DepartmentDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_department="erp_department";
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveDepartment_type(Department_type department_type) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(department_type !=null){
			try{
				session.save(department_type);
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
	public List<Department_type> getDepartment_typeList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_department+" where dept_active=1 ORDER BY dept_id desc ";
		List<Department_type> department_typeList=null;
		try{
			Query query=session.createQuery(hql);
			department_typeList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return department_typeList;
	}
	@Override
	public Department_type getDepartment_typeById(String dept_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_department+" where dept_active=1 and dept_id=?";
		Department_type department_type=null;
		int intValue = Integer.parseInt(dept_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			department_type=(Department_type)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return department_type;
	}
	
   @Override
	public boolean updateDepartment_type(Department_type department_type) {
	   Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(department_type !=null){
			try{
				session.update(department_type);
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
	public boolean deleteDepartment(String id) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_department+" set dept_active=0 where dept_id=?";
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


