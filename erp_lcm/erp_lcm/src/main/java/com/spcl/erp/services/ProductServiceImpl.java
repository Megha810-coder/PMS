package com.spcl.erp.services;

import java.util.List;

import com.spcl.erp.dao.ProductDao;

import com.spcl.erp.model.Product;
import com.spcl.erp.model.Product_Bill;
import com.spcl.erp.model.Product_Packeging;
import com.spcl.erp.model.Product_Scrap;
import com.spcl.erp.model.Product_Vehicle;

public class ProductServiceImpl implements ProductService{

private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao){
		this.productDao=productDao;
	}
	@Override
	public boolean saveProduct(Product product) {
		return productDao.saveProduct(product);
	}

	@Override
	public List<Product> getProduct_list() {
		return productDao.getProduct_list();
	}
	@Override
	public boolean savePackeging(Product_Packeging packeging) {
		return productDao.savePackeging(packeging);
	}

	@Override
	public List<Product_Packeging> getPackeging_list() {
		return productDao.getPackeging_list();
	}
	@Override
	public boolean saveProductVehicle(Product_Vehicle vehicle) {
		return productDao.saveProductVehicle(vehicle);
	}
	@Override
	public List<Product_Vehicle> getVehicle_list() {
		return productDao.getVehicle_list();
	}
	@Override
	public List<Product_Scrap> getScrap_list() {
		return productDao.getScrap_list();
	}
	@Override
	public List<Product_Bill> getBill_list() {
		return productDao.getBill_list();
	}
	@Override
	public boolean saveProductBill(Product_Bill bill) {
		return productDao.saveProductBill(bill);
	}
	@Override
	public boolean saveProductScrap(Product_Scrap scrap) {
		return productDao.saveProductScrap(scrap);
	}
	@Override
	public boolean updateProduct(Product product) {
	
			return productDao.updateProduct(product);
		}
	@Override
	public boolean updatePackeging(Product_Packeging packeging) {
		return productDao.updatePackeging(packeging);
	}
	@Override
	public boolean updateVehicle(Product_Vehicle vehicle) {
		return productDao.updateVehicle(vehicle);
	}
	@Override
	public boolean updateScrap(Product_Scrap scrap) {
		return productDao.updateScrap(scrap);
	}
	@Override
	public boolean updateBill(Product_Bill bill) {
		return productDao.updateBill(bill);
	}
	@Override
	public boolean deleteProduct(String id) {
		return productDao.deleteProduct(id);
	}
	@Override
	public boolean deletePackeging(String id) {
		return productDao.deletePackeging(id);
	}
	@Override
	public boolean deleteVehicle(String id) {
		return productDao.deleteVehicle(id);
	}
	@Override
	public boolean deleteScrap(String id) {
		return productDao.deleteScrap(id);
	}
	@Override
	public boolean deleteBill(String id) {
		return productDao.deleteBill(id);
	}
	

}
