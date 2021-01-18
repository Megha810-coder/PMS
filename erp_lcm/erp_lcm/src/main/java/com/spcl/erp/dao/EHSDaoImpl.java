package com.spcl.erp.dao;

import java.util.List;
import java.sql.Date;
import java.util.ArrayList;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Ehs_Action;
import com.spcl.erp.model.Ehs_Factory_Act;
import com.spcl.erp.model.Ehs_Incident;
import com.spcl.erp.model.Ehs_Industrial;
import com.spcl.erp.model.Ehs_Product;
import com.spcl.erp.model.Ehs_Shipping;
import com.spcl.erp.model.Ehs_Training;
import com.spcl.erp.model.Ehs_Waste;
import com.spcl.erp.model.Ehs_Waste_Transport;
import com.spcl.erp.model.Ehs_witnesed;
import com.spcl.erp.model.Employee;
import com.spcl.erp.model.HIRA;
import com.spcl.erp.model.Hazardous_Chemicals;
import com.spcl.erp.model.LabourCheck;
import com.spcl.erp.model.Osha_Law;


public class EHSDaoImpl implements EHSDao {

	@Autowired
	private SessionFactory sessionFactory;

	private String tbl_Incident = "erp_action";
	private String tbl_witnesed = "erp_witnesed";
	private String tbl_incident = "erp_incident";
	private String tb1_Hazardous = "erp_chemicals";
	private String tb1_Waste = "erp_waste";
	private String tb1_Product = "erp_ehs_product";
	private String tb1_Training = "erp_training";
	private String tb1_industrial = "erp_industrial";
	private String tb1_factory = "erp_factory";
	private String tb1_osha_law = "erp_osha_law";
	private String tb1_Hira ="erp_hira";

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveIncident(Ehs_Action action) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (action != null) {
			try {
				session.save(action);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Ehs_Action> getIncident_list(Map<String, String> search_field) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * String
		 * hql="from "+tbl_Incident+" where action_active=1 ORDER BY action_id desc";
		 */
		StringBuilder hql = new StringBuilder("from " + tbl_Incident + " where action_active=1 ");

		if (search_field != null && !search_field.isEmpty()) {
			for (Map.Entry<String, String> entry : search_field.entrySet()) {
				String value = entry.getValue();
				if (value != null && !value.isEmpty()) {
					String key = entry.getKey();
					hql.append(" and " + key + "='" + value + "' ");
				}
			}
		}
		hql.append("ORDER BY action_id desc");
		List<Ehs_Action> action_list = null;
		try {
			Query query = session.createQuery(hql.toString());
			action_list = query.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return action_list;
	}

	@Override
	public boolean updateIncident(Ehs_Action action) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (action != null) {
			try {
				session.update(action);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public Ehs_Action getIncidentById(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tbl_Incident + " where action_id=?";
		Ehs_Action action = null;
		int intValue = Integer.parseInt(id);
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, intValue);
			action = (Ehs_Action) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

		return action;
	}

	@Override
	public Ehs_Action getActionById(String action_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tbl_Incident + " where action_id=?";
		Ehs_Action action = null;
		int intValue = Integer.parseInt(action_id);
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, intValue);
			action = (Ehs_Action) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

		return action;
	}

	@Override
	public Ehs_witnesed getWitnesedById(String action_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tbl_witnesed + " where action_id=?";
		Ehs_witnesed witnesed = null;
		int intValue = Integer.parseInt(action_id);
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, intValue);
			witnesed = (Ehs_witnesed) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

		return witnesed;
	}

	@Override
	public Ehs_Incident getIncidentByActionId(String action_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tbl_incident + " where action_id=?";
		Ehs_Incident incident = null;
		int intValue = Integer.parseInt(action_id);
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, intValue);
			incident = (Ehs_Incident) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

		return incident;
	}

	@Override
	public boolean saveHazardous(Hazardous_Chemicals chemicals) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (chemicals != null) {
			try {
				session.save(chemicals);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Hazardous_Chemicals> getHazardous_list(Map<String, String> search_field) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * String
		 * hql="from "+tb1_Hazardous+" where hazard_active=1 ORDER BY hazard_id desc ";
		 */
		StringBuilder hql = new StringBuilder("from " + tb1_Hazardous + " where hazard_active=1 ");

		if (search_field != null && !search_field.isEmpty()) {
			for (Map.Entry<String, String> entry : search_field.entrySet()) {
				String value = entry.getValue();
				if (value != null && !value.isEmpty()) {
					String key = entry.getKey();
					hql.append(" and " + key + "='" + value + "' ");
				}
			}
		}
		hql.append("ORDER BY hazard_id desc");
		List<Hazardous_Chemicals> hazard_list = null;
		try {
			Query query = session.createQuery(hql.toString());
			hazard_list = query.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return hazard_list;
	}

	@Override
	public boolean updateHazardous(Hazardous_Chemicals chemicals) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (chemicals != null) {
			try {
				session.update(chemicals);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public Hazardous_Chemicals getHazardousById(String hazard_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tb1_Hazardous + " where hazard_id=?";
		Hazardous_Chemicals chemicals = null;
		int intValue = Integer.parseInt(hazard_id);
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, intValue);
			chemicals = (Hazardous_Chemicals) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

		return chemicals;
	}

	@Override
	public boolean saveProduct(Ehs_Product products) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (products != null) {
			try {
				session.save(products);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean updateProduct(Ehs_Product products) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (products != null) {
			try {
				session.update(products);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Ehs_Product> getProductList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tb1_Product + " where product_active=1 ORDER BY product_id desc ";
		List<Ehs_Product> product_list = null;
		try {
			Query query = session.createQuery(hql);
			product_list = query.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return product_list;
	}

	@Override
	public Ehs_Product getProductById(String product_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tb1_Product + " where product_id=?";
		Ehs_Product ehs_Product = null;
		int intValue = Integer.parseInt(product_id);
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, intValue);
			ehs_Product = (Ehs_Product) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return ehs_Product;
	}

	@Override
	public boolean updateWaste(Ehs_Waste waste) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (waste != null) {
			try {
				session.update(waste);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean saveWaste(Ehs_Waste waste) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (waste != null) {
			try {
				session.save(waste);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}

		}
		return false;
	}

	@Override
	public List<Ehs_Waste> getWasteList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tb1_Waste + " where waste_active=1 ORDER BY waste_id desc ";
		List<Ehs_Waste> waste_list = null;
		try {
			Query query = session.createQuery(hql);
			waste_list = query.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return waste_list;
	}

	@Override
	public Ehs_Waste getWasteById(String waste_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tb1_Waste + " where waste_id=?";
		Ehs_Waste ehs_Waste = null;
		int intValue = Integer.parseInt(waste_id);
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, intValue);
			ehs_Waste = (Ehs_Waste) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

		return ehs_Waste;
	}

	@Override
	public boolean saveTraining(Ehs_Training training) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (training != null) {
			try {
				session.save(training);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Ehs_Training> getTraining_List() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tb1_Training + " where training_active=1 ORDER BY training_id desc ";
		List<Ehs_Training> training_list = null;
		try {
			Query query = session.createQuery(hql);
			training_list = query.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return training_list;
	}

	@Override
	public boolean saveIndustrial(Ehs_Industrial industrial) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (industrial != null) {
			try {
				session.save(industrial);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	@Override
	public List<Ehs_Industrial> getIndustrial_List() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tb1_industrial + " where industrial_active=1 ORDER BY industrial_id desc ";
		List<Ehs_Industrial> industrial_list = null;
		try {
			Query query = session.createQuery(hql);
			industrial_list = query.list();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return industrial_list;

	}

	/*
	 * @Override public boolean saveFactory(Ehs_Factory_Act factory) { Session
	 * session = sessionFactory.openSession(); Transaction tx =
	 * session.beginTransaction();
	 * 
	 * if (factory != null) { try { session.save(factory); tx.commit();
	 * session.close(); return true; } catch (Exception e) { tx.rollback();
	 * session.close(); e.printStackTrace(); return false; } } return false; }
	 * 
	 * @Override public List<Ehs_Factory_Act> getFactroy_List() { Session session =
	 * sessionFactory.openSession(); Transaction tx = session.beginTransaction();
	 * String hql = "from " + tb1_factory +
	 * " where factory_active=1 ORDER BY factory_id desc "; List<Ehs_Factory_Act>
	 * factory_list = null; try { Query query = session.createQuery(hql);
	 * factory_list = query.list(); tx.commit(); session.close(); } catch (Exception
	 * e) { tx.rollback(); session.close(); e.printStackTrace(); } return
	 * factory_list; }
	 */
	/*
	 * @Override public Ehs_Factory_Act getFactoryById( ) { Session
	 * session=sessionFactory.openSession(); Transaction
	 * tx=session.beginTransaction(); String hql="select * from erp_factory";
	 * Ehs_Factory_Act ehs_factory=null; int intValue =
	 * Integer.parseInt(factory_id); try{ Query query=session.createQuery(hql);
	 * 
	 * query.setParameter(0,intValue);
	 * ehs_factory=(Ehs_Factory_Act)query.uniqueResult(); tx.commit();
	 * session.close(); }catch(Exception e){ tx.rollback(); session.close();
	 * e.printStackTrace(); } return ehs_factory; }
	 */

	@Override
	public Ehs_Training getTrainingById(String training_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tb1_Training + " where training_id=?";
		Ehs_Training training = null;
		int intValue = Integer.parseInt(training_id);
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, intValue);
			training = (Ehs_Training) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

		return training;

	}

	@Override
	public Osha_Law getOshaLaw() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from erp_osha_law where osha_active=1 " ;
		Osha_Law osha = null;
		/* int intValue = Integer.parseInt(factory_id); */
		try {
			Query query = session.createQuery(hql);
			/*
			 * query.setParameter(0,intValue);
			 */
			osha = (Osha_Law) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return osha;
	}

	/*
	 * @Override public Ehs_Factory_Act getFactoryById() { // TODO Auto-generated
	 * method stub return null; }
	 */
	@Override
	public Ehs_Factory_Act getFactoryAct() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from erp_factory where factory_active=1 " ;
		Ehs_Factory_Act factory = null;
		/* int intValue = Integer.parseInt(factory_id); */
		try {
			Query query = session.createQuery(hql);
			/*
			 * query.setParameter(0,intValue);
			 */
			factory = (Ehs_Factory_Act) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return factory;
	}

	@Override
	public boolean saveFactory(Ehs_Factory_Act factory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ehs_Factory_Act> getFactroy_List() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ehs_Factory_Act getFactoryById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ehs_Industrial getIndustrialById(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from " + tb1_industrial + " where industrial_id=?";
		Ehs_Industrial industrial = null;
		int intValue = Integer.parseInt(id);
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, intValue);
			industrial = (Ehs_Industrial) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

		return industrial;

	}
	
	@Override
	public boolean saveHira(HIRA hira) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(hira!=null){
			try{
				session.save(hira);
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
	public List<HIRA> getHira_list() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tb1_Hira+" where hira_active=1 ORDER BY hira_id desc ";
		List<HIRA> hira_list=null;
		try{
			Query query=session.createQuery(hql);
			hira_list=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return hira_list;	
		}
	
	 @Override
	 public boolean saveHiraFileDataInDB(ArrayList<HIRA> hiraList) {
	 Session session = sessionFactory.openSession();
	 Transaction tx = session.beginTransaction();
	 try {
	 for ( int i=0; i<hiraList.size();i++ ) {
	 HIRA hira = hiraList.get(i);
	     session.save(hira);
	     if ( i % 20 == 0)  { 
	     	//20, same as the JDBC batch size
	         //flush a batch of inserts and release memory:
	         session.flush();
	         session.clear();
	     }
	 }
	 tx.commit();
	 session.close();
	 } catch (Exception e) {
	 tx.rollback();
	 session.close();
	 e.printStackTrace();
	 return false;
	 }
	 return true;
	 }

	@Override
	public List<Ehs_Waste> getWaste_list1() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tb1_Waste + " where waste_active=1 ORDER BY waste_id desc ";
		List<Ehs_Waste> waste_list = new ArrayList<>();
		List<Ehs_Waste> waste_list_each = null;

		try {

		Query query = session.createQuery(hql);
		waste_list_each = query.list();

		for (Ehs_Waste list : waste_list_each) {
			
		int waste_id    = list.getWaste_id();
		String chem_name = list.getChem_name();
    	String quantity    = list.getQuantity();
    	Date disposal_date = (Date) list.getDisposal_date();
    	String waste_department = list.getWaste_department();
    	String techniques = list.getTechniques();
    	
//			  long contact=rs.getLong(3);
	
		Ehs_Waste	waste = new Ehs_Waste(waste_id,chem_name,quantity,disposal_date,waste_department,techniques);
		waste_list.add(waste);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return waste_list;
	}

	@Override
	public List<Hazardous_Chemicals> getHazardous_list1() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tb1_Hazardous + " where hazard_active=1 ORDER BY hazard_id desc ";
		List<Hazardous_Chemicals> hazardous_list = new ArrayList<>();
		List<Hazardous_Chemicals> hazardous_list_each = null;

		try {

		Query query = session.createQuery(hql);
		hazardous_list_each = query.list();

		for (Hazardous_Chemicals list : hazardous_list_each) {
			
		int hazard_id    = list.getHazard_id();
		String chemical_name   = list.getChemical_name();
    	String prod_code     = list.getProd_code();
    	String formula   = list.getFormula();
    	String supplier_name     = list.getSupplier_name();
    	/*Date disposal_date = (Date) list.getDisposal_date();
    	String waste_department = list.getWaste_department();
    	String techniques = list.getTechniques();*/
    	
//			  long contact=rs.getLong(3);
	
    	Hazardous_Chemicals	chemicals = new Hazardous_Chemicals(hazard_id,chemical_name,prod_code,formula,supplier_name);
		hazardous_list.add(chemicals);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return hazardous_list;
	}

	@Override
	public boolean saveTransport(Ehs_Waste_Transport transport) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (transport != null) {
			try {
				session.save(transport);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}

		}
		return false;
	}

	@Override
	public boolean saveShipping(Ehs_Shipping shipping) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (shipping != null) {
			try {
				session.save(shipping);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}

		}
		return false;
	}

	@Override
	public boolean saveChemicals(Hazardous_Chemicals chemicals) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (chemicals != null) {
			try {
				session.save(chemicals);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

}
