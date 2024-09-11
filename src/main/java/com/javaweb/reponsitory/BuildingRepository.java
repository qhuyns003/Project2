package com.javaweb.reponsitory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.reponsitory.custom.BuildingRepositoryCustom;
import com.javaweb.reponsitory.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity,Long>, BuildingRepositoryCustom {
	// khai bao cac ham cua spring data jpa tai day
	List<BuildingEntity> findByNameContaining(String name);
}
