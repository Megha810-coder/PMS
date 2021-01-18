package com.spcl.erp.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Contractor;
import com.spcl.erp.model.Department_type;
import com.spcl.erp.model.Employee;
import com.spcl.erp.model.HrRequirement;
import com.spcl.erp.model.Labour;
import com.spcl.erp.model.LabourCheck;
import com.spcl.erp.model.Product_Packeging;
import com.spcl.erp.model.ShiftTime;
import com.spcl.erp.model.Transfer;
import com.spcl.erp.model.VMS_Feedback;

public class LabourDaoImpl implements LabourDao{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	private String tbl_labour="erp_labour";
	private String tbl_feedback="vms_feedback";
	private String tbl_contract="erp_contractor";
	private String tbl_product="erp_product";
	private String tbl_labour_check="erp_labour_check";
	private String tbl_hrRequirement="erp_hr_requirement";
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveLabour(Labour labour) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(labour!=null){
			try{
				session.save(labour);
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
	public List<Labour> getLabour_list() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql=" from "+tbl_labour+" where lab_active=1 ORDER BY lab_id desc ";
		List<Labour> lab_list=null;
		try{
			Query query=session.createQuery(hql);
			lab_list=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return lab_list;
	}


	@Override
	public boolean updateLabour(Labour labour) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(labour!=null){
			try{
				session.update(labour);
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
	public Labour getLabourById(String lab_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_labour+" where lab_id=?";
		Labour labour=null;
		int intValue = Integer.parseInt(lab_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			labour=(Labour)query.uniqueResult();
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return labour;
	}

	@Override
	public boolean saveContractor(Contractor contract) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(contract!=null){
			try{
				session.save(contract);
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
	public List<Contractor> getContractor_list() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_contract+" where cd_active=1 ORDER BY cd_id desc ";
		List<Contractor> cd_list=null;
		try{
			Query query=session.createQuery(hql);
			cd_list=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return cd_list;
	}

	@Override
	public boolean updateContractor(Contractor contract) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(contract!=null){
			try{
				session.update(contract);
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
	@Override
	public List<LabourCheck> getCheckIn_list() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_labour_check+" where check_active=1 ORDER BY lab_check_id desc ";
		List<LabourCheck> check_list=null;
		try{
			Query query=session.createQuery(hql);
			check_list=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return check_list;
		
	}

	@Override
	public boolean saveLabourCheck(LabourCheck labourCheck) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(labourCheck!=null){
			try{
				session.save(labourCheck);
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
	public LabourCheck getLabCheckById(String lab_check_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_labour_check where lab_check_id=?";
		LabourCheck labourCheck=null;
		int intValue = Integer.parseInt(lab_check_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			labourCheck=(LabourCheck)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return labourCheck;
	}

	@Override
	public boolean updateLabourCheck(LabourCheck labourCheck) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(labourCheck!=null){
			try{
				session.update(labourCheck);
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
	public LabourCheck getSalaryById(String lab_check_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from erp_labour_check where lab_check_id=?";
		LabourCheck labourCheck=null;
		int intValue = Integer.parseInt(lab_check_id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			labourCheck=(LabourCheck)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return labourCheck;
	}

	@Override
	public Integer getTotalHalfDay(Integer labour_lab_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(status)  from erp_labour_check where labour_lab_id=? AND status=0";
		Integer halfDay=null;
		
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,labour_lab_id);
			Long count=(Long) query.uniqueResult();
			halfDay = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return halfDay;
	}

	@Override
	public Integer getTotalfullDay(Integer labour_lab_id) {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(status) from erp_labour_check where labour_lab_id=? AND status=1";
		Integer fullDay=null;
	
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,labour_lab_id);
			Long count=(Long) query.uniqueResult();
			fullDay = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return fullDay;
	}

	@Override
	public Integer getCheckCountById(Integer labour_lab_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(Check_In_Status) from erp_labour_check where labour_lab_id=? AND Check_In_Status='Check_In'";
		Integer checkInCount=null;
	
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,labour_lab_id);
			Long count=(Long) query.uniqueResult();
			checkInCount = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return checkInCount;
}
	@Override
	public List<LabourCheck> getCheckIn_list(Map<String, String> search) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		StringBuilder hql=new StringBuilder("select lb from "+tbl_labour_check+" lb left join fetch erp_department on (dept_id=department_dept_id) where check_active=1");
		
		if (search!=null&&!search.isEmpty()) {
			//hql=new StringBuilder("from "+tbl_labour_check+" where check_active=1 ");
			for(Map.Entry<String, String> entry : search.entrySet()) {
				String value = entry.getValue();
				if (value!=null&&!value.isEmpty()) {
					String key = entry.getKey();
					if (key.equals("week")) {						
						hql.append(" and check_in_time between subdate(current_date(),7) AND current_date() " );
					}else if (key.equals("month")) {						
						hql.append(" and check_in_time between subdate(current_date(),30) AND current_date() " );
					}else if (key.equals("year")) {						
						hql.append(" and check_in_time between subdate(current_date(),365) AND current_date() " );
					}else if(key.equals("1") ){	
						 hql.append(" and shift_id=1") ;
					 }else if(key.equals("2")) {	
						 hql.append(" and shift_id=2") ;
					 } else if(key.equals("3") ){	
						 hql.append(" and shift_id=3") ;
					 }else {
						hql.append(" and "+key+"='"+value+"' " );
					}
					
				}
			}
		}
		hql.append("ORDER BY lab_check_id desc");
		
		List<LabourCheck> check_list=null;
		try{
			Query query=session.createQuery(hql.toString());
			check_list=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return check_list;
		
	}

	@Override
	public boolean saveFileDataInDB(ArrayList<Labour> labourList) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			try {
				for ( int i=0; i<labourList.size(); i++ ) {
					Labour lab = labourList.get(i);
				    session.save(lab);
				    if ( i % 20 == 0 ) { 
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
	public List<LabourCheck> getCheckInListById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_labour_check+" where labour_lab_id=?";
		List<LabourCheck> labcheck=null;
		int intval=Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intval);
			labcheck=query.list();
			tx.commit();
			
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return labcheck;
	}
	@Override
	public boolean saveConFileDataInDB(ArrayList<Contractor> contractorList) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			try {
				for ( int i=0; i<contractorList.size(); i++ ) {
					Contractor con = contractorList.get(i);
				    session.save(con);
				    if ( i % 20 == 0 ) { 
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
	public Integer getTodayTotalLabourCheckIN() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(labour_lab_id)  from erp_labour_check where Check_in_time=current_date() ";
		Integer totalCHeckIn=null;
		
		try{
			Query query=session.createQuery(hql);
			
			Long count=(Long) query.uniqueResult();
			totalCHeckIn = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return totalCHeckIn;
	}

	@Override
	public Integer getContractLabourShiftCOunt1(Integer cd_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(labour_lab_id)  from erp_labour_check where cd_id=? AND Check_in_time=current_date and shift_id=1 ";
		Integer shift1Count=null;
		
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,cd_id);
			Long count=(Long) query.uniqueResult();
			shift1Count = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return shift1Count;
	}
	
	@Override
	public Integer getContractLabourShiftCOunt2(Integer cd_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(labour_lab_id)  from erp_labour_check where Check_in_time=current_date and shift_id=2 ";
		Integer shift2Count=null;
		
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,cd_id);
			Long count=(Long) query.uniqueResult();
			shift2Count = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return shift2Count;
	}
	
	@Override
	public Integer getContractLabourShiftCOunt3(Integer cd_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(labour_lab_id)  from erp_labour_check where cd_id=? and Check_in_time=current_date and shift_id=3 ";
		Integer shift3Count=null;
		
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,cd_id);
			Long count=(Long) query.uniqueResult();
			shift3Count = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return shift3Count;
	}
	@Override
	public Integer getTotalLabour() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select count(lab_id) from  erp_labour where lab_active=1";
		Integer totalLabour=null;
		
		try{
			Query query=session.createQuery(hql);
			//query.setParameter(0,Lab_id);
			Long count=(Long) query.uniqueResult();
			totalLabour = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return totalLabour;
	}
	
	@Override
	public Integer getTotalContractor() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select count(cd_id) from  erp_contractor where cd_active=1";
		Integer totalContracter=null;
		
		try{
			Query query=session.createQuery(hql);
			//query.setParameter(0,lab_id);
			Long count=(Long) query.uniqueResult();
			totalContracter = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return totalContracter;
	}

	@Override
	public List<Object> gettotalweeklyCount() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String sql="select "
				+ " SUM(case when check_in_time between DATE_SUB(current_date(),INTERVAL 7 DAY) AND current_date() then 1 else 0 end) as weekcnt,"
				+ " SUM(case when check_in_time between DATE_SUB(current_date(),INTERVAL 1 MONTH) AND current_date() then 1 else 0 end) as monthcnt,"
				+ " SUM(case when check_in_time between DATE_SUB(current_date(),INTERVAL 1 YEAR) AND current_date() then 1 else 0 end) as yearcnt"
				+ " from erp_labour_check";
		List cntlist=null;
		try{
			Query query=session.createSQLQuery(sql);
			cntlist=query.list();
			tx.commit();
			session.close();
		}
		 catch(Exception e)
		 {
			 tx.rollback();
			 session.close();
			 e.printStackTrace();
		 }
		
		return cntlist;
	}
	@Override
	public List<LabourCheck> getLabListById(Integer id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_labour_check+" where labour_lab_id=?";
		List<LabourCheck> labcheck=null;
		
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,id);
			labcheck=query.list();
			tx.commit();
			
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return labcheck;
	}
	@Override
	public Integer getLabCheckIDByLabID(String cd_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select lab_check_id from erp_labour_check where labour_lab_id=? ";
		Integer shift3Count=null;
		
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,cd_id);
			Long count=(Long) query.uniqueResult();
			shift3Count = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return shift3Count;
	}

	
	@Override
	public List<LabourCheck> getSalaryListById(Integer id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select salary from erp_labour_check where labour_lab_id=?";
		List<LabourCheck> labcheck=null;
		
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,id);
			labcheck=query.list();
			tx.commit();
			
		}
		catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return labcheck;
	}
	
	@Override
	public Integer getLabourCheckinShift1COunt() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(labour_lab_id)  from erp_labour_check where shift_id=1 And check_in_time=current_date()";
		Integer shift1Count=null;
		
		try{
			Query query=session.createQuery(hql);
			
			Long count=(Long) query.uniqueResult();
			shift1Count = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return shift1Count;
	}

	@Override
	public Integer getLabourCheckinShift2COunt() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(labour_lab_id)  from erp_labour_check where shift_id=2 And check_in_time=current_date()";
		Integer shift2Count=null;
		
		try{
			Query query=session.createQuery(hql);
			
			Long count=(Long) query.uniqueResult();
			shift2Count = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return shift2Count;
	}

	@Override
	public Integer getLabourCheckinShift3COunt() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(labour_lab_id)  from erp_labour_check where shift_id=3 And check_in_time=current_date()";
		Integer shift3Count=null;
		
		try{
			Query query=session.createQuery(hql);
			
			Long count=(Long) query.uniqueResult();
			shift3Count = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return shift3Count;
	}

	@Override
	public Integer getLabourCheckinDepartment1COunt() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(labour_lab_id)  from erp_labour_check where department_dept_id=1 and shift_id=1" ;
		
		Integer department1Count=null;
		
		try{
			Query query=session.createQuery(hql);
			
			Long count=(Long) query.uniqueResult();
			department1Count = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return department1Count;
	}
	
	@Override
	public Integer getTotalLeaveDay(Integer labour_lab_id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="Select count(status) from erp_labour_check where labour_lab_id=? AND status=2";
		Integer leave=null;
	
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,labour_lab_id);
			Long count=(Long) query.uniqueResult();
			leave = (int) (long) count;
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return leave;
	}
	@Override
	public Integer getTotalHrlabourrequirement() {
	Session session=sessionFactory.openSession();
	Transaction tx=session.beginTransaction();
	String hql="select sum(labour_required) from erp_hr_requirement where hr_created_date=current_date()";
	        Integer TotalHrlabourrequirement=null;

	try{
	Query query=session.createQuery(hql);

	TotalHrlabourrequirement= Integer.parseInt((String) query.uniqueResult());

	tx.commit();
	session.close();
	}
	 catch(Exception e)
	 {
	 tx.rollback();
	 session.close();
	 e.printStackTrace();
	 }

	return TotalHrlabourrequirement;
	}

	@Override
	public List<Labour> getLabour_list1() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tbl_labour + " where lab_active=1 ORDER BY lab_id desc ";
		List<Labour> lab_list = new ArrayList<>();
		List<Labour> lab_list_each = null;

		try {

		Query query = session.createQuery(hql);
		lab_list_each = query.list();

		for (Labour list : lab_list_each) {
		int lab_id = list.getLab_id();
		String lab_code = list.getLab_code();
//			  long contact=rs.getLong(3);
		String lab_fname = list.getLab_fname();
		String lab_mname = list.getLab_mname();
		String lab_lname = list.getLab_lname();
		String lab_mobile_no =list.getLab_mobile_no();
		String lab_dob = list.getLab_dob();
		Labour	emp = new Labour(lab_id, lab_code, lab_fname, lab_mname,lab_lname,lab_mobile_no,lab_dob);
		lab_list.add(emp);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return lab_list;
	}

	@Override
	public List<Contractor> getContractor_list1() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tbl_contract + " where cd_active=1 ORDER BY cd_id desc ";
		List<Contractor> contractor_list = new ArrayList<>();
		List<Contractor> contractor_list_each = null;

		try {

		Query query = session.createQuery(hql);
		contractor_list_each = query.list();

		for (Contractor list : contractor_list_each) {
		int cd_id   = list.getCd_id();
		String cd_code = list.getCd_code();
//			  long contact=rs.getLong(3);
		String cd_fname = list.getCd_fname();
		String cd_mname = list.getCd_mname();
		String cd_lname = list.getCd_lname();
		
		Contractor	contractor = new Contractor(cd_id, cd_code, cd_fname, cd_mname,cd_lname);
		contractor_list.add(contractor);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return contractor_list;
	}

	@Override
	public List<LabourCheck> getLabourCheck_list1() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tbl_labour_check + " where check_active=1 ORDER BY lab_check_id desc ";
		List<LabourCheck> labourcheck_list = new ArrayList<>();
		List<LabourCheck> labourcheck_list_each = null;

		try {

		Query query = session.createQuery(hql);
		labourcheck_list_each = query.list();

		for (LabourCheck list : labourcheck_list_each) {
			
		int lab_check_id    = list.getLab_check_id();
//		String department_dept_id  = list.get;
//			  long contact=rs.getLong(3);
	
		LabourCheck	labourcheck = new LabourCheck(lab_check_id);
		labourcheck_list.add(labourcheck);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return labourcheck_list;
	}

	
	@Override
	public boolean saveFeedback(VMS_Feedback feedback) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		if (feedback != null) {
			try {
				session.save(feedback);
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
	public List<VMS_Feedback> getFeedback_list1() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from " + tbl_feedback + " where feedback_active=1 ORDER BY feedback_id desc ";
		List<VMS_Feedback> feedback_list = new ArrayList<>();
		List<VMS_Feedback> feedback_list_each = null;

		try {

		Query query = session.createQuery(hql);
		feedback_list_each = query.list();

		for (VMS_Feedback list : feedback_list_each) {
				/*
				 * int feedback_id = list.getLab_id(); String lab_mname = list.getLab_mname();
				 * String lab_lname = list.getLab_lname(); VMS_Feedback feedback = new
				 * VMS_Feedback(lab_id, lab_code, lab_fname,
				 * lab_mname,lab_lname,lab_mobile_no,lab_dob);
				 */
//		feedback_list.add(feedback);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return feedback_list;
	}

	@Override
	public List<Contractor> getContractor_name() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "select cd_fname from erp_contractor where cd_active=1";
		List<Contractor> con_name = new ArrayList<>();
		List<Contractor> con_name_each = null;
		try {

		Query query = session.createQuery(hql);
		con_name_each = query.list();

		/*for (Contractor list : con_name_each) {

			String cd_fname = list.getCd_fname();
			
			Contractor	contractor = new Contractor(cd_fname);
			con_name.add(contractor);
		}*/

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return con_name_each;

	}

	@Override
	public List<Labour> getLabour_name() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "select lab_fname from erp_labour where lab_active=1 and cd_id=?";
		List<Labour> lab_name = new ArrayList<>();
		List<Labour> lab_name_each = null;
		try {

		Query query = session.createQuery(hql);
		lab_name_each = query.list();

		

			for (Labour list : lab_name_each) {
			int lab_id   = list.getLab_id();
			String lab_code = list.getLab_code();
//				  long contact=rs.getLong(3);
			String lab_fname = list.getLab_fname();
			String lab_mname = list.getLab_mname();
			String lab_lname = list.getLab_lname();
			String lab_mobile_no = list.getLab_mobile_no();
			String lab_dob = list.getLab_dob();
			
			Labour labour = new Labour(lab_id,lab_code,lab_fname,lab_mname,lab_lname,lab_mobile_no,lab_dob);
			lab_name.add(labour);

			}

		tx.commit();
		session.close();
		} catch (Exception e) {
		tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return lab_name_each;

	}
	
	@Override
	public List<Labour> getById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select lab_fname from erp_labour where lab_active=1 and cd_id=?";
		List<Labour> lab=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			lab = query.list();
			/*lab=(List<Labour>)query.uniqueResult();*/
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return lab;
	}

	
	@Override
	public List<ShiftTime> getShift() {
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	String hql = "select shift_status from erp_shift_time";
	List<ShiftTime> shift = new ArrayList<>();
	List<ShiftTime> shift_each= null;
	try {

	Query query = session.createQuery(hql);
	shift_each = query.list();

	tx.commit();
	session.close();
	} catch (Exception e) {
	tx.rollback();
	session.close();
	e.printStackTrace();
	}
	return shift_each;
	}

	@Override
	public boolean saveHrRequirement(HrRequirement hrrequirement) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(hrrequirement!=null){
			try{
				session.save(hrrequirement);
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
	public List<HrRequirement> getHrRequirement_list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = " from "+tbl_hrRequirement+" where hr_active=1";
		List<HrRequirement> hrRequirement_list = new ArrayList<>();
		List<HrRequirement> hrRequirement_list_each = null;

		try {

		Query query = session.createQuery(hql);
		hrRequirement_list_each = query.list();

		for (HrRequirement list : hrRequirement_list_each) {
				
				  int hr_req_id = list.getHr_req_id();
				  String hr_department = list.getDepartment_type().getDt_department_name();
				  String hr_shifts = list.getShift_time().getShift_status();
				  java.util.Date hr_created_date = list.getHr_created_date();
				  
				  HrRequirement hrequirement = new HrRequirement(hr_req_id,hr_created_date,hr_department,hr_shifts);
				 
				  hrRequirement_list.add(hrequirement);

		}

		tx.commit();
		session.close();
		} catch (Exception e) {

			tx.rollback();
		session.close();
		e.printStackTrace();
		}
		return hrRequirement_list;
	}
	
	@Override
	 public List<Department_type> getDept_name() {
	 Session session = sessionFactory.openSession();
	 Transaction tx = session.beginTransaction();
	 String hql = "select dt_department_name from erp_department where dept_active=1";
	 List<Department_type> dept = new ArrayList<>();
	 List<Department_type> dept_each = null;
	 try {

	 Query query = session.createQuery(hql);
	 dept_each = query.list();

	 tx.commit();
	 session.close();
	 } catch (Exception e) {
	 tx.rollback();
	 session.close();
	 e.printStackTrace();
	 }
	 return dept_each;
	 }
	/* @Override
	 public Contractor getContractorById(String cd_id) {
	 Session session = sessionFactory.openSession();
	 Transaction tx = session.beginTransaction();
	 String hql = "from "+tbl_contract+" where cd_id=?";
	 Contractor contract = null;
	 int intval = Integer.parseInt(cd_id);
	 try {
	 Query query = session.createQuery(hql);
	 query.setParameter(0, intval);
	 contract = (Contractor) query.uniqueResult();
	 tx.commit();

	 } catch (Exception e) {
	 tx.rollback();
	 session.close();
	 e.printStackTrace();
	 }

	 return contract;
	 }*/
//	 @Override
//		public Integer getTotalLabour(Integer labour_lab_id) {
//			Session session=sessionFactory.openSession();
//			Transaction tx=session.beginTransaction();
//			String hql="Select count(status)  from erp_labour_check where labour_lab_id=? AND status=0";
//			Integer halfDay=null;
//			
//			try{
//				Query query=session.createQuery(hql);
//				query.setParameter(0,labour_lab_id);
//				Long count=(Long) query.uniqueResult();
//				halfDay = (int) (long) count;
//				tx.commit();
//				session.close();
//			}
//		 catch(Exception e)
//		 {
//			 tx.rollback();
//			 session.close();
//			 e.printStackTrace();
//		 }
//			
//			return halfDay;
//		}

	/*@Override
	public Integer getById1(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="select count(cd_id) from erp_labour where lab_active=1 and cd_id=?";
		Integer lab=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			//query.setParameter(1,intValue );
			lab = query.list();
			lab=(List<Labour>)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return lab;
	
	}*/
	
	 @Override
	 public Integer getById1(String id) {
	 Session session = sessionFactory.openSession();
	 Transaction tx = session.beginTransaction();
	 String hql = "select count(cd_id) from erp_labour where lab_active=1 and cd_id=?";
	 Integer contract = null;
	 int intval = Integer.parseInt(id);
	 try {
	 Query query = session.createQuery(hql);
	 query.setParameter(0, intval);
	 Long count=(Long) query.uniqueResult();
	 contract = (int) (long) count;
	 tx.commit();

	 } catch (Exception e) {
	 tx.rollback();
	 session.close();
	 e.printStackTrace();
	 }

	 return contract;
	 }

	
}


