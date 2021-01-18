package com.spcl.erp.controllers;

import java.io.IOException;
import java.security.SecureRandom;
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
import com.spcl.erp.model.Contact;
import com.spcl.erp.model.Transfer;
import com.spcl.erp.services.MarketingService;

@Controller
@RequestMapping(value = "/marketing")
public class MarketingController {
	
	public JSONObject json = null;
	private static SecureRandom random = new SecureRandom();
	
	@Autowired
	private Helper helper;
	
	@Autowired
	private MarketingService marketingService;
	
	
	@RequestMapping(value = "/mng_contact", method = RequestMethod.GET)
	public String mng_contact(Locale locale, Model model,HttpServletRequest request) {
		
		List<Contact> contactList=new ArrayList<Contact>();
		contactList=marketingService.getContactList();
		
		model.addAttribute("contact_list", contactList);
		model.addAttribute("url", request.getRequestURI());
		return "marketing/contact_list";
	}
	
	@RequestMapping(value = "/new_contact", method = RequestMethod.GET)
	public String new_contact(Model model,HttpServletRequest request) {
		
		Contact contact=new Contact();
		model.addAttribute("contact", contact);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "marketing/add_contact";
	}
	

	@RequestMapping(value = "/save_contact", method = RequestMethod.POST)
	public void save_customer(
			@ModelAttribute("contact") @Valid Contact contact, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flasdatat
		) throws IOException {
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        json=new JSONObject();
        
        String suc_msg="";
		String err_msg="";
		
		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}

		String opr_mode=request.getParameter("opr_mode").trim();
		
		if (opr_mode.equals("save")) {
			
			boolean flag=marketingService.saveContact(contact);
			if(flag) {
				suc_msg="Contact created Successfully..!";
				json.put("status", 1);
			}else {
				json.put("error", 0);
				err_msg="Can't saved...something went wrong..!";
			}
				
		}else if (opr_mode.equals("update")){
			boolean flag=marketingService.updateContact(contact);
			if(flag) {
				suc_msg="Contact updated Successfully..!";
				json.put("status", 1);
			}else {
				json.put("error", 0);
				err_msg="Can't update...something went wrong..!";
			}
				
		}
		
		json.put("success", suc_msg);
		json.put("error", err_msg);
		flasdatat.addFlashAttribute("suc_msg", suc_msg);
		flasdatat.addFlashAttribute("err_msg", err_msg);
	   	
        response.getWriter().write(json.toString());
	   	return;
	}
	
	@RequestMapping(value = "/edit_contact", method = RequestMethod.GET)
	public String edit_contact(	
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
		) {
		
		String id=request.getParameter("cntc_id").trim();
		Contact contact=new Contact();
		contact=marketingService.getContactById(id);
		
		model.addAttribute("contact", contact);
		model.addAttribute("opr_mode", "update");
		//model.addAttribute("helper", helper);
		return "marketing/add_contact";
	}
	
	@RequestMapping(value = "/view_contact", method = RequestMethod.GET)
	public String view_contact(	
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
		) {
		
		String id=request.getParameter("cntc_id").trim();
		Contact contact=new Contact();
		contact=marketingService.getContactById(id);
		
		model.addAttribute("contact", contact);
		model.addAttribute("opr_mode", "view");
		//model.addAttribute("helper", helper);
		return "marketing/add_contact";
	}
	
	@RequestMapping(value = "/delete_contact", method = RequestMethod.GET)
    public void delete_contact(
    		HttpServletRequest request,
    		HttpServletResponse response
    	) {
		String msg="false";
		String id=request.getParameter("cntc_id").trim();
		if(marketingService.deleteContact(id)) {
			msg="true";
		}
	
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
 		try {
 			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
       
    }

}
