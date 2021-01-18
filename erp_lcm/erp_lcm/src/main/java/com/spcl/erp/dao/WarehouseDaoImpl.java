package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Operation;
import com.spcl.erp.model.Warehouse;


public class WarehouseDaoImpl implements WarehouseDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_warehouse="erp_warehouse";
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public void saveWarehouse(Warehouse warehouse) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(warehouse !=null)
		{
		 try{
			session.save(warehouse);
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
	public List<Warehouse> getWarehouseList() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_warehouse+" where ware_active=1 ORDER BY ware_id desc ";
		List<Warehouse> warehouseList=null;
		try{
			Query query=session.createQuery(hql);
			warehouseList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return warehouseList;
	}

	@Override
	public Warehouse getWarehouseById(String ware_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_warehouse+" where ware_active=1 and ware_id=?";
		Warehouse warehouse=null;
		int intValue = Integer.parseInt(ware_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			warehouse=(Warehouse)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return warehouse;
	}

	@Override
	public void updateWarehouse(Warehouse warehouse) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(warehouse !=null)
		{
		 try{
			session.update(warehouse);
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
	public boolean deleteWarehouse(String ware_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="update "+tbl_warehouse+" set ware_active=0 where ware_id=?";
		int intValue = Integer.parseInt(ware_id);
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
	public List<Warehouse> searchWarehouseList(String ware_name) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_warehouse+" where ware_active=1 ";
		
		if (!ware_name.equals(""))
			 hql = hql + " and ware_name LIKE :name";

		/*if(!str_dt.equals(""))
        	 hql = hql + " and ev_str_dt LIKE :str_dt";

     	if(!loc.equals(""))
        	 hql = hql + " and ev_location LIKE :loc";*/
                 

		hql = hql + " ORDER BY ware_id desc ";
		
		List<Warehouse> warehouseList=null;
		try{
			Query query=session.createQuery(hql);
			if (!ware_name.equals(""))
				query.setString("name","%"+ware_name+"%");
		
			/*if(!str_dt.equals(""))
			query.setString("str_dt","%"+str_dt+"%");
		
			if(!loc.equals(""))
			query.setString("loc","%"+loc+"%");*/
				
		
			warehouseList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e){
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		}
		return warehouseList;
	}

	@Override
	public void saveOperation(Operation operation) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(operation !=null)
		{
		 try{
			session.save(operation);
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
	public void updateOperation(Operation operation) {
		// TODO Auto-generated method stub
		
	}

}
