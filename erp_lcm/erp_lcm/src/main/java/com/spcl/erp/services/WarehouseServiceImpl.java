package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.WarehouseDao;
import com.spcl.erp.model.Operation;
import com.spcl.erp.model.Warehouse;

public class WarehouseServiceImpl implements WarehouseService{

	@Autowired
	private WarehouseDao warehouseDao;
	
	public void setWarehouseDao(WarehouseDao warehouseDao)
	{
		this.warehouseDao=warehouseDao;
	}
	
	
	@Override
	public void saveWarehouse(Warehouse warehouse) {
		warehouseDao.saveWarehouse(warehouse);

	}

	@Override
	public List<Warehouse> getWarehouseList() {
		List<Warehouse> warehouseList=new ArrayList<Warehouse>();
		warehouseList=warehouseDao.getWarehouseList();
		return warehouseList;
	}

	@Override
	public Warehouse getWarehouseById(String ware_id) {
		Warehouse warehouse=new Warehouse();
		warehouse=warehouseDao.getWarehouseById(ware_id);
		return warehouse;
	}

	@Override
	public void updateWarehouse(Warehouse warehouse) {
		warehouseDao.updateWarehouse(warehouse);
		
	}

	@Override
	public boolean deleteWarehouse(String ware_id) {
		return warehouseDao.deleteWarehouse(ware_id);
	}

	@Override
	public List<Warehouse> searchWarehouseList(String ware_name) {
		List<Warehouse> warehouseList=new ArrayList<Warehouse>();
		warehouseList=warehouseDao.searchWarehouseList(ware_name);
		return warehouseList;
	}


	@Override
	public void saveOperation(Operation operation) {
		warehouseDao.saveOperation(operation);

	}


	@Override
	public void updateOperation(Operation operation) {
		// TODO Auto-generated method stub
		
	}

}
