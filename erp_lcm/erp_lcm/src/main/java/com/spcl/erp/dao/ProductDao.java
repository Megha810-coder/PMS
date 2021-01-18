package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Product;
import com.spcl.erp.model.Product_Bill;
import com.spcl.erp.model.Product_Packeging;
import com.spcl.erp.model.Product_Scrap;
import com.spcl.erp.model.Product_Vehicle;



public interface ProductDao {

public boolean saveProduct(Product product);
	
	public List<Product> getProduct_list();
	
	public boolean savePackeging(Product_Packeging packeging);
	public List<Product_Packeging> getPackeging_list();
	
	public boolean saveProductVehicle(Product_Vehicle vehicle);

	public List<Product_Vehicle> getVehicle_list();

	public List<Product_Scrap> getScrap_list();

	public List<Product_Bill> getBill_list();

	public boolean saveProductBill(Product_Bill bill);

	public boolean saveProductScrap(Product_Scrap scrap);

	public boolean updateProduct(Product product);

	public boolean updatePackeging(Product_Packeging packeging);

	public boolean updateVehicle(Product_Vehicle vehicle);

	public boolean updateScrap(Product_Scrap scrap);

	public boolean updateBill(Product_Bill bill);

	public boolean deleteProduct(String id);

	public boolean deletePackeging(String id);

	public boolean deleteVehicle(String id);

	public boolean deleteScrap(String id);

	public boolean deleteBill(String id);
}
