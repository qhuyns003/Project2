package com.javaweb.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.SearchingDTO;

public interface BuildingService {
	ArrayList<BuildingDTO> findAll(HashMap<String,String> building,ArrayList<String> type);
}
