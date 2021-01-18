package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


import com.spcl.erp.model.RequestQuotation;
import com.spcl.erp.model.RfqProductList;
import com.spcl.erp.model.Transfer;
import com.spcl.erp.model.Transfer_Product;
import com.spcl.erp.model.Warehouse;

public class TransferDaoImpl implements TransferDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_transfer="erp_invent_transfer";
	private String tbl_trp_list="erp_transfer_product_list";
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveTransfer(Transfer transfer) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(transfer !=null)
		{
		 try{
			session.save(transfer);
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
	public List<Transfer> getTransferList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_transfer+" where tra_active=1 ORDER BY tra_id desc ";
		List<Transfer> transferList=null;
		try{
			Query query=session.createQuery(hql);
			transferList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return transferList;
	}

	@Override
	public Transfer getTransferById(String tra_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_transfer+" where tra_id=?";
		Transfer transfer=null;
		int intValue = Integer.parseInt(tra_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			transfer=(Transfer)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return transfer;
	}
	
	@Override
	public Transfer getReceiptById(String rfq_id ) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_transfer+" where rfq_id =?";
		Transfer transfer=null;
		int intValue = Integer.parseInt(rfq_id );
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			transfer=(Transfer)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return transfer;
	}
	
	@Override
	public Transfer getLabelById(String tra_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="tra_lable" +"from "+tbl_transfer+" where tra_id=?";
		Transfer transfer=null;
		int intValue = Integer.parseInt(tra_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			transfer=(Transfer)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return transfer;
	}

	@Override
	public boolean updateTransfer(Transfer transfer) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(transfer !=null)
		{
		 try{
			session.update(transfer);
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
	public boolean deleteTransfer(String tra_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_transfer+" set tra_active=0 where tra_id=?";
		int intValue = Integer.parseInt(tra_id);
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
	public List<Transfer> searchTransferList(String ware_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTransferproducts(String del_pro_ids) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="delete from "+tbl_trp_list+" WHERE id IN ("+del_pro_ids+")";
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
	public boolean markReadyTransfer(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_transfer+" set tra_lable=0 where tra_id=?";
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
	public boolean saveReceipt(RequestQuotation rfq) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(rfq !=null)
		{
		 try{
			session.save(rfq);
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
	public Transfer_Product getProductById(String trp_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_trp_list+" where trp_id=?";
		Transfer_Product tral=null;
		int intValue = Integer.parseInt(trp_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			tral=(Transfer_Product)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return tral;
	}
	


}
