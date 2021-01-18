package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Customer;


public interface CustomerDao {
	
	public boolean saveCustomer(Customer customer);
	public List<Customer> getCustomerList();
	public Customer getCustomerById(String cust_id);
	public boolean updateCustomer(Customer customer);
	public boolean deleteCustomer(String cust_id);
	public List<Customer> searchCustomerList(String cust_name);
	public String getCityById(String city_id);

}
