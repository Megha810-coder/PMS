package com.spcl.erp.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spcl.erp.model.Warehouse;
import com.spcl.erp.model.Operation;
import com.spcl.erp.services.WarehouseService;



@Controller
@RequestMapping(value = "/warehouse")
public class WarehouseController {
	
	@Autowired
	private WarehouseService warehouseService;
	
	@RequestMapping(value = "/mng_warehouse", method = RequestMethod.GET)
	public String manageWarehouse(Locale locale, Model model) {
		
		List<Warehouse> warehouseList=new ArrayList<Warehouse>();
		warehouseList=warehouseService.getWarehouseList();
		
		model.addAttribute("WAREHOUSELIST", warehouseList);
		model.addAttribute("warehouseService", warehouseService);
		model.addAttribute("resp_page", "warehouse/warehouse_list");
		return "warehouse/warehouse_list";
	}
	
	@RequestMapping(value = "/new_warehouse", method = RequestMethod.GET)
	public String newWarehouse(Locale locale, Model model) {

		Warehouse warehouse=new Warehouse();
		model.addAttribute("warehouse", warehouse);
		model.addAttribute("opr_mode", "save");
		return "warehouse/add_warehouse";
	}


	@RequestMapping(value = "/save_warehouse", method = RequestMethod.POST)
	public String saveWarehouse(@ModelAttribute("warehouse") @Valid Warehouse warehouse, BindingResult result,
		ModelMap model,HttpServletRequest request) throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("error","true");
			return "redirect:/warehouse/mng_warehouse";
	   	}
		String suc_msg="";
		String err_msg="";
		Date dat=new Date(new java.util.Date().getTime());
		warehouse.setWare_active(1);	
		String opr_mode=request.getParameter("opr_mode".trim());
		if (opr_mode.equals("save")) {
			
			warehouse.setWare_create_date(dat);	
			warehouseService.saveWarehouse(warehouse);
			suc_msg="Warehouse created Successfully..!";
		}else if (opr_mode.equals("update")){
			
			warehouse.setWare_update_date(dat);	
			warehouseService.updateWarehouse(warehouse);
			suc_msg="Warehouse Updated Successfully..!";
		}

		model.addAttribute("suc_msg", suc_msg);
		model.addAttribute("err_msg", err_msg);
		return "redirect:/warehouse/mng_warehouse";
	}
	
	
	@RequestMapping(value = "/edit_warehouse", method = RequestMethod.GET)
	public String warehouseById(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("ware_id").trim();
		Warehouse warehouse=new Warehouse();
		warehouse=warehouseService.getWarehouseById(id);
		
		model.addAttribute("warehouse", warehouse);
		model.addAttribute("opr_mode", "update");
		return "warehouse/add_warehouse";
	}
	
	
	
	
	@RequestMapping(value = "/delete_warehouse", method = RequestMethod.GET)
    public void deleteWarehouse(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("ware_id").trim();
		if(warehouseService.deleteWarehouse(id)) {
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
	
	@RequestMapping(value = "/view_warehouse", method = RequestMethod.GET)
	public String view_warehouse(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String id=request.getParameter("ware_id").trim();
		Warehouse warehouse=new Warehouse();
		warehouse=warehouseService.getWarehouseById(id);
		
		
		
		
		
		model.addAttribute("warehouse", warehouse);
		model.addAttribute("opr_mode", "view");
		return "warehouse/add_warehouse";
	}

	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchEvent(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		
		String name=request.getParameter("ware_name").trim() != null ? request.getParameter("ware_name").trim() : "";
		/*String dt=request.getParameter("ev_str_dt").trim() != null ? request.getParameter("ev_str_dt").trim() : "";
		String loc=request.getParameter("ev_loc").trim() != null ? request.getParameter("ev_loc").trim() : "";*/
		
		
		List<Warehouse> warehouseList=new ArrayList<Warehouse>();
		warehouseList=warehouseService.searchWarehouseList(name);
				
		
		model.addAttribute("WAREHOUSELIST", warehouseList);
		model.addAttribute("ware_name", name);
		/*model.addAttribute("EV_STR_DT", dt);
		model.addAttribute("EV_LOC", loc);*/
		
		
		return "admin/event_report";
	}
	
	
	@RequestMapping(value = "/create_operation", method = RequestMethod.GET)
	public String newoperation(Locale locale, Model model) {

		Operation operation=new Operation();
		model.addAttribute("operation", operation);
		model.addAttribute("opr_mode", "save");
		return "operation/add_operation";
	}
	
	@RequestMapping(value = "/save_operation", method = RequestMethod.POST)
	public String saveOperation(@ModelAttribute("operation") @Valid Operation operation, BindingResult result,
		ModelMap model,HttpServletRequest request) throws IOException {
		if (result.hasErrors()) {
			model.addAttribute("error","true");
			return "redirect:/warehouse/create_operation";
	   	}
		String suc_msg="";
		String err_msg="";
		Date dat=new Date(new java.util.Date().getTime());
		operation.setOpt_active(1);	
		String opr_mode=request.getParameter("opr_mode".trim());
		if (opr_mode.equals("save")) {
			
			operation.setOpt_create_date(dat);	
			warehouseService.saveOperation(operation);
			suc_msg="Warehouse created Successfully..!";
		}else if (opr_mode.equals("update")){
			
			operation.setOpt_update_date(dat);	
			warehouseService.updateOperation(operation);
			suc_msg="Warehouse Updated Successfully..!";
		}

		model.addAttribute("suc_msg", suc_msg);
		model.addAttribute("err_msg", err_msg);
		return "redirect:/warehouse/create_operation";
	}
}
