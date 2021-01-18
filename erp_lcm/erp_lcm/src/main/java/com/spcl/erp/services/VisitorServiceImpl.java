package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.dao.VisitorDao;

import com.spcl.erp.model.Visitor;

public class VisitorServiceImpl implements VisitorService{
	
	private VisitorDao visitorDao;
	
	public void setVisitorDao(VisitorDao visitorDao){
		this.visitorDao=visitorDao;
	}
	
	@Override
	public boolean saveVisitor(Visitor visitor) {
		return visitorDao.saveVisitor(visitor);
	}

	@Override
	public List<Visitor> getVisitor_list() {
		return visitorDao.getVisitor_list();
	}

	

}
