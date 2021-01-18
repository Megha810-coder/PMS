package com.spcl.erp.dao;

import java.util.List;


import com.spcl.erp.model.Visitor;

public interface VisitorDao {
	
	public boolean saveVisitor(Visitor visitor);
	
	public List<Visitor> getVisitor_list();
	
	
	
	

}
