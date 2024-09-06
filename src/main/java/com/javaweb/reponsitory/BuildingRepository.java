package com.javaweb.reponsitory;

import java.util.ArrayList;
import java.util.HashMap;

import com.javaweb.model.SearchingDTO;
import com.javaweb.reponsitory.entity.BuildingEntity;

public interface BuildingRepository {
	ArrayList<BuildingEntity> findAll(HashMap<String,Object> building,ArrayList<String> type);
}
