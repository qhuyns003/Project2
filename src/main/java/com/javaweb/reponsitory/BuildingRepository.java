package com.javaweb.reponsitory;

import java.util.ArrayList;

import com.javaweb.model.SearchingDTO;
import com.javaweb.reponsitory.entity.BuildingEntity;

public interface BuildingRepository {
	ArrayList<BuildingEntity> findAll(SearchingDTO building);
}
