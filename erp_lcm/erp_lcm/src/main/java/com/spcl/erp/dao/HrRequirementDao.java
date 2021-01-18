package com.spcl.erp.dao;

import java.util.List;
import com.spcl.erp.model.HrRequirement;

public interface HrRequirementDao {
	public boolean saveHr_Requirement(HrRequirement hr_requirement);
	public List<HrRequirement> getHr_Requirement();
	public boolean updatehrrequirement(HrRequirement hr_requirement);
	public HrRequirement getHrrequirement_ById(String hr_req_id);
	public boolean deletehrrequirement(String hr_req_id);
	

}
