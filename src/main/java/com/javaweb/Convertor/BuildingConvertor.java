package com.javaweb.Convertor;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.reponsitory.BuildingRepository;
import com.javaweb.reponsitory.DistrictRepository;
import com.javaweb.reponsitory.RentAreaRepository;
import com.javaweb.reponsitory.entity.BuildingEntity;
import com.javaweb.reponsitory.entity.DistrictEntity;
import com.javaweb.reponsitory.entity.RentAreaEntity;


@Component
public class BuildingConvertor {
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public BuildingDTO buildingConvertor(BuildingEntity item){
		BuildingDTO bd = modelMapper.map(item , BuildingDTO.class);
		DistrictEntity district = districtRepository.findById(item.getDistrictid());
		bd.setAddress(item.getStreet()+", "+item.getWard()+", "+district.getName());
		ArrayList<RentAreaEntity> rentarea = rentAreaRepository.findById(item.getId());
		bd.setRentarea(rentarea.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(",")));
		
		return bd;
	}
}
