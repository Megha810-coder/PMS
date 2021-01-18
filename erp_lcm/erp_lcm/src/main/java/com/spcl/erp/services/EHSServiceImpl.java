package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.EHSDao;
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
import com.spcl.erp.model.RequestQuotation;
import com.spcl.erp.model.Hazardous_Chemicals;
import com.spcl.erp.model.Osha_Law;

public class EHSServiceImpl implements EHSService {
	
	@Autowired
	private EHSDao ehsDao;

	public void setEhsDao(EHSDao ehsDao) {
		this.ehsDao = ehsDao;
	}

	@Override
	public boolean saveIncident(Ehs_Action action) {
		return ehsDao.saveIncident(action);
	}
	@Override
	public List<Ehs_Action> getIncident_list(Map<String, String> search_field) {
		return ehsDao.getIncident_list(search_field);
	}
	
	@Override
	public boolean updateIncident(Ehs_Action action) {
		return ehsDao.updateIncident(action);
	}

	@Override
	public Ehs_Action getIncidentById(String action_id) {
		return ehsDao.getIncidentById(action_id);
	}
/*
	@Override
	public StringBuilder getAllButton(Ehs_Action action, String contextPath) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public StringBuilder getAllButton(Ehs_Action action, String contextPath) {
		StringBuilder btnstring=new StringBuilder();
		btnstring.append("<button href='javscript:void(0);' rel='"+contextPath+"/ehs/view_ehs?action_id="+action.getAction_id()+"' class='btn-sm btn-info btn-icon view_item' data-toggle='tooltip' data-placement='top' title='View' ><i class='icofont icofont-eye-alt'></i></button>"+
     	"<button href='jacvscript:void(0);' rel="+contextPath+"/ehs/edit_ehs?action_id="+action.getAction_id()+" class='btn-sm btn-warning btn-icon edit_item' data-toggle='tooltip' data-placement='top' title='Edit'><i class='icofont icofont-edit'></i></button>"

				);
		return btnstring;
		}
		


	@Override
	public Ehs_Action getActionById(String action_id) {
		Ehs_Action action=new Ehs_Action();
		action=ehsDao.getActionById(action_id);
		return action;
	}

	@Override
	public Ehs_witnesed getWitnesedById(String action_id) {
		Ehs_witnesed witnesed=new Ehs_witnesed();
		witnesed=ehsDao.getWitnesedById(action_id);
		return witnesed;
	}

	@Override
	public Ehs_Incident getIncidentByActionId(String action_id) {
		  Ehs_Incident incident=new Ehs_Incident();
		  incident=ehsDao.getIncidentByActionId(action_id);
		 return incident;
	}
	@Override
	public boolean saveHazardous(Hazardous_Chemicals chemicals) {
		return ehsDao.saveHazardous(chemicals);
	}

	@Override
	public List<Hazardous_Chemicals> getHazardous_list(Map<String, String> search_field) {
		return ehsDao.getHazardous_list(search_field);
	}

	@Override
	public boolean updateHazardous(Hazardous_Chemicals chemicals) {
		return ehsDao.updateHazardous(chemicals);
	}

	@Override
	public Hazardous_Chemicals getHazardousById(String hazard_id) {
		return ehsDao.getHazardousById(hazard_id);
	}

	@Override
	public boolean saveProduct(Ehs_Product products) {
	return ehsDao.saveProduct(products);
	}
	
	@Override
	public boolean updateProduct(Ehs_Product products) {
		return ehsDao.updateProduct(products);

	}

	@Override
	public List<Ehs_Product> getProductList() {
		return ehsDao.getProductList();
	}

	@Override
	public Ehs_Product getProductById(String id) {
		return ehsDao.getProductById(id);
	}

	@Override
	public boolean saveWaste(Ehs_Waste waste) {
		return ehsDao.saveWaste(waste);

	}

	@Override
	public boolean updateWaste(Ehs_Waste waste) {
		return ehsDao.updateWaste(waste);

	}

	@Override
	public List<Ehs_Waste> getWasteList() {
		return ehsDao.getWasteList();

	}

	@Override
	public Ehs_Waste getWasteById(String id) {
		return ehsDao.getWasteById(id);
	}
	
	@Override
	public boolean saveTraining(Ehs_Training training) {
		// TODO Auto-generated method stub
		return ehsDao.saveTraining(training);
	}

	@Override
	public List<Ehs_Training> getTraining_List() {
		return ehsDao.getTraining_List();
	}
	
	

	@Override
	public boolean saveIndustrial(Ehs_Industrial industrial) {
		// TODO Auto-generated method stub
		return ehsDao.saveIndustrial(industrial);
	}

	@Override
	public List<Ehs_Industrial> getIndustrial_List() {
		// TODO Auto-generated method stub
		return ehsDao.getIndustrial_List();
	}

	@Override
	public boolean saveFactory(Ehs_Factory_Act factory) {
		// TODO Auto-generated method stub
		return ehsDao.saveFactory(factory);
	}

	@Override
	public List<Ehs_Factory_Act> getFactory_List() {
		// TODO Auto-generated method stub
		return ehsDao.getFactroy_List();
	}

	@Override
	public Ehs_Factory_Act getFactoryById() {
		// TODO Auto-generated method stub
		return ehsDao.getFactoryById();
	}

	@Override
	public Ehs_Training getTrainingById(String id) {
		return ehsDao.getTrainingById(id);
	}

	@Override
	public Osha_Law getOshaLaw() {
		// TODO Auto-generated method stub
		return ehsDao.getOshaLaw();
	}

	@Override
	public Ehs_Factory_Act getFactoryAct() {
		// TODO Auto-generated method stub
		return ehsDao.getFactoryAct();
	}

	@Override
	public Ehs_Industrial getIndustrialById(String id) {
		return ehsDao.getIndustrialById(id);
	}

	@Override
	public boolean saveHira(HIRA hira) {
		return ehsDao.saveHira(hira);
	}

	@Override
	public List<HIRA> getHira_list() {
		return ehsDao.getHira_list();
	}
	
	@Override
	 public boolean saveHiraFileDataInDB(ArrayList<HIRA> hiraList) {
		return ehsDao.saveHiraFileDataInDB(hiraList);
	}

	@Override
	public List<Ehs_Waste> getWaste_list1() {
		return ehsDao.getWaste_list1();
	}

	@Override
	public List<Hazardous_Chemicals> getHazardous_list1() {
	return ehsDao.getHazardous_list1();
	}

	@Override
	public boolean saveTransport(Ehs_Waste_Transport transport) {
		return ehsDao.saveTransport(transport);

	}

	@Override
	public boolean saveShipping(Ehs_Shipping shipping) {
		return ehsDao.saveShipping(shipping);
	}

	@Override
	public boolean saveChemicals(Hazardous_Chemicals chemicals) {
		return ehsDao.saveChemicals(chemicals);
	}
	
}
