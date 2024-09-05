package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.Convertor.BuildingConvertor;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.SearchingDTO;
import com.javaweb.reponsitory.BuildingRepository;
import com.javaweb.reponsitory.DistrictRepository;
import com.javaweb.reponsitory.RentAreaRepository;
import com.javaweb.reponsitory.entity.BuildingEntity;
import com.javaweb.reponsitory.entity.DistrictEntity;
import com.javaweb.reponsitory.entity.RentAreaEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
//	@Autowired
//	private DistrictRepository districtRepository;
//	@Autowired
//	private RentAreaRepository rentAreaRepository;
	@Autowired
	private BuildingConvertor buildingConvertor;
	@Override
	public ArrayList<BuildingDTO> findAll(HashMap<String,String> building,ArrayList<String> type) {
		ArrayList<BuildingEntity> buildingEntities = buildingRepository.findAll(building,type);
		ArrayList<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO bd = buildingConvertor.buildingConvertor(item);
			result.add(bd);
		}
		return result;
	}
	

}
