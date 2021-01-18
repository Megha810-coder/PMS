package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Leave_Department;
import com.spcl.erp.model.Leave_Request;
import com.spcl.erp.model.Leave_type;


public interface LeaveDao {
	
	public void saveLeave_type(Leave_type leave_type);
	public List<Leave_type> getLeave_typeList();
	public Leave_type getLeave_typeById(String lt_id);
	public void updateLeave_type(Leave_type leave_type);
	public boolean deleteLeave_type(String lt_id);
	public List<Leave_type> searchLeave_typeList(String lt_name);
	public void saveLeave_Department(Leave_Department leave_department);
	public List<Leave_Department> getLeave_department_List();
	public List<Leave_Request> getLeave_request_List();
	public boolean saveLeave_Request(Leave_Request leave_request);
	public boolean updateLeave_Request(Leave_Request leave_request);
	public Leave_Request getLeave_requestById(String lr_id);
	public boolean deleteLeave(String id);
}
