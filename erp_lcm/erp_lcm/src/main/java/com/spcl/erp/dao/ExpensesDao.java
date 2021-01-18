

package com.spcl.erp.dao;

import java.util.List;
import java.util.Map;

import com.spcl.erp.model.Expenses;


public interface ExpensesDao {
	
	public List<Expenses> getExpensesList(Map<String, String> search_field1);
	
	public boolean saveExpenses(Expenses expenses);
	
	
	
	public boolean updateExpenses(Expenses expenses);
	
	public boolean deleteExpenses(String exp_id);
	
	public Expenses getExpensesById(String exp_id);
	
	 public String formatDate(String inDate);

}
