package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.CustomerDao;
import com.spcl.erp.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao)
	{
		this.customerDao=customerDao;
	}

	@Override
	public boolean saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	@Override
	public List<Customer> getCustomerList() {
		List<Customer> customer_List=new ArrayList<Customer>();
		customer_List=customerDao.getCustomerList();
		return customer_List;
	}

	@Override
	public Customer getCustomerById(String cust_id) {
		Customer customer=new Customer();
		customer=customerDao.getCustomerById(cust_id);
		return customer;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(String cust_id) {
		return customerDao.deleteCustomer(cust_id);
	}

	@Override
	public List<Customer> searchCustomerList(String cust_name) {
		List<Customer> customer_List=new ArrayList<Customer>();
		customer_List=customerDao.searchCustomerList(cust_name);
		return customer_List;
	}

	@Override
	public String getCustomerByFullName(Customer cust) {
		
		String cust_name=cust.getCust_title() . concat(" ").concat(cust.getCust_fname()) . concat(" ").concat(cust.getCust_mname()) . concat(" ").concat(cust.getCust_lname());
		return cust_name;
		
	}

	@Override
	public String getAddrLine1ById(Customer cust) {
		String addrs_line1=cust.getCust_adds_line1();
		
		return addrs_line1;
	}

	@Override
	public String getAddrLine2ById(Customer cust) {
		
		String addrs_line2=cust.getCust_adds_line2();

		return addrs_line2;
	}

	public String getCityById(String city_id) {
		String city_name=customerDao.getCityById(city_id);
		return city_name;
	}
	
	@Override
	public String getJobPositionById(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSalePersonById(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDuedayById(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountPayById(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDueAccById(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
