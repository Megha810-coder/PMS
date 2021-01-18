package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import com.spcl.erp.dao.EmployeeDao;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
		
	}

	@Override
	public List<Employee> getEmployee_list() {
		List<Employee> employee_list=new ArrayList<Employee>();
		employee_list=employeeDao.getEmployee_list();
		return employee_list;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		return employeeDao.updateEmployee(employee);
	}
	
	@Override
	public String getEmployeeByFullName(Employee emp) {
		
		String emp_name=emp.getEmp_title() . concat(" ").concat(emp.getEmp_fname()) . concat(" ").concat(emp.getEmp_mname()) . concat(" ").concat(emp.getEmp_lname());
		return emp_name;
		
	}
	
	@Override
	public String getEmployeeGender(Employee emp) {
		String gender="Not Set";
		switch (emp.getEmp_gender()) {
		case 1:
			gender="Male";
			break;
		case 2:
			gender="Female";
			break;
		case 3:
			gender="Transgender";
			break;

		default:
			gender="Not Set";
			break;
		}
		return gender;
		
	}
	
	@Override
	public String getEmployeeMaritalStatus(Employee emp) {
		String staus="Not Set";
		switch (emp.getEmp_marital_status()) {
		case 1:
			staus="Single";
			break;
		case 2:
			staus="Married";
			break;
		case 3:
			staus="Divorce";
			break;
		case 4:
			staus="Widowe";
			break;
		case 5:
			staus="Legal Cohabitant";
			break;

		default:
			staus="Not Set";
			break;
		}
		return staus;
		
	}
	
	@Override
	public Employee getEmployeeById(String id) {
		return employeeDao.getEmployeeById(id);
	}
	
}
