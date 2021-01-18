package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.LeaveDao;
import com.spcl.erp.model.Leave_Department;
import com.spcl.erp.model.Leave_Request;
import com.spcl.erp.model.Leave_type;

public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveDao leaveDao;
	
	public void setLeaveDao(LeaveDao leaveDao)
	{
		this.leaveDao=leaveDao;
	}
	
	@Override
	public void saveLeave_type(Leave_type leave_type) {
		
		leaveDao.saveLeave_type(leave_type);

	}

	@Override
	public List<Leave_type> getLeave_typeList() {

		List<Leave_type> leave_typeList=new ArrayList<Leave_type>();
		leave_typeList=leaveDao.getLeave_typeList();
		return leave_typeList;
	}

	@Override
	public Leave_type getLeave_typeById(String lt_id) {

		Leave_type leave_type=new Leave_type();
		leave_type=leaveDao.getLeave_typeById(lt_id);
		return leave_type;
	}

	@Override
	public void updateLeave_type(Leave_type leave_type) {

		leaveDao.updateLeave_type(leave_type);

	}

	@Override
	public boolean deleteLeave_type(String id) {

		return leaveDao.deleteLeave_type(id);

	}

	@Override
	public List<Leave_type> searchLeave_typeList(String lt_name) {

		List<Leave_type> leave_typeList=new ArrayList<Leave_type>();
		leave_typeList=leaveDao.searchLeave_typeList(lt_name);
		return leave_typeList;
	}
	
	@Override
	public String getLt_is_unpaid_value(Integer lt_is_unpaid) {
		if (lt_is_unpaid==null) {
			return "Not Set";
		}
		
		String lt_is_unpaid_value="";		
		switch(lt_is_unpaid.intValue()){ 
		case 1:  
			lt_is_unpaid_value="Yes"; 
				break; 
		case 2: 
			lt_is_unpaid_value="No"; 
				break; 
		default:
			lt_is_unpaid_value="Not Set"; 
				break; 
		}
		
		return lt_is_unpaid_value;
	}
	
	@Override
	public String getLt_take_leave_value(Integer lt_take_leave) {
		if (lt_take_leave==null) {
			return "Not Set";
		}
		
		String lt_take_leave_value;
		switch(lt_take_leave.intValue()){ 
		case 1:  
			lt_take_leave_value="Day"; 
				break; 
		case 2: 
			lt_take_leave_value="Hours"; 
				break;
		default:
			lt_take_leave_value="Not Set"; 
				break; 
		}
		return lt_take_leave_value;
	}
	
	@Override
	public String getLt_valid_by_value(Integer lt_valid_by) {
		if (lt_valid_by==null) {
			return "Not Set";
		}
		
		String lt_valid_by_value;
		switch(lt_valid_by.intValue()){ 
		case 1:  
				lt_valid_by_value="Human Resource Officer"; 
				break; 
		case 2: 
				lt_valid_by_value="Employee Manager"; 
				break; 
		case 3: 
				lt_valid_by_value="Double Validations"; 
				break; 
		
		default:
				lt_valid_by_value="Not Set"; 
				break; 
		}
		return lt_valid_by_value;
	}
	
	
	@Override
	public String getLt_allc_mode_value(Integer lt_allc_mode) {
		if (lt_allc_mode==null) {
			return "Not Set";
		}
		String lt_allc_mode_value;
		switch(lt_allc_mode.intValue()){ 
		case 1:  
				lt_allc_mode_value="Fixed by HR"; 
				break; 
		case 2: 
				lt_allc_mode_value="Allocation Request"; 
				break; 
		case 3: 
				lt_allc_mode_value="No Allocation"; 
				break; 
		default:
				lt_allc_mode_value="Not Set"; 
				break; 
		}
		return lt_allc_mode_value;
	}
	
	@Override
	public void updateLeave_Department_type(Leave_Department leave_department) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Leave_Department> getLeave_department_List() {

		List<Leave_Department> leave_department_list=new ArrayList<Leave_Department>();
		leave_department_list=leaveDao.getLeave_department_List();
		return leave_department_list;
	}
	@Override
	public void saveLeave_Department(Leave_Department leave_department) {
		
		leaveDao.saveLeave_Department(leave_department);

	}

	@Override
	public List<Leave_Request> getLeave_request_List() {
		List<Leave_Request> leave_request_list=new ArrayList<Leave_Request>();
		leave_request_list=leaveDao.getLeave_request_List();
		return leave_request_list;
	}

	@Override
	public boolean saveLeave_Request(Leave_Request leave_request) {
		return leaveDao.saveLeave_Request(leave_request);
	}

	@Override
	public boolean updateLeave_Request(Leave_Request leave_request) {
		return leaveDao.updateLeave_Request(leave_request);
		
	}

	@Override
	public Leave_Request getLeave_requestById(String lr_id) {
		Leave_Request leave_request=new Leave_Request();
		leave_request=leaveDao.getLeave_requestById(lr_id);
		return leave_request;
	}

	@Override
	public boolean deleteLeave(String id) {
		return leaveDao.deleteLeave(id);
	}
	public StringBuilder getAllButton(Leave_Request leave_request, String contextPath) {
		StringBuilder btnstring = new StringBuilder();
		Integer lbl_status = leave_request.getLr_status();
		btnstring.append(
		"<button href=\"javscript:void(0);\" rel='"+contextPath+"/leave/view_leave_request?lr_id="+leave_request.getLr_id()+"' class=\"btn btn-info btn-mini b-none view_item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"View\" ><i class=\"icofont icofont-eye-alt\"></i></button>\r\n");

		if (lbl_status.intValue()!=4) {
		btnstring.append("<button href='javscript:void(0); ' rel='"+contextPath+"/leave/edit_leave_request?lr_id="+leave_request.getLr_id()+"' class='btn btn-warning btn-mini b-none edit_item' data-toggle='tooltip' data-placement='top' title='Edit'><i class='icofont icofont-edit'></i></button>\r\n");
		}

		btnstring.append("<button href=\"javscript:void(0);\" rel='"+contextPath+"/leave/delete_leave_request?lr_id="+leave_request.getLr_id()+"' class=\"btn btn-danger btn-mini b-none alert-confirm remove_item\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Delete/Remove\"><i class=\"icofont icofont-archive\"></i></button>\r\n");

		if (lbl_status.intValue()==1) {
		btnstring.append("<a href='"+contextPath+"/leave/approve_ready?lr_id="+leave_request.getLr_id()+"' class=\"btn btn-info btn-mini b-none alert-confirm approve_leave\" data-toggle='tooltip' data-placement='top' title=\"To Approve\"><i class='icofont icofont-cart'></i>");

		}
		if (lbl_status.intValue()==1) {
			btnstring.append("<a href='"+contextPath+"/leave/refuse_leave_request?lr_id="+leave_request.getLr_id()+"' class=\"btn btn-info btn-mini b-none alert-confirm approve_leave\" data-toggle='tooltip' data-placement='top' title=\"Refuse\"><i class='icofont icofont-cart'></i>");

			}
		return btnstring;
		
	}

	@Override
	public String getStatusLable(Leave_Request leave_request) {
		// TODO Auto-generated method stub
		return null;
	}

}
