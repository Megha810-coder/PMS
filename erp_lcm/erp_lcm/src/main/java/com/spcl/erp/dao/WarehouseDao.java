package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Operation;
import com.spcl.erp.model.Warehouse;


public interface WarehouseDao {
	public void saveWarehouse(Warehouse warehouse);
	public List<Warehouse> getWarehouseList();
	public Warehouse getWarehouseById(String ware_id);
	public void updateWarehouse(Warehouse warehouse);
	public boolean deleteWarehouse(String ware_id);
	public List<Warehouse> searchWarehouseList(String ware_name);
	public void saveOperation(Operation operation);
	public void updateOperation(Operation operation);
	


}
