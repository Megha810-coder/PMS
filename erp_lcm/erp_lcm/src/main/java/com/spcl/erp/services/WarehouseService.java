package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.model.Warehouse;
import com.spcl.erp.model.Operation;

public interface WarehouseService {

	public void saveWarehouse(Warehouse warehouse);
	public List<Warehouse> getWarehouseList();
	public Warehouse getWarehouseById(String ware_id);
	public void updateWarehouse(Warehouse warehouse);
	public boolean deleteWarehouse(String ware_id);
	public List<Warehouse> searchWarehouseList(String ware_name);
	public void saveOperation(Operation operation);
	public void updateOperation(Operation operation);
	
}
