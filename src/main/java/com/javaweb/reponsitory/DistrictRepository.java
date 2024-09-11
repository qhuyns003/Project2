package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.reponsitory.entity.BuildingEntity;
import com.javaweb.reponsitory.entity.DistrictEntity;

public interface DistrictRepository extends JpaRepository<DistrictEntity,Long> {
	
}
