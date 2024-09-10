package com.javaweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.SearchingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(HashMap<String,Object> building,List<String> type);
}
