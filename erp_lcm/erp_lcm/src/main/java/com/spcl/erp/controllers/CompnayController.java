package com.spcl.erp.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Com_Enquiry;
import com.spcl.erp.model.Country;
import com.spcl.erp.services.CompanyService;

@Controller
@RequestMapping(value = "/company")
public class CompnayController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private Helper helper;
	
	
	@RequestMapping(value = "/mng_company_enquiry", method = RequestMethod.GET)
	public String mng_company_enquiry(Locale locale, Model model, HttpServletRequest request) {
		List<Com_Enquiry> enqList=new ArrayList<Com_Enquiry>();
		enqList=companyService.getEnquiryList();
		model.addAttribute("enqList", enqList);
		model.addAttribute("url", request.getRequestURI());
		return "company_manager/enquiry_list";
	}
	
	@RequestMapping(value = "/allow_module", method = RequestMethod.GET)
	public String mng_leave_type(Locale locale, Model model, HttpServletRequest request) {
		String id=request.getParameter("enq_id").trim();
		Com_Enquiry com_enquiry = new Com_Enquiry();
		com_enquiry=companyService.getEnquiryById(id);
		model.addAttribute("enquiry", com_enquiry);
		model.addAttribute("url", request.getRequestURI());
		return "company_manager/set_module_to_company";
	}
	
	
	@RequestMapping(value = "/reg_enq", method = RequestMethod.POST)
	public void save_company(@ModelAttribute("com_enquiry") @Valid Com_Enquiry com_enquiry, BindingResult result,
		ModelMap model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		String msg="";
		if (result.hasErrors()) {
			 List<FieldError> errors = result.getFieldErrors();
			 for (FieldError error : errors ) {
		        msg +=error.getField()+ " - " + error.getDefaultMessage()+"\n";
			 }
			response.getWriter().write(msg);
			return;
	   	}
		Date dat=new Date(new java.util.Date().getTime());
		Country cntry = helper.getCountryById(request.getParameter("enq_country_id"));
		com_enquiry.setEnq_cuntry(cntry);
		com_enquiry.setEnq_date(dat);
		com_enquiry.setEnq_contact_id(1);
		companyService.saveEnquiry(com_enquiry);
		msg="Registered Successfully..! We will contact you soon.";
		response.getWriter().write(msg);
	}
	
	
	
	
}
