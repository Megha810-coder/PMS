
package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Com_Enquiry;
import com.spcl.erp.model.Country;
import com.spcl.erp.model.Leave_type;


public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_enq="erp_enquiry_request";
	private String tbl_cntry="erp_country";
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public void saveEnquiry(Com_Enquiry com_Enquiry) {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(com_Enquiry !=null){
			try{
				session.save(com_Enquiry);
				/*session.save(cntry);*/
				tx.commit();
				session.close();
			}
			catch(Exception e){
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Com_Enquiry> getEnquiryList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_enq+" ORDER BY enq_id desc ";
		List<Com_Enquiry> enqList=null;
		try{
			Query query=session.createQuery(hql);
			enqList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return enqList;
	}

	@Override
	public Com_Enquiry getEnquiryById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_enq+" where enq_id=?";
		Com_Enquiry enquiry=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			enquiry=(Com_Enquiry)query.uniqueResult();
			tx.commit();
			session.close();
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return enquiry;
	}
	
	

	

}
