package com.javaweb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.SearchingDTO;
import com.javaweb.reponsitory.BuildingRepository;
import com.javaweb.reponsitory.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public ArrayList<BuildingDTO> findAll(SearchingDTO building) {
		ArrayList<BuildingEntity> buildingEntities = buildingRepository.findAll(building);
		ArrayList<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO bd =new BuildingDTO();
			bd.setAddress(item.getStreet()+", "+item.getWard()+", "+item.getDistrict());
			bd.setBrokerageFee(item.getBrokerageFee());
			bd.setFloorArea(item.getFloorArea());
			bd.setName(item.getName());
			bd.setNameOfManager(item.getNameOfManager());
			bd.setNumberOfBasement(item.getNumberOfBasement());
			bd.setPhoneOfManager(item.getPhoneOfManager());
			bd.setRentArea(item.getRentArea());
			bd.setRentPrice(item.getRentPrice());
			bd.setServiceFee(item.getServiceFee());
			result.add(bd);
		}
		return result;
	}
	

}
