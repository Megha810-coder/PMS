package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.model.Employee;

public interface EmployeeService {
	public boolean saveEmployee(Employee employee);
	public List<Employee>getEmployee_list();
	public boolean updateEmployee(Employee employee);
	public String getEmployeeByFullName(Employee employee);
	public String getEmployeeGender(Employee employee);
	public String getEmployeeMaritalStatus(Employee employee);
	public Employee getEmployeeById(String emp_id);
	}
