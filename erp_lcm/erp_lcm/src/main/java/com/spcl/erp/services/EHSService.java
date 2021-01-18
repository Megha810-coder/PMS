package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

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
import com.spcl.erp.model.Osha_Law;
import com.spcl.erp.model.RequestQuotation;

public interface EHSService {
	
	public boolean saveIncident(Ehs_Action action);
	public List<Ehs_Action>getIncident_list(Map<String, String> search_field);

	public boolean updateIncident(Ehs_Action action);
	public Ehs_Action getIncidentById(String action_id);
	
	public StringBuilder getAllButton(Ehs_Action action,String contextPath);
	public Ehs_Action getActionById(String id);
	public Ehs_witnesed getWitnesedById(String id);
	
	public Ehs_Incident getIncidentByActionId(String action_id);
	
	public boolean saveHazardous(Hazardous_Chemicals chemicals);
	public List<Hazardous_Chemicals>getHazardous_list(Map<String, String> search_field);
	public boolean updateHazardous(Hazardous_Chemicals chemicals);
	public Hazardous_Chemicals getHazardousById(String hazard_id);
	
	
	public boolean updateWaste(Ehs_Waste waste);
	public boolean saveWaste(Ehs_Waste waste);
	public List<Ehs_Waste> getWasteList();
	public Ehs_Waste getWasteById(String waste_id);
	
	public boolean saveProduct(Ehs_Product products);
	public boolean updateProduct(Ehs_Product products);
	public List<Ehs_Product> getProductList();
	public Ehs_Product getProductById(String id);
	
	public boolean saveTraining(Ehs_Training training);
	public List<Ehs_Training> getTraining_List();
	
	public boolean saveIndustrial(Ehs_Industrial industrial);
	public List<Ehs_Industrial> getIndustrial_List();
	
	public boolean saveFactory(Ehs_Factory_Act factory);
	public List<Ehs_Factory_Act> getFactory_List();
	public Ehs_Factory_Act getFactoryById();
	public Ehs_Training getTrainingById(String id);
	
	
	public Osha_Law getOshaLaw();
	
	public Ehs_Factory_Act getFactoryAct();
	public Ehs_Industrial getIndustrialById(String id);
	
	public boolean saveHira(HIRA hira);
	public List<HIRA>getHira_list();
	 public boolean saveHiraFileDataInDB(ArrayList<HIRA> hiraList);
	 
	public List<Ehs_Waste> getWaste_list1();
	public List<Hazardous_Chemicals> getHazardous_list1();
	public boolean saveTransport(Ehs_Waste_Transport transport);
	public boolean saveShipping(Ehs_Shipping shipping);
	public boolean saveChemicals(Hazardous_Chemicals chemicals);
	
}
