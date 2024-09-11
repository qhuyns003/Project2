package com.javaweb.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.javaweb.model.BuildingDTO;

public interface BuildingService {
	ArrayList<BuildingDTO> findAll(HashMap<String,Object> building,ArrayList<String> type);
}
