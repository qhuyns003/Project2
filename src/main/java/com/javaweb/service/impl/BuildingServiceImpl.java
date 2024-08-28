package com.javaweb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.reponsitory.BuildingRepository;
import com.javaweb.reponsitory.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public ArrayList<BuildingDTO> findAll(String name) {
		ArrayList<BuildingEntity> buildingEntities = buildingRepository.findAll(name);
		ArrayList<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setNumberOfBasement(item.getNumberOfBasement());
			building.setAddress(item.getStreet()+" "+item.getWard());
			result.add(building);
		}
		return result;
	}

}
