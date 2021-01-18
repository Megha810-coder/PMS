package com.spcl.erp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.BankDao;
import com.spcl.erp.model.Account;
import com.spcl.erp.model.Bank;

public class BankServiceImpl implements  BankService{
	
	
	@Autowired
	private BankDao bankDao;
	
	public void setBankDao(BankDao bankDao){
		this.bankDao=bankDao;
	}
	
	
	@Override
	public List<Bank> getBankList(Map<String, String> search_field) {
		return bankDao.getBankList(search_field);
	}
	
	@Override
	public boolean saveBank(Bank bank) {
		return bankDao.saveBank(bank);
	}
	
	@Override
	public boolean updateBank(Bank bank) {
		return bankDao.updateBank(bank);
	}


	@Override
	public Bank getBankById(String id) {
		return bankDao.getBankById(id);
	}


	@Override
	public boolean deleteBank(String id) {
		return bankDao.deleteBank(id);
	}
	
	@Override
	public List<Account> getAccountList() {
		return bankDao.getAccountList();
	}
	
	@Override
	public boolean saveAccount(Account account) {
		return bankDao.saveAccount(account);
	}
	
	@Override
	public boolean updateAccount(Account account) {
		return bankDao.updateAccount(account);
	}


	@Override
	public Account getAccountById(String id) {
		return bankDao.getAccountById(id);
	}


	@Override
	public boolean deleteAccount(String id) {
		return bankDao.deleteAccount(id);
	}

}
