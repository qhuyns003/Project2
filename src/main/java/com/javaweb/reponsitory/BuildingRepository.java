package com.javaweb.reponsitory;

import java.util.ArrayList;
import java.util.HashMap;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.reponsitory.entity.BuildingEntity;

public interface BuildingRepository {
	ArrayList<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);
}
