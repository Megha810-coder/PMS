package com.spcl.erp.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Department_type;
import com.spcl.erp.services.DepartmentService;
@Controller
@RequestMapping(value = "/department")
public class DepartmentController {	
	JSONObject json = new JSONObject();
	private static SecureRandom random = new SecureRandom();
	
	@Autowired
	private Helper helper;
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/department_list", method = RequestMethod.GET)
	public String department_type(Locale locale, Model model,HttpServletRequest request) {
		
		List<Department_type> department_typeList=new ArrayList<Department_type>();
		department_typeList=departmentService.getDepartment_typeList();
		
		model.addAttribute("department_typeList", department_typeList);
		model.addAttribute("departmentService", departmentService);
		model.addAttribute("url", request.getRequestURI());
		return "department/department_list";
	}
	
	@RequestMapping(value = "/new_department", method = RequestMethod.GET)
	public String new_department_type(Locale locale, Model model) {

		Department_type department_type=new Department_type();
		model.addAttribute("department_type", department_type);
		model.addAttribute("opr_mode", "save");
		return "department/dept_details";
	}
	@RequestMapping(value = "/save_department_type", method = RequestMethod.POST)
	public void save_customer(
			@ModelAttribute("department_type") @Valid Department_type department_type, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flasdatat
		) throws IOException {
		
		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			
	   	}else {
	   		
			String suc_msg="";
			String err_msg="";
			Date dat=new Date(new java.util.Date().getTime());
			String opr_mode=request.getParameter("opr_mode".trim());
			department_type.setDept_active(1);
			if (opr_mode.equals("save")) {
			department_type.setDt_create_date(dat);
				
				boolean flag=departmentService.saveDepartment_type(department_type);
				if(flag) {
					suc_msg="department created Successfully..!";
					json.put("status", 1);
				}else {
					json.put("error", 0);
					err_msg="Can't saved...something went wrong..!";
				}
				
			}else if (opr_mode.equals("update")){
				
				department_type.setDt_update_date(dat);
				boolean flag=departmentService.updateDepartment_type(department_type);
				if(flag) {
					suc_msg="Department updated Successfully..!";
					json.put("status", 1);
				}else {
					json.put("error", 0);
					err_msg="Can't update...something went wrong..!";
				}
				
			}
			json.put("success", suc_msg);
			json.put("error", err_msg);
			flasdatat.addFlashAttribute("suc_msg", suc_msg);
	   	}
		String responseJsonString = json.toString();
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJsonString);
    
	}
	
	@RequestMapping(value = "/edit_department", method = RequestMethod.GET)
	public String edit_department(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("dept_id").trim();
		Department_type department_type=new Department_type();
		department_type=departmentService.getDepartment_typeById(id);
		
		model.addAttribute("department_type", department_type);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "update");
		return "department/dept_details";
	}
	
	@RequestMapping(value = "/update_department", method = RequestMethod.POST)
	public String update_department(@ModelAttribute("department_type") @Valid Department_type department_type, BindingResult result,
			ModelMap model,HttpServletRequest request) throws IOException {
		
		if (result.hasErrors()) {
		 	model.addAttribute("error","true");
		 	return "redirect:/department_list";
        }
		Date dat=new Date(new java.util.Date().getTime());
		department_type.setDt_update_date(dat);;
		departmentService.updateDepartment_type(department_type);
				
		String msg="department Updated Successfully..!";
		
		model.addAttribute("msg_on_eventmaster", msg);
		return "department/department_list";
	}
	
	@RequestMapping(value = "/view_department_type", method = RequestMethod.GET)
	public String view_leave_type(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("dept_id").trim();
		Department_type department_type=new Department_type();
		department_type=departmentService.getDepartment_typeById(id);
		model.addAttribute("department_type", department_type);
		model.addAttribute("opr_mode", "view");
		return "department/dept_details";
	}
	
	@RequestMapping(value = "/delete_department", method = RequestMethod.GET)
    public void deleteEvent(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("dept_id").trim();
		if(departmentService.deleteDepartment(id)) {
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

	
	
	

}
