package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Customer;


public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_customer="erp_customer";
	private String tbl_city="erp_city";
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveCustomer(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(customer !=null){
			try{
				session.save(customer);
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
	public List<Customer> getCustomerList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_customer+" where cust_active=1  ORDER BY cust_id desc ";
		List<Customer> customer_List=null;
		try{
			Query query=session.createQuery(hql);
			customer_List=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return customer_List;
	}

	@Override
	public Customer getCustomerById(String cust_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_customer+" where cust_active=1 and cust_id=?";
		Customer customer=null;
		int intValue = Integer.parseInt(cust_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			customer=(Customer)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return customer;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(customer !=null){
			try{
				session.update(customer);
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
	public boolean deleteCustomer(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_customer+" set cust_active=0 where cust_id=?";
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
	public List<Customer> searchCustomerList(String cust_name) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_customer+" where cust_active=1 ";
		
		if (!cust_name.equals(""))
			 hql = hql + " and lt_name LIKE :name";

		/*if(!str_dt.equals(""))
        	 hql = hql + " and ev_str_dt LIKE :str_dt";

     	if(!loc.equals(""))
        	 hql = hql + " and ev_location LIKE :loc";*/
                 

		hql = hql + " ORDER BY cust_id desc ";
		
		List<Customer> customerList=null;
		try{
			Query query=session.createQuery(hql);
			if (!cust_name.equals(""))
				query.setString("name","%"+cust_name+"%");
		
			/*if(!str_dt.equals(""))
			query.setString("str_dt","%"+str_dt+"%");
		
			if(!loc.equals(""))
			query.setString("loc","%"+loc+"%");*/
				
		
			customerList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e){
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public String getCityById(String city_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_city+" where  city_id=?";
		Customer customer=null;
		int intValue = Integer.parseInt(city_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			customer=(Customer)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return city_id;
	}

}
