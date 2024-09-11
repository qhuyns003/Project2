package com.javaweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.javaweb.model.BuildingAddDTO;
import com.javaweb.model.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(HashMap<String,Object> building,List<String> type);
	List<BuildingDTO> findByName(String name);
	void addBuilding(BuildingAddDTO buildingAddDTO);
}
