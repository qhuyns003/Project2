package com.javaweb.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customException.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	@GetMapping(value = "/api/building/")
	public Object getBuilding(@RequestParam HashMap<String,Object> building,
								@RequestParam(value="typecode",required = false) ArrayList<String> type) {
		ArrayList<BuildingDTO> result = buildingService.findAll(building,type);
		return result;
	}
	
//	public void validData(BuildingDTO building) {
//		if(building.getName()== null || building.getName().equals("")) {
//			throw new FieldRequiredException("FieldRequiredException");
//		}
//		
//	}



	
	

	
}
