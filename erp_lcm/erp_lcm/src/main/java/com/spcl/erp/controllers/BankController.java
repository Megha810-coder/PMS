package com.spcl.erp.controllers;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Date;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Account;
import com.spcl.erp.model.Bank;
import com.spcl.erp.services.BankService;

@Controller
@RequestMapping(value = "/bank")
public class BankController {

	
	@Autowired
	private BankService bankService;
	
	private JSONObject json = null;
	
	@Autowired
	private Helper helper;
	

	public void setBankService(BankService bankService) {
		this.bankService = bankService;
	}

	@RequestMapping(value = "/mng_bank")
	public String manageBank(Locale locale, 
			Model model,
			HttpServletRequest request) 
	{
		
		List<Bank> bankList=new ArrayList<Bank>();
		Map<String, String> search_field=null;
		
		String search_bank= request.getParameter("search_bank");
		
		if (search_bank!=null&&search_bank.equals("true")) {
			
			search_field=new HashMap<String, String>();
			
			String bank_name=request.getParameter("bnk_name");
			search_field.put("bnk_name", bank_name);
			
			String bank_code=request.getParameter("bnk_id_code");
			search_field.put("bnk_id_code", bank_code);
		}
				
		bankList=bankService.getBankList(search_field);
		
		model.addAttribute("bank_list", bankList);
		model.addAttribute("search_field", search_field);
		model.addAttribute("helper", helper);
		model.addAttribute("BankService", bankService);
		model.addAttribute("url", request.getRequestURI());
		return "bank/bank_list";
	}
	
	
	@RequestMapping(value = "/new_bank", method = RequestMethod.GET)
	public String new_bank(Locale locale, Model model,HttpServletRequest request) {

		Bank bank=new Bank();
		model.addAttribute("bank",bank);
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "bank/add_bank";
	}
	
	
	@RequestMapping(value = "/save_bank", method = RequestMethod.POST)
	public void save_bank(
			@ModelAttribute("bank") @Valid Bank bank, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flasdatat
		) throws IOException {
		
		Date dat=new Date(new java.util.Date().getTime());
		
		
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
		bank.setBnk_active(1);
		if (opr_mode.equals("save")) {
			
			bank.setBnk_create_date(dat);
			boolean flag=bankService.saveBank(bank);
			if(flag) {
				suc_msg="Bank details created Successfully..!";
				json.put("status", 1);
			}else {
				json.put("error", 0);
				err_msg="Can't saved...something went wrong..!";
			}
				
		}else if (opr_mode.equals("update")){
			bank.setBnk_update_date(dat);
			boolean flag=bankService.updateBank(bank);
			if(flag) {
				suc_msg="Bank details updated Successfully..!";
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
	
	
	
	@RequestMapping(value = "/edit_bank", method = RequestMethod.GET)
	public String edit_bank(	
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
		) {
		
		String id=request.getParameter("bnk_id").trim();
		Bank bank=new Bank();
		bank=bankService.getBankById(id);
		
		model.addAttribute("bank", bank);
		model.addAttribute("opr_mode", "update");
		//model.addAttribute("helper", helper);
		return "bank/add_bank";
	}
	
	@RequestMapping(value = "/view_bank", method = RequestMethod.GET)
	public String view_bank(	
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
		) {
		
		String id=request.getParameter("bnk_id").trim();
		Bank bank=new Bank();
		bank=bankService.getBankById(id);
		
		model.addAttribute("bank", bank);
		model.addAttribute("opr_mode", "view");
		//model.addAttribute("helper", helper);
		return "bank/add_bank";
	}
	
	@RequestMapping(value = "/search_bank", method = RequestMethod.GET)
	public String search_bank(	
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
		) {
		
		String search =request.getParameter("filter");
		Bank bank=new Bank();
		bank=bankService.getBankById(search);
		
		model.addAttribute("bank", bank);
		model.addAttribute("opr_mode", "search");
		return "bank/add_bank";
	}
	
	@RequestMapping(value = "/delete_bank", method = RequestMethod.GET)
    public void delete_bank(
    		HttpServletRequest request,
    		HttpServletResponse response
    	) {
		String msg="false";
		String id=request.getParameter("bnk_id").trim();
		if(bankService.deleteBank(id)) {
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
	
	@RequestMapping(value = "/mng_account", method = RequestMethod.GET)
	public String manageaccount(Locale locale, Model model,HttpServletRequest request) {
		
		List<Account> accountList=new ArrayList<Account>();
		accountList=bankService.getAccountList();
		
		model.addAttribute("account_list", accountList);
		
		model.addAttribute("helper", helper);
		model.addAttribute("BankService", bankService);
		model.addAttribute("resp_page", "account/account_list");
		model.addAttribute("url", request.getRequestURI());
		return "bank/account_list";
	}
	
	@RequestMapping(value = "/new_account", method = RequestMethod.GET)
	public String new_account(Locale locale, Model model,HttpServletRequest request) {

		Account account=new Account();
		model.addAttribute("account",account);
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "bank/add_account";
	}
	
	@RequestMapping(value = "/save_account", method = RequestMethod.POST)
	public void save_account(
			@ModelAttribute("account") @Valid Account account, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flasdatat
		) throws IOException {
		
		Date dat=new Date(new java.util.Date().getTime());
		
		
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
		account.setBank(bankService.getBankById(account.getBank().getBnk_id().toString()));
		account.setAcc_active(1);
		if (opr_mode.equals("save")) {
			
			account.setAcc_create_date(dat);
			boolean flag=bankService.saveAccount(account);
			if(flag) {
				suc_msg="Bank account details created Successfully..!";
				json.put("status", 1);
			}else {
				json.put("error", 0);
				err_msg="Can't saved...something went wrong..!";
			}
				
		}else if (opr_mode.equals("update")){
			account.setAcc_update_date(dat);
			boolean flag=bankService.updateAccount(account);
			if(flag) {
				suc_msg="Bank account details updated Successfully..!";
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
	
	@RequestMapping(value = "/edit_account", method = RequestMethod.GET)
	public String edit_account(	
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
		) {
		
		String id=request.getParameter("acc_id").trim();
		Account account=new Account();
		account=bankService.getAccountById(id);
		
		model.addAttribute("account", account);
		model.addAttribute("opr_mode", "update");
		//model.addAttribute("helper", helper);
		return "bank/add_account";
	}
	
	@RequestMapping(value = "/view_account", method = RequestMethod.GET)
	public String view_account(	
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response
		) {
		
		String id=request.getParameter("acc_id").trim();
		Account account=new Account();
		account=bankService.getAccountById(id);
		
		model.addAttribute("account", account);
		model.addAttribute("opr_mode", "view");
		//model.addAttribute("helper", helper);
		return "bank/add_account";
	}
	
	@RequestMapping(value = "/delete_account", method = RequestMethod.GET)
    public void delete_account(
    		HttpServletRequest request,
    		HttpServletResponse response
    	) {
		String msg="false";
		String id=request.getParameter("acc_id").trim();
		if (bankService.deleteAccount(id)) {
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
