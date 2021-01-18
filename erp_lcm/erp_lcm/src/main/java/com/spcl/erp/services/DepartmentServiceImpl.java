package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.DepartmentDao;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Department_type;


public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao)
	{
		this.departmentDao=departmentDao;
	}
	
	

	@Override
	public boolean saveDepartment_type(Department_type department_type) {
		return departmentDao.saveDepartment_type(department_type);
		
	}

	@Override
	public List<Department_type> getDepartment_typeList() {
		List<Department_type> department_typeList=new ArrayList<Department_type>();
		department_typeList=departmentDao.getDepartment_typeList();
		return department_typeList;
	}

	@Override
	public Department_type getDepartment_typeById(String dept_id) {
		Department_type  department_type=new Department_type();
		department_type=departmentDao.getDepartment_typeById(dept_id);
		return department_type;
	}

	@Override
	public boolean updateDepartment_type(Department_type department_type) {
		return departmentDao.updateDepartment_type(department_type);
		
	}

	@Override
	public boolean deleteDepartment(String id) {
		return departmentDao.deleteDepartment(id);
	}


}
	

	