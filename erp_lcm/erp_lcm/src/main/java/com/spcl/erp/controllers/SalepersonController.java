package com.spcl.erp.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.spcl.erp.model.SalePerson;
import com.spcl.erp.services.SalepersonService;

@Controller
@RequestMapping(value = "/saleperson")
public class SalepersonController {
	
	JSONObject json = new JSONObject();
	private static SecureRandom random = new SecureRandom();
	
	@Autowired
	private Helper helper;
	
	@Autowired
	private SalepersonService salepersonService;
	/*private Helper helper;*/
	@RequestMapping(value = "/mng_saleperson", method = RequestMethod.GET)
	public String managesaleperson(Locale locale, Model model,HttpServletRequest request) {
		
		List<SalePerson> salep_List=new ArrayList<SalePerson>();
		salep_List=salepersonService.getSalepersonList();
		
		model.addAttribute("SALEPERSONLIST", salep_List);
		model.addAttribute("helper", helper);
		model.addAttribute("SalepersonService", salepersonService);
		model.addAttribute("url", request.getRequestURI());
		return "saleperson_list";
	}
	
	@RequestMapping(value = "/new_saleperson", method = RequestMethod.GET)
	public String new_saleperson(Locale locale, Model model) {
		
		SalePerson saleperson=new SalePerson();
		model.addAttribute("saleperson", saleperson);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "salesperson";
	}
	

	@RequestMapping(value = "/save_saleperson", method = RequestMethod.POST)
	public void save_saleperson(
			@ModelAttribute("saleperson") @Valid SalePerson saleperson, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flashdata,
			@RequestParam("salep_profile_photo") MultipartFile file
		) throws IOException {
		
		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			
	   	}else {
	   		if(file!=null&&!file.isEmpty()) {
	   			try {
   					String img_code=new BigInteger(30, random).toString(32).toUpperCase()+".png";
   					byte[] bytes = file.getBytes();
					// Creating the directory to store file

					File dir = new File(Helper.SALEPERSON_IMG_PATH);
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
	   					+ File.separator + img_code) ;
					BufferedOutputStream stream = new BufferedOutputStream(
	   					new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					saleperson.setSalep_img_code(img_code);

					//return "You successfully uploaded file=" +  product.getPro_name();
	   		
	   			} 
	   			catch (Exception e) {
	   				json.put("status", 0);
	   				json.put("error", "You failed to upload " +  saleperson.getSalep_img_code() + " => " + e.getMessage());
	   			}
	   				
   			}
	   		
			String suc_msg="";
			String err_msg="";
			Date dat=new Date(new java.util.Date().getTime());
			String opr_mode=request.getParameter("opr_mode".trim());
			
			
			saleperson.setSalep_active(1);
			if (opr_mode.equals("save")) {
				saleperson.setSalep_create_date(dat);
				
				boolean flag=salepersonService.saveSaleperson(saleperson);
				if(flag) {
					suc_msg="Saleperson created Successfully..!";
					json.put("status", 1);
				}else {
					json.put("error", 0);
					err_msg="Can't saved...something went wrong..!";
				}
				
			}else if (opr_mode.equals("update")){
				
				saleperson.setSalep_update_date(dat);
				boolean flag=salepersonService.updateSaleperson(saleperson);
				if(flag) {
					suc_msg="Saleperson updated Successfully..!";
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
	
	
	@RequestMapping(value = "/edit_saleperson", method = RequestMethod.GET)
	public String edit_saleperson(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("salep_id").trim();
		SalePerson salePerson=new SalePerson();
		salePerson=salepersonService.getSalepersonById(id);
		
		model.addAttribute("saleperson", salePerson);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "update");
		return "salesperson";
	}
	
	@RequestMapping(value = "/update_saleperson", method = RequestMethod.POST)
	public String update_saleperson(@ModelAttribute("saleperson") @Valid SalePerson salePerson, BindingResult result,
			ModelMap model,HttpServletRequest request) throws IOException {
		
		if (result.hasErrors()) {
		 	model.addAttribute("error","true");
		 	return "redirect:/saleperson/mng_saleperson";
        }
		Date dat=new Date(new java.util.Date().getTime());
		salePerson.setSalep_update_date(dat);;
		salepersonService.updateSaleperson(salePerson);
				
		String msg="Saleperson Updated Successfully..!";
		
		model.addAttribute("msg_on_eventmaster", msg);
		return "mng_saleperson";
	}
	
	@RequestMapping(value = "/view_saleperson", method = RequestMethod.GET)
	public String view_saleperson(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("cust_id").trim();
		SalePerson salePerson=new SalePerson();
		salePerson=salepersonService.getSalepersonById(id);
		
		model.addAttribute("saleperson", salePerson);
		model.addAttribute("helper", helper);
		model.addAttribute("salepersonService", salepersonService);
		model.addAttribute("opr_mode", "view");
		return "salesperson";
	}
	
	@RequestMapping(value = "/delete_saleperson", method = RequestMethod.GET)
    public void deletesaleperson(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("salep_id").trim();
		if(salepersonService.deleteSaleperson(id)) {
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
	
	
	/*@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchEvent(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String name=request.getParameter("lt_name").trim() != null ? request.getParameter("lt_name").trim() : "";
		String dt=request.getParameter("ev_str_dt").trim() != null ? request.getParameter("ev_str_dt").trim() : "";
		String loc=request.getParameter("ev_loc").trim() != null ? request.getParameter("ev_loc").trim() : "";
		
		
		List<Customer> customer_List=new ArrayList<Customer>();
		customer_List=customerService.searchCustomerList(cust_name);
				
		
		model.addAttribute("CUSTOMERLIST", customer_List);
		model.addAttribute("cust_name", name);
		model.addAttribute("EV_STR_DT", dt);
		model.addAttribute("EV_LOC", loc);
		
		
		return "admin/event_report";
	}*/
	
}
