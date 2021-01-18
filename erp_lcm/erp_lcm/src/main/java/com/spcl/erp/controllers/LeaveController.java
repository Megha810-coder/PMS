package com.spcl.erp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Leave_Department;
import com.spcl.erp.model.Leave_Request;
import com.spcl.erp.model.Leave_type;
import com.spcl.erp.services.LeaveService;

@Controller
@RequestMapping(value = "/leave")
public class LeaveController {
	JSONObject json = new JSONObject();
	private static SecureRandom random = new SecureRandom();
	@Autowired
	private Helper helper;
	@Autowired
	private LeaveService leaveService;
	
	@RequestMapping(value = "/mng_leave_type", method = RequestMethod.GET)
	public String mng_leave_type(Locale locale, Model model,HttpServletRequest request) {
		
		List<Leave_type> leave_typeList=new ArrayList<Leave_type>();
		leave_typeList=leaveService.getLeave_typeList();
		
		model.addAttribute("leave_typeList", leave_typeList);
		model.addAttribute("leaveService", leaveService);
		model.addAttribute("resp_page", "leave_manager/leave_type_list");
		model.addAttribute("url", request.getRequestURI());
		return "leave_manager/leave_type_list";
	}
	
	@RequestMapping(value = "/new_leave_type", method = RequestMethod.GET)
	public String new_leave_type(Locale locale, Model model) {

		Leave_type leave_type=new Leave_type();
		model.addAttribute("leave_type", leave_type);
		model.addAttribute("opr_mode", "save");
		return "leave_manager/leave_type";
	}


	@RequestMapping(value = "/save_leave_type", method = RequestMethod.POST)
	public String save_leave_type(@ModelAttribute("leave_type") @Valid Leave_type leave_type, BindingResult result,
		ModelMap model,HttpServletRequest request) throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("error","true");
			return "redirect:/leave/mng_leave_type";
	   	}
		String suc_msg="";
		String err_msg="";
		Date dat=new Date(new java.util.Date().getTime());
		String opr_mode=request.getParameter("opr_mode".trim());
		
		if(leave_type.getLt_is_unpaid()==null)
			leave_type.setLt_is_unpaid(0);
		/*if(leave_type.getLt_take_leave()==null)
			leave_type.setLt_take_leave(0);;
		if(leave_type.getLt_allc_mode()==null)
			leave_type.setLt_allc_mode(0);
		if(leave_type.getLt_valid_by()==null)
			leave_type.setLt_valid_by(0);*/
		
		leave_type.setLt_active(1);
		if (opr_mode.equals("save")) {
			leave_type.setLt_create_date(dat);
			leaveService.saveLeave_type(leave_type);
			suc_msg="Leave type created Successfully..!";
		}else if (opr_mode.equals("update")){
			leave_type.setLt_update_date(dat);	
			leaveService.updateLeave_type(leave_type);
			suc_msg="Leave type Updated Successfully..!";
		}
				
		model.addAttribute("suc_msg", suc_msg);
		model.addAttribute("err_msg", err_msg);
		return "redirect:/leave/mng_leave_type";
	}
	
	
	@RequestMapping(value = "/edit_leave_type", method = RequestMethod.GET)
	public String edit_leave_type(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("lt_id").trim();
		Leave_type leave_type=new Leave_type();
		leave_type=leaveService.getLeave_typeById(id);
		
		
		SimpleDateFormat dt1 = new SimpleDateFormat("MM/dd/yyyy");
		
		String st_dt=dt1.format(leave_type.getLt_start_date());
		String en_dt=dt1.format(leave_type.getLt_end_date());
		
		model.addAttribute("lt_start_date", st_dt);
		model.addAttribute("lt_end_date", en_dt);
		model.addAttribute("leave_type", leave_type);
		model.addAttribute("opr_mode", "update");
		return "leave_manager/leave_type";
	}
	
	@RequestMapping(value = "/view_leave_type", method = RequestMethod.GET)
	public String view_leave_type(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("lt_id").trim();
		Leave_type leave_type=new Leave_type();
		leave_type=leaveService.getLeave_typeById(id);
		
		
		SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
		
		String st_dt=dt1.format(leave_type.getLt_start_date());
		String en_dt=dt1.format(leave_type.getLt_end_date());
		
		model.addAttribute("lt_take_leave", leaveService.getLt_take_leave_value(leave_type.getLt_take_leave()));
		model.addAttribute("lt_allc_mode", leaveService.getLt_allc_mode_value(leave_type.getLt_allc_mode()));
		model.addAttribute("lt_valid_by", leaveService.getLt_valid_by_value(leave_type.getLt_valid_by()));
		model.addAttribute("lt_start_date", st_dt);
		model.addAttribute("lt_end_date", en_dt);
		model.addAttribute("leave_type", leave_type);
		model.addAttribute("opr_mode", "view");
		return "leave_manager/leave_type";
	}
	
	@RequestMapping(value = "/update_leave_type", method = RequestMethod.POST)
	public String update_leave_type(@ModelAttribute("leave_type") @Valid Leave_type leave_type, BindingResult result,
			ModelMap model,HttpServletRequest request) throws IOException {
		
		if (result.hasErrors()) {
		 	model.addAttribute("error","true");
		 	return "redirect:/leave/mng_leave_type";
        }
		Date dat=new Date(new java.util.Date().getTime());
		leave_type.setLt_update_date(dat);
		leaveService.updateLeave_type(leave_type);
				
		String msg="Event Updated Successfully..!";
		
		model.addAttribute("msg_on_eventmaster", msg);
		return "/leave/mng_leave_type";
	}
	
	
	@RequestMapping(value = "/delete_leave_type", method = RequestMethod.GET)
    public void delete_leave_type(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("lt_id").trim();
		if(leaveService.deleteLeave_type(id)) {
			msg="true";
		}
	
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
 		try {
 			response.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchLeave_type(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String name=request.getParameter("lt_name").trim() != null ? request.getParameter("lt_name").trim() : "";
		String dt=request.getParameter("ev_str_dt").trim() != null ? request.getParameter("ev_str_dt").trim() : "";
		String loc=request.getParameter("ev_loc").trim() != null ? request.getParameter("ev_loc").trim() : "";
		
		
		List<Leave_type> leave_typeList=new ArrayList<Leave_type>();
		leave_typeList=leaveService.searchLeave_typeList(name);
				
		
		model.addAttribute("LEAVETYPELIST", leave_typeList);
		model.addAttribute("lt_name", name);
		model.addAttribute("EV_STR_DT", dt);
		model.addAttribute("EV_LOC", loc);
		
		
		return "admin/event_report";
	}
	
	@RequestMapping(value = "/mng_leave_departement", method = RequestMethod.GET)
	public String mng_leave_department(Locale locale, Model model,HttpServletRequest request) {
		
		List<Leave_Department> leave_department_List=new ArrayList<Leave_Department>();
		leave_department_List=leaveService.getLeave_department_List();
		
		model.addAttribute("leave_department_list",leave_department_List);
		model.addAttribute("leaveService", leaveService);
		model.addAttribute("url", request.getRequestURI());
		return "leave_manager/leave_department_list";
	}
	

	@RequestMapping(value = "/new_leave_department", method = RequestMethod.GET)
	public String new_leave_department(Locale locale, Model model) {
		Leave_Department leave_department=new Leave_Department();
		model.addAttribute("leave_department", leave_department);
		model.addAttribute("opr_mode", "save");
		return "leave_manager/leave_dept";
		
	}
		
	@RequestMapping(value = "/save_leave_department", method = RequestMethod.POST)
	public String save_leave_department(@ModelAttribute("leave_department") @Valid Leave_Department leave_department, BindingResult result,
		ModelMap model,HttpServletRequest request) throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("error","true");
			return "redirect:/leave/mng_leave_departement";
	   	}
		String suc_msg="";
		String err_msg="";
		Date dat=new Date(new java.util.Date().getTime());
		String opr_mode=request.getParameter("opr_mode".trim());
		leave_department.setLd_active(1);
		if (opr_mode.equals("save")) {
			
			leave_department.setLd_create_date(dat);	
			leaveService.saveLeave_Department(leave_department);
			suc_msg="Leave department created Successfully..!";
		}else if (opr_mode.equals("update")){
			
			leave_department.setLd_update_date(dat);	
			leaveService.updateLeave_Department_type(leave_department);
			suc_msg="Leave type Updated Successfully..!";
		}
				
		model.addAttribute("suc_msg", suc_msg);
		model.addAttribute("err_msg", err_msg);
		return "redirect:/leave/mng_leave_departement";
	}
	@RequestMapping(value = "/mng_leave_request", method = RequestMethod.GET)
	public String mng_leave_request(Locale locale, Model model,HttpServletRequest request) {
		
		List<Leave_Request> leave_request_list=new ArrayList<Leave_Request>();
		leave_request_list=leaveService.getLeave_request_List();
		
		model.addAttribute("leave_request_list", leave_request_list);
		model.addAttribute("leaveService", leaveService);
		model.addAttribute("helper", helper);
		model.addAttribute("resp_page", "leave_manager/leave_type_list");
		model.addAttribute("url", request.getRequestURI());
		return "leave_manager/leave_request_list";
	}
	@RequestMapping(value = "/new_leave_request", method = RequestMethod.GET)
	public String new_leave_request(Locale locale, Model model) {
		Leave_Request leave_request=new Leave_Request();
		model.addAttribute("leave_request", leave_request);
		model.addAttribute("opr_mode", "save");
		return "leave_manager/leave_request";
		}
	@RequestMapping(value = "/save_leave_request", method = RequestMethod.POST)
	public void save_customer(
			@ModelAttribute("leave_request") @Valid Leave_Request leave_request, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flashdata
			
		) throws IOException {
			if (result.hasErrors()) {
				json.put("status", 0);
				json.put("error", helper.getErrors(result));
				
		   	}else {
			
				String suc_msg="";
				String err_msg="";
				leave_request.setLr_status(helper.To_APPROVE);
				Date dat=new Date(new java.util.Date().getTime());
				String opr_mode=request.getParameter("opr_mode".trim());
				leave_request.setLr_active(1);
				
				if (opr_mode.equals("save")) {
					leave_request.setLr_create_date(dat);
					
					boolean flag=leaveService.saveLeave_Request(leave_request);
					if(flag) {
						suc_msg="leave Request created Successfully..!";
						json.put("status", 1);
					}else {
						json.put("error", 0);
						err_msg="Can't saved...something went wrong..!";
					}
				}
				else if (opr_mode.equals("update")){
				
					leave_request.setLr_update_date(dat);
					boolean flag=leaveService.updateLeave_Request(leave_request);
					if(flag) {
						suc_msg="leave request updated Successfully..!";
						json.put("status", 1);
					}else {
						json.put("error", 0);
						err_msg="Can't update...something went wrong..!";
					}
				
				}
				
				json.put("success", suc_msg);
				json.put("error", err_msg);
				flashdata.addFlashAttribute("suc_msg", suc_msg);
				flashdata.addFlashAttribute("err_msg", err_msg);
			}
			
			String responseJsonString = json.toString();
	 
	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(responseJsonString);
    }
	@RequestMapping(value = "/edit_leave_request", method = RequestMethod.GET)
	public String edit_leave_request(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("lr_id").trim();
		Leave_Request leave_request=new Leave_Request();
		leave_request=leaveService.getLeave_requestById(id);
		
		model.addAttribute("leave_request", leave_request);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "update");
		return "leave_manager/leave_request";
	}
	@RequestMapping(value = "/update_leave_request", method = RequestMethod.POST)
	public String update_leave_request(@ModelAttribute("leave_request") @Valid Leave_Request leave_request, BindingResult result,
			ModelMap model,HttpServletRequest request) throws IOException {
		
		if (result.hasErrors()) {
		 	model.addAttribute("error","true");
		 	return "redirect:/mng_leave_request";
        }
		Date dat=new Date(new java.util.Date().getTime());
		leave_request.setLr_update_date(dat);;
		leaveService.updateLeave_Request(leave_request);
				
		String msg="Leave request Updated Successfully..!";
		
		model.addAttribute("msg_on_eventmaster", msg);
		return "leave/mng_leave_request";
	}
	@RequestMapping(value = "/view_leave_request", method = RequestMethod.GET)
	public String view_customer(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("lr_id").trim();
		Leave_Request leave_request=new Leave_Request();
		leave_request=leaveService.getLeave_requestById(id);
		
		model.addAttribute("leave_request", leave_request);
		model.addAttribute("helper", helper);
		model.addAttribute("leaveService", leaveService);
		model.addAttribute("opr_mode", "view");
		return "leave/leave_request";
	}
	@RequestMapping(value = "/delete_leave_request", method = RequestMethod.GET)
    public void deleteEvent(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("lr_id").trim();
		if(leaveService.deleteLeave(id)) {
			msg="true";
		}
	
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
 		try {
 			response.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
	 @RequestMapping(value = "/approve_ready", method = RequestMethod.GET)
	    public void approveReady(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws IOException {

	response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
	response.setCharacterEncoding("UTF-8");
	json=new JSONObject();
	String suc_msg="";
	String err_msg="";

	String id=request.getParameter("lr_id").trim();
	Leave_Request leave_request=new Leave_Request();
	leave_request=leaveService.getLeave_requestById(id);
	leave_request.setLr_status(Helper.APPROVED);
	boolean flag=leaveService.updateLeave_Request(leave_request);

	if(flag) {
	suc_msg="approve Updated Successfully..!";
	json.put("status", 1);

	}else {
	json.put("error", 0);
	err_msg="Can't update...something went wrong..!";
	}
	json.put("success", suc_msg);
	json.put("error", err_msg);


	response.getWriter().write(json.toString());
	return;
     }
	 @RequestMapping(value = "/refuse_leave_request", method = RequestMethod.GET)
	    public void refuse(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws IOException {

	response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
	response.setCharacterEncoding("UTF-8");
	json=new JSONObject();
	String suc_msg="";
	String err_msg="";

	String id=request.getParameter("lr_id").trim();
	Leave_Request leave_request=new Leave_Request();
	leave_request=leaveService.getLeave_requestById(id);
	leave_request.setLr_status(Helper.REFUSE);
	boolean flag=leaveService.updateLeave_Request(leave_request);

	if(flag) {
	suc_msg="refuse Updated Successfully..!";
	json.put("status", 1);

	}else {
	json.put("error", 0);
	err_msg="Can't update...something went wrong..!";
	}
	json.put("success", suc_msg);
	json.put("error", err_msg);


	response.getWriter().write(json.toString());
	return;
  }

	 
		

}
