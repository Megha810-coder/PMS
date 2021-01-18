package com.spcl.erp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Product;
import com.spcl.erp.model.Product_Bill;
import com.spcl.erp.model.Product_Packeging;
import com.spcl.erp.model.Product_Scrap;
import com.spcl.erp.model.Product_Vehicle;


public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;


	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private String tbl_product="erp_new_product";
	private String tbl_packeging="erp_packeging";
	private String tbl_vehicle="erp_vehicle";
	private String tbl_scrap="erp_new_scrap";
	private String tbl_bill="erp_bill";
	@Override
	public boolean saveProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(product!=null){
			try{
				session.save(product);				
				tx.commit();
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
	
	

	@Override
	public List<Product> getProduct_list() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_product +"  where product_active=1 ORDER BY material_id desc ";
		List<Product> pro_list = new ArrayList<>();
		List<Product> product_List=null;
		try{
			Query query = session.createQuery(hql);
			product_List = query.list();
			
			for (Product list : product_List) {
				
				int material_id  = list.getMaterial_id();
				//String company_name=list.getCompany_name();
			
				String company_name=list.getCompany_name();
				String manufacturing_date =list.getManufacturing_date();
				String row_material = list.getRow_material();
				String expiry_date =list.getExpiry_date();
				String name_of_process =list.getName_of_process();
				String quality =list.getQuality();
				String crude_product =list.getCrude_product();
				String purification =list.getPurification();
				String Equipment_used =list.getEquipment_used();
				//String name_of_process = list.getName_of_process();
				
				Product pro=new Product(material_id,company_name,manufacturing_date,row_material,expiry_date,name_of_process,quality,crude_product,purification,Equipment_used);
				pro_list.add(pro);
			}

			tx.commit();
			session.close();
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return pro_list;
	}
	@Override
	public boolean savePackeging(Product_Packeging packeging) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(packeging!=null){
			try{
				session.save(packeging);
				tx.commit();
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

	@Override 
	public List<Product_Packeging> getPackeging_list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tbl_packeging + " where packeging_active=1 ORDER BY packeging_id desc ";
		List<Product_Packeging> packeging_list = new ArrayList<>();
		List<Product_Packeging> packeging_list_each = null;

		try {

		Query query = session.createQuery(hql);
		packeging_list_each = query.list();

		for (Product_Packeging list : packeging_list_each) {
				
				  int packeging_id = list.getPackeging_id();
				  String packeging_material = list.getPackeging_material();
				  String weight_of_product = list.getWeight_of_product();
				  String sealing = list.getSealing();
				  String packeging_date =list.getPackeging_date();
				  String delivery_date =list.getDelivery_date();
				 // String pack_type = list.getPack_type();
				 // String pack_method = list.getPack_method();
				//  String way_to_handle = list.getWay_to_handle();
				  
				  Product_Packeging packeging = new Product_Packeging(packeging_id,packeging_material,weight_of_product,sealing,packeging_date,delivery_date);
				 
				  packeging_list.add(packeging);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return packeging_list;
	}
	@Override
	public boolean saveProductVehicle(Product_Vehicle vehicle) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(vehicle!=null){
			try{
				session.save(vehicle);
				tx.commit();
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

	@Override
	public List<Product_Vehicle> getVehicle_list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tbl_vehicle + " where vehicle_active=1 ORDER BY vehicle_id desc ";
		List<Product_Vehicle> vehicle_list = new ArrayList<>();
		List<Product_Vehicle> vehicle_list_each = null;

		try {

		Query query = session.createQuery(hql);
		vehicle_list_each = query.list();

		for (Product_Vehicle list : vehicle_list_each) {
				
				  int vehicle_id = list.getVehicle_id();
				  String vehicle_name = list.getVehicle_name();
				  String vehicle_no = list.getVehicle_no();
				  String supplier_name = list.getSupplier_name();
				  String supplier_no = list.getSupplier_no();
				  String supplier_address = list.getSupplier_name();
				  String driver_name = list.getDriver_name();
				  String Delivery_Date = list.getDelivery_Date();
				  String driver_no =list.getDriver_no();
				  
				  
				  Product_Vehicle vehicle = new Product_Vehicle(vehicle_id, vehicle_name, vehicle_no,supplier_name,supplier_no,supplier_address,driver_name,Delivery_Date,driver_no);
				 
				  vehicle_list.add(vehicle);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return vehicle_list;
	}



	@Override
	public List<Product_Scrap> getScrap_list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tbl_scrap + " where scrap_active=1 ORDER BY scrap_id desc ";
		List<Product_Scrap> scrap_list = new ArrayList<>();
		List<Product_Scrap> scrap_list_each = null;

		try {

		Query query = session.createQuery(hql);
		scrap_list_each = query.list();

		for (Product_Scrap list : scrap_list_each) {
				
				  int scrap_id = list.getScrap_id();
				  String unused_material = list.getUnused_material();
				  String quatity = list.getQuatity();
				  String stock = list.getStock();
				  String reused_date = list.getReused_date();
				String material_name =list.getMaterial_name();
				String description =list.getDescription();
				String department=list.getDepartment();
				  String date_of_deposal=list.getDate_of_deposal();
				  String vehicle_name=list.getVehicle_name();
				  String vehicle_no=list.getVehicle_no();
				  String material_quantity=list.getMaterial_quantity();
				  String date_of_dispatched=list.getDate_of_dispatched();
				  String disposal_name=list.getDisposal_name();
				  String deposal_method=list.getDeposal_method();
				  Product_Scrap scrap = new Product_Scrap(scrap_id,unused_material,quatity,stock,reused_date,
							 material_name,description,department,date_of_deposal,
							  vehicle_name, vehicle_no, material_quantity, disposal_name,date_of_dispatched,deposal_method);
				 
				  scrap_list.add(scrap);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return scrap_list;
	}



	@Override
	public List<Product_Bill> getBill_list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tbl_bill + " where bill_active=1 ORDER BY bill_id desc ";
		List<Product_Bill> bill_list = new ArrayList<>();
		List<Product_Bill> bill_list_each = null;

		try {

		Query query = session.createQuery(hql);
		bill_list_each = query.list();

		for (Product_Bill list : bill_list_each) {
				
				  int bill_id = list.getBill_id();
				  String name_purchaser = list.getName_purchaser();
				  String purchaser_no = list.getPurchaser_no();
				  String supplier_name = list.getSupplier_name();
				  String supplier_no = list.getSupplier_no();
				  String supplier_address =list.getSupplier_address();
				  String date =list.getDate();
				  String purchaser_address =list.getPurchaser_address();
				
				  
				  Product_Bill bill = new Product_Bill(bill_id, name_purchaser, purchaser_no,supplier_name,supplier_no,supplier_address,date,purchaser_address);
				 
				  bill_list.add(bill);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return bill_list;
	}



	@Override
	public boolean saveProductBill(Product_Bill bill) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(bill!=null){
			try{
				session.save(bill);				
				tx.commit();
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



	@Override
	public boolean saveProductScrap(Product_Scrap scrap) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(scrap!=null){
			try{
				session.save(scrap);				
				tx.commit();
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



	@Override
	public boolean updateProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(product !=null)
		{
		 try{
			session.update(product);
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
	public boolean updatePackeging(Product_Packeging packeging) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(packeging !=null)
		{
		 try{
			session.update(packeging);
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
	public boolean updateVehicle(Product_Vehicle vehicle) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(vehicle !=null)
		{
		 try{
			session.update(vehicle);
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
	public boolean updateScrap(Product_Scrap scrap) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(scrap !=null)
		{
		 try{
			session.update(scrap);
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
	public boolean updateBill(Product_Bill bill) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(bill !=null)
		{
		 try{
			session.update(bill);
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
//	@Override
//	public boolean deleteWaste(String id) {
//	Session session = sessionFactory.openSession();
//	Transaction tx = session.beginTransaction();
//	String hql = "delete from " + tb1_Waste + " WHERE waste_id=" + id;
//	try {
//	Query query = session.createQuery(hql);
//	query.executeUpdate();
//	tx.commit();
//	session.close();
//	return true;
//	} catch (Exception e) {
//	tx.rollback();
//	session.close();
//	e.printStackTrace();
//	}
//	return false;
//	}
//


	@Override
	public boolean deleteProduct(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from " + tbl_product + " WHERE material_id=" + id;
		try {
		Query query = session.createQuery(hql);
		query.executeUpdate();
		tx.commit();
		session.close();
		return true;
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return false;
		}



	@Override
	public boolean deletePackeging(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from " + tbl_packeging + " WHERE packeging_id="+id;
		try {
		Query query = session.createQuery(hql);
		query.executeUpdate();
		tx.commit();
		session.close();
		return true;
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return false;
		}



	@Override
	public boolean deleteVehicle(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from " + tbl_vehicle + " WHERE vehicle_id="+id;
		try {
		Query query = session.createQuery(hql);
		query.executeUpdate();
		tx.commit();
		session.close();
		return true;
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return false;
		}



	@Override
	public boolean deleteScrap(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from " + tbl_scrap + " WHERE scrap_id="+id;
		try {
		Query query = session.createQuery(hql);
		query.executeUpdate();
		tx.commit();
		session.close();
		return true;
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return false;
		}



	@Override
	public boolean deleteBill(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from " + tbl_bill + " WHERE bill_id="+id;
		try {
		Query query = session.createQuery(hql);
		query.executeUpdate();
		tx.commit();
		session.close();
		return true;
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return false;
		}





	

}
