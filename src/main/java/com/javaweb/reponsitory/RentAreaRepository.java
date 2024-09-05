package com.javaweb.reponsitory;

import java.util.ArrayList;

import com.javaweb.reponsitory.entity.RentAreaEntity;

public interface RentAreaRepository {
	ArrayList<RentAreaEntity> findById(Long id);
}
