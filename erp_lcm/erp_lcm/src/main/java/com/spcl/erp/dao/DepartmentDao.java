package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Department_type;

public interface DepartmentDao {

	public boolean saveDepartment_type(Department_type department_type);
	public List<Department_type>getDepartment_typeList();
	public Department_type getDepartment_typeById(String dept_id);
	public boolean updateDepartment_type(Department_type department_type);
	public boolean deleteDepartment(String id);
}
