package com.spcl.erp.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.spcl.erp.dao.LabourDao;
import com.spcl.erp.helper.Helper;
import com.spcl.erp.model.Contractor;
import com.spcl.erp.model.Customer;
import com.spcl.erp.model.Department_type;
import com.spcl.erp.model.HrRequirement;
import com.spcl.erp.model.Labour;
import com.spcl.erp.model.LabourCheck;
import com.spcl.erp.model.ShiftTime;
import com.spcl.erp.model.VMS_Feedback;

public class LabourServiceImpl implements LabourService {
	private LabourDao labourDao;
	
	public LabourDao getLabourDao() {
		return labourDao;
	}

	public void setLabourDao(LabourDao labourDao) {
		this.labourDao = labourDao;
	}

	@Override
	public boolean saveLabour(Labour labour) {
		return labourDao.saveLabour(labour);
	}

	@Override
	public List<Labour> getLabour_list() {
		List<Labour> lab_list=new ArrayList<Labour>();
		lab_list=labourDao.getLabour_list();
		return lab_list;
	}

	@Override
	public boolean updateLabour(Labour labour) {
		
		return labourDao.updateLabour(labour);
	}

	@Override
	public String getLabourByFullName(Labour labour) {
		String lab_name=labour.getLab_title() . concat(" ").concat(labour.getLab_fname()) . concat(" ").concat(labour.getLab_mname()) . concat(" ").concat(labour.getLab_lname());
		return lab_name;
	}

	@Override
	public String getLabourGender(Labour labour) {
		String gender="Not Set";
		switch (labour.getLab_gender()) {
		case 1:
			gender="Male";
			break;
		case 2:
			gender="Female";
			break;
		case 3:
			gender="Transgender";
			break;

		default:
			gender="Not Set";
			break;
		}
		return gender;
	}

	@Override
	public String getLabourMaritalStatus(Labour labour) {
		String staus="Not Set";
		switch (labour.getLab_marital_status()) {
		case 1:
			staus="Single";
			break;
		case 2:
			staus="Married";
			break;
		case 3:
			staus="Divorce";
			break;
		case 4:
			staus="Widowe";
			break;
		case 5:
			staus="Legal Cohabitant";
			break;

		default:
			staus="Not Set";
			break;
		}
		return staus;
	}

	@Override
	public Labour getLabourById(String lab_id) {
		
		return labourDao.getLabourById(lab_id);
	}

	@Override
	public boolean updateContractor(Contractor contract) {
		return labourDao.updateContractor(contract);
	}

	@Override
	public boolean saveContractor(Contractor contract) {
		
		return labourDao.saveContractor(contract);
	}

	@Override
	public List<Contractor> getContractor_list() {
		List<Contractor> cd_list=new ArrayList<Contractor>();
		cd_list=labourDao.getContractor_list();
		return cd_list;
	}

	@Override
	public Contractor getContractorById(String cd_id) {
		
		return labourDao.getContractorById(cd_id);
	}

	@Override
	public String getContractorByFullName(Contractor contract) {
		String cd_name=contract.getCd_title() . concat(" ").concat(contract.getCd_fname()) . concat(" ").concat(contract.getCd_mname()) . concat(" ").concat(contract.getCd_lname());
		return cd_name;
	}

	@Override
	public String getContractorGender(Contractor contract) {
		String gender="Not Set";
		switch (contract.getCd_gender()) {
		case 1:
			gender="Male";
			break;
		case 2:
			gender="Female";
			break;
		case 3:
			gender="Transgender";
			break;

		default:
			gender="Not Set";
			break;
		}
		return gender;
	}

	@Override
	public String getContractorMaritalStatus(Contractor contract) {
		String staus="Not Set";
		switch (contract.getCd_marital_status()) {
		case 1:
			staus="Single";
			break;
		case 2:
			staus="Married";
			break;
		case 3:
			staus="Divorce";
			break;
		case 4:
			staus="Widow";
			break;
		case 5:
			staus="Legal Cohabitant";
			break;

		default:
			staus="Not Set";
			break;
		}
		return staus;
	}

	@Override
	public List<LabourCheck> getCheckIn_list() {
		List<LabourCheck> check_list=new ArrayList<LabourCheck>();
		check_list=labourDao.getCheckIn_list();
		return check_list;
	}

	@Override
	public boolean saveLabourCheck(LabourCheck labourCheck) {
		return labourDao.saveLabourCheck(labourCheck);
	}

	@Override
	public LabourCheck getLabCheckById(String lab_check_id) {
		LabourCheck labourCheck = labourDao.getLabCheckById(lab_check_id);
		return labourCheck;
	}

	@Override
	public boolean updateLabourCheck(LabourCheck labourCheck) {
		return labourDao.updateLabourCheck(labourCheck);
	}

	@Override
	public LabourCheck getSalaryById(String lab_check_id) {
		LabourCheck labourCheck = labourDao.getSalaryById(lab_check_id);
		return labourCheck;
	}

	@Override
	public Integer getTotalHalfDay(Integer labour_lab_id) {
		Integer halfDay=labourDao.getTotalHalfDay(labour_lab_id);
		return halfDay;
	}

	@Override
	public Integer getTotalfullDay(Integer labour_lab_id) {
		Integer fullDay=labourDao.getTotalfullDay(labour_lab_id);
		return fullDay;
	}

	@Override
	public Integer getCheckCountById(Integer labour_lab_id) {
		Integer checkInCount=labourDao.getCheckCountById(labour_lab_id);
		return checkInCount;
	}
	@Override
	public List<LabourCheck> getCheckIn_list(Map<String, String> search) {
		return labourDao.getCheckIn_list(search);
	}
	@Override
	public List<LabourCheck> getCheckInListById(String id) {
		return labourDao.getCheckInListById(id);
	}

	@Override
	public Integer getTodayTotalLabourCheckIN() {
		Integer totalCHeckIn=labourDao.getTodayTotalLabourCheckIN();
		return totalCHeckIn;
	}

	@Override
	public Integer getContractLabourShiftCOunt1(Integer cd_id) {
		Integer shift1Count=labourDao.getContractLabourShiftCOunt1(cd_id);
		return shift1Count;
	}
	@Override
	public Integer getContractLabourShiftCOunt2(Integer cd_id) {
		Integer totalCHeckIn=labourDao.getContractLabourShiftCOunt2(cd_id);
		return totalCHeckIn;
	}
	@Override
	public Integer getContractLabourShiftCOunt3(Integer cd_id) {
		Integer totalCHeckIn=labourDao.getContractLabourShiftCOunt3(cd_id);
		return totalCHeckIn;
	}

	@Override
	public Integer getTotalLabour() {
		Integer totallabour=labourDao.getTotalLabour();
		return totallabour;
	}
	
	@Override
	public Integer getTotalContractor() {
		Integer totalContractor=labourDao.getTotalContractor();
		return totalContractor;
	}

	@Override
	public List<Object> gettotalweeklyCount() {
		return labourDao.gettotalweeklyCount();
	}

	@Override
	public List<LabourCheck> getLabListById(Integer id) {
		return labourDao.getLabListById(id);
		
	}
	@Override
	public List<LabourCheck> getSalaryListById(Integer id) {
		return labourDao.getSalaryListById(id);
	}

	@Override
	public String getLabourByFullName(String Lab_id) {
		Labour labour=labourDao.getLabourById(Lab_id);
		String lab_name=labour.getLab_title() . concat(" ").concat(labour.getLab_fname()) . concat(" ").concat(labour.getLab_mname()) . concat(" ").concat(labour.getLab_lname());
		return lab_name;
	}

	@Override
	public Integer getLabourCheckinShift1COunt() {
		Integer shift1Count=labourDao.getLabourCheckinShift1COunt();
        return shift1Count;
	}

	@Override
	public Integer getLabourCheckinShift2COunt() {
		Integer shift2Count=labourDao.getLabourCheckinShift2COunt();
        return shift2Count;
	}

	@Override
	public Integer getLabourCheckinShift3COunt() {
		Integer shift3Count=labourDao.getLabourCheckinShift3COunt();
        return shift3Count;
	}

	@Override
	public Integer getLabourCheckinDepartment1Count() {
		Integer deparetment1Count=labourDao.getLabourCheckinDepartment1COunt();
        return deparetment1Count;
	}

	@Override
	public Integer getTotalLeaveDay(Integer labour_lab_id) {
		Integer leave=labourDao.getTotalLeaveDay(labour_lab_id);
		return leave;
	}
	
	 @Override
	 public Integer getTotalHrlabourrequirement() {
	 Integer TotalHrlabourrequirement=labourDao.getTotalHrlabourrequirement();
	 return TotalHrlabourrequirement;
	 }

	@Override
	public List<Labour> getLabour_list1() {
		return labourDao.getLabour_list1();
	}

	@Override
	public List<Contractor> getContractor_list1() {
		return labourDao.getContractor_list1();
	}

	@Override
	public List<LabourCheck> getLabourCheck_list1() {
		return labourDao.getLabourCheck_list1();
	}
	
	@Override
	public boolean saveFeedback(VMS_Feedback feedback) {
		return labourDao.saveFeedback(feedback);

	}

	@Override
	public List<VMS_Feedback> getFeedback_list1() {
		return labourDao.getFeedback_list1();
	}

	@Override
	public List<Contractor> getContractor_name() {
		return labourDao.getContractor_name();
	}

	@Override
	public List<Labour> getLabour_name() {
		return labourDao.getLabour_name();
	}

	@Override
	public List<Labour> getById(String id) {
		return labourDao.getById(id);
	}
	
	
	@Override
	public List<Department_type> getDept_name() {
	return labourDao.getDept_name();
	}
	
	 @Override
	 public List<ShiftTime> getShift() {
	 return labourDao.getShift();
	 }

	@Override
	public boolean saveHrRequirement(HrRequirement hrrequirement) {
		return labourDao.saveHrRequirement(hrrequirement);
	}

	@Override
	public List<HrRequirement> getHrRequirement_list() {
		return labourDao.getHrRequirement_list();
	}

	@Override
	public Integer getById1(String id) {
		return labourDao.getById1(id);
	}

	/*@Override
	public Contractor getContractorById(String cd_id) {

	return labourDao.getContractorById(cd_id);
	}*/
	
}
