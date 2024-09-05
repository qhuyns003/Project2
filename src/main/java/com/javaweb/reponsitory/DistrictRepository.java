package com.javaweb.reponsitory;

import com.javaweb.reponsitory.entity.DistrictEntity;

public interface DistrictRepository {
	DistrictEntity findById(Long id);
}
