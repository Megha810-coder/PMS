package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.model.HrRequirement;
public interface HrRequirementService {
	public boolean saveHr_Requirement(HrRequirement hrrequirement);
	public List<HrRequirement>getHr_Requirement();

	/* public boolean updatehrrequirement(HrRequirement hrrequirement); */
	public HrRequirement getHrrequirement_ById(String hr_req_id);
	public boolean deletehrrequirement(String id);

}
