package com.spcl.erp.dao;

import java.util.List;

import com.spcl.erp.model.Scrap;

public interface ScrapDao {

	public boolean saveScrap(Scrap scrap);
	public List<Scrap> getScrapList();
	public Scrap getScrapById(String scrap_id);
	public boolean updateScrap(Scrap scrap);
	public boolean deleteScrap(String scrap_id);
	public List<Scrap> searchScrapList(String scrap_name);
}
