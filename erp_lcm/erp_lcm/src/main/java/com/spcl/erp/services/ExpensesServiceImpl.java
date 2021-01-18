package com.spcl.erp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.ExpensesDao;
import com.spcl.erp.model.Expenses;

public class ExpensesServiceImpl implements ExpensesService{

	@Autowired
	private ExpensesDao expensesDao;
	
	 
	
	public void setExpensesDao(ExpensesDao expensesDao)
	{
		this.expensesDao=expensesDao;
	}
	
	@Override
	public boolean saveExpenses(Expenses expenses) {
		
		return expensesDao.saveExpenses(expenses);

	
}
	@Override
	public List<Expenses> getExpensesList(Map<String, String> search_field1) {
		return expensesDao.getExpensesList(search_field1);
	}

	@Override
	public Expenses getExpensesById(String exp_id) {
		return expensesDao.getExpensesById(exp_id);
	}

	@Override
	public boolean  updateExpenses(Expenses expenses) {
		 return expensesDao.updateExpenses(expenses);
		
	}

	@Override
	public boolean deleteExpenses(String exp_id) {
		return expensesDao.deleteExpenses(exp_id);
	}

	@Override
	public String formatDate(String inDate) {
		return expensesDao.formatDate(inDate) ;
	}

}
	

	
