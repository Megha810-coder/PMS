package com.spcl.erp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Operation;
import com.spcl.erp.model.RequestQuotation;
import com.spcl.erp.model.RfqProductList;
import com.spcl.erp.model.SalePerson;
import com.spcl.erp.model.Transfer;
import com.spcl.erp.model.Transfer_Product;
import com.spcl.erp.services.CustomerService;
import com.spcl.erp.services.PurchaseService;
import com.spcl.erp.services.TransferService;

@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {
	
	JSONObject json = new JSONObject();
	private static SecureRandom random = new SecureRandom();
	
	@Autowired
	private Helper helper;
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TransferService transferService;
	/*private Helper helper;*/
	@RequestMapping(value = "/mng_rfq", method = RequestMethod.GET)
	public String manageRFQ(Locale locale, Model model,HttpServletRequest request) {
		
		List<RequestQuotation> rfq_List=new ArrayList<RequestQuotation>();
		rfq_List=purchaseService.getRFQList();
		
		model.addAttribute("RFQLIST", rfq_List);
		model.addAttribute("helper", helper);
		model.addAttribute("PurchaseService", purchaseService);
		model.addAttribute("url", request.getRequestURI());
		return "purchase/request_quotation_list";
	}
	
	@RequestMapping(value = "/new_rfq", method = RequestMethod.GET)
	public String new_rfq(Locale locale, Model model) {
		
		RequestQuotation rfq=new RequestQuotation();
		rfq.setRfq_isRfq(1);
		model.addAttribute("rfq", rfq);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "purchase/add_rfq";
	}
	

	@RequestMapping(value = "/save_rfq", method = RequestMethod.POST)
	public void save_rfq(
			@ModelAttribute("rfq") @Valid RequestQuotation rfq, 
			BindingResult result,
			ModelMap model,
			RfqProductList rfqproductlist,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flashdata
			
	) throws IOException {
		
		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			
	   	}else {
	   			   		
			String suc_msg="";
			String err_msg="";
			
			String opr_mode=request.getParameter("opr_mode").trim();
			
			Customer customer = helper.getVendorById(request.getParameter("rfq_vend_id"));
			rfq.setCustomer(customer);
			SalePerson saleperson=helper.getRepresentativeById(request.getParameter("rfq_representive_id"));
			rfq.setSaleperson(saleperson);
			
			String del_pro_ids="";
			
			
			float gross_amt=00.00f;
			float tax_amt=00.00f;
			
			List<RfqProductList> prod_list=rfq.getRfqproductlist();
			if(null != prod_list && prod_list.size() > 0) {
				
				List<RfqProductList> prod_list_from_db =helper.getProductListformDB(rfq.getRfq_id());
				
				for (RfqProductList rfpl : prod_list) {
					rfpl.setRfq(rfq);
					float sub_total=00.00f;
					sub_total=(rfpl.getRfpl_qty()!=null?rfpl.getRfpl_qty().floatValue():0.00f)
								*(rfpl.getRfpl_unit_price()!=null?rfpl.getRfpl_unit_price():00.00f);
					gross_amt+=sub_total;
					tax_amt+=helper.getTaxById(rfpl.getRfpl_tax_id(),sub_total).floatValue();
					rfpl.setRfpl_subtotal(new Float(sub_total));
				}
				
				rfq.setGross_amount(new Float(gross_amt));
				rfq.setTax_amount(new Float(tax_amt));
				rfq.setNet_amount(new Float(gross_amt+tax_amt));
				
				
				for(RfqProductList rfq_db:prod_list_from_db) {
					boolean is_delete=true;
					for (RfqProductList rfpl : prod_list) {
						if (null!=rfq.getRfq_id()&&rfq_db.getRfpl_prod_id().intValue()==rfq.getRfq_id().intValue()){
							is_delete=false;
							break;
						}
						if (null==rfq.getRfq_id()) {
							prod_list.remove(rfq);
						}
					}
					if (is_delete) {
						del_pro_ids+=rfq_db.getRfpl_prod_id().toString()+",";
					}
					
				}
				
			}else {
				json.put("status", 0);
				json.put("error", " Transfer document require minimum one product in list.");
				response.getWriter().write(json.toString());
				return;
			}
			
			rfq.setRfqproductlist(prod_list);
			
			rfq.setRfq_label_status(Helper.PO_RFQ);
			rfq.setRfq_active(1);
			
			if(rfq.getRfq_isRfq()==null) {
				rfq.setRfq_isRfq(0);
			}else {
				rfq.setRfq_no(helper.getRFQNo());
			}
			if(rfq.getRfq_isPO()==null) {
				rfq.setRfq_isPO(0);
			}else {
				rfq.setRfq_no(helper.getPONo());
			}
			
			
			if (opr_mode.equals("save")) {
								
				boolean flag=purchaseService.saveRFQ(rfq);
				if(flag) {
					suc_msg="Request For Quotation is  created Successfully..!";
					json.put("status", 1);
				}else {
					json.put("error", 0);
					err_msg="Can't saved...something went wrong..!";
				}
				
			}else if (opr_mode.equals("update")){
				
				boolean flag=purchaseService.updateRFQ(rfq);
				if(!del_pro_ids.equals("")) {
					del_pro_ids=del_pro_ids.substring(0, del_pro_ids.length()-1);
					flag=purchaseService.deleteRFQproducts(del_pro_ids);
				}
				
				if(flag) {
					suc_msg="Request For Quotation updated Successfully..!";
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
        return;
	}
	
	
	@RequestMapping(value = "/edit_rfq", method = RequestMethod.GET)
	public String edit_rfq(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("rfq_id").trim();
		RequestQuotation rfq=new RequestQuotation();
		rfq=purchaseService.getRFQById(id);
				
		model.addAttribute("rfq",rfq );
		model.addAttribute("rfq_odr_date", Helper.DATEFORMAT.format(rfq.getRfq_odr_date()));
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "update");
		return "purchase/add_rfq";
	}
	
	
	@RequestMapping(value = "/view_rfq", method = RequestMethod.GET)
	public String view_rfq(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("rfq_id").trim();
		RequestQuotation rfq=new RequestQuotation();
		rfq=purchaseService.getRFQById(id);
		
		model.addAttribute("rfq", rfq);
		model.addAttribute("helper", helper);
		model.addAttribute("purchaseService", purchaseService);
		model.addAttribute("customerService", customerService);
		model.addAttribute("opr_mode", "view");
		return "purchase/rfq_view";
	}
	
	@RequestMapping(value = "/delete_rfq", method = RequestMethod.GET)
    public void deleterfq(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("rfq_id").trim();
		if(purchaseService.deleteRFQ(id)) {
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
	
	@RequestMapping(value = "/mng_po", method = RequestMethod.GET)
	public String managePO(Locale locale, Model model,HttpServletRequest request) {
		
		List<RequestQuotation> po_list=new ArrayList<RequestQuotation>();
		po_list=purchaseService.getPOList();
		
		model.addAttribute("POLIST", po_list);
		model.addAttribute("helper", helper);
		model.addAttribute("PurchaseService", purchaseService);
		model.addAttribute("url", request.getRequestURI());
		return "purchase/purchase_order_list";
	}
	
	@RequestMapping(value = "/new_po", method = RequestMethod.GET)
	public String new_po(Locale locale, Model model) {
				
		RequestQuotation rfq=new RequestQuotation();
		rfq.setRfq_isPO(1);
		model.addAttribute("rfq", rfq);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "purchase/add_rfq";
	}
	
	@RequestMapping(value = "/rfq_mail", method = RequestMethod.GET)
	public String rfq_mail(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("rfq_id").trim();
		RequestQuotation rfq=new RequestQuotation();
		rfq=purchaseService.getRFQById(id);
		rfq.setRfq_label_status(Helper.PO_MAIL);
		purchaseService.updateRFQ(rfq);
		
		return "redirect:mng_rfq";
	}
	
	@RequestMapping(value = "/create_po", method = RequestMethod.GET)
	public String create_po(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("rfq_id").trim();
		Operation operation=new Operation();
		RequestQuotation rfq=new RequestQuotation();
		rfq=purchaseService.getRFQById(id);
			
		
		rfq.setRfq_label_status(Helper.PO_ORDER);
		model.addAttribute("helper", helper);
		/*rfq.setRfq_no(helper.getPONo());*/
		purchaseService.updateRFQ(rfq);
		/*tplist=transferService.getProductById(rfqlist.getRfpl_prod_id().toString());*/
		Date dat=new Date(new java.util.Date().getTime());
		Transfer transfer=new Transfer();
		transfer.setTra_partner_id(rfq.getCustomer().getCust_id());
		transfer.setTra_active(1);
		transfer.setTra_opt_type(1);
		transfer.setTra_lable(Helper.TRA_READY);
		transfer.setTra_create_date(dat);
		transfer.setTra_source("P001");
		transfer.setTra_note("Receipt");
		transfer.setTra_priority(1);
		transfer.setTra_opt_type(1);
		transfer.setTra_shiping(1);
		
		
		List<Transfer_Product> trp_list =new ArrayList<Transfer_Product>();
		for (RfqProductList rfqp : rfq.getRfqproductlist()) {
				Transfer_Product trp=new Transfer_Product();
				trp.setTrp_product_id(rfqp.getRfpl_prod_id());
				trp.setTrp_initial(rfqp.getRfpl_qty());
				trp.setTransfer(transfer);
				trp_list.add(trp);
			transfer.setTrp_list(trp_list);
			
		}
		transfer.setRfq(rfq);
		List<Transfer> transferlist =new ArrayList<Transfer>();
			transferlist.add(transfer);
		rfq.setTransferlist(transferlist);
		//add transfer in rfq  transfer list

		
		if(rfq.getRfq_label_status()==3) {
			
			transferService.saveTransfer(transfer);
			
			
		}
		
		return "redirect:mng_rfq";
	}
	@RequestMapping(value = "/view_receipt", method = RequestMethod.GET)
	public String view_receipt(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String rfq_id=request.getParameter("rfq_id").trim();
		Transfer transfer=new Transfer();
		transfer=transferService.getReceiptById(rfq_id);
		
		model.addAttribute("transfer", transfer);
		model.addAttribute("helper", helper);
		model.addAttribute("transferService", transferService);
		model.addAttribute("opr_mode", "view");
		
		return "transfer/add_transfer";
	}
}
