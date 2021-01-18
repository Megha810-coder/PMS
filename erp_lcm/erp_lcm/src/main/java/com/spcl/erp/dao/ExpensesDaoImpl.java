package com.spcl.erp.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.model.Expenses;

public class ExpensesDaoImpl implements ExpensesDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private String tbl_expenses="erp_expenses";
	
	private static SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
	  private static SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	@Override
	public List<Expenses> getExpensesList(Map<String, String> search_field1) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		StringBuilder hql=new StringBuilder("from "+tbl_expenses+" where exp_active=1 ");
		if (search_field1!=null&&!search_field1.isEmpty()) {
			hql=new StringBuilder("from "+tbl_expenses+" where exp_active=1 ");
			for(Map.Entry<String, String> entry : search_field1.entrySet()) {
				String value = entry.getValue();
				if (value!=null&&!value.isEmpty()) {
					String key = entry.getKey();
					hql.append(" and "+key+"='"+value+"' " );
				}
			}
		}
		hql.append("ORDER BY exp_id desc");
		List<Expenses> expensesList=null;
		try{
			Query query=session.createQuery(hql.toString());
			expensesList=query.list();
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return expensesList;
	}
	
	@Override
	public boolean saveExpenses(Expenses expenses) {

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		if(expenses!=null)
		{
		 try{
			session.save(expenses);
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
	public boolean updateExpenses(Expenses expenses) {
		   Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			if(expenses!=null)
			{
			 try{
				session.update(expenses);
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
	public Expenses getExpensesById(String id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="from "+tbl_expenses+" where exp_id=?";
		Expenses expenses=null;
		int intValue = Integer.parseInt(id);
		try{
			Query query=session.createQuery(hql);
			query.setParameter(0,intValue);
			expenses=(Expenses)query.uniqueResult();
			tx.commit();
			session.close();
		}
	 catch(Exception e)
	 {
		 tx.rollback();
		 session.close();
		 e.printStackTrace();
	 }
		
		return expenses;
	}

	@Override
	public boolean deleteExpenses(String del_id) {
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="delete from "+tbl_expenses+" WHERE exp_id="+del_id;
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
	public String formatDate(String inDate) {
		 String outDate = "";
		    if (inDate != null) {
		        try {
		            Date date = inSDF.parse(inDate);
		            outDate = outSDF.format(date);
		        } catch (ParseException ex){ 
		        }
		    }
		return outDate;
	}
	
}
	


	
