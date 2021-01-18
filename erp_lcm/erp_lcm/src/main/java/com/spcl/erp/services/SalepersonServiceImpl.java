package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.SalepersonDao;
import com.spcl.erp.model.SalePerson;

public class SalepersonServiceImpl implements SalepersonService {

	@Autowired
	private SalepersonDao salepersonDao;
	
	
	public SalepersonDao getSalepersonDao() {
		return salepersonDao;
	}

	public void setSalepersonDao(SalepersonDao salepersonDao) {
		this.salepersonDao = salepersonDao;
	}



	@Override
	public String getSalepersonByFullName(SalePerson saleperson) {
		
		String salep_name=saleperson.getSalep_title() . concat(" ").concat(saleperson.getSalep_fname()) . concat(" ").concat(saleperson.getSalep_mname()) . concat(" ").concat(saleperson.getSalep_lname());
		return salep_name;
		
	}

	@Override
	public boolean saveSaleperson(SalePerson saleperson) {
		return salepersonDao.saveSaleperson(saleperson);
	}

	@Override
	public List<SalePerson> getSalepersonList() {
		List<SalePerson> salep_List=new ArrayList<SalePerson>();
		salep_List=salepersonDao.getSalepersonList();
		return salep_List;
	}

	@Override
	public SalePerson getSalepersonById(String salep_id) {
		SalePerson saleperson=new SalePerson();
		saleperson=salepersonDao.getSalepersonById(salep_id);
		return saleperson;
	}

	@Override
	public boolean updateSaleperson(SalePerson saleperson) {
		return salepersonDao.updateSaleperson(saleperson);
	}

	@Override
	public boolean deleteSaleperson(String salep_id) {
		return salepersonDao.deleteSaleperson(salep_id);
	}

	@Override
	public List<SalePerson> searchSalepersonList(String salep_name) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
