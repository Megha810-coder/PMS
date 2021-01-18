package com.spcl.erp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spcl.erp.dao.ScrapDao;
import com.spcl.erp.model.Scrap;



public class ScrapServiceImpl implements ScrapService {
	
	@Autowired
	private ScrapDao scrapDao;
	
	public void setScrapDao(ScrapDao scrapDao)
	{
		this.scrapDao=scrapDao;
	}

	@Override
	public boolean saveScrap(Scrap scrap) {
		return scrapDao.saveScrap(scrap);
		
	}

	@Override
	public List<Scrap> getScrapList() {
		List<Scrap> scrapList=new ArrayList<Scrap>();
		scrapList=scrapDao.getScrapList();
		return scrapList;
	}

	@Override
	public Scrap getScrapById(String scrap_id) {
		Scrap scrap=new Scrap();
		scrap=scrapDao.getScrapById(scrap_id);
		return scrap;
	}

	@Override
	public boolean updateScrap(Scrap scrap) {
		return scrapDao.updateScrap(scrap);
	}

	@Override
	public boolean deleteScrap(String scrap_id) {
		return scrapDao.deleteScrap(scrap_id);
	}

	@Override
	public List<Scrap> searchScrapList(String scrap_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
