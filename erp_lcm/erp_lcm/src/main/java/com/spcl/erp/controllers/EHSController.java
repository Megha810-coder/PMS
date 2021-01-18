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
//import java.sql.Date;
import java.util.Date;  
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import com.spcl.erp.model.Contractor;
import com.spcl.erp.model.Department_type;
import com.spcl.erp.model.Ehs_Action;
import com.spcl.erp.model.Ehs_Factory_Act;
import com.spcl.erp.model.Ehs_Incident;
import com.spcl.erp.model.Ehs_Industrial;
import com.spcl.erp.model.Ehs_Product;
import com.spcl.erp.model.Ehs_Shipping;
import com.spcl.erp.model.Ehs_Training;
import com.spcl.erp.model.Ehs_Waste;
import com.spcl.erp.model.Ehs_Waste_Transport;
import com.spcl.erp.model.Ehs_witnesed;
import com.spcl.erp.model.HIRA;
import com.spcl.erp.model.Hazardous_Chemicals;
import com.spcl.erp.model.Labour;
import com.spcl.erp.model.LabourCheck;
import com.spcl.erp.model.Osha_Law;
import com.spcl.erp.model.ShiftTime;
import com.spcl.erp.services.EHSService;
import com.spcl.erp.services.ExportHira;
import com.spcl.erp.services.ImportHira;

import java.security.SecureRandom;

@Controller
@RequestMapping(value = "/ehs")
public class EHSController {

	private static final String String = null;

	JSONObject json = new JSONObject();
	private static SecureRandom random = new SecureRandom();
	@Autowired
	private Helper helper;

	Map<String, String> search_field = null;

	@Autowired
	private EHSService ehsService;
	
	@Autowired
	private ExportHira exportHIRA;
	
	@Autowired
	private ImportHira importHIRA;

	private int generation;

	public void setEhsService(EHSService ehsService) {
		this.ehsService = ehsService;
	}

	@RequestMapping(value = "/mng_ehs")
	public String manageBank(Locale locale, Model model, HttpServletRequest request) {

		List<Ehs_Action> action_list = new ArrayList<Ehs_Action>();

		String search_incident = request.getParameter("search_incident");

		if (search_incident != null && search_incident.equals("true")) {

			search_field = new HashMap<String, String>();

			String plant_name = request.getParameter("plant_name");
			search_field.put("plant_name", plant_name);

		}
		action_list = ehsService.getIncident_list(search_field);

		model.addAttribute("action_list", action_list);
		model.addAttribute("search_field", search_field);
		model.addAttribute("ehsService", ehsService);
		model.addAttribute("resp_page", "ehs/show_report_list");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/show_report_list";
	}

	@RequestMapping(value = "/new_ehs", method = RequestMethod.GET)
	public String new_ehs(Locale locale, Model model, HttpServletRequest request) {

		Ehs_Action action = new Ehs_Action();

		model.addAttribute("action", action);
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/incident_reporting";
	}

	@RequestMapping(value = "/save_ehs", method = RequestMethod.POST)
	public void save_ehs(@ModelAttribute("action") @Valid Ehs_Action action,

			BindingResult result, ModelMap model, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes flasdatat, @RequestParam("file_name_photo") MultipartFile file) throws IOException {

		Date dat = new Date(new java.util.Date().getTime());
		String opr_mode = request.getParameter("opr_mode").trim();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		json = new JSONObject();

		String suc_msg = "";
		String err_msg = "";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
		}

		if (file != null && !file.isEmpty()) {
			try {
				String img_code = new BigInteger(30, random).toString(32).toUpperCase() + ".png";
				byte[] bytes = file.getBytes();
				// Creating the directory to store file

				File dir = new File(Helper.INCIDENT_DOC_PATH);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + img_code);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				action.setFile_name(img_code);

			} catch (Exception e) {
				json.put("status", 0);
				json.put("error", "You failed to upload " + action.getTitle() + " => " + e.getMessage());
			}

		}

		action.setAction_active(1);
		
		action.getTreatment().setEhs_action(action);
		for (Iterator iterator = action.getWitnesed_list().iterator(); iterator.hasNext();) {
			Ehs_witnesed ehs_wts = (Ehs_witnesed) iterator.next();
			ehs_wts.setEhs_action(action);

		}

		if (opr_mode.equals("save")) {

			action.setAction_create_date(dat);
			action.setAction_create_by("megha");
			boolean flag = ehsService.saveIncident(action);
			if (flag) {
				suc_msg = "Incident details created Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't saved...something went wrong..!";
			}

		} else if (opr_mode.equals("update")) {

			action.setAction_update_date(dat);
			boolean flag = ehsService.updateIncident(action);
			if (flag) {
				suc_msg = "Incident details updated Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't update...something went wrong..!";
			}
		}

		json.put("success", suc_msg);
		json.put("error", err_msg);
		flasdatat.addFlashAttribute("suc_msg", suc_msg);
		flasdatat.addFlashAttribute("err_msg", err_msg);

		response.getWriter().write(json.toString());
		return;
	}

	@RequestMapping(value = "/edit_ehs", method = RequestMethod.GET)
	public String edit_ehs(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("action_id").trim();

		Ehs_Action action = new Ehs_Action();
		action = ehsService.getActionById(id);
		String action_date = Helper.DATEFORMAT.format(action.getAction_date());
		model.addAttribute("action", action);

		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "update");
		model.addAttribute("action_date", action_date);
		return "ehs/incident_reporting";
	}

	@RequestMapping(value = "/view_ehs", method = RequestMethod.GET)
	public String view_product(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("action_id").trim();
		Ehs_Action action = new Ehs_Action();
		action = ehsService.getActionById(id);
		Ehs_witnesed witnesed = new Ehs_witnesed();
		witnesed = ehsService.getWitnesedById(id);
		Ehs_Incident incident = new Ehs_Incident();
		incident = ehsService.getIncidentByActionId(id);
		/*
		 * Ehs_Injured injured=new Ehs_Injured();
		 * incident=ehsService.getIncidentByActionId(id); Ehs_Incident incident=new
		 * Ehs_Incident(); incident=ehsService.getIncidentByActionId(id);
		 */
		model.addAttribute("action", action);
		model.addAttribute("witnesed", witnesed);
		model.addAttribute("incident", incident);
		model.addAttribute("helper", helper);
		/* model.addAttribute("reorderService", reorderService); */
		model.addAttribute("opr_mode", "view");
		return "ehs/incident_reporting";
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_hazardous", method = RequestMethod.GET)  
	public String manageEvent1(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
	List<Hazardous_Chemicals> hazardous_list=new ArrayList<Hazardous_Chemicals>();
	hazardous_list=ehsService.getHazardous_list1();


	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        if(hazardous_list.size()>0) {
	        	  Json=json.toJson(hazardous_list);
	        	 out.print(Json);
	        }
	        model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("ehsService", ehsService);
	model.addAttribute("url", request.getRequestURI());
	return "ehs/mng_hazardous";
	}
	

	/*@RequestMapping(value = "/mng_hazardous")
	public String manageHazardous(Locale locale, Model model, HttpServletRequest request) {

		List<Hazardous_Chemicals> chemical_list = new ArrayList<Hazardous_Chemicals>();
		Map<String, String> search_field = null;

		String search_hazard = request.getParameter("search_hazard");

		if (search_hazard != null && search_hazard.equals("true")) {

			search_field = new HashMap<String, String>();

			String chemical_name = request.getParameter("chemical_name");
			search_field.put("chemical_name", chemical_name);

		}

		chemical_list = ehsService.getHazardous_list(search_field);

		model.addAttribute("chemical_list", chemical_list);
		model.addAttribute("search_field", search_field);

		model.addAttribute("url", request.getRequestURI());
		return "ehs/hazardsList";
	}*/

	@RequestMapping(value = "/new_hazardous", method = RequestMethod.GET)
	public String new_hazardous(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("opr_mode", "save");
		return "ehs/hazardSubM";
	}

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/save_hazardous", method = RequestMethod.POST)
	public void save_hazardous(
			@ModelAttribute("data") @Valid Hazardous_Chemicals chemicals, 
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
    	
    	  String chemical_name = jsonObj.getString("chemical_name");
    	  chemicals.setChemical_name(chemical_name);
    	 
    	  /*String quantity = jsonObj.getString("quantity");
    	  waste.setQuantity(quantity);
    	  
    	  String waste_desc = jsonObj.getString("waste_desc");
    	  waste.setWaste_desc(waste_desc);
    	  
    	 String waste_department = jsonObj.getString("waste_department");
    	  waste.setWaste_department(waste_department);*/
    	  
    /*	  String disposal_date = jsonObj.getString("disposal_date");
    	  waste.setDisposal_date(disposal_date);*/
    	  
    	  /*String techniques = jsonObj.getString("techniques");
    	  waste.setTechniques(techniques);
    	  
    	  Ehs_Shipping shipping=new  Ehs_Shipping();*/
   	    
    	/*  String generation_1 = jsonObj.getString("generation_1");
    	  String generation_2 = jsonObj.getString("generation_2");
			  if(generation == 1) {
			  int generation = Integer.parseInt(generation_1);
			  //Integer generation=Integer.parseInt(generation_1);
			  shipping.setGeneration(generation_1);
			  }
    	
	    	  else {
	    	  int generation = Integer.parseInt(generation_2);
	    	  shipping.setGeneration(generation_2);
	    	  }*/
    	  /*String collection_1 = jsonObj.getString("collection_1");
    	  shipping.setCollection(collection);
    	  
    	  String generation_1 = jsonObj.getString("generation_1");
    	  shipping.setGeneration(generation_1);
    	  
    	  String generation_1 = jsonObj.getString("generation_1");
    	  shipping.setGeneration(generation_1);*/
    	  
    	 /*Ehs_Waste_Transport transport=new  Ehs_Waste_Transport();
    	  String veh_name = jsonObj.getString("veh_name");
    	  System.out.println(veh_name);
    	  transport.setVeh_name(veh_name);
    	
    	  String veh_number = jsonObj.getString("veh_number");
    	  transport.setVeh_number(veh_number);
    	  
    	  String material_qty = jsonObj.getString("material_qty");
    	  transport.setMaterial_qty(material_qty);
    	  
     	  String dis_name = jsonObj.getString("dis_name");
    	  transport.setDis_name(dis_name);*/
    	  
    /*	  String shipment_date = jsonObj.getString("shipment_date");
    	  shipping.setShipment_date(shipment_date);*/
			
    	  chemicals.setHazard_active(1);
    	
        String suc_msg="";
		String err_msg="";
	
		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}
			boolean flag=ehsService.saveChemicals(chemicals);
		/*	boolean flag1=ehsService.saveTransport(chemicals);
			boolean flag11=ehsService.saveShipping(shipping);*/
			
			if(flag) {
				suc_msg="chemicals created Successfully..!";
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
	
	
	/*@RequestMapping(value = "/save_hazardous", method = RequestMethod.POST)
	public void save_hazardous(@ModelAttribute("chemicals") @Valid Hazardous_Chemicals chemicals, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes flasdatat,
			@RequestParam("doc_name") MultipartFile file) throws IOException {

		Date dat = new Date(new java.util.Date().getTime());

		if (chemicals.getIdentification() != null)
			;
		{
			chemicals.getIdentification().setHazardous_Chemicals(chemicals);
		}

		if (chemicals.getFirst_aid() != null) {
			chemicals.getFirst_aid().setHazardous_Chemicals(chemicals);
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		json = new JSONObject();

		String suc_msg = "";
		String err_msg = "";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;

		}

		if (file != null && !file.isEmpty()) {
			try {
				String img_code = new BigInteger(30, random).toString(32).toUpperCase() + ".pdf";
				byte[] bytes = file.getBytes();
				// Creating the directory to store file

				File dir = new File(Helper.INCIDENT_DOC_PATH);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + img_code);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				chemicals.setFile_name(img_code);

			} catch (Exception e) {
				json.put("status", 0);
				json.put("error", "You failed to upload " + chemicals.getChemical_name() + " => " + e.getMessage());
			}

		}

		String opr_mode = request.getParameter("opr_mode".trim());
		chemicals.setHazard_active(1);
		if (opr_mode.equals("save")) {
			chemicals.setHazardous_created_date(dat);
			chemicals.setHazardous_create_by("Abhi");
			boolean flag = ehsService.saveHazardous(chemicals);

			if (flag) {
				suc_msg = "Hazardous details created Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't saved...something went wrong..!";
			}
		} else if (opr_mode.equals("update")) {
			chemicals.setHazardous_updated_date(dat);
			boolean flag = ehsService.updateHazardous(chemicals);
			if (flag) {
				suc_msg = "Hazardous details updated Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't update...something went wrong..!";
			}

		}

		json.put("success", suc_msg);
		json.put("error", err_msg);
		flasdatat.addFlashAttribute("suc_msg", suc_msg);
		flasdatat.addFlashAttribute("err_msg", err_msg);

		response.getWriter().write(json.toString());
		return;
	}
*/
	@RequestMapping(value = "/view_hazardous", method = RequestMethod.GET)
	public String view_hazardous(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("hazard_id").trim();
		Hazardous_Chemicals hazard = new Hazardous_Chemicals();
		hazard = ehsService.getHazardousById(id);

		model.addAttribute("hazard", hazard);
		model.addAttribute("opr_mode", "view");
		// model.addAttribute("helper", helper);
		return "ehs/hazardSubM";
	}

	@RequestMapping(value = "/edit_hazardous", method = RequestMethod.GET)
	public String edit_hazardous(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("hazard_id").trim();
		Hazardous_Chemicals hazard = new Hazardous_Chemicals();
		hazard = ehsService.getHazardousById(id);

		model.addAttribute("hazard", hazard);
		model.addAttribute("opr_mode", "update");
		// model.addAttribute("helper", helper);
		return "ehs/hazardSubM";
	}

	@RequestMapping(value = "/mng_danagrous_goods_list", method = RequestMethod.GET)
	public String manage_goods(Locale locale, Model model, HttpServletRequest request) {

		List<Hazardous_Chemicals> chemical_list = new ArrayList<Hazardous_Chemicals>();

		chemical_list = ehsService.getHazardous_list(search_field);

		model.addAttribute("chemical_list", chemical_list);

		model.addAttribute("search_field", search_field);
		// model.addAttribute("ehsService", ehsService);
		model.addAttribute("resp_page", "ehs/danagrous_goods_list");

		model.addAttribute("url", request.getRequestURI());
		return "ehs/danagrous_goods_list";
	}

	@RequestMapping(value = "/new_danagrous_goods_magt", method = RequestMethod.GET)
	public String new_goods(Locale locale, Model model, HttpServletRequest request) {
		String id = request.getParameter("hazard_id").trim();
		Hazardous_Chemicals hazard = new Hazardous_Chemicals();
		hazard = ehsService.getHazardousById(id);

		model.addAttribute("hazard", hazard);
		model.addAttribute("url", request.getRequestURI());
		return "ehs/add_danagrous_goods";
	}

	@RequestMapping(value = "/impact_danagrous_goods", method = RequestMethod.GET)
	public String new_impact(Locale locale, Model model, HttpServletRequest request) {

		String id = request.getParameter("hazard_id").trim();
		Hazardous_Chemicals hazard = new Hazardous_Chemicals();
		hazard = ehsService.getHazardousById(id);
		model.addAttribute("hazard", hazard);
		model.addAttribute("value", "impact");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/add_danagrous_goods";
	}

	@RequestMapping(value = "/risk_danagrous_goods", method = RequestMethod.GET)
	public String new_risk(Locale locale, Model model, HttpServletRequest request) {
		String id = request.getParameter("hazard_id").trim();
		Hazardous_Chemicals hazard = new Hazardous_Chemicals();
		hazard = ehsService.getHazardousById(id);

		model.addAttribute("hazard", hazard);
		model.addAttribute("value", "risk");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/add_danagrous_goods";
	}

	@RequestMapping(value = "/safety_danagrous_goods", method = RequestMethod.GET)
	public String new_safety(Locale locale, Model model, HttpServletRequest request) {
		String id = request.getParameter("hazard_id").trim();
		Hazardous_Chemicals hazard = new Hazardous_Chemicals();
		hazard = ehsService.getHazardousById(id);

		model.addAttribute("hazard", hazard);
		model.addAttribute("value", "safety");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/add_danagrous_goods";
	}

	@RequestMapping(value = "/mail_ehs")
	public String mail_ehs(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/mail";
	}

	@RequestMapping(value = "/mng_product")
	public String manageProduct(Locale locale, Model model, HttpServletRequest request) {

		List<Ehs_Product> product_list = new ArrayList<Ehs_Product>();
		product_list = ehsService.getProductList();
		model.addAttribute("ehsService", ehsService);
		model.addAttribute("product_list", product_list);
		model.addAttribute("url", request.getRequestURI());
		return "ehs/product_report_list";
	}

	@RequestMapping(value = "/new_product", method = RequestMethod.GET)
	public String new_product(Locale locale, Model model, HttpServletRequest request) {
		Ehs_Product products = new Ehs_Product();
		model.addAttribute("products", products);
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("opr_mode", "save");
		return "ehs/product_reporting";
	}

	@RequestMapping(value = "/save_product", method = RequestMethod.POST)
	public void save_product(@ModelAttribute("products") @Valid Ehs_Product products, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes flasdatat)
			throws IOException {

		Date dat = new Date(new java.util.Date().getTime());

		/*
		 * if(products.getEhs_Safety()!=null); {
		 * products.getEhs_Safety().setEhs_Product(products); }
		 * 
		 * if(products.getEhs_Pack()!=null); {
		 * products.getEhs_Pack().setEhs_Product(products); }
		 * 
		 * if(products.getEhs_Vehicle()!=null); {
		 * products.getEhs_Vehicle().setEhs_Product(products); }
		 */

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		json = new JSONObject();

		String suc_msg = "";
		String err_msg = "";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;

		}

		products.setProduct_active(1);
		products.getEhs_Safety().setEhs_Product(products);
		products.getEhs_Pack().setEhs_Product(products);
		products.getEhs_Vehicle().setEhs_Product(products);

		String opr_mode = request.getParameter("opr_mode".trim());
		if (opr_mode.equals("save")) {
//			products.setProduct_active(dat);
			products.setProduct_create_by("Abhishek");
			boolean flag = ehsService.saveProduct(products);

			if (flag) {
				suc_msg = "Product details created Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't saved...something went wrong..!";
			}
		} else if (opr_mode.equals("update")) {
			products.setProduct_updated_date(dat);
			boolean flag = ehsService.updateProduct(products);
			if (flag) {
				suc_msg = "Products details updated Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't update...something went wrong..!";
			}

		}

		json.put("success", suc_msg);
		json.put("error", err_msg);
		flasdatat.addFlashAttribute("suc_msg", suc_msg);
		flasdatat.addFlashAttribute("err_msg", err_msg);

		response.getWriter().write(json.toString());
		return;
	}

	@RequestMapping(value = "/view_product", method = RequestMethod.GET)
	public String view_products(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("product_id").trim();
		Ehs_Product products = new Ehs_Product();
		products = ehsService.getProductById(id);

		model.addAttribute("products", products);
		model.addAttribute("opr_mode", "view");
		// model.addAttribute("helper", helper);
		return "ehs/product_reporting";
	}

	@RequestMapping(value = "/edit_product", method = RequestMethod.GET)
	public String edit_product(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("product_id").trim();
		Ehs_Product products = new Ehs_Product();
		products = ehsService.getProductById(id);

		String manufacturing_date = Helper.DATEFORMAT.format(products.getManufacturing_date());
		String expiry_date = Helper.DATEFORMAT.format(products.getExpiry_date());
		String packeging_date = Helper.DATEFORMAT.format(products.getEhs_Pack().getPackeging_date());
		String delivery_date = Helper.DATEFORMAT.format(products.getEhs_Pack().getDelivery_date());
		String del_date = Helper.DATEFORMAT.format(products.getEhs_Vehicle().getDel_date());

		model.addAttribute("products", products);
		model.addAttribute("opr_mode", "update");
		model.addAttribute("manufacturing_date", manufacturing_date);
		model.addAttribute("expiry_date", expiry_date);
		model.addAttribute("packeging_date", packeging_date);
		model.addAttribute("delivery_date", delivery_date);
		model.addAttribute("del_date", del_date);
		// model.addAttribute("helper", helper);
		return "ehs/product_reporting";
	}
	
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_waste_list", method = RequestMethod.GET)  
	public String manageEvent(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
	List<Ehs_Waste> waste_list=new ArrayList<Ehs_Waste>();
	waste_list=ehsService.getWaste_list1();


	        PrintWriter out = response.getWriter();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        Gson json = new Gson();
	        String Json=null;
	        if(waste_list.size()>0) {
	        	  Json=json.toJson(waste_list);
	        	 out.print(Json);
	        }
	        model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("ehsService", ehsService);
	model.addAttribute("url", request.getRequestURI());
	return "ehs/mng_waste_list";
	}
	
	

	/*@RequestMapping(value = "/mng_waste_list", method = RequestMethod.GET)
	public String manageWaste(Locale locale, Model model, HttpServletRequest request) {

		List<Ehs_Waste> waste_list = new ArrayList<Ehs_Waste>();
		waste_list = ehsService.getWasteList();

		model.addAttribute("waste_list", waste_list);
		model.addAttribute("ehsService", ehsService);
		model.addAttribute("resp_page", "ehs/show_report_list");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/waste_report_list";
	}*/

	@RequestMapping(value = "/new_waste", method = RequestMethod.GET)
	public String new_waste(Locale locale, Model model, HttpServletRequest request) {

		Ehs_Waste waste = new Ehs_Waste();

		model.addAttribute("waste", waste);
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/waste_reporting";
	}
  
	
	/*@RequestMapping(value = "/save_waste", method = RequestMethod.POST)
	public void save_waste(@ModelAttribute("waste") @Valid Ehs_Waste waste, BindingResult result, ModelMap model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes flasdatat,
			@RequestParam("doc_waste_name") MultipartFile file) throws IOException {

		Date dat = new Date(new java.util.Date().getTime());

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		json = new JSONObject();

		String suc_msg = "";
		String err_msg = "";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;

		}

		if (file != null && !file.isEmpty()) {
			try {
				String img_code = new BigInteger(30, random).toString(32).toUpperCase() + ".pdf";
				byte[] bytes = file.getBytes();
				// Creating the directory to store file

				File dir = new File(Helper.WASTE_DOC_PATH);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + img_code);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				waste.setDoc_waste(img_code);

			} catch (Exception e) {
				json.put("status", 0);
				json.put("error", "You failed to upload " + waste.getChem_name() + " => " + e.getMessage());
			}

		}
		waste.setWaste_active(1);
		waste.getEhs_Shipping().setEhs_waste(waste);
		waste.getEhs_Waste_Transport().setEhs_waste(waste);

		String opr_mode = request.getParameter("opr_mode".trim());
		waste.setWaste_active(1);
		if (opr_mode.equals("save")) {
			waste.setWaste_create_date(dat);
			waste.setWaste_update_by("Abhi");
			boolean flag = ehsService.saveWaste(waste);

			if (flag) {
				suc_msg = "Waste details created Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't saved...something went wrong..!";
			}
		} else if (opr_mode.equals("update")) {
			waste.setWaste_update_date(dat);
			boolean flag = ehsService.updateWaste(waste);
			if (flag) {
				suc_msg = "Waste details updated Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't update...something went wrong..!";
			}

		}

		json.put("success", suc_msg);
		json.put("error", err_msg);
		flasdatat.addFlashAttribute("suc_msg", suc_msg);
		flasdatat.addFlashAttribute("err_msg", err_msg);

		response.getWriter().write(json.toString());
		return;
	}
*/
	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/save_waste", method = RequestMethod.POST)
	public void save_labCheckk(
			@ModelAttribute("data") @Valid Ehs_Waste waste, 
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
    	
    	  String chem_name = jsonObj.getString("chem_name");
    	  waste.setChem_name(chem_name);
    	 
    	  String quantity = jsonObj.getString("quantity");
    	  waste.setQuantity(quantity);
    	  
    	  String waste_desc = jsonObj.getString("waste_desc");
    	  waste.setWaste_desc(waste_desc);
    	  
    	 String waste_department = jsonObj.getString("waste_department");
    	  waste.setWaste_department(waste_department);
    	  
    	/*  String disposal_date = jsonObj.getString("disposal_date");
     	  int date = Integer.parseInt(disposal_date);
    	  waste.setDisposal_date(disposal_date);*/
    	  
    	  String techniques = jsonObj.getString("techniques");
    	  waste.setTechniques(techniques);
    	  
    	  String generation_1 = jsonObj.getString("generation_1");
    	  int generation = Integer.parseInt(generation_1);
    	  String generation_2 = jsonObj.getString("generation_2");
    	
			  if(generation == 1) {
				  waste.setGeneration(generation_1);
			  }
	    	  else {
	    		  waste.setGeneration(generation_2);
	    	  }
			  
			  String collection_1 = jsonObj.getString("collection_1");
	    	  int collection = Integer.parseInt(generation_1);
	    	  String collection_2 = jsonObj.getString("collection_1");
	    	
				  if(collection == 1) {
					  waste.setCollection(collection_1);
				  }
		    	  else {
		    		  waste.setCollection(collection_2);
		    	  }
				  
				  String storage_1 = jsonObj.getString("storage_1");
		    	  int storage = Integer.parseInt(storage_1);
		    	  String storage_2 = jsonObj.getString("storage_2");
		    	
					  if(storage == 1) {
						  waste.setStorage(storage_1);
					  }
			    	  else {
			    		  waste.setStorage(storage_2);
			    	  }
					  
					  String transportation_1 = jsonObj.getString("transportation_1");
			    	  int transportation = Integer.parseInt(transportation_1);
			    	  String transportation_2= jsonObj.getString("transportation_2");
			    	
						  if(transportation == 1) {
							  waste.setTransportation(transportation_1);
						  }
				    	  else {
				    		  waste.setTransportation(transportation_2);
				    	  }
    	  
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
    	  
      /*    String shipment_date = jsonObj.getString("shipment_date");
    	  shipping.setShipment_date(shipment_date);*/
			
    	  waste.setWaste_active(1);
    	
        String suc_msg="";
		String err_msg="";
	
		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}
			boolean flag=ehsService.saveWaste(waste);
			boolean flag1=ehsService.saveTransport(transport);
			if(flag) {
				suc_msg="waste created Successfully..!";
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
	
	@RequestMapping(value = "/view_waste", method = RequestMethod.GET)
	public String view_waste(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("waste_id").trim();
		Ehs_Waste waste = new Ehs_Waste();
		waste = ehsService.getWasteById(id);

		model.addAttribute("waste", waste);
		model.addAttribute("opr_mode", "view");
		// model.addAttribute("helper", helper);
		return "ehs/waste_reporting";
	}

	@RequestMapping(value = "/edit_waste", method = RequestMethod.GET)
	public String edit_waste(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("waste_id").trim();
		Ehs_Waste waste = new Ehs_Waste();
		waste = ehsService.getWasteById(id);

		String disposal_date = Helper.DATEFORMAT.format(waste.getDisposal_date());
		String shipment_date = Helper.DATEFORMAT.format(waste.getEhs_Shipping().getShipment_date());

		model.addAttribute("waste", waste);
		model.addAttribute("opr_mode", "update");
		model.addAttribute("disposal_date", disposal_date);
		model.addAttribute("shipment_date", shipment_date);
		// model.addAttribute("helper", helper);
		return "ehs/waste_reporting";
	}

	@RequestMapping(value = "/mng_occupational_programs_list", method = RequestMethod.GET)
	public String manage_occupational_programs(Locale locale, Model model, HttpServletRequest request) {

		List<Ehs_Training> training_list = new ArrayList<Ehs_Training>();

		training_list = ehsService.getTraining_List();

		model.addAttribute("training_list", training_list);

		model.addAttribute("search_field", search_field);
		// model.addAttribute("ehsService", ehsService);
		model.addAttribute("resp_page", "ehs/occupational_program_list");

		model.addAttribute("url", request.getRequestURI());
		return "ehs/occupational_program_list";
	}
	@RequestMapping(value = "/back_occupational_list", method = RequestMethod.GET)
	public String back_occupational_list(Locale locale, Model model, HttpServletRequest request) {

		List<Ehs_Training> training_list = new ArrayList<Ehs_Training>();

		training_list = ehsService.getTraining_List();

		model.addAttribute("training_list", training_list);

		model.addAttribute("search_field", search_field);
		 model.addAttribute("ehsService", ehsService);
		

		model.addAttribute("url", request.getRequestURI());
		return "ehs/occupational_program_list";
	}

	@RequestMapping(value = "/new_occupational_programs", method = RequestMethod.GET)
	public String new_occupational_programs(Locale locale, Model model, HttpServletRequest request) {
		Ehs_Training training = new Ehs_Training();
		model.addAttribute("training", training);
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/occupational_training";
	}

	@RequestMapping(value = "/new_occupational_law", method = RequestMethod.GET)
	public String new_occupational_law(Locale locale, Model model, HttpServletRequest request) {
		Osha_Law osha = new Osha_Law();
		osha = ehsService.getOshaLaw();
		model.addAttribute("osha", osha);
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/osha_law";
	}
	@RequestMapping(value = "/new_first_aid", method = RequestMethod.GET)
	public String new_first_aid(Locale locale, Model model, HttpServletRequest request) {
		model.addAttribute("url", request.getRequestURI());
		return "ehs/add_first_aid_occupational";
	}

	@RequestMapping(value = "/save_occupational", method = RequestMethod.POST)
	public void save_occupational(@ModelAttribute("occupational") @Valid Ehs_Training training, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes flasdatat)
			throws IOException {

		Date dat = new Date(new java.util.Date().getTime());

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		json = new JSONObject();

		String suc_msg = "";
		String err_msg = "";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;

		}

		training.setTraining_active(1);
		String opr_mode = request.getParameter("opr_mode".trim());
		if (opr_mode.equals("save")) {
			training.setTraining_created_date(dat);
			boolean flag = ehsService.saveTraining(training);
			if (flag) {
				suc_msg = "Training details created Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't saved...something went wrong..!";
			}
		}
		/*
		 * else if (opr_mode.equals("update")) { products.setProduct_updated_date(dat);
		 * boolean flag=ehsService.updateProduct(products); if(flag) {
		 * suc_msg="Products details updated Successfully..!"; json.put("status", 1);
		 * }else { json.put("error", 0);
		 * err_msg="Can't update...something went wrong..!"; }
		 */

		json.put("success", suc_msg);
		json.put("error", err_msg);
		flasdatat.addFlashAttribute("suc_msg", suc_msg);
		flasdatat.addFlashAttribute("err_msg", err_msg);

		response.getWriter().write(json.toString());
		return;
	}

	@RequestMapping(value = "/view_occupational_programs", method = RequestMethod.GET)
	public String view_occupational(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("training_id").trim();
		Ehs_Training training = new Ehs_Training();
		training = ehsService.getTrainingById(id);

		model.addAttribute("training", training);
		model.addAttribute("opr_mode", "view");
		// model.addAttribute("helper", helper);
		return "ehs/occupational_training";
	}
	
	
	/*
	 * @RequestMapping(value = "/complaint_occupational_programs", method =
	 * RequestMethod.GET) public String new_complaint(Locale locale, Model model,
	 * HttpServletRequest request) {
	 * 
	 * model.addAttribute("url", request.getRequestURI()); return
	 * "ehs/add_occupational_programs"; }
	 * 
	 * @RequestMapping(value = "/firstaid_occupational_programs", method =
	 * RequestMethod.GET) public String new_firstaid(Locale locale, Model model,
	 * HttpServletRequest request) {
	 * 
	 * model.addAttribute("url", request.getRequestURI()); return
	 * "ehs/add_occupational_programs"; }
	 */

	@RequestMapping(value = "/mng_industrial_hygine_programs_list", method = RequestMethod.GET)
	public String manage_industrial_hygine_programs(Locale locale, Model model, HttpServletRequest request) {

		List<Ehs_Industrial> industrial_List = new ArrayList<Ehs_Industrial>();

		industrial_List = ehsService.getIndustrial_List();

		model.addAttribute("industrial_list", industrial_List);

		model.addAttribute("resp_page", "ehs/industrial_hygine_program_list");

		model.addAttribute("url", request.getRequestURI());
		return "ehs/industrial_hygine_program_list";
	}
	
	@RequestMapping(value = "/back_industrial_list", method = RequestMethod.GET)
	public String back_industrial_list(Locale locale, Model model, HttpServletRequest request) {

		List<Ehs_Industrial> industrial_list = new ArrayList<Ehs_Industrial>();

		industrial_list = ehsService.getIndustrial_List();

		model.addAttribute("industrial_list", industrial_list);

		model.addAttribute("search_field", search_field);
		 model.addAttribute("ehsService", ehsService);
		

		model.addAttribute("url", request.getRequestURI());
		return "ehs/industrial_hygine_program_list";
	}


	@RequestMapping(value = "/new_industrial_hygine_programs", method = RequestMethod.GET)
	public String new_industrial_hygine_programs(Locale locale, Model model, HttpServletRequest request) {
		Ehs_Industrial industrial = new Ehs_Industrial();
		model.addAttribute("industrial", industrial);
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/industrial_program";
	}

	@RequestMapping(value = "/new_factory_law", method = RequestMethod.GET)
	public String new_factory_law(Locale locale, Model model, HttpServletRequest request) {
		Ehs_Factory_Act factory = new Ehs_Factory_Act();
		factory = ehsService.getFactoryAct();
		model.addAttribute("factory", factory);
		model.addAttribute("opr_mode", "save");
		model.addAttribute("url", request.getRequestURI());
		return "ehs/factory_act";
	}

	
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/save_industrial", method = RequestMethod.POST)
	public void save_industrial(
			@ModelAttribute("data") @Valid Ehs_Industrial industrial, 
			BindingResult result,
			ModelMap model,
			HttpServletRequest request, 
			HttpServletResponse response,
			RedirectAttributes flashdata
		) throws IOException, ParseException {
		
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
    	
    	  String industrial_name = jsonObj.getString("industrial_name");
    	  industrial.setIndustrial_name(industrial_name);
    	  
    	  String industrial_aspect = jsonObj.getString("industrial_aspect");
    	  industrial.setIndustrial_aspect(industrial_aspect);
    	  
    	  String industrial_des = jsonObj.getString("industrial_des");
    	  industrial.setIndustrial_des(industrial_des);
    	  
/*   	  String industrial_date = jsonObj.getString("industrial_date");
   	DateFormat formatter;
   	formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
   	Date date_temp=null;
    date_temp = (Date) formatter.parse(industrial_date);*/
//    	  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(industrial_date);  
//    	  System.out.println("\t"+date1);  
    	
   	
//    	  java.lang.String date1=print.format(parsedDate)
    	  //industrial.setIndustrial_date(date_temp);
//    	  SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
//    	  java.util.Date date= df.parse(industrial_date);
//    	  //System.out.println(date);
//    	  industrial.setIndustrial_date(date);
//    	  
    	/*  String generation_1 = jsonObj.getString("generation_1");
    	  int generation = Integer.parseInt(generation_1);
    	  String generation_2 = jsonObj.getString("generation_2");
    	
			  if(generation == 1) {
				  waste.setGeneration(generation_1);
			  }
	    	  else {
	    		  waste.setGeneration(generation_2);
	    	  }*/
			  
/*    	  
    	 Ehs_Waste_Transport transport=new  Ehs_Waste_Transport();
    	  String veh_name = jsonObj.getString("veh_name");
    	  System.out.println(veh_name);
    	  transport.setVeh_name(veh_name);
    	
    	  String veh_number = jsonObj.getString("veh_number");
    	  transport.setVeh_number(veh_number);
    	  
*/			
    	  industrial.setIndustrial_active(1);
    	
        String suc_msg="";
		String err_msg="";
	
		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}
			boolean flag=ehsService.saveIndustrial(industrial);
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
	
	
	/*@RequestMapping(value = "/save_industrial", method = RequestMethod.POST)
	public void save_industrial(@ModelAttribute("industrial") @Valid Ehs_Industrial industrial, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes flasdatat)
			throws IOException {

		Date dat = new Date(new java.util.Date().getTime());

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		json = new JSONObject();

		String suc_msg = "";
		String err_msg = "";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;

		}

		industrial.setIndustrial_active(1);
		String opr_mode = request.getParameter("opr_mode".trim());
		if (opr_mode.equals("save")) {
			industrial.setIndustrial_created_date(dat);
			boolean flag = ehsService.saveIndustrial(industrial);
			if (flag) {
				suc_msg = "Inspection details created Successfully..!";
				json.put("status", 1);
			} else {
				json.put("error", 0);
				err_msg = "Can't saved...something went wrong..!";
			}
		}
		
		 * else if (opr_mode.equals("update")) { products.setProduct_updated_date(dat);
		 * boolean flag=ehsService.updateProduct(products); if(flag) {
		 * suc_msg="Products details updated Successfully..!"; json.put("status", 1);
		 * }else { json.put("error", 0);
		 * err_msg="Can't update...something went wrong..!"; }
		 

		json.put("success", suc_msg);
		json.put("error", err_msg);
		flasdatat.addFlashAttribute("suc_msg", suc_msg);
		flasdatat.addFlashAttribute("err_msg", err_msg);

		response.getWriter().write(json.toString());
		return;
	}*/

	

	/*
	 * @RequestMapping(value = "/save_factory", method = RequestMethod.POST) public
	 * void save_factory(@ModelAttribute("factory") @Valid Ehs_Factory_Act factory,
	 * BindingResult result, ModelMap model, HttpServletRequest request,
	 * HttpServletResponse response, RedirectAttributes flasdatat) throws
	 * IOException {
	 * 
	 * Date dat = new Date(new java.util.Date().getTime());
	 * 
	 * response.setContentType("application/json");
	 * response.setCharacterEncoding("UTF-8"); json = new JSONObject();
	 * 
	 * String suc_msg = ""; String err_msg = "";
	 * 
	 * if (result.hasErrors()) { json.put("status", 0); json.put("error",
	 * helper.getErrors(result)); response.getWriter().write(json.toString());
	 * return;
	 * 
	 * }
	 * 
	 * factory.setFactory_active(1);; String opr_mode =
	 * request.getParameter("opr_mode".trim()); if (opr_mode.equals("save")) {
	 * factory.setFactory_created_date(dat); boolean flag =
	 * ehsService.saveFactory(factory); if (flag) { suc_msg =
	 * "Factory Acts details created Successfully..!"; json.put("status", 1); } else
	 * { json.put("error", 0); err_msg = "Can't saved...something went wrong..!"; }
	 * }
	 * 
	 * else if (opr_mode.equals("update")) { products.setProduct_updated_date(dat);
	 * boolean flag=ehsService.updateProduct(products); if(flag) {
	 * suc_msg="Products details updated Successfully..!"; json.put("status", 1);
	 * }else { json.put("error", 0);
	 * err_msg="Can't update...something went wrong..!"; }
	 * 
	 * 
	 * json.put("success", suc_msg); json.put("error", err_msg);
	 * flasdatat.addFlashAttribute("suc_msg", suc_msg);
	 * flasdatat.addFlashAttribute("err_msg", err_msg);
	 * 
	 * response.getWriter().write(json.toString()); return; }
	 * 
	 * 
	 */
	
	 @RequestMapping(value = "/view_industrial_programs", method =
	 RequestMethod.GET) public String new_law_industrial(Locale locale, Model
	 model, HttpServletRequest request) {

			String id = request.getParameter("industrial_id").trim();
			Ehs_Industrial industrial = new Ehs_Industrial();
			industrial = ehsService.getIndustrialById(id);

			model.addAttribute("industrial", industrial);
			model.addAttribute("opr_mode", "view");
 
	 return "ehs/industrial_program"; 
	 }
	 
	/*
	 * @RequestMapping(value = "/complaint_industrial_programs", method =
	 * RequestMethod.GET) public String new_complaint_industrial(Locale locale,
	 * Model model, HttpServletRequest request) {
	 * 
	 * model.addAttribute("url", request.getRequestURI()); return
	 * "ehs/industrial_hygine_mngt"; }
	 * 
	 * @RequestMapping(value = "/rules_industrial_programs", method =
	 * RequestMethod.GET) public String new_rules_industrial(Locale locale, Model
	 * model, HttpServletRequest request) {
	 * 
	 * model.addAttribute("url", request.getRequestURI()); return
	 * "ehs/industrial_hygine_mngt"; }
	 */
	 @RequestMapping(value = "/mng_hira", method = RequestMethod.GET)
		public String manage_hira(Locale locale, Model model, HttpServletRequest request) {
			
			List<HIRA> hira_list= new ArrayList<HIRA>();
			hira_list = ehsService.getHira_list();
			
			model.addAttribute("hira_list", hira_list);
			model.addAttribute("url", request.getRequestURI());
			return "ehs/hira_list";
		}


		@RequestMapping(value = "/new_hira", method = RequestMethod.GET)
		public String new_hira(Locale locale, Model model, HttpServletRequest request) {

			HIRA hira = new HIRA();
			model.addAttribute("hira",hira);
			model.addAttribute("opr_mode", "save");
			model.addAttribute("url", request.getRequestURI());
			return "ehs/add_hira";
		}
		
		
		@CrossOrigin(origins="http://localhost:4200")
		@RequestMapping(value = "/save_hira", method = RequestMethod.POST)
		public void save_hira(
				@ModelAttribute("data") @Valid HIRA hira, 
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
	    	
	    	  String activity = jsonObj.getString("activity");
	    	  hira.setActivity(activity);
	    	  
	    	  String land = jsonObj.getString("land");
	    	  hira.setLand(land);
	    	  
	    	  String air = jsonObj.getString("air");
	    	  hira.setAir(air);
	    	  
	    	  String water = jsonObj.getString("water");
	    	  hira.setWater(water);
	    	  
	    	  String human = jsonObj.getString("human");
	    	  hira.setHuman(human);
	    	  
	    	  String resource = jsonObj.getString("resource");
	    	  hira.setResource(resource);
	    	  
	    	  String land1 = jsonObj.getString("land1");
	    	  int land11= Integer.parseInt(land1);	
	    	  hira.setLand1(land11);
	    	  
	    	  String air1 = jsonObj.getString("air1");
	    	 int air2= Integer.parseInt(air1);	
	    	  hira.setAir1(air2);
	    	  
	    	  String water1 = jsonObj.getString("water1");
	    	  int water11= Integer.parseInt(water1);	
	    	  hira.setWater1(water11);
	    	  
	    	  String human1 = jsonObj.getString("human1");
	    	  int human11= Integer.parseInt(human1);	
	    	  hira.setHuman1(human11);
	    	  
	    	  String resource1 = jsonObj.getString("resource1");
	    	  int resource11= Integer.parseInt(resource1);	
	    	  hira.setResource1(resource11);
	    	  
	    	  String total_rating = jsonObj.getString("total_rating");
	    	  int total_rating1= Integer.parseInt(total_rating);	
	    	  hira.setTotal_rating(total_rating1);
	    	  
	    	  String legal = jsonObj.getString("legal");
	    	  int legal1= Integer.parseInt(legal);	
	    	  hira.setLegal(legal1);
	    	  
	    	  String frequency = jsonObj.getString("frequency");
	    	  int frequency1= Integer.parseInt(frequency);	
	    	  hira.setFrequency(frequency1);
	    	  
	    	  String impact_rating = jsonObj.getString("impact_rating");
	    	  int impact_rating1= Integer.parseInt(impact_rating);	
	    	  hira.setImpact_rating(impact_rating1);
	    	 
	    	  hira.setHira_active(1);
	    	
	        String suc_msg="";
			String err_msg="";
		
			if (result.hasErrors()) {
				json.put("status", 0);
				json.put("error", helper.getErrors(result));
				response.getWriter().write(json.toString());
				return;
				
		   	}
				boolean flag=ehsService.saveHira(hira);
				if(flag) {
					suc_msg="hira created Successfully..!";
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
		
		
		/*@RequestMapping(value = "/save_hira", method = RequestMethod.POST)
		public void save_hira(
		@ModelAttribute("hira") @Valid HIRA hira, 
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

		String opr_mode=request.getParameter("opr_mode".trim());
		hira.setHira_active(1);
		if (opr_mode.equals("save")) 
		{
		boolean flag=ehsService.saveHira(hira);
		if(flag) {
		suc_msg="Hira details created Successfully..!";
		json.put("status", 1);
		}else {
		json.put("error", 0);
		err_msg="Can't saved...something went wrong..!";
		}
		}
		else if (opr_mode.equals("update"))
		{
		chemicals.setHazardous_updated_date(dat);
		boolean flag=ehsService.updateHazardous(chemicals);
		if(flag) {
		suc_msg="Hazardous details updated Successfully..!";
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
		}*/
		
		@RequestMapping(value = "/export_HIRA", method = RequestMethod.GET)
		public void export_HIRA(
				Model model,
				HttpServletResponse response)
		{
			try {
				File dwnfile=exportHIRA.buildExcelFile();
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
		
		 @RequestMapping(value = "/importhira", method = RequestMethod.POST)
			public void importHira(ModelMap model, HttpServletRequest request, HttpServletResponse response,
					@RequestParam("excel_file") MultipartFile file) throws IOException {

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				json = new JSONObject();

				String suc_msg = "";
				String err_msg = "";
				File excel_file=null;
				if (file != null && !file.isEmpty()) {
					try {
						String img_code = "HIRA_IMP"+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
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
					 importHIRA.uploadHiraFileData(excel_file,helper);
					json.put("status", 1);
					suc_msg = "File imported Successfully..!";
				}else {
					json.put("status", 0);
					err_msg = "Can't import...something went wrong..!";
				}
			
				json.put("success", suc_msg);
				json.put("error", err_msg);
				
			 response.getWriter().write(json.toString());
			 return ;
		}
		 

}
