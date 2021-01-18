package com.spcl.erp.services;

import java.util.List;


import com.spcl.erp.model.Visitor;

public interface VisitorService {
	
	public boolean saveVisitor(Visitor visitor);
	
	public List<Visitor> getVisitor_list();
	
	

}
