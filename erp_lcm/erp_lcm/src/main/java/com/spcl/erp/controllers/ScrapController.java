package com.spcl.erp.controllers;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Scrap;

import com.spcl.erp.services.ScrapService;

@Controller
@RequestMapping(value = "/scrap")
public class ScrapController {
	
	JSONObject json = new JSONObject(); 
	
	@Autowired
	private ScrapService scrapService;

	@Autowired
	private Helper helper;
	
	@RequestMapping(value = "/mng_scrap", method = RequestMethod.GET)
	public String manageScrap(Locale locale, Model model,HttpServletRequest request) {
		
		List<Scrap> scrapList=new ArrayList<Scrap>();
		scrapList=scrapService.getScrapList();
		
		model.addAttribute("SCRAPLIST", scrapList);
		model.addAttribute("scrapService", scrapService);
		model.addAttribute("resp_page", "scrap/scrap_list");
		model.addAttribute("url", request.getRequestURI());
		return "scrap/scrap_list";
	}
	
	@RequestMapping(value = "/new_scrap", method = RequestMethod.GET)
	public String newScrap(Locale locale, Model model) {

		Scrap scrap=new Scrap();
		model.addAttribute("scrap", scrap);
		model.addAttribute("helper", helper);
		model.addAttribute("opr_mode", "save");
		return "scrap/add_scrap";
	}
	
	@RequestMapping(value = "/save_scrap", method = RequestMethod.POST)
	public void saveScrap(@ModelAttribute("scrap") @Valid Scrap scrap, BindingResult result,
		ModelMap model,HttpServletRequest request,RedirectAttributes flasdatat,
		HttpServletResponse response) throws IOException {
		if (result.hasErrors()) {
			json.put("status", 0);
			json.put("error", helper.getErrors(result));
	   	}else {
		String suc_msg="";
		String err_msg="";
		Date dat=new Date(new java.util.Date().getTime());
		scrap.setScrap_active(1);	
		String opr_mode=request.getParameter("opr_mode".trim());
		if (opr_mode.equals("save")) {
			scrap.setScrap_create_date(dat);	
			boolean flag=scrapService.saveScrap(scrap);
			if(flag) {
				suc_msg="scrap created Successfully..!";
				json.put("status", 1);
			}else {
				json.put("error", 0);
				err_msg="Can't saved...something went wrong..!";
			}
		}else if (opr_mode.equals("update")){
			scrap.setScrap_update_date(dat);	
			scrapService.updateScrap(scrap);
			boolean flag=scrapService.updateScrap(scrap);
			if(flag) {
				suc_msg="scrap Updated Successfully..!";
				json.put("status", 1);
			}else {
				json.put("error", 0);
				err_msg="Can't update...something went wrong..!";
			}
			suc_msg="scrap Updated Successfully..!";
		}
		json.put("success", suc_msg);
		json.put("error", err_msg);
		flasdatat.addFlashAttribute("suc_msg", suc_msg);
		flasdatat.addFlashAttribute("err_msg", err_msg);
	}
		String responseJsonString = json.toString();
		 
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJsonString);
	}
	
	
	@RequestMapping(value = "/edit_scrap", method = RequestMethod.GET)
	public String eventById(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("scrap_id").trim();
		Scrap scrap=new Scrap();
		scrap=scrapService.getScrapById(id);
		model.addAttribute("scrap", scrap);
		model.addAttribute("opr_mode", "update");
		model.addAttribute("helper", helper);
		return "scrap/add_scrap";
	}
	
	@RequestMapping(value = "/delete_scrap", method = RequestMethod.GET)
    public void deleteEvent(HttpServletRequest request,HttpServletResponse response) {
		String msg="false";
		String id=request.getParameter("scrap_id").trim();
		if(scrapService.deleteScrap(id)) {
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
	
	@RequestMapping(value = "/view_scrap", method = RequestMethod.GET)
	public String view_product(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("scrap_id").trim();
		Scrap scrap=new Scrap();
		scrap=scrapService.getScrapById(id);
		model.addAttribute("scrap", scrap);
		model.addAttribute("helper", helper);
		model.addAttribute("scrapService", scrapService);
		model.addAttribute("opr_mode", "view");
		return "scrap/add_scrap";
	}
}
