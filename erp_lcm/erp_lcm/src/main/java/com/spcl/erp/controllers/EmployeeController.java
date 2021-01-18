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
import com.spcl.erp.model.Employee_Education;
import com.spcl.erp.model.Employee_Work;
import com.spcl.erp.model.Address;
import com.spcl.erp.model.Employee;
import com.spcl.erp.model.Employee_Document;
import com.spcl.erp.services.EmployeeService;
@Controller
@RequestMapping(value = "/employee")

public class EmployeeController {

	JSONObject json = new JSONObject();
	private static SecureRandom random = new SecureRandom();
	@Autowired
	private Helper helper;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/mng_employee", method = RequestMethod.GET)
	public String manageEvent(Locale locale, Model model,HttpServletRequest request) {
		
		List<Employee> employee_list=new ArrayList<Employee>();
		employee_list=employeeService.getEmployee_list();
		
		model.addAttribute("employee_list", employee_list);
		model.addAttribute("helper", helper);
		model.addAttribute("employeeService", employeeService);
		model.addAttribute("url", request.getRequestURI());
		return "employee/employee_list";
	}
	@RequestMapping(value = "/new_employee_details", method = RequestMethod.GET)
	public String new_employee(Locale locale, Model model) {
		
		Employee employee=new Employee();
		employee.setEmp_code(helper.getEmployeeCode());
		model.addAttribute("employee", employee);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "employee/add_employee_details";
	}
	@RequestMapping(value = "/save_employee_details", method = RequestMethod.POST)
	public void save_customer(
			@ModelAttribute("Employee_type") @Valid Employee employee, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flashdata,
			@RequestParam("emp_profile_photo") MultipartFile file
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
		
		if(file!=null&&!file.isEmpty()) {
   			try {
				String img_code=new BigInteger(30, random).toString(32).toUpperCase()+".png";
				byte[] bytes = file.getBytes();
				// Creating the directory to store file

				File dir = new File(Helper.EMPLOYEE_IMG_PATH);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
   					+ File.separator + img_code) ;
				BufferedOutputStream stream = new BufferedOutputStream(
   					new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				employee.setEmp_img_code(img_code);

   			} 
   			catch (Exception e) {
   				json.put("status", 0);
   				json.put("error", "You failed to upload " +  employee.getEmp_img_code() + " => " + e.getMessage());
   			}
   				
		}
		
		Date dat=new Date(new java.util.Date().getTime());
		String opr_mode=request.getParameter("opr_mode").trim();
		for (Employee_Education education : employee.getEducation_list()) {
			education.setEmployee(employee);
		}
		
		if (employee.getContacts()!=null) {
			employee.getContacts().setEmployee_contact(employee);
			if (!employee.getContacts().getAddress_list().isEmpty()) {
				for (Address adds : employee.getContacts().getAddress_list()) {
					adds.setEmp_contact(employee.getContacts());
				}
			}
		}
		
		if (employee.getAccount()!=null) {
			employee.getAccount().setEmployee(employee);
		}
		if (employee.getWork_list()!=null) {
			for (Employee_Work work : employee.getWork_list()) {
				work.setEmployee(employee);
			}
			
		}
			/*String emp_company_id=request.getParameter("emp_company_id");
			Employee_Company company=helper.getCompanyById(emp_company_id);*/
			if(employee.getCompany()!=null);
			{
				employee.getCompany().setEmployee_company(employee);
			}
			for (Employee_Education education : employee.getEducation_list()) {
				education.setEmployee(employee);
			}
			
			 if (employee.getDocument_list()!=null) {
				 for (Employee_Document document : employee.getDocument_list()) {
				 document.setEmployee(employee);
				 }
				 }
				  
		/*
		 * if (employee.getPosition_list()!=null) { for (Employee_position position :
		 * employee.getPosition_list()) { position.setEmployee(employee); } } (10:35:25
		 * AM) for (Employee_document document : employee.getDocument_list()) {
		 * if(doc!=null&&!doc.isEmpty()) { try { String img_code=new BigInteger(30,
		 * random).toString(32).toUpperCase()+".docx"; byte[] bytes = doc.getBytes(); //
		 * Creating the directory to store file
		 * 
		 * File dir = new File(Helper.EMPLOYEE_DOC_PATH); if (!dir.exists())
		 * dir.mkdirs();
		 * 
		 * // Create the file on server File serverFile = new File(dir.getAbsolutePath()
		 * + File.separator + img_code) ; BufferedOutputStream stream = new
		 * BufferedOutputStream( new FileOutputStream(serverFile)); stream.write(bytes);
		 * stream.close(); document.setEmp_doc1(img_code);
		 * 
		 * } catch (Exception e) { json.put("status", 0); json.put("error",
		 * "You failed to upload " + document.getEmp_doc1() + " => " + e.getMessage());
		 * }
		 * 
		 * } }
		 * 
		 */		if (opr_mode.equals("save")) {
			employee.setEmp_created_date(dat);
			
			boolean flag=employeeService.saveEmployee(employee);
			if(flag) {
				suc_msg="employee created Successfully..!";
				json.put("status", 1);
			}else {
				json.put("error", 0);
				err_msg="Can't saved...something went wrong..!";
			}
		}
		else if (opr_mode.equals("update")){
		
			employee.setEmp_updated_date(dat);
			
			boolean flag=employeeService.updateEmployee(employee);
			if(flag) {
				suc_msg="employee details updated Successfully..!";
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
		response.getWriter().write(json.toString());
		return;
		
    }
	
	@RequestMapping(value = "/edit_employee", method = RequestMethod.GET)
	public String edit_employee(
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
	) {
		
		if (request.getParameter("emp_id")==null) {
			return "redirect:/error_404";
		}
		String id=request.getParameter("emp_id").trim();
		Employee employee=new Employee();
		employee=employeeService.getEmployeeById(id);
		String emp_dob=Helper.DATEFORMAT.format(employee.getEmp_dob());
		
		model.addAttribute("emp_dob", emp_dob);
		model.addAttribute("employee", employee);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "update");
		return "employee/add_employee_details";
	}
	
	@RequestMapping(value = "/view_employee", method = RequestMethod.GET)
	public String view_employee(
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
	) {
		
		if (request.getParameter("emp_id")==null) {
			return "redirect:/error_404";
		}
		String id=request.getParameter("emp_id").trim();
		Employee employee=new Employee();
		employee=employeeService.getEmployeeById(id);
		String emp_dob=Helper.DATEFORMAT.format(employee.getEmp_dob());
		
		model.addAttribute("emp_dob", emp_dob);
		model.addAttribute("employee", employee);
		model.addAttribute("employeeService", employeeService);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "view");
		return "employee/add_employee_details";
	}
	
	
	
}
