package com.spcl.erp.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.HrRequirementDao;
import com.spcl.erp.model.HrRequirement;

public class HrRequirementServiceImpl implements HrRequirementService {
	@Autowired
	private HrRequirementDao hrrequirementDao;
	public void setHrrequirementDao(HrRequirementDao hrrequirementDao) {
		this.hrrequirementDao = hrrequirementDao;
	}

	@Override
	public boolean saveHr_Requirement(HrRequirement hr_requirement) {
		return hrrequirementDao.saveHr_Requirement(hr_requirement);
	}

	@Override
	public List<HrRequirement> getHr_Requirement() {
		List<HrRequirement> hr_requirement_list=new ArrayList<HrRequirement>();
		hr_requirement_list=hrrequirementDao.getHr_Requirement();
		return hr_requirement_list;
		
	}

	/*@Override
	public boolean updatehrrequirement(HrRequirement hrrequirement) {
	return hrrequirementDao.updatehrrequirement(hrrequirement); 
	}

	*/@Override
	public HrRequirement getHrrequirement_ById(String hr_req_id) {
		HrRequirement hrrequirement=new HrRequirement();
		hrrequirement=hrrequirementDao.getHrrequirement_ById(hr_req_id);
		return hrrequirement;
	}

	@Override
	public boolean deletehrrequirement(String hr_req_id) {
		return hrrequirementDao.deletehrrequirement(hr_req_id);
		}

	
	
	

}
