package com.spcl.erp.dao;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.spcl.erp.model.HrRequirement;
public class HrRequirementDaoImpl implements HrRequirementDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_hr_requirement="erp_hr_requirement";
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveHr_Requirement(HrRequirement hrrequirement) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(hrrequirement!=null){
			try{
				session.save(hrrequirement);
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
	public List<HrRequirement> getHr_Requirement() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_hr_requirement+" where hr_active=1 ORDER BY hr_req_id desc ";
		List<HrRequirement> hr_requirement_list=null;
		try{
			Query query=session.createQuery(hql);
			hr_requirement_list=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return hr_requirement_list;
	}

	@Override
	public boolean updatehrrequirement(HrRequirement hr_requirement) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(hr_requirement !=null){
			try{
				session.update(hr_requirement);
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
	public HrRequirement getHrrequirement_ById(String hr_req_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_hr_requirement+" where hr_active=1 and hr_req_id=?";
		HrRequirement hrrequirement=null;
		int intValue = Integer.parseInt(hr_req_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			hrrequirement=(HrRequirement)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return hrrequirement;
	}

	@Override
	public boolean deletehrrequirement(String hr_req_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_hr_requirement+" set hr_active=0 where hr_req_id=?";
		int intValue = Integer.parseInt(hr_req_id);
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
	
	
	/*
	 * @Override public HrRequirement getHrrequirement_ById(String hr_req_id) {
	 * Session session=sessionFactory.openSession(); Transaction
	 * tx=session.beginTransaction(); String
	 * hql="from "+tbl_hr_requirement+" where hr_active=1 and hr_req_id=?";
	 * HrRequirement hrrequirement=null; int intValue = Integer.parseInt(hr_req_id);
	 * try{ Query query=session.createQuery(hql); query.setParameter(0,intValue);
	 * hrrequirement=(HrRequirement)query.uniqueResult(); tx.commit();
	 * session.close(); } catch(Exception e) { tx.rollback(); session.close();
	 * e.printStackTrace(); }
	 * 
	 * return hrrequirement; }
	 */
	}


