package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.model.Customer;


public interface CustomerService {

	public boolean saveCustomer(Customer customer);
	public List<Customer> getCustomerList();
	public Customer getCustomerById(String cust_id);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(String cust_id);
	public List<Customer> searchCustomerList(String cust_name);
	public String getCustomerByFullName(Customer cust);
	public String getAddrLine1ById(Customer cust);
	public String getAddrLine2ById(Customer cust);
	/*public String getCityById(Customer cust);*/
	public String getJobPositionById(Customer cust);
	public String getSalePersonById(Customer cust);
	public String getDuedayById(Customer cust);
	public String getAccountPayById(Customer cust);
	public String getDueAccById(Customer cust);
	String getCityById(String city_id);
}
