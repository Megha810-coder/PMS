package com.spcl.erp.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spcl.erp.helper.Helper;

@Controller
@RequestMapping(value = "/extra")
public class ExtraController {
	
	@Autowired
	private Helper helper;
	JSONObject json =null;
	
	@RequestMapping(value = "/getCitylist", method = RequestMethod.GET)
	public void save_customer(
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam("search") String city_name
		) throws IOException {
		
		Gson gsonBuilder = new GsonBuilder().create();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        json=new JSONObject();
        json.put("results", helper.getCityDropDownJson(city_name));
        
        response.getWriter().write(json.toString());
    
	}
	
	@RequestMapping(value = "/getBanklist", method = RequestMethod.GET)
	public void save_cust(
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam("search") String bank_name
		) throws IOException {
		
		Gson gsonBuilder = new GsonBuilder().create();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        json=new JSONObject();
        json.put("results", helper.getBankDropDownJson(bank_name));
        
        response.getWriter().write(json.toString());
    
	}
	
	
}
