package com.spcl.erp.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

import com.google.gson.Gson;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Visitor;

import com.spcl.erp.services.VisitorService;

@Controller
@RequestMapping(value="/visitor")
public class VisitorController {
	
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private Helper helper;
	

	JSONObject json = new JSONObject();
	
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_visitor", method = RequestMethod.GET  )
	public String manageEvent(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
		
	List<Visitor> visitor_list=new ArrayList<Visitor>();
	visitor_list=visitorService.getVisitor_list();


	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        if(visitor_list.size()>0) {
	        	  Json=json.toJson(visitor_list);
	        	 out.print(Json);
	        }
	        model.addAttribute("Json", Json);
	        model.addAttribute("helper", helper);
	        model.addAttribute("visitorService", visitorService);
	        model.addAttribute("url", request.getRequestURI());
	        return "visitor/mng_visitor";
	}
	
	@RequestMapping(value = "/new_visitor", method = RequestMethod.GET)
	public String new_labour(Locale locale, Model model) {
		
		Visitor visitor=new Visitor();
		//visitor.setLab_code(helper.getLabourCode());
		model.addAttribute("visitor", visitor);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "visitor/add_labour";
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/save_visitor", method = RequestMethod.POST)
	public void save_visitor(
			@ModelAttribute("data") @Valid Visitor visitor, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flashdata
		) throws IOException {
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        json=new JSONObject();
       
        String data = "";   
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        data = builder.toString();
        System.out.println(data);
        JSONObject jsonObj = new JSONObject(data);
        System.out.println(jsonObj);
        
        String appointment_no = jsonObj.getString("appointment_no");
        visitor.setAppointment_no(appointment_no);
        
      
        visitor.setVisitor_active(1);
        
        String arrival_time = jsonObj.getString("arrival_time");
        visitor.setArrival_time(arrival_time);
        
        
        String hours  = jsonObj.getString("hours");
        visitor.setVisiting_hour_per_day(hours);
        
        String visitor_name = jsonObj.getString("visitor_name");
        visitor.setVisitor_name(visitor_name);
        
        String org_name = jsonObj.getString("org_name");
        visitor.setOrganization_name(org_name);
        
        String mobile_no = jsonObj.getString("mobile_no");
        visitor.setMobile_no(mobile_no);
        
        String email = jsonObj.getString("email");
        visitor.setEmail(email);
        
        String visitor_type = jsonObj.getString("visitor_type");
        visitor.setVisitor_type(visitor_type);
        
        String carryring = jsonObj.getString("carryring");
        visitor.setCarryng_device(carryring);
        
        String host_name = jsonObj.getString("host_name");
        visitor.setHost_name(host_name);
        
        String dept_name = jsonObj.getString("dept_name");
        visitor.setDept_name(dept_name);
        
        String purpose = jsonObj.getString("purpose");
        visitor.setPurpose(purpose);
        
        
        String suc_msg="";
		String err_msg="";
		
		
		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}
			boolean flag=visitorService.saveVisitor(visitor);
			if(flag) {
				suc_msg="Visitor created Successfully..!";
				json.put("status", 1);
			}else {
				json.put("error", 0);
				err_msg="Can't saved...something went wrong..!";
			}
		
		model.addAttribute("err_msg", err_msg);
		json.put("success", suc_msg);
		json.put("error", err_msg);
		
		flashdata.addFlashAttribute("suc_msg", suc_msg);
		flashdata.addFlashAttribute("err_msg", err_msg);
		response.getWriter().write(json.toString());
		return;
		
    }
	
	
}
