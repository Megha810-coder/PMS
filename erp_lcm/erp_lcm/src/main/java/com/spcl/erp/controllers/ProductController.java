package com.spcl.erp.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Product;
import com.spcl.erp.model.Product_Bill;
import com.spcl.erp.model.Product_Packeging;
import com.spcl.erp.model.Product_Scrap;
import com.spcl.erp.model.Product_Vehicle;
import com.spcl.erp.services.ProductService;


@Controller
@RequestMapping(value="/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private Helper helper;
	

	JSONObject json = new JSONObject();
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_product", method = RequestMethod.GET  )
	public String manageProduct(Locale locale, Model model,	HttpServletRequest request, 
	HttpServletResponse response) throws IOException {
		
	List<Product> product_list=new ArrayList<Product>();
	product_list=productService.getProduct_list();


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
	        model.addAttribute("productService", productService);
	        model.addAttribute("url", request.getRequestURI());
	        return "product/mng_product";
	}
	@RequestMapping(value = "/new_product", method = RequestMethod.GET)
	public String new_product(Locale locale, Model model) {
		
		Product product=new Product();
		
		model.addAttribute("product", product);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "product/add_product";
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
		
	    
		 
 String company_name = jsonObj.getString("company_name");
		 product.setCompany_name(company_name);
	    
			 String row_material = jsonObj.getString("row_material");
			 product.setRow_material(row_material);
			
			  String crude_product = jsonObj.getString("crude_product");
			  product.setCrude_product(crude_product);
			 
		  
			
			  String manufacturing_date = jsonObj.getString("manufacturing_date");
			  product.setManufacturing_date(manufacturing_date);
			  
			  String expiry_date = jsonObj.getString("expiry_date");
			  product.setExpiry_date(expiry_date);
			  
			  
			  String name_of_process = jsonObj.getString("name_of_process");
			  product.setName_of_process(name_of_process);
			  
			  
			  
			  String purification = jsonObj.getString("purification");
			  product.setPurification(purification);
			 
			  String quality = jsonObj.getString("quality");
			  product.setQuality(quality);
			 
		  product.setProduct_active(1);
		
	        String suc_msg="";
		String err_msg="";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}
			boolean flag=productService.saveProduct(product);
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
	}
		@CrossOrigin(origins = "http://localhost:4200")
		@RequestMapping(value = "/update_product", method = RequestMethod.POST)
		public void update_product(@ModelAttribute("data") @Valid Product product, BindingResult result,
				ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes flashdata)
				throws IOException {

			Date dat = new Date(new java.util.Date().getTime());

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



			Integer id =jsonObj.getInt("material_id");
			System.out.print(id);
			product.setMaterial_id(id);

			String crude_product = jsonObj.getString("crude_product");
			product.setCrude_product(crude_product);

//			String cd_title = jsonObj.getString("cd_title");
//			contract.setCd_title(cd_title);


			  String manufacturing_date = jsonObj.getString("manufacturing_date");
			  product.setManufacturing_date(manufacturing_date);
			  
			  String expiry_date = jsonObj.getString("expiry_date");
			  product.setExpiry_date(expiry_date);
			  
			  
			  String name_of_process = jsonObj.getString("name_of_process");
			  product.setName_of_process(name_of_process);
			  
			  
			  
			  String purification = jsonObj.getString("purification");
			  product.setPurification(purification);
			 
			  product.setProduct_active(1);

			
			  

			boolean flag = productService.updateProduct(product);
			
		
	}
		@CrossOrigin(origins = "http://localhost:4200")
				 @RequestMapping(value = "/delete_product", method = RequestMethod.GET)
				    public void delete_product(
				    	 HttpServletRequest request,
				    	 HttpServletResponse response
				    	) {
				String msg="false";
				String id=request.getParameter("material_id".trim());
				productService.deleteProduct(id);

				if(productService.deleteProduct(id)) {
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

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_packeging", method = RequestMethod.GET) public
	String mng_packeging(Locale locale, Model model, HttpServletRequest request,
	HttpServletResponse response) throws IOException { 
		
		List<Product_Packeging> packeging_list=new ArrayList<Product_Packeging>();
		packeging_list=productService.getPackeging_list();
	
	
	PrintWriter out = response.getWriter();
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	Gson json = new Gson(); String
	Json=null; 
	if(packeging_list.size()>0) 
	{ 
		  Json=json.toJson(packeging_list);
	out.print(Json);
	} 
	model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("productService",productService); 
	model.addAttribute("url",
	request.getRequestURI()); 
	return "product/mng_packeging";
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/save_packeging", method = RequestMethod.POST)
	public void save_packeging(
			@ModelAttribute("data") @Valid Product_Packeging packeging, 
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
			
		      String packeging_material = jsonObj.getString("packeging_material");
			  packeging.setPackeging_material(packeging_material);
		  
			  String weight_of_product = jsonObj.getString("weight_of_product");
			  packeging.setWeight_of_product(weight_of_product);
			
			  String sealing = jsonObj.getString("sealing");
			  packeging.setSealing(sealing);
			 
			  String packeging_date = jsonObj.getString("packeging_date");
			  packeging.setPackeging_date(packeging_date);
			  
			  String delivery_date = jsonObj.getString("delivery_date");
			  packeging.setDelivery_date(delivery_date);
			  
			  packeging.setPackeging_active(1);
		
	    String suc_msg="";
		String err_msg="";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}
			boolean flag=productService.savePackeging(packeging);
			if(flag) {
				suc_msg="Packeging created Successfully..!";
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
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/update_packeging", method = RequestMethod.POST)
	public void update_packeging(@ModelAttribute("data") @Valid Product_Packeging packeging, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes flashdata)
			throws IOException {

		Date dat = new Date(new java.util.Date().getTime());

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



		Integer id =jsonObj.getInt("packeging_id");
		System.out.print(id);
		packeging.setPackeging_id(id);

		String packeging_material = jsonObj.getString("packeging_material");
		  packeging.setPackeging_material(packeging_material);
	  
		  String weight_of_product = jsonObj.getString("weight_of_product");
		  packeging.setWeight_of_product(weight_of_product);
		
		  String sealing = jsonObj.getString("sealing");
		  packeging.setSealing(sealing);
		 
		  String packeging_date = jsonObj.getString("packeging_date");
		  packeging.setPackeging_date(packeging_date);
		  
		  String delivery_date = jsonObj.getString("delivery_date");
		  packeging.setDelivery_date(delivery_date);
		  
		  packeging.setPackeging_active(1);

		
		  

		boolean flag = productService.updatePackeging(packeging);
		
	
}
	@CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value = "/delete_packeging", method = RequestMethod.GET)
	    public void delete_packeging(
	    	 HttpServletRequest request,
	    	 HttpServletResponse response
	    	) {
	String msg="false";
	String id=request.getParameter("packeging_id".trim());
	productService.deletePackeging(id);

	if(productService.deletePackeging(id)) {
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
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_vehicle", method = RequestMethod.GET) public
	String mng_vehicle(Locale locale, Model model, HttpServletRequest request,
	HttpServletResponse response) throws IOException { 
		
		List<Product_Vehicle> vehicle_list=new ArrayList<Product_Vehicle>();
		vehicle_list=productService.getVehicle_list();
	
	
	PrintWriter out = response.getWriter();
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	Gson json = new Gson(); String
	Json=null; 
	if(vehicle_list.size()>0) 
	{ 
		  Json=json.toJson(vehicle_list);
	out.print(Json);
	} 
	model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("productService",productService); 
	model.addAttribute("url",
	request.getRequestURI()); 
	return "product/mng_vehicle";
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/save_vehicle", method = RequestMethod.POST)
	public void save_vehicle(
			@ModelAttribute("data") @Valid Product_Vehicle vehicle, 
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
			
		      String vehicle_name = jsonObj.getString("vehicle_name");
		      vehicle.setVehicle_name(vehicle_name);
		  
			  String vehicle_no = jsonObj.getString("vehicle_no");
			  vehicle.setVehicle_no(vehicle_no);
			
			  String supplier_name = jsonObj.getString("supplier_name");
			  vehicle.setSupplier_name(supplier_name);
			  
			  String supplier_no = jsonObj.getString("supplier_no");
			  vehicle.setSupplier_no(supplier_no);
			  
			  String supplier_address = jsonObj.getString("supplier_address");
			  vehicle.setSupplier_address(supplier_address);
			  
			  String driver_name = jsonObj.getString("driver_name");
			  vehicle.setDriver_name(driver_name);
			  
			  String driver_no = jsonObj.getString("driver_no");
			  vehicle.setDriver_no(driver_no);
			  
			  String Delivery_Date = jsonObj.getString("Delivery_Date");
			  vehicle.setDelivery_Date(Delivery_Date);
			 
		  
			  vehicle.setVehicle_active(1);
		
	    String suc_msg="";
		String err_msg="";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}
			boolean flag=productService.saveProductVehicle(vehicle);
			if(flag) {
				suc_msg="Vehicle created Successfully..!";
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
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/update_vehicle", method = RequestMethod.POST)
	public void update_vehicle(@ModelAttribute("data") @Valid Product_Vehicle vehicle, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes flashdata)
			throws IOException {

		Date dat = new Date(new java.util.Date().getTime());

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



		Integer id =jsonObj.getInt("vehicle_id");
		System.out.print(id);
		vehicle.setVehicle_id(id);

		 String vehicle_name = jsonObj.getString("vehicle_name");
	      vehicle.setVehicle_name(vehicle_name);
	  
		  String vehicle_no = jsonObj.getString("vehicle_no");
		  vehicle.setVehicle_no(vehicle_no);
		
		  String supplier_name = jsonObj.getString("supplier_name");
		  vehicle.setSupplier_name(supplier_name);
		  
		  String supplier_no = jsonObj.getString("supplier_no");
		  vehicle.setSupplier_no(supplier_no);
		  
		  String supplier_address = jsonObj.getString("supplier_address");
		  vehicle.setSupplier_address(supplier_address);
		  
		  String driver_name = jsonObj.getString("driver_name");
		  vehicle.setDriver_name(driver_name);
		  
		  String driver_no = jsonObj.getString("driver_no");
		  vehicle.setDriver_no(driver_no);
		  
		  String Delivery_Date = jsonObj.getString("Delivery_Date");
		  vehicle.setDelivery_Date(Delivery_Date);
		 
	  
		  vehicle.setVehicle_active(1);

		
		  

		boolean flag = productService.updateVehicle(vehicle);
		
	
}
	@CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value = "/delete_vehicle", method = RequestMethod.GET)
	    public void delete_vehicle(
	    	 HttpServletRequest request,
	    	 HttpServletResponse response
	    	) {
	String msg="false";
	String id=request.getParameter("vehicle_id".trim());
	productService.deleteVehicle(id);

	if(productService.deleteVehicle(id)) {
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
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_scrap", method = RequestMethod.GET) public
	String mng_scrap(Locale locale, Model model, HttpServletRequest request,
	HttpServletResponse response) throws IOException { 
		
		List<Product_Scrap> scrap_list=new ArrayList<Product_Scrap>();
		scrap_list=productService.getScrap_list();
	
	
	PrintWriter out = response.getWriter();
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	Gson json = new Gson(); String
	Json=null; 
	if(scrap_list.size()>0) 
	{ 
		  Json=json.toJson(scrap_list);
	out.print(Json);
	} 
	model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("productService",productService); 
	model.addAttribute("url",
	request.getRequestURI()); 
	return "product/mng_scrap";
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/save_scrap", method = RequestMethod.POST)
	public void save_scrap(
			@ModelAttribute("data") @Valid Product_Scrap scrap, 
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
			
		      String unused_material = jsonObj.getString("unused_material");
		      scrap.setUnused_material(unused_material);
		  
			  String quatity = jsonObj.getString("quatity");
			  scrap.setQuatity(quatity);
			
			  String stock = jsonObj.getString("stock");
			  scrap.setStock(stock);
			  
			  String reused_date = jsonObj.getString("reused_date");
			  scrap.setReused_date(reused_date);
			  
			  String description = jsonObj.getString("description");
			  scrap.setDescription(description);
			  
			  String material_name = jsonObj.getString("material_name");
			  scrap.setMaterial_name(material_name);
			  
			  String department = jsonObj.getString("department");
			  scrap.setDepartment(department);
			  
			 /* String department = jsonObj.getString("department");
			  scrap.setDepartment(department);*/
			  
			  
				 
				  
				  
				 /* Integer generation_1 = jsonObj.getInt("generation");
				  
				  
				  if(generation_1 == 1) { scrap.setGeneration(generation_1); } else {
				  
					  scrap.setGeneration(generation_1); }
				  
				  
				  Integer collection_1 = jsonObj.getInt("collection_1");
				  
				  if(collection_1 == 1) { scrap.setCollection_1(collection_1); } else {
					  scrap.setCollection_1(collection_1); }
				  
				  Integer storage_1 = jsonObj.getInt("storage_1"); if(storage_1 == 1) {
					  scrap.setStorage_1(storage_1); } else { scrap.setStorage_1(storage_1); }
				  
				  Integer transportation_1 = jsonObj.getInt("transportation_1");
				  if(transportation_1 == 1) { scrap.setTransportation_1(transportation_1); }
				  else { scrap.setTransportation_1(transportation_1); }*/
				 
			  
			  String date_of_deposal = jsonObj.getString("date_of_deposal");
			  scrap.setDate_of_deposal(date_of_deposal);
			  
			  String deposal_method = jsonObj.getString("deposal_method");
			  scrap.setDeposal_method(deposal_method);
			  
			  String vehicle_name = jsonObj.getString("vehicle_name");
			  scrap.setVehicle_name(vehicle_name);
			  
			  String vehicle_no = jsonObj.getString("vehicle_no");
			  scrap.setVehicle_no(vehicle_no);
			  
			  String material_quantity = jsonObj.getString("material_quantity");
			  scrap.setMaterial_quantity(material_quantity);
			  
			  String disposal_name = jsonObj.getString("disposal_name");
			  scrap.setDisposal_name(disposal_name);
			  
			  String date_of_dispatched = jsonObj.getString("date_of_dispatched");
			  scrap.setDate_of_dispatched(date_of_dispatched);
			  
			
			 
			 
		  
			  scrap.setScrap_active(1);
		
	    String suc_msg="";
		String err_msg="";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}
			boolean flag=productService.saveProductScrap(scrap);
			if(flag) {
				suc_msg="Packeging created Successfully..!";
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
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/update_scrap", method = RequestMethod.POST)
	public void update_scrap(@ModelAttribute("data") @Valid Product_Scrap scrap, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes flashdata)
			throws IOException {

		Date dat = new Date(new java.util.Date().getTime());

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



		Integer id =jsonObj.getInt("scrap_id");
		System.out.print(id);
		scrap.setScrap_id(id);

		 String unused_material = jsonObj.getString("unused_material");
	      scrap.setUnused_material(unused_material);
	  
		  String quatity = jsonObj.getString("quatity");
		  scrap.setQuatity(quatity);
		
		  String stock = jsonObj.getString("stock");
		  scrap.setStock(stock);
		  
		  String reused_date = jsonObj.getString("reused_date");
		  scrap.setReused_date(reused_date);
		  
		  String description = jsonObj.getString("description");
		  scrap.setDescription(description);
		  
		  String material_name = jsonObj.getString("material_name");
		  scrap.setMaterial_name(material_name);
		  
		 /* String department = jsonObj.getString("department");
		  scrap.setDepartment(department);*/
		  
		  
			 
			  
			  
			 /* Integer generation_1 = jsonObj.getInt("generation");
			  
			  
			  if(generation_1 == 1) { scrap.setGeneration(generation_1); } else {
			  
				  scrap.setGeneration(generation_1); }
			  
			  
			  Integer collection_1 = jsonObj.getInt("collection_1");
			  
			  if(collection_1 == 1) { scrap.setCollection_1(collection_1); } else {
				  scrap.setCollection_1(collection_1); }
			  
			  Integer storage_1 = jsonObj.getInt("storage_1"); if(storage_1 == 1) {
				  scrap.setStorage_1(storage_1); } else { scrap.setStorage_1(storage_1); }
			  
			  Integer transportation_1 = jsonObj.getInt("transportation_1");
			  if(transportation_1 == 1) { scrap.setTransportation_1(transportation_1); }
			  else { scrap.setTransportation_1(transportation_1); }*/
			 
		  
		  String date_of_deposal = jsonObj.getString("date_of_deposal");
		  scrap.setDate_of_deposal(date_of_deposal);
		  
		  String deposal_method = jsonObj.getString("deposal_method");
		  scrap.setDeposal_method(deposal_method);
		  
		  String vehicle_name = jsonObj.getString("vehicle_name");
		  scrap.setVehicle_name(vehicle_name);
		  
		  String vehicle_no = jsonObj.getString("vehicle_no");
		  scrap.setVehicle_no(vehicle_no);
		  
		  String material_quantity = jsonObj.getString("material_quantity");
		  scrap.setMaterial_quantity(material_quantity);
		  
//		  String disposal_name = jsonObj.getString("disposal_name");
//		  scrap.setDisposal_name(disposal_name);
//		  
		  String date_of_dispatched = jsonObj.getString("date_of_dispatched");
		  scrap.setDate_of_dispatched(date_of_dispatched);
		  
		
		 
		 
	  
		  scrap.setScrap_active(1);

		
		  

		boolean flag = productService.updateScrap(scrap);
		
	
}
	@CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value = "/delete_scrap", method = RequestMethod.GET)
	    public void delete_scrap(
	    	 HttpServletRequest request,
	    	 HttpServletResponse response
	    	) {
	String msg="false";
	String id=request.getParameter("scrap_id".trim());
	productService.deleteScrap(id);

	if(productService.deleteScrap(id)) {
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
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/mng_bill", method = RequestMethod.GET) public
	String mng_bill(Locale locale, Model model, HttpServletRequest request,
	HttpServletResponse response) throws IOException { 
		
		List<Product_Bill> bill_list=new ArrayList<Product_Bill>();
		bill_list=productService.getBill_list();
	
	
	PrintWriter out = response.getWriter();
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	Gson json = new Gson(); String
	Json=null; 
	if(bill_list.size()>0) 
	{ 
		  Json=json.toJson(bill_list);
	out.print(Json);
	} 
	model.addAttribute("Json", Json);
	model.addAttribute("helper", helper);
	model.addAttribute("productService",productService); 
	model.addAttribute("url",
	request.getRequestURI()); 
	return "product/mng_bill";
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value = "/save_bill", method = RequestMethod.POST)
	public void save_bill(
			@ModelAttribute("data") @Valid Product_Bill bill, 
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
			
		      String name_purchaser = jsonObj.getString("name_purchaser");
		      bill.setName_purchaser(name_purchaser);
		  
			  String purchaser_no = jsonObj.getString("purchaser_no");
			  bill.setPurchaser_no(purchaser_no);
			
			  String purchaser_address = jsonObj.getString("purchaser_address");
			  bill.setPurchaser_address(purchaser_address);
			  
			  String supplier_name = jsonObj.getString("supplier_name");
			  bill.setSupplier_name(supplier_name);
			  
			  String supplier_no = jsonObj.getString("supplier_no");
			  bill.setSupplier_no(supplier_no);
			  
			  String supplier_address = jsonObj.getString("supplier_address");
			  bill.setSupplier_address(supplier_address);
			  
			  String date = jsonObj.getString("date");
			  bill.setDate(date);
			 
			 
		  
			  bill.setBill_active(1);
		
	    String suc_msg="";
		String err_msg="";

		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
			response.getWriter().write(json.toString());
			return;
			
	   	}
			boolean flag=productService.saveProductBill(bill);
			if(flag) {
				suc_msg="Packeging created Successfully..!";
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
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/update_bill", method = RequestMethod.POST)
	public void update_bill(@ModelAttribute("data") @Valid  Product_Bill bill, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes flashdata)
			throws IOException {

		Date dat = new Date(new java.util.Date().getTime());

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



		Integer id =jsonObj.getInt("bill_id");
		System.out.print(id);
		bill.setBill_id(id);

		String name_purchaser = jsonObj.getString("name_purchaser");
	      bill.setName_purchaser(name_purchaser);
	  
		  String purchaser_no = jsonObj.getString("purchaser_no");
		  bill.setPurchaser_no(purchaser_no);
		
		  String purchaser_address = jsonObj.getString("purchaser_address");
		  bill.setPurchaser_address(purchaser_address);
		  
		  String supplier_name = jsonObj.getString("supplier_name");
		  bill.setSupplier_name(supplier_name);
		  
		  String supplier_no = jsonObj.getString("supplier_no");
		  bill.setSupplier_no(supplier_no);
		  
		  String supplier_address = jsonObj.getString("supplier_address");
		  bill.setSupplier_address(supplier_address);
		  
		  String date = jsonObj.getString("date");
		  bill.setDate(date);
		 
		 
	  
		  bill.setBill_active(1);

		
		  

		boolean flag = productService.updateBill(bill);
		
	
}
	@CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value = "/delete_bill", method = RequestMethod.GET)
	    public void delete_bill(
	    	 HttpServletRequest request,
	    	 HttpServletResponse response
	    	) {
	String msg="false";
	String id=request.getParameter("bill_id".trim());
	productService.deleteBill(id);

	if(productService.deleteBill(id)) {
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
