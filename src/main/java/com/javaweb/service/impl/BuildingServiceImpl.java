package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.Convertor.BuildingConvertor;
import com.javaweb.Convertor.BuildingSearchBuilderConvertor;
import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.BuildingAddDTO;
import com.javaweb.model.BuildingDTO;
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
	@Autowired
	private BuildingConvertor buildingConvertor;
	@Autowired
	private BuildingSearchBuilderConvertor buildingSearchBuilderConvertor;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private DistrictRepository districtRepository;
	@Override
	public List<BuildingDTO> findAll(HashMap<String,Object> building,List<String> type) {
		BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConvertor.toBuildingSearchBuilder(building, type);
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder);
		List<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO bd = buildingConvertor.buildingConvertor(item);
			result.add(bd);
		}
		return result;
	}
	@Override
	public List<BuildingDTO> findByName(String name) {
		List<BuildingEntity> buildingEntities = buildingRepository.findByNameContaining(name);
		List<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO bd = buildingConvertor.buildingConvertor(item);
			result.add(bd);
		}
		return result;
	}
	@Override
	@Transactional
	public void addBuilding(BuildingAddDTO buildingAddDTO) {
		BuildingEntity buildingEntity = modelMapper.map(buildingAddDTO, BuildingEntity.class);
		DistrictEntity districtEntity = districtRepository.findById(buildingAddDTO.getDistrictid()).get();
		buildingEntity.setDistrict(districtEntity);
		// lam ham convertor
		buildingRepository.save(buildingEntity);
	};
	

}
