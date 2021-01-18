package com.spcl.erp.services;

import java.util.List;
import java.util.Map;

import com.spcl.erp.model.Account;
import com.spcl.erp.model.Bank;

public interface BankService {
	
	public List<Bank> getBankList(Map<String, String> search_field);

	public boolean saveBank(Bank bank);
	
	public boolean updateBank(Bank bank);
	
	public Bank getBankById(String id);

	public boolean deleteBank(String id);
	
	public List<Account> getAccountList();
	
	public boolean saveAccount( Account account);
	
	public boolean updateAccount( Account account);
	
	public  Account getAccountById(String id);

	public boolean deleteAccount(String id);

	

}
