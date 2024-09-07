package com.javaweb.Convertor;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtil;

@Component
public class BuildingSearchBuilderConvertor {
	public static BuildingSearchBuilder toBuildingSearchBuilder(HashMap<String,Object> building,ArrayList<String> type) {
		BuildingSearchBuilder buidingSearchBuilder = new BuildingSearchBuilder.Builder()
																	.setName(MapUtil.getObject(building, "name", String.class))
																	.setFloorarea(MapUtil.getObject(building, "floorarea", Long.class)) 
																	.setWard(MapUtil.getObject(building, "ward", String.class))
																	.setStreet (MapUtil.getObject(building, "street", String.class))
																	.setDistrictid (MapUtil.getObject(building, "districtid", String.class)) 
																	.setNumberofbasement (MapUtil.getObject (building, "numberofbasement", Integer.class)) 
																	.setTypecode(type)
																	.setManagername (MapUtil.getObject(building, "managername", String.class))
																	.setManagerphonenumber(MapUtil.getObject(building, "managerphonenumber", String.class)) 
																	.setPriceTo(MapUtil.getObject(building, "priceTo", Long.class))
																	.setPriceFrom(MapUtil.getObject(building, "priceFrom", Long.class))
																	.setAreaFrom(MapUtil.getObject(building, "areaFrom", Long.class))
																	.setAreaTo(MapUtil.getObject(building, "areaTo", Long.class))
																	.setStaffid(MapUtil.getObject(building, "staffid", Long.class))
																	.build();
		return buidingSearchBuilder;
	}
}
