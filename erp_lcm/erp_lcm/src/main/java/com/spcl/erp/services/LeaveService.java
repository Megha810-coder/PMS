package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.model.Leave_Department;
import com.spcl.erp.model.Leave_Request;
import com.spcl.erp.model.Leave_type;

public interface LeaveService {

	public void saveLeave_type(Leave_type leave_type);
	public List<Leave_type> getLeave_typeList();
	public Leave_type getLeave_typeById(String lt_id);
	public void updateLeave_Department_type(Leave_Department leave_department);
	public boolean deleteLeave_type(String lt_id);
	public List<Leave_type> searchLeave_typeList(String lt_name);
	
	public String getLt_is_unpaid_value(Integer lt_is_unpaid);
	public String getLt_take_leave_value(Integer lt_take_leave);
	public String getLt_valid_by_value(Integer lt_valid_by);
	public String getLt_allc_mode_value(Integer lt_allc_mode);
	
	public void saveLeave_Department(Leave_Department leave_department);
	public void updateLeave_type(Leave_type leave_type);
	public List<Leave_Department> getLeave_department_List();
	public List<Leave_Request> getLeave_request_List();
	public boolean saveLeave_Request(Leave_Request leave_request);
	public boolean updateLeave_Request(Leave_Request leave_request);
	public Leave_Request getLeave_requestById(String lr_id);
	public boolean deleteLeave(String id);
	public StringBuilder getAllButton(Leave_Request leave_request, String contextPath);
	public String getStatusLable(Leave_Request  leave_request);
	
}
