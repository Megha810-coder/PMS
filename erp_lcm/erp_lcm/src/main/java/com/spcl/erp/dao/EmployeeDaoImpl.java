package com.spcl.erp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Employee;
import com.spcl.erp.model.Transfer;

public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_employee="erp_employee";
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

	@Override
	public boolean saveEmployee(Employee employee) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(employee!=null){
			try{
				session.save(employee);
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
	public boolean updateEmployee(Employee employee) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(employee!=null){
			try{
				session.update(employee);
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
	public  List<Employee> getEmployee_list() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_employee+" where emp_active=1 ORDER BY emp_id desc ";
		List<Employee> employee_list=null;
		try{
			Query query=session.createQuery(hql);
			employee_list=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return employee_list;
	}


	@Override
	public Employee getEmployeeById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_employee+" where emp_id=?";
		Employee employee=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			employee=(Employee)query.uniqueResult();
			tx.commit();
			session.close();
		}catch(Exception e){
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return employee;
	}
	
}


