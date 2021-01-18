package com.spcl.erp.controllers;

import java.io.IOException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Transfer;
import com.spcl.erp.model.Transfer_Product;
import com.spcl.erp.services.TransferService;




@Controller
@RequestMapping(value = "/transfer")
public class TransferController {
	
	JSONObject json = null; 
	
	@Autowired
	private Helper helper;
	
	@Autowired
	private TransferService transferService;
	
	@RequestMapping(value = "/invent_transfer", method = RequestMethod.GET)
	public String transfer(Locale locale, Model model,HttpServletRequest request) {
		
		List<Transfer> transferList=new ArrayList<Transfer>();
		transferList=transferService.getTransferList();
		
		model.addAttribute("TRANSFERLIST", transferList);
		model.addAttribute("transferService", transferService);
		model.addAttribute("resp_page", "transfer/tarnsfer_list");
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("helper", helper);
	
		/*if(mark_mode==null || mark_mode.equals("mark_ready")) {
			transfer.setTra_lable(3);
			transferService.updateTransfer(transfer);
			model.addAttribute("mark_mode","validate");
			if(mark_mode!=null && mark_mode.equals("validate")) {
				transfer.setTra_lable(4);
				transferService.updateTransfer(transfer);
				
			}
			
		}*/
		return "transfer/tarnsfer_list";
	}
	
	@RequestMapping(value = "/create_transfer", method = RequestMethod.GET)
	public String newTransfer(Locale locale, Model model) {
		
		Transfer transfer=new Transfer();
		model.addAttribute("transfer", transfer);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "transfer/add_transfer";
	}
	
	@RequestMapping(value = "/save_transfer", method = RequestMethod.POST)
	public void saveTransfer(
			@ModelAttribute("transfer") @Valid Transfer transfer, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request,
			RedirectAttributes flasdatat,
			HttpServletResponse response) throws IOException {
		
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
		
		
		
		String del_pro_ids="";
		List<Transfer_Product> trp_list =transfer.getTrp_list();
		if(null != trp_list && trp_list.size() > 0) {
			List<Transfer_Product> trp_list_from_db =helper.getTrpListformDB(transfer.getTra_id());
			
			for (Transfer_Product trp : trp_list) {
				trp.setTransfer(transfer);
			}
			
			for(Transfer_Product trp_db:trp_list_from_db) {
				boolean is_delete=true;
				for (Transfer_Product trp : trp_list) {
					if (null!=trp.getTrp_id()&&trp_db.getTrp_id().intValue()==trp.getTrp_id().intValue()){
						is_delete=false;
						break;
					}
					if (null==trp.getTrp_product_id()) {
						trp_list.remove(trp);
					}
				}
				if (is_delete) {
					del_pro_ids+=trp_db.getTrp_id().toString()+",";
				}
				
			}
		}else {
			json.put("status", 0);
			json.put("error", " Transfer document require minimum one product in list.");
			response.getWriter().write(json.toString());
			return;
		}
		
		Date dat=new Date(new java.util.Date().getTime());
		Transfer_Product transfer_product=new Transfer_Product();
		transfer.setTra_active(1);	
		transfer.setTra_lable(Helper.TRA_DRAFT);
		transfer.setTrp_list(trp_list);
		String opr_mode=request.getParameter("opr_mode".trim());
		if (opr_mode.equals("save")) {
			
			transfer_product.setTrp_done(0);
			transfer.setTra_create_date(dat);	
			boolean flag=transferService.saveTransfer(transfer);
			if(flag) {
				suc_msg="Transfer created Successfully..!";
				json.put("status", 1);
				json.put("tra_id", transfer.getTra_id().intValue());
			}else {
				json.put("error", 0);
				err_msg="Can't saved...something went wrong..!";
			}
			
		}else if (opr_mode.equals("update")){
			transfer.setTra_update_date(dat);
			String id=request.getParameter("tra_id").trim();
			
			Transfer db_transfer=transferService.getTransferById(id);
			if(db_transfer.getTra_lable()==3) {
				transfer.setTra_lable(Helper.TRA_DONE);
			}
			
			boolean flag=transferService.updateTransfer(transfer);
				if(!del_pro_ids.equals("")) {
					del_pro_ids=del_pro_ids.substring(0, del_pro_ids.length()-1);
					flag=transferService.deleteTransferproducts(del_pro_ids);
				}
			if(flag) {
				suc_msg="transfer Updated Successfully..!";
				json.put("status", 1);
				json.put("tra_id", transfer.getTra_id().intValue());
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
	
	@RequestMapping(value = "/mark_ready", method = RequestMethod.GET)
    public void markReadyEvent(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
		response.setCharacterEncoding("UTF-8");
			json=new JSONObject();
			String suc_msg="";
			String err_msg="";
			
		String id=request.getParameter("tra_id").trim();
		Transfer transfer=new Transfer();
		transfer=transferService.getTransferById(id);
		transfer.setTra_lable(Helper.TRA_READY);
		boolean flag=transferService.updateTransfer(transfer);
		
		if(flag) {
			suc_msg="transfer Updated Successfully..!";
			json.put("status", 1);
			
		}else {
			json.put("error", 0);
			err_msg="Can't update...something went wrong..!";
		}
		json.put("success", suc_msg);
		json.put("error", err_msg);
		
		
		response.getWriter().write(json.toString());
		return;
		
 		
       
    }
	
	@RequestMapping(value = "/edit_validation", method = RequestMethod.GET)
	public String editValidationById(ModelMap model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id=request.getParameter("tra_id").trim();
		Transfer transfer=new Transfer();
		transfer=transferService.getTransferById(id);
		
		model.addAttribute("transfer", transfer);
		model.addAttribute("opr_mode", "update");
		model.addAttribute("helper", helper);
	
		return "transfer/add_transfer";
	}
	
	
	@RequestMapping(value = "/edit_transfer", method = RequestMethod.GET)
	public String eventById(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("tra_id").trim();
		Transfer transfer=new Transfer();
		transfer=transferService.getTransferById(id);
		
		model.addAttribute("transfer", transfer);
		model.addAttribute("opr_mode", "update");
		model.addAttribute("helper", helper);
		return "transfer/add_transfer";
	}
	
	@RequestMapping(value = "/delete_transfer", method = RequestMethod.GET)
    public void deleteEvent(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("tra_id").trim();
		if(transferService.deleteTransfer(id)) {
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
	
	@RequestMapping(value = "/view_transfer", method = RequestMethod.GET)
	public String view_product(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("tra_id").trim();
		Transfer transfer=new Transfer();
		transfer=transferService.getTransferById(id);
		model.addAttribute("transfer", transfer);
		model.addAttribute("helper", helper);
		model.addAttribute("transferService", transferService);
		model.addAttribute("opr_mode", "view");
		
		return "transfer/add_transfer";
	}
	
	
}

