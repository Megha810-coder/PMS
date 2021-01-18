package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.SalePerson;


public interface SalepersonDao {

	public boolean saveSaleperson(SalePerson saleperson);
	public List<SalePerson> getSalepersonList();
	public SalePerson getSalepersonById(String salep_id);
	public boolean updateSaleperson(SalePerson saleperson);
	public boolean deleteSaleperson(String salep_id);
	public List<SalePerson> searchSalepersonList(String salep_name);
}
