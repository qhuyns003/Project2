package com.javaweb.service;

import java.util.ArrayList;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.SearchingDTO;

public interface BuildingService {
	ArrayList<BuildingDTO> findAll(SearchingDTO building);
}
