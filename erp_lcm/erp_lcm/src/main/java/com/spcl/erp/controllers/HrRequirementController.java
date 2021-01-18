package com.spcl.erp.controllers;

import java.io.BufferedReader;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.HrRequirement;
import com.spcl.erp.model.Leave_Request;
import com.spcl.erp.services.HrRequirementService;


@Controller
@RequestMapping(value = "/hr_requirement")
public class HrRequirementController {
	JSONObject json = new JSONObject();
	private static SecureRandom random = new SecureRandom();
	@Autowired
	private HrRequirementService hrrequirementService;
	@Autowired
	private Helper helper;
	
	@RequestMapping(value = "/mng_hr_requirement", method = RequestMethod.GET)
	public String manageEvent(Locale locale, Model model,HttpServletRequest request) {
		
		List<HrRequirement> hr_requirement_list=new ArrayList<HrRequirement>();
		hr_requirement_list=hrrequirementService.getHr_Requirement();
		
		model.addAttribute("hr_requirement_list", hr_requirement_list);
		model.addAttribute("helper", helper);
		model.addAttribute("HrRequirementService", hrrequirementService);
		model.addAttribute("url", request.getRequestURI());
		return "hr_requirement/hr_requirement_list";
	}
	
	@RequestMapping(value = "/new_hr_requirement", method = RequestMethod.GET)
	public String new_requirement(Locale locale, Model model) {		
		HrRequirement hrrequirement=new HrRequirement();
		model.addAttribute("HrRequirement", hrrequirement);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "hr_requirement/add_hr_requirement";
	}
	
	@RequestMapping(value = "/save_hr_requirement", method = RequestMethod.POST)
	public void save_customer(
			@ModelAttribute("hr_requirement") @Valid HrRequirement hrrequirement, 
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
				Date dat=new Date(new java.util.Date().getTime());
				String opr_mode=request.getParameter("opr_mode".trim());
				hrrequirement.setHr_active(1);
				
				if (opr_mode.equals("save")) {
					hrrequirement.setHr_created_date(dat);
					
					boolean flag=hrrequirementService.saveHr_Requirement(hrrequirement);
					if(flag) {
						suc_msg="hr requirement created Successfully..!";
						json.put("status", 1);
					}else {
						json.put("error", 0);
						err_msg="Can't saved...something went wrong..!";
					}
				}
				else if (opr_mode.equals("update")){
				
					hrrequirement.setHr_updated_date(dat);
				/* boolean flag=hrrequirementService.updatehrrequirement(hrrequirement); */
				/*
				 * if(flag) { suc_msg="hr requirement updated Successfully..!";
				 * json.put("status", 1); }else { json.put("error", 0);
				 * err_msg="Can't update...something went wrong..!"; }
				 */
				
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
	/*@RequestMapping(value = "/edit_hr_requirement", method = RequestMethod.GET)
	public String edit_leave_request(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("hr_req_id").trim();
		HrRequirement leave_request=new Leave_Request();
		leave_request=leaveService.getLeave_requestById(id);
		
		model.addAttribute("leave_request", leave_request);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "update");
		return "leave_manager/leave_request";
	}
	@RequestMapping(value = "/update_hr_requirement", method = RequestMethod.POST)
	public String update_hr_requirement(@ModelAttribute("hrrequirement") @Valid HrRequirement hrrequirement, BindingResult result,
			ModelMap model,HttpServletRequest request) throws IOException {
		
		if (result.hasErrors()) {
		 	model.addAttribute("error","true");
		 	return "redirect:/mng_hr_requirement";
        }
		Date dat=new Date(new java.util.Date().getTime());
		hrrequirement.setHr_updated_date(dat);;
		hrrequirementService.updatehrrequirement(hrrequirement);
		String msg="hr requirement Updated Successfully..!";
		model.addAttribute("msg_on_eventmaster", msg);
		return "hr_requirement/mng_hr_requirement";
	}*/
	@RequestMapping(value = "/view_hr_requirement", method = RequestMethod.GET)
	public String view_job_position(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("hr_req_id").trim();
		HrRequirement hrrequirement=new HrRequirement();
		hrrequirement=hrrequirementService.getHrrequirement_ById(id);
		hrrequirement=hrrequirementService.getHrrequirement_ById(id);
		
		
		SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
		model.addAttribute("HrRequirement",hrrequirement);
		model.addAttribute("opr_mode", "view");
		return "hr_requirement/add_hr_requirement";
	}
	@RequestMapping(value = "/delete_hr_requirement", method = RequestMethod.GET)
    public void deleteEvent(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("hr_req_id").trim();
		if(hrrequirementService.deletehrrequirement(id)) {
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



