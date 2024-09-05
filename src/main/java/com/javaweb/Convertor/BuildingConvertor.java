package com.javaweb.Convertor;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
	
	public BuildingDTO buildingConvertor(BuildingEntity item){
		BuildingDTO bd = new BuildingDTO();
		DistrictEntity district = districtRepository.findById(item.getDistrictid());
		bd.setAddress(item.getStreet()+", "+item.getWard()+", "+district.getName());
		bd.setBrokeragefee(item.getBrokeragefee());
		bd.setFloorarea(item.getFloorarea());
		bd.setManagername(item.getManagername());
		bd.setManagerphonenumber(item.getManagerphonenumber());
		bd.setName(item.getName());
		bd.setNumberofbasement(item.getNumberofbasement());
		ArrayList<RentAreaEntity> rentarea = rentAreaRepository.findById(item.getId());
		bd.setRentarea(rentarea.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(",")));
		bd.setRentprice(item.getRentprice());
		bd.setServicefee(item.getServicefee());
		return bd;
	}
}
