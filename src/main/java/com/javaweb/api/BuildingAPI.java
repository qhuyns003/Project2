package com.javaweb.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customException.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingAddDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.reponsitory.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private BuildingService buildingService;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping(value = "/api/building/")
	public Object getBuilding(@RequestParam HashMap<String,Object> building,
								@RequestParam(value="typecode",required = false) List<String> type) {
		List<BuildingDTO> result = buildingService.findAll(building,type);
		return result;
	}
	
	@GetMapping(value = "/api/building/{name}")
	public Object getBuilding(@PathVariable String name) {
		List<BuildingDTO> result = buildingService.findByName(name);
		return result;
	}
	
	@PostMapping(value = "/api/building/")
	@Transactional
	public void createBuilding(@RequestBody BuildingAddDTO buildingAddDTO) {
		buildingService.addBuilding(buildingAddDTO);
	}
	
	
	
//	public void validData(BuildingDTO building) {
//		if(building.getName()== null || building.getName().equals("")) {
//			throw new FieldRequiredException("FieldRequiredException");
//		}
//		
//	}



	
	

	
}
