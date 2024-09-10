package com.javaweb.reponsitory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.SearchingDTO;
import com.javaweb.reponsitory.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
