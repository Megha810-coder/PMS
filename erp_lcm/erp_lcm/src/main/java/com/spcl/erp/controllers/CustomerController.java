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
import com.spcl.erp.model.Customer;
import com.spcl.erp.services.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	JSONObject json = new JSONObject();
	private static SecureRandom random = new SecureRandom();
	
	@Autowired
	private Helper helper;
	
	@Autowired
	private CustomerService customerService;
	/*private Helper helper;*/
	@RequestMapping(value = "/mng_customer", method = RequestMethod.GET)
	public String manageEvent(Locale locale, Model model,HttpServletRequest request) {
		
		List<Customer> customer_List=new ArrayList<Customer>();
		customer_List=customerService.getCustomerList();
		
		model.addAttribute("CUSTOMERLIST", customer_List);
		model.addAttribute("helper", helper);
		model.addAttribute("CustomerService", customerService);
		model.addAttribute("url", request.getRequestURI());
		return "customer/customer_list";
	}
	
	@RequestMapping(value = "/new_customer", method = RequestMethod.GET)
	public String new_customer(Locale locale, Model model) {
		
		/*List<City> city_list=new ArrayList<City>();
		city_list=helper.getCityList();*/
		
		
		Customer customer=new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "customer/add_customer_vendor";
	}
	

	@RequestMapping(value = "/save_customer", method = RequestMethod.POST)
	public void save_customer(
			@ModelAttribute("customer") @Valid Customer customer, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flasdatat,
			@RequestParam("cust_profile_photo") MultipartFile file
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

					File dir = new File(Helper.CUSTOMER_IMG_PATH);
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
	   					+ File.separator + img_code) ;
					BufferedOutputStream stream = new BufferedOutputStream(
	   					new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					customer.setCust_img_code(img_code);

					//return "You successfully uploaded file=" +  product.getPro_name();
	   		
	   			} 
	   			catch (Exception e) {
	   				json.put("status", 0);
	   				json.put("error", "You failed to upload " +  customer.getCust_img_code() + " => " + e.getMessage());
	   			}
	   				
   			}
	   		
			String suc_msg="";
			String err_msg="";
			Date dat=new Date(new java.util.Date().getTime());
			String opr_mode=request.getParameter("opr_mode".trim());
			
			customer.setEnq_city(helper.getCityByID(customer.getCust_city_id().intValue()));
			customer.setCust_active(1);
			if (opr_mode.equals("save")) {
				customer.setCust_create_date(dat);
				
				boolean flag=customerService.saveCustomer(customer);
				if(flag) {
					suc_msg="Customer created Successfully..!";
					json.put("status", 1);
				}else {
					json.put("error", 0);
					err_msg="Can't saved...something went wrong..!";
				}
				
			}else if (opr_mode.equals("update")){
				
				customer.setCust_update_date(dat);
				boolean flag=customerService.updateCustomer(customer);
				if(flag) {
					suc_msg="Customer updated Successfully..!";
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
	   	}
		String responseJsonString = json.toString();
 
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJsonString);
    
	}
	
	
	@RequestMapping(value = "/edit_customer", method = RequestMethod.GET)
	public String edit_customer(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("cust_id").trim();
		Customer customer=new Customer();
		customer=customerService.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "update");
		return "customer/add_customer_vendor";
	}
	
	@RequestMapping(value = "/update_customer", method = RequestMethod.POST)
	public String update_customer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result,
			ModelMap model,HttpServletRequest request) throws IOException {
		
		if (result.hasErrors()) {
		 	model.addAttribute("error","true");
		 	return "redirect:/mng_customer";
        }
		Date dat=new Date(new java.util.Date().getTime());
		customer.setCust_update_date(dat);;
		customerService.updateCustomer(customer);
				
		String msg="Customer Updated Successfully..!";
		
		model.addAttribute("msg_on_eventmaster", msg);
		return "customer/mng_customer";
	}
	
	@RequestMapping(value = "/view_customer", method = RequestMethod.GET)
	public String view_customer(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("cust_id").trim();
		Customer customer=new Customer();
		customer=customerService.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		model.addAttribute("helper", helper);
		model.addAttribute("CustomerService", customerService);
		model.addAttribute("opr_mode", "view");
		return "customer/add_customer_vendor";
	}
	
	@RequestMapping(value = "/delete_customer", method = RequestMethod.GET)
    public void deleteEvent(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("lt_id").trim();
		if(customerService.deleteCustomer(id)) {
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
