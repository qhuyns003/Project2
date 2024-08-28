package com.javaweb.service;

import java.util.ArrayList;

import com.javaweb.model.BuildingDTO;

public interface BuildingService {
	ArrayList<BuildingDTO> findAll(String name);
}
