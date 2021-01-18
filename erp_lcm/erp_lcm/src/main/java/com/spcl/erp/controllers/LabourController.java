package com.spcl.erp.controllers;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Employee_Education;
import com.spcl.erp.model.Hazardous_Chemicals;
import com.spcl.erp.model.HrRequirement;
import com.spcl.erp.model.Labour;
import com.spcl.erp.model.LabourCheck;
import com.spcl.erp.model.Product;
import com.spcl.erp.model.SalePerson;
import com.spcl.erp.model.ShiftTime;
import com.spcl.erp.model.VMS_Feedback;
import com.spcl.erp.model.Address;
import com.spcl.erp.model.Contractor;
import com.spcl.erp.model.Department_type;
import com.spcl.erp.model.Employee;
import com.spcl.erp.services.EmployeeService;
import com.spcl.erp.services.ExpensesService;
import com.spcl.erp.services.ExportContractor;
import com.spcl.erp.services.ExportLabour;
import com.spcl.erp.services.FileUploadLabourService;
import com.spcl.erp.services.LabourService;
@Controller
@RequestMapping(value = "/labour")

public class LabourController {

	JSONObject json = new JSONObject();
	private static SecureRandom random = new SecureRandom();
	@Autowired
	private Helper helper;
	 @Autowired
	private FileUploadLabourService fileUploadLabourService;
	 @Autowired
		private ExportLabour exportLab;
		
		@Autowired
		private ExportContractor exportcon;
	@Autowired
	private LabourService labourService;
	@Autowired
	private ExpensesService expensesService;
	
	public void setExpensesService(ExpensesService expensesService) {
		this.expensesService = expensesService;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/con_name", method = RequestMethod.GET)  
	public String con_name(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
	List<Contractor> contractor_name=new ArrayList<Contractor>();
	contractor_name=labourService.getContractor_name();


	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        if(contractor_name.size()>0) {
	        	  Json=json.toJson(contractor_name);
	        	 out.print(Json);
	        }
	      
	        model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("labourService", labourService);
	model.addAttribute("url", request.getRequestURI());
	return "labour/con_name";
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/lab_name", method = RequestMethod.GET)  
	public String lab_name(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
		
		String id=request.getParameter("cd_id");
		
		List<Labour> lab_name=labourService.getById(id);
		
			System.out.println("Hii");
	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        if(lab_name.size()>0) {
	        	  Json=json.toJson(lab_name);
	        	 out.print(Json);
	        }
	      
	        model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("labourService", labourService);
	model.addAttribute("url", request.getRequestURI());
	return "labour/lab_name";
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/lab_count", method = RequestMethod.GET)  
	public String lab_count(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
		
		String id=request.getParameter("cd_id");
		//Integer TotalLabour=labourService.getById1();
		Integer lab_count=labourService.getById1(id);
		
			System.out.println("Hii");
	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        if(lab_count>0) {	        	
	        	Json=json.toJson(lab_count);
	        	 out.print(Json);
	        }
	      
	        model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("labourService", labourService);
	return "labour/lab_count";
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_labour", method = RequestMethod.GET)  
	public String manageEvent(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
	List<Labour> lab_list=new ArrayList<Labour>();
	lab_list=labourService.getLabour_list1();


	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        if(lab_list.size()>0) {
	        	  Json=json.toJson(lab_list);
	        	 out.print(Json);
	        }
	        model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("labourService", labourService);
	model.addAttribute("url", request.getRequestURI());
	return "labour/mng_labour";
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_contract", method = RequestMethod.GET)  
	public String manageEvent1(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
	List<Contractor> contractor_list=new ArrayList<Contractor>();
	contractor_list=labourService.getContractor_list1();


	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        if(contractor_list.size()>0) {
	        	  Json=json.toJson(contractor_list);
	        	 out.print(Json);
	        }
	        model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("labourService", labourService);
	model.addAttribute("url", request.getRequestURI());
	return "labour/mng_contract";
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_checkIn", method = RequestMethod.GET)  
	public String manageEvent11(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
	List<LabourCheck> lab_checkin_list=new ArrayList<LabourCheck>();
	
	lab_checkin_list=labourService.getLabourCheck_list1();


	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        if(lab_checkin_list.size()>0) {
	        	  Json=json.toJson(lab_checkin_list);
	        	 out.print(Json);
	        }
	        model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("labourService", labourService);
	model.addAttribute("url", request.getRequestURI());
	return "labour/mng_checkIn";
	}
	
	/*@RequestMapping(value = "/mng_labour", method = RequestMethod.GET)
	public String manageEvent(Locale locale, Model model,HttpServletRequest request) {
		
		List<Labour> lab_list=new ArrayList<Labour>();
		lab_list=labourService.getLabour_list();
		
		model.addAttribute("lab_list", lab_list);
		model.addAttribute("helper", helper);
		model.addAttribute("labourService", labourService);
		model.addAttribute("url", request.getRequestURI());
		return "labour/labour_list";
	}*/
	@RequestMapping(value = "/new_labour", method = RequestMethod.GET)
	public String new_labour(Locale locale, Model model) {
		Labour lab=new Labour();
		lab.setLab_code(helper.getLabourCode());
		model.addAttribute("lab", lab);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "labour/add_labour";
	}
	@CrossOrigin(origins="http://localhost:4200")
			 @RequestMapping(value = "/save_labour", method = RequestMethod.POST)
			 public void save_labour(
			 @ModelAttribute("data") @Valid Labour labour, 
			 BindingResult result,
			 ModelMap model,
			 HttpServletRequest request, 
			 HttpServletResponse response,
			 RedirectAttributes flashdata)
			  throws IOException {

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
			     	
			         String lab_code = jsonObj.getString("lab_code");
			     	 labour.setLab_code(lab_code);
			     	 
			     	String lab_title = jsonObj.getString("lab_title");
			     	labour.setLab_title(lab_title);
			     	  
			     	  String lab_fname = jsonObj.getString("lab_fname");
			     	 labour.setLab_fname(lab_fname);
			     	  
			     	  String lab_mname = jsonObj.getString("lab_mname");
			     	 labour.setLab_mname(lab_mname);
			     	  
			     	String lab_lname = jsonObj.getString("lab_lname");
			     	labour.setLab_lname(lab_lname);
			     	
			     	String lab_mobile_no = jsonObj.getString("lab_mobile_no");
			     	labour.setLab_mobile_no(lab_mobile_no);
			     	
			     	String corr_line1 = jsonObj.getString("corr_line1");
			     	labour.setCorr_line1(corr_line1);
			     	
			     	String corr_line2 = jsonObj.getString("corr_line2");
			     	labour.setCorr_line2(corr_line2);  
			     	
			     	String lab_marital_status = jsonObj.getString("lab_marital_status");
			     	labour.setLab_marital_status(lab_marital_status);

			     	String con_name = jsonObj.getString("cd_id");
			     	Contractor con = helper.getContractorByName(con_name);
			     	labour.setContractor(con);
			     	 
			     	 /*String lab_fname = jsonObj.getString("labour_lab_id";
			     	Labour lab = helper.getLabourByName(lab_fname);
			     	labourCheck.setLabour(lab);*/
			     	
			     	String lab_city_id = jsonObj.getString("lab_city_id");
			     	labour.setLab_city_id(lab_city_id);
			     	
			     	String lab_dob = jsonObj.getString("lab_dob");
			     	labour.setLab_dob(lab_dob);
			     	
			     	String lab_join_date = jsonObj.getString("lab_join_date");
			     	labour.setLab_join_date(lab_join_date);
			     	
			     	/*String lab_gender_1 = jsonObj.getString("lab_gender_1";
//				      	  int lab_gender = Integer.parseInt(lab_gender_1);
			    	  String lab_gender_2 = jsonObj.getString("lab_gender_2";
			    	
			  if(lab_gender_1 != "null" {
			  labour.setLab_gender(lab_gender_1);
			  }
			    	  else {
			    	   labour.setLab_gender(lab_gender_2);
			    	  }*/

			     	/* String training_date = jsonObj.getString(data);
			   String training_date="31/12/1998";  
			         java.util.Date date1=new SimpleDateFormat("dd/MM/yyyy".parse(training_date);  
			         System.out.println(training_date+"\t"+date1); */
			         
			     	 /* String industrial_date = jsonObj.getString("industrial_date";
			     	  DateFormat df = new SimpleDateFormat("yyyy-MM-dd";
			     	  Date date=(Date) df.parse(industrial_date);
			     	  System.out.println(date);
			     	  industrial.setIndustrial_date(date);*/
			     	 

			     	labour.setLab_active(1);
			     	
			         String suc_msg="";
			 String err_msg="";

			 if (result.hasErrors()) {
			 json.put("status", 0);
			 json.put("error", helper.getErrors(result));
			 response.getWriter().write(json.toString());
			 return;

			    	}
			 boolean flag=labourService.saveLabour(labour);
			 //boolean flag1=ehsService.saveTransport(transport);
			 if(flag) {
			 suc_msg="industrial created Successfully..!";
			 json.put("status", 1);
			 }

			 else {
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

	
	/*@RequestMapping(value = "/mng_contract", method = RequestMethod.GET)
	public String mng_contract(Locale locale, Model model,HttpServletRequest request) {
		
		List<Contractor> ctr_list=new ArrayList<Contractor>();
		ctr_list=labourService.getContractor_list();
		Integer shift1Count=0;
		Integer shift2Count=0;
		Integer shift3Count=0;
		for(Contractor contract:ctr_list) {
			contract.getLabour();
			
			 * Integer cd_id=contract.getCd_id();
			 * shift1Count=labourService.getContractLabourShiftCOunt1(cd_id);
			 
			
		}
		
		
		 * for (Contractor contractor : ctr_list) {
		 * 
		 * 
		 * 
		 * shift2Count=labourService.getContractLabourShiftCOunt2(cd_id);
		 * shift3Count=labourService.getContractLabourShiftCOunt3(cd_id); }
		 
	
		
		
		model.addAttribute("shift1Count", shift1Count);
		model.addAttribute("shift2Count", shift2Count);
		model.addAttribute("shift3Count", shift3Count);
		model.addAttribute("ctr_list", ctr_list);
		model.addAttribute("helper", helper);
		model.addAttribute("labourService", labourService);
		model.addAttribute("url", request.getRequestURI());
		return "labour/contractor_list";
	}*/
	
	@RequestMapping(value = "/new_contract", method = RequestMethod.GET)
	public String new_contract(Locale locale, Model model) {
		
		Contractor contract=new Contractor();
		contract.setCd_code(helper.getContractorCode());
		model.addAttribute("contract", contract);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "labour/add_contractor";
	}
	@CrossOrigin(origins="http://localhost:4200")
			 @RequestMapping(value = "/save_contract", method = RequestMethod.POST)
			 public void save_contract(
			 @ModelAttribute("data") @Valid Contractor contract, 
			 BindingResult result,
			 ModelMap model,
			 HttpServletRequest request, 
			 HttpServletResponse response,
			 RedirectAttributes flashdata)
			  throws IOException {

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
			     	
			         String cd_code = jsonObj.getString("cd_code");
			     	 contract.setCd_code(cd_code);
			     	 
			     	 String cd_title = jsonObj.getString("cd_title");
			     	 contract.setCd_title(cd_title);
			     	  
			     	  String cd_fname = jsonObj.getString("cd_fname");
			     	 contract.setCd_fname(cd_fname);
			     	  
			     	  String cd_mname = jsonObj.getString("cd_mname");
			     	 contract.setCd_mname(cd_mname);
			     	  
			     	String cd_lname = jsonObj.getString("cd_lname");
			     	contract.setCd_lname(cd_lname);
			     	
			     	String cd_mobile_no = jsonObj.getString("cd_mobile_no");
			     	contract.setCd_mobile_no(cd_mobile_no);
			     	
			     	String corr_line1 = jsonObj.getString("corr_line1");
			     	contract.setCorr_line1(corr_line1);
			     	
			     	String corr_line2 = jsonObj.getString("corr_line2");
			     	contract.setCorr_line2(corr_line2); 
			     	
			     	String cd_dob = jsonObj.getString("cd_dob");
			     	contract.setCd_dob(cd_dob); 
			     	
			     	

			     	contract.setCd_active(1);
			     	
			         String suc_msg="";
			 String err_msg="";

			 if (result.hasErrors()) {
			 json.put("status", 0);
			 json.put("error", helper.getErrors(result));
			 response.getWriter().write(json.toString());
			 return;

			    	}
			 boolean flag=labourService.saveContractor(contract);
			 //boolean flag1=ehsService.saveTransport(transport);
			 if(flag) {
			 suc_msg="industrial created Successfully..!";
			 json.put("status", 1);
			 }

			 else {
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
	
	/*@RequestMapping(value = "/view_con_labour", method = RequestMethod.GET)
	public String view_con_labour(
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
	) {
		
		if (request.getParameter("cd_id")==null) {
			return "redirect:/error_404";
		}
		String id=request.getParameter("cd_id").trim();
		
		Contractor contract=labourService.getContractorById(id);
		model.addAttribute("contract", contract);
		model.addAttribute("helper", helper);
		model.addAttribute("labourService", labourService);
		
		return "labour/labour_contract_list";
	}*/
	
	@RequestMapping(value = "/view_checkInList", method = RequestMethod.GET)
	public String view_checkInList(
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
	) {
		
		if (request.getParameter("labour_lab_id")==null) {
			return "redirect:/error_404";
		}
		 LocalDate localDate = LocalDate.now();
		 String id=request.getParameter("labour_lab_id".trim());
		 /*	int labour_lab_id = Integer.parseInt(id);*/
		 List<LabourCheck> labourcheck=labourService.getCheckInListById(id);
		 for(LabourCheck labourCh:labourcheck) {
		 Integer shift=labourCh.getShift_time().getShift_id();
		 if(shift==1) {
		 Timestamp check_out_=(Timestamp)labourCh.getCheck_out();
		 if(check_out_==null) {
		 Time Shift_time_out=(Time) labourCh.getShift_time().getShift_time_out();
		 LocalTime localTime = Shift_time_out.toLocalTime();
		     LocalDateTime dt = LocalDateTime.of(localDate, localTime);
		     Timestamp check_out_update = Timestamp.valueOf(dt);
		     labourCh.setCheck_out(check_out_update);
		 }
		 }
		 else if(shift==2) {
		 Timestamp check_out_=(Timestamp)labourCh.getCheck_out();
		 if(check_out_==null) {
		 Time Shift_time_out=(Time) labourCh.getShift_time().getShift_time_out();
		 LocalTime localTime = Shift_time_out.toLocalTime();
		     LocalDateTime dt = LocalDateTime.of(localDate, localTime);
		     Timestamp check_out_update = Timestamp.valueOf(dt);
		     labourCh.setCheck_out(check_out_update);	 }
		 }
		 else if(shift==3) {
		 Timestamp check_out_=(Timestamp)labourCh.getCheck_out();
		 if(check_out_==null) {
		 Time Shift_time_out=(Time) labourCh.getShift_time().getShift_time_out();
		 LocalTime localTime = Shift_time_out.toLocalTime();
		     LocalDateTime dt = LocalDateTime.of(localDate, localTime);
		     Timestamp check_out_update = Timestamp.valueOf(dt);
		     labourCh.setCheck_out(check_out_update);	 }
		 }
		 else {
		 System.out.println("checkOut Time ids Null");
		 }
		 labourService.updateLabourCheck(labourCh);
		 }

		Labour labour = labourService.getLabourById(id);
		model.addAttribute("labourcheck", labourcheck);
		model.addAttribute("labour", labour);
		model.addAttribute("helper", helper);
		model.addAttribute("labourService", labourService);
		
		return "labour/labour_checkInList";
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(Locale locale, Model model) {
		Date Check_in_time=new Date(new java.util.Date().getTime());
		Integer TotalLabour=labourService.getTotalLabour();
		
		
		Integer TotalContractor=labourService.getTotalContractor();
	
		 Integer totalCHeckIn=labourService.getTodayTotalLabourCheckIN(); 
		List<Object> cntlist=labourService.gettotalweeklyCount();
		
		 Integer shift1Count=labourService.getLabourCheckinShift1COunt(); 
		  Integer shift2Count=labourService.getLabourCheckinShift2COunt(); 
		  Integer shift3Count=labourService.getLabourCheckinShift3COunt(); 
		  Integer department1Count=labourService.getLabourCheckinDepartment1Count();
		  Integer TotalHrlabourrequirement=labourService.getTotalHrlabourrequirement();
		  
		model.addAttribute("shift1Count",shift1Count);
		model.addAttribute("TotalHrlabourrequirement",TotalHrlabourrequirement);
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
	
	/*@RequestMapping(value = "/mng_checkIn")
	public String manageCheckInEvent(
			Locale locale, 
			Model model,
			HttpServletRequest request) {
		
		List<LabourCheck> check_list=new ArrayList<LabourCheck>();
		Map<String, String> search=null;
		
		String search_Labour= request.getParameter("search_Labour");
		String check_in=null;
		
		if (search_Labour!=null&&search_Labour.equals("true")) {
			
			search=new HashMap<String, String>();
			
			check_in=request.getParameter("Check_in_time");
			String date = expensesService.formatDate(check_in);
			search.put("Check_in_time", date);
			
			String shift_id=request.getParameter("shift_id");
			search.put("shift_id", shift_id);
			
			String dept_name=request.getParameter("dt_department_name");
			search.put("dt_department_name", dept_name);
		}
		
		
		
		if (search_Labour!=null&&search_Labour.equals("true")) {
		try {
				search.put("Check_in_time", helper.DATEFORMAT.format(helper.DATEFORMAT.parse(check_in)));
			} catch (ParseException e) {
				search.put("Check_in_time", "");
				e.printStackTrace();
			}
		}
		check_list=labourService.getCheckIn_list(search);
		model.addAttribute("check_list", check_list);
		model.addAttribute("search", search);
		model.addAttribute("helper", helper);
		model.addAttribute("labourService", labourService);
		model.addAttribute("url", request.getRequestURI());
		return "labour/labCheck_list";
	}*/
	@RequestMapping(value = "/new_labour_check", method = RequestMethod.GET)
	public String new_labour_check(Locale locale, Model model) {
		
		LabourCheck labourCheck=new LabourCheck();
	/*	lab.setLab_code(helper.getLabourCode());*/
		model.addAttribute("labourCheck", labourCheck);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "labour/add_labCheck";
	}
	
	@RequestMapping(value = "/save_labCheck", method = RequestMethod.POST)
	public void save_labCheck(
			@ModelAttribute("labourCheck") @Valid LabourCheck labourCheck, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flashdata
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
		Labour labour=new Labour();
		String labour_lab_id_=request.getParameter("labour_lab_id");
		
		labour=helper.getLabourById(labour_lab_id_);
		labourCheck.setLabour(labour);
		 
		LocalDate localDate = LocalDate.now();
		Date date = java.sql.Date.valueOf(localDate);
	
		Integer labour_lab_id=Integer.parseInt(labour_lab_id_);
		Integer checkInCount=labourService.getCheckCountById(labour_lab_id);
		
		if(checkInCount<5) {
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());
		String opr_mode=request.getParameter("opr_mode").trim();
		String dept_id=request.getParameter("department_dept_id");
		Department_type dept=helper.getDepartmentById(dept_id);
		labourCheck.setDepartment(dept);
		String shift_time_=request.getParameter("shift_id");
		Integer shift_time= Integer.parseInt(shift_time_);
		ShiftTime shift=helper.getShiftTimeById(shift_time);
		labourCheck.setShift_time(shift);
		
		labourCheck.setCheck_in_time(date);
	
		labourCheck.setCheck_active(1);;
		if (opr_mode.equals("save")) {
			labourCheck.setCheck_in(timestamp);				
			labourCheck.setCheck_In_Status("Check_In");
			boolean flag=labourService.saveLabourCheck(labourCheck);
			if(flag) {
				suc_msg="Labour created Successfully..!";
				json.put("status", 1);
			}else {
				json.put("error", 0);
				err_msg="Can't saved...something went wrong..!";
			}
		}
		}
		else {
			/*json.put("error", 0);*/
			err_msg="Labour completed 210 days....!";
			response.getWriter().write(err_msg);
						
		}
		model.addAttribute("err_msg", err_msg);
		json.put("success", suc_msg);
		json.put("error", err_msg);
		
		flashdata.addFlashAttribute("suc_msg", suc_msg);
		flashdata.addFlashAttribute("err_msg", err_msg);
		response.getWriter().write(json.toString());
		return;
		
    }
	
	
	@RequestMapping(value = "/check_out", method = RequestMethod.GET)
	public String check_out(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) {
		
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());
		String lab_check_id=request.getParameter("lab_check_id").trim();
		LabourCheck labourCheck=new LabourCheck();
		
		labourCheck=labourService.getLabCheckById(lab_check_id);
		labourCheck.setCheck_out(timestamp);
	/*	labourCheck.setCheck_In_Status("Check_Out");*/
		labourService.updateLabourCheck(labourCheck);
		
		
		
		Integer shift=labourCheck.getShift_time().getShift_id();
		
		if(shift!=null) {
			
			Timestamp check_in=(Timestamp)labourCheck.getCheck_in();
			Timestamp check_out=(Timestamp)labourCheck.getCheck_out();
			float diff =check_out.getTime() - check_in.getTime()  ;
			float diffHours = diff / (60 * 60 * 1000) % 24;
			Integer diffTimes = (int) (long) diffHours;
			if(shift!=3) {
				if(diffHours>=8.5 && diffHours<=8.75) {
					labourCheck.setStatus(1);
				}
				else if(diffHours>=4.5 && diffHours<8.5 ) {
					labourCheck.setStatus(0);
				}
				else {
					labourCheck.setStatus(2);
				}
				}else {
					labourCheck.setStatus(1);
				}
				labourService.updateLabourCheck(labourCheck);
		}
		/*else if(shift.equals("3.30-12")) {
			Timestamp check_in=(Timestamp)labourCheck.getCheck_in();
			Timestamp check_out=(Timestamp)labourCheck.getCheck_out();
			long diff =check_out.getTime() - check_in.getTime()  ;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			Integer diffTimes = (int) (long) diffHours;
			if(diffTimes>=4) {
				labourCheck.setStatus(1);
			}
			else if(diffTimes<=4) {
				labourCheck.setStatus(0);
			}
			labourService.updateLabourCheck(labourCheck);
		}
		else if(shift.equals("12-7")) {
			Timestamp check_in=(Timestamp)labourCheck.getCheck_in();
			Timestamp check_out=(Timestamp)labourCheck.getCheck_out();
			long diff =check_out.getTime() - check_in.getTime()  ;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			Integer diffTimes = (int) (long) diffHours;
			if(diffTimes>=4) {
				labourCheck.setStatus(1);
			}
			else if(diffTimes<=4) {
				labourCheck.setStatus(0);
			}
			labourService.updateLabourCheck(labourCheck);
		}
		*/

		model.addAttribute("labourCheck", labourCheck);
		return "redirect:mng_checkIn";
	}
	
	@RequestMapping(value = "/salary", method = RequestMethod.GET)
	public String salary(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) {
		Integer halfDay=0;
		Integer fullDay=0;
		Integer halfDaysalary=0;
		Integer halfSalary=0;
		Integer fullSalary=0;
		Integer salary=0;
		Integer salary_addtion=0;
		Integer total_salary_addtion=0;
		Integer leave=0;
		
		Labour labour=new Labour();
		Timestamp timestamp= new Timestamp(System.currentTimeMillis());
		String Lab_id_=request.getParameter("lab_id").trim();
		Integer Lab_id=Integer.parseInt(Lab_id_);
		System.out.println(Lab_id);
		
		LabourCheck labourCheck=new LabourCheck();
		LocalDate localDate = LocalDate.now();
		Date date = java.sql.Date.valueOf(localDate);
		
	/*	labourCheck=labourService.getLabCheckById(lab_check_id);
		Integer lab_id=labourCheck.getLabour().getLab_id();*/
		
		List<LabourCheck> labourcheck=labourService.getLabListById(Lab_id);
		for(LabourCheck lab:labourcheck) {
			Integer shift=lab.getShift_time().getShift_id();
			
				if(shift!=null) {
				
				Timestamp check_in=(Timestamp)lab.getCheck_in();
				Timestamp check_out=(Timestamp)lab.getCheck_out();
				float diff = check_out.getTime() - check_in.getTime() ;
				float diffHours = diff / (60 * 60 * 1000) % 24;
				/*Integer diffTimes = (int) (long) diffHours;*/
				if(shift!=3) {
				if(diffHours>=8.5 && diffHours<=8.75) {
					lab.setStatus(1);
					 fullSalary=300;
					lab.setSalary(fullSalary);
				}
				else if(diffHours>=4.5 && diffHours<8.5 ) {
					lab.setStatus(0);
					 halfDaysalary=300/2;
					 lab.setSalary(halfDaysalary);
				}
				else {
					lab.setStatus(2);
					lab.setSalary(0);
				}
				}else {
					lab.setStatus(1);
					 fullSalary=300;
					lab.setSalary(fullSalary);
				}
				labourService.updateLabourCheck(lab);
			}
				 halfDay=labourService.getTotalHalfDay(Lab_id);
				 fullDay=labourService.getTotalfullDay(Lab_id);
				 leave=labourService.getTotalLeaveDay(Lab_id);
				
				 halfDaysalary=300/2;
				 halfSalary=halfDay * halfDaysalary;
				 fullSalary=fullDay *300;
				
				/* salary= fullSalary + halfSalary;*/
				
			/*	lab.setSalary(salary);*/
				/*labourService.updateLabourCheck(lab);*/
		}
		
		List<LabourCheck> labourcheck_salary=labourService.getLabListById(Lab_id);
		for(LabourCheck salary_add:labourcheck_salary) {
			System.out.println(salary_add);
			
			salary_addtion= salary_add.getSalary();
			total_salary_addtion +=salary_addtion;
			System.out.println(total_salary_addtion);
			}

		
		model.addAttribute("total_salary_addtion",total_salary_addtion);
		model.addAttribute("halfDay", halfDay);
		model.addAttribute("fullDay", fullDay);
		model.addAttribute("leave", leave);
		model.addAttribute("salary", salary);
		model.addAttribute("halfSalary", halfSalary);
		model.addAttribute("fullSalary", fullSalary);
		model.addAttribute("labourCheck", labourCheck);
		model.addAttribute("labourService", labourService);
		model.addAttribute("Lab_id_", Lab_id_);
		model.addAttribute("labour", labour);
		model.addAttribute("opr_mode", "view");
		return "labour/salary_view";
	}
	 @RequestMapping(value = "/import_labour", method = RequestMethod.POST)
	 public void import_labour(ModelMap model, HttpServletRequest request, HttpServletResponse response,
	 @RequestParam("excel_file") MultipartFile file) throws IOException {

	 response.setContentType("application/json");
	 response.setCharacterEncoding("UTF-8");
	 json = new JSONObject();

	 String suc_msg = "";
	 String err_msg = "";
	 File excel_file=null;
	 if (file != null && !file.isEmpty()) {
	 try {
	 //String img_code = "LAB_IMP_" + new BigInteger(30, random).toString(32).toUpperCase() + ".xlsx";
	 String img_code = "LAB_IMP"+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
	 byte[] bytes = file.getBytes();
	 // Creating the directory to store file

	 File dir = new File(Helper.EMP_EXCEl_PATH);
	 if (!dir.exists())
	 dir.mkdirs();

	 // Create the file on server
	 excel_file = new File(dir.getAbsolutePath() + File.separator + img_code);
	 BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(excel_file));
	 stream.write(bytes);
	 stream.close();

	 } catch (Exception e) {
	 json.put("status", 0);
	 json.put("error", "You failed to upload excel file => " + e.getMessage());
	 }

	 }

	 if (excel_file != null && excel_file.exists()) {

	 /*fileuploadService.uploadFileData(excel_file,helper);*/
	 fileUploadLabourService.uploadLabourFileData(excel_file,helper);
	 suc_msg = "Employee file imported Successfully..!";
	 }else {
	 err_msg = "Can't import...something went wrong..!";
	 }

	 json.put("success", suc_msg);
	 json.put("error", err_msg);
	 json.put("error", err_msg);

	 response.getWriter().write(json.toString());
	 return;

	 }
	 @RequestMapping(value = "/mng_attendance",method = RequestMethod.GET)
		public String  mng_attendance(Locale locale, Model model,HttpServletRequest request) {
			
			List<LabourCheck> check_list=new ArrayList<LabourCheck>();
			Map<String, String> search=new HashMap<String, String>();
			Integer salary_not_null=0;
			String search_Labour= request.getParameter("search_Labour");
			String check_in=null;
			
			if (search_Labour!=null&&search_Labour.equals("true")) {
				
				check_in=request.getParameter("Check_in_time");
				String date = expensesService.formatDate(check_in);
				search.put("Check_in_time", date);
				
				String shift_id=request.getParameter("shift_id");
				search.put("shift_id", shift_id);
				
				String dept_name=request.getParameter("dt_department_name");
				search.put("dt_department_name", dept_name);
					
			}
			String search_type=request.getParameter("search_type");
			if(search_type!=null && !search_type.isEmpty()){
				if (search_type.equals("week")) {						
					search.put("week", "week");}
				if (search_type.equals("month")) {						
					search.put("month", "month");}
				if (search_type.equals("year")) {						
					search.put("year", "year");}
				}
			String shift_type=request.getParameter("shift_type");
			if(shift_type!=null && !shift_type.isEmpty()){
			if (shift_type.equals("1")) {	
			search.put("1", "1");}
			if (shift_type.equals("2")) {	
			search.put("2", "2");}
			if (shift_type.equals("3")) {	
			search.put("3", "3");}

			}
			check_list=labourService.getCheckIn_list(search);
			for(LabourCheck salary:check_list) {
				Labour labour_salary=new Labour();
				Integer Lab_id_check=salary.getLabour().getLab_id();
				labour_salary=labourService.getLabourById(Lab_id_check.toString());
				salary_not_null=labour_salary.getLab_salary();
				if(salary_not_null==null) {
					labour_salary.setLab_salary(0);
				}
				labourService.updateLabour(labour_salary);
			}
			if (search_Labour!=null&&search_Labour.equals("true")) {
			try {
					search.put("Check_in_time", helper.DATEFORMAT.format(helper.DATEFORMAT.parse(check_in)));
				} catch (ParseException e) {
					search.put("Check_in_time", "");
					e.printStackTrace();
				}
			}
		
			model.addAttribute("check_list", check_list);
			model.addAttribute("search", search);
			model.addAttribute("helper", helper);
			model.addAttribute("labourService", labourService);
			
			model.addAttribute("url", request.getRequestURI());
			return "labour/lab_attendance";
		}
	 @RequestMapping(value = "/export_labour", method = RequestMethod.GET)
		public void export(
				Model model, 
				HttpServletResponse response
				) {
			
			try {
				File dwn_file=exportLab.buildExcelFile();
				if (dwn_file.exists())
		        {
		            response.setContentType("application/octet-stream");
		            response.addHeader("Content-Disposition", "attachment; filename="+dwn_file.getName());
		            response.setContentLength((int) dwn_file.length());
		            try
		            {
		            	/**** Get The Output Stream Of The Response ****/
		    			OutputStream outStream = response.getOutputStream();
		    			FileInputStream inputStream = new FileInputStream(dwn_file);
		    			byte[] buffer = new byte[4096];
		    			int bytesRead = -1;

		    			/**** Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data  Read From The Input Stream Into The Output Stream ****/
		    			while ((bytesRead = inputStream.read(buffer)) != -1) {
		    				outStream.write(buffer, 0, bytesRead);
		    			}

		    			inputStream.close();
		    			outStream.close();
		                response.getOutputStream().flush();
		            }
		            catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
			} catch (Exception e) {
				e.printStackTrace();
			}
			 	
		   
		}
		
		@RequestMapping(value = "/export_contractor", method = RequestMethod.GET)
		public void export_contractor(
				Model model,
				HttpServletResponse response)
		{
			try {
				File dwnfile=exportcon.buildExcelFile();
				if(dwnfile.exists())
				{
					response.setContentType("application/octet-stream");
		            response.addHeader("Content-Disposition", "attachment; filename="+dwnfile.getName());
		            response.setContentLength((int) dwnfile.length());
				}
				 try
		            {
		            	/**** Get The Output Stream Of The Response ****/
		    			OutputStream outStream = response.getOutputStream();
		    			FileInputStream inputStream = new FileInputStream(dwnfile);
		    			byte[] buffer = new byte[4096];
		    			int bytesRead = -1;

		    			/**** Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data  Read From The Input Stream Into The Output Stream ****/
		    			while ((bytesRead = inputStream.read(buffer)) != -1) {
		    				outStream.write(buffer, 0, bytesRead);
		    			}

		    			inputStream.close();
		    			outStream.close();
		                response.getOutputStream().flush();
		            }
		            catch (IOException ex) {
		                ex.printStackTrace();
		            }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		 @RequestMapping(value = "/monthly_salary_all", method = RequestMethod.GET)
			public String monthly_salary_all(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) {
				Integer halfDay=0;
				Integer fullDay=0;
				Integer halfDaysalary=0;
				Integer halfSalary=0;
				Integer fullSalary=0;
				Integer salary=0;
				Integer salary_addtion=0;
				Integer total_salary_addtion=0;
				
				
				Timestamp timestamp= new Timestamp(System.currentTimeMillis());
				LabourCheck labourCheck=new LabourCheck();
				LocalDate localDate = LocalDate.now();
						
				Integer salary_not_null=0;
				Labour labour_salary=new Labour();
				List<Labour> labour_list=labourService.getLabour_list();
				for(Labour total_salary_list:labour_list) {
					
					
				/*	String Lab_id_=request.getParameter("lab_id").trim();*/
					Integer Lab_id=total_salary_list.getLab_id();
					
					List<LabourCheck> labourcheck=labourService.getLabListById(Lab_id);
					for(LabourCheck lab:labourcheck) {
						Integer shift=lab.getShift_time().getShift_id();
						
							if(shift!=null) {
							
							Timestamp check_in_=(Timestamp)lab.getCheck_in();
							Timestamp check_out=(Timestamp)lab.getCheck_out();
							float diff = check_out.getTime() - check_in_.getTime() ;
							float diffHours = diff / (60 * 60 * 1000) % 24;
							/*Integer diffTimes = (int) (long) diffHours;*/
							if(shift!=3) {
							if(diffHours>=8.5 && diffHours<=8.75) {
								lab.setStatus(1);
								 fullSalary=300;
								lab.setSalary(fullSalary);
							}
							else if(diffHours>=4.5 && diffHours<8.5 ) {
								lab.setStatus(0);
								 halfDaysalary=300/2;
								 lab.setSalary(halfDaysalary);
							}
							else {
								lab.setStatus(2);
								lab.setSalary(0);
							}
							}else {
								lab.setStatus(1);
								 fullSalary=300;
								lab.setSalary(fullSalary);
							}
							labourService.updateLabourCheck(lab);
						}
							 halfDay=labourService.getTotalHalfDay(Lab_id);
							 fullDay=labourService.getTotalfullDay(Lab_id);
							
							 halfDaysalary=300/2;
							 halfSalary=halfDay * halfDaysalary;
							 fullSalary=fullDay *300;
							
							/* salary= fullSalary + halfSalary;*/
							
						/*	lab.setSalary(salary);*/
							/*labourService.updateLabourCheck(lab);*/
					}
					
					List<LabourCheck> labourcheck_salary=labourService.getLabListById(Lab_id);
					for(LabourCheck salary_add:labourcheck_salary) {
						System.out.println(salary_add);
						
						salary_addtion= salary_add.getSalary();
						total_salary_addtion +=salary_addtion;
						System.out.println(total_salary_addtion);
						}
					
					labour_salary=labourService.getLabourById(Lab_id.toString());
					labour_salary.setLab_salary(total_salary_addtion);
					labourService.updateLabour(labour_salary);
					total_salary_addtion=0;
				}
				
					return "redirect:mng_attendance";
				
			}
		 
		 
		 @RequestMapping(value = "/new_feedback", method = RequestMethod.GET)
			public String new_waste(Locale locale, Model model, HttpServletRequest request) {
		
				VMS_Feedback feedback = new VMS_Feedback();
		
				model.addAttribute("feedback", feedback);
				model.addAttribute("opr_mode", "save");
				model.addAttribute("url", request.getRequestURI());
				return "vms/feedback_reporting";
			}
		
			
			
	/*
	 * @CrossOrigin(origins="http://localhost:4200")
	 * 
	 * @RequestMapping(value = "/mng_waste_list", method = RequestMethod.GET) public
	 * String manageEvent(Locale locale, Model model, HttpServletRequest request,
	 * HttpServletResponse response) throws IOException { List<VMS_Feedback>
	 * feedback_list=new ArrayList<VMS_Feedback>();
	 * feedback_list=vmsService.getFeedback_list1();
	 * 
	 * 
	 * PrintWriter out = response.getWriter();
	 * response.setContentType("application/json");
	 * response.setCharacterEncoding("UTF-8"); Gson json = new Gson(); String
	 * Json=null; if(feedback_list.size()>0) { Json=json.toJson(feedback_list);
	 * out.print(Json); } model.addAttribute("Json", Json);
	 * model.addAttribute("helper", helper);
	 * model.addAttribute("vmsService",vmsService); model.addAttribute("url",
	 * request.getRequestURI()); return "ehs/mng__list"; }
	 */
			 
			 
  
			@CrossOrigin(origins="http://localhost:4201")
			@RequestMapping(value = "/save_feedback", method = RequestMethod.POST)
			public void save_feedback(
					@ModelAttribute("data") @Valid VMS_Feedback feedback, 
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
		    	
		          String emp_name = jsonObj.getString("emp_name");
		    	  feedback.setEmp_name(emp_name);
		    	  
		    	  String overall_experience_1 = jsonObj.getString("overall_experience_1"); 
		    	  int overall_experience =Integer.parseInt(overall_experience_1); 
		    	  String overall_experience_2 =jsonObj.getString("overall_experience_2");
		    	  String overall_experience_3 =jsonObj.getString("overall_experience_3");
		    	  String overall_experience_4 =jsonObj.getString("overall_experience_4");
 				  if(overall_experience == 1) 
 				  {
 					feedback.setOverall_experience(overall_experience_1);
 					  } 
 				   else if(overall_experience == 2) {
 						feedback.setOverall_experience(overall_experience_2);
 				  }
 				  else if(overall_experience == 3) {
						feedback.setOverall_experience(overall_experience_3);
				  }
 				  else {
						feedback.setOverall_experience(overall_experience_4);
				  }
 				  
 				 String timely_response_1 = jsonObj.getString("timely_response_1"); 
		    	  int timely_response  =Integer.parseInt(timely_response_1); 
		    	  String timely_response_2 =jsonObj.getString("timely_response_2");
		    	  String timely_response_3 =jsonObj.getString("timely_response_3");
		    	  String timely_response_4 =jsonObj.getString("timely_response_4");
				  if(timely_response == 1) 
				  {
					feedback.setTimely_response(timely_response_1);
					  } 
				   else if(timely_response == 2) {
					   feedback.setTimely_response(timely_response_2);
				  }
				  else if(timely_response == 3){
					  feedback.setTimely_response(timely_response_3);
				  }
				  else {
					  feedback.setTimely_response(timely_response_4);
				  }
				  
				  String support_1 = jsonObj.getString("support_1"); 
		    	  int support  =Integer.parseInt(support_1); 
		    	  String support_2 =jsonObj.getString("support_2");
		    	  String support_3 =jsonObj.getString("support_3");
		    	  String support_4 =jsonObj.getString("support_4");
				  if(support == 1) 
				  {
					feedback.setSupport(support_1);
					  } 
				   else if(support == 2) {
						feedback.setSupport(support_2);
				  }
				  else if(support == 3) {
						feedback.setSupport(support_3);
				  }
				  else {
						feedback.setSupport(support_4);
				  }
				  
				  String sastisfaction_1 = jsonObj.getString("sastisfaction_1"); 
		    	  int sastisfaction   =Integer.parseInt(sastisfaction_1); 
		    	  String sastisfaction_2 =jsonObj.getString("sastisfaction_2");
		    	  String sastisfaction_3 =jsonObj.getString("sastisfaction_3");
		    	  String sastisfaction_4 =jsonObj.getString("sastisfaction_4");
				  if(sastisfaction == 1) 
				  {
					feedback.setSastisfaction(sastisfaction_1);
					  } 
				   else if(sastisfaction  == 2) {
						feedback.setSastisfaction(sastisfaction_2);
				  }
				  else if(sastisfaction  == 3) {
						feedback.setSastisfaction(sastisfaction_3);
				  }
				  else {
						feedback.setSastisfaction(sastisfaction_4);
				  }
				/*
				 * String quantity = jsonObj.getString("quantity"); waste.setQuantity(quantity);
			 * 
				 * String waste_desc = jsonObj.getString("waste_desc");
				 * waste.setWaste_desc(waste_desc);
				 * 
				 * String waste_department = jsonObj.getString("waste_department");
				 * waste.setWaste_department(waste_department);
				 */
		    	  
		    	/*  String disposal_date = jsonObj.getString("disposal_date");
	     	  int date = Integer.parseInt(disposal_date);
		    	  waste.setDisposal_date(disposal_date);*/
		    	  
				/*
				 * String techniques = jsonObj.getString("techniques");
				 * waste.setTechniques(techniques);
				 * 
				 * String generation_1 = jsonObj.getString("generation_1"); int generation =
				 * Integer.parseInt(generation_1); String generation_2 =
				 * jsonObj.getString("generation_2");
				 * 
				 * if(generation == 1) { waste.setGeneration(generation_1); } else {
				 * waste.setGeneration(generation_2); }
				 * 
				 * String collection_1 = jsonObj.getString("collection_1"); int collection =
				 * Integer.parseInt(generation_1); String collection_2 =
				 * jsonObj.getString("collection_1");
				 * 
				 * if(collection == 1) { waste.setCollection(collection_1); } else {
				 * waste.setCollection(collection_2); }
				 * 
				 * String storage_1 = jsonObj.getString("storage_1"); int storage =
				 * Integer.parseInt(storage_1); String storage_2 =
				 * jsonObj.getString("storage_2");
				 * 
				 * if(storage == 1) { waste.setStorage(storage_1); } else {
				 * waste.setStorage(storage_2); }
				 * 
				 * String transportation_1 = jsonObj.getString("transportation_1"); int
				 * transportation = Integer.parseInt(transportation_1); String transportation_2=
				 * jsonObj.getString("transportation_2");
				 * 
				 * if(transportation == 1) { waste.setTransportation(transportation_1); } else {
				 * waste.setTransportation(transportation_2); }
				 */
		    	  
		      /*    String shipment_date = jsonObj.getString("shipment_date");
		    	  shipping.setShipment_date(shipment_date);*/
					
		    	  feedback.setFeedback_active(1);
		    	
		        String suc_msg="";
			    String err_msg="";
			
				if (result.hasErrors()) {
					json.put("status", 0);
					json.put("error", helper.getErrors(result));
					response.getWriter().write(json.toString());
					return;
					
			   	}
					boolean flag=labourService.saveFeedback(feedback);
					if(flag) {
						suc_msg="feedback created Successfully..!";
						json.put("status", 1);
					}
			
					else {
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
			
			
		


@CrossOrigin(origins="http://localhost:4201")
  
  @RequestMapping(value = "/mng_feedback", method = RequestMethod.GET) public
 String mng_feedback(Locale locale, Model model, HttpServletRequest request,
  HttpServletResponse response) throws IOException { 
	List<VMS_Feedback> feedback_list=new ArrayList<VMS_Feedback>();
  feedback_list=labourService.getFeedback_list1();
  
  
  PrintWriter out = response.getWriter();
  response.setContentType("application/json");
  response.setCharacterEncoding("UTF-8");
  Gson json = new Gson(); String
  Json=null; 
  if(feedback_list.size()>0) 
  { 
	  Json=json.toJson(feedback_list);
  out.print(Json);
  } 
  model.addAttribute("Json", Json);
  model.addAttribute("helper", helper);
  model.addAttribute("labourService",labourService); 
  model.addAttribute("url",
 request.getRequestURI()); 
  return "ehs/mng_feedback";
 }


		/*@CrossOrigin(origins="http://localhost:4200")
		@RequestMapping(value = "/mng_product", method = RequestMethod.GET)  
		public String mng_product(Locale locale, Model model,	HttpServletRequest request, 
		HttpServletResponse response) throws IOException {
		List<Product> product_list=new ArrayList<Product>();
		product_list=labourService.getProduct_list();


        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson json = new Gson();
        String Json=null;
        if(product_list.size()>0) {
        	  Json=json.toJson(product_list);
        	 out.print(Json);
        }
        model.addAttribute("Json", Json);
		model.addAttribute("helper", helper);
		model.addAttribute("labourService", labourService);
		model.addAttribute("url", request.getRequestURI());
		return "labour/mng_product";
	}

@RequestMapping(value = "/new_product", method = RequestMethod.GET)
public String new_product(Locale locale, Model model) {
	
	Product product=new Product();
	
	model.addAttribute("product", product);
	model.addAttribute("helper", helper);
	model.addAttribute("opr_mode", "save");
	return "labour/add_product";
}

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/save_product", method = RequestMethod.POST)
public void save_product(
		@ModelAttribute("data") @Valid Product product, 
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
	
		
		 String product_name = jsonObj.getString("product_name");
		 product.setProduct_name(product_name);
		
	 
		
		  String product_quantity = jsonObj.getString("product_quantity");
		  product.setProduct_quantity(product_quantity);
		 
	  
		
		  String bill_material = jsonObj.getString("bill_material");
		  product.setBill_material(bill_material);
		 
	  
		
		  String manufa_order = jsonObj.getString("manufa_order");
		  product.setManufa_order(manufa_order);
		
		  String prod_type = jsonObj.getString("prod_type");
		  product.setProd_type(prod_type);
		  
		 String sales_price = jsonObj.getString("sales_price");
		  product.setSales_price(sales_price);
		  
		  String reference = jsonObj.getString("reference");
		  product.setReference(reference);
		  
		  String cost = jsonObj.getString("cost"); product.setCost(cost);
		  
		  String barcode = jsonObj.getString("barcode"); product.setBarcode(barcode);
		  
		  String prod_category = jsonObj.getString("prod_category");
		  product.setProd_category(prod_category);
		  
		  String notes = jsonObj.getString("notes");
		  product.setNotes(notes);
		 
	
	
	  
	 Ehs_Waste_Transport transport=new  Ehs_Waste_Transport();
	  String veh_name = jsonObj.getString("veh_name");
	  System.out.println(veh_name);
	  transport.setVeh_name(veh_name);
	
	  String veh_number = jsonObj.getString("veh_number");
	  transport.setVeh_number(veh_number);
	  
	  String material_qty = jsonObj.getString("material_qty");
	  transport.setMaterial_qty(material_qty);
	  
 	  String dis_name = jsonObj.getString("dis_name");
	  transport.setDis_name(dis_name);
	  

		
	  product.setPro_active(1);
	
    String suc_msg="";
	String err_msg="";

	if (result.hasErrors()) {
		json.put("status", 0);
		json.put("error", helper.getErrors(result));
		response.getWriter().write(json.toString());
		return;
		
   	}
		boolean flag=labourService.saveProduct(product);
		if(flag) {
			suc_msg="Product created Successfully..!";
			json.put("status", 1);
		}

		else {
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
	
}*/
		

		
		@CrossOrigin(origins="http://localhost:4200")
		@RequestMapping(value = "/mng_prerequisite", method = RequestMethod.GET  )
		public String mng_prerequisite(Locale locale, Model model,	HttpServletRequest request, 
		HttpServletResponse response) throws IOException {
			
		List<HrRequirement> hrrequirement_list=new ArrayList<HrRequirement>();
		hrrequirement_list=labourService.getHrRequirement_list();


		        PrintWriter out = response.getWriter();
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        Gson json = new Gson();
		        String Json=null;
		        if(hrrequirement_list.size()>0) {
		        	  Json=json.toJson(hrrequirement_list);
		        	 out.print(Json);
		        }
		        model.addAttribute("Json", Json);
		        model.addAttribute("helper", helper);
		        model.addAttribute("labourService", labourService);
		        model.addAttribute("url", request.getRequestURI());
		        return "labour/mng_prerequisite";
		}
		 @CrossOrigin(origins = "http://localhost:4200")
		 @RequestMapping(value = "/save_prerequisite", method = RequestMethod.POST)
		 public void save_prerequisite(

		 @ModelAttribute("data") @Valid HrRequirement hrrequirement, BindingResult result, ModelMap model,
		 HttpServletRequest request, HttpServletResponse response, RedirectAttributes flashdata) throws IOException {

			 Date dat=new Date(new java.util.Date().getTime());
			 hrrequirement.setHr_created_date(dat);
			 
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 json = new JSONObject();

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
		 
		 String dept = jsonObj.getString("department_dept_id");
		 Department_type deptObj = helper.getDeptByName(dept);
		 hrrequirement.setDepartment_type(deptObj);

		 String shift = jsonObj.getString("shift_id");
		 ShiftTime shiftObj = helper.getShiftByName(shift);
		 hrrequirement.setShift_time(shiftObj);
		
		 
		 String required = jsonObj.getString("labour_required");
		 hrrequirement.setLabour_required(required);
		 
		 
	
		 hrrequirement.setHr_active(1);

		 String suc_msg = "";
		 String err_msg = "";

		 if (result.hasErrors()) {
		 json.put("status", 0);
		 json.put("error", helper.getErrors(result));
		 response.getWriter().write(json.toString());
		 return;

		 }
		 boolean flag = labourService.saveHrRequirement(hrrequirement);

		 if (flag) {
		 suc_msg = "Labour check created Successfully..!";
		 json.put("status", 1);
		 }

		 else {
		 json.put("error", 0);
		 err_msg = "Can't saved...something went wrong..!";
		 }

		 model.addAttribute("err_msg", err_msg);
		 json.put("success", suc_msg);
		 json.put("error", err_msg);

		 flashdata.addFlashAttribute("suc_msg", suc_msg);
		 flashdata.addFlashAttribute("err_msg", err_msg);
		 response.getWriter().write(json.toString());
		 return;

		 }
		 
		 
		 @CrossOrigin(origins = "http://localhost:4200")
				 @RequestMapping(value = "/dept_name", method = RequestMethod.GET)
				 public void dept_name(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response)
				 throws IOException {
				 List<Department_type> dept = new ArrayList<Department_type>();
				 dept = labourService.getDept_name();

				 PrintWriter out = response.getWriter();
				 response.setContentType("application/json");
				 response.setCharacterEncoding("UTF-8");
				 Gson json = new Gson();
				 String Json = null;
				 if (dept.size() > 0) {
				 Json = json.toJson(dept);
				 out.print(Json);
				 }

				 model.addAttribute("Json", Json);
				 model.addAttribute("helper", helper);
				 model.addAttribute("labourService", labourService);
				 model.addAttribute("url", request.getRequestURI());

				 }
		 
		 @CrossOrigin(origins = "http://localhost:4200")

				 @RequestMapping(value = "/shift", method = RequestMethod.GET)
				 public void shift(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response)
				 throws IOException {
				 List<ShiftTime> shift = new ArrayList<ShiftTime>();
				 shift = labourService.getShift();

				 PrintWriter out = response.getWriter();
				 response.setContentType("application/json");
				 response.setCharacterEncoding("UTF-8");
				 Gson json = new Gson();
				 String Json = null;
				 if (shift.size() > 0) {
				 Json = json.toJson(shift);
				 out.print(Json);
				 }
				 model.addAttribute("Json", Json);
				 model.addAttribute("helper", helper);
				 model.addAttribute("labourService", labourService);
				 model.addAttribute("url", request.getRequestURI());

				 }

		 @CrossOrigin(origins = "http://localhost:4200")
				 @RequestMapping(value = "/view_con_labour", method = RequestMethod.GET)
				 public String view_con_labour(ModelMap model, HttpServletRequest request, HttpServletResponse response)
				 throws IOException {

				 
			 if (request.getParameter("cd_id")==null) {
					return "redirect:/error_404";
				}
				  

				 String id = request.getParameter("cd_id");
				 System.out.println(id);
				 Contractor contractor = new Contractor();
				 contractor = labourService.getContractorById(id);

				 PrintWriter out = response.getWriter();
				 response.setContentType("application/json");
				 response.setCharacterEncoding("UTF-8");
				 Gson json = new Gson();
				 String Json = null;

				 Json = json.toJson(contractor);
				 out.print(Json);

				 model.addAttribute("Json", Json);
//				 	 return "ehs/view_hira";
//				 	 String id = request.getParameter("cd_id".trim());
				 //	
				 //
//				 	 Contractor contract = labourService.getContractorById(id);
				 //	
				 //	
//				 	 model.addAttribute("contract", contract);
//				 	 model.addAttribute("helper", helper);
//				 	 model.addAttribute("labourService", labourService);

				 return "labour/view_con_labour";

				 }
		
}	 

