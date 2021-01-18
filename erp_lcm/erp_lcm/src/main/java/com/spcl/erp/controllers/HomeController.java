package com.spcl.erp.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Com_Enquiry;
import com.spcl.erp.services.CompanyService;
import com.spcl.erp.services.LabourService;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private CompanyService companyService;
	@Autowired
	private LabourService labourService;
	@Autowired
	private Helper helper;
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Com_Enquiry com_enquiry = new Com_Enquiry();
		model.addAttribute("com_enquiry", com_enquiry);
		model.addAttribute("help", helper);
		return "reg_login";
	}
	@RequestMapping(value = "/user_dashboard", method = RequestMethod.GET)
	public String user_dashboard(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		HttpSession session=request.getSession();
		Date Check_in_time=new Date(new java.util.Date().getTime());
		Integer TotalLabour=labourService.getTotalLabour();
		
		
		Integer TotalContractor=labourService.getTotalContractor();
	
		 Integer totalCHeckIn=labourService.getTodayTotalLabourCheckIN(); 
		List<Object> cntlist=labourService.gettotalweeklyCount();
		
		 Integer shift1Count=labourService.getLabourCheckinShift1COunt(); 
		  Integer shift2Count=labourService.getLabourCheckinShift2COunt(); 
		  Integer shift3Count=labourService.getLabourCheckinShift3COunt(); 
		  Integer department1Count=labourService.getLabourCheckinDepartment1Count();
		  
		model.addAttribute("shift1Count",shift1Count);
		model.addAttribute("shift2Count",shift2Count);
		model.addAttribute("shift3Count",shift3Count);
		model.addAttribute("department1Count",department1Count);
		model.addAttribute("TotalLabour", TotalLabour);
		model.addAttribute("TotalContractor", TotalContractor);
		model.addAttribute("cntlist", cntlist);
		 model.addAttribute("totalCHeckIn", totalCHeckIn); 
		model.addAttribute("labourService", labourService);
						
		return "labour/report";
	}
	
	@RequestMapping(value = "/vendor_add", method = RequestMethod.GET)
	public String add_vendor(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		HttpSession session=request.getSession();
		
		return "add_customer_vendor";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest req, HttpServletResponse res,Model model,
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		
			
			if (error != null) {
				model.addAttribute("error", "Invalid username and password!");
			}

			if (logout != null) {
				model.addAttribute("msg", "You've been logged out successfully.");
			}
			model.addAttribute("help", helper);
			//model.setViewName("index");
		

		return "reg_login";

	}
	
	@RequestMapping(value = "/logoutSuccess", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model,HttpServletRequest req) {
	 req.getSession().invalidate();
        return "redirect:/";
    }
	
	@RequestMapping(value = "/leave", method = RequestMethod.GET)
	public String add_leave_type(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) {
		logger.info("Welcome home! The client locale is {}.", locale);
		HttpSession session=request.getSession();
		
		return "leave_dada/leave_type";
	}
	
	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String add_vendor(Locale locale, Model model) {
		return "error_404";
	}
	
	
	
}
