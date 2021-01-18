package com.spcl.erp.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.spcl.erp.model.Contractor;
import com.spcl.erp.model.Department_type;
import com.spcl.erp.model.Employee;
import com.spcl.erp.model.HrRequirement;
import com.spcl.erp.model.Labour;
import com.spcl.erp.model.LabourCheck;
import com.spcl.erp.model.ShiftTime;
import com.spcl.erp.model.VMS_Feedback;

public interface LabourService {
	public boolean saveLabour(Labour labour);
	public List<Labour>getLabour_list();
	public boolean updateLabour(Labour labour);
	public String getLabourByFullName(Labour labour);
	public String getLabourGender(Labour labour);
	public String getLabourMaritalStatus(Labour labour);
	public Labour getLabourById(String lab_id);
	
	public boolean updateContractor(Contractor contract);
	public boolean saveContractor(Contractor contract);
	public List<Contractor> getContractor_list();
	public Contractor getContractorById(String cd_id);
	public String getContractorByFullName(Contractor contract);
	public String getContractorGender(Contractor contract);
	public String getContractorMaritalStatus(Contractor contract);
	public List<LabourCheck>getCheckIn_list(Map<String, String> search);
	public List<LabourCheck>getCheckIn_list();
	public boolean saveLabourCheck(LabourCheck labourCheck);
	public LabourCheck getLabCheckById(String lab_check_id);
	public boolean updateLabourCheck(LabourCheck labourCheck);
	public LabourCheck getSalaryById(String lab_check_id);
	
	public Integer getTotalLabour();
	public Integer getTotalContractor();
	
	public Integer getTotalHalfDay(Integer lab_id);
	public Integer getTotalfullDay(Integer lab_id);
	
	public Integer getTodayTotalLabourCheckIN();
	
	public Integer getCheckCountById(Integer lab_id);
	public List<LabourCheck> getCheckInListById(String id);
	public Integer getContractLabourShiftCOunt1(Integer cd_id);
	public Integer getContractLabourShiftCOunt2(Integer cd_id);
	public Integer getContractLabourShiftCOunt3(Integer cd_id);
	public List<Object> gettotalweeklyCount();
	
	public String getLabourByFullName(String Lab_id);
	public List<LabourCheck> getLabListById(Integer id);
	public List<LabourCheck> getSalaryListById(Integer id);
	
	public Integer getLabourCheckinShift1COunt();
	
	public Integer getLabourCheckinShift2COunt();
	public Integer getLabourCheckinShift3COunt();
	public Integer getLabourCheckinDepartment1Count();
	
	Integer getTotalLeaveDay(Integer labour_lab_id);
	 public Integer getTotalHrlabourrequirement() ;
	public List<Labour> getLabour_list1();
	public List<Contractor> getContractor_list1();
	public List<LabourCheck> getLabourCheck_list1();
	
	public boolean saveFeedback(VMS_Feedback feedback);
	public List<VMS_Feedback> getFeedback_list1();
	public List<Contractor> getContractor_name();
	public List<Labour> getLabour_name();
	public List<Labour> getById(String id);
	 public List<Department_type> getDept_name();
	public List<ShiftTime> getShift();
	public boolean saveHrRequirement(HrRequirement hrrequirement);
	public List<HrRequirement> getHrRequirement_list();
	//public Contractor getContractorById(String cd_id);
	public Integer getById1(String id);
	}
