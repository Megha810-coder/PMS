package com.spcl.erp.services;

import java.util.List;
import java.util.Map;

import com.spcl.erp.model.Expenses;

public interface ExpensesService {

	public List<Expenses> getExpensesList(Map<String, String> search_field1);
	public boolean saveExpenses(Expenses expenses);

	public Expenses getExpensesById(String exp_id);
	public boolean updateExpenses(Expenses expenses);
	public boolean deleteExpenses(String exp_id);
	
	 public String formatDate(String inDate);
	
}
