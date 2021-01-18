package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Employee;

public interface EmployeeDao {
	public boolean saveEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public List<Employee> getEmployee_list();
	public Employee getEmployeeById(String id);
}
