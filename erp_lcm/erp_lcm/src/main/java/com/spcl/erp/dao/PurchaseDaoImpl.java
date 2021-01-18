package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Customer;
import com.spcl.erp.model.RequestQuotation;
import com.spcl.erp.model.RfqProductList;


public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired
	private SessionFactory sessionFactory;
	private String tbl_rfq_pro_list="erp_rfq_product_list";
	private String tbl_rfq="erp_req_for_quotation";
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveRFQ(RequestQuotation rfq) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(rfq !=null){
			try{
				session.save(rfq);
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
	public List<RequestQuotation> getRFQList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_rfq+" where rfq_active=1  ORDER BY rfq_id desc ";
		List<RequestQuotation> rfq_List=null;
		try{
			Query query=session.createQuery(hql);
			rfq_List=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return rfq_List;
	}

	@Override
	public RequestQuotation getRFQById(String rfq_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_rfq+" where rfq_active=1 and rfq_id=?";
		RequestQuotation rfq=null;
		int intValue = Integer.parseInt(rfq_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			rfq=(RequestQuotation)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return rfq;
	}

	@Override
	public boolean updateRFQ(RequestQuotation rfq) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(rfq !=null){
			try{
				session.update(rfq);
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
	public boolean deleteRFQ(String rfq_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_rfq+" set rfq_active=0 where rfq_id=?";
		int intValue = Integer.parseInt(rfq_id);
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
	public boolean deleteRFQproducts(String del_pro_ids) {
		
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			String hql="delete from "+tbl_rfq_pro_list+" WHERE id IN ("+del_pro_ids+")";
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
	public boolean sendRFQMail(String rfq_id) {
		
		return false;
	}

	@Override
	public List<RequestQuotation> getPOList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_rfq+" where rfq_active=1 and rfq_isPO=1  ORDER BY rfq_id desc ";
		List<RequestQuotation> po_List=null;
		try{
			Query query=session.createQuery(hql);
			po_List=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return po_List;
	}

	@Override
	public RfqProductList getProductById(String rfq_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_rfq_pro_list+" where rfq_id=?";
		RfqProductList rfpl=null;
		int intValue = Integer.parseInt(rfq_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			rfpl=(RfqProductList)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return rfpl;
	}
	

}
