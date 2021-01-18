package com.spcl.erp.helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.spcl.erp.model.City;
import com.spcl.erp.model.Contractor;
import com.spcl.erp.model.Country;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Department_type;
import com.spcl.erp.model.Labour;
import com.spcl.erp.model.Leave_Request;
import com.spcl.erp.model.RequestQuotation;
import com.spcl.erp.model.RfqProductList;
import com.spcl.erp.model.SalePerson;
import com.spcl.erp.model.ShiftTime;
import com.spcl.erp.model.Transfer;
import com.spcl.erp.model.Transfer_Product;
import com.spcl.erp.services.PurchaseService;

public class Helper {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PurchaseService purchaseService;
	
	public static final String EMPLOYEE_IMG_PATH ="C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/emp_img/";
	public static final String CUSTOMER_IMG_PATH ="C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/cust_img/";
	public static final String PRODUCT_IMG_PATH ="C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/product_img/";
	public static final String SALEPERSON_IMG_PATH ="C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/saleperson_img/";
	public static final String LAB_IMG_PATH = "C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/lab_img/";
	public static final String CONT_IMG_PATH = "C:/Users/Dell/Documents/Received Files/erp-company/erp_company/src/main/webapp/resources/cd_img/";
	public static final String EMP_EXCEl_PATH ="C:/Users/Dell/eclipse-workspace/erp_lcm/src/main/webapp/resources/emp_import_excel_file/";
	public static final String INCIDENT_DOC_PATH ="C:/Users/admin/Desktop/ERP FILE/erp_lcm/src/main/webapp/resources/incident_doc/";
	public static final String WASTE_DOC_PATH ="C:/Users/admin/Desktop/ERP FILE/erp_lcm/src/main/webapp/resources/waste_doc/";

	
	public static final Integer PO_RFQ=new Integer(1);
	public static final Integer PO_MAIL=new Integer(2);
	public static final Integer PO_ORDER=new Integer(3);
	
	public static final Integer TRA_DRAFT=new Integer(1);
	public static final Integer TRA_WATING=new Integer(2);
	public static final Integer TRA_READY=new Integer(3);
	public static final Integer TRA_DONE=new Integer(4);
	
	public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("MM/dd/yyyy");
	public static final SimpleDateFormat VIEWDATEFORMAT = new SimpleDateFormat("yyyy-mm-dd");
	
	public static final Integer To_APPROVE=new Integer(1);
	public static final Integer APPROVED=new Integer(2);
	public static final Integer REFUSE=new Integer(3);
	
	public static final String GENDER_FEMALE = "Female";
	public static final String GENDER_MALE = "Male";
	
	public static final String MARITAL_SINGLE="Single";
	public static final String MARITAL_MARRIED="Married";
	public static final String MARITAL_DIVORCE="Divorce";
	public static final String MARITAL_WIDWOE="Widowe";
	public static final String MARITAL_LEGAL_COHABITANT="Legal Cohabitant";
	
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public String getErrors(BindingResult result) {
		String error="";
		for (FieldError errorfile : result.getFieldErrors() ) {
	        error +=errorfile.getField()+ " - " + errorfile.getDefaultMessage()+"\n";
		 }
		 return error;
		
	}
	
	
	public String getContryDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select cntry_id,cntry_name from erp_country where cntry_flag=1 ORDER BY cntry_name asc";
		List coutry_list=null;
		try{
			Query query=session.createQuery(hql);
			coutry_list=query.list();
			tx.commit();
			List<Object[]> list = query.list();
			for(Object[] arr : list){
				return_value+="<option value='"+arr[0]+"'>"+arr[1]+"</option>/n";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
		

	}
	
	
	public JSONArray getCityDropDownJson(String city_name) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select city_id,city_name from erp_city where city_name like ? ORDER BY city_name asc";
		JSONArray returnjason=new JSONArray();
		List<Object[]> city_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(50);
			query.setString(0,city_name+"%");
			city_list=query.list();
			tx.commit();
			for(Object[] city : city_list){
				returnjason.put(new JSONObject().put("id",city[0]).put("text",city[1]));
			}
			return returnjason;
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
			return null;
		}
		

	}
	
	public Country getCountryById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_country where cntry_flag=1 and cntry_id=?";
		Country cntry=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			cntry=(Country)query.uniqueResult();
			tx.commit();
			
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return cntry;
	}
	
	
	public String getRootPath() {
		return System.getProperty("catalina.home");
		
	}

	public City getCityByID(int city_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_city where city_id=?";
		City city=null;
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,city_id);
			city=(City)query.uniqueResult();
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return city;
	}
	
	public String getCustomerAddress(Customer customer) {
		if (customer==null) {
			return "";
		}
		String ad_line_1=customer.getCust_adds_line1()!=null?customer.getCust_adds_line1():"";
		String ad_line_2=customer.getCust_adds_line2()!=null?customer.getCust_adds_line2():"";
		
		String address=ad_line_1+",\n"+ad_line_2+",\n"
							+customer.getEnq_city().getCity_name()+","
								+customer.getEnq_city().getErp_state().getState_name()+","
										+customer.getEnq_city().getErp_state().getErp_cuntry().getCntry_name();
		 return address;
		
	}
	
	public String getOperationDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select opt_id,operation from erp_operation  ORDER BY operation asc";
		List operation_list=null;
		try{
			Query query=session.createQuery(hql);
			operation_list=query.list();
			tx.commit();
			List<Object[]> list = query.list();
			for(Object[] operation : list){
				return_value+="<option value='"+operation[0]+"'>"+operation[1]+"</option>/n";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
		

	}
	
	
	public String getProductDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select pro_id,pro_name from erp_product ORDER BY pro_name asc";
		List<Object[]> product_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(100);;
			product_list=query.list();
			tx.commit();
			for(Object[] product : product_list){
				return_value+="<option value='"+product[0]+"'>"+product[1]+"</option>";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
		

	}

	public List<Transfer_Product> getTrpListformDB(Integer tra_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql=" from erp_transfer_product_list where tra_id= :tra_id ORDER BY trp_id asc";
		List<Transfer_Product> product_list=null;
		try{
			Query query=session.createQuery(hql);
			query.setParameter("tra_id", tra_id);
			product_list=query.list();
			tx.commit();
			
			return product_list;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return product_list;
		}
	}
	
	public String getEmployeeCode() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select count(emp_id) from erp_employee where emp_active=1";
		try{
			Query query=session.createQuery(hql);
			Long count = (Long)query.uniqueResult();
			tx.commit();
			return new String("COMP-"+count.longValue());
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return new String("");
		}
	}
	
	public Map<String, String> get_Certificate_list() {
		Map<String, String> cert_list = new HashMap<String, String>();
		cert_list.put("1", "Master");
		cert_list.put("2", "Bachelor");
		cert_list.put("3", "Graduate");
		cert_list.put("4", "Diploma");
		cert_list.put("5", "HSC");
		cert_list.put("6", "SSC");
		
		return cert_list;
	}
	
	public Map<String, String> get_Degree_list() {
		Map<String, String> cert_list = new HashMap<String, String>();
		cert_list.put("1", "Phd");
		cert_list.put("2", "MCS");
		cert_list.put("3", "MCA");
		cert_list.put("4", "M.Tech");
		cert_list.put("5", "B.Tech");
		cert_list.put("6", "ME");
		cert_list.put("7", "BE");
		return cert_list;
	}
	
	public JSONArray getBankDropDownJson(String bank_name) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select bnk_id,bnk_name from erp_bank where bnk_name like ? ORDER BY bnk_name asc";
		JSONArray returnjason=new JSONArray();
		List<Object[]> bank_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(50);
			query.setString(0,bank_name+"%");
			bank_list=query.list();
			tx.commit();
			for(Object[] bank : bank_list){
				returnjason.put(new JSONObject().put("id",bank[0]).put("text",bank[1]));
			}
			return returnjason;
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
			return null;
		}
		

	}
	
	public String getVendorDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select cust_id,cust_fname from erp_customer where cust_vendor=1";
		List<Object[]> vendor_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(100);;
			vendor_list=query.list();
			tx.commit();
			for(Object[] vendor : vendor_list){
				return_value+="<option value='"+vendor[0]+"'>"+vendor[1]+"</option>";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
	}

	public Customer getVendorById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_customer where cust_active=1 and cust_id=?";
		Customer customer=null;
		int intval=Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intval);
			customer=(Customer)query.uniqueResult();
			tx.commit();
			
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return customer;
	}
	
	public String getRepresentativeDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select salep_id,salep_fname from erp_saleperson where salep_active=1";
		List<Object[]> saleperson_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(100);;
			saleperson_list=query.list();
			tx.commit();
			for(Object[] saleperson : saleperson_list){
				return_value+="<option value='"+saleperson[0]+"'>"+saleperson[1]+"</option>";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
}

	public SalePerson getRepresentativeById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_saleperson where salep_active=1 and salep_id=?";
		SalePerson saleperson=null;
		int intval=Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intval);
			saleperson=(SalePerson)query.uniqueResult();
			tx.commit();
			
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return saleperson;
	}
	
		
	public List<RfqProductList> getProductListformDB(Integer rfq_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql=" from erp_rfq_product_list where rfq_id= :rfq_id ORDER BY rfq_id asc";
		List<RfqProductList> prod_list=null;
		try{
			Query query=session.createQuery(hql);
			query.setParameter("rfq_id", rfq_id);
			prod_list=query.list();
			tx.commit();
			
			return prod_list;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return prod_list;
		}
	}
	
	public String SendRFQMail(Integer rfq_id) {
		
		return null;
		
	}
	
	public String getStatusLable(RequestQuotation  rfq) {
		String status_lbl="";
		switch (rfq.getRfq_label_status().intValue()) {
		case 1:
			status_lbl="RFQ-SENT";
			break;
			
		case 2:
			status_lbl="PURCHASE ORDER";
			break;

		case 3:
			status_lbl="RFQ";
			break;
		
		}
		return status_lbl;
	}
	
	
	public  Float getProductNetAmt(RequestQuotation rfq) {
		float gross_amount=0.00f;
 		float net_amount=0.00f;
 		float tax_amount=0.00f;          
		 
		 List<RfqProductList> rfpl_list=new ArrayList<RfqProductList>();
		 rfpl_list=rfq.getRfqproductlist();
		 	for(RfqProductList prod_list:rfpl_list) {
		 		Integer prod_id=prod_list.getRfpl_prod_id();
		 		float rfpl_qty=prod_list.getRfpl_qty();
		 		
				float rfpl_subtotal=getProductSubtotal(prod_id.toString());
		 		float rfpl_unit_price=prod_list.getRfpl_unit_price();
		 		float tax=prod_list.getRfpl_tax_id();
		 		gross_amount=gross_amount+rfpl_subtotal;
		 		tax_amount=tax_amount+(rfpl_subtotal*(tax/100));
		 	}
		 	return net_amount=(gross_amount+tax_amount);
   
	}
	
	public  Float getProductSubtotal(String prod_id) {
		RfqProductList prod_listdb=purchaseService.getProductById(prod_id);
		float rfpl_qty=prod_listdb.getRfpl_qty();
		float rfpl_unit_price=prod_listdb.getRfpl_unit_price();
		float tax=prod_listdb.getRfpl_tax_id();
		float rfpl_subtotal=prod_listdb.getRfpl_subtotal();
	
		return rfpl_subtotal=(rfpl_unit_price)*(rfpl_qty);
    
	}
	public String getCategoryDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select cat_id,Scategory from erp_category ORDER BY Scategory asc";
		List<Object[]> category_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(100);;
			category_list=query.list();
			tx.commit();
			for(Object[] category : category_list){
				return_value+="<option value='"+category[0]+"'>"+category[1]+"</option>";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
		

	}
	public String getStatusLable(Transfer  transfer) {
		
		String  tra_lable_value="";
		switch (transfer.getTra_lable().intValue()) {
		case 1:
			 tra_lable_value="DRAFT";
			break;
			
		case 2:
			 tra_lable_value="WATING";
			break;
			
		case 3:
			 tra_lable_value="READY";
			break;
			
		case 4:
			 tra_lable_value="DONE";
			break;

		default:
			 tra_lable_value="DRAFT";
			break;
		}
		return  tra_lable_value;
	}

	public Float getTaxById(Integer rfpl_tax_id, float sub_total) {
		
		float tax=0.00f;
		if (rfpl_tax_id!=null) {
			switch (rfpl_tax_id.intValue()) {
			case 1:
				 tax+=sub_total*0.02;
				break;
			case 2:
				tax+=sub_total*0.05;
				break;
				
			case 3:
				tax+=sub_total*0.08;
				break;
				
			default:
				break;
			}
		}
		return  new Float(tax);
	}
	
	
	public String getProductName(Integer  transfer) {
		
		String  tra_lable_value="";
		switch (transfer.intValue()) {
		case 1:
			 tra_lable_value="Milk";
			break;
		case 2:
			 tra_lable_value="Cud";
			break;
			
		case 3:
			 tra_lable_value="Buttermilk";
			break;
		
		default:
			 tra_lable_value="Not-set";
			break;
		}
		return  tra_lable_value;
	}
	
	public String getPONo() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select count(rfq_id) from erp_request_for_quotation where rfq_active=1 and rfq_isPO=1";
		try{
			Query query=session.createQuery(hql);
			Long count = (Long)query.uniqueResult();
			tx.commit();
			return new String("PO-"+count.longValue());
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return new String("");
		}
	}
	public String getRFQNo() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select count(rfq_id) from erp_request_for_quotation where rfq_active=1";
		try{
			Query query=session.createQuery(hql);
			Long count = (Long)query.uniqueResult();
			tx.commit();
			return new String("RFQ-"+count.longValue());
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return new String("");
		}
	}

	public String getLabourCode() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select count(lab_id) from erp_labour where lab_active=1";
		try{
			Query query=session.createQuery(hql);
			Long count = (Long)query.uniqueResult();
			tx.commit();
			return new String("LAB-"+count.longValue());
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return new String("");
		}
	}

	public String getContractorCode() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select count(cd_id) from erp_contractor where cd_active=1";
		try{
			Query query=session.createQuery(hql);
			Long count = (Long)query.uniqueResult();
			tx.commit();
			return new String("CONT-"+count.longValue());
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return new String("");
		}
	}
	public City getCityByName(String inputCellValue) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from erp_city where city_name=?";
		City city = null;
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, inputCellValue);
			city = (City)query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}

		return city;
	}
	public Department_type getDeptByName(String inputCellValue) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from erp_department where dt_department_name=?";
		Department_type dept = null;
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, inputCellValue);
			dept =(Department_type)query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return dept;
	}
	public Department_type getDepartmentById(String dept_id) {
		
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			String hql="from erp_department where dept_active=1 and dept_id=?";
			Department_type dept=null;
			int intval=Integer.parseInt(dept_id);
			try{
				Query query=session.createQuery(hql);
				query.setParameter(0,intval);
				dept=(Department_type)query.uniqueResult();
				tx.commit();
				
			}
			catch(Exception e){
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
			
			return dept;
	}
	
	public String getDepartmentDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select dept_id,dt_department_name from erp_department order by dt_department_name asc";
		List<Object[]> dept_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(100);;
			dept_list=query.list();
			tx.commit();
			for(Object[] dept : dept_list){
				return_value+="<option value='"+dept[0]+"'>"+dept[1]+"</option>";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
	}
	public String getDepartmentDropDown1() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select dept_id,dt_department_name from erp_department order by dt_department_name asc";
		List<Object[]> dept_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(100);;
			dept_list=query.list();
			tx.commit();
			for(Object[] dept : dept_list){
				return_value+="<option value='"+dept[1]+"'>"+dept[1]+"</option>";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
	}
	
	public Contractor getContractorById(String cd_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_contractor where cd_id=?";
		Contractor contract=null;
		int intval=Integer.parseInt(cd_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intval);
			contract=(Contractor)query.uniqueResult();
			tx.commit();
			
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return contract;
	}
	

	public String getContractorDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select cd_id,cd_fname,cd_lname,cd_mname from erp_contractor order by cd_id asc";
		List<Object[]> ctr_list=null;
		try{
			Query query=session.createQuery(hql).setMaxResults(100);;
			ctr_list=query.list();
			tx.commit();
			for(Object[] ctr : ctr_list){
				return_value+="<option value='"+ctr[0]+"'>"+ctr[1]+"</option>";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
	}
	public Labour getLabourById(String lab_id) {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_labour where lab_active=1 and lab_id=?";
		Labour lab=null;
		int intval=Integer.parseInt(lab_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intval);
			lab=(Labour)query.uniqueResult();
			tx.commit();
			
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return lab;
	}

	public String getLabourDropDown() {

			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			String return_value="";
			String hql="select lab_id,lab_fname from erp_labour order by lab_fname asc";
			List<Object[]> lab_list=null;
			try{
				Query query=session.createQuery(hql).setMaxResults(100);;
				lab_list=query.list();
				tx.commit();
				for(Object[] dept : lab_list){
					return_value+="<option value='"+dept[0]+"'>"+dept[1]+"</option>";
				}
				return return_value;
			}
			catch(Exception e)
			{
				tx.rollback();
				session.close();
				e.printStackTrace();
				return return_value;
			}
		}
	public String getStatusLable(Leave_Request  leave_request) {

		String lable_status_value="";
		switch (leave_request.getLr_status().intValue()) {
		case 1:
		lable_status_value="To Approve";
		break;
		case 2:
			lable_status_value="Approved";
		break;
		case 3:
			lable_status_value="Refuse";
		break;
		}
		return  lable_status_value;
	}
	public String getShiftTimeDropDown() {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String return_value="";
		String hql="select shift_id,shift_status from erp_shift_time";
		List shift_list=null;
		try{
			Query query=session.createQuery(hql);
			shift_list=query.list();
			tx.commit();
			List<Object[]> list = query.list();
			for(Object[] arr : list){
				return_value+="<option value='"+arr[0]+"'>"+arr[1]+"</option>/n";
			}
			return return_value;
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
			return return_value;
		}
		

	}
	
	public ShiftTime getShiftTimeById(Integer shift_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_shift_time where shift_id=?";
		ShiftTime  shift=null;
		/*int intValue = Integer.parseInt(shift_id);*/
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,shift_id);
			shift=(ShiftTime)query.uniqueResult();
			tx.commit();
			
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return shift;
	}
	
	public List<ShiftTime> getShiftTime_list(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql=" from erp_shift_time";
		List<ShiftTime> shiftTime_list=null;
		try{
			Query query=session.createQuery(hql);
			shiftTime_list=query.list();
			tx.commit();
			session.close();
			}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return shiftTime_list;
	}
	public Contractor getContractorByName(String cd_fname) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_contractor where cd_active=1 and cd_fname=?";
		Contractor con=null;
		String intval=cd_fname;
		try{
		Query query=session.createQuery(hql);
		query.setParameter(0,intval);
		con=(Contractor)query.uniqueResult();
		tx.commit();

		}
		catch(Exception e){
		tx.rollback();
		session.close();
		e.printStackTrace();
		}

		return con;
		}
	
	
	public ShiftTime getShiftByName(String shift) {

		 Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 String hql="from erp_shift_time where shift_status=?";
		 ShiftTime shift_status=null;
		 String intval=shift;
		 try{
		 Query query=session.createQuery(hql);
		 query.setParameter(0,intval);
		 shift_status=(ShiftTime)query.uniqueResult();
		 tx.commit();

		 }
		 catch(Exception e){
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
		 }

		 return shift_status;
	
	}

}
